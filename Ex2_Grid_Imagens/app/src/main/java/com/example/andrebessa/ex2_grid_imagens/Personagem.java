package com.example.andrebessa.ex2_grid_imagens;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by andrebessa on 23/07/16.
 */
public class Personagem implements Parcelable {

    String nome;
    int id;

    public Personagem(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nome);
        dest.writeInt(this.id);
    }

    protected Personagem(Parcel in) {
        this.nome = in.readString();
        this.id = in.readInt();
    }

    public static final Creator<Personagem> CREATOR = new Creator<Personagem>() {
        @Override
        public Personagem createFromParcel(Parcel source) {
            return new Personagem(source);
        }

        @Override
        public Personagem[] newArray(int size) {
            return new Personagem[size];
        }
    };
}
