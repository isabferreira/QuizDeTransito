package com.example.quiztransito;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class QuizResultado extends AppCompatActivity {

    ImageView imgvReacao;
    Button btnSair;
    TextView txtResultado, txtMotivacional;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz_resultado);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imgvReacao = findViewById(R.id.imgvReacao);
        btnSair = findViewById(R.id.btnSair);
        txtResultado = findViewById(R.id.txtResultado);
        txtMotivacional = findViewById(R.id.txtMotivacional);

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuizTela.setPontos(0); // Reseta os pontos
                Intent it = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(it);
                finish();
            }
        });


        resultado();
    }

    public void resultado() {
        int pontos = QuizTela.getPontos();
        txtResultado.setText(pontos + "/5");
        if(pontos >= 3){
            txtMotivacional.setText("Parabéns, você foi ótimo/a!");
            imgvReacao.setImageResource(R.drawable.parabens);
        }
    }


}