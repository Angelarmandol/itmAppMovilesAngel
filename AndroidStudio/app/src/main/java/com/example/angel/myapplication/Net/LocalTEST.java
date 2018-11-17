package com.example.angel.myapplication.Net;

import android.content.Context;

import com.example.angel.myapplication.Models.Materia;

import java.util.ArrayList;

public class LocalTEST {


    ArrayList<Materia> MateriasArrayList = new ArrayList<>();



    public static ArrayList<Materia> setMateriasLocal(){
        final ArrayList<Materia> materiasaList = new ArrayList<>();

        try {
            for(int i = 0; i < materiasaList.size(); i++){
                Materia materia = new Materia();

                materia.nameMateria="desdetexto"+i;
                materiasaList.add(materia);
            }
        } catch (Exception e ) {
            e.printStackTrace();
        }

        return materiasaList;
    }

}
