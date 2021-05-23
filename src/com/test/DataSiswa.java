package com.test;

import com.database.Account;
import com.database.Database;
import com.database.Kelas;
import com.database.Transaksi;
import com.database.Validation;
import com.media.Waktu;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.UUID;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Class in digunakan untuk memanipulasi tabel siswa pada <code>Database</code>.
 *
 * @author Achmad Baihaqi
 * @since 2021-05-07
 */
public class DataSiswa {
    
    /**
     * Digunakan untuk segala hal yang berhubungan dengan tabel siswa yang ada didalam <code>Database</code>.
     */
    protected static final Account siswa = new Account();
    /**
     * Digunakan untuk segala hal yang berhubungan dengan tabel kelas yang ada didalam <code>Database</code>.
     */
    protected static final Kelas kls = new Kelas();
    /**
     * Digunakan untuk segala hal yang berhubungan dengan waktu.
     */
    protected static final Waktu waktu = new Waktu();
    /**
     * Digunakan untuk membuat sebuah data random
     */
    private static final CreateDataSiswa crData = new CreateDataSiswa();
    /**
     * File yang berisi data Siswa.
     */
    public static final String filename = "S:\\Source Code\\Java Programming\\Java Project\\SPP Payment\\src\\resources\\data\\data baru";
    
    /**
     * Method ini digunakan untuk mendapatkan NIS dari siswa yang paling akhir. Method ini berguna 
     * saat akan membuat sebuah akun bot siswa. Method aka mendapatkan NIS yang paling akhir 
     * dengan mengambilnya langsung dari <code>Database</code>.
     * 
     * @return NIS yang paling akhir. 
     */
    private static int getLastNis(){
        try{
            // query yang digunakan
            String query = "SELECT nis FROM siswa ORDER BY nis DESC LIMIT 0,1;";
            // mengeksekusi query
            siswa.res = siswa.stat.executeQuery(query);
            // mengecek apakah output dari query kosong atau tidak
            if(siswa.res.next()){
                // mengembalikan nis yang paling akhir
                return siswa.res.getInt("nis");
            }
        }catch(SQLException ex){
            System.out.println("Terjadi Kesalahan : " + ex);
        }
        return 0;
    }
    
    /**
     * Method ini digunakan untuk menampilkan semua data yang ada didalam file. Method akan membaca 
     * satu-persatu baris yang ada didalam file dengan menggunakan bantuan dari class <code>BufferedReader</code>.
     * Pertama-tama method akan mengecek apakah baris yang sedang dibaca adalah sebuah data kosong atau tidak 
     * Jika yang sedang dibaca adalah data kosong maka data tersebut akan diabaikan dan tidak akan ditampilkan.
     * <br><br>
     * Selanjutnya method akan mengecek kevalidan data yang akan ditampilkan melalui mehtod <code>isValidData(String data)</code>
     * yang berada diclass <code>ValidationSiswa</code>. Jika output dari method tersebut adalah <strong>True</strong>
     * maka data akan ditampilkan ke-konsol. Tapi jika output dari mehtod tersebut adalah <strong>False</strong> maka 
     * dat tidak akan ditampilkan karena data dianggap tidak valid.
     * <br><br>
     * <b>Note : </b> Method ini hanya akan menampilkan data yang valid saja.
     */
    private static void showAllData(){
        try{
            // object dan variabel yang digunakan
            BufferedReader baca = new BufferedReader(new FileReader(filename));
            String buffer;
            int baris = 1;
            
            // membaca semua data yang ada didalam file
            while((buffer = baca.readLine()) != null){
                // mengecek apakah baris data yang dibaca adalah sebuah baris kosong atau baris komentar
                if(buffer.length() >= 1 || !buffer.startsWith("//")){
                    // mengecek apakah data yang akan ditampilkan valid atau tidak
                    if(ValidationSiswa.isValidData(buffer)){
                        showData(buffer);
                    }else{
                        System.out.println("Gagal menampilkan data dikarenakan data pada baris "+ baris +" tidak valid....");
                    }
                }
                baris++;
            }
        }catch(IOException ex){
            System.out.println("Terjadi Kesaalahan : " + ex.getMessage());
        }
    }
    
    /**
     * Method ini digunakan untuk menampilkan data ke-konsol. Method akan membuat sebuah object 
     * <code>StringTokenizer</code> dengan parameter data yang telah diinputkan dan dengan delimetri '#'
     * <br><br>
     * Selanjutnya method akan mengecek kevalidan data yang diinputkan melalui method <code>isValidData(String data)</code>
     * yang berada didalam class <code>ValidationSiswa</code> jika output dari method tersebut adalah <strong>False</strong>
     * maka data tidak akan ditampilkan karena data dianggap tidak valid.
     * <br><br>
     * Tapi jika output methodnya adalah <strong>True</strong> maka method akan menampilkan data yang telah diinputkan 
     * oleh user ke-konsol.
     * 
     * @param data Data yang akan ditampilkan. 
     */
    private static void showData(String data){
        // object dan variabel yang digunakan
        StringTokenizer token = new StringTokenizer(data, "#");
        String kelas, nis, nama, gender, tmpLahir, tglLahir, alamat, nohp, gmail, ortu, spp, foto;
        
        // mengecek apakah jumlah data yang diinputkan berjumlah 12 data atau tidak
        if(ValidationSiswa.isValidData(data)){
            // mendapatkan data
            kelas = token.nextToken().replaceAll("-", "");
            nis = token.nextToken();
            nama = token.nextToken();
            gender = token.nextToken();
            tmpLahir = token.nextToken();
            tglLahir = token.nextToken();
            alamat = token.nextToken();
            nohp = token.nextToken();
            gmail = token.nextToken();
            ortu = token.nextToken();
            spp = token.nextToken();
            foto = token.nextToken();

            // menampilkan data ke konsol
            System.out.println(
                    String.format(
                            "NIS : %s\nNama : %s\nGender : %s\nTTL : %s\nAlamat : %s\nKelas : %s\nNomor Telepon : %s\nEmail : %s\nNama Wali : %s\nID SPP : %s\nFoto Profile : %s\n", 
                            nis, crData.toCapitalize(nama), siswa.getGenderName(gender), tmpLahir + ", " + waktu.getTanggal(tglLahir), alamat, kls.getNamaKelas(kelas), nohp, gmail, ortu, spp, foto
                    )
            );            
        }else{
            System.out.println("Gagal menampilkan data dikarenakan data tidak valid....");
        }
        
    }
    
