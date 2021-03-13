package test;

import java.util.StringTokenizer;

/**
 *
 * @author Achmad Baihaqi
 */
public class AllPhoto {
    
    public static void main(String[] args) {
        ListPath list = new ListPath("S:\\Source Code\\Schools\\Java\\Prepare UKK\\UKK_01RPL_1\\src\\resources\\image\\user-profile\\");
        String files = list.getListFile(), buffer;
        StringTokenizer token = new StringTokenizer(files, "[,]");
        while(token.hasMoreTokens()){
           buffer = token.nextToken();
//           if(buffer.startsWith(" ")){
//               System.out.println(buffer.substring(1));
//           }else{
//               System.out.println(buffer);
//           }
            System.out.println(buffer.substring(buffer.lastIndexOf("\\")+1));
        }
    }
}
