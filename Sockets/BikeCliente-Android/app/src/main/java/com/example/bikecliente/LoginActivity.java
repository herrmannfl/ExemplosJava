package com.example.bikecliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import controller.ConexaoController;

public class LoginActivity extends AppCompatActivity {

    EditText edtUsuario, edtSenha;
    Button btnEntrar;

    InformacoesApp infoApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // associar os componentes
        edtUsuario = findViewById(R.id.edtUsuario);
        edtSenha = findViewById(R.id.edtSenha);
        btnEntrar = findViewById(R.id.btnEntrar);

        // pegar o contexto (Application)
        infoApp = (InformacoesApp) getApplicationContext();

        Thread t = new Thread(){
            @Override
            public void run() {
                ConexaoController ccont = new ConexaoController(infoApp);
                ccont.Conectar();
            }
        };
        t.start();

        // declarar os enventos
        btnEntrar.setOnClickListener(cliqueEntrar);
    }

    View.OnClickListener cliqueEntrar = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent it = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(it);
        }
    };

}
