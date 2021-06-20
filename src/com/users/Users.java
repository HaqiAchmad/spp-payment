package com.users;

import com.data.app.Log;
import com.data.app.Storage;
import com.data.db.Database;
import com.data.db.DatabaseTables;
import com.error.AuthenticationException;
import com.error.InValidUserDataException;
import com.manage.FileManager;
import com.manage.Text;
import com.manage.Validation;
import com.manage.Waktu;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.StringTokenizer;
import java.util.UUID;


/**
 *
 * @author Achmad Baihaqi
 * @since 2021-06-11
 */
public class Users extends Database{
    
    /**
     * Direktori dari file yang digunakan untuk menyimpan data dari akun yang sedang digunakan untuk login.
     */
    private final String LOGIN_DATA_FILE = new Storage().getUsersDirectory() + "login_data.haqi";

    /**
     * Merupakan satu-satunya constructor yang ada didalam class {@code Users}. Saat constructor dipanggil saat pembuatan 
     * object constructor akan secara otomatis memanggil method {@code startConnection()} yang ada didalam class 
     * {@code Database} untuk membuat koneksi ke <b>Database MySQL</b>. Setelah membuat koneksi ke <b>Database MySQL</b>
     * constructor akan mengecek apakah folder user storage dari aplikasi, file login_data.haqi dan user storage dari 
     * user yang sedang login apakah exist atau tidak. 
     * <br><br>
     * Jika ada salah satu dari folder atau file tersebut yang tidak exist maka folder dan file tersebut akan dibuat. 
     * Folder dan File tersebut sangatlah penting karena jika tidak ada folder dan file tersebut akan menyebabkan 
     * force close pada aplikasi.
     * <br><br>
     * Constructor dari class {@code Users} ini juga dapat untuk membuat object dari inner class dari class {@code Users} 
     * yaitu {@code LevelPetugas} dan {@code LevelSiswa}. Anda dapat membuat object dari kedua class tersebut dengan 
     * memanggil method {@code levelPetugas()} untuk membuat object dari class {@code LevelPetugas} dan method 
     * {@code levelSiswa()} untuk membuat object dari class {@code LevelSiswa}.
     */
    public Users(){
        // memulai koneksi ke database
        this.startConnection();
        
        // jika storage tidak ditemukan maka akan dibuat
        if(!new File(new Storage().getUsersDirectory()).exists()){
            new FileManager().createFolders(new Storage().getUsersDirectory());
        }
        
        // jika file login data tidak ditemukan maka file akan dibuat
        if(!new File(this.LOGIN_DATA_FILE).exists()){
            new FileManager().createFile(this.LOGIN_DATA_FILE);
        }
        
        // jika folder user storage dari akun yang sedang login tidak ditemukan maka folder akan dibuat
        if(this.isLogin()){
            if(!this.isExistUserStorage(getCurrentLogin())){
                createUserStorage(getCurrentLogin());
            }
        }
    }
    
    /**
     * Method ini akan mengembalikan object dari inner class {@code LevelPetugas}. Pertama-tama method akan membuat 
     * sebuah object dari class {@code Users} terlebih dahulu. Setelah object dari class {@code Users} berhasil dibuat
     * maka selanjutnya method akan membuat object dari inner class {@code LevelPetgas} dengan keyword {@code new}. 
     * Tujuan dibuatnya method ini adalah agar semua method yang ada didalam class {@code Users} maupun inner class 
     * {@code LevelPetugas} dapat diakses secara bersamaan dalam satu object yang sama.
     * <br><br>
     * Sehingga baris kode pada aplikasi menjadi lebih ringkas karena hanya perlu untuk membuat satu object saja.
     * User dapat menanipulasi atau menadapatkan data yang ada didalam class {@code Users} maupun yang ada 
     * didalam class {@code LevelPetugas}. User juga dapat melakukan Login maupun Logout melalui object dari class
     * {@code LevelPetugas} ini.
     * 
     * @return object dari inner class LevelPetugas. 
     */
    public static LevelPetugas levelPetugas(){
        return new Users().new LevelPetugas();
    }
    
    /**
     * Method ini akan mengembalikan object dari inner class {@code LevelSiswa}. Pertama-tama method akan membuat 
     * sebuah object dari class {@code Users} terlebih dahulu. Setelah object dari class {@code Users} berhasil dibuat
     * maka selanjutnya method akan membuat object dari inner class {@code LevelSiswa} dengan keyword {@code new}. 
     * Tujuan dibuatnya method ini adalah agar semua method yang ada didalam class {@code Users} maupun inner class 
     * {@code LevelSiswa} dapat diakses secara bersamaan.
     * <br><br>
     * Sehingga baris kode pada aplikasi menjadi lebih ringkas karena hanya perlu untuk membuat satu object saja.
     * User dapat menanipulasi atau menadapatkan data yang ada didalam class {@code Users} maupun yang ada 
     * didalam class {@code LevelSiswa}. User juga dapat melakukan Login maupun Logout melalui object dari class
     * {@code LevelSiswa} ini.
     * 
     * @return object dari inner class LevelSiswa. 
     */
    public static LevelSiswa levelSiswa() {
        return new Users().new LevelSiswa();
    }
    
    /**
     * Method ini digunakan untuk menambahkan data dari user yang diinputkan kedalam <b>Database MySQL</b>.
     * Data dari user akan ditambahkan ke dalam <b>Database</b> melalui class {@code PreparedStatement} sehingga 
     * proses menambahkan data kedalam <b>Database</b> lebih aman. Pertama-tama method akan mengecek apakah 
     * semua data dari user valid atau tidak. Jika ada salah satu data dari user yang tidak valid maka data 
     * tidak akan ditambahkan kedalam <b>Database</b> dan method akan mengembalikan nilai <code>false</code>.
     * <br><br>
     * Jika semua data dari user valid maka method akan membuat sebuah object {@code PreparedStatement}. Setelah 
     * object dari class {@code PreparedStatement} berhasil dibuat selanjutnya method akan menambahkan semua data 
     * dari user kedalam object {@code PreparedStatement}. Jika semua data dari user sudah ditambahkan kedalam 
     * object {@code PreparedStatement} maka data dari user tersebut akan ditambahka kedalam <b>Database</b> melalui 
     * method {@code executeUpdate()} yang ada didalam class {@code PreparedStatement}.
     * <br><br>
     * Untuk data foto profile jika foto yang diinputkan <code>null</code> atau foto tersebut tidak exist maka 
     * data dari foto profile akan secara default diset ke <code>NULL</code>. Jika foto profile exist maka foto 
     * profile akan ditambahkan kedalam <b>Database</b> dalam bentuk byte stream / <code>Blob</code>.
     * 
     * @param idUser ID dari user.
     * @param noHp nomor HP dari user.
     * @param email email dari user.
     * @param foto foto dari user.
     * @param password password dari user.
     * @param level level dari user.
     * 
     * @return <strong>True</strong> jika data berhasil ditambahkan. <br>
     *         <strong>False</strong> jika data tidak berhasil ditambahkan. 
     * 
     * @throws FileNotFoundException jika terjadi kegagalan saat menkonversi foto profile kedalam byte stream / Blob.
     * @throws SQLException jika terjadi kegagalan saat menambahkan data kedalam <b>Database</b>.
     * @throws InValidUserDataException jika data dari petugas tidak valid.
     */
    public final boolean addUser(String idUser, String noHp, String email, File foto, String password, UserLevels level) 
            throws FileNotFoundException, SQLException, InValidUserDataException
    {
        PreparedStatement pst;
        Log.addLog("Sedang menyiapkan proses transfer data.");
        // mengecek apakah data yang akan ditambahkan valid atau tidak
//        if(this.validateAddUser(idUser, noHp, email, password)){
            // menambahkan data kedalam Database
            pst = this.conn.prepareStatement("INSERT INTO users VALUES (?, ?, ?, ?, ?, ?)");
            pst.setInt(1, Integer.parseInt(idUser));
            pst.setString(2, noHp);
            pst.setString(3, email);
            pst.setString(5, password);
            pst.setString(6, level.name());
            
            Log.addLog("Memproses data yang akan ditranfer.");
            
            // jika foto yang diinputkan tidak kosong
            if(foto != null){
                // jika foto exist maka foto akan dikonversi kedalam bentuk byte stream
                if(foto.exists()){
                    // mengkonversi file ke byte stream
                    pst.setBlob(4, new FileManager().fileToBlob(foto));
                }else{
                    // jika foto tidak exist maka foto akan diset ke NULL
                    Log.addLog("User tidak memasukan foto profile.");
                    pst.setString(4, null);
                }                
            }else{
                // jika foto kosong maka foto akan diset ke NULL
                Log.addLog("User tidak memasukan foto profile.");
                pst.setString(4, null);
            }
            
            Log.addLog("Data berhasil diproses dan siap ditransfer.");
            
            // mengekusi query
            return pst.executeUpdate() > 0;
            
//        }
//        return false;
    }
    
    /**
     * Method ini digunakan untuk mengecek apakah semua data dari user yang diinputkan valid atau tidak.
     * Method akan mengecek satu persatu data dari user. Jika ada salah satu data saja yang tidak valid maka 
     * semua data dari user yang di inputkan akan dianggap tidak valid dan method akan mengembalikan nilai 
     * <code>False</code>. Method hanya akan mengembalikan nilai <code>True</code> jika semua data dari 
     * user yang diinputkan valid.
     * 
     * @param idUser id user yang akan dicek.
     * @param noHp no hp yang akan dicek.
     * @param email email yang akan dicek.
     * @param password password yang akan dicek.
     * @return <strong>True</strong> jika semua data dari user valid. <br>
     *         <strong>False</strong> jika ada salah satu data dari user yang tidak valid.
     */
    private boolean validateAddUser(String idUser, String noHp, String email, String password){
        
        boolean vIdUser, vNoHp, vEmail, vPassword;
        
        // mengecek apakah id user valid atau tidak
        Log.addLog("Validasi ID User");
        if(!this.isExistUser(idUser)){
            vIdUser = true;
        }else{
            throw new InValidUserDataException("'" + idUser + "' ID User tersebut sudah terpakai.");
        }            
        
        // mengecek apakah nomor hp valid atau tidak
        Log.addLog("Validasi Nomor HP");
        if(!this.isExistNoHp(noHp)){
            vNoHp = true;
        }else{
            throw new InValidUserDataException("'" + noHp + "' Nomor Hp terebut sudah terpakai.");
        }
        
        // mengecek apakah email valid atau tidak
        Log.addLog("Validasi Email");
        if(!this.isExistEmail(email)){
            vEmail = true;
        }else{
            throw new InValidUserDataException("'" + email + "' Email tersebut sudah terpakai.");
        }
        
        // mengecek apakah password valid atau tidak
        if(Validation.isPassword(password)){
            vPassword = true;
        }else{
            throw new InValidUserDataException("'" + password + "' Password tersebut tidak valid.");
        }
        
        return vIdUser && vNoHp && vEmail && vPassword;
    }
    
    /**
     * Method ini digunakan untuk menghapus sebuah akun dari user yang ada didalam <b>Database</b> berdasarkan 
     * id user yang diinputkan. Method akan menghapus akun user dari <b>Database</b> melalui method 
     * {@code deleteData()} yang ada didalam class {@code Database}. Method akan mengembalikan nilai 
     * <code>True</code> jika akun dari user berhasil dihapus.
     * 
     * @param idUser id dari user yang ingin dihapus.
     * @return <strong>True</strong> jika akun dari user berhasil dihapus. <br>
     *         <strong>Fale</strong> jiak akun dari user tidak berhasil dihapus.
     */
    public final boolean deleteUser(String idUser){
        return this.deleteData(DatabaseTables.USERS.name(), UserData.ID_USER.name(), idUser);
    }
    
    /**
     * Method ini digunakan untuk mendapatkan data akun yang sedang digunakan untuk login (login data) 
     * pada Aplikasi. Login data disimpan pada file <code>login_data.haqi</code> yang ada didalam folder 
     * Storage. Method membaca data yang ada didalam file <code>login_data.haqi</code> dengan melalui 
     * class {@code BufferedReader}. 
     * <br><br>
     * Jika file <code>login_data.haqi</code> yang digunakan untuk menyimpan login data tidak ditemukan 
     * maka akan menyebabkan force close pada Aplikasi.Data yang ada didalam login data sangatlah simple 
     * karena hanya berisi id login dan id dari user saja.
     * <br><br>
     * <b>Contoh Login Data : </b> Ju09pzi4/6156 (id login / id user).
     * 
     * @return akan mengembalikan data akun yang sedang digunakan untuk login (login data).
     */
    private String getLoginData(){        
        // membaca semua data yang ada didalam file login_data.haqi
        try(BufferedReader data = new BufferedReader(new FileReader(this.LOGIN_DATA_FILE))){
            // mengembalikan nilai loginData
            return data.readLine();
        }catch(IOException ex){
            System.out.println(ex.getMessage());
            System.exit(404);
        }     
        return null;
    }
    
    /**
     * Digunakan untuk mengecek apakah user sudah melalukan Login pada Aplikasi atau belum. Petama-tama
     * method akan mendapatkan login data dari Aplikasi. Selanjunya method akan mengecek apakah login data 
     * kosong atau tidak. Jika login data kosong maka user akan dianggap belum melakukan login. Jika login data tidak 
     * kosong maka method akan mengambil data id login dan id user yang ada didalam login data melalui object dari 
     * class {@code StringTokenizer}.
     * <br><br>
     * Sebelum mengambil data id login dan id user yang ada didalam login data method akan mengecek apakah token yang ada
     * didalam object {@code StringTokenizer} berjumlah dua token atau tidak. Jika jumlah tokennya != 2 maka login data 
     * dinyatakan tidak valid dan method akan mengembalikan nilai <code>False</code>. Jika jumlah tokenya sama dengan 
     * dua maka method akan mendapatkan data id login dan id user yang ada di dalam login data. 
     * <br><br>
     * Selanjutnya method akan mengecek id login dan id user yang dari login data apakah ada atau tidak didalam <b>Database</b>. 
     * Jika id login atau id user tidak ada didalam <b>Database</b> maka login data dianggap tidak valid dan user juga akan 
     * dianggap belum melakukan login. Tetapi jika id login dan id user ada didalam <b>Database</b> maka method akan mengecek 
     * apakah id user dari id login yang ada didalam login data apakah match/sama dengan id user yang ada didalam <b>Database</b>.
     * <br><br>
     * Jika id user dari id login yang ada didalam login data match/sama dengan id user yang ada didalam <b>Database</b>
     * maka user dianggap sudah melalukan login dan method akan mengembalikan nilai <code>True</code>.
     * 
     * @return <strong>True</strong> jika user sudah melakukan login. <br>
     *         <strong>False</strong> jika user belum melakukan login.
     */
    public final boolean isLogin(){
        
        // object dan variabel digunakan untuk mengecek 
        String idLogin, idUser, loginData = this.getLoginData();
        StringTokenizer token;
        
        // jika login data tidak kosong
        if(loginData != null){
            // menginputkan login data kedalam StringTokenizer
            token = new StringTokenizer(loginData, "/");
            // mengecek apakah jumlah token sama dengan 2 atau tidak
            if(token.countTokens() == 2){
                // mendapatkan data dari loginData
                idLogin = token.nextToken();
                idUser = token.nextToken();
                // mengecek apakah idLogin dan idUser dari loginData exist atatu tidak
                if(isExistIdLogin(idLogin) && this.isExistUser(idUser)){
                    // mengecek apakah id user yg ada didalam login data apakah sama dgn yg ada didalam DB
                    return isMatchLogin(idLogin, idUser);
                }
            }            
        }
        return false;
    }
    
