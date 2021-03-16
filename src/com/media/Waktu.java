package com.media;

import java.util.Calendar;

/**
 *
 * @author Achmad Baihaqi
 * @since 2021-03-16
 */
public class Waktu {
    
    private final Calendar kalender = Calendar.getInstance();
    
    public static final String JANUARI = "Januari", FEBRUARI = "Februari", MARET = "Maret", APRIL = "April", 
                                MEI = "Mei", JUNI = "Juni", JULI = "Juli", AGUSTUS = "Agustus", SEPTEMBER = "September", 
                                OKTOBER = "Oktober", NOVEMBER = "November", DESEMBER = "Desember";
    
    public int getTahun(){
        return kalender.get(Calendar.YEAR);
    }
    
    public int getBulan(){
        return kalender.get(Calendar.MONTH);
    }
    
    public int getTanggal(){
        return kalender.get(Calendar.DAY_OF_MONTH);
    }
    
    public int getJam(){
        return kalender.get(Calendar.HOUR_OF_DAY);
    }
    
    public int getMenit(){
        return kalender.get(Calendar.MINUTE);
    }
    
    public int getDetik(){
        return kalender.get(Calendar.SECOND);
    }
    
    public String getDateNow(){
        return String.format("%d-%02d-%02d", getTahun(), getBulan()+1, getTanggal());
    }
    
    public static void main(String[] args) {
        Waktu waktu = new Waktu();
        System.out.println(waktu.getDateNow());
    }
    
}
