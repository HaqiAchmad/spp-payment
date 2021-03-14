package test;

import java.io.*;
import java.util.StringTokenizer;

/**
 *
 * @author Achmad Baihaqi
 */
public class ShowDataSiswa {
    
    public static void main(String[] args) throws IOException {
        
        StringTokenizer token;
        String buffer, id_kelas, nis, nama, gender, tmp_lhr, tgl_lhr, alamat, nohp, email, nama_wali, spp, foto;
        boolean exist;
        FileReader file = new FileReader("src\\resources\\data\\Data Siswa Ori Processed.txt");
        BufferedReader data = new BufferedReader(file);
        
        while((buffer = data.readLine()) != null){
            if(!buffer.startsWith("-")){
                token = new StringTokenizer(buffer, "#");
                id_kelas = token.nextToken();
                nis = token.nextToken();
                nama = token.nextToken();
                gender = token.nextToken();
                tmp_lhr = token.nextToken();
                tgl_lhr = token.nextToken();
                alamat = token.nextToken();
                nohp = token.nextToken();
                email = token.nextToken();
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
            }
        }
    }
    
}