    /**
     * Method ini digunakan untuk mengecek apakah sebuah fileData yang ada didalam baris file merupakan fileData yang valid atau tidak.
     * Method akan membaca satu-persatu baris yang ada didalam file melalui object dari class <code>BufferedReader</code>.
     * Setiap satu baris file method akan menyimpan fileData yang ada dialam baris file tersebut kedalam sebuah 
     * variabel <code>String</code> yang bernama 'buffer'.
     * <br><br>
     * Selanjutnya method akan mengecek apakah variabel buffer tersebut panjangnya lebih besar dari 1 dan tidak 
     * diawali dengan tanda '//' atau tidak. Jika 'Tidak' maka baris dari file tersebut akan diabaikan dan 
     * dianggap kosong tanpa fileData. Jika 'Ya' maka method akan mengecek kevalidan data melalui method 
     * <code>isValidData(String data)</code> yang berada didalam class <code>ValidationSiswa</code>. 
     * 
     * <br><br>
     * <b>Kriteria baris fileData yang diabaikan : </b>
     * <ul>
     *  <li>Data diawali dengan tanda '//'.</li>
     *  <li>Panjang dari baris kurang dari sama dengan 1 karakter.</li>
     * </ul>
     * <b>Kriteria baris fileData yang valid : </b>
     * <ul>
     *  <li>Data tidak diawali dengan tanda '-'.</li>
     *  <li>Jumlah fileData pada baris berjumlah 12 fileData.</li>
     * </ul>
     * <b>Kriteria baris fileData yang tidak valid : </b>
     * <ul>
     *  <li>Data diawali dengan tanda '-'.</li>
     *  <li>Jumlah fileData pada baris kurang atau lebih dari 12 fileData.</li>
     * </ul>
     * 
     * @param showValid jika nilai yang diinputkan adalah 'True' maka method akan menampilkan log dari fileData yang valid ke-console
     * @param showInvalid jika nilai yang diinputkan adalah 'True' maka method akan menampilkan log dari fileData yang tidak valid ke-console
     */
    private static void chekingData(final boolean showValid, final boolean showInValid){
        try{
            System.out.println("-------- Pengecekan Data Yang Tidak Valid...");
            // object dan variabel yang digunakan untuk pengecekan fileData
            BufferedReader data = new BufferedReader(new FileReader(filename));
            int baris = 1, valid = 0, invalid = 0;
            String buffer;
            
            // membaca semua baris fileData yang ada didalam file
            while((buffer = data.readLine()) != null){
                // jika buffer berisi baris kosong atau baris komentar maka fileData yang ada didalam baris akan diabaikan
                if(buffer.length() >= 1 && !buffer.startsWith("//")){
                    // mengecek kevalidan data 
                    if(ValidationSiswa.isValidData(buffer)){
                        valid++; // jika data valid
                        // mengecek apakah log fileData valid diizinkan untuk ditampilkan atau tidak
                        if(showValid){
                            System.out.println("Data pada baris " + baris + " sudah valid....");
                        }
                    }else{
                        invalid++; // jika data tidak valid
                        // mengecek apakah log fileData tidak valid diizinkan untuk ditampilkan atau tidak
                        if(showInValid){
                            System.out.println("Data pada baris " + baris + " belum valid...");
                        }
                    }                    
                }
                baris++;
            }
            System.out.format("--------\nData Valid : %d\nData Tidak Valid : %d\n---\nPengecekan Selesai...\n", valid, invalid);
            data.close(); // memnutup object BufferedReader
        }catch(IOException ex){
            System.out.println("Terjadi Kesalahan : " + ex.getMessage());
        }
    }
    
    /**
     * Method ini digunakan untuk memperbaiki semua data yang ada didalam file yang datanya tidak 
     * valid. Method akan membaca semua data yang ada didalam file melalui class <code>BufferedReader</code>
     * Pertama-tama method akan mengecek apakah data yang sedang dibaca adalah data kosong atau tidak. Jika 
     * data kosong maka data akan diabaikan. 
     * <br><br>
     * Tapi jika data tidak kosong maka method akan mengecek apakah data yang sedang dibaca valid atau tidak 
     * dengan menggunakan method <code>isValidData(String data)</code> yang berada diclass <code>ValidationSiswa</code>.
     * Jika output dari method tersebut adalah <strong>True</strong> maka data akan disimpan tanpa ada perubahan 
     * sedikitpun karena data tersebut sudah dianggap valid.
     * <br><br>
     * Tapi jika output dari method tersebut adalah <strong>False</strong> maka data akan diperbaiki melalui method
     * <code>repairData(String data)</code>. Selanjutnya method akan mengecek apakah data tersebut berhasil diperbaiki 
     * atau tidak. Jika data berhasil diperbaiki maka data tersebut akan disimpan. Tetapi jika data gagal diperbiki 
     * maka program akan force close karena dikhawatirkan akan menyebabkan crash pada aplikasi.
     * <br><br>
     * Jika semua data yang dibaca sudah valid maka selanjutnya method akan menyimpan data-data yang sudah diperbaiki 
     * terebut kedalam sebuah file melalui class <code>BufferedWriter</code>. Method juga akan menampilkan log informasi
     * selama proses perbaikan data berlangsung.
     * 
     */
    private static void repairAllData(){
        try{
            System.out.println("\nMemperbaiki data yang tidak valid....");
            // object dan variabel yang digunakan
            BufferedReader oldFile = new BufferedReader(new FileReader(filename));
            BufferedWriter newFile;
            StringBuilder newData = new StringBuilder(100);
            String buffer, repair;
            int baris = 1, repairData = 0, validData = 0;
            
            // membaca semua data yang ada didalam file
            while((buffer = oldFile.readLine()) != null){
                // mengecek apakah data kosong atau tidak
                if(buffer.length() >= 1 && !buffer.startsWith("//")){
                    // mengecek apakah data valid atau tidak
                    if(!ValidationSiswa.isValidData(buffer)){
                        System.out.println("Memperbaiki data pada baris " + baris + " --> " + buffer);
                        // memperbaiki data yang tidak valid
                        repair = repairData(buffer);
                        // mengecek apakah data berhasil diperbaiki atau tidak
                        if(repair != null){
                            System.out.println("Data berhasil diperbaiki");
                            // menyimpan perubahan data kedalam StringBuilder
                            repairData++;
                            newData.append(repair).append("\n");
                        }else{
                            // jika data gagal disimpan maka program akan force close untuk menghindari kerusakan data siswa
                            System.err.println("Error : Gagal memperbaiki data pada baris " + baris + " karena ada primary data yang tidak valid!");
                            System.exit(404);
                        }
                    }else{
                        // menyimpan data yang valid kedalam StringBuilder
                        validData++;
                        newData.append(buffer).append("\n");
                    }
                }else{
                    // menyimpan data yang kosong kedalam StringBuilder
                    newData.append(buffer).append("\n");
                }
                baris++;
            }
            
            // menutup object BufferedReader
            oldFile.close();
            // membuat object BufferedWriter
            newFile = new BufferedWriter(new FileWriter(filename));
            // menyimpan perubahan data
            newFile.write(newData.toString());
            newFile.flush();
            newFile.close();
            
            // menampilkan log info
            System.out.format("----\nTotal data : %,d\nData yang valid : %,d\nData yang diperbaiki : %,d\n",(validData+repairData), validData, repairData);
        }catch(IOException ex){
            System.out.println("Terjadi Kesalahan : " + ex.getMessage());
        }
    }
    
    /**
     * Method ini digunakan untuk memperbaiki data yang tidak valid. 
     * Pertama-tama method akan mengecek apakah data yang diinputkan adalah data kosong atau tidak.
     * Selanjutnya method akan mengecek apakah data siswa yang diinputkan valid atau tidak melalui 
     * method <code>isValidData(String data)</code> yang berada diclass <code>ValidationSiswa</code> 
     * <br><br>
     * Jika output dari method tersebut adalah <strong>True</strong> maka method akan mengambalikan 
     * data yang diinputkan tanpa perubahan sedikitpun karena datanya sudah valid. Tapi jika output 
     * dari method tersebut adalah <strong>False</strong> maka data dianggap tidak valid dan method 
     * akan mengecek apakah data tersebut masih dapat diperbaiki atau tidak.
     * <br><br>
     * Jika masih dapat diperbaiki maka method akan memperbaiki data yang diinputkan sampai data 
     * tersebut benar-benar valid. Jika data sudah valid maka method akan mengembalikan data yang 
     * sudah valid tersebut.
     * 
     * @param data Data yang akan diperbaiki.
     * @return Data Siswa yang sudah diperbaiki
     */
    private static String repairData(String data){
        // object dan variabel yang digunakan untuk menampilkan data
        StringTokenizer token = new StringTokenizer(data, "#");
        String newData = "";
        
        // mengecek apakah data yang akan diperbaiki adalah data kosong atau tidak
        if(data.length() >= 1 && !data.startsWith("//")){
            // mengecek data valid atau tidak
            if(!ValidationSiswa.isValidData(data)){
                // mengecek apakah jumlah data kurang dari 4 dan apaakh primary datanya valid atau tidak
                if(token.countTokens() < 4 || !ValidationSiswa.isValidPrimaryData(data)){
                    return null;
                }else{
                    // memperbaiki data 
                    newData = repairData0(data);
                }
            }else{
                return data;
            }
        }
        
        // mengecek data
        if(ValidationSiswa.isValidData(newData)){
            return repairData(newData);
        }else{
            return null;
        }
    }