    /**
     * Method ini digunakan untuk melakukan Login pada Aplikasi. User dapat melakukan Login pada Aplikasi cukup 
     * dengan menginputkan ID User beserta passwordnya. Pertama-tama method akan mengecek apakah user sudah 
     * melakukan login atau belum. Jika user sudah melakukan login maka method akan menghasilkan exception 
     * {@code AuthenticationException}. Pertama-tama method akan mengecek apakah ID User dan passwordnya valid atau tidak. 
     * Jika ID User atau passwordnya tidak valid maka Login akan dibatalkan dan method akan mengembalikan nilai <b>False</b>.
     * <br><br>
     * Jika ID User dan passwordya valid maka method akan membuat sebuah ID Login baru. Setelah membuat ID Login
     * method akan juga membuat login data baru bedasarkan ID User yang diinputkan dan ID Login yang baru saja dibuat.
     * Setelah login data dibuat method akan menyimpan login data tersebut kedalam file login_data.haqi yang 
     * ada didalam folder Storage dengan menggunakan class {@code BufferedWriter}. 
     * <br><br>
     * Jika login data sudah berhasil disimpan kedalam file maka selanjutnya mehtod akan membuat sebuah object 
     * {@code PreparedStatement} yang digunakan untuk menyimpan login data kedalam <b>Database</b>. Method juga 
     * akan membuat folder user storage yang digunakan untuk menyimpan data dari user berdasarkan ID User yang diinputkan. 
     * Jika login data berhasil ditambahkan kedalam <b>Database</b> dan folder user storage berhasil dibuat maka 
     * login dianggap berhasil dan method akan mengembalikan nilai <code>True</code>.
     * 
     * @param idUser id dari user yang akan melakukan login.
     * @param password password dari user.
     * 
     * @return <strong>True</strong> jika login berhasil dilakukan. <br>
     *         <strong>False</strong> jika login tidak berhasil dilakukan.
     * 
     * @throws IOException jika terjadi kesalahan saat memanipulasi file login_data.haqi.
     * @throws AuthenticationException jika user sudah melakukan login.
     * @throws SQLException jika terjadi kesalahan pada <b>Database</b>.
     */
    public final boolean login(String idUser, String password) throws IOException, AuthenticationException, SQLException{
        
        PreparedStatement pst;
        String idLogin, newLoginData;
        
        // mengecek apakah user sudah login atau belum
        if(this.isLogin()){
            throw new AuthenticationException("Anda sudah login dengan akun '" + this.getCurrentLogin() + "'");
        }
        
        // mengecek apakah idUser dan password valid atau tidak
//        if(this.validateLogin(idUser, password)){
            // membuat sebuah id login baru 
            idLogin = this.createIdLogin();
            // membuat login data baru
            newLoginData = idLogin + "/" + idUser;
            Log.addLog("Melakukan Login dengan ID Login : '" + idLogin + "' dan dengan ID User : '"+ idUser +"'");
            
            // menyimpan login data kedalam file
            BufferedWriter save = new BufferedWriter(new FileWriter(this.LOGIN_DATA_FILE));
            save.write(newLoginData);
            save.flush();
            save.close();
            
            // menyimpan login data ke dalam tabel login yang ada didalam Database
            pst = this.conn.prepareStatement("INSERT INTO login VALUES (?, ?, ?)");
            pst.setString(1, idLogin);
            pst.setString(2, idUser);
            pst.setString(3, new Waktu().getCurrentDateTime());
            
            // true jika login data berhasil ditambahkan dan user storage berhasil dibuat
            return pst.executeUpdate() > 0 && this.createUserStorage(idUser);
//        }
//        return false;
    }
    
    /**
     * Digunakan untuk mengecek apakah id user dan password valid atau tidak. Jika salah satu data dari id user 
     * atau password ada yang tidak valid maka semua data akan dianggap tidak valid dan method akan mengembalikan 
     * nilai <code>False</code>. Method akan mengembalikan nilai <code>True</code> jika id user dan password valid.
     * 
     * @param idUser ID dari user yang akan dicek.
     * @param password password dari user yang akan dicek.
     * 
     * @return <strong>True</strong> jika id user dan password valid. <br>
     *         <strong>False</strong> jika id user atau password tidak valid.
     * 
     * @throws AuthenticationException jika id user atau password tidak valid.
     */
    private boolean validateLogin(String idUser, String password) throws AuthenticationException{

        // mengecek apakah id user valid atau tidak
        if(!new Text().isNumber(idUser)){
            throw new AuthenticationException("ID User harus berupa Angka.");
        }else if(!Validation.isIdUser(Integer.parseInt(idUser))){
            throw new AuthenticationException("'" +idUser + "' ID User tersebut tidak valid.");
        }else if(!this.isExistUser(idUser)){
            throw new AuthenticationException("'" +idUser + "' ID User tersebut tidak dapat ditemukan.");
        }
        // mengecek apakah password valid atau tidak
        else if(!Validation.isPassword(password)){
            throw new AuthenticationException("Password yang anda masukan tidak valid.");
        }else if(!password.equalsIgnoreCase(this.getPassword(idUser))){
            throw new AuthenticationException("Password yang anda masukan tidak cocok.");
        }else{
            return true;
        }
    }
    
    /**
     * Digunakan untuk mengecek apakah direktori storage dari user exist atu tidak. Pertama-tama method 
     * akan mendapatkan direktori dari storage user melalui method {@code getUserStorage()}. Setelah 
     * direktori dari storage user berhasil didapatkan selanjutnya method akan mengecek apakah direktori 
     * tersebut exist atau tidak dengan menggunakan method {@code exists()} yang ada didalam class {@code File}
     * 
     * @param idUser id user yang akan dicek.
     * @return <strong>True</strong> jika storage dari user exist. <br>
     *         <strong>False</strong> jika storage dari user tidak exist.
     */
    public final boolean isExistUserStorage(String idUser){
        return new File(this.getUserStorage(idUser)).exists();
    }
    
    /**
     * Method ini digunakan untuk membuat folder storage dari user. Pertama-tama method akan mengecek apakah 
     * direktori dari storage user sudah exist atau belum. Jika sebelumnya direktori storage dari user sudah 
     * exist maka method akan mengembalikan nilai <code>True</code>. Tetapi sebelumnya direktori dari user
     * belum exist maka storage dari user akan dibuat melalui method {@code createFolders()} yang ada didalam
     * class {@code FileManager}. Jika storage dari user berhasil dibuat maka method akan mengembalikan nilai 
     * <code>True</code>.
     * 
     * @param idUser id user yang akan dicek.
     * @return <strong>True</strong> jika storage berhasil dibuat. <br>
     *         <strong>False</strong> jika storage tidak berhasil dibuat.
     */
    public final boolean createUserStorage(String idUser){
        if(this.isExistUserStorage(idUser)){
            return true;
        }else{
            return new FileManager().createFolders(this.getUserStorage(idUser));
        }
    }
    
    /**
     * Method ini digunakan untuk memdapatakan direktori storage dari id user yang diinputkan. Kegunaan 
     * direktori storage dari user adalah untuk menyimpan data-data dari user. Pertama-tama method akan 
     * mendapatkan direktori dari Storage melalui method {@code getUsersDirectory()} yang ada didalam class
     * {@code Storage}. 
     * <br><br>
     * Selanjutnya method akan mendapatakan nama dari user melalui method {@code getNameOfIdUser()}. Jika nama dari 
     * user sudah didapatkan selanjutnya method akan mengabungkan direktori dari Storage, id user dan nama dari user 
     * untuk mendapatkan direktori dari user storage.
     * <br><br>
     * <b>Contoh Direktori : </b> C:\Users\Infinite World\AppData\Local\Punya Haqi\SPP Payment 1.0.0\Users\6156_achmad_baihaqi.
     * 
     * @param idUser id dari user.
     * @return akan mengembalikan direktori storage dari id user yang diinputkan.
     */
    public final String getUserStorage(String idUser){
        return new Storage().getUsersDirectory() + idUser + ("_" + getNameOfIdUser(idUser).replaceAll(" ", "_").toLowerCase());
    }
    
    /**
     * Digunakan untuk membuat sebuah ID Login baru. Method akan membuat sebuah ID Login dengan menggunakan 
     * method {@code randomUUID()} yang ada didalam class {@code UUID}. Output dari method tersebut adalah 
     * sebuah String dengan nilai random. Mehotd akan mengambil delapan karakter pertama dari String tersebut.
     * <br><br>
     * Setelah ID Login didapatkan method akan mengecek apakah ID Login tersebut sudah exist atau belum. Jika 
     * ID Login belum exist maka method akan mengembalikan ID Login tersebut dalam bentuk string. Tetapi jika
     * ID Login sudah exist maka method akan membuat ID Login baru.
     * <br><br>
     * <b>Contoh ID Login : </b> Zq0P38Dk
     * 
     * @return ID Login baru dalam bentuk String.
     */
    private String createIdLogin(){
        // membuat id login dengan bantuan dari class UUID
        String idLogin = UUID.randomUUID().toString().substring(0, 8).replaceAll("-", "");
        
        // jika id login belum exist maka method akan mengebalikan id login
        if(!this.isExistIdLogin(idLogin)){
            return idLogin;
        }
        // membuat id login baru jika id login sudah exist
        return createIdLogin();
    }
    
    /**
     * Digunakan untuk mengecek apakah sebuah ID Login sudah exist atau belum. Pertama-tama method
     * akan mengecek apakah ID Login yang diinputkan sudah valid atau tidak dengan menggunakan 
     * method {@code isIdLogin()} yang ada didalam class {@code Validation}. Jika ID Login tidak 
     * valid maka method akan menghasilkan error {@code InValidUserDataException}. Tetapi jika 
     * ID Login valid maka method akan mengecek apakah ID Login sudah exist atau belum dengan 
     * menggunakan method {@code isExistData()} yang ada didalam class {@code Database}.
     * 
     * @param IdLogin ID Login yang akan dicek.
     * @return <strong>True</strong> jika ID Login exist. <br>
     *         <strong>False</strong> jika ID Login belum exist.
     */
    private boolean isExistIdLogin(String IdLogin){
        // mengecek apakah id login valid atau tidak
        if(Validation.isIdLogin(IdLogin)){
            return this.isExistData(DatabaseTables.LOGIN.name(), UserData.ID_LOGIN.name(), IdLogin);
        }
        // akan menghasilkan error jika id login tidak valid
        throw new InValidUserDataException("'" + IdLogin + "' ID Login tersebut tidak valid");
    }
    
    /**
     * Method ini digunakan untuk mendapatkan ID Login dari akun yang sedang digunakan untuk Login.
     * Pertama-tama method akan mengecek apakah user sudah melakukan Login atau belum. Jika user belum 
     * melakukan Login maka method akan mengembalikan nilai <code>null</code>. 
     * <br><br>
     * Tetapi jika user sudah melakukan login method akan mendapatkan ID Login yang berada didalam login data. 
     * ID Login yang ada didalam login data akan didapatkan melalui method {@code nextToken()} yang ada didalam 
     * class {@code StringTokenizer()}.
     * <br><br>
     * <b>Example : </b> P9dz93ig
     * 
     * @return ID Login dari akun yang sedang digunakan untuk Login
     */
    private String getCurrentIdLogin(){
        // mengecek apakah user sudah login atau belum
        if(this.isLogin()){
            // mengembalikan data ID Login dari akun yang sedang digunakan untuk Login
            return new StringTokenizer(getLoginData(), "/").nextToken();
        }
        return null;
    }
    
    /**
     * Method ini digunakan untuk mendapatkan ID User dari akun yang sedang digunakan untuk Login.
     * Pertama-tama method akan mengecek apakah user sudah melakukan Login atau belum. Jika user belum 
     * melakukan Login maka method akan mengembalikan nilai <code>null</code>. Tetapi jika user sudah 
     * melakukan login method akan mendapatkan ID User yang berada didalam login data. ID User yang 
     * ada didalam login data akan didapatkan melalui method {@code nextToken()} yang ada didalam 
     * class {@code StringTokenizer()}.
     * <br><br>
     * <b>Example : </b> 6156
     * 
     * @return ID User dari akun yang sedang digunakan untuk Login.
     */
    public final String getCurrentLogin(){
        // mengecek apakah user sudah login atau belum
        if(this.isLogin()){
            // membaca data yang ada dialam variabel loginData
            StringTokenizer token = new StringTokenizer(getLoginData(), "/");
            // membuang data dari ID Login
            token.nextToken(); 
            // mengembalikan data ID User dari akun yang sedang digunakan untuk Login
            return token.nextToken();
        }            
        return null;
    }
    
    /**
     * Method ini digunakan untuk mengecek apkah ID User dari ID Login yang ada didalam login data apakah 
     * cocok/match dengan ID User dari ID Login yang ada didalam <b>Database</b>. Method akan mendapatkan 
     * ID user dari ID Login yang ada didalam <b>Database</b> berdasarkan ID Login yang diinputkan. 
     * Jika ID User yang ada didalam <b>Database</b> sudah didapatkan maka selanjutnya method akan mengecek 
     * apakah ID user yang ada didalam login data cocok/match dengan ID User yang ada didalam 
     * <b>Database</b> atau tidak.
     * 
     * @param idLogin ID Login yang ada didalam <b>Database</b>.
     * @param idUser ID User yang akan dicek.
     * @return <strong>True</strong> jika cocok. <br>
     *         <strong>False</strong> jika tidak cocok.
     */
    private boolean isMatchLogin(String idLogin, String idUser){
        return
        // mendapatkan data dari id_user yang ada didalam database        
        this.getData(DatabaseTables.LOGIN.name(), UserData.ID_USER.name(), "WHERE " + UserData.ID_LOGIN + " = '" + idLogin +"'")
            // mengecek apakah idUser yang ada didalam login data apakah cocok dengan yang ada didalam database    
            .equals(idUser);
    }
    
    /**
     * Method ini digunakan untuk melakukan Logout pada Aplikasi. Sebelum melogout akun method akan mengecek apakah 
     * user sudah melakukan Login atau belum. Jika user belum melakukan Login maka method akan menghasilkan 
     * exception {@code AuthenticationException}. Method akan melogout akun dengan cara menhapus login data yang 
     * ada didalam <b>Database</b> dengan menggunakan method {@code deleteData()} yang ada didalam class 
     * {@code Database}. Jika login data yang ada didalam <b>Database</b> berhasil dihapus maka Logout akan 
     * dinyatakan berhasil dan method akan mengembalikan nilai <code>True</code>.
     * 
     * @return <strong>True</strong> jika Logout berhasil. <br>
     *         <strong>False</strong> jika Logout tidak berhasil.
     * 
     * @throws AuthenticationException jika user belum melakukan login.
     */
    public final boolean logout() throws AuthenticationException{
        // mengecek apakah user sudah melakukan login atau belum
        if(isLogin()){
            Log.addLog("Melakukan Logout pada Akun dengan ID User : " + this.getCurrentLogin() + "'");
            // menghapus login data yang ada didalam database
            return this.deleteData(DatabaseTables.LOGIN.name(), UserData.ID_LOGIN.name(), this.getCurrentIdLogin());         
        }
        throw new AuthenticationException("Gagal melogout akun dikarenakan Anda belum Login.");
    }
    
    /**
     * Method ini digunakan untuk mengecek apakah sebuah ID User sudah exist atau belum didalam <b>Database</b>.
     * Pertama-tama method akan mengecek apakah ID User valid atau tidak dengan menggunakan method 
     * {@code isIdUser()} yang ada didalam class {@code Validation}. Jika ID User tidak valid maka method 
     * akan menghasilkan exception {@code InValidUserDataException}.
     * <br><br>
     * Method akan mengecek apakah sebuah ID User sudah exist atau belum didalam <b>Database</b> dengan 
     * menggunakan method {@code isExistData()} yang ada didalam class {@code Database}. Jika output dari 
     * method tersebut adalah <code>True</code> maka ID User dinyatakan exist.
     * 
     * @param idUser ID User yang akan dicek.
     * @return <strong>True</strong> jika ID User exist. <br>
     *         <strong>False</strong> jika ID User tidak exist.
     */
    public final boolean isExistUser(String idUser){
        // mengecek apakah id user yang diinputkan merupakah sebuah number atau tidak
        if(new Text().isNumber(idUser)){
            // mengecek apakah id user valid atau tidak
            if(Validation.isIdUser(Integer.parseInt(idUser))){
                return this.isExistData(DatabaseTables.USERS.name(), UserData.ID_USER.name(), idUser);
            }
        }
        // akan menghasilkan error jika id user tidak valid
        throw new InValidUserDataException("'" +idUser + "' ID User tersebut tidak valid.");
    }
    
    /**
     * Method ini digunakan untuk mengecek apakah sebuah Nomor HP sudah exist atau belum didalam <b>Database</b>.
     * Pertama-tama method akan mengecek apakah Nomor HP valid atau tidak dengan menggunakan method 
     * {@code isNoHp()} yang ada didalam class {@code Validation}. Jika Nomor HP tidak valid maka method 
     * akan menghasilkan exception {@code InValidUserDataException}.
     * <br><br>
     * Method akan mengecek apakah sebuah Nomor HP sudah exist atau belum didalam <b>Database</b> dengan 
     * menggunakan method {@code isExistData()} yang ada didalam class {@code Database}. Jika output dari 
     * method tersebut adalah <code>True</code> maka Nomor HP dinyatakan exist.
     * 
     * @param noHp nomor HP yang akan dicek.
     * @return <strong>True</strong> jika Nomor HP exist. <br>
     *         <strong>False</strong> jika Nomor HP tidak exist.
     */
    public final boolean isExistNoHp(String noHp){
        // mengecek apakah no hp valid atau tidak
        if(Validation.isNoHp(noHp)){
            return this.isExistData(DatabaseTables.USERS.name(), UserData.NO_HP.name(), noHp);
        }
        // akan menghasilkan error jika no hp tidak valid
        throw new InValidUserDataException("'" + noHp + "' Nomor HP tersebut tidak valid.");
    }
    
