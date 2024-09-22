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

public class QuizTela extends AppCompatActivity {

    private int contador = 1;
    static int pontos;

    TextView txtPergunta, txtNumPergunta;
    ImageView imgvPlaca;
    Button btnSair2, btnPlaca1, btnPlaca2, btnPlaca3, btnPlaca4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_quiz_tela);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtNumPergunta = findViewById(R.id.txtNumPergunta);
        txtPergunta = findViewById(R.id.txtPergunta);
        imgvPlaca = findViewById(R.id.imgvPlaca);
        btnSair2 = findViewById(R.id.btnSair2);
        btnPlaca1 = findViewById(R.id.btnPlaca1);
        btnPlaca2 = findViewById(R.id.btnPlaca2);
        btnPlaca3 = findViewById(R.id.btnPlaca3);
        btnPlaca4 = findViewById(R.id.btnPlaca4);

        atualizarTela();
    }

    public void Sair(View view) {
        finish();
    }

    public static int getPontos() {
        return pontos;
    }

    public static void setPontos(int pontos) {
        QuizTela.pontos = pontos;
    }

    private void atualizarTela() {
        switch (contador) {
            case 1:
                txtNumPergunta.setText("QUESTÃO 1");
                txtPergunta.setText("Qual é o significado desta placa?");
                imgvPlaca.setImageResource(R.drawable.retorno);
                btnPlaca1.setText("Curva acentuada à esquerda");
                btnPlaca2.setText("Retorno à esquerda");
                btnPlaca3.setText("Curva à direita");
                btnPlaca4.setText("Via lateral à direita");
                break;
            case 2:
                txtNumPergunta.setText("QUESTÃO 2");
                txtPergunta.setText("Qual é o significado desta placa?");
                imgvPlaca.setImageResource(R.drawable.direita);
                btnPlaca1.setText("Curva acentuada à direita");
                btnPlaca2.setText("Confluência à direita");
                btnPlaca3.setText("Curva à direita");
                btnPlaca4.setText("Vire à direita");
                break;
            case 3:
                txtNumPergunta.setText("QUESTÃO 3");
                txtPergunta.setText("Qual é o significado desta placa?");
                imgvPlaca.setImageResource(R.drawable.pedestre);
                btnPlaca1.setText("Área escolar");
                btnPlaca2.setText("Crianças");
                btnPlaca3.setText("Obras");
                btnPlaca4.setText("Trânsito de pedestre");
                break;
            case 4:
                txtNumPergunta.setText("QUESTÃO 4");
                txtPergunta.setText("Qual é o significado desta placa?");
                imgvPlaca.setImageResource(R.drawable.sinuosa);
                btnPlaca1.setText("Pista sinuosa");
                btnPlaca2.setText("Pesta escorregadia");
                btnPlaca3.setText("Pista irregular");
                btnPlaca4.setText("Projeção de cascalho");
                break;
            case 5:
                txtNumPergunta.setText("QUESTÃO 5");
                txtPergunta.setText("Qual é o significado desta placa?");
                imgvPlaca.setImageResource(R.drawable.afinandopista);
                btnPlaca1.setText("Pista irregular");
                btnPlaca2.setText("Declive acentuado");
                btnPlaca3.setText("Estreitamento de pista à direita");
                btnPlaca4.setText("Estreitamento de pedestres");
                break;
            case 6:
                Intent it = new Intent(getApplicationContext(), QuizResultado.class);
                startActivity(it);
                finish();
                break;
        }
    }

    public void Escolha1(View view) {
        if (verificarResposta(1)) {
            pontos++;
        }
        contador++;
        atualizarTela();
    }

    public void Escolha2(View view) {
        if (verificarResposta(2)) {
            pontos++;
        }
        contador++;
        atualizarTela();
    }

    public void Escolha3(View view) {
        if (verificarResposta(3)) {
            pontos++;
        }
        contador++;
        atualizarTela();
    }

    public void Escolha4(View view) {
        if (verificarResposta(4)) {
            pontos++;
        }
        contador++;
        atualizarTela();
    }

    private boolean verificarResposta(int escolha) {
        switch (contador) {
            case 1:
                return escolha == 2;
            case 2:
                return escolha == 1;
            case 3:
                return escolha == 4;
            case 4:
                return escolha == 1;
            case 5:
                return escolha == 3;
            default:
                return false;
        }
    }
}