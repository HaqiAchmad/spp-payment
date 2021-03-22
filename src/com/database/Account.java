package com.database;

import com.media.Audio;
import javax.swing.JOptionPane;

/**
 *
 * @author Achmad Baihaqi
 * @since 2021-03-15
 */
public class Account extends Database{
    
    public static final String DEFAULT_FOTO = "src\\\\resources\\\\image\\\\user-profile\\\\default.png",
                               LEVEL_ADMIN = "admin", LEVEL_PETUGAS = "petugas", LEVEL_SISWA = "siswa";
    
    public Account(){
        this.startConnection();
    }
    
    public boolean isAdmin(String id){
        if(this.isExistData(PETUGAS, "id_petugas", id) || this.isExistData(PETUGAS, "username", id)){
            return this.getData(PETUGAS, "level", "WHERE id_petugas = '" + id + "' OR username = '" + id + "'")
                    .equalsIgnoreCase("admin");
        }
        return false;
    }
    
    public boolean isPetugas(String id){
        if(this.isExistData(PETUGAS, "id_petugas", id) || this.isExistData(PETUGAS, "username", id)){
            return this.getData(PETUGAS, "level", "WHERE id_petugas = '" + id + "' OR username = '" + id + "'")
                    .equalsIgnoreCase("petugas");
        }
        return false;
    }
    
    public boolean isExistAkun(String id){
        if(this.isAdmin(id) || this.isPetugas(id)){
            return this.isExistData(PETUGAS, "id_petugas", id) || this.isExistData(PETUGAS, "username", id);
        }else{
            return this.isExistData(SISWA, "nis", id);
        }
    }
    
    public boolean buatAkunPetugas(int id, String username, String namaPetugas, String gender, String noHP, String email, String password, String level, String foto){
        String queryAkun = "INSERT INTO petugas VALUES ("
                        + id + ", '"+username+"', '"+ namaPetugas+"', '"+gender+"', default, default, default, "
                        + "'" + noHP + "', '" + email + "', '" + password + "', '"+level+"');",
                queryFoto = "INSERT INTO foto_profile VALUES ("
                        + id + ", '"+foto+"');";
        boolean insertAkun = addData(queryAkun), insertFoto = addData(queryFoto);
        return insertAkun == insertFoto;
    }
    
    public boolean buatAkunSiswa(int nis, String namaSiswa, String gender, String idKelas, String noHP, String email, int idSpp, String foto){
        String queryAkun = "INSERT INTO siswa VALUES ("
                        + nis + ", '"+namaSiswa+"', '"+ gender + "', default, default, default, '" +idKelas+ "', "
                        + "'" +noHP+"', '" +email+"', default, " +idSpp+ ")",
               queryFoto = "INSERT INTO foto_profile VALUES ("
                        + nis + ", '"+foto+"');";
        boolean insertAkun = addData(queryAkun), insertFoto = addData(queryFoto);
        return insertAkun == insertFoto;
    }
    