    /**
     * Method ini digunakan untuk membantu method <code>repairData(String data)</code> untuk 
     * memperbaiki data yang tidak valid. Ada dua kriteria data yang tidak valid dan cara mempebaikinya 
     * juga akan berbeda antara satu kriteria dengan kriteria yang lainya.
     * <br><br>
     * <b>Kriteria data yang tidak valid antara lain :</b>
     * <ul>
     *   <li>Data diawali dengan tanda '-' dan jumlah datanya tidak sama dengan 12 data.</li>
     *   <li>Data tidak diawali dengan tanda '-' dan datanya berjumlah 12 data tetapi ada salah satu yang tidak valid.</li>
     * </ul>
     * <br>
     * <b>Cara memperbaiki data berdasarkan kriteria 1.</b>
     * <br><br>
     * Pertama-tama method akan mendapatkan primary data dari data yang diinputkan.
     * Primary data adalah data-data utama dari data siswa. Setelah primary data sudah 
     * didapatkan selanjutnya method akan mengisi nilai dari data-data non primary data dengan 
     * data random. 
     * <br><br>
     * Jika semua data-data non primary data nilainya sudah diisi maka method akan membuat data 
     * baru dengan cara menimpa data yang lama. Dan setelah data baru tersebut sudah selesai dibuat maka
     * method akan mengembalikan nilai dari data baru tersebut.
     * <br><br>
     * <b>Cara memperbaiki data berdasarkan kriteria 2.</b>
     * <br><br>
     * Pertama-tama method akan mendapatkan semua data yang ada didalam data yang diinputkan. Selanjutnya 
     * method akan mengecek satu persatu data apakah ada data yang tidak valid. Jika ada data yang tidak valid
     * maka method akan mengisi nilai dari data tersebut dengan data random.
     * <br><br>
     * Method akan mengecek semua data sampai data benar-benar valid. Jika semua data sudah valid maka method 
     * akan membuat data baru dengan cara menimpa data yang lama. Dan setelah data baru tersebut sudah selesai dibuat maka
     * method akan mengembalikan nilai dari data baru tersebut.
     * 
     * @param data Data yang akan perbaiki.
     * @return Data yang sudah diperbaiki.
     */
    private static String repairData0(String data){
        // object dan variabel yang digunakan 
        StringTokenizer token = new StringTokenizer(data, "#");
        String kelas, nis, nama, gender, tmpLahir, tglLahir, alamat, nohp, gmail, ortu, spp, foto;

        // mengecek apakah data diawali dengan tanda '-' dan datanya tidak sama dengan 12
        if(data.startsWith("-") || token.countTokens() != 12){
            // mendapatkan data
            kelas = token.nextToken().replaceAll("-", "");
            nis = token.nextToken();
            nama = crData.toCapitalize(token.nextToken());
            gender = token.nextToken();
            
            // membuat data baru
            tmpLahir = crData.randTempat();
            tglLahir = crData.randTanggalLahir();
            alamat = crData.randTempat() + ", Indonesia";
            nohp = crData.randNoHp();
            gmail = crData.createGmail(nama);
            ortu = crData.randNamaOrtu();
            spp = crData.getIDSpp(kelas);
            foto = crData.getProfile(nis, nama);
            // mengembalikan data baru yang sudah direpair
            return String.format(
                    "%s#%s#%s#%s#%s#%s#%s#%s#%s#%s#%s#%s", 
                    kelas, nis, nama, gender, tmpLahir, tglLahir, alamat, nohp, gmail, ortu, spp, foto
            );
        }
        // mencari data mana yang tidak valid
        else if(token.countTokens() == 12){
            // mendapatkan data
            kelas = token.nextToken().replaceAll("-", "");
            nis = token.nextToken();
            nama = crData.toCapitalize(token.nextToken());
            gender = token.nextToken();
            tmpLahir = token.nextToken();
            tglLahir = token.nextToken();
            alamat = token.nextToken();
            nohp = token.nextToken();
            gmail = token.nextToken();
            ortu = token.nextToken();
            spp = token.nextToken();
            foto = token.nextToken();
            
            // mengecek apakah tempat lahir valid atau tidak
            if(!ValidationSiswa.isNamaTempat(tmpLahir)){
                tmpLahir = crData.randTempat();
            }
            // mengecek apakah tanggal lahir valid atau tidak
            if(!ValidationSiswa.isTanggalLahir(tglLahir)){
                tglLahir = crData.randTanggalLahir();
            }
            // mengecek apakah alamat valid atau tidak
            if(!ValidationSiswa.isNamaTempat(alamat)){
                alamat = crData.randTempat() + ", Indonesia";
            }
            // mengecek apakah nomor hp valid atau tidak
            if(!ValidationSiswa.isNoHp(nohp)){
                nohp = crData.randNoHp();
            }
            // mengecek apakah gmail valid atau tidak
            if(!ValidationSiswa.isEmail(gmail)){
                gmail = crData.createGmail(nama);
            }
            // mengecek apakah ortu valid atau tidak
            if(!ValidationSiswa.isNamaOrtu(ortu)){
                ortu = crData.randNamaOrtu();
            }
            // mengecek apakah spp valid atau tidak
            if(!ValidationSiswa.isIDSpp(spp)){
                spp = crData.getIDSpp(kelas);
            }
            // mengecek apakah foto profile valid atau tidak
            if(!ValidationSiswa.isProfile(foto)){
                foto = crData.getProfile(nis, nama);
            }
            // mengembalikan data baru yang sudah direpair
            return String.format(
                    "%s#%s#%s#%s#%s#%s#%s#%s#%s#%s#%s#%s", 
                    kelas, nis, nama, gender, tmpLahir, tglLahir, alamat, nohp, gmail, ortu, spp, foto
            );
        }
        return null;
    }
    
    /**
     * Method ini digunakan untuk mengosongkan semua data yang ada didalam tabel siswa.
     * Method akan menghapus semua data yang ada didalam tabel menggunakan query sql.
     * Query sql tersebut akan dieksekusi oleh object dari class <code>Siswa</code>.
     */
    private static void setEmptyData(){
        try{
            // menghapus semua data yang ada didalam tabel siswa
            siswa.stat.executeUpdate("TRUNCATE siswa;");
        }catch(SQLException ex){
            System.out.println("Terjadi Kesalahan : " + ex.getMessage());
        }
    }
    
    /**
     * Method ini digunakan untuk mengecek apakah tabel siswa kosong atau tidak.
     * Method akan mengecek kosong atau tidaknya tabel dengan query sql yang 
     * nantinya akan dieksekusi oleh object <code>siswa</code>.
     * 
     * @return <strong>True</strong> jika tabel kosong. <br>
     *         <strong>False</strong> jika tabel tidak kosong.
     */
    private static boolean isEmptyData(){
        try{
            // mengeksekusi query
            String query = "SELECT COUNT(nis) AS total FROM siswa;";
            siswa.res = siswa.stat.executeQuery(query);
            // mengecek apakah eksekusi berhasil atau tidak
            if(siswa.res.next()){
                return siswa.res.getInt("total") >= 0;
            }
        }catch(SQLException ex){
            System.out.println("Terjadi Kesalahan : " + ex.getMessage());
        }
        return false;
    }
    
