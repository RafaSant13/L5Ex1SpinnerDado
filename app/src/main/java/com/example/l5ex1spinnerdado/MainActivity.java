package com.example.l5ex1spinnerdado;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbDado1;
    private RadioButton rbDado2;
    private RadioButton rbDado3;
    private Spinner spFaceDado;
    private TextView tvResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rbDado1 = findViewById(R.id.rbDado1);
        rbDado1.setChecked(true);
        rbDado2 = findViewById(R.id.rbDado2);
        rbDado3 = findViewById(R.id.rbDado3);
        spFaceDado = findViewById(R.id.spFaceDado);
        tvResultado = findViewById(R.id.tvResultado);
        preencheSpinner();

        Button btnJogar = findViewById(R.id.btnJogar);
        btnJogar.setOnClickListener(op -> jogarDados());
    }

    private void jogarDados() {
        StringBuffer buffer = new StringBuffer();
        int face = (Integer) spFaceDado.getSelectedItem();
        int qtd, i;
        if (rbDado1.isChecked()){
            qtd = 1;
        }
        else if (rbDado2.isChecked()){
            qtd = 2;
        }
        else{
            qtd = 3;
        }
        for (i = 1; i<=qtd; i++){
            buffer.append("Dado " + i +": " + geraNumero(face) + "\n");
        }
        tvResultado.setText(buffer.toString());
    }

    private int geraNumero(int face) {
        Random rnd = new Random();
        return rnd.nextInt(face)+1;
    }

    private void preencheSpinner() {
        List<Integer> lista = new ArrayList<>();
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);
        lista.add(20);
        lista.add(100);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spFaceDado.setAdapter(adapter);
    }
}