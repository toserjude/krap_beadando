package uni.eszterhazy.krap.model;


import org.springframework.format.annotation.DateTimeFormat;
import uni.eszterhazy.krap.exceptions.RosszGyartasiEv;
import uni.eszterhazy.krap.exceptions.RosszKobcenti;
import uni.eszterhazy.krap.exceptions.RosszDatum;
import uni.eszterhazy.krap.exceptions.UresMezo;

import java.time.LocalDate;
import java.util.UUID;


public class Auto {

    private String rendszam;
    private String marka;
    private String model;
    private int hengerurtartalom;
    private String tulajdonos;
    private int gyartasEve;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate muszakiVizsgaIdo;
    private Uzemanyag uzemanyag;

    public Auto() {}

    public String getRendszam() {
        return rendszam;
    }

    public void setRendszam(String rendszam) throws UresMezo {
        if (rendszam.isEmpty()) {
            throw new UresMezo();
        }
        this.rendszam = rendszam;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) throws UresMezo {
        if (marka.isEmpty()) {
            throw new UresMezo();
        }
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) throws UresMezo {
        if (model.isEmpty()) {
            throw new UresMezo();
        }
        this.model = model;
    }

    public int getHengerurtartalom() {
        return hengerurtartalom;
    }

    public void setHengerurtartalom(int hengerurtartalom) throws RosszKobcenti {
        if (hengerurtartalom < 800 || hengerurtartalom > 5000) {
            throw new RosszKobcenti(hengerurtartalom);
        }
        this.hengerurtartalom = hengerurtartalom;
    }

    public String getTulajdonos() {
        return tulajdonos;
    }

    public void setTulajdonos(String tulajdonos) throws UresMezo {
        if (tulajdonos.isEmpty()) {
            throw new UresMezo();
        }
        this.tulajdonos = tulajdonos;
    }

    public int getGyartasEve() {
        return gyartasEve;
    }

    public void setGyartasEve(int gyartasEve) throws RosszGyartasiEv {
        int date = LocalDate.now().getYear();
        if (gyartasEve < 1900 || gyartasEve > date) {
            throw new RosszGyartasiEv(gyartasEve);
        }
        this.gyartasEve = gyartasEve;
    }

    public LocalDate getMuszakiVizsgaIdo() {
        return muszakiVizsgaIdo;
    }

    public void setMuszakiVizsgaIdo(LocalDate muszakiVizsgaIdo) throws RosszDatum {
        if (muszakiVizsgaIdo.isAfter(LocalDate.now())) {
            throw new RosszDatum("Műszaki vizsga ideje a jövőbe mutat: " + muszakiVizsgaIdo);
        }
        this.muszakiVizsgaIdo = muszakiVizsgaIdo;
    }

    public Uzemanyag getUzemanyag() {
        return uzemanyag;
    }

    public void setUzemanyag(Uzemanyag uzemanyag) {
        this.uzemanyag = uzemanyag;
    }

}
