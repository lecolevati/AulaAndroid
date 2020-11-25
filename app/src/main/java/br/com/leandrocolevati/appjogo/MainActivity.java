package br.com.leandrocolevati.appjogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText etTentativa = findViewById(R.id.etTentativa);
        etTentativa.setGravity(Gravity.CENTER);
        etTentativa.setInputType(View.LAYER_TYPE_NONE);

        EditText etNumero = (EditText) findViewById(R.id.etNumero);
        etNumero.setGravity(Gravity.CENTER);

        Button btnTentar = (Button) findViewById(R.id.btnTentar);

        //Gere um número aleatório de 1 a 100
        int numeroGerado = (int)((Math.random() * 100) + 1);

        /*
        btnTentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jogar(etNumero, numeroGerado, tvTentativa);
            }
        });
        */
        btnTentar.setOnClickListener(v -> jogar(etNumero, numeroGerado, etTentativa));
    }

    private void jogar(EditText etNumero, int numeroGerado, EditText etTentativa) {
        int numero = Integer.parseInt(etNumero.getText().toString());
        if (numero > numeroGerado) {
            etTentativa.setText("O número é menor !");
        }
        if (numero < numeroGerado) {
            etTentativa.setText("O número é maior !");
        }
        if (numero == numeroGerado) {
            vitoria(numeroGerado);
        }
    }

    private void vitoria(int numeroGerado) {
        Bundle bundle = new Bundle();
        bundle.putInt("numeroGerado", numeroGerado);

        Intent intent = new Intent(this, RetornoActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
        this.finish();
    }
}