    /**
     * Method ini digunakan untuk mentransfer semua data yang ada didalam file ke dalam <code>Database</code>.
     * Pertama-tama method akan mengosongkan/menghapus semua data yang ada didalam tabel siswa pada <code>Database</code> 
     * melalui method <code>setEmptyData()</code>. Selanjutnya method akan mengecek apakah tabel siswa sudah kosong atau 
     * tidak melalui method <code>isEmptyData()</code>.
     * <br><br>
     * Jika output dari method tersebut adalah <code>False</code> bearti terjadi kegagalan saat proses penggosongan data.
     * Dan user harus menghapus secara manual data-data yang ada didalam tabel siswa. Jika data-data pada tabel siswa 
     * tidak dikosongkan/dihapus maka kemungkinan error yang akan terjadi pada saat mentransfer data sangatlah besar.
     * Selanjutnya method akan mengecek apakah semua data yang ada didalam file sudah valid tidak melalui method 
     * <code>isValidAllData()</code> yang berada didalam class <code>ValidationSiswa</code>.
     * <br><br>
     * Jika output dari method tersebut adalah <strong>False</strong> maka masih ada data yang tidak valid.
     * Data akan tetap ditransfer tetapi sebelum mentransfer data method akan memperbaiki data-data 
     * yang tidak valid tersebut melalui method <code>repairAllData()</code>. Jika semua data yang tidak valid sudah 
     * diperbaiki maka method akan mencoba kembali untuk mentranser data.
     * <br><br>
     * Tetapi jika output dari <code>isValidAllData()</code> tersebut adalah <strong>True</strong> maka semua data yang
     * ada didalam file dinyatakan valid. Selanjutnya method akan membaca satu-persatu baris data yang ada didalam file 
     * melalui class <code>BufferedReader</code>. Method akan mengecek apakah baris data yang sedang dibaca adalah 
     * sebuah data kosong atau tidak.
     * <br><br>
     * Jika data yang sedang dibaca adalah data kosong maka data tidak akan ditransfer ke <code>Database</code>. Tapi 
     * jika yang sedang dibaca bukanlah merupakan baris kosong maka data akan ditranster menggunakan method
     * <code>transferData(String data)</code>. Jika output dari method tersebut adalah <strong>True</strong> maka 
     * transfer data dinyatakan berhasil. Tapi jika outputnya <strong>False</strong> maka transfer data dinyatakan 
     * gagal.
     * <br><br>
     * Hal ini akan terus dilakukan sampai semua data yang ada didalam file habis.
     */
    private static void transferAllData(){
        try{
            // object dan variabel yang digunakan 
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String buffer;
            int baris = 1, success = 0, failed = 0;
            boolean isSuccess;
            
            // memngkosongkan isi tabel
            DataSiswa.setEmptyData();
            
            // mengecek apakah tabel sudah kosong atau tidak
            if(DataSiswa.isEmptyData()){
                // mengecek apakah semua data yang akan dimasukan valid atau tidak
                if(ValidationSiswa.isValidAllData()){
                    // membaca semua yang ada didalam file
                    while((buffer = reader.readLine()) != null){
                        // mengecek apakah data yang sedang dibaca kosong atau tidak
                        if(buffer.length() >= 1 && !buffer.startsWith("//")){
                            // mentransfer data ke database mysql
                            isSuccess = transferData(buffer);
                            // mengecek apakah proses transfer data berhasil data atau tidak
                            if(isSuccess){
                                success++;
                                System.out.println("Data pada baris " + baris + " berhasil ditransfer.");
                            }else{
                                failed++;
                                System.out.println("Data pada baris " + baris + " gagal ditransfer.");
                            }
                        }else{
                            System.out.println("Data pada baris " + baris + " diskip karena merupakan data kosong!");
                        }
                        baris++;
                    }
                }else{
                    // memperbaiki data yang tidak valid
                    DataSiswa.repairAllData();
                    // mencoba mentransfer ulang data
                    DataSiswa.transferAllData();
                }
            }else{
                System.out.println("Harap kosongkan tabel siswa secara manual!");
            }
            
            System.out.format("\n-----------\nData yang berhasil ditranfser : %,d\nData yang gagal ditransfer %,d\n\n", success, failed);
            
        }catch(IOException ex){
            System.out.println("Terjadi Kesalahan : " + ex.getMessage());
        }
    }
    
    /**
     * Method ini digunakan untuk mentransfer data Siswa kedalam <code>Database</code>.
     * Sebelum mentransfer data pertama-tama method akan mengecek apakah data Siswa yang akan ditransfer 
     * valid atau tidak dengan menggunakan method <code>isValidData(String data)</code> yang berada 
     * diclass <code>ValidationSiswa</code>.
     * <br><br>
     * Jika output dari method tersebut adalah <strong>False</strong> maka data tidak akan ditransfter dan method 
     * ini akan mengembalikan nilai <strong>False</strong>. Tapi jika outputnya adalah <strong>True</strong> 
     * maka method akan mentransfer data Siswa yang diinputkan ke dalam <code>Database</code>.
     * <br><br>
     * Sebelum mentransfer data Siswa pertama-tama method akan mengambil data-data Siswa yang diinputkan 
     * melalui object dari class <code>StringTokenizer</code>. Selanjutnya method akan mengecek apakah 
     * primary data dari data Siswa sudah exist atau tidak. Primary data adalah data-data seperti nis, 
     * email dan nohp. Data-data ini tidak boleh sama antara satu Siswa dengan Siswa yang lain.
     * <br><br>
     * Jika primary data seperti email atau nomor hp ternyata sudah ada yang memakai maka method akan 
     * membuat data email atau nomor hp yang baru dengan data yang dirandom. Setelah data berhasil dibuat 
     * maka method akan mencoba kembali untuk mentransfer data Siswa tersebut ke <code>Database</code>. 
     * Hal ini hanya berlaku pada primary data seperti email dan nomor hp saja untuk data NIS user harus 
     * secara manual mengantinya agar tidak menimbulkan crash pada aplikasi.
     * <br><br>
     * Tapi jika primary data dari data Siswa belum exist maka method akan mentranster data tersebut ke dalam 
     * <code>Database</code>. Sebelum mentransfer data method akan membuat sebuah query <code>SQL</code> yang 
     * digunakan untuk memasukan data Siswa ke dalam <code>Database</code>. Setelah query berhasil dibuat 
     * maka method akan mengeksekusi query <code>SQL</code> tersebut melalui method <code>executeUpdate(String sql)</code>
     * yang berada didalam class <code>Statement</code>.
     * <br><br>
     * Jika output dari method <code>executeUpdate(String sql)</code> tersebut lebih besar dari 0 maka transfer 
     * data akan dianggap berhasil dan method akan mengembalikan nilai <strong>True</strong>. Tapi jika output dari 
     * method kurang dari sama dengan 0 maka transfer data dianggap gagal dan method akan mengembalikan 
     * nilai <strong>False</strong>.
     * 
     * @param data Data siswa yang akan ditransfer.
     * @return <strong>True</strong> jika transfer data berhasil. <br>
     *         <strong>False</strong> jika transfer data gagal.
     */
    private static boolean transferData(String data){
        try{
            // object dan variabel yang digunakan 
            StringTokenizer token = new StringTokenizer(data, "#");
            String sql, kelas, nis, nama, gender, tmpLahir, tglLahir, alamat, nohp, gmail, ortu, spp, foto;
            
            // mengecek data valid atau tidak
            if(ValidationSiswa.isValidData(data)){
                // mendapatkan data
                kelas = token.nextToken().toLowerCase();
                nis = token.nextToken();
                nama = crData.toCapitalize(token.nextToken());
                gender = token.nextToken().toUpperCase();
                tmpLahir = crData.toCapitalize(token.nextToken());
                tglLahir = token.nextToken();
                alamat = crData.toCapitalize(token.nextToken());
                nohp = token.nextToken();
                gmail = token.nextToken().toLowerCase();
                ortu = crData.toCapitalize(token.nextToken());
                spp = token.nextToken();
                foto = token.nextToken().toLowerCase();
                
                System.out.println("Mentransfer data " + nama + " ke dalam Database.");
                // mengecek apakah data-data primary key exist atau tidak
                if(!ValidationSiswa.isExistNis(nis) && !ValidationSiswa.isExistEmail(gmail) && !ValidationSiswa.isExistNoHp(nohp)){
                    // membuat query mysql
                    sql = "INSERT INTO `siswa` VALUES ("
                        + String.format(
                                "%s, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', %s", 
                                nis, nama, gender, tmpLahir, tglLahir, alamat, kelas, nohp, gmail, ortu, spp
                                )
                        + ");";
                    System.out.println(sql.toLowerCase());
                    
                    // mengesksukusi query
                    int result = siswa.stat.executeUpdate(sql);
                    // mengecek apakah proses eksekusi berhasil atau tidak
                    if(result > 0){
                        System.out.println("Data dari " + nama + " berhasil ditransfer.");
                        return true;
                    }
                }
                // mengecek data primary yang sudah exist
                else{
                    System.out.println(data);
                    // mengecek apakah nis sudah exist atau belum
                    if(ValidationSiswa.isExistNis(nis)){
                        System.err.println(nis + " NIS tersebut sudah terpakai harap digunakan yang lain!\nProses transfer data dibatalkan!");
                        // program akan force close jika ada data nis yang sama untuk menghindari crash pada aplikasi
                        DataSiswa.setEmptyData();
                        System.exit(404);
                    }
                    // mengecek apakah email exist atau tidak
                    if(ValidationSiswa.isExistEmail(gmail)){
                        System.out.println(gmail + "Email sudah exist!");
                        // membuat data email baru dengan tambahan nis dibelakang nama (example : baihaqi6156@gmail.com
                        gmail = crData.createGmail(nama+nis);
                    }
                    // mengecek apakah nomor hp exist atau tidak
                    if(ValidationSiswa.isExistNoHp(nohp)){
                        System.out.println(nohp + "Nomor HP tersebut sudah terpakai!");
                        // membuat data nomor hp baru dengan nomor yang acak
                        nohp = crData.randNoHp();
                    }
                    
                    // membuat data baru dengan menimpa data yang lama.
                    data = String.format(
                            "%s#%s#%s#%s#%s#%s#%s#%s#%s#%s#%s#%s", 
                            kelas, nis, nama, gender, tmpLahir, tglLahir, alamat, nohp, gmail, ortu, spp, foto
                    );
                    
                    // mencoba kembali mentransfer data
                    DataSiswa.transferData(data);
                }
            }else{
                System.out.println(data);
                System.out.println("Gagal mentransfer data dikarenakan data tidak valid!");
            }
            
        }catch(Exception ex){
            System.out.println("Terjadi Kesalahan : " + ex.getMessage());
        }
        return false;
    }
    
