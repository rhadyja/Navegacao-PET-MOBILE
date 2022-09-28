package com.example.bottonnavegantion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TermicoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termico);
    }

    public void verificarAreaDoClique(double x, double y) {
        //receber uma lista, x do clique e y do clique
        //verificar cada índice da lista
        for (int k = 1; k < list.size(); k++) {
            if (list.consultar(0).getAtual() == list.consultar(k).getAtual()) {
                if (list.consultar(k).getX1() < x && x < list.consultar(k).getX2()
                        && list.consultar(k).getY1() < y && y < list.consultar(k).getY2()) { //verificando area que foi clicada
                    imageView.setImageResource(list.consultar(k).getProximo());//fazer troca da imagem atual pela proxima
                    break;
                }
            }
            break;
        }

        for (int i = 1; i < list.size(); i++) { //percorrendo a lista
            if (list.consultar(i).getX1() < x && x < list.consultar(i).getX2()
                    && list.consultar(i).getY1() < y && y < list.consultar(i).getY2()) { //verificando area que foi clicada
                imageView.setImageResource(list.consultar(i).getProximo()); //fazer troca da imagem atual pela proxima
                break;
            }
            for (int j = i + 1; j < list.size() - 1; j++) {
                if (list.consultar(i).getProximo() == list.consultar(j).getAtual()) {
                    i = j - 1;
                    break;
                }
                break;
            }
        }
    }
}