package com.example.angel.myapplication.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.angel.myapplication.Models.Materia;
import com.example.angel.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MateriaAdapter extends BaseAdapter {


        private Context mContext;
        private LayoutInflater mInflater;
        private ArrayList<Materia> mDataSource;

        private static final HashMap<String, Integer> LABEL_COLORS = new HashMap<String, Integer>() {{
            put("Materia mas Solicitada", R.color.colorMateriaHigh);
            put("Materia menos solicitada", R.color.colorMateriaLow);

        }};

        public MateriaAdapter(Context context, ArrayList<Materia> items) {
            mContext = context;
            mDataSource = items;
            mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return mDataSource.size();
        }

        @Override
        public Object getItem(int position) {
            return mDataSource.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }


}
