package com.main;

import com.data.app.Log;
import com.data.input.DataSiswaDuplicate;
import java.util.Scanner;

/**
 *
 * @author Achmad Baihaqi
 * @since 2021-06-19
 */
public class Main {
    
    public static void main(String[] args) {
        
        boolean login = login();
        
        if(login){
            long start, finish;

            start = System.nanoTime();

            Main.inputData();

            finish = System.nanoTime();
            System.out.println("\nTotal Time : " + (finish-start)/1_000_000_000L + " detik.");            
        }else{
            System.out.println("PASSWORD YANG ANDA MASUKAN TIDAK COCOK.");
        }
        
        
    }
    
    public static boolean login(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukan Password : ");
        String pass = scan.next();
        
        return pass.equalsIgnoreCase("araso");
    }
    
    public static void inputData() {
        Log.createLog();
        
        Scanner scan = new Scanner(System.in);
        String input;
        boolean open = true;
        
        // akan melakukan loopin sampai user memilih input data
        while(open){
            // mengambil input data dari user
            System.out.println("-------- Pilih Input Data --------\n");
            System.out.println("  > 1. Data Petugas");
            System.out.println("  > 2. Data Siswa");
            System.out.println("  > 3. Random Pembayaran");
            System.out.print("\nMasukan Kode : ");
            input = scan.next();

            // mengecek input data yang dimasukan user
            switch(input){
                // jika input data adalah data petugas
                case "1": 
                    // jika user yakin ingin menginputkan data
                    if(Main.confirmInput("Data Petugas")){
                        // menginputkan data petugas
                        System.out.println("Input Data Petugas saat ini belum tersedia.");
                        open = false;
                    }else{
                        System.out.println("\nInput Data Petugas dibatalkan.");
                        open = false;
                    }
                break;
                // jika input data adalah data siswa
                case "2": 
                    // jika user yakin ingin menginputkan data
                    if(Main.confirmInput("Data Siswa")){
                        // menginputkan data petugas
                        Log.addLog("MENTRANSFER DATA SISWA KE DATABASE");
                        DataSiswaDuplicate.transferAllData();
                        open = false;
                    }else{
                        System.out.println("\nInput Data Siswa dibatalkan.");
                        open = false;
                    }
                break;
                // jika input data adalah random pembayaran
                case "3": 
                    if(Main.confirmInput("Random Pembayaran")){
                        // menginputkan random pembayaran
                        System.out.println("Random Pembayaran saat ini belum tersedia.");
                        open = false;
                    }else{
                        System.out.println("\nRandom Pembayaran dibatalkan.");
                        open = false;
                    }
                break;
                // jika input tidak terdaftar maka user diminta untuk menginputkan kode kembali
                default: System.out.println("\nERROR : Input yang Anda masukan tidak valid.");break;
            }            
        }
        
        System.out.println();
        Log.addLog("------------------------> Program Ditutup.");
        Log.saveLog();
        
    }
    
    /**
     * Untuk mengecek apakah user yakin atau tidak untuk menginputkan data.
     * @param data
     * @return 
     */
    private static boolean confirmInput(String data){
        Scanner scanner = new Scanner(System.in);
        String confirm;
        
        while(true){
            // mengambil input dari user
            System.out.println("\nAnda akan menginputkan data " + data + " ke Database.");
            System.out.print("Apakah Anda yakin Y/N : ");
            confirm = scanner.next().toLowerCase();

            // mengecek input dari user
            switch(confirm){
                case "y": return true;
                case "n": return false;
                default : System.out.println("ERROR : Input yang Anda masukan tidak valid.");
            }            
        }
    }
    
}
