package test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListPath {

    private String path;

    // mengatur path yg akan digunakan dgn var path diatas
    public ListPath(String path){
        this.path = path;
    }

    // merubah value/directory dari var path
    public void changePath(String path) {
        this.path = path;
    }

    // mendapatkan value dari var path
    public String getPath() {
        return path;
    }

    // mengecek apakah path ada dlm tersedia || tidak
    public boolean isExistPath(){
        File file = new File(this.path);
        if (file.exists()){
            return true; // exits
        }else {
            return false; // not
        }
    }

    // menampilkan file yang exits di dalam directory this.path
    public void showExistFile(){

        StringTokenizer data = new StringTokenizer(getListFile(), ",");
        File file; String buffer;

            while (data.hasMoreTokens()){
                buffer = data.nextToken();
                file = new File(buffer);
                if (!file.exists()){
                    System.out.println(buffer + " is exist");
                }else{
                    System.out.println(buffer + " not exist");
                }
                file = null;
            }

    }

    // mendapatkan file yang ada di dlm directory this.path (default)
    public String getListFile(){

        Path p = Paths.get(this.path);
        String data;

        try (Stream<Path> subP = Files.walk(p, 1)){

            List<String> listPath = subP.filter(Files::isRegularFile)
                    .map(Objects::toString)     // Files::exits = mendapatkan file yang ada di dlm directory this.path utk di inputkan ke dlm var listPath
                    .collect(Collectors.toList());

            data = listPath.toString(); // merubah ke bentuk str dan di masukan ke dlam var data
            return data;

        }catch (NoSuchFileException no){
            System.out.println(this.path + " not exist!"); // exception jika file tidak ditemukan
        }catch (IOException io){
            io.printStackTrace();
        }

        return "@37476486238623874628"; // untuk menandakan jika terjadi error
    }

    // overload dari getListFile
    public String getListFile(String direktori){

        Path p = Paths.get(direktori);
        String data;

        try (Stream<Path> subP = Files.walk(p, 1)){

            List<String> listPath = subP.filter(Files::isRegularFile)
                    .map(Objects::toString)     // Files::exits = mendapatkan file yang ada di dlm directory this.path utk di inputkan ke dlm var listPath
                    .collect(Collectors.toList());

            data = listPath.toString(); // merubah ke bentuk str dan di masukan ke dlam var data
            return data;

        }catch (NoSuchFileException no){
            System.out.println(this.path + " not exist!"); // exception jika file tidak ditemukan
        }catch (IOException io){
            io.printStackTrace();
        }

        return "@37476486238623874628"; // untuk menandakan jika terjadi error
    }

    // menampilkan list file
    public void showListFile(){

        // mengambil data dari method getListPath() untuk di show dgn delim ','
        StringTokenizer buffer = new StringTokenizer(getListFile(), ",");
            while (buffer.hasMoreTokens()){
                System.out.println(buffer.nextToken()); // menampilkan
            }
    }

    // overload dari showListFile
    public void showListFile(String direktori){

        // mengambil data dari method getListPath() untuk di show dgn delim ','
        StringTokenizer buffer = new StringTokenizer(getListFile(direktori), ",");
        while (buffer.hasMoreTokens()){
            System.out.println(buffer.nextToken()); // menampilkan
        }
    }

    // mendatkan file yg berformat tertentu di dlm directory this.path
    public String getListFileByformat(String format) {

        // get data dari getListPath()
        StringTokenizer buffer = new StringTokenizer(getListFile(), ",");
        String data = "", bufferStr;

        while (buffer.hasMoreTokens()) {
            bufferStr = buffer.nextToken();

            if (bufferStr.contains(format)) {
                data += bufferStr + ","; // menambahkan ',' untuk di sbg penanda antar file
            }

        }
        return data;
    }

    // overload dari getlistFileByFormat
    public String getListFileByformat(String format, String direktori) {

        // get data dari getListPath()
        StringTokenizer buffer = new StringTokenizer(getListFile(direktori), ",");
        String data = "", bufferStr;

        while (buffer.hasMoreTokens()) {
            bufferStr = buffer.nextToken();

            if (bufferStr.contains(format)) {
                data += bufferStr + ","; // menambahkan ',' untuk di sbg penanda antar file
            }

        }
        return data;
    }

    // menampilkan file yg berformat tertentu di dlm directory this.path
    public void showListFileByFormat(String format){

        // get data dari getListByFormat dgn delim ','
        StringTokenizer buffer = new StringTokenizer(getListFileByformat(format), ",");
            while (buffer.hasMoreTokens()){
                System.out.println(buffer.nextToken()); //show
            }

    }

    //overload dari showListFileByFormat
    public void showListFileByFormat(String format, String direktori){

        // get data dari getListByFormat dgn delim ','
        StringTokenizer buffer = new StringTokenizer(getListFileByformat(format, direktori), ",");
        while (buffer.hasMoreTokens()){
            System.out.println(buffer.nextToken()); //show
        }

    }

    // menghitung jumlah file yg ada dlm directory this.path
    public int getJumlahFile(){

        StringTokenizer buffer = new StringTokenizer(getListFile(), ",");
        int jumlah = 0;

            while (buffer.hasMoreTokens()){
                buffer.nextToken();
                jumlah++; // akan bertambah hasMoreToken bernilai false
            }

            return jumlah;
    }

    // overload dari getJumlahFile
    public int getJumlahFile(String direktori){

        StringTokenizer buffer = new StringTokenizer(getListFile(direktori), ",");
        int jumlah = 0;

        while (buffer.hasMoreTokens()){
            buffer.nextToken();
            jumlah++; // akan bertambah hasMoreToken bernilai false
        }

        return jumlah;
    }

    // menghitung jumlah file tertentu yg ada di dlm directory this.path
    public int getJumlahFile_ByFormat(String format){

        StringTokenizer buffre = new StringTokenizer(getListFileByformat(format), ",");
        int jumlah = 0;
            while (buffre.hasMoreTokens()){
                buffre.nextToken();
                jumlah++;
            }
        return jumlah;
    }

    // overload dari getJumlahFile_ByFormat
    public int getJumlahFile_ByFormat(String format, String direktori){

        StringTokenizer buffre = new StringTokenizer(getListFileByformat(format, direktori), ",");
        int jumlah = 0;
        while (buffre.hasMoreTokens()){
            buffre.nextToken();
            jumlah++;
        }
        return jumlah;
    }

    // menampilkan folder yg ada didalam directory this.path
    public String getListFolder(){

        Path path = Paths.get(this.path);

        try(Stream<Path> sub = Files.walk(path, 1)) {

            List<String> list = sub.filter(Files::isDirectory)
                    .map(Objects::toString) // Files::exits = mendapatkan folder yang ada di dlm directory this.path utk di inputkan ke dlm var listPath
                    .collect(Collectors.toList());

            return list.toString(); // merubah ke str

        }catch (NoSuchFileException ns){
            System.out.println(this.path + " directory not found");
        }catch (IOException ex){
            ex.printStackTrace();
        }

        return null;
    }

    // overload dari getListFolder
    public String getListFolder(String direktori){

        Path path = Paths.get(direktori);

        try(Stream<Path> sub = Files.walk(path, 1)) {

            List<String> list = sub.filter(Files::isDirectory)
                    .map(Objects::toString) // Files::exits = mendapatkan folder yang ada di dlm directory this.path utk di inputkan ke dlm var listPath
                    .collect(Collectors.toList());

            return list.toString(); // merubah ke str

        }catch (NoSuchFileException ns){
            System.out.println(this.path + " directory not found");
        }catch (IOException ex){
            ex.printStackTrace();
        }

        return null;
    }

    // menampilkan folder yg ada di dlm directory this.path
    public void showListFolder(){

        StringTokenizer buffer = new StringTokenizer(getListFolder(), ",");
        while (buffer.hasMoreTokens()){
            System.out.println(buffer.nextToken()); // show
        }
    }

    // overload dari showListFolder
    public void showListFolder(String direktori){

        StringTokenizer buffer = new StringTokenizer(getListFolder(direktori), ",");
        while (buffer.hasMoreTokens()){
            System.out.println(buffer.nextToken()); // show
        }
    }

    // menghitung jumlah folder yg ada di dlm directory ths.path
    public int getJumlahFolder(){

        StringTokenizer buffer = new StringTokenizer(getListFolder(), ",");
        int index = 0;

        while (buffer.hasMoreTokens()){
            buffer.nextToken();
            index++;
        }
        return index;
    }

    // overload dari getJumlahFolder
    public int getJumlahFolder(String direktori){

        StringTokenizer buffer = new StringTokenizer(getListFolder(direktori), ",");
        int index = 0;

        while (buffer.hasMoreTokens()){
            buffer.nextToken();
            index++;
        }
        return index;
    }

    // membuat filename (digunakan untuk method di class LocalDBase) untuk mebuat file baru
    public String getFileName(String direktori){

        StringTokenizer data = new StringTokenizer(direktori, "\\:");
        String buffer, out="";
            while (data.hasMoreTokens()){
                buffer = data.nextToken();
                out += buffer + "+"; // menganti '\' pada file name dgn '+' agar tidak exception

            }
        return out.substring(0, out.length()-1);
    }



}