    private static void createBot(String idKelas, int jumlah){
        // varibel yang digunakan 
        String data, kelas, nis, nama, gender, tmpLahir, tglLahir, alamat, nohp, gmail, ortu, spp, foto;
        
        // mengecek id kelas yang diinputkan exist atau tidak
        if(ValidationSiswa.isKelas(idKelas)){
            for(int i = 1; i <= jumlah; i++){
                System.out.println("Merandom data bot Siswa...");
                kelas = idKelas;
                nis = "" + (getLastNis()+1);
                nama = crData.randNamaSiswa();
                gender = crData.randGender();
                tmpLahir = crData.randTempat();
                tglLahir = crData.randTanggalLahir();
                alamat = crData.randTempat() + ", Indonesia";
                nohp = crData.randNoHp();
                gmail = crData.createGmail(nama);
                ortu = crData.randNamaOrtu();
                spp = crData.getIDSpp(kelas);
                foto = crData.getProfile(nis, nama);

                data = String.format(
                        "%s#%s#%s#%s#%s#%s#%s#%s#%s#%s#%s#%s", 
                        kelas, nis, nama, gender, tmpLahir, tglLahir, alamat, nohp, gmail, ortu, spp, foto
                );      
                
                DataSiswa.transferData(data);
            }
            
        }
    }
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Pilh Kode 1/2 : ");
        String input = scan.next();
        
