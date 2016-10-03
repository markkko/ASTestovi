package markko.testoviassprint;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Random;

import markko.testoviassprint.Pitanja.Kontroler;
import markko.testoviassprint.Pitanja.Odgovor;
import markko.testoviassprint.Pitanja.Pitanje;
import markko.testoviassprint.database.TestAdapter;

public class MainActivity extends AppCompatActivity {

    public static Kontroler kontroler;
    public static int[] idSlike = new int[40];

    public static SeekBar seekBar;

    private int brPitanja;
    private int negativni;
    private int test;

    private MyPagerAdapter ad;

    public static ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = getIntent();
        test = i.getIntExtra("test", 1);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ad = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(ad);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setProgress(0);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser)
                    mViewPager.setCurrentItem(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        putPitanja();
        setIdSlike();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_noviTest) {
            Intent intent = new Intent(this, StartActivity.class);
            startActivity(intent);
            kontroler = null;
            finish();
            return true;
        }
        if (id == R.id.action_zavrsi) {
            mViewPager.setCurrentItem(40);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("EXIT")
                .setMessage("Da li želite da izađete?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        MainActivity.super.onBackPressed();
                    }
                }).create().show();
    }

    public ViewPager getmViewPager() {
        return mViewPager;
    }

    public void putPitanja() {
        kontroler = new Kontroler();
        TestAdapter mDbHelper = new TestAdapter(this);
        mDbHelper.createDatabase();
        mDbHelper.open();
        try {
            Random rm = new Random();
            int randomNum, max, i;
            Pitanje p;
            Odgovor o;
            Cursor pitanja, odgovori;

            //teorija
            String teorija = "select * from pitanje where kat like ";
            if (test == 1)
                teorija += "'a%'";
            if (test == 2)
                teorija += "'%b%'";
            if (test == 3)
                teorija += "'%c%'";
            pitanja = mDbHelper.getData(teorija);
            max = pitanja.getCount() - 1;
            for (i = 0; i < 20; i++) {
                p = new Pitanje();
                randomNum = rm.nextInt(max) + 1;
                pitanja.moveToPosition(randomNum);
                p.setId(pitanja.getInt(0));
                p.setTekst(pitanja.getString(2));
                p.setOdgovor(pitanja.getInt(1));
                odgovori = mDbHelper.getData("select * from odgovor where idPitanje='" + p.getId() + "'");
                while (!odgovori.isAfterLast()) {
                    o = new Odgovor();
                    o.setId(odgovori.getInt(0));
                    o.setIdPitanja(odgovori.getInt(1));
                    o.setTekst(odgovori.getString(2));
                    p.getOdgovori().add(o);
                    odgovori.moveToNext();
                }
                kontroler.getPitanja().add(p);
                pitanja.moveToNext();
            }
            String src;
            pitanja = mDbHelper.getData("SELECT * FROM pitanje WHERE _id BETWEEN 302 and 410");
            max = pitanja.getCount() - 1;
            for (i = 20; i < 30; i++) {
                p = new Pitanje();
                randomNum = rm.nextInt(max) + 1;
                pitanja.moveToPosition(randomNum);
                p.setId(pitanja.getInt(0));
                p.setTekst(pitanja.getString(2));
                p.setOdgovor(pitanja.getInt(1));
                src = "s";
                src += p.getId() - 301;
                p.setIdSlike(getResources().getIdentifier(src,
                        "drawable", getPackageName()));
                odgovori = mDbHelper.getData("SELECT * FROM odgovor WHERE idPitanje = '" + p.getId() + "'");
                while (!odgovori.isAfterLast()) {
                    o = new Odgovor();
                    o.setId(odgovori.getInt(0));
                    o.setIdPitanja(odgovori.getInt(1));
                    o.setTekst(odgovori.getString(2));
                    p.getOdgovori().add(o);
                    odgovori.moveToNext();
                }
                kontroler.getPitanja().add(p);
                pitanja.moveToNext();
            }
            pitanja = mDbHelper.getData("SELECT * FROM pitanje WHERE _id BETWEEN 411 and 520");
            max = pitanja.getCount() - 1;
            for (i = 30; i < 40; i++) {
                p = new Pitanje();
                randomNum = rm.nextInt(max) + 1;
                pitanja.moveToPosition(randomNum);
                p.setId(pitanja.getInt(0));
                p.setTekst(pitanja.getString(2));
                p.setOdgovor(pitanja.getInt(1));
                src = "i";
                src += p.getId() - 410;
                p.setIdSlike(getResources().getIdentifier(src,
                        "drawable", getPackageName()));
                odgovori = mDbHelper.getData("SELECT * FROM odgovor WHERE idPitanje = '" + p.getId() + "'");
                while (!odgovori.isAfterLast()) {
                    o = new Odgovor();
                    o.setId(odgovori.getInt(0));
                    o.setIdPitanja(odgovori.getInt(1));
                    o.setTekst(odgovori.getString(2));
                    p.getOdgovori().add(o);
                    odgovori.moveToNext();
                }
                kontroler.getPitanja().add(p);
                pitanja.moveToNext();
            }
            mDbHelper.close();
        }
        finally {
            if (mDbHelper!=null)
                mDbHelper.close();
        }

    }

    public void setIdSlike() {
        for (int i=0; i<40; i++) {
            String mDrawableName="b"+(i+1);
            idSlike[i] = getResources().getIdentifier(mDrawableName, "drawable", getPackageName());
        }
    }

}
