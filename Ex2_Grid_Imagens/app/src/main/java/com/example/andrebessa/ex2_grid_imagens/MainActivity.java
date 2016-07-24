package com.example.andrebessa.ex2_grid_imagens;

import android.content.Context;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> nomes;
    List<Parcelable> listaPersonagens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {

            nomes = savedInstanceState.getStringArrayList("nomes");
            listaPersonagens = savedInstanceState.getParcelableArrayList("listaPersonagem");

        } else {

            nomes = new ArrayList<String>(
                    Arrays.asList(getResources().getStringArray(R.array.lista_nomes_personagens)));

            listaPersonagens = montarListaPersonagens();
        }

        final StableArrayAdapter adapter = new StableArrayAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_1, nomes, listaPersonagens);

        GridView gridImagens = (GridView)findViewById(R.id.grid_imagens);
        gridImagens.setAdapter(adapter);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putStringArrayList("nomes", nomes);
        outState.putParcelableArrayList("listaPersonagem", (ArrayList<? extends Parcelable>) listaPersonagens);
    }

    private List<Parcelable> montarListaPersonagens(){

        List<Parcelable> lista = new ArrayList<Parcelable>();

        Personagem homer = new Personagem(nomes.get(0), R.drawable.homer);
        lista.add(homer);
        Personagem bart = new Personagem(nomes.get(1), R.drawable.bart);
        lista.add(bart);
        Personagem lisa = new Personagem(nomes.get(2), R.drawable.lisa);
        lista.add(lisa);
        Personagem maggie = new Personagem(nomes.get(3), R.drawable.maggie);
        lista.add(maggie);
        Personagem itchy = new Personagem(nomes.get(4), R.drawable.itchy);
        lista.add(itchy);
        Personagem ned_flanders = new Personagem(nomes.get(5), R.drawable.ned_flanders);
        lista.add(ned_flanders);
        Personagem ralph = new Personagem(nomes.get(6), R.drawable.ralph);
        lista.add(ralph);
        Personagem burns = new Personagem(nomes.get(7), R.drawable.burns);
        lista.add(burns);
        Personagem smithers = new Personagem(nomes.get(8), R.drawable.smithers);
        lista.add(smithers);
        Personagem apu = new Personagem(nomes.get(9), R.drawable.apu);
        lista.add(apu);
        Personagem comic_book_guy = new Personagem(nomes.get(10), R.drawable.comic_book_guy);
        lista.add(comic_book_guy);

        return lista;
    }
}
