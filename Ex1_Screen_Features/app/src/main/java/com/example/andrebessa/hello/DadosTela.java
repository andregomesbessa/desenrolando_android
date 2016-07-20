package com.example.andrebessa.hello;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.andrebessa.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DadosTela extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_tela);

        final ListView listview = (ListView) findViewById(R.id.listview);

        Utils util = new Utils(getResources().getConfiguration(), getResources().getDisplayMetrics());
        util.printLogDadosTela();

        List<String> list = mountKeysList(util);

        final StableArrayAdapter adapter = new StableArrayAdapter(this,
                android.R.layout.simple_list_item_1, list, util);

        listview.setAdapter(adapter);

    }

    private List<String> mountKeysList(Utils util){

        List<String> keys = new ArrayList<String>();

        if(util.getDensity() != 0){
            keys.add(getResources().getString(R.string.density));
        }

        if(util.getOrientation() !=0 ){
            keys.add(getResources().getString(R.string.orientation));
        }

        if(util.getHeight() !=0 ){
            keys.add( getResources().getString(R.string.height));
        }

        if(util.getWidth() !=0 ){
            keys.add(getResources().getString(R.string.width));
        }

        if(util.getLocale() != null){
            keys.add(getResources().getString(R.string.language));
        }

        if(util.getMcc() !=0 ){
            keys.add(getResources().getString(R.string.mcc));
        }

        if(util.getMnc() !=0 ){
            keys.add(getResources().getString(R.string.mnc));
        }

        return keys;

    }

    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, String> mIdMap = new HashMap<String, String>();
        Context context;
        List<String> objects;

        public StableArrayAdapter(Context context, int textViewResourceId,
                                  List<String> objects, Utils util) {

            super(context, textViewResourceId, objects);

            if(util.getDensity() != 0){
                mIdMap.put(objects.get(0), String.valueOf(util.getDensity()));
            }

            if(util.getOrientation() !=0 ){
                mIdMap.put(objects.get(1), String.valueOf(util.getOrientation()));
            }

            if(util.getHeight() !=0 ){
                mIdMap.put(objects.get(2), String.valueOf(util.getHeight()));
            }

            if(util.getWidth() !=0 ){
                mIdMap.put(objects.get(3), String.valueOf(util.getWidth()));
            }

            if(util.getLocale() != null){
                mIdMap.put(objects.get(4), String.valueOf(util.getLocale()));
            }

            if(util.getMcc() !=0 ){
                mIdMap.put(objects.get(5), String.valueOf(util.getMcc()));
            }

            if(util.getMnc() !=0 ){
                mIdMap.put(objects.get(6), String.valueOf(util.getMnc()));
            }

            this.context = context;
            this.objects = objects;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View rowView = inflater.inflate(R.layout.item_caracteristica_tela, parent, false);

            TextView textViewValor = (TextView) rowView.findViewById(R.id.valorItem);
            textViewValor.setText(mIdMap.get(objects.get(position)));

            TextView textViewNome = (TextView) rowView.findViewById(R.id.nomeItem);
            textViewNome.setText(objects.get(position));

            return rowView;
        }

    }
}
