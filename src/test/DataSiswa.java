package test;

import java.io.*;
import java.sql.*;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Achmad Baihaqi
 */
public class DataSiswa {
    
    private static Connection conn;
    private static Statement stat;
    private static ResultSet res;
    
    private static final String DRIVER = "com.mysql.jdbc.Driver",
                                DB_NAME = "baihaqi_app_pembayaranspp",
                                URL = "jdbc:mysql://localhost/" + DB_NAME,
                                USER = "root",
                                PASS = "";
    
    public static void startConnection(){
        try{
            // Menghubungkan ke database
            Class.forName(DRIVER); 
            conn = DriverManager.getConnection(URL, USER, PASS); 
            stat = conn.createStatement(); 
            System.out.println("Berhasil terhubung ke database '" + DB_NAME + "'\n");
        }catch(ClassNotFoundException | SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public static void closeConnection(){
        try{
            if(conn != null){
                conn.close();
            }
            if(stat != null){
                stat.close();
            }
            if(res != null){
                res.close();
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan!\n\nError message : "+ex.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public static void main(String[] args) throws IOException{
        startConnection();
        try {
            stat.executeUpdate("TRUNCATE siswa");
            stat.executeLargeUpdate("TRUNCATE foto_profile");
        } catch (SQLException ex) {
            Logger.getLogger(DataSiswa.class.getName()).log(Level.SEVERE, null, ex);
        }
        insertData();
    }
    
    public static void insertData ()throws IOException {
        
        String buffer, id_kelas, nis, nama, gender, tmp_lhr, tgl_lhr, alamat, nohp, email, nama_wali, spp, foto, insertSiswa, insertFoto;
        StringTokenizer token;
        boolean exist;
        FileReader file = new FileReader("src\\resources\\data\\Data Siswa Ori Processed.txt");
        BufferedReader data = new BufferedReader(file);
        
        while((buffer = data.readLine()) != null){
            if(!buffer.startsWith("-")){
                token = new StringTokenizer(buffer, "#");
                id_kelas = token.nextToken();
                nis = token.nextToken();
                nama = namaValidation(token.nextToken());
                gender = genderValidation(token.nextToken());
                tmp_lhr = tempatLahirValidation(token.nextToken());
                tgl_lhr = tanggalLahirValidation(token.nextToken());
                alamat = alamatValidation(token.nextToken());
                nohp = nohpValidation(token.nextToken());
                email = emailValidation(nama, token.nextToken());
                nama_wali = token.nextToken();
                spp = token.nextToken();
                foto = token.nextToken();
                exist = !foto.equalsIgnoreCase("src\\resources\\image\\user-profile\\default.png");
                
                System.out.println(
                        String.format(
                                "ID-KELAS : %s\nNIS : %s\nNAMA : %s\nGENDER : %s\nTEMPAT LAHIR : %s\nTANGGAL LAHIR : %s\nALAMAT : %s\nNO-HP : %s\nEMAIL : %s\nNAMA WALI : %s\nID-SPP : %s\nFOTO : %s\nFOTO EXITS : %s\n", 
                                id_kelas, nis, nama, gender, tmp_lhr, tgl_lhr, alamat, nohp, email, nama_wali, spp, foto, Boolean.toString(exist).toUpperCase()
                        )
                );
                
                insertSiswa = String.format(
                        "INSERT INTO siswa VALUES (%s, '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');",
                        nis, nama, gender, tmp_lhr, tgl_lhr, alamat, id_kelas, nohp, email, nama_wali, spp
                );
                insertFoto = String.format(
                        "INSERT INTO foto_profile VALUES (%s, '%s')", 
                        nis, foto
                );

                System.out.println("---->\nQUERY SISWA : " + insertSiswa);
                System.out.println("QUERY FOTO : " + insertFoto + "<--");
                
                try{
                    int resSiswa = stat.executeUpdate(insertSiswa),
                        resFoto = stat.executeUpdate(insertFoto);
                    if(resSiswa > 0 && resFoto > 0){
                        System.out.println("STATUE : OK\n");
                    }else{
                        System.out.println("STATUE : NO\n");
                    }
                }catch(SQLException e){
                    e.printStackTrace();
                    System.exit(1);
                }
                
            }
        }
    }
    
    private static String namaValidation(String nama){
        if(nama.equalsIgnoreCase("null")){
            System.exit(1);
        }else{
            return nama;
        }
        return nama;
    }
    
    private static String genderValidation(String gender){
        if(gender.equalsIgnoreCase("null")){
            System.exit(1);
        }else{
            if(gender.equalsIgnoreCase("L") || gender.equalsIgnoreCase("P")){
                return gender;
            }else{
                System.out.println("Unkwon gender : " + gender);
                System.exit(1);
            }
        }
        return gender;
    }
    
    private static String tempatLahirValidation(String tempat){
        if(tempat.equalsIgnoreCase("null")){
            return "Indonesia";
        }else{
            return tempat;
        }
    }
    
    private static String randTglLahir(){
        Random rand = new Random();
        int day = rand.nextInt(27) + 1,
            mounth = rand.nextInt(11) + 1;
        String ttl = "2002-";
        if(mounth < 10){
            ttl += "0"+mounth+"-";
        }else{
            ttl += mounth+"-";
        }
        if(day < 10){
            ttl += "0"+ day;
        }else{
            ttl += day;
        }
        return ttl;
    }
    
    private static String tanggalLahirValidation(String tgl){
        if(tgl.equalsIgnoreCase("null")){
            return randTglLahir();
        }else{
            if(tgl.length() != 10){
                System.exit(1);
            }else{
                return tgl;
            }
        }
        return "null";
    }
    
    private static String alamatValidation(String alamat){
        if(alamat.equalsIgnoreCase("null")){
            return "Jawa Timur, Indonesia";
        }else{
            return alamat;
        }
    }
    private static String randNoHp(){
        Random rand = new Random();
        String nohp = "08";
        for(int i = 1; i <= 10; i++){
            nohp += rand.nextInt(9);
        }
        return nohp;
    }
    
    private static String nohpValidation(String nohp){
        if(nohp.equalsIgnoreCase("null")){
            return randNoHp();
        }else{
            if(nohp.length() <= 10){
                return randNoHp();
            }else{
                return nohp;
            }
        }
    }
    
    private static String createEmail(String nama){
        String email = nama.replaceAll(" ", "");
        return email.toLowerCase() + "@gmail.com";
    }
    
    private static String emailValidation(String nama, String email){
        if(email.equalsIgnoreCase("null")){
            return createEmail(nama);
        }else{
            if(!email.contains("@gmail.com")){
                return createEmail(nama);
            }else{
                return email;
            }
        }
    }
    
    private static String ttl(String ttl){
        
        if(ttl.contains("null")){
            return ttl;
        }
        
        StringTokenizer token = new StringTokenizer(ttl, "-,");
        String tempat = token.nextToken(),
               day = token.nextToken().substring(1),
               mount = token.nextToken(),
               year = token.nextToken(),
               result = tempat +"#";
        
        int dayValue = Integer.parseInt(day);
        if(dayValue < 10){
            result += "0" + dayValue + "-";
        }else{
            result += "" + dayValue + "-";
        }
        switch(mount){
            case "Jan": result += "01"; break;
            case "Feb": result += "02"; break;
            case "Mar": result += "03"; break;
            case "Apr": result += "04"; break;
            case "May": result += "05"; break;
            case "Jun": result += "06"; break;
            case "Jul": result += "07"; break;
            case "Aug": result += "08"; break;
            case "Sep": result += "09"; break;
            case "Oct": result += "10"; break;
            case "Nov": result += "11"; break;
            case "Dec": result += "12"; break;
            default: result += "00"; break;
        }
        return result += "-" + year + "#" + tempat + ", Indonesia";
    }
}
