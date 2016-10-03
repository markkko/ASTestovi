package markko.testoviassprint.Pitanja;

import java.util.ArrayList;

/**
 * Created by Markko on 2/10/2016.
 */
public class Pitanje {

    private String tekst="";
    private int odgovor;
    private int id;
    private ArrayList<Odgovor> odgovori;
    private boolean isTacno;
    private int odg1;
    private int odg2;
    private int odg3;
    private int odg4;
    private int idSlike;

    public Pitanje() {
        odgovori = new ArrayList<Odgovor>(4);
        isTacno=false;
        odg1=odg2=odg3=odg4=2;
    }

    public boolean isOdgovoreno() {
        if (odg1!=2 || odg2!=2 || odg3!= 2 || odg4!=2)
            return true;
        return false;
    }

    public int brojOdgovora() {
        return odgovori.size();
    }

    public int getIdSlike() {
        return idSlike;
    }

    public void setIdSlike(int id) {
        idSlike = id;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public int getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(int odgovor) {
        this.odgovor = odgovor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Odgovor> getOdgovori() {
        return odgovori;
    }

    public void setOdgovori(ArrayList<Odgovor> odgovori) {
        this.odgovori = odgovori;
    }

    public boolean isTacno() {
        return isTacno;
    }

    public void setIsTacno(boolean isTacno) {
        this.isTacno = isTacno;
    }

    public int getOdg1() {
        return odg1;
    }

    public void setOdg1(int odg1) {
        this.odg1 = odg1;
    }

    public int getOdg2() {
        return odg2;
    }

    public void setOdg2(int odg2) {
        this.odg2 = odg2;
    }

    public int getOdg3() {
        return odg3;
    }

    public void setOdg3(int odg3) {
        this.odg3 = odg3;
    }

    public int getOdg4() {
        return odg4;
    }

    public void setOdg4(int odg4) {
        this.odg4 = odg4;
    }
}
