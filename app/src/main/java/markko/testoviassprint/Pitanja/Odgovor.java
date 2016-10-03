package markko.testoviassprint.Pitanja;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Markko on 2/10/2016.
 */
public class Odgovor implements Parcelable {

    private String tekst="";
    private int id;
    private int idPitanja;

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPitanja() {
        return idPitanja;
    }

    public void setIdPitanja(int idPitanja) {
        this.idPitanja = idPitanja;
    }

    public static final Creator<Odgovor> CREATOR = new Parcelable.Creator<Odgovor>() {

        public Odgovor createFromParcel(Parcel source) {
            Odgovor mOdgovor = new Odgovor();
            mOdgovor.tekst = source.readString();
            mOdgovor.id = source.readInt();
            mOdgovor.idPitanja = source.readInt();
            return mOdgovor;
        }

        public Odgovor[] newArray(int size) {
            return new Odgovor[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tekst);
        dest.writeInt(id);
        dest.writeInt(idPitanja);
    }
}