    public boolean loginAsPetugas(String id, String password){
        this.logout();
        String pass;
        if(this.isExistData(PETUGAS, "id_petugas", id) || this.isExistData(PETUGAS, "username", id)){
            pass = this.getDataAkun(id, "password");
            if(password.equals(pass)){
                return setLogin(id);
            }else{
                Audio.play(Audio.SOUND_WARNING);
                JOptionPane.showMessageDialog(null, "Password Anda tidak cocok!", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            Audio.play(Audio.SOUND_WARNING);
            JOptionPane.showMessageDialog(null, "'"+id+"' ID/Username tersebut tidak ditemukan!", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        }
        return false;
    }
    
    public boolean loginAsSiswa(int nis, String password){
        this.logout();
        if(this.isExistData(SISWA, "nis", Integer.toString(nis))){
            if(password.equalsIgnoreCase("root")){
                return setLogin(Integer.toString(nis));
            }else{
                Audio.play(Audio.SOUND_WARNING);
                JOptionPane.showMessageDialog(null, "Password Anda tidak cocok!", "Pesan", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            Audio.play(Audio.SOUND_WARNING);
            JOptionPane.showMessageDialog(null, "'"+nis+"' NIS tersebut tidak ditemukan!", "Pesan", JOptionPane.INFORMATION_MESSAGE);
        }
        return false;
    }
    
    public boolean setLogin(String id){
        return this.addData("INSERT INTO login VALUES ('"+id+"')");
    }
    
    public String getLogin(){
        return this.getData(LOGIN, "id_user");
    }
    
    public boolean logout(){
        return this.addData("TRUNCATE login");
    }
    
    public int getTotalAkun(String tipeAkun){
        switch (tipeAkun) {
            case Account.LEVEL_ADMIN:
                return this.getJumlahData(PETUGAS, "WHERE level = 'admin'");
            case Account.LEVEL_PETUGAS:
                return this.getJumlahData(PETUGAS, "WHERE level = 'petugas'");
            case Account.SISWA:
                return this.getJumlahData(SISWA);
            default: return -1;
        }
    }
    
    public int getTotalAkun(){
        return getTotalAkun(LEVEL_ADMIN) + getTotalAkun(LEVEL_PETUGAS) + getTotalAkun(SISWA);
    }
    
    public String getDataAkun(String id, String data){
        if(this.isAdmin(id) || this.isPetugas(id)){
            return this.getData(PETUGAS, data, "WHERE id_petugas = '" + id +"' OR username = '"+ id +"'");
        }else{
            return this.getData(SISWA, data, "WHERE nis = '" + id+"'");
        }
    }
    
    public String getGenderName(String gender){
        if(gender.equalsIgnoreCase("L")){
            return "Laki-Laki";
        }else if(gender.equalsIgnoreCase("P")){
            return "Perempuan";
        }else{
            return "Tidak Dicantumkan";
        }
    }
    
    public String getKekuatanPassword(String password){
        if(password.length() > 5){
            if(password.length() >= 5 && password.length() < 10 && Validation.containsNumber(password)){
                if(password.length() >= 10 && password.length() < 25 && Validation.containsNumber(password)){
                    if(password.length() >= 25 && Validation.containsNumber(password)){
                        return "Sangat Kuat";
                    }
                }else{
                    return "Kuat";
                }
            }else{
                return "Rendah";
            }
        }else{
            return "Sangat Rendah";
        }
        return "null";
    }
    
    public String getProfile(int id){
        return this.getData(FOTO_PROFILE, "foto", "WHERE id_user = '"+id+"'");
    }
    
    public String getProfile(String username){
        return this.getProfile(Integer.parseInt(this.getDataAkun(username, "id_petugas")));
    }
    
    public boolean setProfile(int id, String newFoto){
        String query;
        if(this.deleteData(FOTO_PROFILE, "id_user", Integer.toString(id))){
            query = "INSERT INTO foto_profile VALUES ("+id+", '"+newFoto+"')";
            return this.addData(query);
        }
        return false;
    }
    
    public boolean setDataAkun(String id, String field, String newData){
        if(this.isAdmin(id) || this.isPetugas(id)){
            if(Validation.isUsername(id)){
                return this.setData(PETUGAS, field, "username", id, newData);
            }else{
                return this.setData(PETUGAS, field, "id_petugas", id, newData);
            }
        }else{
            return this.setData(SISWA, field, "nis", id, newData);
        }
    }
    
    public boolean deleteAkunById(int id){
        if(this.isAdmin(Integer.toString(id)) || this.isPetugas(Integer.toString(id))){
            boolean deletePetugas = this.deleteData(PETUGAS, "id_petugas", Integer.toString(id)),
                    deleteProfile = this.deleteData(FOTO_PROFILE, "id_user", Integer.toString(id));
            return deletePetugas && deleteProfile;
        }else{
            boolean deleteSiswa = this.deleteData(SISWA, "nis", Integer.toString(id)),
                    deleteProfile = this.deleteData(FOTO_PROFILE, "id_user", Integer.toString(id));
            return deleteSiswa && deleteProfile;
        }
    }
    
}
