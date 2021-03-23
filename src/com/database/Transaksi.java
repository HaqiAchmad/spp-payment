package com.database;

import com.media.Audio;
import com.media.Waktu;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    private static final int ID_SPP_17 = 17, ID_SPP_18 = 18, ID_SPP_19 = 19, ID_SPP_20 = 20;
    
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
    
    public Object[] getID(){
        try{
            ArrayList<String> id = new ArrayList<>();
            String query = "SELECT id_pembayaran FROM pembayaran;";
            res = stat.executeQuery(query);
            while(res.next()){
                id.add(res.getString("id_pembayaran"));
            }
            return id.toArray();
        }catch(SQLException ex){
            Audio.play(Audio.SOUND_ERROR);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan : " + ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
        }
        return null;
    }
    
    public String getLastID(){
        Object[] all_id = this.getID();
        if(all_id.length < 1){
            return "TR000000";
        }else{
            return all_id[all_id.length-1].toString();
        }
    }
    
    public String createID(){
        String nomor = this.getLastID().substring(2);
        if(Validation.isNumber(nomor)){
            return String.format("TR%06d", Integer.parseInt(nomor)+1);
        }
        return null;
    }
    
    public boolean bayarSpp(int idPetugas, int nis, String bulan, int tahun, int nominal){
        if(!this.isLunasByBulan(nis, bulan, tahun)){
            int kekurangan = this.kekuranganSpp(nis, bulan, tahun);
            if(nominal <= kekurangan){
                String query = "INSERT INTO pembayaran VALUES " + 
                        String.format("('%s', '%d', '%d', '%s', '%d', '%d' , '%s', '%s')", 
                                createID(), idPetugas, nis, bulan, tahun, nominal, waktu.getDateNow(), acc.getDataAkun("6156", "id_spp"));
                return this.addData(query);
            }else{
                Audio.play(Audio.SOUND_WARNING);
                JOptionPane.showMessageDialog(null, "Uang Anda kelebihan!", "Pesan!", JOptionPane.WARNING_MESSAGE);
                return false;
            }
        }else{
            Audio.play(Audio.SOUND_WARNING);
            JOptionPane.showMessageDialog(null, "SPP siswa ini sudah lunas!", "Pesan!", JOptionPane.WARNING_MESSAGE);
            return true;
        }
    }
    
    public boolean hapusTransaksi(String idPembayaran){
        return this.deleteData(PEMBAYARAN, "id_pembayaran", idPembayaran);
    }
    
    public int sppDibayar(int nis, String bulan, int tahun){
        try{
            int dibayar = 0;
            String query = "SELECT jml_bayar FROM pembayaran " + String.format("WHERE nis = '%d' AND bln_bayar = '%s' AND thn_bayar = '%d'", nis, bulan, tahun),
                   buffer;
            res = stat.executeQuery(query);
            while(res.next()){
                buffer = res.getString("jml_bayar");
                if(!buffer.equalsIgnoreCase("null") && Validation.isNumber(buffer)){
                    dibayar += Integer.parseInt(buffer);
                }
            }
            return dibayar;
        }catch(SQLException ex){
            Audio.play(Audio.SOUND_ERROR);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat mengambil data dari database\n" + ex.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
        return 0;
    }
    
    public int sppDibayar(int nis, int tahun){
        int dibayar = 
                sppDibayar(nis, Waktu.JANUARI, tahun) + sppDibayar(nis, Waktu.FEBRUARI, tahun) + sppDibayar(nis, Waktu.MARET, tahun) + 
                sppDibayar(nis, Waktu.APRIL, tahun) + sppDibayar(nis, Waktu.MEI, tahun) + sppDibayar(nis, Waktu.JUNI, tahun) + 
                sppDibayar(nis, Waktu.JULI, tahun) + sppDibayar(nis, Waktu.AGUSTUS, tahun) + sppDibayar(nis, Waktu.SEPTEMBER, tahun) +
                sppDibayar(nis, Waktu.OKTOBER, tahun) + sppDibayar(nis, Waktu.NOVEMBER, tahun) + sppDibayar(nis, Waktu.DESEMBER, tahun);
        return dibayar;
    }
    
    public int kekuranganSpp(int nis, String bulan, int tahun){
        return this.getNominalSpp(Integer.parseInt(acc.getDataAkun(Integer.toString(nis), "id_spp"))) - this.sppDibayar(nis, bulan, tahun);
    }
    
    public int kekuranganSpp(int nis, int tahun){
        int kekurangan = 
                kekuranganSpp(nis, Waktu.JANUARI, tahun) + kekuranganSpp(nis, Waktu.FEBRUARI, tahun) + kekuranganSpp(nis, Waktu.MARET, tahun) + 
                kekuranganSpp(nis, Waktu.APRIL, tahun) + kekuranganSpp(nis, Waktu.MEI, tahun) + kekuranganSpp(nis, Waktu.JUNI, tahun) + 
                kekuranganSpp(nis, Waktu.JULI, tahun) + kekuranganSpp(nis, Waktu.AGUSTUS, tahun) + kekuranganSpp(nis, Waktu.SEPTEMBER, tahun) +
                kekuranganSpp(nis, Waktu.OKTOBER, tahun) + kekuranganSpp(nis, Waktu.NOVEMBER, tahun) + kekuranganSpp(nis, Waktu.DESEMBER, tahun);
        return kekurangan;
    }
    
    public boolean isLunasByBulan(int nis, String bulan, int tahun){
        return this.sppDibayar(nis, bulan, tahun) >= this.getNominalSpp(Integer.parseInt(acc.getDataAkun(Integer.toString(nis), "id_spp")));
    }
    
    public boolean isLunasByTahun(int nis, int tahun){
        return isLunasByBulan(nis, Waktu.JANUARI, tahun) && isLunasByBulan(nis, Waktu.MEI, tahun) && isLunasByBulan(nis, Waktu.SEPTEMBER, tahun) &&
               isLunasByBulan(nis, Waktu.FEBRUARI, tahun) && isLunasByBulan(nis, Waktu.JUNI, tahun) && isLunasByBulan(nis, Waktu.OKTOBER, tahun) &&
               isLunasByBulan(nis, Waktu.MARET, tahun) && isLunasByBulan(nis, Waktu.JULI, tahun) && isLunasByBulan(nis, Waktu.NOVEMBER, tahun) &&
               isLunasByBulan(nis, Waktu.APRIL, tahun) && isLunasByBulan(nis, Waktu.AGUSTUS, tahun) && isLunasByBulan(nis, Waktu.DESEMBER, tahun);
    }
    
    public String getIdPetugas(String idPembayaran){
        return this.getData(PEMBAYARAN, "id_petugas", "WHERE id_pembayaran = '"+idPembayaran+"'");
    }
    
    public String getNis(String idPembayaran){
        return this.getData(PEMBAYARAN, "nis", "WHERE id_pembayaran = '"+idPembayaran+"'");
    }
    
    public String getBulanBayar(String idPembayaran){
        return this.getData(PEMBAYARAN, "bln_bayar", "WHERE id_pembayaran = '"+idPembayaran+"'");
    }
    
    public String getTahunBayar(String idPembayaran){
        return this.getData(PEMBAYARAN, "thn_bayar", "WHERE id_pembayaran = '"+idPembayaran+"'");
    }
    
    public int getJumlahBayar(String idPembayaran){
        return Integer.parseInt(this.getData(PEMBAYARAN, "jml_bayar", "WHERE id_pembayaran = '"+idPembayaran+"'"));
    }
    
    public String getTanggalBayar(String idPembayaran){
        return this.getData(PEMBAYARAN, "tgl_bayar", "WHERE id_pembayaran = '"+idPembayaran+"'");
    }
    
    public int getIdSpp(String idPembayaran){
        return Integer.parseInt(this.getData(PEMBAYARAN, "id_spp", "WHERE id_pembayaran = '"+idPembayaran+"'"));
    }
    
    public String addRp(long nominal){
        return String.format("Rp. %,d", nominal);
    }
    
    public long getTotalSppDibayar(){
        long dibayar = 0L;
        Object[] tr = this.getID();
        for(Object o : tr){
            dibayar += this.getJumlahBayar(o.toString());
        }
        return dibayar;
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
        int nis = 6156, tahun = 2021;
        String bulan = Waktu.DESEMBER;
        Transaksi tr = new Transaksi();
        
//        System.out.println(tr.bayarSpp(12, nis, bulan, tahun, 180000));
//        System.out.println(tr.bayarSpp(12, nis, bulan, tahun, 10000));
        
        System.out.println("\nNama Siswa : " + tr.acc.getDataAkun(Integer.toString(nis), "nama_siswa"));
        System.out.println("Nama Petugas : " + tr.acc.getDataAkun("12", "nama_petugas"));
        System.out.println("Bulan-Tahun : " + bulan + " " + tahun);
        System.out.println("Spp Dibayar : " + tr.addRp(tr.sppDibayar(nis, bulan, tahun)));
        System.out.println("Kekurangan  : " + tr.addRp(tr.kekuranganSpp(nis, bulan, tahun)));
        System.out.println("Tanggal Bayar : " + tr.getTanggalBayar(tr.getLastID()));
        System.out.println("Lunas by bulan : " + tr.isLunasByBulan(nis, bulan, tahun));
        System.out.println("Lunas by tahun : " + tr.isLunasByTahun(nis, tahun));
        System.out.println("\n\nTotal Spp Dibayar : " + tr.addRp(tr.getTotalSppDibayar()));
    }
    
}