    /**
     * Method ini digunakan untuk mengecek apakah sebuah Email sudah exist atau belum didalam <b>Database</b>.
     * Pertama-tama method akan mengecek apakah Email valid atau tidak dengan menggunakan method 
     * {@code isNoHp()} yang ada didalam class {@code Validation}. Jika Email tidak valid maka method 
     * akan menghasilkan exception {@code InValidUserDataException}.
     * <br><br>
     * Method akan mengecek apakah sebuah Email sudah exist atau belum didalam <b>Database</b> dengan 
     * menggunakan method {@code isExistData()} yang ada didalam class {@code Database}. Jika output dari 
     * method tersebut adalah <code>True</code> maka Email dinyatakan exist.
     * 
     * @param email email yang akan dicek.
     * @return <strong>True</strong> jika Email exist. <br>
     *         <strong>False</strong> jika Email HP tidak exist.
     */
    public final boolean isExistEmail(String email){
        // mengecek apakah email valid atau tidak
        if(Validation.isEmail(email)){
            return this.isExistData(DatabaseTables.USERS.name(), UserData.EMAIL.name(), email);
        }
        // akan menghasilkan error jika email tidak valid
        throw new InValidUserDataException("'" + email + "' Email tersebut tidak valid.");
    }
    
    /**
     * Method ini akan mengembalikan data dari user berdasarkan ID User yang diinputkan. Pertama-tama method 
     * akan mengecek apakah ID User exist atau tidak. Jika ID User tidak exist maka akan menghasilkan exception 
     * {@code InValidUserDataException}. Tetapi jika ID User exist maka data dari user akan didapatkan dengan 
     * melalui method {@code getData()} yang ada didalam class {@code Database}.
     * 
     * @param idUser ID User yang ingin diambil datanya.
     * @param data data yang ingin diambil.
     * @return akan mengembalikan data dari user berdasarkan ID User yang diinputkan.
     */
    private String getUserData(String idUser, UserData data){
        // mengecek apakah id user exist atau tidak
        if(this.isExistUser(idUser)){
            // mendapatkan data dari user
            return this.getData(DatabaseTables.USERS.name(), data.name(), " WHERE "+ UserData.ID_USER.name() +" = " + idUser);
        }
        // akan menghasilkan error jika id user tidak ditemukan
        throw new InValidUserDataException("'" +idUser + "' ID User tersebut tidak dapat ditemukan.");            
    }
    
    /**
     * Method ini digunakan untuk megedit data dari user berdasarkan ID User yang diinputkan. Sebelum mengedit data
     * method akan mengecek apakah ID User exist atau tidak. Jika ID User tidak exist maka akan menghasilkan exception 
     * {@code InValidUserDataException}. Tetapi jika ID User exist maka method akan mengedit data dari user dengan 
     * menggunakan method {@code setData()} yang ada didalam class {@code Database}. Jika data dari user berhasil 
     * diedit maka method akan mengembalikan nilai <code>True</code>.
     * 
     * @param idUser ID User yang ingin diedit datanya.
     * @param data data dari ID User yang ingin diedit.
     * @param newValue nilai baru dari data yang ingin diedit.
     * 
     * @return <strong>True</strong> jika data berhasil diedit. <br>
     *         <strong>False</strong> jika data tidak berhasil diedit.
     */
    private boolean setUserData(String idUser, UserData data, String newValue){
        // mengecek apakah id user exist atau tidak
        if(this.isExistUser(idUser)){
            // mengedit data dari user
            return this.setData(DatabaseTables.USERS.name(), data.name(), UserData.ID_USER.name(), idUser, newValue);
        }
        // akan menghasilkan error jika id user tidak ditemukan
        throw new InValidUserDataException("'" +idUser + "' ID User tersebut tidak dapat ditemukan.");
    }
    
    /**
     * Method ini digunakan untuk mendapatkan data last online dari user berdasarkan ID User yang diinputkan.
     * Sebelum mendapatkan data method akan mengecek apakah ID User yang inputkan exist atau tidak dengan menggunakan 
     * method {@code isExistUser()}. Jika output dari method tersebut adalah <code>False</code> maka ID User dinyatakan 
     * tidak valid dan method akan menghasilkan exception {@code InValidUserDataException}.
     * <br><br>
     * Method akan mendapatkan data last online dari user dengan menggunakan method {@code getData()} yang ada didalam
     * class {@code Database}.
     * 
     * @param idUser ID User yang ingin didapatkan datanya.
     * @return data last online dari user.
     */
    public String getLastOnline(String idUser){
        // mengecek apakah id user exist atau tidak
        if(this.isExistUser(idUser)){
            // mendapatkan data last online dari user
            return this.getData(DatabaseTables.LOGIN.name(), UserData.LAST_ON.name()," WHERE "+ UserData.ID_USER.name() +" = " + idUser);
        }
        // akan menghasilkan error jika id user tidak ditemukan
        throw new InValidUserDataException("'" +idUser + "' ID User tersebut tidak dapat ditemukan.");            
    }
    
    /**
     * Method ini digunakan untuk mendapatkan data last online berdasarkan ID User dari akun yang sedang digunakan 
     * untuk Login. Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}.
     * 
     * @return data last online dari user yang sedang login.
     */
    public String getLastOnline(){
        return this.getLastOnline(getCurrentLogin());
    }
    
    /**
     * Method ini digunakan untuk mengedit data last online berdaskarkan ID User dan Date Time yang diinputkan.
     * Sebelum mengedit data method akan mengecek apakah ID User exist atau tidak. Jika ID User tidak exist maka 
     * akan menghasilkan exception {@code InValidUserDataException}. Tetapi jika ID User exist maka method akan 
     * mengedit data dengan menggunakan method {@code setData()} yang ada didalam class {@code Database}. Jika data 
     * last online berhasil diedit maka method akan mengembalikan nilai <code>True</code>.
     * 
     * @param idUser ID User yang ingin diedit datanya.
     * @param dateTime Date time dari last online.
     * 
     * @return <strong>True</strong> jika data berhasil diedit. <br>
     *         <strong>False</strong> jika data tidak berhasil diedit.
     */
    public boolean updateLastOnline(String idUser, String dateTime){
        // mengecek apakah id user exist atau tidak
        if(this.isExistUser(idUser)){
            // mengedit data last online dari user
            return this.setData(DatabaseTables.LOGIN.name(), UserData.LAST_ON.name(), UserData.ID_USER.name(), idUser, dateTime);
        }
        // akan menghasilkan error jika id user tidak ditemukan
        throw new InValidUserDataException("'" +idUser + "' ID User tersebut tidak dapat ditemukan.");          
    }
    
    /**
     * Method ini digunakan untuk mengedit data last online berdasarkan ID User yang diinputkan. Data last 
     * online akan diset pada date time saat ini. Method akan mengedit data last online dari user dengan 
     * menggunakan method {@code updateLastOnline(String idUser, String dateTime)}. Jika data last online 
     * berhasil diedit maka method akan mengembalikan nilai <code>True</code>.
     * 
     * @param idUser ID User yang ingin diedit datanya.
     * 
     * @return <strong>True</strong> jika data berhasil diedit. <br>
     *         <strong>False</strong> jika data tidak berhasil diedit.
     */
    public boolean updateLastOnline(String idUser){
        // mengedit data last online dengan tanggal dan waktu saat ini
        return this.updateLastOnline(idUser, new Waktu().getCurrentDateTime());
    }
    
    /**
     * Method ini digunakan untuk mengedit data last online berdasarkan ID User dari akun yang sedang digunakan 
     * untuk Login. Data last online akan diset pada date time saat ini. Method akan mengedit data last online 
     * dari user dengan menggunakan method {@code updateLastOnline(String idUser)}. Jika data last online 
     * berhasil diedit maka method akan mengembalikan nilai <code>True</code>.
     * 
     * @return <strong>True</strong> jika data berhasil diedit. <br>
     *         <strong>False</strong> jika data tidak berhasil diedit.
     */
    public boolean updateLastOnline(){
        return this.updateLastOnline(getCurrentLogin());
    }
    
    /**
     * Method ini digunakan untuk mendapatkan data dari nama user berdasarkan ID User yang diinputakan.
     * Pertama-tama method akan mengecek apakah user memiliki level Admin atau Petugas. Jika user memiliki 
     * level Admin atau Petugas maka data dari nama user akan diambil dari tabel petugas yang ada didalam 
     * <b>Database</b>. Tetpai jika user memiliki level Siswa maka data dari nama user akan diambil dari 
     * tabel siswa yang ada didalam <b>Database</b>.
     * 
     * @param idUser ID User yang dinggin diambil namanya.
     * @return akan mengembalikan nama dari ID User yang diinputkan.
     */
    private String getNameOfIdUser(String idUser){
        String name = "";
        // mengecek apakah user memiliki level admin atau petugas
        if(this.isAdmin(idUser) || this.isPetugas(idUser)){
            // mendapatkan data dari nama user yang ada didalam tabel petugas
            name = this.getData(DatabaseTables.PETUGAS.name(), PetugasData.NAMA_PETUGAS.name(), "WHERE " + PetugasData.ID_PETUGAS + " = " + idUser);
        }else if(this.isSiswa(idUser)){
            // mendapatkan data dari nama user yang ada didalam tabel siswa
            name = this.getData(DatabaseTables.SISWA.name(), SiswaData.NAMA_SISWA.name(), "WHERE " + SiswaData.NIS + " = " + idUser);
        }
        return name;
    }
    
    /**
     * Method ini digunakan untuk mendapatkan data Nomor HP dari user berdasarkan ID User yang diinputkan. 
     * ID User yang diinputkan harus sudah terdaftar didalam <b>Database</b>. Jika ID User yang diinputkan ternyata 
     * tidak terdaftar didalam <b>Database</b> maka method akan menghasilkan exception {@code InValidUserDataException}. 
     * Method hanya akan mendapatkan data Nomor HP dari user jika ID User yang diinputkan terdaftar didalam <b>Database</b>.
     * 
     * @param idUser ID User yang ingin didapatkan datanya.
     * @return data Nomor HP dari ID User yang diinputkan.
     */
    public String getNoHp(String idUser){
        return this.getUserData(idUser, UserData.NO_HP);
    }
    
    /**
     * Method ini digunakan untuk mendapatkan data Nomor HP dari user berdasarkan ID User dari akun yang sedang 
     * digunakan untuk Login. Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}.
     * Selanjutnya method akan mendapatkan data Nomor HP dari user melalui method {@code getNoHp(String idUser)}.
     * Jika user belum melakukan login maka method akan mengembalikan nilai <code>null</code>.
     * 
     * @return data Nomor HP dari akun yang sedang Login.
     */
    public String getNoHp(){
        return this.getNoHp(getCurrentLogin());
    }
    
    /**
     * Digunakan untuk mengedit data Nomor HP dari user berdasarkan ID User yang diinputkan. Sebelum mengedit 
     * data Nomor HP method akan mengecek apakah Nomor HP yang diinputkan valid atau tidak dengan menggunakan 
     * method {@code idNoHP(String noHp)} yang ada didalam class {@code Validation}. Jika Nomor HP tidak valid
     * maka method akan menghasilkan exception {@code InValidUserDataException}.
     * <br><br>
     * Jika Nomor HP valid maka selanjutnya method akan mengecek apakah Nomor HP sudah terpakai atau belum dengan 
     * menggunakan method {@code isExistNoHp}. Jika Nomor HP sudah ada yang memakai maka method akan menghasilkan 
     * exception {@code InValidUserDataException}. 
     * <br><br>
     * Tetapi jika Nomor HP belum ada yang memakai maka data Nomor HP dari user akan diedit. 
     * Jika data dari Nomor HP berhasil diedit maka method akan mengembalikan nilai <code>True</code>.
     * 
     * @param idUser ID User yang ingin diedit datanya.
     * @param newNoHp data Nomor HP yang baru.
     * 
     * @return <strong>True</strong> jika data berhasil diedit. <br>
     *         <strong>False</strong> jika data tidak berhasil diedit.
     */
    public boolean setNoHp(String idUser, String newNoHp){
        // mengecek apakah nomor hp valid atau tidak
        if(Validation.isNoHp(newNoHp)){
            // mengecek apakah nomor hp sudah dipakai atau belum
            if(!this.isExistNoHp(newNoHp)){
                // mengedit data nomor hp dari user
                return this.setUserData(idUser, UserData.NO_HP, newNoHp);
            }else{
                // akan menghasilkan error jika nomor hp sudah dipakai
                throw new InValidUserDataException("'" + newNoHp + "' Nomor HP tersebut sudah dipakai.");
            }
        }
        // akan menghasilkan error jika nomor hp tidak valid
        throw new InValidUserDataException("'" + newNoHp + "' Nomor HP tersebut tidak valid.");
    }
    
    /**
     * Digunakan untuk mengedit data Nomor HP dari user berdasarkan ID User dari akun yang sedang digunakan untuk Login. 
     * Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}. Selanjutnya method 
     * akan mengedit data Nomor HP dari user melalui method {@code setNoHp(String idUser, String newNoHp)}. Jika
     * output dari method tersebut adalah <code>True</code> maka data Nomor HP dari user berhasil diedit.
     * 
     * @param newNoHp data Nomor HP yang baru.
     * @return <strong>True</strong> jika data berhasil diedit. <br>
     *         <strong>False</strong> jika data tidak berhasil diedit.
     */
    public boolean setNoHp(String newNoHp){
        return this.setNoHp(getCurrentLogin(), newNoHp);
    }
    
    /**
     * Method ini digunakan untuk mendapatkan data Email dari user berdasarkan ID User yang diinputkan. 
     * ID User yang diinputkan harus sudah terdaftar didalam <b>Database</b>. Jika ID User yang diinputkan ternyata 
     * tidak terdaftar didalam <b>Database</b> maka method akan menghasilkan exception {@code InValidUserDataException}. 
     * Method hanya akan mendapatkan data Email dari user jika ID User yang diinputkan terdaftar didalam <b>Database</b>.
     * 
     * @param idUser ID User yang ingin didapatkan datanya.
     * @return data Email dari ID User yang diinputkan.
     */
    public String getEmail(String idUser){
        return this.getUserData(idUser, UserData.EMAIL);
    }
    
    /**
     * Method ini digunakan untuk mendapatkan data Email dari user berdasarkan ID User dari akun yang sedang 
     * digunakan untuk Login. Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}.
     * Selanjutnya method akan mendapatkan data Email dari user melalui method {@code getEmail(String idUser)}.
     * Jika user belum melakukan login maka method akan mengembalikan nilai <code>null</code>.
     * 
     * @return data Email dari akun yang sedang Login.
     */
    public String getEmail(){
        return this.getEmail(getCurrentLogin());
    }
    
    /**
     * Digunakan untuk mengedit data Email dari user berdasarkan ID User yang diinputkan. Sebelum mengedit 
     * data Email method akan mengecek apakah Email yang diinputkan valid atau tidak dengan menggunakan 
     * method {@code idEmail(String email)} yang ada didalam class {@code Validation}. Jika Email tidak valid
     * maka method akan menghasilkan exception {@code InValidUserDataException}.
     * <br><br>
     * Jika Email valid maka selanjutnya method akan mengecek apakah Email sudah terpakai atau belum dengan 
     * menggunakan method {@code isExistEmail}. Jika Email sudah ada yang memakai maka method akan menghasilkan 
     * exception {@code InValidUserDataException}. 
     * <br><br>
     * Tetapi jika Email belum ada yang memakai maka data Email dari user akan diedit. 
     * Jika data dari Email berhasil diedit maka method akan mengembalikan nilai <code>True</code>.
     * 
     * @param idUser ID User yang ingin diedit datanya.
     * @param newEmail data Email yang baru.
     * 
     * @return <strong>True</strong> jika data berhasil diedit. <br>
     *         <strong>False</strong> jika data tidak berhasil diedit.
     */
    public boolean setEmail(String idUser, String newEmail){
        // mengecek apakah email valid atau tidak
        if(Validation.isEmail(newEmail)){
            // mengecek apakah email sudah dipakai atau belum
            if(!this.isExistEmail(newEmail)){
                // mengedit data email dari user
                return this.setUserData(idUser, UserData.EMAIL, newEmail);
            }else{
                // akan menghasilkan error jika email sudah dipakai
                throw new InValidUserDataException("'" + newEmail + "' Email tersebut sudah dipakai.");
            }
        }
        // akan menghasilkan error jika email tidak valid
        throw new InValidUserDataException("'" + newEmail + "' Email tersebut tidak valid.");
    }
    
    /**
     * Digunakan untuk mengedit data Email dari user berdasarkan ID User dari akun yang sedang digunakan untuk Login. 
     * Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}. Selanjutnya method 
     * akan mengedit data Email dari user melalui method {@code setEmail(String idUser, String newEmail)}. Jika
     * output dari method tersebut adalah <code>True</code> maka data Email dari user berhasil diedit.
     * 
     * @param newEmail data Email yang baru.
     * @return <strong>True</strong> jika data berhasil diedit. <br>
     *         <strong>False</strong> jika data tidak berhasil diedit.
     */
    public boolean setEmail(String newEmail){
        return this.setEmail(getCurrentLogin(), newEmail);
    }
    
    /**
     * Method ini digunakan untuk mendapatkan data Password dari user berdasarkan ID User yang diinputkan. 
     * ID User yang diinputkan harus sudah terdaftar didalam <b>Database</b>. Jika ID User yang diinputkan ternyata 
     * tidak terdaftar didalam <b>Database</b> maka method akan menghasilkan exception {@code InValidUserDataException}. 
     * Method hanya akan mendapatkan data Password dari user jika ID User yang diinputkan terdaftar didalam <b>Database</b>.
     * 
     * @param idUser ID User yang ingin didapatkan datanya.
     * @return data Password dari ID User yang diinputkan.
     */
    public String getPassword(String idUser){
        return this.getUserData(idUser, UserData.PASSWORD);
    }
    
