package com.database;

import static com.database.Database.SISWA;
import static com.database.Database.SPP;
import com.media.Audio;
import com.media.Waktu;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Achmad Baihaqi
 * @since 2021-03-15
 */
public class Transaksi extends Database{
    
    public Transaksi(){
        this.startConnection();
    }
    
    private final Account acc = new Account();
    
    private final Waktu waktu = new Waktu();
    
    public String addRp(long nominal){
        return String.format("Rp. %,d.00", nominal);
    }
    
    public boolean addDataSpp(int idSpp, int tahun, int nominal){
        String query = "INSERT INTO spp VALUES "+String.format("('%d', '%d', '%d')", idSpp, tahun, nominal);
        return this.addData(query);
    }
    
    public boolean hapusDataSpp(int idSpp){
        int pemakai = this.getJumlahData(SISWA, "WHERE id_spp = " + idSpp);
        if(pemakai > 0){
            Audio.play(Audio.SOUND_WARNING);
            JOptionPane.showMessageDialog(null, "ID SPP ini sedang digunakan oleh "+pemakai+" siswa!\nJika anda menghapusnya maka akan mengakibatkan error pada Aplikasi!", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            return this.deleteData(SPP, "id_spp", Integer.toString(idSpp));
        }
        return false;
    }
    
    public int getTahunSpp(int idSpp){
        return Integer.parseInt(this.getData(SPP, "tahun", "WHERE id_spp = " + idSpp));
    }
    
    public boolean setTahunSpp(int idSpp, int tahun){
        return this.setData(SPP, "tahun", "id_spp", Integer.toString(idSpp), Integer.toString(tahun));
    }
    
    public int getNominalSpp(int idSpp){
        return Integer.parseInt(this.getData(SPP, "nominal", "WHERE id_spp = " + idSpp));
    }
    
    public boolean setNominalSpp(int idSpp, int nominal){
        return this.setData(SPP, "nominal", "id_spp", Integer.toString(idSpp), Integer.toString(nominal));
    }
    
    public String[] getIDs(){
        try{
            int index = 0;
            String query = "SELECT id_spp FROM spp";
            String[] IDs = new String[this.getJumlahData(Database.SPP)];
            res = stat.executeQuery(query);
            while(res.next()){
                IDs[index] = res.getString("id_spp");
                index++;
            }
            return IDs;
        }catch(SQLException ex){
            Audio.play(Audio.SOUND_ERROR);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan : " + ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
    
    public int getPenggunaSpp(int idSpp){
        try{
            String query = "SELECT COUNT(id_spp) AS pengguna FROM siswa WHERE id_spp = " + idSpp,
                   buffer;
            res = stat.executeQuery(query);
            if(res.next()){
                buffer = res.getString("pengguna");
                if(Validation.isNumber(buffer)){
                    return Integer.parseInt(buffer);
                }
            }
        }catch(SQLException ex){
            Audio.play(Audio.SOUND_ERROR);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan : " + ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return 0;
    }
    
    private String getLastID(){
        try{
            String query = "SELECT * FROM pembayaran ORDER BY id_pembayaran DESC LIMIT 0,1";
            res = stat.executeQuery(query);
            if(res.next()){
                return res.getString("id_pembayaran");
            }
        }catch(SQLException ex){
            Audio.play(Audio.SOUND_ERROR);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan : " + ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
    
    public String createID(){
        String nomor = this.getLastID().substring(2);
        if(Validation.isNumber(nomor)){
            return String.format("TR%06d", Integer.parseInt(nomor)+1);
        }
        return null;
    }
    
    public boolean bayarSpp(int idPetugas, int nis, String bulan, int tahun, int nominal){  
        
        if(Validation.isValidPembayaran(bulan, tahun)){
            if(!this.isLunasByBulan(nis, bulan, tahun)){
                int kekurangan = this.kekuranganSppSiswa(nis, bulan, tahun);
                if(nominal >= 0){
                    if(nominal <= kekurangan){
                        String query = "INSERT INTO pembayaran VALUES " + 
                                String.format("('%s', '%d', '%d', '%s', '%d', '%d' , '%s', '%s')", 
                                        createID(), idPetugas, nis, bulan, tahun, nominal, waktu.getDateNow(), acc.getDataAkun(Integer.toString(nis), "id_spp"));
                        return this.addData(query);
                    }else{
                        Audio.play(Audio.SOUND_WARNING);
                        JOptionPane.showMessageDialog(null, "Uang Anda kelebihan!", "Pesan!", JOptionPane.WARNING_MESSAGE);
                        return false;
                    }                    
                }else{
                    Audio.play(Audio.SOUND_WARNING);
                    JOptionPane.showMessageDialog(null, "Uang Anda Harus Lebih Dari Rp. 0.00 Untuk Mebayar SPP!", "Pesan!", JOptionPane.WARNING_MESSAGE);
                    return false;                    
                }
            }else{
                Audio.play(Audio.SOUND_WARNING);
                JOptionPane.showMessageDialog(null, "SPP siswa ini sudah lunas!", "Pesan!", JOptionPane.WARNING_MESSAGE);
                return true;
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Pembayaran Dibatalkan!", "Pesan!", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    public boolean batalkanPembayaran(int nis, String bulan, int tahun){
        try{
            String query = String.format(
                    "DELETE FROM pembayaran WHERE nis = %d AND bln_bayar = '%s' AND thn_bayar = %d", nis, bulan, tahun
            );
            int result = stat.executeUpdate(query);
            if(result > 0){
                return true;
            }else{
                Audio.play(Audio.SOUND_WARNING);
                JOptionPane.showMessageDialog(null, "Gagal Membatalkan Pembayaran!", "Pesan!", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }catch(SQLException ex){
            Audio.play(Audio.SOUND_ERROR);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan : " + ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    public boolean isLunasByBulan(int nis, String bulan, int tahun){
        return this.totalSppDibayarSiswa(nis, bulan, tahun) >= this.getNominalSpp(Integer.parseInt(acc.getDataAkun(Integer.toString(nis), "id_spp")));
    }
    
    public boolean isLunasByTahun(int nis, String tahunPelajaran){
        int tahunAwl = Integer.parseInt(tahunPelajaran.substring(0, tahunPelajaran.indexOf("-"))), 
            tahunAkr = Integer.parseInt(tahunPelajaran.substring(tahunPelajaran.indexOf("-")+1));
        
        return isLunasByBulan(nis, Waktu.JANUARI, tahunAkr) && isLunasByBulan(nis, Waktu.MEI, tahunAkr) && isLunasByBulan(nis, Waktu.SEPTEMBER, tahunAwl) &&
               isLunasByBulan(nis, Waktu.FEBRUARI, tahunAkr) && isLunasByBulan(nis, Waktu.JUNI, tahunAkr) && isLunasByBulan(nis, Waktu.OKTOBER, tahunAwl) &&
               isLunasByBulan(nis, Waktu.MARET, tahunAkr) && isLunasByBulan(nis, Waktu.JULI, tahunAwl) && isLunasByBulan(nis, Waktu.NOVEMBER, tahunAwl) &&
               isLunasByBulan(nis, Waktu.APRIL, tahunAkr) && isLunasByBulan(nis, Waktu.AGUSTUS, tahunAwl) && isLunasByBulan(nis, Waktu.DESEMBER, tahunAwl);
    }
    
    public int totalTransaksi(int idSpp){
        try{
            String query = "SELECT COUNT(id_spp) AS TOTAL "+
                           "FROM pembayaran WHERE id_spp = " + idSpp,
                   buffer;
            res = stat.executeQuery(query);
            if(res.next()){
                buffer = res.getString("TOTAL");
                if(Validation.isNumber(buffer)){
                    return Integer.parseInt(buffer);
                }
            }
        }catch(SQLException ex){
            Audio.play(Audio.SOUND_ERROR);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan : " + ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return 0;
    }
    
    public long totalSppDibayar(){
        try{
             String query = "SELECT SUM(jml_bayar) AS TOTAL \n" +
                            "FROM pembayaran";
             res = stat.executeQuery(query);
             if(res.next()){
                 return res.getLong("TOTAL");
             }
        }catch(SQLException ex){
            Audio.play(Audio.SOUND_ERROR);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan : " + ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return 0;
    }
    
    public long totalSppDibayar(int idSpp){
        try{
             String query = "SELECT SUM(t.jml_bayar) AS TOTAL \n" +
                            "FROM pembayaran AS t \n" +
                            "INNER JOIN spp AS s ON (t.id_spp = s.id_spp)\n" +
                            "WHERE t.id_spp = " + idSpp,
                    buffer;
             res = stat.executeQuery(query);
             if(res.next()){
                 buffer = res.getString("TOTAL");
                 if(Validation.isNumber(buffer)){
                     return Long.parseLong(buffer);
                 }
             }
        }catch(SQLException ex){
            Audio.play(Audio.SOUND_ERROR);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan : " + ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return 0;
    }
    
    public int totalSppDibayarKelas(String idKelas, String bulan, int tahun){
        try{
            String  buffer,
                    query =  "SELECT \n" +
                            "k.nama_kelas AS NAMA_KELAS, \n" +
                            "SUM(t.jml_bayar) AS TOTAL_SPP\n" +
                            "FROM pembayaran AS t \n" +
                            "INNER JOIN siswa AS s ON(s.nis = t.nis)\n" +
                            "INNER JOIN kelas AS k ON(s.id_kelas = k.id_kelas)\n" +
                            String.format("WHERE k.id_kelas = '%s' AND t.thn_bayar = %d AND t.bln_bayar = '%s';", idKelas, tahun, bulan);
            res = stat.executeQuery(query);
            if(res.next()){
                buffer = res.getString("TOTAL_SPP");
                if(Validation.isNumber(buffer)){
                    return Integer.parseInt(buffer);
                }
            }
        }catch(SQLException ex){
            Audio.play(Audio.SOUND_ERROR);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan : " + ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return 0;
    }
    
    public int totalSppDibayarKelas(String idKelas, String tahunPelajaran){
        int tahunAwl = Integer.parseInt(tahunPelajaran.substring(0, tahunPelajaran.indexOf("-"))), 
            tahunAkr = Integer.parseInt(tahunPelajaran.substring(tahunPelajaran.indexOf("-")+1));
        int dibayar = 
                this.totalSppDibayarKelas(idKelas, Waktu.JANUARI, tahunAkr) + this.totalSppDibayarKelas(idKelas, Waktu.FEBRUARI, tahunAkr) + this.totalSppDibayarKelas(idKelas, Waktu.MARET, tahunAkr) + 
                this.totalSppDibayarKelas(idKelas, Waktu.APRIL, tahunAkr) + this.totalSppDibayarKelas(idKelas, Waktu.MEI, tahunAkr) + this.totalSppDibayarKelas(idKelas, Waktu.JUNI, tahunAkr) + 
                this.totalSppDibayarKelas(idKelas, Waktu.JULI, tahunAwl) + this.totalSppDibayarKelas(idKelas, Waktu.AGUSTUS, tahunAwl) + this.totalSppDibayarKelas(idKelas, Waktu.SEPTEMBER, tahunAwl) + 
                this.totalSppDibayarKelas(idKelas, Waktu.OKTOBER, tahunAwl) + this.totalSppDibayarKelas(idKelas, Waktu.NOVEMBER, tahunAwl) + this.totalSppDibayarKelas(idKelas, Waktu.DESEMBER, tahunAwl);
        return dibayar;
    }
    
    public int totalSppDibayarSiswa(int nis, String bulan, int tahun){
        try{
            String query = "SELECT SUM(jml_bayar) AS dibayar FROM pembayaran " + 
                   String.format("WHERE nis = %d AND bln_bayar = '%s' AND thn_bayar = %d", nis, bulan, tahun),
                   buffer;
            res = stat.executeQuery(query);
            if(res.next()){
                buffer = res.getString("dibayar");
                if(Validation.isNumber(buffer)){
                    return Integer.parseInt(buffer);
                }
            }
        }catch(SQLException ex){
            Audio.play(Audio.SOUND_ERROR);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mengambil data dari database\n" + ex.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return 0;
    }
    
    public int totalSppDibayarSiswa(int nis, String tahunPelajaran){
        int tahunAwl = Integer.parseInt(tahunPelajaran.substring(0, tahunPelajaran.indexOf("-"))), 
            tahunAkr = Integer.parseInt(tahunPelajaran.substring(tahunPelajaran.indexOf("-")+1));
        int dibayar = 
                this.totalSppDibayarSiswa(nis, Waktu.JANUARI, tahunAkr) + this.totalSppDibayarSiswa(nis, Waktu.FEBRUARI, tahunAkr) + this.totalSppDibayarSiswa(nis, Waktu.MARET, tahunAkr) + 
                this.totalSppDibayarSiswa(nis, Waktu.APRIL, tahunAkr) + this.totalSppDibayarSiswa(nis, Waktu.MEI, tahunAkr) + this.totalSppDibayarSiswa(nis, Waktu.JUNI, tahunAkr) + 
                this.totalSppDibayarSiswa(nis, Waktu.JULI, tahunAwl) + this.totalSppDibayarSiswa(nis, Waktu.AGUSTUS, tahunAwl) + this.totalSppDibayarSiswa(nis, Waktu.SEPTEMBER, tahunAwl) +
                this.totalSppDibayarSiswa(nis, Waktu.OKTOBER, tahunAwl) + this.totalSppDibayarSiswa(nis, Waktu.NOVEMBER, tahunAwl) + this.totalSppDibayarSiswa(nis, Waktu.DESEMBER, tahunAwl);
        return dibayar;
    }
    
    public int kekuranganSppSiswa(int nis, String bulan, int tahun){
        return this.getNominalSpp(Integer.parseInt(acc.getDataAkun(Integer.toString(nis), "id_spp"))) - this.totalSppDibayarSiswa(nis, bulan, tahun);
    }
    
    public int kekuranganSppSiswa(int nis, String tahunPelajaran){
        int tahunAwl = Integer.parseInt(tahunPelajaran.substring(0, tahunPelajaran.indexOf("-"))), 
            tahunAkr = Integer.parseInt(tahunPelajaran.substring(tahunPelajaran.indexOf("-")+1));
        int kekurangan = 
                this.kekuranganSppSiswa(nis, Waktu.JANUARI, tahunAkr) + this.kekuranganSppSiswa(nis, Waktu.FEBRUARI, tahunAkr) + this.kekuranganSppSiswa(nis, Waktu.MARET, tahunAkr) + 
                this.kekuranganSppSiswa(nis, Waktu.APRIL, tahunAkr) + this.kekuranganSppSiswa(nis, Waktu.MEI, tahunAkr) + this.kekuranganSppSiswa(nis, Waktu.JUNI, tahunAkr) + 
                this.kekuranganSppSiswa(nis, Waktu.JULI, tahunAwl) + this.kekuranganSppSiswa(nis, Waktu.AGUSTUS, tahunAwl) + this.kekuranganSppSiswa(nis, Waktu.SEPTEMBER, tahunAwl) +
                this.kekuranganSppSiswa(nis, Waktu.OKTOBER, tahunAwl) + this.kekuranganSppSiswa(nis, Waktu.NOVEMBER, tahunAwl) + this.kekuranganSppSiswa(nis, Waktu.DESEMBER, tahunAwl);
        return kekurangan;
    }
    
    @Override
    public void closeConnection(){
        try{
            // Mengecek apakah conn kosong atau tidak, jika tidak maka akan diclose
            if(conn != null){
                conn.close();
            }
            // Mengecek apakah stat kosong atau tidak, jika tidak maka akan diclose
            if(stat != null){
                stat.close();
            }
            // Mengecek apakah res koson atau tidak, jika tidak maka akan diclose
            if(res != null){
                res.close();
            }
            acc.closeConnection();
            System.out.println("Berhasil memutus koneksi database");
        }catch(SQLException ex){
            Audio.play(Audio.SOUND_ERROR);
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan!\n\nError message : "+ex.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void main(String[] args) {
        Transaksi tr = new Transaksi();
        System.out.println(tr.bayarSpp(12, 6156, Waktu.APRIL, 2021, 500));
    }
    
}
