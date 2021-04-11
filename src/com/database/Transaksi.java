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
    
    public int getPresentaseLunas(int idSpp){
        int dibayar = (int)this.getTotalSppDibayar(idSpp, "2020", "2021"),
            lunas = (this.getNominalSpp(idSpp) * 12 * this.getJumlahData(SISWA, "WHERE id_spp = '"+idSpp+"' "));
        return dibayar / lunas * 100;
    }
    
    public Object[] getID(String keyword){
        try{
            ArrayList<String> id = new ArrayList<>();
            String query = "SELECT id_pembayaran FROM pembayaran " + keyword;
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
    
    public Object[] getID(){
        return this.getID("");
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
                                createID(), idPetugas, nis, bulan, tahun, nominal, waktu.getDateNow(), acc.getDataAkun(Integer.toString(nis), "id_spp"));
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
    
    public int sppDibayar(int nis, String tahun){
        int tahunAwl = Integer.parseInt(tahun.substring(0, tahun.indexOf("-"))), 
            tahunAkr = Integer.parseInt(tahun.substring(tahun.indexOf("-")+1));
        int dibayar = 
                sppDibayar(nis, Waktu.JANUARI, tahunAkr) + sppDibayar(nis, Waktu.FEBRUARI, tahunAkr) + sppDibayar(nis, Waktu.MARET, tahunAkr) + 
                sppDibayar(nis, Waktu.APRIL, tahunAkr) + sppDibayar(nis, Waktu.MEI, tahunAkr) + sppDibayar(nis, Waktu.JUNI, tahunAkr) + 
                sppDibayar(nis, Waktu.JULI, tahunAwl) + sppDibayar(nis, Waktu.AGUSTUS, tahunAwl) + sppDibayar(nis, Waktu.SEPTEMBER, tahunAwl) +
                sppDibayar(nis, Waktu.OKTOBER, tahunAwl) + sppDibayar(nis, Waktu.NOVEMBER, tahunAwl) + sppDibayar(nis, Waktu.DESEMBER, tahunAwl);
        return dibayar;
    }
    
    public int kekuranganSpp(int nis, String bulan, int tahun){
        return this.getNominalSpp(Integer.parseInt(acc.getDataAkun(Integer.toString(nis), "id_spp"))) - this.sppDibayar(nis, bulan, tahun);
    }
    
    public int kekuranganSpp(int nis, String tahun){
        int tahunAwl = Integer.parseInt(tahun.substring(0, tahun.indexOf("-"))), 
            tahunAkr = Integer.parseInt(tahun.substring(tahun.indexOf("-")+1));
        int kekurangan = 
                kekuranganSpp(nis, Waktu.JANUARI, tahunAkr) + kekuranganSpp(nis, Waktu.FEBRUARI, tahunAkr) + kekuranganSpp(nis, Waktu.MARET, tahunAkr) + 
                kekuranganSpp(nis, Waktu.APRIL, tahunAkr) + kekuranganSpp(nis, Waktu.MEI, tahunAkr) + kekuranganSpp(nis, Waktu.JUNI, tahunAkr) + 
                kekuranganSpp(nis, Waktu.JULI, tahunAwl) + kekuranganSpp(nis, Waktu.AGUSTUS, tahunAwl) + kekuranganSpp(nis, Waktu.SEPTEMBER, tahunAwl) +
                kekuranganSpp(nis, Waktu.OKTOBER, tahunAwl) + kekuranganSpp(nis, Waktu.NOVEMBER, tahunAwl) + kekuranganSpp(nis, Waktu.DESEMBER, tahunAwl);
        return kekurangan;
    }
    
    public boolean isLunasByBulan(int nis, String bulan, int tahun){
        return this.sppDibayar(nis, bulan, tahun) >= this.getNominalSpp(Integer.parseInt(acc.getDataAkun(Integer.toString(nis), "id_spp")));
    }
    
    public boolean isLunasByTahun(int nis, String tahun){
        int tahunAwl = Integer.parseInt(tahun.substring(0, tahun.indexOf("-"))), 
            tahunAkr = Integer.parseInt(tahun.substring(tahun.indexOf("-")+1));
        
        return isLunasByBulan(nis, Waktu.JANUARI, tahunAkr) && isLunasByBulan(nis, Waktu.MEI, tahunAkr) && isLunasByBulan(nis, Waktu.SEPTEMBER, tahunAwl) &&
               isLunasByBulan(nis, Waktu.FEBRUARI, tahunAkr) && isLunasByBulan(nis, Waktu.JUNI, tahunAkr) && isLunasByBulan(nis, Waktu.OKTOBER, tahunAwl) &&
               isLunasByBulan(nis, Waktu.MARET, tahunAkr) && isLunasByBulan(nis, Waktu.JULI, tahunAwl) && isLunasByBulan(nis, Waktu.NOVEMBER, tahunAwl) &&
               isLunasByBulan(nis, Waktu.APRIL, tahunAkr) && isLunasByBulan(nis, Waktu.AGUSTUS, tahunAwl) && isLunasByBulan(nis, Waktu.DESEMBER, tahunAwl);
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
    
    public int getJumlahBayar(int nis, String bulan, int tahun){
        int res = Integer.parseInt(this.getData(PEMBAYARAN, "jml_bayar", "WHERE nis = '"+nis+"' AND bln_bayar = '"+bulan+"' AND thn_bayar = '"+tahun+"'"));
        if(Validation.isNumber(""+res)){
            return res;
        }else{
            return 0;
        }
    }
    
    public String getTanggalBayar(String idPembayaran){
        return this.getData(PEMBAYARAN, "tgl_bayar", "WHERE id_pembayaran = '"+idPembayaran+"'");
    }
    
    public int getIdSpp(String idPembayaran){
        return Integer.parseInt(this.getData(PEMBAYARAN, "id_spp", "WHERE id_pembayaran = '"+idPembayaran+"'"));
    }
    
    public String addRp(long nominal){
        return String.format("Rp. %,d.00", nominal);
    }
    
    public long getTotalSppDibayar(){
        long dibayar = 0L;
        Object[] tr = this.getID();
        for(Object o : tr){
            dibayar += this.getJumlahBayar(o.toString());
        }
        return dibayar;
    }
    
    public long getTotalSppDibayar(int id){
        long dibayar = 0L;
        for(Object o : this.getID("WHERE id_spp = '"+id+"'")){
            dibayar += this.getJumlahBayar(o.toString());
        }
        return dibayar;
    }
    
    public long getTotalSppDibayar(int id, String thnAwal, String thnAkhir){
        long dibayar = 0L;
        for(Object o : this.getID("WHERE id_spp = '"+id+"' AND thn_bayar = '"+thnAwal+"' OR thn_bayar = '"+thnAkhir+"'")){
            dibayar += this.getJumlahBayar(o.toString());
        }
        return dibayar;
    }
    
    public long getTotalSppDibayarKelas(String idKelas){
        long dibayar = 0L;
        for(Object o : this.getID("WHERE id_kelas = '"+idKelas+"'")){
            if(acc.getDataAkun(this.getNis(o.toString()), "id_kelas").equalsIgnoreCase(idKelas)){
                dibayar += this.getJumlahBayar(o.toString());
            }
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
    
    private String[] nis(){
        try{
            int row = 0;
            String[] nis = new String[this.getJumlahData(SISWA)];
            String q = "SELECT * FROM siswa;";
            res = stat.executeQuery(q);
            while(res.next()){
                nis[row] = res.getString("nis");
                row++;
            }
            return nis;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public int randID(){
        java.util.Random rand = new java.util.Random();
        int r = rand.nextInt(20);
        while(true){
            if(r >= 11 && r <= 20){
                return r;
            }else{
                r = rand.nextInt(20);
            }
        }
    }
    
    public static void main(String[] args) {
        int nis = 6156, tahun = 2017, uang = 120000;
        String bulan = Waktu.JANUARI;
        Kelas kls = new Kelas();
        Transaksi tr = new Transaksi();
        
        System.out.println(tr.getLastID());
        
//        for(String o : tr.nis()){
//            if(kls.getLevelKelas(tr.acc.getDataAkun(o, "id_kelas")).equalsIgnoreCase("XIII")){
//                tr.bayarSpp(tr.randID(), Integer.parseInt(o), Waktu.JULI, tahun, uang);
//                tr.bayarSpp(tr.randID(), Integer.parseInt(o), Waktu.AGUSTUS, tahun, uang);
//                tr.bayarSpp(tr.randID(), Integer.parseInt(o), Waktu.SEPTEMBER, tahun, uang);
//                tr.bayarSpp(tr.randID(), Integer.parseInt(o), Waktu.OKTOBER, tahun, uang);
//                tr.bayarSpp(tr.randID(), Integer.parseInt(o), Waktu.NOVEMBER, tahun, uang);
//                tr.bayarSpp(tr.randID(), Integer.parseInt(o), Waktu.DESEMBER, tahun, uang);
//                tr.bayarSpp(tr.randID(), Integer.parseInt(o), Waktu.JANUARI, tahun+1, uang);
//                tr.bayarSpp(tr.randID(), Integer.parseInt(o), Waktu.FEBRUARI, tahun+1, uang);
//                tr.bayarSpp(tr.randID(), Integer.parseInt(o), Waktu.MARET, tahun+1, uang);
//                tr.bayarSpp(tr.randID(), Integer.parseInt(o), Waktu.APRIL, tahun+1, uang);
//                tr.bayarSpp(tr.randID(), Integer.parseInt(o), Waktu.MEI, tahun+1, uang);
//                tr.bayarSpp(tr.randID(), Integer.parseInt(o), Waktu.JUNI, tahun+1, uang);
//            }
//        }
        
    }
    
}