    /**
     * Method ini digunakan untuk mendapatkan data Password dari user berdasarkan ID User dari akun yang sedang 
     * digunakan untuk Login. Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}.
     * Selanjutnya method akan mendapatkan data Password dari user melalui method {@code getPassword(String idUser)}.
     * Jika user belum melakukan login maka method akan mengembalikan nilai <code>null</code>.
     * 
     * @return data Password dari akun yang sedang Login.
     */
    public String getPassword(){
        return this.getPassword(getCurrentLogin());
    }
    
    /**
     * Digunakan untuk mengedit data Password dari user berdasarkan ID User yang diinputkan. Sebelum mengedit 
     * data Password method akan mengecek apakah Password yang diinputkan valid atau tidak dengan menggunakan 
     * method {@code isPassword(String password)} yang ada didalam class {@code Validation}. Jika Password tidak valid
     * maka method akan menghasilkan exception {@code InValidUserDataException}.
     * <br><br>
     * Tetapi jika Password valid maka data Password dari user akan diedit. Jika data dari Password berhasil 
     * diedit maka method akan mengembalikan nilai <code>True</code>.
     * 
     * @param idUser ID User yang ingin diedit datanya.
     * @param newPassword data Password yang baru.
     * 
     * @return <strong>True</strong> jika data berhasil diedit. <br>
     *         <strong>False</strong> jika data tidak berhasil diedit.
     */
    public boolean setPassword(String idUser, String newPassword){
        // mengecek apakah password valid atau tidak
        if(Validation.isPassword(newPassword)){
            // mengedit password dari user
            return this.setUserData(idUser, UserData.PASSWORD, newPassword);
        }
        // akan menghasilkan error jika password tidak valid
        throw new InValidUserDataException("'" + newPassword + "' Password tersebut tidak valid.");
    }
    
    /**
     * Digunakan untuk mengedit data Password dari user berdasarkan ID User dari akun yang sedang digunakan untuk Login. 
     * Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}. Selanjutnya method 
     * akan mengedit data Password dari user melalui method {@code setPassword(String idUser, String newPassword)}. Jika
     * output dari method tersebut adalah <code>True</code> maka data Password dari user berhasil diedit.
     * 
     * @param newPassword data Password yang baru.
     * @return <strong>True</strong> jika data berhasil diedit. <br>
     *         <strong>False</strong> jika data tidak berhasil diedit.
     */
    public boolean setPassword(String newPassword){
        return this.setPassword(getCurrentLogin(), newPassword);
    }
    
    /**
     * Method ini digunakan untuk mendapatkan data Level dari user berdasarkan ID User yang diinputkan. 
     * ID User yang diinputkan harus sudah terdaftar didalam <b>Database</b>. Jika ID User yang diinputkan ternyata 
     * tidak terdaftar didalam <b>Database</b> maka method akan menghasilkan exception {@code InValidUserDataException}. 
     * Method hanya akan mendapatkan data Level dari user jika ID User yang diinputkan terdaftar didalam <b>Database</b>.
     * 
     * @param idUser ID User yang ingin didapatkan datanya.
     * @return data Level dari ID User yang diinputkan.
     */
    public UserLevels getLevel(String idUser){
        return UserLevels.valueOf(this.getUserData(idUser, UserData.LEVEL));
    }
    
    /**
     * Method ini digunakan untuk mendapatkan data Level dari user berdasarkan ID User dari akun yang sedang 
     * digunakan untuk Login. Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}.
     * Selanjutnya method akan mendapatkan data Level dari user melalui method {@code getLevel(String idUser)}.
     * Jika user belum melakukan login maka method akan mengembalikan nilai <code>null</code>.
     * 
     * @return data Level dari akun yang sedang Login.
     */
    public UserLevels getLevel(){
        return this.getLevel(getCurrentLogin());
    }
    
    /**
     * Digunakan untuk mengecek apakah Level dari ID User yang diinputkan memiliki Level <b>ADMIN</b> atau tidak.
     * Method akan mendapatkan data Level dari ID User dengan menggunakan method {@code getLevel()}. Jika output 
     * dari method tersebut adalah <b>ADMIN</b> maka method akan mengembalikan nilai <code>True</code>.
     * 
     * @param idUser ID User yang akan dicek.
     * @return <strong>True</strong> jika level dari user adalah <b>ADMIN</b>. <br>
     *         <strong>False</strong> otherwise. 
     */
    public boolean isAdmin(String idUser){
        return this.getLevel(idUser).name().equals("ADMIN");
    }
    
    /**
     * Digunakan untuk mengecek apakah Level dari akun yang sedang digunakan untuk Login apakah memiliki Level
     * <b>ADMIN</b> atau tidak. Method akan mendapatkan ID User dari akun yang sedang digunakan untuk Login dengan 
     * menggunakan method {@code getCurrentLogin()}. Selanjutnya method akan mengecek apakah user memiliki Level 
     * <b>ADMIN</b> atau tidak melalui method {@code isAdmin(String idUser)}.
     * 
     * @return <strong>True</strong> jika level dari user adalah <b>ADMIN</b>. <br>
     *         <strong>False</strong> otherwise. 
     */
    public boolean isAdmin(){
        return this.isAdmin(getCurrentLogin());
    }
    
    /**
     * Digunakan untuk mengecek apakah Level dari ID User yang diinputkan memiliki Level <b>PETUGAS</b> atau tidak.
     * Method akan mendapatkan data Level dari ID User dengan menggunakan method {@code getLevel()}. Jika output 
     * dari method tersebut adalah <b>PETUGAS</b> maka method akan mengembalikan nilai <code>True</code>.
     * 
     * @param idUser ID User yang akan dicek.
     * @return <strong>True</strong> jika level dari user adalah <b>PETUGAS</b>. <br>
     *         <strong>False</strong> otherwise. 
     */
    public boolean isPetugas(String idUser){
        return this.getLevel(idUser).name().equals("PETUGAS");
    }
    
    /**
     * Digunakan untuk mengecek apakah Level dari akun yang sedang digunakan untuk Login apakah memiliki Level
     * <b>PETUGAS</b> atau tidak. Method akan mendapatkan ID User dari akun yang sedang digunakan untuk Login dengan 
     * menggunakan method {@code getCurrentLogin()}. Selanjutnya method akan mengecek apakah user memiliki Level 
     * <b>PETUGAS</b> atau tidak melalui method {@code isPetugas(String idUser)}.
     * 
     * @return <strong>True</strong> jika level dari user adalah <b>PETUGAS</b>. <br>
     *         <strong>False</strong> otherwise. 
     */
    public boolean isPetugas(){
        return this.isPetugas(getCurrentLogin());
    }
    
    /**
     * Digunakan untuk mengecek apakah Level dari ID User yang diinputkan memiliki Level <b>SISWA</b> atau tidak.
     * Method akan mendapatkan data Level dari ID User dengan menggunakan method {@code getLevel()}. Jika output 
     * dari method tersebut adalah <b>SISWA</b> maka method akan mengembalikan nilai <code>True</code>.
     * 
     * @param idUser ID User yang akan dicek.
     * @return <strong>True</strong> jika level dari user adalah <b>SISWA</b>. <br>
     *         <strong>False</strong> otherwise. 
     */
    public boolean isSiswa(String idUser){
        return this.getLevel(idUser).name().equals("SISWA");
    }
    
    /**
     * Digunakan untuk mengecek apakah Level dari akun yang sedang digunakan untuk Login apakah memiliki Level
     * <b>SISWA</b> atau tidak. Method akan mendapatkan ID User dari akun yang sedang digunakan untuk Login dengan 
     * menggunakan method {@code getCurrentLogin()}. Selanjutnya method akan mengecek apakah user memiliki Level 
     * <b>SISWA</b> atau tidak melalui method {@code isSiswa(String idUser)}.
     * 
     * @return <strong>True</strong> jika level dari user adalah <b>SISWA</b>. <br>
     *         <strong>False</strong> otherwise. 
     */
    public boolean isSiswa(){
        return this.isSiswa(getCurrentLogin());
    }
    
    private String getNameOfPhoto(String idUser){
        // mendapatkan nama file dari foto profile berdasarkan id user
        String name = this.getNameOfIdUser(idUser);
        // mengembalikan nama dari file foto profile
        return idUser + "_" + name.replaceAll(" ", "_").toLowerCase() + ".jpg";
    }
    
    public final File getProfile(String idUser){
        try {
            return this.downloadProfile(idUser);
        } catch (SQLException | IOException ex) {
            System.out.println(ex.getMessage());
        }
        return this.getDefaultProfile();
    }
    
