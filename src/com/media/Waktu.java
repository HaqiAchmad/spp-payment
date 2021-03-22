package com.media;

import java.util.Calendar;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Achmad Baihaqi
 * @since 2021-03-16
 */
public class Waktu {
    
    private boolean update = false;
    
    private final Calendar kalender = Calendar.getInstance();
    
    private int tahun, bulan, tanggal, jam, menit, detik, milidetik;
    
    public static final String JANUARI = "Januari", FEBRUARI = "Februari", MARET = "Maret", APRIL = "April", 
                               MEI = "Mei", JUNI = "Juni", JULI = "Juli", AGUSTUS = "Agustus", SEPTEMBER = "September", 
                               OKTOBER = "Oktober", NOVEMBER = "November", DESEMBER = "Desember";
    
    public Waktu(){
        this.tahun = kalender.get(Calendar.YEAR);
        this.bulan = kalender.get(Calendar.MONTH);
        this.tanggal = kalender.get(Calendar.DAY_OF_MONTH);
        this.jam = kalender.get(Calendar.HOUR_OF_DAY);
        this.menit = kalender.get(Calendar.MINUTE);
        this.detik = kalender.get(Calendar.SECOND);
        this.milidetik = kalender.get(Calendar.MILLISECOND);
    }
    
    public int getTahun(){
        return tahun;
    }
    
    public int getBulan(){
        return bulan;
    }
    
    public int getTanggal(){
        return tanggal;
    }
    
    public int getJam(){
        return jam;
    }
    
    public int getMenit(){
        return menit;
    }
    
    public int getDetik(){
        return detik;
    }
    
    public int getMiliDetik(){
        return milidetik;
    }
    
    public String getDateNow(){
        return String.format("%d-%02d-%02d", getTahun(), getBulan()+1, getTanggal());
    }
    
    public String getTanggal(String tgl){
        int gHari, gBulan, gTahun;
        StringTokenizer token = new StringTokenizer(tgl, "-");
        gTahun = Integer.parseInt(token.nextToken());
        gBulan = Integer.parseInt(token.nextToken());
        gHari =  Integer.parseInt(token.nextToken());
        return String.format("%02d %s %02d", gHari, getNamaBulan(gBulan-1), gTahun);
    }
    
    public String getHari(){
        switch(kalender.get(Calendar.DAY_OF_WEEK)){
            case Calendar.SUNDAY: return "Minggu";
            case Calendar.MONDAY: return "Senin";
            case Calendar.TUESDAY: return "Selasa";
            case Calendar.WEDNESDAY: return "Rabu";
            case Calendar.THURSDAY: return "Kamis";
            case Calendar.FRIDAY: return "Jumat";
            case Calendar.SATURDAY: return "Sabtu";
            default: return "null";
        }
    }
    
    public String getNamaBulan(int bulan){
        switch(bulan){
            case Calendar.JANUARY: return "Januari";
            case Calendar.FEBRUARY: return "Februari";
            case Calendar.MARCH: return "Maret";
            case Calendar.APRIL: return "April";
            case Calendar.MAY: return "Mei";
            case Calendar.JUNE: return "Juni";
            case Calendar.JULY: return "Juli";
            case Calendar.AUGUST: return "Agustus";
            case Calendar.SEPTEMBER: return "September";
            case Calendar.OCTOBER: return "Oktober";
            case Calendar.NOVEMBER: return "November";
            case Calendar.DECEMBER: return "Desember";
            default: return "null";
        }
    }
    
    public void updateWaktu(){
        update = true;
        System.out.println("Update Waktu Aktif");
        new Thread(new Runnable(){
            
            @Override
            public void run(){
                try{
                    while(update){
                        milidetik+=1;
                        if(milidetik > 999){
                            detik++;
                            milidetik = 0;
                        }else if(detik > 59){
                            menit++;
                            detik = 0;
                        }else if(menit > 59){
                            jam++;
                            menit = 0;
                        }else if(jam > 23){
                            jam = 0;
                            tanggal++;
                        }
                        Thread.sleep(1);
                    }
                }catch(InterruptedException ex){
                    JOptionPane.showMessageDialog(null, "Terjadi Kesalahan : " + ex.getMessage(), "Pesan", JOptionPane.WARNING_MESSAGE);
                }
            }
        }).start();
    }
    
    public boolean isUpdate(){
        return update;
    }
    
    public void closeUpdate(){
        System.out.println("Update Waktu Dimatikan");
        update = false;
    }
    
    public String getUpdateWaktu(){
        return String.format(
                "%s, %02d %s %d | %02d:%02d:%02d", 
                this.getHari(), tanggal, this.getNamaBulan(bulan), tahun, jam, menit, detik
        );
    }
    
    public static void main(String[] args) {
        Waktu waktu = new Waktu();
        System.out.println(waktu.getDateNow());
        System.out.println(waktu.getHari());
        waktu.updateWaktu();
        
        new Thread(new Runnable(){
            
            @Override
            public void run(){
                try{
                    while(true){
                        System.out.println(waktu.getUpdateWaktu());
                        Thread.sleep(500);
                    }
                }catch(InterruptedException ex){
                    JOptionPane.showMessageDialog(null, "Terjadi Kesalahan : " + ex.getMessage(), "Pesan", JOptionPane.WARNING_MESSAGE);
                }
            }
        }).start();
    }
    
}