        switch (input) {
            case "1":
                new Thread(new Runnable(){
                    @Override
                    public void run(){
                        createBot("x.bot1", 100000);
                    }
                }).start();
                break;
            case "2":
                new Thread(new Runnable(){
                    @Override
                    public void run(){
                        createBot("x.bot1", 100000);
                    }
                }).start();
                new Thread(new Runnable(){
                    @Override
                    public void run(){
                        randPembayaran(100000);
                    }
            }).start();
                break;
            default:
                System.out.println("Input Tidak Tersedia!!");
                break;
        }
    }
    
    private static void randPembayaran(int jumlah){
        Transaksi tr = new Transaksi();
        Random rand = new Random();
        String sql, id;
        int res, bayar; 
        
        for(int i = 1; i <= jumlah; i++){
            try{
                System.out.println("Melakukan transaksi pembayaran pada <bot>");
                id = UUID.randomUUID().toString().substring(0, 10).replaceAll("-", "");
                res = rand.nextInt(10);
                switch(res){
                    case 0: bayar = 50_331; break;
                    case 1: bayar = 125_951; break;
                    case 2: bayar = 174_665; break;
                    case 3: bayar = 258_824; break;
                    case 4: bayar = 290_093; break;
                    case 5: bayar = 348_418; break;
                    case 6: bayar = 416_998; break;
                    case 7: bayar = 521_894; break;
                    case 8: bayar = 593_238; break;
                    case 9: bayar = 714_981; break;
                    case 10: bayar = 854_267; break;
                    default: bayar = 587_498; break;
                }
                sql = "INSERT INTO pembayaran VALUES ('"+id+"', '12', '-1', 'Januari' ,'1999', '"+bayar*3+"', '1999-12-31', '99')";
                int result = tr.stat.executeUpdate(sql);
                if(result > 0){
                    System.out.println(sql.toLowerCase());
                    System.out.println("Transaksi Sukses!");
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        
    }
}

/**
 * Class ini digunakan untuk membuat data baru
 * 
 * @author Achmad Baihaqi
 * @since 2021-05-21
 */
class CreateDataSiswa extends DataSiswa{
    
    /**
     * Method ini digunakan untuk merubah sebuah gaya dari text ke Capitalize.
     * Method ini berguna saat untuk merapihkan penulisan data nama siswa yang 
     * akan ditransfer ke dalam <code>Database</code>.
     * <br><br>
     * <b>Example : </b> 
     * <br>
     * <strong>Sebelum</strong> : "achmad baihaqi." <br>
     * <strong>Sesudah</strong> : "Achmad Baihaqi."
     * 
     * @param text Text yang akan diubah ke capitalize.
     * @return Text yang gaya textnys diubah ke capitalize
     */
    protected String toCapitalize(String text){
        String res = text.toLowerCase(), buffer;
        // merubah huruf pertama dari text menjadi kapital
        res = "" + res.charAt(0);
        res = res.toUpperCase() + (text.substring(1).toLowerCase());
        
        // melakulan looping dari index pertama sampai index terakhir dari text 
        for(int i = 0; i < res.length(); i++){
            // mengecek apakah masih terdapat index atau tidak yang ada didalam text
            if(i < text.length()-1 && i > 1){
                // mengecek apakah index dari text memiliki karakter ' ' atau tidak
                if(res.charAt(i) == ' '){
                    // merubah karakter yang ada disetelah index yang memiliki karakter ' ' ke huruf kapital
                    buffer = res.substring(0, i+1);
                    buffer = buffer + ("" + res.charAt(i+1) + "").toUpperCase();
                    buffer = buffer + res.substring(i+2);
                    res = buffer;
                }
            }
        }
        return res;
    }
    
    /**
     * Method ini digunakan untuk merandom data nama Siswa. Method ini akan digunakan untuk 
     * membuat sebuah bot Siswa yang digunakan untuk penyempurnaan Aplikasi. Method akan merandom 
     * data nama siswa melalui method <code>randomUUID()</code> yang berada didalam class <code>UUID</code>.
     * <br><br>
     * <b>Example : </b> Siswa 7359073b-a2d7-4f5
     * 
     * @return Data random dari nama Siswa.
     */
    protected String randNamaSiswa(){
        return "Siswa "+UUID.randomUUID().toString().substring(0, 18) + "\b";
    }
    
    /**
     * Method ini digunakan untuk merandom data jenis kelamin dari Siswa. Method akan 
     * melalukan random data jenis kelamin dengan menggunakan class <code>Random</code>. 
     * Method ini digunakan untuk memperbaiki data jenis kelamin dari Siswa yang tidak valid.
     * 
     * @return Data random dari jenis kelamin. 
     */
    protected String randGender(){
        Random rand = new Random();
        // merandom jenis kelamin
        int res = rand.nextInt(2);
        switch(res){
            case 1: return "L";
            case 2: return "P";
            default: return "P";
        }
    }
    
    /**
     * Method ini digunakan untuk merandom data tempat tanggal lahir dan alamat dari Siswa. Method akan 
     * melalukan random data tempat tanggal lahir dan alamat dengan menggunakan class <code>Random</code>. 
     * Method ini digunakan untuk memperbaiki data tempat tanggal lahir dan alamat dari Siswa yang tidak valid.
     * 
     * @return Data random dari tempat tanggal lahir dan alamat
     */
    protected String randTempat(){
        Random rand = new Random();
        // merandom tempat tanggal lahir
        int res = rand.nextInt(3);
        switch(res){
            case 1: return "Nganjuk";
            case 2: return "Kediri";
            case 3: return "Jombang";
            default: return "Nganjuk";
        }
    }
    
    /**
     * Method ini digunakan untuk merandom data tanggal lahir dari Siswa. Method akan 
     * melalukan random data tanggal lahir dengan menggunakan class <code>Random</code>. 
     * Method ini digunakan untuk memperbaiki data tanggal lahir dari Siswa yang tidak valid.
     * 
     * @return Data random dari tanggal lahir
     */
    protected String randTanggalLahir(){
        Random rand = new Random();
        // merandom tanggal lahir dari siswa
        int randTanggal = rand.nextInt(27) + 1,
            randBulan = rand.nextInt(11) + 1,
            randTahun = rand.nextInt(2) + 1;
        
        return String.format("%d-%02d-%02d", (2000 + randTahun), randBulan, randTanggal);
    }
    
    /**
     * Method ini digunakan untuk merandom data nomor hp dari Siswa. Method akan 
     * melalukan random data tempat tanggal lahir dengan menggunakan class <code>Random</code>. 
     * Method ini digunakan untuk memperbaiki data nomor hp dari Siswa yang tidak valid.
     * 
     * @return Data random dari nomor hp
     */
    protected String randNoHp(){
        Random rand = new Random();
        String noHp = "08";
        // merandom nomor hp
        for(int i = 1; i <= 10; i++){
            noHp += Integer.toString(rand.nextInt(9));
        }
        return noHp;
    }

    /**
     * Method ini digunakan untuk membuat sebuah alamat Gmail dari nama Siswa. Method ini 
     * digunakan untuk memperbaiki data nomor hp dari Siswa yang tidak valid.
     * <br><br>
     * <b>Example : </b>
     * <br>
     * <strong>Sebelum : </strong> "Achmad Baihaqi" <br>
     * <strong>Sesudah : </strong> "achmadbaihaqi@gmail.com"
     * 
     * @param name Nama dari siswa yang akan dibuatkan Gmail.
     * @return Alamat Gmail dari nama Siswa.
     */
    protected String createGmail(String name){
        return name.toLowerCase().replaceAll(" ", "").replaceAll("-", "").replaceFirst("'", "") + "@gmail.com";
    }
    
    /**
     * Method ini digunakan untuk merandom data nama orangtua dari Siswa. Method akan 
     * melalukan random data nama orangtua dengan menggunakan class <code>Random</code>. 
     * Method ini digunakan untuk memperbaiki data nama orangtua dari Siswa yang tidak valid.
     * 
     * @return Data random dari nama orangtua
     */
    protected String randNamaOrtu(){
        return "Manusia "+UUID.randomUUID().toString().substring(9, 13);
    }
    
    /**
     * Method ini digunakan untuk mendapatkan ID SPP dari ID Kelas yang berasal 
     * dari data Siswa. Method akan mengambil level kelas dari ID Kelas yang diinputkan 
     * lalu mencocokanya sesuai dengan ID SPP nya.
     * 
     * @param idKelas ID kelas dari data Siswa.
     * @return ID SPP dari Kelas.
     */
    protected String getIDSpp(String idKelas){
        String level = kls.getLevelKelas(idKelas.replaceAll("-", ""));
        switch(level){
            case "X": return "20";
            case "XI": return "19";
            case "XII": return "18";
            case "XIII": return "17";
            default: return "-1";
        }
    }
    
    /**
     * Method ini digunakan untuk mendapatkan direktori dari foto profile Siswa berdasarkan NIS dan 
     * nama Siswa. Sebagai contoh jika user menginputkan NIS dengan nilai '6156' dan nama dengan nilai 
     * 'Achmad Baihaqi' maka direktorinya adalah '6156_achmad_baihaqi.jpg'. Selanjutnya method akan 
     * membuat sebuah variabel baru yang nilai dari variabel tersebut adalah direktori dari foto 
     * profile Siswa.
     * <br><br>
     * Kemudian method akan mengecek apakah direktori tersebut exist atau tidak. Jika direktori tersebut
     * exist maka method akan mengembalikan nilai dari direktori tersebut. Tapi jika direktori tidak exist
     * maka method akan mengembalikan direktori default dari foto profile yaitu 'default.jpg'.
     * 
     * @param nis NIS dari Siswa.
     * @param nama Nama dari Siswa.
     * @return Direktori dari foto profile Siswa.
     */
    protected String getProfile(String nis, String nama){
        // direktori dari foto profile
        String directory = "src\\\\resources\\\\image\\\\user-profile\\\\" + nis + ("_" + nama.replaceAll(" ", "_")) + ".jpg";
        // mengecek apakah direktori exist atau tidak
        if(new File(directory).exists()){
            return directory.toLowerCase();
        }else{
            return Account.DEFAULT_FOTO;
        }
    }
}

/**
 * Class ini digunakan untuk mengecek apakah data dari Siswa sudah valid atau tidak. 
 * Pengecekan data dari siswa sangat perlu dilakukan guna meminimalisir error yang terjadi pada program 
 * saat digunakan nanti.
 * 
 * @author Achmad Baihaqi
 * @since 2021-05-20
 */
class ValidationSiswa extends DataSiswa{
    
    /**
     * Digunakan untuk mengecek apakah NIS dari Siswa valid atau tidak.
     * <br><br>
     * <b>Kriteria NIS yang valid : </b>
     * <ul>
     *  <li>NIS harus berupa angka.</li>
     *  <li>NIS harus lebih besar dari 0.</li>
     * </ul>
     * @param nis NIS siswa yang akan dicek.
     * @return <strong>True</strong> jika NIS memenuhi kriteria. <br>
     *         <strong>False</strong> jika NIS tidak memenuhi kriteria.
     */
    public static boolean isNis(String nis){
        return nis.equals("<INC>") || nis.equals("<BOT>") || Validation.isNumber(nis) && (Integer.parseInt(nis)) > 0;
    }
    
    /**
     * Digunakan untuk mengecek apakah Nama dari Siswa valid atau tidak.
     * <br><br>
     * <b>Kriteria Nama Siswa yang valid : </b>
     * <ul>
     *   <li>Panjang dari Nama Siswa harus diantara 5 sampai 50 karakter.</li>
     *   <li>Nama Siswa tidak boleh mengandung angka.</li>
     * </ul>
     * @param nama Nama Siswa yang akan dicek.
     * @return <strong>True</strong> jika Nama Siswa memenuhi kriteria. <br>
     *         <strong>False</strong> jika Nama Siswa tidak memenuhi kriteria.
     */
    public static boolean isNamaSiswa(String nama){
        return nama.endsWith("\b") || nama.length() >= 5 && nama.length() <= 50 && !Validation.isNumber(nama);
    }
    
    /**
     * Digunakan untuk mengecek apakah Jenis kelamin dari Siswa valid atau tidak.
     * <br><br>
     * <b>Kriteria Jenis kelamin yang valid : </b>
     * <ul>
     *   <li>Jenis kelamin harus diantara 'L' atau 'P'.</li>
     * </ul>
     * @param gender Jenis kelamin yang akan dicek.
     * @return <strong>True</strong> jika Jenis kelamin memenuhi kriteria. <br>
     *         <strong>False</strong> jika Jenis kelamin memenuhi kriteria.
     */
    public static boolean isGender(String gender){
        return gender.equalsIgnoreCase("L") || gender.equalsIgnoreCase("P");
    }
    
    /**
     * Digunakan untuk mengecek apakah Nama Tempat/Lokasi dari Siswa valid atau tidak.
     * <br><br>
     * <b>Kriteria Nama Tempat/Lokasi yang valid : </b>
     * <ul>
     *   <li>Panjang dari Nama Tempat/Lokasi harus diantara 4 sampai 50 karakter.</li>
     * </ul>
     * @param tempat Nama Tempat/Lokasi yang akan dicek.
     * @return <strong>True</strong> jika Nama Tempat/Lokasi memenuhi kriteria. <br>
     *         <strong>False</strong> jika Nama Tempat/Lokasi tidak memenuhi kriteria.
     */
    public static boolean isNamaTempat(String tempat){
        return tempat.length() >= 4 && tempat.length() <= 50;
    }
    
    /**
     * Digunakan untuk mengecek apakah Tanggal lahir dari Siswa valid atau tidak. 
     * Method akan mengecek valid atau tidaknya tanggal lahir dari siswa menggunakan method
     * <code>isTanggal(String tanggal)</code> yang berada di class <code>Waktu</code>.
     * 
     * @param tanggal Tanggal lahir yang akan dicek.
     * @return <strong>True</strong> jika Tanggal lahir memenuhi kriteria tanggal yang ada di method <code>isTanggal(String tanggal).</code><br>
     *         <strong>False</strong> jika Tanggal lahir tidak memenuhi kriteria tanggal yang ada di method <code>isTanggal(String tanggal).</code><br>
     */
    public static boolean isTanggalLahir(String tanggal){
        return waktu.isTanggal(tanggal);
    }
    
    /**
     * Digunakan untuk mengecek apakah Kelas dari Siswa valid atau tidak.
     * <br><br>
     * <b>Kriteria Kelas yang valid : </b>
     * <ul>
     *   <li>ID Kelas yang diinputkan harus exist.</li>
     * </ul>
     * @param kelas Kelas/ID Kelas yang akan dicek.
     * @return <strong>True</strong> jika Kelas memenuhi kriteria. <br>
     *         <strong>False</strong> jika Kelas tidak memenuhi kriteria.
     */
    public static boolean isKelas(String kelas){
        return kls.isExistData(Database.KELAS, "id_kelas", kelas.replaceAll("-", ""));
    }
    
    /**
     * Digunakan untuk mengecek apakah Nomor HP dari Siswa valid atau tidak.
     * <br><br>
     * <b>Kriteria Nomor HP yang valid : </b>
     * <ul>
     *   <li>Panjang dari Nomor HP harus diantara 10 sampai 15 karakter.</li>
     *   <li>Nomor HP harus diawali dengan angka '08'.</li>
     * </ul>
     * @param noHp Nomor HP yang akan dicek.
     * @return <strong>True</strong> jika Nomor HP memenuhi kriteria. <br>
     *         <strong>False</strong> jika Nomor HP tidak memenuhi kriteria.
     */
    public static boolean isNoHp(String noHp){
        return noHp.replaceAll("-", "").length() >= 10 && noHp.replaceAll("-", "").length() <= 15 && noHp.startsWith("08");
    }
    
    /**
     * Digunakan untuk mengecek apakah Email dari Siswa valid atau tidak.
     * <br><br>
     * <b>Kriteria Email yang valid : </b>
     * <ul>
     *   <li>Panjang dari Email harus diantara 16 sampai 60 karakter.</li>
     *   <li>Alamat Email yang didukung antara lain @gmail, @yahoo dan @smkn1kts.sch.id</li>
     * </ul>
     * @param email Email yang akan dicek.
     * @return <strong>True</strong> jika Email memenuhi kriteria. <br>
     *         <strong>False</strong> jika Email tidak memenuhi kriteria.
     */
    public static boolean isEmail(String email){
        if(email.length() >= 16 && email.length() <= 60 && email.contains("@") && email.contains(".")){
            return email.substring(email.lastIndexOf("@")).equalsIgnoreCase("@gmail.com") || 
               email.substring(email.lastIndexOf("@")).equalsIgnoreCase("@yahoo.com") ||
               email.substring(email.lastIndexOf("@")).equalsIgnoreCase("@smkn1kts.sch.id");
        }
        return false;
    }
    
    /**
     * Digunakan untuk mengecek apakah Nama Orangtua dari Siswa valid atau tidak.
     * <br><br>
     * <b>Kriteria Orangtua yang valid : </b>
     * <ul>
     *   <li>Panjang dari Nama Orangtua harus diantara 5 sampai 50 karakter.</li>
     * </ul>
     * @param ortu Nama Orangtua yang akan dicek.
     * @return <strong>True</strong> jika Nama Orangtua memenuhi kriteria. <br>
     *         <strong>False</strong> jika Nama Orangtua tidak memenuhi kriteria.
     */
    public static boolean isNamaOrtu(String ortu){
        return ortu.length() >= 5 && ortu.length() <= 50;
    }
    
    /**
     * Digunakan untuk mengecek apakah ID SPP dari Siswa valid atau tidak.
     * <br><br>
     * <b>Kriteria ID SPP yang valid : </b>
     * <ul>
     *   <li>ID SPP harus exist.</li>
     * </ul>
     * @param idspp ID SPP yang akan dicek.
     * @return <strong>True</strong> jika ID SPP memenuhi kriteria. <br>
     *         <strong>False</strong> jika ID SPP tidak memenuhi kriteria.
     */
    public static boolean isIDSpp(String idspp){
        return siswa.isExistData("spp", "id_spp", idspp);
    }
    
    /**
     * Digunakan untuk mengecek apakah Foto Profile dari Siswa valid atau tidak.
     * <br><br>
     * <b>Kriteria Foto Profile yang valid : </b>
     * <ul>
     *   <li>File dari Foto Profile harus exist.</li>
     * </ul>
     * @param foto Foto Profle yang akan dicek.
     * @return <strong>True</strong> jika Foto Profile memenuhi kriteria. <br>
     *         <strong>False</strong> jika Foto Profile tidak memenuhi kriteria.
     */
    public static boolean isProfile(String foto){
        return new File(foto).exists();
    }
    
    /**
     * Method ini digunakan untuk mengecek apakah NIS dari siswa exist atau tidak.
     * 
     * @param nis NIS yang akan dicek.
     * @return <strong>True</strong> jika NIS sudah exist. <br>
     *         <strong>False</strong> jika NIS tidak exist.
     */
    public static boolean isExistNis(String nis){
        return siswa.isExistData("siswa", "nis", nis);
    }
    
    /**
     * Method ini digunakan untuk mengecek apakah Email dari siswa exist atau tidak.
     * 
     * @param email Email yang akan dicek.
     * @return <strong>True</strong> jika Email sudah exist. <br>
     *         <strong>False</strong> jika Email tidak exist.
     */
    public static boolean isExistEmail(String email){
        return siswa.isExistData("siswa", "email", email);
    }
    
    /**
     * Method ini digunakan untuk mengecek apakah Nomor HP dari siswa exist atau tidak.
     * 
     * @param nohp Nomor HP yang akan dicek.
     * @return <strong>True</strong> jika Nomor HP sudah exist. <br>
     *         <strong>False</strong> jika Nomor HP tidak exist.
     */
    public static boolean isExistNoHp(String nohp){
        return siswa.isExistData("siswa", "no_hp", nohp);
    }
    
    /**
     * Method ini digunakan untuk mengecek apakah primary data dari data siswa valid atau tidak.
     * Yang dimaksud primary data adalah data-data dasar seperti kelas, nis, nama dan jenis kelamin.
     * Jika pada data siswa ada salah satu primary data yang salah maka data siswa tersebut akan rusak dan 
     * tidak dapat diperbaiki.
     * 
     * @param data data yang akan dicek 
     * @return <strong>True</strong> jika semua primary data valid. <br>
     *         <strong>False</strong> jika ada salah satu data yang tidak valid.
     */
    public static boolean isValidPrimaryData(String data){
        // object dan variabel yang digunakan
        StringTokenizer token = new StringTokenizer(data, "#");
        String kelas, nis, nama, gender;
        
        // mengecek apakah data yang diinputkan adalah data kosng atau tidak
        if(data.length() >= 1 && !data.startsWith("//") && token.countTokens() >= 4){
            // mendapatkan data
            kelas = token.nextToken().replaceAll("-", "");
            nis = token.nextToken();
            nama = token.nextToken();
            gender = token.nextToken();
            
            // mengecek valid atau tidaknya primary data
            return isKelas(kelas) && isNis(nis) && isNamaSiswa(nama) && isGender(gender);
        }
        return false;
    }
    
    /**
     * Method ini digunakan untuk mengecek apakah data-data dari siswa valid atau tidak.
     * Pertama-tama method akan membuat sebuah object <code>StrinTokenizer</code> dengan parameter 
     * data siswa yang telah diinputkan oleh user dengan delimetri '#'
     * <br><br>
     * Kemudian method akan mengecek apakah data mentah yang dinputkan tidak diawali dengan tanda '-' dan 
     * jumlah tokenya sama dengan 12 atau tidak. Jika 'Tidak' maka semua data siswa yang ada didalam 
     * data mentah dianggap tidak valid. 
     * <br><br>
     * Jika 'Ya' method akan mengambil semua data siswa seperti 
     * nis, nama, gender, ttl, email, dll dari data mentah yang sudah diinputkan oleh user. Method akan 
     * mengambil data siswa dari data mentah melalui object dari class <code>StringTokenizer</code> yang 
     * sudah dibuat tadi.
     * <br>
     * <br>
     * <b>Berikut adalah kriteria dari data siswa yang valid</b>
     * <ul>
     *   <li>ID Kelas harus sudah terdaftar didalam Database.</li>
     *   <li>NIS harus berupa angka.</li>
     *   <li>NIS harus lebih dari 0.</li>
     *   <li>Nama Siswa harus memenuhi kriteria nama yang valid berdasarkan method <code>Validation.isNamaOrang(String nama).</code></li>
     *   <li>Jenis kelamin dari Siswa harus diantara 'L' atau 'P'.</li>
     *   <li>Tempat lahir harus memenuhi kriteria nama tempat yang valid berdasarkan method <code>Validation.isNamaTempat(String tempat).</code></li>
     *   <li>Tanggal lahir harus memenuhi kriteria tanggal lahir yang valid berdasarkan method <code>waktu.isTanggal(tanggal).</code></li>
     *   <li>Alamat harus memenuhi kriteria nama tempat yang valid berdasarkan method <code>Validation.isNamaTempat(String tempat).</code></li>
     *   <li>Nomor HP harus memenuhi kriteria nomor hp yang valid berdasarkan method <code>Validation.isNoHp(String nohp).</code></li>
     *   <li>Email harus memenuhi kriteria email yang valid berdasarkan method <code>Validation.isEmail(String email).</code></li>
     *   <li>Nama Orang tua harus terdiri kurang dari sama dengan 6 karakter.</li>
     *   <li>ID SPP harus memenuhi kriteria ID SPP yang valid berdasarkan method <code>Validation.isIdSpp(String spp).</code></li>
     *   <li>Directory dari file foto profile siswa harus exist.</code></li>
     * </ul>
     * 
     * @param dataMentah data mentah dari data siswa yang akan dicek kevalidanya
     * @return <strong>True</strong> jika semua data valid. <br>
     *         <strong>False</strong> jika ada salah-satu data yang tidak valid. 
     */
    public static boolean isValidData(String dataMentah){
        // object dan variabel yang digunakan 
        StringTokenizer token = new StringTokenizer(dataMentah, "#");
        String kelas, nis, nama, gender, tmpLahir, tglLahir, alamat, nohp, email, ortu, spp, foto;
        // mengecek apakah data yang diinputkan adalah data kosong atau tidak
        if(dataMentah.length() >= 1 && !dataMentah.startsWith("//")){
            // mengecek apakah data diawali dengan tanda '-' dan jumlah data sama dengan 12 atau tidak
            if(!dataMentah.startsWith("-") && token.countTokens() == 12){
                // mendapatkan data
                kelas = token.nextToken().replaceAll("-", "");
                nis = token.nextToken();
                nama = token.nextToken();
                gender = token.nextToken();
                tmpLahir = token.nextToken();
                tglLahir = token.nextToken();
                alamat = token.nextToken();
                nohp = token.nextToken();
                email = token.nextToken();
                ortu = token.nextToken();
                spp = token.nextToken();
                foto = token.nextToken();
                
                // jika semua data dari siswa valid maka akan mengembalikan nilai true
                // tapi jika ada salah satu data yang tidak valid maka akan mengembalikan nilai false
                return isKelas(kelas) && isNis(nis) && isNamaSiswa(nama) && isGender(gender) && 
                       isNamaTempat(tmpLahir) && isTanggalLahir(tglLahir) && isNamaTempat(alamat) && 
                       isNoHp(nohp) && isEmail(email) && isNamaOrtu(ortu) && isIDSpp(spp) && isProfile(foto);
            }
        }
        return false;
    }
    
    /**
     * Method ini digunakan untuk mengecek apakah semua data yang ada didalam file 
     * sudah valid atau belum. Method akan membaca satu-persatu baris data yang ada 
     * didalam file dengan bantuan class <code>BufferedReader</code>. 
     * <br><br>
     * Jika baris data yang sedang dibaca berisi data kosong maka baris data tersebut akan diabaikan. Tapi jika 
     * bukan data kosong maka data tersebut akan dicek kevalidanya melalui method <code>isValidData(String data)</code> 
     * jika output dari method tersebut adalah <strong>False</strong> maka semua data yang ada 
     * didalam file dinyatakan tidak valid dan method ini akan mengembalikan nilai <strong>False</strong>. 
     * <br><br>
     * Tapi jika hasil dari method <code>isValidData(String data)</code> tersebut adalah 
     * <strong>True</strong> maka method akan terus membaca baris berikutnya sampai 
     * tidak ada baris lagi yang tersisa didalam file.
     * 
     * @return <strong>True</strong> jika semua data valid.
     *         <strong>False</strong> jika ada salah satu data yang tidak valid.
     */
    public static boolean isValidAllData(){
        try{
            // object dan variabel yang digunakan 
            BufferedReader data = new BufferedReader(new FileReader(filename));
            String buffer;
            
            // membaca semua data yang ada didalam file
            while((buffer = data.readLine()) != null){
                // jika data yang dibaca kosong maka data tersebut akan diabaikan
                if(buffer.length() >= 1 && !buffer.startsWith("//")){
                    // mengecek apakah ada data yang tidak valid atau tidak
                    if(!isValidData(buffer)){
                        System.out.println(buffer);
                        return false;
                    }
                }
            }
            // mengembalikan nilai true jika semua data valid
            return true;
        }catch(IOException ex){
            System.out.println("Terjadi Kesalahan : " + ex.getMessage());
        }
        return false;
    }
    
}