    public final File getDefaultProfile(){
        // file default foto profile
        File defProfile = new File(new Storage().getCacheDirectory() + "pictures\\default.jpg");
        boolean rename;
        
        try{
            // jika file default foto profile sudah exist maka akan mengembalikan niali dari defProfile
            if(defProfile.exists()){
                // akan mengembalikan defProfile
                return defProfile;
            }else{
                // mendownload file default foto profile
                defProfile = this.downloadProfile("1");
                // merename file default foto profile ke 'default'
                rename = new FileManager().renameFile(defProfile.toString(), "default");
                // jika file default foto profile berhasil direname maka method akan mengembalikan direktori dari foto profile
                if(rename){
                    // mengembalikan direktori dari file default foto profile
                    return new File(new Storage().getCacheDirectory() + "pictures\\default.jpg");
                }
            }
        }catch(SQLException | IOException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    private String getProfileDir(String idUser){
        // mendapatkan nama file dari foto profile
        String file = this.getNameOfPhoto(idUser);
        // mendapatkan direktori dari foto profile
        return new Storage().getCacheDirectory() + "pictures\\" + file;
    }
    
    private boolean isDownloadedProfile(String idUser){
        // mengecek apakah direktori dan file foto profile exist atau tidak
        return new File(this.getProfileDir(idUser)).exists();
    }
    
    private File downloadProfile(String idUser) throws SQLException, IOException{
        Blob blob = null;
        String query, file;
        // mengecek apakah file sudah terdonwload atau belum
        if(this.isDownloadedProfile(idUser)){
            return new File(this.getProfileDir(idUser));
        }else{
            Log.addLog("Mendownload Foto Profile dari ID User '"+ idUser + "'");
            // membuat query untuk mendapatkan foto profile dari database mysql
            query = String.format(
                    "SELECT %s FROM %s WHERE %s = %s", 
                    UserData.FOTO_PROFILE, DatabaseTables.USERS, UserData.ID_USER, idUser
            );
            System.out.println(query);
            
            // mengeksekusi query
            this.res = this.stat.executeQuery(query);
            // mengecek apakah output dari query kosong atau tidak
            if(this.res.next()){
                blob = this.res.getBlob(UserData.FOTO_PROFILE.name());
            }
            
            // mengecek apakah fotoFile kosong atau tidak
            if(blob == null){
                // mengembalikan file default profile
                return this.getDefaultProfile();
            }else{
                file = this.getProfileDir(idUser);
                // mengkonversi blob menjadi file
                new FileManager().blobToFile(blob, file);
                
                Log.addLog("Foto Profile dari '" + idUser + "' berhasil didownload");
                // mengembalikan file dari foto profile
                return new File(file);
            }
        }
    }
    
    private String getBackupProfileDir(String idUser){
        // mendapatkan nama file dari foto profile
        String file = this.getNameOfPhoto(idUser);
        // mendapatkan direktori dari foto profile
        return new Storage().getBackupDirectory() + "pictures\\" + file;
    }
    
    private boolean isBackupProfile(String idUser){
        return new File(this.getBackupProfileDir(idUser)).exists();
    }
    
    private boolean backupProfile(String idUser, String newFileName){
        String foto, backupFoto;
        // mengecek apakah foto sudah didownload atau belum
        if(this.isDownloadedProfile(idUser)){
            // jika sudah didownload maka akan mengembalikan nilai true
            if(this.isBackupProfile(idUser)){
                return true;
            }else{
                // mendapatkan direktori dari foto yang akan dibackup
                foto = this.getProfileDir(idUser);
                // direktori dari backup foto profile
                backupFoto = new Storage().getBackupDirectory() + "pictures\\";
                // membackup foto profile
                return new FileManager().copyFile(foto, backupFoto);
            }
        }else{
            return false;
        }
    }
    
    private File getBackupProfile(String idUser){
        boolean result;
        // mengecek apakah foto sudah dibackup atau belum
        if(this.isBackupProfile(idUser)){
            return new File(this.getBackupProfileDir(idUser));
        }else{
            // membackup file
            result = this.backupProfile(idUser, null);
            if(result){
                return new File(this.getBackupProfileDir(idUser));
            }
        }
        return null;
    }

    /**
     * Class ini digunakan untuk mendapatkan data data dari petugas.
     * 
     * @author Achmad Baihaqi
     * @since 2021-06-14
     */
    public class LevelPetugas extends Users{  
        
        /**
         * Method ini digunakan untuk menambahkan data dari User dan Petugas yang diinputkan kedalam <b>Database MySQL</b>.
         * Method akan mengembalikan nilai <code>True</code> jika data dari User dan Petugas berhasil ditambahkan kedalam 
         * <b>Database</b>. Jika ada salah satu data yang gagal ditambahkan kedalam <b>Database</b> maka method akan 
         * mengembalikan nilai <code>False</code>
         * <br><br>
         * Pertama-tama method akan menambahkan data dari User kedalam <b>Database</b>. Data dari User akan ditambahkan ke 
         * dalam <b>Database</b> dengan melalui method {@code addUser()} yang ada didalam class {@code Users}. Jika data 
         * dari User berhasil ditambahkan kedalam <b>Database</b> maka selanjutnya method akan menambahkan data Petugas 
         * kedalam <b>Database</b>
         * <br><br>
         * Sebelum menambahkan data Petugas kedalam <b>Database</b> method akan mengecek apakah semua data dari Petugas
         * yang diinputkan valid atau tidak. Jika ada salah satu data dari Petugas yang tidak valid maka data Petugas tidak akan 
         * ditambahkan kedalam <b>Database</b> dan data User yang sebelumnya sudah ditambahkan akan dihapus melalui method 
         * {@code deleteUser} yang ada didalam class {@code} Users. 
         * <br><br>
         * Jika semua data dari Petugas valid maka method akan membuat sebuah object {@code PreparedStatement} yang digunakan 
         * untuk menambahkan data Petugas kedalam <b>Database</b>. Setelah object dari class {@code PreparedStatement} berhasil 
         * dibuat selanjutnya method akan menambahkan semua data dari Petugas kedalam object {@code PreparedStatement}. 
         * <br><br>
         * Jika semua data dari Petugas sudah ditambahkan kedalam object {@code PreparedStatement} maka data dari Petugas tersebut 
         * akan ditambahkan kedalam <b>Database</b> melalui method {@code executeUpdate()} yang ada didalam class 
         * {@code PreparedStatement}. Jika data Petugas berhasil ditambahkan kedalam <b>Database</b> maka method akan megembalikan 
         * nilai <code>True</code>.
         * 
         * @param idUser id user dari user atau petugas.
         * @param noHP no hp dari user atau petugas.
         * @param email email dari user atau petugas.
         * @param profile foto profile dari user atau petugas.
         * @param password passworddari user atau petugas.
         * @param level level dari user atau petugas.
         * @param nama nama dari user atau petugas.
         * @param gender gender dari user atau petugas.
         * @param tempatLahir tampat lahir dari user atau petugas.
         * @param tanggalLahir tanggal lahirdari user atau petugas.
         * @param alamat alamat dari user atau petugas.
         * 
         * @return <strong>True</strong> jika data berhasil ditambahkan. <br>
         *         <strong>False</strong> jika data tidak berhasil ditambahkan. 
         * 
         * @throws FileNotFoundException jika terjadi kegagalan saat menkonversi foto profile kedalam byte stream / Blob.
         * @throws SQLException jika terjadi kegagalan saat menambahkan data kedalam <b>Database</b>.
         * @throws InValidUserDataException jika data dari petugas tidak valid.
         */
        public final boolean addPetugas(String idUser, String noHP, String email, File profile, String password, UserLevels level, String nama, String gender, String tempatLahir, String tanggalLahir, String alamat) 
                throws FileNotFoundException, SQLException, InValidUserDataException
        {
            // digunakan untuk menambahkan data petugas kedalam database
            PreparedStatement pst;
            boolean addUser, addPetugas = false;
            
            // menambahkan data user kedalam database
            addUser = Users.this.addUser(idUser, noHP, email, profile, password, level);
            
            // jika data user berhasil ditambahkan maka data petugas akan ditambahkan kedalam database
            if(addUser){
                // mengecek apakah data petugas valid atau tidak
                if(this.validateAddPetugas(idUser, level, nama, gender, tempatLahir, tanggalLahir, alamat)){
                    // menambahkan data petugas kedalam database
                    pst = Users.this.conn.prepareStatement("INSERT INTO petugas VALUES (?, ?, ?, ?, ?, ?)");
                    pst.setString(1, idUser);
                    pst.setString(2, nama);
                    pst.setString(3, gender);
                    pst.setString(4, tempatLahir);
                    pst.setString(5, tanggalLahir);
                    pst.setString(6, alamat);
                    // mengeksekusi query
                    addPetugas = pst.executeUpdate() > 0;
                }
            }
            
            // jika data petugas berhasil ditambahkan maka method akan mengembalikan nilai true
            if(addPetugas){
                return true;
            }else{
                // jika data petugas gagal ditambahkan maka data user akan dihapus melalui mehtod deleteUser()
                Users.this.deleteUser(idUser);
                return false;
            }
        }
        
        /**
         * Method ini digunakan untuk mengecek apakah semua data dari Petugas yang diinputkan valid atau tidak.
         * Method akan mengecek satu persatu data dari Petugas. Jika ada salah satu data saja yang tidak valid maka 
         * semua data dari Petugas yang di inputkan akan dianggap tidak valid dan method akan mengembalikan nilai 
         * <code>False</code>. Method hanya akan mengembalikan nilai <code>True</code> jika semua data dari 
         * Petugas yang diinputkan valid.
         * 
         * @param idPetugas id id petugas yang akan dicek.
         * @param level level yang akan dicek.
         * @param nama nama level yang akan dicek.
         * @param gender gender level yang akan dicek.
         * @param tempatLahir tempat lahir level yang akan dicek.
         * @param tanggalLahir tanggal lahir level yang akan dicek.
         * @param alamat alamat level yang akan dicek.
         * 
         * @return <strong>True</strong> jika semua data dari Petugas valid. <br>
         *         <strong>False</strong> jika ada salah satu data dari Petugas yang tidak valid.
         */
        private boolean validateAddPetugas(String idPetugas, UserLevels level, String nama, String gender, String tempatLahir, String tanggalLahir, String alamat){
            
            boolean vPetugas, vLevel, vNama, vGender, vTmpLhr, vTglLhr, vAlamat;
            
            // mengecek id peugas valid atau tidak
            if(Validation.isIdPetugas(Integer.parseInt(idPetugas))){
                // mengecek apakah id petugas exist atau tidak
                if(!this.isExistPetugas(idPetugas)){
                    vPetugas = true;
                }else{
                    throw new InValidUserDataException("'" + idPetugas + "' ID Petugas tersebut sudah terpakai.");
                }
            }else{
                throw new InValidUserDataException("'" + idPetugas + "' ID Petugas tersebut tidak valid.");
            }
            
            // mengecek level valid atau tidak
            if(level.name().equalsIgnoreCase("ADMIN") || level.name().equalsIgnoreCase("PETUGAS")){
                vLevel = true;
            }else{
                throw new InValidUserDataException("Level dari Petugas harus diantara 'ADMIN' dan 'PETUGAS'.");
            }
            
            // mengecek nama petugas valid atau tidak
            if(Validation.isNamaOrang(nama)){
                vNama = true;
            }else{
                throw new InValidUserDataException("'" + nama + "' Nama tersebut tidak valid.");
            }                
            
            // mengecek gender valid atau tidak
            if(Validation.isGender(gender)){
                vGender = true;
            }else{
                throw new InValidUserDataException("Gender harus diantara 'L' atau 'P'");
            }
            
            // mengecek tempat lahir valid atau tidak            
            if(Validation.isNamaTempat(tempatLahir)){
                vTmpLhr = true;
            }else{
                throw new InValidUserDataException("Tempat Lahir tidak valid.");
            }
            
            // mengecek tanggal lahir valid atau tidak
            if(Validation.isTanggalLahir(tanggalLahir)){
                vTglLhr = true;
            }else{
                throw new InValidUserDataException("Tanggal Lahir tidak valid.");
            }

            // megecek apakah alamat valid atau tidak
            if(Validation.isNamaTempat(alamat)){
                vAlamat = true;
            }else{
                throw new InValidUserDataException("Alamat tidak valid.");
            }
            return vPetugas && vLevel && vNama && vGender && vTmpLhr && vTglLhr && vAlamat;
        }
        
        /**
         * Method ini digunakan untuk menghapus sebuah akun Petugas yang tersimpan didalam tabel <code>users</code> dan 
         * tabel <code>petugas</code> yang ada didalam <b>Database</b> berdasarkan id user yang diinputkan. Method akan menghapus 
         * data akun Petugas yang ada didalam tabel <code>users</code> dengan melalui method {@code deleteUser()} yang ada 
         * didalam class {@code Users}.
         * <br><br>
         * Method akan menghapus data akun Petugas yang ada didalam tabel <code>petugas</code> dengan menggunakan method
         * {@code deleteData()} yang ada didalam class {@code Database}. Jika kedua data Petugas yang ada didalam tabel 
         * <code>users</code> dan tabel <code>petugas</code> berhasil dihapus maka method akan mengembalikan nilai <code>True</code>s
         * 
         * @param idUser id dari user yang ingin dihapus.
         * @return <strong>True</strong> jika akun berhasil dihapus. <br>
         *         <strong>False</strong> jiak akun tidak berhasil dihapus.
         */
        public final boolean deletePetugas(String idUser){
            return Users.this.deleteUser(idUser) && 
                   Users.this.deleteData(DatabaseTables.PETUGAS.name(), PetugasData.ID_PETUGAS.name(), idUser);
        }
        
        /**
         * Method ini digunakan untuk mengecek apakah sebuah ID User dari Petugas sudah exist atau belum didalam 
         * <b>Database</b>. Method akan mengembalikan nilai <code>True</code> jika ID User dari Petugas exist didalam 
         * tabel <code>users</code> dan tabel <code>petugas</code> yang ada didalam <b>Database</b>. Pertama-tama method 
         * akan mengecek apakah ID User dari Petugas exist atau tidak didalam tabel <code>users</code> yang ada didalam 
         * <b>Database</b>. 
         * <br><br>
         * Jika ID User tidak exist maka method akan mengembalikan nilai <code>False</code>. Selanjutnya method akan mengecek 
         * apakah ID User dari Petugas valid atau tidak dengan menggunakan method {@code isIdPetugas()} yang ada didalam 
         * class {@code Validation}. Jika ID User dari Petugas tidak valid maka method akan menghasilkan exception 
         * {@code InValidUserDataException}.
         * <br><br>
         * Jika ID User dari Petugas valid maka method akan mengecek apakah sebuah ID User dari Petugas exist atau tidak didalam 
         * tabel <code>petugas</code> yang ada didalam <b>Database</b> dengan menggunakan method {@code isExistData()} 
         * yang ada didalam class {@code Database}. Jika output dari method tersebut adalah <code>True</code> maka 
         * ID User dari Petugas dinyatakan exist dan method akan mengembalikan nilai <code>True</code>.
         * 
         * @param idUser ID User dari Petugas yang akan dicek.
         * @return <strong>True</strong> jika ID User dari Petugas exist. <br>
         *         <strong>False</strong> jika ID User dari Petugas tidak exist.
         */
        @Deprecated
        public final boolean isExistPetugas(String idUser){
            // mengecek apakah id petugas valid atau tidak
            if(Validation.isIdPetugas(Integer.parseInt(idUser))){
                // mengecek apakah id petugas exist atau tidak
                return super.isExistData(DatabaseTables.PETUGAS.name(), PetugasData.ID_PETUGAS.name(), idUser);
            }
            return false;
        }
    
        /**
         * Method ini akan mengembalikan data dari Petugas berdasarkan ID Petugas yang diinputkan. Pertama-tama method 
         * akan mengecek apakah ID Petugas exist atau tidak. Jika ID Petugas tidak exist maka method akan menghasilkan exception 
         * {@code InValidUserDataException}. Tetapi jika ID Petugas exist maka data dari Petugas akan didapatkan dengan 
         * melalui method {@code getData()} yang ada didalam class {@code Database}.
         * 
         * @param idPetugas ID Petugas yang ingin diambil datanya.
         * @param data data yang ingin diambil.
         * @return akan mengembalikan data dari Petugas berdasarkan ID Petugas yang diinputkan.
         */
        private String getPetugasData(String idPetugas, PetugasData data){
            // mengecek apakah id petugas exist atau tidak
            if(this.isExistPetugas(idPetugas)){
                // mendapatkan data dari petugas
                return this.getData(DatabaseTables.PETUGAS.name(), data.name(), " WHERE "+ PetugasData.ID_PETUGAS +" = " + idPetugas);
            }
            // akan menghasilkan error jika id petugas tidak ditemukan
            throw new InValidUserDataException("'" +idPetugas + "' ID Petugas tersebut tidak dapat ditemukan.");
        }

        /**
         * Method ini digunakan untuk megedit data dari Petugas berdasarkan ID Petugas yang diinputkan. Sebelum mengedit data
         * method akan mengecek apakah ID Petugas exist atau tidak. Jika ID Petugas tidak exist maka method akan menghasilkan 
         * exception {@code InValidUserDataException}. Tetapi jika ID Petugas exist maka method akan mengedit data dari Petugas
         * dengan menggunakan method {@code setData()} yang ada didalam class {@code Database}. Jika data dari Petugas berhasil 
         * diedit maka method akan mengembalikan nilai <code>True</code>.
         * 
         * @param idPetugas ID Petugas yang ingin diedit datanya.
         * @param data data dari ID Petugas yang ingin diedit.
         * @param newValue nilai baru dari data yang ingin diedit.
         * 
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        private boolean setPetugasData(String idPetugas, PetugasData data, String newValue){
            // mengecek apakah id petugas exist atau tidak
            if(this.isExistPetugas(idPetugas)){
                // mengedit data dari user
                return this.setData(DatabaseTables.PETUGAS.name(), data.name(), PetugasData.ID_PETUGAS.name(), idPetugas, newValue);
            }
            // akan menghasilkan error jika id petugas tidak ditemukan
            throw new InValidUserDataException("'" +idPetugas + "' ID Petugas tersebut tidak dapat ditemukan.");
        }

        /**
         * Method ini digunakan untuk mendapatkan data Nama Petugas berdasarkan ID User dari Petugas yang diinputkan. 
         * ID User dari Petugas yang diinputkan harus sudah terdaftar didalam <b>Database</b>. Jika ID User dari Petugas yang 
         * diinputkan ternyata tidak terdaftar didalam <b>Database</b> maka method akan menghasilkan exception 
         * {@code InValidUserDataException}. Method hanya akan mendapatkan data Nama Petugas jika ID User dari Petugas 
         * yang diinputkan terdaftar didalam <b>Database</b>.
         * 
         * @param idUser ID User dari Petugas yang ingin didapatkan datanya.
         * @return data Nama dari Petugas.
         */
        public String getNama(String idUser) {
            return this.getPetugasData(idUser, PetugasData.NAMA_PETUGAS);
        }
        
        /**
         * Method ini digunakan untuk mendapatkan data Nama Petugas berdasarkan ID User dari Petugas yang sedang 
         * digunakan untuk Login. Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}.
         * Selanjutnya method akan mendapatkan data Nama Petugas melalui method {@code getNama(String idUser)}.
         * Jika user belum melakukan login maka method akan mengembalikan nilai <code>null</code>.
         * 
         * @return data Nama dari akun yang sedang Login.
         */
        public String getNama(){
            return this.getNama(Users.this.getCurrentLogin());
        }

        /**
         * Digunakan untuk mengedit data Nama Petugas berdasarkan ID User dari Petugas yang diinputkan. Sebelum mengedit 
         * data Nama method akan mengecek apakah Nama yang diinputkan valid atau tidak dengan menggunakan 
         * method {@code isNama(String nama)} yang ada didalam class {@code Validation}. Jika Nama tidak valid
         * maka method akan menghasilkan exception {@code InValidUserDataException}.
         * <br><br>
         * Tetapi jika Nama valid maka data Nama dari Petugas akan diedit. Jika data dari Nama berhasil 
         * diedit maka method akan mengembalikan nilai <code>True</code>.
         * 
         * @param idUser ID User yang ingin diedit datanya.
         * @param newNama data Nama yang baru.
         * 
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setNama(String idUser, String newNama) {
            // mengecek nama valid atau tidak
            if(Validation.isNamaOrang(newNama)){
                return this.setPetugasData(idUser, PetugasData.NAMA_PETUGAS, newNama);
            }
            throw new InValidUserDataException("'" + newNama + "' Nama tersebut tidak valid.");
        }
        
        /**
         * Digunakan untuk mengedit data Nama Petugas berdasarkan ID User dari Petugas yang sedang digunakan untuk Login. 
         * Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}. Selanjutnya method 
         * akan mengedit data Nama Petugas melalui method {@code setNama(String idUser, String newNama)}. 
         * Jika output dari method tersebut adalah <code>True</code> maka data Nama dari user berhasil diedit.
         * 
         * @param newNama data Nama yang baru.
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setNama(String newNama){
            return this.setNama(Users.this.getCurrentLogin(), newNama);
        }

        /**
         * Method ini digunakan untuk mendapatkan data Gender Petugas berdasarkan ID User dari Petugas yang diinputkan. 
         * ID User dari Petugas yang diinputkan harus sudah terdaftar didalam <b>Database</b>. Jika ID User dari Petugas yang 
         * diinputkan ternyata tidak terdaftar didalam <b>Database</b> maka method akan menghasilkan exception 
         * {@code InValidUserDataException}. Method hanya akan mendapatkan data Gender Petugas jika ID User dari Petugas 
         * yang diinputkan terdaftar didalam <b>Database</b>.
         * 
         * @param idUser ID User dari Petugas yang ingin didapatkan datanya.
         * @return data Gender dari Petugas.
         */
        public String getGender(String idUser) {
            return this.getPetugasData(idUser, PetugasData.GENDER);
        }
        
        /**
         * Method ini digunakan untuk mendapatkan data Gender Petugas berdasarkan ID User dari Petugas yang sedang 
         * digunakan untuk Login. Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}.
         * Selanjutnya method akan mendapatkan data Gender Petugas melalui method {@code getGender(String idUser)}.
         * Jika user belum melakukan login maka method akan mengembalikan nilai <code>null</code>.
         * 
         * @return data Gender dari akun yang sedang Login.
         */
        public String getGender(){
            return this.getGender(Users.this.getCurrentLogin());
        }

        /**
         * Digunakan untuk mengedit data Gender Petugas berdasarkan ID User dari Petugas yang diinputkan. Sebelum mengedit 
         * data Gender method akan mengecek apakah Gender yang diinputkan valid atau tidak dengan menggunakan 
         * method {@code isGender(String gender)} yang ada didalam class {@code Validation}. Jika Gender tidak valid
         * maka method akan menghasilkan exception {@code InValidUserDataException}.
         * <br><br>
         * Tetapi jika Gender valid maka data Gender dari Petugas akan diedit. Jika data dari Gender berhasil 
         * diedit maka method akan mengembalikan nilai <code>True</code>.
         * 
         * @param idUser ID User yang ingin diedit datanya.
         * @param newGender data Gender yang baru.
         * 
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setGender(String idUser, String newGender) {
            // mengecek apakah gender valid atau tidak
            if(Validation.isGender(newGender)){
                return this.setPetugasData(idUser, PetugasData.GENDER, newGender);
            }
            throw new InValidUserDataException("Gender harus diantara 'L' atau 'P'.");
        }
        
        /**
         * Digunakan untuk mengedit data Gender Petugas berdasarkan ID User dari Petugas yang sedang digunakan untuk Login. 
         * Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}. Selanjutnya method 
         * akan mengedit data Gender Petugas melalui method {@code setGender(String idUser, String newGender)}. 
         * Jika output dari method tersebut adalah <code>True</code> maka data Gender dari user berhasil diedit.
         * 
         * @param newGender data Gender yang baru.
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setGender(String newGender){
            return this.setGender(Users.this.getCurrentLogin(), newGender);
        }

        /**
         * Method ini digunakan untuk mendapatkan data Tempat Lahir Petugas berdasarkan ID User dari Petugas yang diinputkan. 
         * ID User dari Petugas yang diinputkan harus sudah terdaftar didalam <b>Database</b>. Jika ID User dari Petugas yang 
         * diinputkan ternyata tidak terdaftar didalam <b>Database</b> maka method akan menghasilkan exception 
         * {@code InValidUserDataException}. Method hanya akan mendapatkan data Tempat Lahir Petugas jika ID User dari Petugas 
         * yang diinputkan terdaftar didalam <b>Database</b>.
         * 
         * @param idUser ID User dari Petugas yang ingin didapatkan datanya.
         * @return data Tempat Lahir dari Petugas.
         */
        public String getTempatLahir(String idUser) {
            return this.getPetugasData(idUser, PetugasData.TEMPAT_LHR);
        }
        
        /**
         * Method ini digunakan untuk mendapatkan data Tempat Lahir Petugas berdasarkan ID User dari Petugas yang sedang 
         * digunakan untuk Login. Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}.
         * Selanjutnya method akan mendapatkan data Tempat Lahir Petugas melalui method {@code getTempatLahir(String idUser)}.
         * Jika user belum melakukan login maka method akan mengembalikan nilai <code>null</code>.
         * 
         * @return data Tempat Lahir dari akun yang sedang Login.
         */
        public String getTempatLahir(){
            return this.getTempatLahir(Users.this.getCurrentLogin());
        }
        
        /**
         * Digunakan untuk mengedit data Tempat Lahir Petugas berdasarkan ID User dari Petugas yang diinputkan. Sebelum mengedit 
         * data Tempat Lahir method akan mengecek apakah Tempat Lahir yang diinputkan valid atau tidak dengan menggunakan 
         * method {@code isNamaTempat(String namaTempat)} yang ada didalam class {@code Validation}. Jika Tempat Lahir tidak valid
         * maka method akan menghasilkan exception {@code InValidUserDataException}.
         * <br><br>
         * Tetapi jika Tempat Lahir valid maka data Tempat Lahir dari Petugas akan diedit. Jika data dari Tempat Lahir berhasil 
         * diedit maka method akan mengembalikan nilai <code>True</code>.
         * 
         * @param idUser ID User yang ingin diedit datanya.
         * @param newTempatLahir data Tempat Lahir yang baru.
         * 
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setTempatLahir(String idUser, String newTempatLahir) {
            // mengecek tempat lahir valid atau tidak
            if(Validation.isNamaTempat(newTempatLahir)){
                return this.setPetugasData(idUser, PetugasData.TEMPAT_LHR, newTempatLahir);
            }
            throw new InValidUserDataException("Tempat Lahir yang Anda masukan tidak valid.");
        }
        
        /**
         * Digunakan untuk mengedit data Tempat Lahir Petugas berdasarkan ID User dari Petugas yang sedang digunakan untuk Login. 
         * Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}. Selanjutnya method 
         * akan mengedit data Tempat Lahir Petugas melalui method {@code setTempatLahir(String idUser, String newTempatLahir)}. 
         * Jika output dari method tersebut adalah <code>True</code> maka data TempatLahir dari user berhasil diedit.
         * 
         * @param newTempatLahir data Tempat Lahir yang baru.
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setTempatLahir(String newTempatLahir){
            return this.setTempatLahir(Users.this.getCurrentLogin(), newTempatLahir);
        }

        /**
         * Method ini digunakan untuk mendapatkan data Tanggal Lahir Petugas berdasarkan ID User dari Petugas yang diinputkan. 
         * ID User dari Petugas yang diinputkan harus sudah terdaftar didalam <b>Database</b>. Jika ID User dari Petugas yang 
         * diinputkan ternyata tidak terdaftar didalam <b>Database</b> maka method akan menghasilkan exception 
         * {@code InValidUserDataException}. Method hanya akan mendapatkan data Tanggal Lahir Petugas jika ID User dari Petugas 
         * yang diinputkan terdaftar didalam <b>Database</b>.
         * 
         * @param idUser ID User dari Petugas yang ingin didapatkan datanya.
         * @return data Tanggal Lahir dari Petugas.
         */
        public String getTanggalLahir(String idUser) {
            return this.getPetugasData(idUser, PetugasData.TANGGAL_LHR);
        }
        
        /**
         * Method ini digunakan untuk mendapatkan data Tanggal Lahir Petugas berdasarkan ID User dari Petugas yang sedang 
         * digunakan untuk Login. Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}.
         * Selanjutnya method akan mendapatkan data Tanggal Lahir Petugas melalui method {@code getTanggalLahir(String idUser)}.
         * Jika user belum melakukan login maka method akan mengembalikan nilai <code>null</code>.
         * 
         * @return data Tanggal Lahir dari akun yang sedang Login.
         */
        public String getTanggalLahir(){
            return this.getTanggalLahir(Users.this.getCurrentLogin());
        }

        /**
         * Digunakan untuk mengedit data Tanggal Lahir Petugas berdasarkan ID User dari Petugas yang diinputkan. Sebelum mengedit 
         * data Tanggal Lahir method akan mengecek apakah Tanggal Lahir yang diinputkan valid atau tidak dengan menggunakan 
         * method {@code isTanggalLahir(String tanggalLahir)} yang ada didalam class {@code Validation}. Jika Tanggal Lahir tidak valid
         * maka method akan menghasilkan exception {@code InValidUserDataException}.
         * <br><br>
         * Tetapi jika Tanggal Lahir valid maka data Tanggal Lahir dari Petugas akan diedit. Jika data dari Tanggal Lahir berhasil 
         * diedit maka method akan mengembalikan nilai <code>True</code>.
         * 
         * @param idUser ID User yang ingin diedit datanya.
         * @param newTanggalLahir data Tanggal Lahir yang baru.
         * 
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setTanggalLahir(String idUser, String newTanggalLahir) {
            // mengecek tanggal lahir valid atau tidak
            if(Validation.isTanggalLahir(newTanggalLahir)){
                return this.setPetugasData(idUser, PetugasData.TANGGAL_LHR, newTanggalLahir);
            }
            throw new InValidUserDataException("Tanggal Lahir yang Anda masukan tidak valid.");
        }
        
        /**
         * Digunakan untuk mengedit data Tanggal Lahir Petugas berdasarkan ID User dari Petugas yang sedang digunakan untuk Login. 
         * Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}. Selanjutnya method 
         * akan mengedit data Tanggal Lahir Petugas melalui method {@code setTanggalLahir(String idUser, String newTanggalLahir)}. 
         * Jika output dari method tersebut adalah <code>True</code> maka data Tanggal Lahir dari user berhasil diedit.
         * 
         * @param newTanggalLahir data Tanggal Lahir yang baru.
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setTanggalLahir(String newTanggalLahir){
            return this.setTanggalLahir(Users.this.getCurrentLogin(), newTanggalLahir);
        }

        /**
         * Method ini digunakan untuk mendapatkan data Alamat Petugas berdasarkan ID User dari Petugas yang diinputkan. 
         * ID User dari Petugas yang diinputkan harus sudah terdaftar didalam <b>Database</b>. Jika ID User dari Petugas yang 
         * diinputkan ternyata tidak terdaftar didalam <b>Database</b> maka method akan menghasilkan exception 
         * {@code InValidUserDataException}. Method hanya akan mendapatkan data Alamat Petugas jika ID User dari Petugas 
         * yang diinputkan terdaftar didalam <b>Database</b>.
         * 
         * @param idUser ID User dari Petugas yang ingin didapatkan datanya.
         * @return data Alamat dari Petugas.
         */
        public String getAlamat(String idUser) {
            return this.getPetugasData(idUser, PetugasData.ALAMAT);
        }
        
        /**
         * Method ini digunakan untuk mendapatkan data Alamat Petugas berdasarkan ID User dari Petugas yang sedang 
         * digunakan untuk Login. Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}.
         * Selanjutnya method akan mendapatkan data Alamat Petugas melalui method {@code getAlamat(String idUser)}.
         * Jika user belum melakukan login maka method akan mengembalikan nilai <code>null</code>.
         * 
         * @return data Alamat dari akun yang sedang Login.
         */
        public String getAlamat(){
            return this.getAlamat(Users.this.getCurrentLogin());
        }

        /**
         * Digunakan untuk mengedit data Alamat Petugas berdasarkan ID User dari Petugas yang diinputkan. Sebelum mengedit 
         * data Alamat method akan mengecek apakah Alamat yang diinputkan valid atau tidak dengan menggunakan 
         * method {@code isNamaTempat(String isNamaTempat)} yang ada didalam class {@code Validation}. Jika Alamat tidak valid
         * maka method akan menghasilkan exception {@code InValidUserDataException}.
         * <br><br>
         * Tetapi jika Alamat valid maka data Alamat dari Petugas akan diedit. Jika data dari Alamat berhasil 
         * diedit maka method akan mengembalikan nilai <code>True</code>.
         * 
         * @param idUser ID User yang ingin diedit datanya.
         * @param newAlamat data Alamat yang baru.
         * 
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setAlamat(String idUser, String newAlamat) {
            // mengecek apakah alamat valid atau tidak
            if(Validation.isNamaTempat(newAlamat)){
                return this.setPetugasData(idUser, PetugasData.ALAMAT, newAlamat);
            }
            throw new InValidUserDataException("Alamat yang Anda masukan tidak valid.");
        }
        
        /**
         * Digunakan untuk mengedit data Alamat Petugas berdasarkan ID User dari Petugas yang sedang digunakan untuk Login. 
         * Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}. Selanjutnya method 
         * akan mengedit data Alamat Petugas melalui method {@code setAlamat(String idUser, String newAlamat)}. 
         * Jika output dari method tersebut adalah <code>True</code> maka data Alamat dari user berhasil diedit.
         * 
         * @param newAlamat data Alamat yang baru.
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setAlamat(String newAlamat){
            return this.setAlamat(Users.this.getCurrentLogin(), newAlamat);
        }
        
        /**
         * Digunakan untuk menutup koneksi dari <B>Database</B> MySQL. Koneksi dari <B>Database</B> perlu ditutup jika sudah 
         * tidak digunakan lagi. Sebelum menutup koneksi dari <B>Database</B> method akan mengecek apakah object {@code Connection},
         * {@code Statement} dan {@code ResultSet} kosong atau tidak. Jika tidak maka koneksi dari <B>Database</B> akan ditutup. 
         * Jika tidak dicek kosong atau tidaknya object maka saat objek kosong lalu dipaksa untuk menutup koneksi dari <B>Database</B>
         * maka akan menimbulkan exception {@code NullPointerException}.
         */
        @Override
        public void closeConnection(){
            // menutup koneksi dari object Users
            Users.this.closeConnection();
            // menutup koneksi dari object Level Petugas
            Users.this.closeConnection();
        }

    }
    
    /**
     * 
     * @author Achmad Baihaqi
     * @since 2021-06-14
     */
    public class LevelSiswa extends Users{
        
        /**
         * Method ini digunakan untuk menambahkan data dari User dan Siswa yang diinputkan kedalam <b>Database MySQL</b>.
         * Method akan mengembalikan nilai <code>True</code> jika data dari User dan Siswa berhasil ditambahkan kedalam 
         * <b>Database</b>. Jika ada salah satu data yang gagal ditambahkan kedalam <b>Database</b> maka method akan 
         * mengembalikan nilai <code>False</code>
         * <br><br>
         * Pertama-tama method akan menambahkan data dari User kedalam <b>Database</b>. Data dari User akan ditambahkan ke 
         * dalam <b>Database</b> dengan melalui method {@code addUser()} yang ada didalam class {@code Users}. Jika data 
         * dari User berhasil ditambahkan kedalam <b>Database</b> maka selanjutnya method akan menambahkan data Siswa 
         * kedalam <b>Database</b>
         * <br><br>
         * Sebelum menambahkan data Siswa kedalam <b>Database</b> method akan mengecek apakah semua data dari Siswa
         * yang diinputkan valid atau tidak. Jika ada salah satu data dari Siswa yang tidak valid maka data Siswa tidak akan 
         * ditambahkan kedalam <b>Database</b> dan data User yang sebelumnya sudah ditambahkan akan dihapus melalui method 
         * {@code deleteUser} yang ada didalam class {@code} Users. 
         * <br><br>
         * Jika semua data dari Siswa valid maka method akan membuat sebuah object {@code PreparedStatement} yang digunakan 
         * untuk menambahkan data Siswa kedalam <b>Database</b>. Setelah object dari class {@code PreparedStatement} berhasil 
         * dibuat selanjutnya method akan menambahkan semua data dari Siswa kedalam object {@code PreparedStatement}. 
         * <br><br>
         * Jika semua data dari Siswa sudah ditambahkan kedalam object {@code PreparedStatement} maka data dari Siswa tersebut 
         * akan ditambahkan kedalam <b>Database</b> melalui method {@code executeUpdate()} yang ada didalam class 
         * {@code PreparedStatement}. Jika data Siswa berhasil ditambahkan kedalam <b>Database</b> maka method akan megembalikan 
         * nilai <code>True</code>.
         * 
         * @param idUser id user dari user atau siswa.
         * @param noHP no hp dari user atau siswa.
         * @param email email dari user atau siswa.
         * @param profile foto profile dari user atau siswa.
         * @param nama nama dari user atau siswa.
         * @param gender gender dari user atau siswa.
         * @param tempatLahir tampat lahir dari user atau siswa.
         * @param tanggalLahir tanggal lahirdari user atau siswa.
         * @param alamat alamat dari user atau siswa.
         * @param idKelas id kelas dari user atau siswa.
         * @param namaWali id kelas dari user atau siswa.
         * @param idSpp id spp dari user atau siswa.
         * 
         * @return <strong>True</strong> jika data berhasil ditambahkan. <br>
         *         <strong>False</strong> jika data tidak berhasil ditambahkan. 
         * 
         * @throws FileNotFoundException jika terjadi kegagalan saat menkonversi foto profile kedalam byte stream / Blob.
         * @throws SQLException jika terjadi kegagalan saat menambahkan data kedalam <b>Database</b>.
         * @throws InValidUserDataException jika data dari siswa tidak valid.
         */
        public final boolean addSiswa(String idUser, String noHP, String email, File profile, 
                                      String nama, String gender, String tempatLahir, String tanggalLahir, String alamat, String idKelas, String namaWali, int idSpp) 
                throws FileNotFoundException, SQLException, InValidUserDataException
        {
            PreparedStatement pst;
            boolean addUser, addSiswa = false;
            
            Log.addLog("Mentransfer data '" + idUser + "/" + nama + "' ke Database.");
            
            // menambahkan data user ke database
            addUser = Users.this.addUser(idUser, noHP, email, profile, "Siswa"+idUser, UserLevels.SISWA);
            
            // jika data user berhasil ditambahkan maka data siswa akan ditambahkan kedalam database
            if(addUser){
                // mengecek apakah data siswa valid atau tidak
                Log.addLog("Mengecek data '" + idUser + "/" + nama + " valid atau tidak.");
                if(this.validateDataSiswa(idUser, nama, gender, tempatLahir, tanggalLahir, alamat, idKelas, namaWali, idSpp)){
                    
                    Log.addLog("Data dari '" + idUser + "/" + nama + "' valid.");
                    Log.addLog("Menambahkan data dari '"+ idUser + "/" + nama + "' ke Database.");
                    
                    // menambahkan data siswa kedalam database
                    pst = Users.this.conn.prepareStatement("INSERT INTO siswa VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
                    pst.setString(1, idUser);
                    pst.setString(2, nama);
                    pst.setString(3, gender);
                    pst.setString(4, tempatLahir);
                    pst.setString(5, tanggalLahir);
                    pst.setString(6, alamat);
                    pst.setString(7, idKelas);
                    pst.setString(8, namaWali);
                    pst.setInt(9, idSpp);
                    // mengeksekusi query
                    addSiswa = pst.executeUpdate() > 0;
                    Log.addLog("Data Berhasil ditambahkan.");
                }
            }
            
            // jika data siswa berhasil ditambahakan maka method akan mengembalikan nilai true
            if(addSiswa){
                Log.addLog("Data dari '" + idUser + "/" + nama + "' berhasil ditransfer.");
                return true;
            }else{
                // jika data siswa tidak berhasil ditambahkan maka data user akan dihapus
                Users.this.deleteUser(idUser);
                return false;
            }
        }
        
        /**
         * Method ini digunakan untuk mengecek apakah semua data dari Siswa yang diinputkan valid atau tidak.
         * Method akan mengecek satu persatu data dari Petugas. Jika ada salah satu data saja yang tidak valid maka 
         * semua data dari Siswa yang di inputkan akan dianggap tidak valid dan method akan mengembalikan nilai 
         * <code>False</code>. Method hanya akan mengembalikan nilai <code>True</code> jika semua data dari 
         * Siswa yang diinputkan valid.
         * 
         * @param level level yang akan dicek.
         * @param nama nama level yang akan dicek.
         * @param gender gender level yang akan dicek.
         * @param tempatLahir tempat lahir level yang akan dicek.
         * @param tanggalLahir tanggal lahir level yang akan dicek.
         * @param alamat alamat level yang akan dicek.
         * @param idKelas id kelas yang akan dicek.
         * @param namaWali nama wali yang akan dicek.
         * @param idSpp id spp yang akan dicek.
         * 
         * @return <strong>True</strong> jika semua data dari Siswa valid. <br>
         *         <strong>False</strong> jika ada salah satu data dari Siswa yang tidak valid.
         */
        private boolean validateDataSiswa(String nis, String nama, String gender, String tempatLahir, String tanggalLahir, String alamat, String idKelas, String namaWali, int idSpp){
            
            boolean vNis, vNama, vGender, vTmpLhr, vTglLhr, vAlamat, vIdKelas, vNamaWali, vIdSpp;
            
            // mengecek nis valid atau tidak
            if(Validation.isNis(Integer.parseInt(nis))){
                // mengecek nis sudah terpakai atau belulm
                if(!this.isExistSiswa(nis)){
                    vNis = true;
                }else{
                    throw new InValidUserDataException("'" + nis + "' NIS tersebut sudah terpakai.");
                }
            }else{
                throw new InValidUserDataException("'" + nis + "' NIS tersebut tidak valid.");
            }
            
            // mengecek nama petugas valid atau tidak
            if(Validation.isNamaOrang(nama)){
                vNama = true;
            }else{
                throw new InValidUserDataException("'" + nama + "' Nama tersebut tidak valid.");
            }                
            
            // mengecek gender valid atau tidak
            if(Validation.isGender(gender)){
                vGender = true;
            }else{
                throw new InValidUserDataException("Gender harus diantara 'L' atau 'P'");
            }
            
            // mengecek tempat lahir valid atau tidak            
            if(Validation.isNamaTempat(tempatLahir)){
                vTmpLhr = true;
            }else{
                throw new InValidUserDataException("Tempat Lahir tidak valid.");
            }
            
            // mengecek tanggal lahir valid atau tidak
            if(Validation.isTanggalLahir(tanggalLahir)){
                vTglLhr = true;
            }else{
                throw new InValidUserDataException("Tanggal Lahir tidak valid.");
            }

            // megecek apakah alamat valid atau tidak
            if(Validation.isNamaTempat(alamat)){
                vAlamat = true;
            }else{
                throw new InValidUserDataException("Alamat tidak valid.");
            }
            
            // mengecek apakah id kelas valid atau tidak
            if(Validation.isIdKelas(idKelas)){
                vIdKelas = true;
            }else{
                throw new InValidUserDataException("ID Kelas tidak valid.");
            }

            // mengecek apakah nama wali valid atau tidak
            if(namaWali.length() >= 4){
                vNamaWali = true;
            }else{
                throw new InValidUserDataException("Nama Wali tidak valid.");
            }

            // mengecek apakah id spp valid atau tidak
            if(Validation.isIdSpp(idSpp)){
                vIdSpp = true;
            }else{
                throw new InValidUserDataException("ID SPP tidak valid.");
            }
            
            return vNis && vNama && vGender && vTmpLhr && vTglLhr && vAlamat && vIdKelas && vNamaWali && vIdSpp;
        }
        
        /**
         * Method ini digunakan untuk menghapus sebuah akun Siswa yang tersimpan didalam tabel <code>users</code> dan 
         * tabel <code>siswa</code> yang ada didalam <b>Database</b> berdasarkan id user yang diinputkan. Method akan menghapus 
         * data akun Siswa yang ada didalam tabel <code>users</code> dengan melalui method {@code deleteUser()} yang ada 
         * didalam class {@code Users}.
         * <br><br>
         * Method akan menghapus data akun Siswa yang ada didalam tabel <code>siswa</code> dengan menggunakan method
         * {@code deleteData()} yang ada didalam class {@code Database}. Jika kedua data Siswa yang ada didalam tabel 
         * <code>users</code> dan tabel <code>siswa</code> berhasil dihapus maka method akan mengembalikan nilai <code>True</code>s
         * 
         * @param idUser id dari user yang ingin dihapus.
         * @return <strong>True</strong> jika akun berhasil dihapus. <br>
         *         <strong>False</strong> jiak akun tidak berhasil dihapus.
         */
        public final boolean deleteSiswa(String idUser){
            return Users.this.deleteUser(idUser) && 
                   Users.this.deleteData(DatabaseTables.SISWA.name(), SiswaData.NIS.name(), idUser);
        }
        
        /**
         * Method ini digunakan untuk mengecek apakah sebuah ID User dari Siswa sudah exist atau belum didalam 
         * <b>Database</b>. Method akan mengembalikan nilai <code>True</code> jika ID User dari Siswa exist didalam 
         * tabel <code>users</code> dan tabel <code>siswa</code> yang ada didalam <b>Database</b>. Pertama-tama method 
         * akan mengecek apakah ID User dari Siswa exist atau tidak didalam tabel <code>users</code> yang ada didalam 
         * <b>Database</b>. 
         * <br><br>
         * Jika ID User tidak exist maka method akan mengembalikan nilai <code>False</code>. Selanjutnya method akan mengecek 
         * apakah ID User dari Siswa valid atau tidak dengan menggunakan method {@code isIdNis()} yang ada didalam 
         * class {@code Validation}. Jika ID User dari Siswa tidak valid maka method akan menghasilkan exception 
         * {@code InValidUserDataException}.
         * <br><br>
         * Jika ID User dari Siswa valid maka method akan mengecek apakah sebuah ID User dari Siswa exist atau tidak didalam 
         * tabel <code>siswa</code> yang ada didalam <b>Database</b> dengan menggunakan method {@code isExistData()} 
         * yang ada didalam class {@code Database}. Jika output dari method tersebut adalah <code>True</code> maka 
         * ID User dari Siswa dinyatakan exist dan method akan mengembalikan nilai <code>True</code>.
         * 
         * @param idUser ID User dari Siswa yang akan dicek.
         * @return <strong>True</strong> jika ID User dari Siswa exist. <br>
         *         <strong>False</strong> jika ID User dari Siswa tidak exist.
         */
        @Deprecated
        public final boolean isExistSiswa(String idUser){
            // mengecek apakah id siswa valid atau tidak
            if(Validation.isNis(Integer.parseInt(idUser))){
                // mengecek apakah id siswa exist atau tidak
                return super.isExistData(DatabaseTables.SISWA.name(), SiswaData.NIS.name(), idUser);
            }
            return false;
        }
        
        /**
         * Method ini akan mengembalikan data dari Siswa berdasarkan NIS yang diinputkan. Pertama-tama method 
         * akan mengecek apakah NIS exist atau tidak. Jika NIS tidak exist maka method akan menghasilkan exception 
         * {@code InValidUserDataException}. Tetapi jika NIS exist maka data dari Siswa akan didapatkan dengan 
         * melalui method {@code getData()} yang ada didalam class {@code Database}.
         * 
         * @param idPetugas NIS yang ingin diambil datanya.
         * @param data data yang ingin diambil.
         * @return akan mengembalikan data dari Siswa berdasarkan NIS yang diinputkan.
         */
        private String getSiswaData(String nis, SiswaData data){
            // mengecek apakah nis exist atau tidak
            if(this.isExistSiswa(nis)){
                // mendapatkan data dari siswa
                return Users.this.getData(DatabaseTables.SISWA.name(), data.name(), " WHERE "+ SiswaData.NIS.name() +" = " + nis);
            }
            // akan menghasilkan error jika nis tidak ditemukan
            throw new InValidUserDataException("'" + nis + "' NIS tersebut tidak dapat ditemukan.");
        }

        /**
         * Method ini digunakan untuk megedit data dari Siswa berdasarkan NIS yang diinputkan. Sebelum mengedit data
         * method akan mengecek apakah NIS exist atau tidak. Jika NIS tidak exist maka method akan menghasilkan 
         * exception {@code InValidUserDataException}. Tetapi jika NIS exist maka method akan mengedit data dari Siswa
         * dengan menggunakan method {@code setData()} yang ada didalam class {@code Database}. Jika data dari Siswa berhasil 
         * diedit maka method akan mengembalikan nilai <code>True</code>.
         * 
         * @param idPetugas NIS yang ingin diedit datanya.
         * @param data data dari NIS yang ingin diedit.
         * @param newValue nilai baru dari data yang ingin diedit.
         * 
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        private boolean setSiswaData(String nis, SiswaData data, String newValue){
            // mengecek apakah nis exist atau tidak
            if(this.isExistSiswa(nis)){
                // mengedit data dari siswa
                return Users.this.setData(DatabaseTables.SISWA.name(), data.name(), SiswaData.NIS.name(), nis, newValue);
            }
            // akan menghasilkan error jika nis tidak ditemukan
            throw new InValidUserDataException("'" + nis + "' NIS tersebut tidak dapat ditemukan.");
        }

        /**
         * Method ini digunakan untuk mendapatkan data Nama Siswa berdasarkan ID User dari Siswa yang diinputkan. 
         * ID User dari Siswa yang diinputkan harus sudah terdaftar didalam <b>Database</b>. Jika ID User dari Siswa yang 
         * diinputkan ternyata tidak terdaftar didalam <b>Database</b> maka method akan menghasilkan exception 
         * {@code InValidUserDataException}. Method hanya akan mendapatkan data Nama Siswa jika ID User dari Siswa 
         * yang diinputkan terdaftar didalam <b>Database</b>.
         * 
         * @param idUser ID User dari Siswa yang ingin didapatkan datanya.
         * @return data Nama dari Siswa.
         */
        public String getNama(String idUser) {
            return this.getSiswaData(idUser, SiswaData.NAMA_SISWA);
        }
        
        /**
         * Method ini digunakan untuk mendapatkan data Nama Siswa berdasarkan ID User dari Petugas yang sedang 
         * digunakan untuk Login. Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}.
         * Selanjutnya method akan mendapatkan data Nama Siswa melalui method {@code getNama(String idUser)}.
         * Jika user belum melakukan login maka method akan mengembalikan nilai <code>null</code>.
         * 
         * @return data Nama dari akun yang sedang Login.
         */
        public String getNama(){
            return this.getNama(Users.this.getCurrentLogin());
        }

        /**
         * Digunakan untuk mengedit data Nama Siswa berdasarkan ID User dari Siswa yang diinputkan. Sebelum mengedit 
         * data Nama method akan mengecek apakah Nama yang diinputkan valid atau tidak dengan menggunakan 
         * method {@code isNama(String nama)} yang ada didalam class {@code Validation}. Jika Nama tidak valid
         * maka method akan menghasilkan exception {@code InValidUserDataException}.
         * <br><br>
         * Tetapi jika Nama valid maka data Nama dari Siswa akan diedit. Jika data dari Nama berhasil 
         * diedit maka method akan mengembalikan nilai <code>True</code>.
         * 
         * @param idUser ID User yang ingin diedit datanya.
         * @param newNama data Nama yang baru.
         * 
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setNama(String idUser, String newNama) {
            // mengecek nama valid atau tidak
            if(Validation.isNamaOrang(newNama)){
                return this.setSiswaData(idUser, SiswaData.NAMA_SISWA, newNama);
            }
            throw new InValidUserDataException("'" + newNama + "' Nama tersebut tidak valid.");
        }
        
        /**
         * Digunakan untuk mengedit data Nama Siswa berdasarkan ID User dari Siswa yang sedang digunakan untuk Login. 
         * Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}. Selanjutnya method 
         * akan mengedit data Nama Siswa melalui method {@code setNama(String idUser, String newNama)}. 
         * Jika output dari method tersebut adalah <code>True</code> maka data Nama dari user berhasil diedit.
         * 
         * @param newNama data Nama yang baru.
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setNama(String newNama){
            return this.setNama(Users.this.getCurrentLogin(), newNama);
        }

        /**
         * Method ini digunakan untuk mendapatkan data Gender Siswa berdasarkan ID User dari Siswa yang diinputkan. 
         * ID User dari Siswa yang diinputkan harus sudah terdaftar didalam <b>Database</b>. Jika ID User dari Siswa yang 
         * diinputkan ternyata tidak terdaftar didalam <b>Database</b> maka method akan menghasilkan exception 
         * {@code InValidUserDataException}. Method hanya akan mendapatkan data Gender Siswa jika ID User dari Siswa 
         * yang diinputkan terdaftar didalam <b>Database</b>.
         * 
         * @param idUser ID User dari Siswa yang ingin didapatkan datanya.
         * @return data Gender dari Siswa.
         */
        public String getGender(String idUser) {
            return this.getSiswaData(idUser, SiswaData.GENDER);
        }
        
        /**
         * Method ini digunakan untuk mendapatkan data Gender Siswa berdasarkan ID User dari Petugas yang sedang 
         * digunakan untuk Login. Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}.
         * Selanjutnya method akan mendapatkan data Gender Siswa melalui method {@code getGender(String idUser)}.
         * Jika user belum melakukan login maka method akan mengembalikan nilai <code>null</code>.
         * 
         * @return data Gender dari akun yang sedang Login.
         */
        public String getGender(){
            return this.getGender(Users.this.getCurrentLogin());
        }

        /**
         * Digunakan untuk mengedit data Gender Siswa berdasarkan ID User dari Siswa yang diinputkan. Sebelum mengedit 
         * data Gender method akan mengecek apakah Gender yang diinputkan valid atau tidak dengan menggunakan 
         * method {@code isGender(String gender)} yang ada didalam class {@code Validation}. Jika Gender tidak valid
         * maka method akan menghasilkan exception {@code InValidUserDataException}.
         * <br><br>
         * Tetapi jika Gender valid maka data Gender dari Siswa akan diedit. Jika data dari Gender berhasil 
         * diedit maka method akan mengembalikan nilai <code>True</code>.
         * 
         * @param idUser ID User yang ingin diedit datanya.
         * @param newGender data Gender yang baru.
         * 
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setGender(String idUser, String newGender) {
            // mengecek apakah gender valid atau tidak
            if(Validation.isGender(newGender)){
                return this.setSiswaData(idUser, SiswaData.GENDER, newGender);
            }
            throw new InValidUserDataException("Gender harus diantara 'L' atau 'P'.");
        }
        
        /**
         * Digunakan untuk mengedit data Gender Siswa berdasarkan ID User dari Siswa yang sedang digunakan untuk Login. 
         * Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}. Selanjutnya method 
         * akan mengedit data Gender Siswa melalui method {@code setGender(String idUser, String newGender)}. 
         * Jika output dari method tersebut adalah <code>True</code> maka data Nama dari user berhasil diedit.
         * 
         * @param newGender data Gender yang baru.
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setGender(String newGender){
            return this.setGender(Users.this.getCurrentLogin(), newGender);
        }
        
        /**
         * Method ini digunakan untuk mendapatkan data Tempat Lahir Siswa berdasarkan ID User dari Siswa yang diinputkan. 
         * ID User dari Siswa yang diinputkan harus sudah terdaftar didalam <b>Database</b>. Jika ID User dari Siswa yang 
         * diinputkan ternyata tidak terdaftar didalam <b>Database</b> maka method akan menghasilkan exception 
         * {@code InValidUserDataException}. Method hanya akan mendapatkan data Tempat Lahir Siswa jika ID User dari Siswa 
         * yang diinputkan terdaftar didalam <b>Database</b>.
         * 
         * @param idUser ID User dari Siswa yang ingin didapatkan datanya.
         * @return data Tempat Lahir dari Siswa.
         */
        public String getTempatLahir(String idUser) {
            return this.getSiswaData(idUser, SiswaData.TEMPAT_LHR);
        }
        
        /**
         * Method ini digunakan untuk mendapatkan data Tempat Lahir Siswa berdasarkan ID User dari Petugas yang sedang 
         * digunakan untuk Login. Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}.
         * Selanjutnya method akan mendapatkan data TempatLahir Siswa melalui method {@code getTempatLahir(String idUser)}.
         * Jika user belum melakukan login maka method akan mengembalikan nilai <code>null</code>.
         * 
         * @return data Tempat Lahir dari akun yang sedang Login.
         */
        public String getTempatLahir(){
            return this.getTempatLahir(Users.this.getCurrentLogin());
        }

        /**
         * Digunakan untuk mengedit data Tempat Lahir Siswa berdasarkan ID User dari Siswa yang diinputkan. Sebelum mengedit 
         * data Tempat Lahir method akan mengecek apakah Tempat Lahir yang diinputkan valid atau tidak dengan menggunakan 
         * method {@code isNamaTempat(String namaTempat)} yang ada didalam class {@code Validation}. Jika Tempat Lahir tidak valid
         * maka method akan menghasilkan exception {@code InValidUserDataException}.
         * <br><br>
         * Tetapi jika Tempat Lahir valid maka data Tempat Lahir dari Siswa akan diedit. Jika data dari Tempat Lahir berhasil 
         * diedit maka method akan mengembalikan nilai <code>True</code>.
         * 
         * @param idUser ID User yang ingin diedit datanya.
         * @param newTempatLahir data Tempat Lahir yang baru.
         * 
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setTempatLahir(String idUser, String newTempatLahir) {
            // mengecek tempat lahir valid atau tidak
            if(Validation.isNamaTempat(newTempatLahir)){
                return this.setSiswaData(idUser, SiswaData.TEMPAT_LHR, newTempatLahir);
            }
            throw new InValidUserDataException("Tempat Lahir yang Anda masukan tidak valid.");
        }
        
        /**
         * Digunakan untuk mengedit data Tempat Lahir Siswa berdasarkan ID User dari Siswa yang sedang digunakan untuk Login. 
         * Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}. Selanjutnya method 
         * akan mengedit data Tempat Lahir Siswa melalui method {@code setTempatLahir(String idUser, String new[TempatLahir)}. 
         * Jika output dari method tersebut adalah <code>True</code> maka data Nama dari user berhasil diedit.
         * 
         * @param newTempatLahir data TempatLahir yang baru.
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setTempatLahir(String newTempatLahir){
            return this.setTempatLahir(Users.this.getCurrentLogin(), newTempatLahir);
        }

        /**
         * Method ini digunakan untuk mendapatkan data Tanggal Lahir Siswa berdasarkan ID User dari Siswa yang diinputkan. 
         * ID User dari Siswa yang diinputkan harus sudah terdaftar didalam <b>Database</b>. Jika ID User dari Siswa yang 
         * diinputkan ternyata tidak terdaftar didalam <b>Database</b> maka method akan menghasilkan exception 
         * {@code InValidUserDataException}. Method hanya akan mendapatkan data Tanggal Lahir Siswa jika ID User dari Siswa 
         * yang diinputkan terdaftar didalam <b>Database</b>.
         * 
         * @param idUser ID User dari Siswa yang ingin didapatkan datanya.
         * @return data Tanggal Lahir dari Siswa.
         */
        public String getTanggalLahir(String idUser) {
            return this.getSiswaData(idUser, SiswaData.TANGGAL_LHR);
        }
        
        /**
         * Method ini digunakan untuk mendapatkan data Tanggal Lahir Siswa berdasarkan ID User dari Petugas yang sedang 
         * digunakan untuk Login. Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}.
         * Selanjutnya method akan mendapatkan data Tanggal Lahir Siswa melalui method {@code getTanggalLahir(String idUser)}.
         * Jika user belum melakukan login maka method akan mengembalikan nilai <code>null</code>.
         * 
         * @return data Tanggal Lahir dari akun yang sedang Login.
         */
        public String getTanggalLahir(){
            return this.getTanggalLahir(Users.this.getCurrentLogin());
        }

        /**
         * Digunakan untuk mengedit data Tanggal Lahir Siswa berdasarkan ID User dari Siswa yang diinputkan. Sebelum mengedit 
         * data Tanggal Lahir method akan mengecek apakah Tanggal Lahir yang diinputkan valid atau tidak dengan menggunakan 
         * method {@code isTanggalLahir(String tanggaLahir)} yang ada didalam class {@code Validation}. Jika Tanggal Lahir tidak valid
         * maka method akan menghasilkan exception {@code InValidUserDataException}.
         * <br><br>
         * Tetapi jika Tanggal Lahir valid maka data Tanggal Lahir dari Siswa akan diedit. Jika data dari Tanggal Lahir berhasil 
         * diedit maka method akan mengembalikan nilai <code>True</code>.
         * 
         * @param idUser ID User yang ingin diedit datanya.
         * @param newTanggalLahir data TanggalLahir yang baru.
         * 
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setTanggalLahir(String idUser, String newTanggalLahir) {
            // mengecek apakah tanggal lahir valid atau tidak
            if(Validation.isTanggalLahir(newTanggalLahir)){
                return this.setSiswaData(idUser, SiswaData.TANGGAL_LHR, newTanggalLahir);
            }
            throw new InValidUserDataException("Tanggal Lahir yang Anda masukan tidak valid.");
        }
        
        /**
         * Digunakan untuk mengedit data Tanggal Lahir Siswa berdasarkan ID User dari Siswa yang sedang digunakan untuk Login. 
         * Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}. Selanjutnya method 
         * akan mengedit data Tanggal Lahir Siswa melalui method {@code setTanggalLahir](String idUser, String newTanggalLahir)}. 
         * Jika output dari method tersebut adalah <code>True</code> maka data Nama dari user berhasil diedit.
         * 
         * @param newTanggalLahir data Tanggal Lahir yang baru.
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setTanggalLahir(String newTanggalLahir){
            return this.setTanggalLahir(Users.this.getCurrentLogin(), newTanggalLahir);
        }

        /**
         * Method ini digunakan untuk mendapatkan data Alamat Siswa berdasarkan ID User dari Siswa yang diinputkan. 
         * ID User dari Siswa yang diinputkan harus sudah terdaftar didalam <b>Database</b>. Jika ID User dari Siswa yang 
         * diinputkan ternyata tidak terdaftar didalam <b>Database</b> maka method akan menghasilkan exception 
         * {@code InValidUserDataException}. Method hanya akan mendapatkan data Alamat Siswa jika ID User dari Siswa 
         * yang diinputkan terdaftar didalam <b>Database</b>.
         * 
         * @param idUser ID User dari Siswa yang ingin didapatkan datanya.
         * @return data Alamat dari Siswa.
         */
        public String getAlamat(String idUser) {
            return this.getSiswaData(idUser, SiswaData.ALAMAT);
        }
        
        /**
         * Method ini digunakan untuk mendapatkan data Alamat Siswa berdasarkan ID User dari Petugas yang sedang 
         * digunakan untuk Login. Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}.
         * Selanjutnya method akan mendapatkan data Alamat Siswa melalui method {@code getAlamat(String idUser)}.
         * Jika user belum melakukan login maka method akan mengembalikan nilai <code>null</code>.
         * 
         * @return data Alamat dari akun yang sedang Login.
         */
        public String getAlamat(){
            return this.getAlamat(Users.this.getCurrentLogin());
        }

        /**
         * Digunakan untuk mengedit data Alamat Siswa berdasarkan ID User dari Siswa yang diinputkan. Sebelum mengedit 
         * data Alamat method akan mengecek apakah Alamat yang diinputkan valid atau tidak dengan menggunakan 
         * method {@code isNamaTempat(String namaTempat)} yang ada didalam class {@code Validation}. Jika Alamat tidak valid
         * maka method akan menghasilkan exception {@code InValidUserDataException}.
         * <br><br>
         * Tetapi jikaAlamat valid maka data Alamat dari Siswa akan diedit. Jika data dari Alamat berhasil 
         * diedit maka method akan mengembalikan nilai <code>True</code>.
         * 
         * @param idUser ID User yang ingin diedit datanya.
         * @param newAlamat data Alamat yang baru.
         * 
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setAlamat(String idUser, String newAlamat) {
            // mengecek alamat valid atau tidak
            if(Validation.isNamaTempat(newAlamat)){
                return this.setSiswaData(idUser, SiswaData.ALAMAT, newAlamat);
            }
            throw new InValidUserDataException("Alamat yang Anda masukan tidak valid.");
        }
        
        /**
         * Digunakan untuk mengedit data Alamat Siswa berdasarkan ID User dari Siswa yang sedang digunakan untuk Login. 
         * Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}. Selanjutnya method 
         * akan mengedit data Alamat Siswa melalui method {@code setAlamat(String idUser, String newAlamat)}. 
         * Jika output dari method tersebut adalah <code>True</code> maka data Nama dari user berhasil diedit.
         * 
         * @param newAlamat data Alamat yang baru.
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setAlamat(String newAlamat){
            return this.setAlamat(Users.this.getCurrentLogin(), newAlamat);
        }

        /**
         * Method ini digunakan untuk mendapatkan data ID Kelas Siswa berdasarkan ID User dari Siswa yang diinputkan. 
         * ID User dari Siswa yang diinputkan harus sudah terdaftar didalam <b>Database</b>. Jika ID User dari Siswa yang 
         * diinputkan ternyata tidak terdaftar didalam <b>Database</b> maka method akan menghasilkan exception 
         * {@code InValidUserDataException}. Method hanya akan mendapatkan data ID Kelas Siswa jika ID User dari Siswa 
         * yang diinputkan terdaftar didalam <b>Database</b>.
         * 
         * @param idUser ID User dari Siswa yang ingin didapatkan datanya.
         * @return data ID Kelas dari Siswa.
         */
        public String getIdKelas(String idUser){
            return this.getSiswaData(idUser, SiswaData.ID_KELAS);
        }
        
        /**
         * Method ini digunakan untuk mendapatkan data ID Kelas Siswa berdasarkan ID User dari Petugas yang sedang 
         * digunakan untuk Login. Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}.
         * Selanjutnya method akan mendapatkan data ID Kelas Siswa melalui method {@code getIdKelas(String idUser)}.
         * Jika user belum melakukan login maka method akan mengembalikan nilai <code>null</code>.
         * 
         * @return data ID Kelas dari akun yang sedang Login.
         */
        public String getIdKelas(){
            return this.getIdKelas(Users.this.getCurrentLogin());
        }

        /**
         * Digunakan untuk mengedit data ID Kelas Siswa berdasarkan ID User dari Siswa yang diinputkan. Sebelum mengedit 
         * data ID Kelas method akan mengecek apakah ID Kelas yang diinputkan valid atau tidak dengan menggunakan 
         * method {@code isIdKelas(String idKelas)} yang ada didalam class {@code Validation}. Jika ID Kelas tidak valid
         * maka method akan menghasilkan exception {@code InValidUserDataException}.
         * <br><br>
         * Tetapi jika ID Kelas valid maka data ID Kelas dari Siswa akan diedit. Jika data dari ID Kelas berhasil 
         * diedit maka method akan mengembalikan nilai <code>True</code>.
         * 
         * @param idUser ID User yang ingin diedit datanya.
         * @param newIdKelas data ID Kelas yang baru.
         * 
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setIdKelas(String idUser, String newIdKelas){
            // mengecek apakah ID Kelas valid atau tidak
            if(Validation.isIdKelas(newIdKelas)){
                return this.setSiswaData(idUser, SiswaData.ID_KELAS, newIdKelas);
            }
            throw new InValidUserDataException("'" + newIdKelas +"' ID Kelas tersebut tidak valid.");
        }

        /**
         * Digunakan untuk mengedit data ID Kelas Siswa berdasarkan ID User dari Siswa yang sedang digunakan untuk Login. 
         * Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}. Selanjutnya method 
         * akan mengedit data ID Kelas Siswa melalui method {@code setIdKelas(String idUser, String newIdKelas)}. 
         * Jika output dari method tersebut adalah <code>True</code> maka data Nama dari user berhasil diedit.
         * 
         * @param newIdKelas data ID Kelas yang baru.
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setIdKelas(String newIdKelas){
            return this.setIdKelas(Users.this.getCurrentLogin(), newIdKelas);
        }

        /**
         * Method ini digunakan untuk mendapatkan data Nama Wali Siswa berdasarkan ID User dari Siswa yang diinputkan. 
         * ID User dari Siswa yang diinputkan harus sudah terdaftar didalam <b>Database</b>. Jika ID User dari Siswa yang 
         * diinputkan ternyata tidak terdaftar didalam <b>Database</b> maka method akan menghasilkan exception 
         * {@code InValidUserDataException}. Method hanya akan mendapatkan data Nama Wali Siswa jika ID User dari Siswa 
         * yang diinputkan terdaftar didalam <b>Database</b>.
         * 
         * @param idUser ID User dari Siswa yang ingin didapatkan datanya.
         * @return data Nama Wali dari Siswa.
         */
        public String getNamaWali(String idUser){
            return this.getSiswaData(idUser, SiswaData.NAMA_WALI);
        }

        /**
         * Method ini digunakan untuk mendapatkan data Nama Wali Siswa berdasarkan ID User dari Petugas yang sedang 
         * digunakan untuk Login. Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}.
         * Selanjutnya method akan mendapatkan data Nama Wali Siswa melalui method {@code getNamaWali(String idUser)}.
         * Jika user belum melakukan login maka method akan mengembalikan nilai <code>null</code>.
         * 
         * @return data Nama Wali dari akun yang sedang Login.
         */
        public String getNamaWali(){
            return this.getNamaWali(Users.this.getCurrentLogin());
        }

        /**
         * Digunakan untuk mengedit data Nama Wali Siswa berdasarkan ID User dari Siswa yang diinputkan. Sebelum mengedit 
         * data Nama Wali method akan mengecek apakah Nama Wali yang diinputkan valid atau tidak dengan menggunakan 
         * method {@code isNamaOrang(String namaWali)} yang ada didalam class {@code Validation}. Jika Nama Wali tidak valid
         * maka method akan menghasilkan exception {@code InValidUserDataException}.
         * <br><br>
         * Tetapi jika Nama Wali valid maka data Nama Wali dari Siswa akan diedit. Jika data dari Nama Wali berhasil 
         * diedit maka method akan mengembalikan nilai <code>True</code>.
         * 
         * @param idUser ID User yang ingin diedit datanya.
         * @param newNama data Nama Wali yang baru.
         * 
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setNamaWali(String idUser, String newNama){
            // mengecek apakah nama valid atau tidak
            if(Validation.isNamaOrang(newNama)){
                return this.setSiswaData(idUser, SiswaData.NAMA_WALI, newNama);
            }
            throw new InValidUserDataException("'" + newNama + "' Nama tersebut tidak valid.");
        }

        /**
         * Digunakan untuk mengedit data Nama Wali Siswa berdasarkan ID User dari Siswa yang sedang digunakan untuk Login. 
         * Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}. Selanjutnya method 
         * akan mengedit data Nama Wali Siswa melalui method {@code setNamaWali(String idUser, String newNamaWali)}. 
         * Jika output dari method tersebut adalah <code>True</code> maka data Nama dari user berhasil diedit.
         * 
         * @param newNama data Nama Wali yang baru.
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setNamaWali(String newNama){
            return this.setNamaWali(Users.this.getCurrentLogin(), newNama);
        }

        /**
         * Method ini digunakan untuk mendapatkan data ID SPP Siswa berdasarkan ID User dari Siswa yang diinputkan. 
         * ID User dari Siswa yang diinputkan harus sudah terdaftar didalam <b>Database</b>. Jika ID User dari Siswa yang 
         * diinputkan ternyata tidak terdaftar didalam <b>Database</b> maka method akan menghasilkan exception 
         * {@code InValidUserDataException}. Method hanya akan mendapatkan data ID SPP Siswa jika ID User dari Siswa 
         * yang diinputkan terdaftar didalam <b>Database</b>.
         * 
         * @param idUser ID User dari Siswa yang ingin didapatkan datanya.
         * @return data ID SPP dari Siswa.
         */
        public String getIdSpp(String idUser){
            return this.getSiswaData(idUser, SiswaData.ID_SPP);
        }

        /**
         * Method ini digunakan untuk mendapatkan data ID SPP Siswa berdasarkan ID User dari Petugas yang sedang 
         * digunakan untuk Login. Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}.
         * Selanjutnya method akan mendapatkan data ID SPP Siswa melalui method {@code getIdSpp(String idUser)}.
         * Jika user belum melakukan login maka method akan mengembalikan nilai <code>null</code>.
         * 
         * @return data ID SPP dari akun yang sedang Login.
         */
        public String getIdSpp(){
            return this.getIdSpp(Users.this.getCurrentLogin());
        }

        /**
         * Digunakan untuk mengedit data ID SPP Siswa berdasarkan ID User dari Siswa yang diinputkan. Sebelum mengedit 
         * data ID SPP method akan mengecek apakah ID SPP yang diinputkan valid atau tidak dengan menggunakan 
         * method {@code isIdSpp(String idSpp)} yang ada didalam class {@code Validation}. Jika ID SPP tidak valid
         * maka method akan menghasilkan exception {@code InValidUserDataException}.
         * <br><br>
         * Tetapi jika ID SPP valid maka data ID SPP dari Siswa akan diedit. Jika data dari ID SPP berhasil 
         * diedit maka method akan mengembalikan nilai <code>True</code>.
         * 
         * @param idUser ID User yang ingin diedit datanya.
         * @param newIdSpp data ID SPP yang baru.
         * 
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setIdSpp(String idUser, String newIdSpp){
            // mengecek apakah id spp yang diinputkan adalah sebuah number atau tidak
            if(new Text().isNumber(newIdSpp)){
                // mengecek apakah id spp valid atau tidak
                if(Validation.isIdSpp(Integer.parseInt(newIdSpp))){
                    return this.setSiswaData(idUser, SiswaData.ID_SPP, newIdSpp);
                }
            }
            throw new InValidUserDataException("'" + newIdSpp + "' ID SPP tersebut tidak valid.");
        }

        /**
         * Digunakan untuk mengedit data ID SPP Siswa berdasarkan ID User dari Siswa yang sedang digunakan untuk Login. 
         * Method akan mendapatkan ID User dengan menggunakan method {@code getCurrentLogin()}. Selanjutnya method 
         * akan mengedit data ID SPP Siswa melalui method {@code setIdSpp(String idUser, String newIdSpp)}. 
         * Jika output dari method tersebut adalah <code>True</code> maka data Nama dari user berhasil diedit.
         * 
         * @param newIdSpp data ID SPP yang baru.
         * @return <strong>True</strong> jika data berhasil diedit. <br>
         *         <strong>False</strong> jika data tidak berhasil diedit.
         */
        public boolean setIdSpp(String newIdSpp){
            return this.setIdSpp(Users.this.getCurrentLogin(), newIdSpp);
        }
        
        /**
         * Digunakan untuk menutup koneksi dari <B>Database</B> MySQL. Koneksi dari <B>Database</B> perlu ditutup jika sudah 
         * tidak digunakan lagi. Sebelum menutup koneksi dari <B>Database</B> method akan mengecek apakah object {@code Connection},
         * {@code Statement} dan {@code ResultSet} kosong atau tidak. Jika tidak maka koneksi dari <B>Database</B> akan ditutup. 
         * Jika tidak dicek kosong atau tidaknya object maka saat objek kosong lalu dipaksa untuk menutup koneksi dari <B>Database</B>
         * maka akan menimbulkan exception {@code NullPointerException}.
         */
        @Override
        public void closeConnection(){
            // menutup koneksi dari object Users
            Users.this.closeConnection();
            // menutup koneksi dari object Level Siswa
            Users.this.closeConnection();
        }

    }
}
