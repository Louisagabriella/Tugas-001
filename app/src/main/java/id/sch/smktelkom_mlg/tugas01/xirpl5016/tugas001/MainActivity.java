package id.sch.smktelkom_mlg.tugas01.xirpl5016.tugas001;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etNama, etNomer;
    Button bDaftar;
    TextView tvHasil;
    Spinner spKelas;
    RadioButton rL,r2,rM,rO,rP,rD;
    CheckBox cbA,cbB,cbC,cbD,cbE,cbF,cbG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNama = (EditText) findViewById(R.id.editTextNama);
        bDaftar = (Button) findViewById(R.id.buttonDaftar);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        spKelas= (Spinner) findViewById(R.id.spinnerKelas);
        etNomer= (EditText) findViewById(R.id.editTextNomer);
        rL= (RadioButton) findViewById(R.id.radioButtonLaki);
        r2= (RadioButton) findViewById(R.id.radioButton2);
        cbA=(CheckBox) findViewById(R.id.checkBoxA);
        cbB=(CheckBox) findViewById(R.id.checkBoxB);
        cbC=(CheckBox) findViewById(R.id.checkBoxC);
        cbD=(CheckBox) findViewById(R.id.checkBoxD);
        cbE=(CheckBox) findViewById(R.id.checkBoxE);
        cbF=(CheckBox) findViewById(R.id.checkBoxF);
        cbG=(CheckBox) findViewById(R.id.checkBoxG);
        rO= (RadioButton) findViewById(R.id.radioButtonM);
        rM= (RadioButton) findViewById(R.id.radioButtonO);
        rP= (RadioButton) findViewById(R.id.radioButtonP);
        rD= (RadioButton) findViewById(R.id.radioButtonD);


        bDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doProcess();
            }
        });
    }

    private void doProcess() {
        if(isValid())
        {
            String kelas = spKelas.getSelectedItem().toString();
            String nama = etNama.getText().toString();
            int nomer = Integer.parseInt(etNomer.getText().toString());
            String hasil = null;
            if(rL.isChecked())
            {
                hasil = rL.getText().toString();
            }
            else
            {
                hasil = r2.getText().toString();
            }
            String jenis = "Jenis Kelamin : "+hasil+"\n";
            String ekstra = "Anda Mengikuti Ekstrakulikuler : \n" ;
            int startlen = hasil.length();
            if(cbA.isChecked()) ekstra +="- "+cbA.getText()+"\n";
            if(cbB.isChecked()) ekstra +="- "+cbB.getText()+"\n";
            if(cbC.isChecked()) ekstra +="- "+cbC.getText()+"\n";
            if(cbD.isChecked()) ekstra +="- "+cbD.getText()+"\n";
            if(cbE.isChecked()) ekstra +="- "+cbE.getText()+"\n";
            if(cbF.isChecked()) ekstra +="- "+cbF.getText()+"\n";
            if(cbG.isChecked()) ekstra +="- "+cbG.getText()+"\n";

            String organ = null;
            if(rM.isChecked())
            {
                organ = rM.getText().toString();
            }
            else if (rO.isChecked())
            {
                organ = rO.getText().toString();
            }
            else if (rP.isChecked())
            {
                organ = rP.getText().toString();
            }
            else
            {
                organ = rD.getText().toString();
            }
            tvHasil.setText("Nama : "+nama+"\n"+"Kelas : "+kelas+"\n"+"Nomer Absen : "+nomer+"\n"+jenis+ekstra+"Anda Mengikuti Organisasi : "+organ+"\n");
        }
    }

    public boolean isValid() {
        boolean valid = true;
        String nama = etNama.getText().toString();
        String nomer = etNomer.getText().toString();
        if(nama.isEmpty())
        {
            etNama.setError("Anda Belum Mengisi Nama");
            valid = false;
        }
        else
        {
            etNama.setError(null);
        }
        if(nomer.isEmpty())
        {
            etNomer.setError("Anda Belum Mengisi Nomer Absen");
            valid = false;
        }
        else if(nomer.length()!=2)
        {
            etNomer.setError("Format Nomer Absen 2 angka");
            valid = false;
        }
        else
        {
            etNomer.setError(null);
        }
        return valid;
    }
}
