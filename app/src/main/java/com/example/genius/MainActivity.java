package com.example.genius;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import java.util.Random;
import android.graphics.Color;
//import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
//import android.widget.Button;
//import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AppCompatButton btn1;
    private AppCompatButton btn2;
    private AppCompatButton btn3;
    private AppCompatButton btn4;
    private TextView txt1;
    private TextView txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
    }

    int x = 1;
    int c = 0;
    int recorde = 0;
    int[] vet = new int[100]; //sequencia de cores do jogo
    int[] click = new int[100]; //sequencia de cores do jogador

    Random random = new Random(); //objeto para sortear a cor
    int sorteador = 0;

    public void novoJogo(View view){
        String frase = "Novo Jogo, Boa Sorte!";
        txt1.setText(frase);
        x = 1; //numero para saber quantas cores serão sorteadas
        c = 0; //numero para conferir a cor por click

        Jogo();
    }

    public void Jogo(){

        for (int i = 0;i < x;i++){

            sorteador = (random.nextInt(4)+1);
            vet[i] = sorteador;

            piscar(sorteador);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //tempo para sortear a próxima cor
                }
            },400);

        }
    }

    public void piscar(int cor){ //Para piscar uma cor
        Handler handler = new Handler();
        if (cor == 1){ // VERDE

            //mudar de cor
            btn1.setBackgroundColor(Color.parseColor("#008000"));


            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //retornar a cor original
                    btn1.setBackgroundColor(Color.parseColor("#98FB98"));
                }
            }, 500);

        } else if (cor == 2) { // VERMELHO

            //mudar de cor
            btn2.setBackgroundColor(Color.parseColor("#8B0000"));

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //retornar a cor orginal
                    btn2.setBackgroundColor(Color.parseColor("#FA8072"));
                }
            }, 500);

        } else if (cor == 3) { // AMARELO

            //muda de cor
            btn3.setBackgroundColor(Color.parseColor("#B8860B"));


            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //retornar a cor original
                    btn3.setBackgroundColor(Color.parseColor("#F0E68C"));
                }
            }, 500);

        }else{ // AZUL

            //muda de cor
            btn4.setBackgroundColor(Color.parseColor("#0000FF"));


            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    //retornar a cor original
                    btn4.setBackgroundColor(Color.parseColor("#B0E0E6"));
                }
            }, 500);
        }
    }

    public void Botao1(View view){
        piscar(1);
        click[c] = 1;

        confere();
    }

    public void Botao2(View view){
        piscar(2);
        click[c] = 2;

        confere();
    }

    public void Botao3(View view){
        piscar(3);
        click[c] = 3;

        confere();
    }

    public void Botao4(View view){
        piscar(4);
        click[c] = 4;

        confere();
    }

    public void confere(){

        if(click[c] != vet[c]){
            gameOver();
        }

        c += 1;

        if(c == x){
            x += 1;
            c=0;
            Jogo();
        }

    }

    public void gameOver(){
        String frase1 = "Você Perdeu, Clique em Novo Jogo!, Seu Score é " + x;
        txt1.setText(frase1);
        if(x>recorde){
            recorde=x;
            String frase2 = "Recorde: " + x;
            txt2.setText(frase2);
        }
    }


}






