package markko.testoviassprint.Pitanja;

import java.util.ArrayList;

/**
 * Created by Markko on 2/10/2016.
 */
public class Kontroler {

    private ArrayList<Pitanje> pitanja;
    private int negativni;

    public Kontroler() {
        pitanja = new ArrayList<Pitanje>(40);
        setNegativni(0);
    }

    public ArrayList<Pitanje> getPitanja() {
        return pitanja;
    }


    public void setOdgovor(int brPitanja) {

        boolean o1 = pitanja.get(brPitanja).getOdg1()==1;
        boolean o2 = pitanja.get(brPitanja).getOdg2()==1;
        boolean o3 = pitanja.get(brPitanja).getOdg3()==1;
        boolean o4 = pitanja.get(brPitanja).getOdg4()==1;
        int odgovor = pitanja.get(brPitanja).getOdgovor();
        boolean isTacno = false;
        switch (odgovor) {
            case 1:
                if (o1 && !o2 && !o3 && !o4)
                    isTacno=true;
                break;
            case 2:
                if (!o1 && o2 && !o3 && !o4)
                    isTacno=true;
                break;
            case 3:
                if (!o1 && !o2 && o3 && !o4)
                    isTacno=true;
                break;
            case 4:
                if (!o1 && !o2 && !o3 && o4)
                    isTacno=true;
                break;
            case 12:
                if (o1 && o2 && !o3 && !o4)
                    isTacno=true;
                break;
            case 13:
                if (o1 && !o2 && o3 && !o4)
                    isTacno=true;
                break;
            case 14:
                if (o1 && !o2 && !o3 && o4)
                    isTacno=true;
                break;
            case 23:
                if (!o1 && o2 && o3 && !o4)
                    isTacno=true;
                break;
            case 24:
                if (!o1 && o2 && !o3 && o4)
                    isTacno=true;
                break;
            case 34:
                if (!o1 && !o2 && o3 && o4)
                    isTacno=true;
                break;
            case 123:
                if (o1 && o2 && o3 && !o4)
                    isTacno=true;
                break;
            case 124:
                if (o1 && o2 && !o3 && o4)
                    isTacno=true;
                break;
            case 134:
                if (o1 && !o2 && o3 && o4)
                    isTacno=true;
                break;
            case 234:
                if (!o1 && o2 && o3 && o4)
                    isTacno=true;
                break;
        }
        pitanja.get(brPitanja).setIsTacno(isTacno);
    }

    public int getNegativni() {
        return negativni;
    }

    public void setNegativni(int negativni) {
        this.negativni = negativni;
    }
}
