package com.example.ceteli.login;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //chamando os objstos
       final EditText login = (EditText) findViewById(R.id.EdtTxtUser);
        final EditText senha = (EditText) findViewById(R.id.EdtTxtPassword);
        final Button entrar = (Button) findViewById(R.id.btConfirmar);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usercerto = "dgavieira";
                String senhacerta = "1234";
                String strLogin = login.getText().toString();
                String strSenha = senha.getText().toString();

                if (strLogin.equals(usercerto) && strSenha.equals(senhacerta) ){
                    Toast.makeText(MainActivity.this, "Bem-vindo!", Toast.LENGTH_SHORT).show();
                    login.setText("");
                }
                else{
                    Toast.makeText(MainActivity.this, "login invalido", Toast.LENGTH_SHORT).show();
                    senha.setText("");
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
