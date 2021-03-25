package com.database;

/**
 *
 * @author Achmad Baihaqi
 * @since 2021-03-15
 */
public class Kelas extends Database{
    
    public Kelas(){
        this.startConnection();
    }
    
    public static final String
            // id kelas x
            ID_X_TPM1 = "x.tpm1", ID_X_TPM2 = "x.tpm2", ID_X_TPM3 = "x.tpm3", ID_X_TOI1 = "x.toi1",
            ID_X_TITL1 = "x.titl1", ID_X_TITL2 = "x.titl2", ID_X_TITL3 = "x.titl3", ID_X_RPL1 = "x.rpl1", 
            ID_X_RPL2 = "x.rpl2", ID_X_TBG1 = "x.tbg1", ID_X_TBG2 = "x.tbg2", ID_X_TBS1 = "x.tbs1", ID_X_TBS2 = "x.tbs2",
            // id kelas xi
            ID_XI_TPM1 = "xi.tpm1", ID_XI_TPM2 = "xi.tpm2", ID_XI_TPM3 = "xi.tpm3", ID_XI_TOI1 = "xi.toi1",
            ID_XI_TITL1 = "xi.titl1", ID_XI_TITL2 = "xi.titl2", ID_XI_TITL3 = "xi.titl3", ID_XI_RPL1 = "xi.rpl1", 
            ID_XI_RPL2 = "xi.rpl2", ID_XI_TBG1 = "xi.tbg1", ID_XI_TBG2 = "xi.tbg2", ID_XI_TBS1 = "xi.tbs1", ID_XI_TBS2 = "xi.tbs2",
            // id kelas xii & xiii
            ID_XII_TPM1 = "xii.tpm1", ID_XII_TPM2 = "xii.tpm2", ID_XII_TPM3 = "xii.tpm3", ID_XII_TOI1 = "xii.toi1",
            ID_XII_TITL1 = "xii.titl1", ID_XII_TITL2 = "xii.titl2", ID_XII_TITL3 = "xii.titl3", ID_XII_RPL1 = "xii.rpl1", 
            ID_XII_RPL2 = "xii.rpl2", ID_XII_TBG1 = "xii.tbg1", ID_XII_TBG2 = "xii.tbg2", ID_XII_TBS1 = "xii.tbs1", 
            ID_XII_TBS2 = "xii.tbs2", ID_XIII_TOI = "xiii.toi1";
    
    public static final String TPM = "TPM", TITL = "TITL", TOI = "TOI", TBS = "TBS", TBG = "TBG", RPL = "RPL";
    
    public boolean addKelas(String id, String namaKelas, String levelKelas, String jurusan){
        String query = "INSERT INTO kelas VALUES ("
                +"'"+id+"', '"+namaKelas+"', '"+levelKelas+"', '"+jurusan+"');";
        return this.addData(query);
    }
    
    public Object[][] getDataKelas(String kondisi){
        return null;
    }
    
    public Object[][] getDataKelas(){
        return this.getDataKelas("");
    }
    
    public String getNamaKelas(String id){
        return this.getData(KELAS, "nama_kelas", "WHERE id_kelas = '"+id+"'");
    }
    
    public boolean setNamaKelas(String nis, String newNama){
        return this.setData(KELAS, "nama_kelas", "id_kelas", nis, newNama);
    }
    
    public String getLevelKelas(String id){
        return this.getData(KELAS, "level_kelas", "WHERE id_kelas = '"+id+"'");
    }    
    
    public String getGelombang(String id){
        String namaKelas = getNamaKelas(id);
        return ""+namaKelas.charAt(namaKelas.length()-1);
    }
    
    public boolean setLevelKelas(String id, String newLevel){
        return this.setData(KELAS, "level_kelas", "id_kelas", id, newLevel);
    }
    
    public String getJurusan(String id){
        return this.getData(KELAS, "jurusan", "WHERE id_kelas = '"+id+"'");
    }
    
    public String getJurusanName(String id){
        switch(this.getJurusan(id)){
            case TPM: return "Teknik Pemesinan";
            case TITL: return "Teknik Instalasi Tenaga Listrik";
            case TOI: return "Teknik Otomasi Industri";
            case TBG: return "Tata Boga";
            case TBS: return "Tata Busana";
            case RPL: return "Rekayasa Perangkat Lunak";
            default : return null;
        }
    }
    
    public boolean setJurusan(String id, String newJurusan){
        return this.setData(KELAS, "jurusan", "id_kelas", id, newJurusan);
    }
    
    public boolean deleteKelas(String id){
        return this.deleteData(KELAS, "id_kelas", id);
    }
    
}
