package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
 *
 * @author Achmad Baihaqi
 */
public class Rename {
    
    public static void main(String[] args) throws Exception{
        rename(false, "XII TBS 1");
    }
    // 6156_achmad_baihaqi.jpg
    public static void rename(boolean checking, String kelas) throws Exception{
        
//        getFilename(new File("D:\\Downloads\\Images\\PAS FOTO XII COMPRESSED\\XII RPL 1\\"), "1");
//        System.exit(0);
        
        int index = -1;
        String absen, nis, nama, gender, nohp, email, ttl, newName;
        File rename;
        FileReader file = new FileReader("S:\\Source Code\\Schools\\Java\\Prepare UKK\\UKK_01RPL_1\\src\\resources\\data\\"+kelas+".txt");
        BufferedReader data = new BufferedReader(file);
        StringTokenizer token;
        String buffer;
        while((buffer = data.readLine()) != null){
            index++;
            if(buffer.startsWith("-")){
                System.out.println("SKIP="+buffer);
            }else{
                token = new StringTokenizer(buffer, "#");
                absen = token.nextToken();
                nis = token.nextToken().substring(0, 4);
                nama = token.nextToken().replaceAll(" ", "_");
                gender = token.nextToken();
                nohp = token.nextToken();
                email = token.nextToken();
                ttl = token.nextToken();
                newName = nis+"_"+nama+".jpg";
//                System.out.println(newName.toLowerCase());
                String foto = getFilename(new File("D:\\Downloads\\Images\\PAS FOTO XII COMPRESSED\\"+kelas), Integer.toString(index));
                if(foto != null){
                    File cek = new File(foto);
                    if(cek.exists()){
                        System.out.println(cek.getName() + " to " + (newName.toLowerCase()));
                        File r = cek;
                        if(checking){
                            newName = newName.toLowerCase();
                            boolean res = r.renameTo(new File(cek.getParent()+"\\"+newName));
                            System.out.println("STATUE : " + res);
                        }
                    }                    
                }
            }
        }
        
    }
    
    private static String getFilename(File file, String absen){
        ListPath list = new ListPath(file.toString());
        String files = list.getListFile(), buffer, filename;
        StringTokenizer token = new StringTokenizer(files, ",[]");
        while(token.hasMoreTokens()){
           buffer = token.nextToken();
           if(buffer.startsWith(" ")){
               buffer = buffer.substring(1);
           }
           filename = buffer.substring(buffer.lastIndexOf("\\")+1);
           if(filename.contains(".")){
               if(filename.substring(0, filename.indexOf(".")).equalsIgnoreCase(absen)){
                   return buffer;
               }
           }
        }
        return null;
    }
    
}

//S:\Source Code\Schools\Java\Prepare UKK\UKK_01RPL_1\src\resources\data\XII RPL 1.txt
//S:\Source Code\Schools\Java\Prepare UKK\UKK_01RPL_1\src\resources\data\XII RPL 2.txt
//S:\Source Code\Schools\Java\Prepare UKK\UKK_01RPL_1\src\resources\data\XII TBG 1.txt
//S:\Source Code\Schools\Java\Prepare UKK\UKK_01RPL_1\src\resources\data\XII TBS 1.txt
//S:\Source Code\Schools\Java\Prepare UKK\UKK_01RPL_1\src\resources\data\XII TITL 1.txt
//S:\Source Code\Schools\Java\Prepare UKK\UKK_01RPL_1\src\resources\data\XII TITL 2.txt
//S:\Source Code\Schools\Java\Prepare UKK\UKK_01RPL_1\src\resources\data\XII TITL 3.txt
//S:\Source Code\Schools\Java\Prepare UKK\UKK_01RPL_1\src\resources\data\XII TOI 1.txt
//S:\Source Code\Schools\Java\Prepare UKK\UKK_01RPL_1\src\resources\data\XII TPM 1.txt
//S:\Source Code\Schools\Java\Prepare UKK\UKK_01RPL_1\src\resources\data\XII TPM 2.txt
//S:\Source Code\Schools\Java\Prepare UKK\UKK_01RPL_1\src\resources\data\XII TPM 3.txt