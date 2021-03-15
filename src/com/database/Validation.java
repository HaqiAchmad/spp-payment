package com.database;

import com.media.Audio;
import javax.swing.JOptionPane;

/**
 *
 * @author Achmad Baihaqi
 * @since 2021-03-15
 */
public class Validation {
    
    /**
     * Digunakan untuk mengecek apakah didalam sebuah text mengandung sebuah angka atau tidak
     * 
     * @param text text yang akan dicek 
     * @return Jika didalam text mengandung number maka akan mengembalikan nilai True
     *         Tapi jika didalam text tidak mengandung number maka akan mengembalikan nilai False
     */
    public static boolean containsNumber(String text){
        String number = "1234567890";
        char a, b;
        for(int i = 0; i < number.length(); i++){
            for(int k = 0; k < text.length(); k++){
                a = number.charAt(i); b = text.charAt(k);
                if(a == b){
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Digunakan untuk mengecek apakah sebuah String dapat dikonversi ke Integer atau tidak.
     * 
     * @param text text yang ingin dicek
     * @return jika bisa dikonversi maka akan mengembalikan nilai true
     *         tapi jika tidak maka akan mengembalikan nilai false.
     */
    public static boolean isNumber(String text){
        
        text = text.toLowerCase();
        // karakter yang bukan merupakan number
        String notNums = "abcdefghijklmnopqrstuvwxyz`~!@#$%^&*()_+=\\|{[]}:;'\"<>?/";
        for(int i = 0; i < text.length(); i++){
            for(int k = 0; k < notNums.length(); k++){
                // jika kerakter yang ada didalam text mengandung karakter yang ada didalam notNums maka akan mereturn false
                if(text.charAt(i) == notNums.charAt(k)){
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * - id petugas harus diantara 1 sampai 999
     * 
     * @param id id petugas yang akan dicek
     * @return 
     */
    public static boolean isIdPetugas(int id){
        if(id < 1000 && id > 1){
            return true;
        }else{
            Audio.play(Audio.SOUND_WARNING);
            JOptionPane.showMessageDialog(null, "ID harus diantara 1-999!", "Pesan", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    /**
     * - nis harus diantara 1000 sampai 99,999
     * @param nis nis yang akan diecek
     * @return 
     */
    public static boolean isNis(int nis){
        if(nis >= 1000 && nis < 100000){
            return true;
        }else{
            Audio.play(Audio.SOUND_WARNING);
            JOptionPane.showMessageDialog(null, "NIS harus diantara 1000-99999!", "Pesan", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    /**
     * - id kelas panjangnya harus kurang dari 10 karakter
     * 
     * @param id id kelas yang akan dicek
     * @return 
     */
    public static boolean isIdKelas(String id){
        if(id.length() < 10){
            return true;
        }else{
            Audio.play(Audio.SOUND_WARNING);
            JOptionPane.showMessageDialog(null, "Panjang dari ID Kelas harus diantara 1-9 karakter!", "Pesan", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    /**
     * - id spp harus diantara 10-99
     * 
     * @param id id spp yang akan dicek
     * @return 
     */
    public static boolean isIdSpp(int id){
        if(id > 9 && id < 100){
            return true;
        }else{
            Audio.play(Audio.SOUND_WARNING);
            JOptionPane.showMessageDialog(null, "ID SPP harus diantara 10-99!", "Pesan", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    public static boolean isIdPembayaran(String id){
        if(id.length() >= 5 && id.length() <= 10){
            if(containsNumber(id)){
                return true;
            }else{
                Audio.play(Audio.SOUND_WARNING);
                JOptionPane.showMessageDialog(null, "ID Pembayaran harus mengandung angka!", "Pesan", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            Audio.play(Audio.SOUND_WARNING);
            JOptionPane.showMessageDialog(null, "Panjang dari ID Pembayaran harus diantara 6-10 karakter!", "Pesan", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    /**
     *  - nama harus terdiri dari 6-50 karakter
     *  - nama tidak boleh mengandung angka
     * 
     * @param nama nama yang akan dicek
     * @return 
     */
    public static boolean isNamaOrang(String nama){
        if(nama.length() >= 6 && nama.length() <= 50){
            if(!containsNumber(nama)){
                return true;
            }else{
                Audio.play(Audio.SOUND_WARNING);
                JOptionPane.showMessageDialog(null, "Nama tidak boleh mengandung angka!", "Pesan", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            Audio.play(Audio.SOUND_WARNING);
            JOptionPane.showMessageDialog(null, "Nama harus terdiri dari 6-50 karakter!", "Pesan", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    /**
     * - nama kelas harus terdiri dari 2-9 karakter
     * 
     * @param kelas nama kelas yang akan dicek
     * @return 
     */
    public static boolean isNamaKelas(String kelas){
        if(kelas.length() > 1 && kelas.length() <= 9){
            return true;
        }else{
            Audio.play(Audio.SOUND_WARNING);
            JOptionPane.showMessageDialog(null, "Nama Kelas harus terdiri dari 2-50 karakter!", "Pesan", JOptionPane.WARNING_MESSAGE);
        }
        return true;
    }
    
    /**
     * - tahun yg diinputkan tidak boleh kurang dari tahun saat ini
     * - tahun tidak boleh lebih dari 9999
     * 
     * @param tahun tahun yang akan dicek
     * @return 
     */
    public static boolean isTahunSpp(int tahun){
        com.media.Waktu waktu = new com.media.Waktu();
        if(tahun >= waktu.getTahun()){
            if(tahun < 9999){
                return true;
            }else{
                Audio.play(Audio.SOUND_WARNING);
                JOptionPane.showMessageDialog(null, "Tahun tidak boleh lebih dari 9999!", "Pesan", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            Audio.play(Audio.SOUND_WARNING);
            JOptionPane.showMessageDialog(null, "'"+tahun+"' Tahun tersebut sudah kadaluarsa!", "Pesan", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    /**
     * nominal spp harus diantara Rp. 50.000 sampai Rp. 1.000.000
     * 
     * @param nominal nominal yang akan dicek
     * @return 
     */
    public static boolean isNominalSpp(int nominal){
        if(nominal >= 50000 && nominal <= 1000000){
            return true;
        }else{
            Audio.play(Audio.SOUND_WARNING);
            JOptionPane.showMessageDialog(
                    null, "Nominal SPP harus diantara Rp. 50.000 sampai Rp. 1.000.000!\nNominal yang anda masukan adalah Rp. " + String.format("%,d!", nominal), 
                    "Pesan", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    /**
     * - Jumlah uang minimum untuk membayara spp adalah rp. 10.000
     * 
     * @param bayar jumlah bayar yang akan dicek
     * @return 
     */
    public static boolean isValidBayar(int bayar){
        if(bayar >= 10000){
            return true;
        }else{
            Audio.play(Audio.SOUND_WARNING);
             JOptionPane.showMessageDialog(null, "Jumlah uang minimal untuk membayar SPP adalah Rp. 10.000!", "Pesan", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    /**
     * - panjang dari username harus diantara 4 sampai 50 karakter
     * - username tidak boleh mengandung spasi
     * 
     * @param username username yang akan dicek
     * @return 
     */
    public static boolean isUsername(String username){
        if(username.length() >= 4 && username.length() <= 50){
            if(!username.contains(" ")){
                return true;
            }else{
                Audio.play(Audio.SOUND_WARNING);
                JOptionPane.showMessageDialog(null, "Username tidak boleh mengandung spasi!", "Pesan", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            Audio.play(Audio.SOUND_WARNING);
            JOptionPane.showMessageDialog(null, "Panjang dari Username harus diantara 4-50 karakter!", "Pesan", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    /**
     * - panjang dari password harus diantara 5-50 karakter
     * 
     * @param password password yang akan dicek
     * @return 
     */
    public static boolean isPassword(String password){
        if(password.length() >= 5 && password.length() <= 50){
            return true;
        }else{
            Audio.play(Audio.SOUND_WARNING);
            JOptionPane.showMessageDialog(null, "Panjang dari Password harus diantara 5-50 karakter!", "Pesan", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    /**
     * - panjangnya harus diantara 5-50 karakter
     * 
     * @param tempat nama tempat yang akan dicek
     * @return 
     */
    public static boolean isNamaTempat(String tempat){
        if(tempat.length() >= 5 && tempat.length() <= 50){
            return true;
        }else{
            Audio.play(Audio.SOUND_WARNING);
            JOptionPane.showMessageDialog(null, "Panjang dari Nama Tempat harus diantara 5-50 karakter!", "Pesan", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    /**
     * - panjang dari email harus terdiri dari 10-60 karakter
     * - alamat email yang didukung hanyalah @gmail, @yahoo dan @smkn1kts.sch.id
     * 
     * @param email email yang akan dicek
     * @return 
     */
    public static boolean isEmail(String email){
        String gmail = "@gmail.com", ymail = "@yahoo.com", sekolah = "@smkn1kts.sch.id", alamat;
        if(email.length() >= 10 && email.length() <= 60){
            if(email.contains("@") && email.contains(".")){
                alamat = email.substring(email.lastIndexOf("@"));
                if(alamat.equalsIgnoreCase(gmail) || alamat.equalsIgnoreCase(ymail) || alamat.equalsIgnoreCase(sekolah)){
                    return true;
                }else{
                    Audio.play(Audio.SOUND_WARNING);
                    JOptionPane.showMessageDialog(null, "Alamat email yang didukung hanyalah : @gmail.com, @yahoo.com dan @smkn1kts.sch.id", "Pesan", JOptionPane.WARNING_MESSAGE);
                }                
            }else{
                Audio.play(Audio.SOUND_WARNING);
                JOptionPane.showMessageDialog(null, "Email tersebut tidak valid!", "Pesan", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            Audio.play(Audio.SOUND_WARNING);
            JOptionPane.showMessageDialog(null, "Panjang dari Email harus diantara 10-60 karakter!", "Pesan", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    /**
     * - panjang dari nomor hp harus diantara 10-15 karakter
     * 
     * @param noHp nohp yang akan dicek
     * @return 
     */
    public static boolean isNoHp(String noHp){
        if(noHp.length() >= 10 && noHp.length() <= 15){
            if(noHp.startsWith("08")){
                return true;
            }else{
                Audio.play(Audio.SOUND_WARNING);
                JOptionPane.showMessageDialog(null, "Nomor HP tidak valid!\nContoh Nomor HP yang valid : 085655864624", "Pesan", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            Audio.play(Audio.SOUND_WARNING);
            JOptionPane.showMessageDialog(null, "Panjang dari Nomor Hp harus diantara 10-15 karakter!", "Pesan", JOptionPane.WARNING_MESSAGE);
        }
        return false;
    }
    
    
    public static void main(String[] args) {
        System.out.println(Validation.isIdPetugas(15));
        System.out.println(Validation.isNis(99999));
        System.out.println(Validation.isIdKelas("r"));
        System.out.println(Validation.isIdSpp(15));
        System.out.println(Validation.isIdPembayaran("TR000001"));
        System.out.println(Validation.containsNumber("1.baihaqi"));
        System.out.println(Validation.isNamaOrang("Haqi-desu"));
        System.out.println(Validation.isNamaKelas("X-RPL-1"));
        System.out.println(Validation.isTahunSpp(2022));
        System.out.println(Validation.isNominalSpp(250000));
        System.out.println("TR013411".length());
        System.out.println(Validation.isValidBayar(50000));
        System.out.println(Validation.isUsername("levi"));
        System.out.println(Validation.isPassword("12345678"));
        System.out.println(Validation.isNamaTempat("Jombang"));
        System.out.println(Validation.isNoHp("085655864624"));
        System.out.println(Validation.isEmail("hakiahmad@smkn1kts.sch.id"));
    }
    
}
