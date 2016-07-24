package com.example.andrebessa.ex2_grid_imagens;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrebessa on 23/07/16.
 */
public class StableArrayAdapter extends ArrayAdapter<String> {


    Context context;
    List<String> objects;
    List<Parcelable> personagems;

    public StableArrayAdapter(Context context, int textViewResourceId,
                              ArrayList<String> nomes, List<Parcelable> personagems) {

        super(context, textViewResourceId, nomes);

        this.context = context;
        this.objects = objects;
        this.personagems = personagems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.item_list, parent, false);

        TextView textViewValor = (TextView)rowView.findViewById(R.id.nome);
        textViewValor.setText(((Personagem)personagems.get(position)).getNome());

        ImageView imageView = (ImageView) rowView.findViewById(R.id.image_aluno);
        imageView.setImageDrawable(ResourcesCompat.getDrawable(this.context.getResources(), ((Personagem)personagems.get(position)).getId(), null));

        return rowView;
    }
}
