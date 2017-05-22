package quewquewcrew.appngasal.model.entity;

import java.util.ArrayList;

/**
 * Created by User on 5/22/2017.
 */

public class Lapangan {
    private int idLap;
    private String namalapan;
    private String alamat;
    private String kecamatan;
    private String notel;
    public static int _id = 1;

    public static ArrayList<Lapangan> lapangans = new ArrayList<>();
    public Lapangan(){

    }
    public int getIdLap() {
        return idLap;
    }

    public String getNameLap() {
        return namalapan;
    }

    public void setNameLap(String name) {
        this.namalapan = namalapan;
    }

    public String getAlamatLap() {
        return alamat;
    }

    public void setKecamatan(String email) {
        this.kecamatan = kecamatan;
    }


}
