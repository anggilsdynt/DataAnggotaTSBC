package id.sch.smktelkom_mlg.tugas01.xiirpl3005.dataanggotatsbc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText isinama;
    Button bOK;
    RadioButton rbL, rbP;
    TextView tvHasil, tvJk;
    CheckBox cbM, cbB, cbH;
    Spinner spNopung;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isinama = (EditText) findViewById(R.id.editTextNama);
        rbL = (RadioButton) findViewById(R.id.radioButtonLaki);
        rbP = (RadioButton) findViewById(R.id.radioButtonPerempuan);
        bOK = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvJk = (TextView) findViewById(R.id.textView3);
        spNopung = (Spinner) findViewById(R.id.spinnerNopung);
        cbM = (CheckBox) findViewById(R.id.checkBoxMerah);
        cbB = (CheckBox) findViewById(R.id.checkBoxBiru);
        cbH = (CheckBox) findViewById(R.id.checkBoxHitam);

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                doClick();
            }
        });

    }

    private void doClick()
    {
        if (isValid()) {
            //edit text
            String nama = isinama.getText().toString();

            //radio button
            String jk = "(Not choosen)";

            if (rbL.isChecked()) {
                jk = rbL.getText().toString();
            } else if (rbP.isChecked()) {
                jk = rbP.getText().toString();
            }

            //spinner
            String nopung = spNopung.getSelectedItem().toString();

            //checkbox
            String warna = "Warna Jersey Saat Ini :\n";
            int startlen = warna.length();
            if (cbM.isChecked()) warna += cbM.getText() + "\n";
            if (cbB.isChecked()) warna += cbB.getText() + "\n";
            if (cbH.isChecked()) warna += cbH.getText() + "\n";

            if (warna.length() == startlen) warna += "(No object was choosen)";

            //hasil
            tvHasil.setText("Name        : " + nama + "\n" + "Jenis Kelamin      : " + jk + "\n"
                    + "No. Punggung         : " + nopung + "\n" + warna);
        }
    }

    public boolean isValid() {
        boolean valid = true;

        String nama = isinama.getText().toString();
        String jk = "";

        if (nama.isEmpty()) {
            isinama.setError("Name must be filled!");
            valid = false;
        } else if (nama.length() < 3) {
            isinama.setError("Name min have 3 characters");
            valid = false;
        } else {
            isinama.setError(null);
        }

        if (jk == null) {
            tvJk.setError("");
            valid = false;
        } else {
            tvJk.setError(null);
        }
        return valid;
    }
}


