package markko.testoviassprint;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import markko.testoviassprint.Pitanja.Pitanje;

public class OdgovoriActivity extends AppCompatActivity {

    private ArrayList<Pitanje> pitanja;
    private Button[] buttons;
    public static Pitanje p;
    public static boolean toast=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odgovori);
        pitanja = MainActivity.kontroler.getPitanja();
        setButtons();
    }

    public void setButtons() {
        buttons = new Button[40];
        buttons[0] = (Button) findViewById(R.id.button1);
        buttons[1] = (Button) findViewById(R.id.button2);
        buttons[2] = (Button) findViewById(R.id.button3);
        buttons[3] = (Button) findViewById(R.id.button4);
        buttons[4] = (Button) findViewById(R.id.button5);
        buttons[5] = (Button) findViewById(R.id.button6);
        buttons[6] = (Button) findViewById(R.id.button7);
        buttons[7] = (Button) findViewById(R.id.button8);
        buttons[8] = (Button) findViewById(R.id.button9);
        buttons[9] = (Button) findViewById(R.id.button10);
        buttons[10] = (Button) findViewById(R.id.button11);
        buttons[11] = (Button) findViewById(R.id.button12);
        buttons[12] = (Button) findViewById(R.id.button13);
        buttons[13] = (Button) findViewById(R.id.button14);
        buttons[14] = (Button) findViewById(R.id.button15);
        buttons[15] = (Button) findViewById(R.id.button16);
        buttons[16] = (Button) findViewById(R.id.button17);
        buttons[17] = (Button) findViewById(R.id.button18);
        buttons[18] = (Button) findViewById(R.id.button19);
        buttons[19] = (Button) findViewById(R.id.button20);
        buttons[20] = (Button) findViewById(R.id.button21);
        buttons[21] = (Button) findViewById(R.id.button22);
        buttons[22] = (Button) findViewById(R.id.button23);
        buttons[23] = (Button) findViewById(R.id.button24);
        buttons[24] = (Button) findViewById(R.id.button25);
        buttons[25] = (Button) findViewById(R.id.button26);
        buttons[26] = (Button) findViewById(R.id.button27);
        buttons[27] = (Button) findViewById(R.id.button28);
        buttons[28] = (Button) findViewById(R.id.button29);
        buttons[29] = (Button) findViewById(R.id.button30);
        buttons[30] = (Button) findViewById(R.id.button31);
        buttons[31] = (Button) findViewById(R.id.button32);
        buttons[32] = (Button) findViewById(R.id.button33);
        buttons[33] = (Button) findViewById(R.id.button34);
        buttons[34] = (Button) findViewById(R.id.button35);
        buttons[35] = (Button) findViewById(R.id.button36);
        buttons[36] = (Button) findViewById(R.id.button37);
        buttons[37] = (Button) findViewById(R.id.button38);
        buttons[38] = (Button) findViewById(R.id.button39);
        buttons[39] = (Button) findViewById(R.id.button40);

        int negativni=0;

        for (int i = 0; i < 20; i++) {
            if (!pitanja.get(i).isTacno()) {
                negativni += 2;
                buttons[i].setBackgroundColor(Color.RED);
                buttons[i].setText("-2");
            }
            else
                buttons[i].setBackgroundColor(Color.GREEN);
        }
        for (int i = 20; i < 30; i++) {
            if (!pitanja.get(i).isTacno()) {
                negativni += 3;
                buttons[i].setBackgroundColor(Color.RED);
                buttons[i].setText("-3");
            }
            else
                buttons[i].setBackgroundColor(Color.GREEN);
        }
        for (int i = 30; i < 40; i++) {
            if (!pitanja.get(i).isTacno()) {
                negativni += 5;
                buttons[i].setBackgroundColor(Color.RED);
                buttons[i].setText("-5");
            }
            else
                buttons[i].setBackgroundColor(Color.GREEN);
        }

        TextView negativniTW = (TextView) findViewById(R.id.negativniTW);
        negativniTW.setText(Integer.toString(negativni));
        if (negativni < 11)
            negativniTW.setTextColor(Color.GREEN);
        else
            negativniTW.setTextColor(Color.RED);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("EXIT")
                .setMessage("Da li želite da izađete?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        OdgovoriActivity.super.onBackPressed();
                    }
                }).create().show();
    }

    public void onClickBtn(View v) {
        Button btn = (Button) v;
        int id = btn.getId();
        for (int i = 0; i < 40; i++)
            if (id == buttons[i].getId()) {
                p = pitanja.get(i);
                Intent in = new Intent(this, OdgovorActivity.class);
                in.putExtra("id", i);
                startActivity(in);
            }
    }

    public void onClickA (View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("test", 1);
        pitanja = null;
        MainActivity.kontroler=null;
        startActivity(intent);
        finish();
    }
    public void onClickB (View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("test", 2);
        pitanja = null;
        MainActivity.kontroler=null;
        startActivity(intent);
        finish();
    }
    public void onClickC (View v) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("test", 3);
        pitanja = null;
        MainActivity.kontroler=null;
        startActivity(intent);
        finish();
    }
}
