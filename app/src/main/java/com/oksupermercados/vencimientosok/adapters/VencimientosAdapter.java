package com.oksupermercados.vencimientosok.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.oksupermercados.vencimientosok.R;
import com.oksupermercados.vencimientosok.model.Vencimiento;

import java.util.List;

public class VencimientosAdapter extends RecyclerView.Adapter<VencimientosAdapter.View> {

    private List<Vencimiento> vencimientos;
    private Context context;

    public VencimientosAdapter(List<Vencimiento> vencimientos, Context context) {
        this.vencimientos = vencimientos;
        this.context = context;
    }

    @NonNull
    @Override
    public VencimientosAdapter.View onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VencimientosAdapter.View(LayoutInflater.from(context).inflate(R.layout.cardview_vencimiento,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull VencimientosAdapter.View holder, int position) {
        holder.mostrarDatos(vencimientos.get(position));
    }

    @Override
    public int getItemCount() {
        return vencimientos.size();
    }

    public void addVencimiento(Vencimiento vencimiento){
        vencimientos.add(vencimiento);
        notifyItemInserted(getItemCount()-1);
    }

    public class View extends RecyclerView.ViewHolder {

        TextView codigo;
        TextView fechaVencimiento;

        public View(@NonNull android.view.View itemView) {
            super(itemView);

            codigo = itemView.findViewById(R.id.codigo);
            fechaVencimiento = itemView.findViewById(R.id.fechaVencimiento);

        }
        public void mostrarDatos(Vencimiento vencimiento){
            codigo.setText(vencimiento.getCodf());
            fechaVencimiento.setText(vencimiento.getFec_venc().toString());
        }
    }
}
