package com.example.angel.myapplication.Models;

import android.content.Context;

import java.util.ArrayList;

public class Materia {

    public String nameMateria;
    public String id_Materia;
    public String getNameMateria() {
        return nameMateria;
    }

    public void setNameMateria(String nameMateria) {
        this.nameMateria = nameMateria;
    }

public Materia(String nombre, String id){
        this.id_Materia=id;
        this.nameMateria=nombre;
}

}
