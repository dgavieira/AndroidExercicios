package com.example.usuario.tratandoeventos;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    public static final int CONSTANTE_TELA_1 = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btnCadastro);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            enviarDados();
            }
        });
        EditText edtRegiao = (EditText) findViewById(R.id.edtRegiao);
        edtRegiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usarToast("Clique");
            }
        });
        edtRegiao.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                usarToast("Long Clique");
                return false;
            }
        });
    }
    public void usarToast(String msg){
        Toast.makeText(this, msg, 1000).show();
    }

    public void enviarDados(){
        EditText nome = (EditText) findViewById(R.id.edtNome);
        EditText regiao = (EditText) findViewById(R.id.edtRegiao);

        Bundle params = new Bundle();
        params.putString("nome", nome.getText().toString());
        params.putString("regiao", regiao.getText().toString());

        Intent intent = new Intent(this, MensagemActivity.class);
        intent.putExtras(params);

        startActivityForResult(intent, CONSTANTE_TELA_1);
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
