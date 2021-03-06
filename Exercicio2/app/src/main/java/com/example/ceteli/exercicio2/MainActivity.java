package com.example.ceteli.exercicio2;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //chamando os objetos
        final EditText nome = (EditText) findViewById(R.id.edtTxtName);
        final EditText fone = (EditText) findViewById(R.id.edtTxtPhone);
        final EditText mail = (EditText) findViewById(R.id.edtTxtMail);
        final EditText salario = (EditText) findViewById(R.id.edtTxtSalario);
        final Button confirma = (Button) findViewById(R.id.btSend);
        final RadioGroup estadocivil = (RadioGroup) findViewById(R.id.rdGp1);
        final RadioButton casado = (RadioButton) findViewById(R.id.rdBtCasado);
        final RadioButton solteiro = (RadioButton) findViewById(R.id.rdBtSolteiro);
        final RadioButton divorciado = (RadioButton) findViewById(R.id.rdBtDivorciado);
        final CheckBox checkmail = (CheckBox) findViewById(R.id.ckBoxeMail);
        final CheckBox sms = (CheckBox) findViewById(R.id.ckBoxSMS);
        final CheckBox wpp = (CheckBox) findViewById(R.id.ckBoxWhatsApp);
        final ToggleButton toggle = (ToggleButton) findViewById(R.id.tgBtCadastro);
        final String[] msg = new String[1];;
        final String[]  String[][];
        String[][] msgemail;

        msgemail = new String[1][1];
        ;
        final String[] msgsms = new String[1];
        final String msgwpp;

        toggle.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v){
                if (((ToggleButton) v).isChecked()){
                    estadocivil.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                            if (casado.isChecked()) {
                                msg[0] = "casado";
                            }
                            if (solteiro.isChecked()) {
                                msg[0] = "solteiro";
                            }
                            if (divorciado.isChecked()) {
                                msg[0] = "divorciado";
                            }
                        }
                    });

                    confirma.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String mensagem = " ";
                            mensagem+= nome.getText().toString() + " \n";
                            mensagem+= fone.getText().toString() + " \n";
                            mensagem+= mail.getText().toString() + " \n";
                            mensagem+= salario.getText().toString() + " \n";
                            mensagem+= msg[0] + "\n";
                            mensagem+= msgsms[0] + "\n";
                            mensagem+= msgwpp + "\n";

                            Toast.makeText(MainActivity.this, mensagem, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else{
                    confirma.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String mensagem = "Cadastro Inativo";
                            Toast.makeText(MainActivity.this, mensagem, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
