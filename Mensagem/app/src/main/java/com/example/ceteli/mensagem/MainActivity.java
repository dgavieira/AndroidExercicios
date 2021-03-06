package com.example.ceteli.mensagem;

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
    EditText edtNome;
    EditText edtRegiao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNome = (EditText) findViewById(R.id.edtNome);
        Button btn = (Button) findViewById(R.id.btnCadastro);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarMensagem();
            }
        });
        EditText edtRegiao = (EditText) findViewById(R.id.edtRegiao);
        edtRegiao.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                usarToast("clique");
            }
        });
        edtRegiao.setOnClickListener(new View.OnClickListener(){

            public boolean onLongClick(View v){
                usarToast(" Long CLique");
                return false;
            }
        });
    }
    public void mostrarMensagem(){
        Intent intent = new Intent(this, MensagemActivity.class);
        intent.putExtra("nome", edtNome.getText().toString());
        startActivity(intent);
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
    public void usarToast(String msg){
        Toast.makeText(this, msg, 1000).show();
    }
}
