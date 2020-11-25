package br.com.leandrocolevati.appjogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RetornoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retorno);

        EditText etResultado = (EditText) findViewById(R.id.etResultado);
        etResultado.setGravity(Gravity.CENTER);
        etResultado.setTextSize(16);
        etResultado.setInputType(View.LAYER_TYPE_NONE);

        Button btnVoltar = (Button) findViewById(R.id.btnVoltar);

        Intent intentMain = getIntent();
        Bundle bundleMain = intentMain.getExtras();
        int numeroGerado = bundleMain.getInt("numeroGerado");

        etResultado.setText("Parabéns! Você acertou o número: "+numeroGerado);

        btnVoltar.setOnClickListener(v -> voltar());
    }

    private void voltar(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }
}