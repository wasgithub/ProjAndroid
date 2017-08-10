package br.com.washington.projandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etLogin;
    private EditText etSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //recupera os componentes da tela
        etLogin = (EditText) findViewById(R.id.etUsuario);
        etSenha = (EditText) findViewById(R.id.etSenha);
    }

    //clique no botao
    public void logar(View view) {

        String login = etLogin.getText().toString();
        String senha = etSenha.getText().toString();

        //valida o usuario e senha
        if (login.equals("admin") && senha.equals("")) {
            //mudar de tela de destino
            Intent intent = new Intent(this, MainActivity.class);
            //passar valor para proxima tela
            intent.putExtra("usuario", login);
            //inicia a outra tela
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, "Senha incorreta", Toast.LENGTH_SHORT).show();
        }
    }
}
