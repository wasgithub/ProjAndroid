package br.com.washington.projandroid.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.washington.projandroid.R;
import br.com.washington.projandroid.modelo.Cliente;

/**
 * Created by washington on 06/08/2017.
 */

public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ClienteViewHolder>  {
    private List<Cliente> clientes;
    private OnItemClickListener onItemClickListener;

    public ClienteAdapter(List<Cliente> clientes, OnItemClickListener onItemClickListener) {
        this.clientes = clientes;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ClienteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cliente_lista, parent, false);
        return new ClienteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ClienteViewHolder holder, int position) {
        final Cliente cliente = this.clientes.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(cliente);
            }
        });

        holder.nomeCliente.setText(cliente.getNomeCliente());
        holder.telefoneCliente.setText(cliente.getTelefoneCliente());
        holder.enderecoCliente.setText(cliente.getEnderecoCliente());
        holder.logintudeCliente.setText(cliente.getLogintudeCliente());
        holder.latitudeCliente.setText(cliente.getLatitudeCliente());
    }

    @Override
    public int getItemCount() {
        return this.clientes.size();
    }


    static class ClienteViewHolder extends RecyclerView.ViewHolder {

        final TextView nomeCliente;
        final TextView telefoneCliente;
        final TextView enderecoCliente;
        final TextView logintudeCliente;
        final TextView latitudeCliente;

        public ClienteViewHolder(View itemView) {
            super(itemView);
            this.nomeCliente = (TextView) itemView.findViewById(R.id.nomeCliente);
            this.telefoneCliente = (TextView) itemView.findViewById(R.id.telefoneCliente);
            this.enderecoCliente = (TextView) itemView.findViewById(R.id.enderecoCliente);
            this.logintudeCliente = (TextView) itemView.findViewById(R.id.logintudeCliente);
            this.latitudeCliente = (TextView) itemView.findViewById(R.id.latitudeCliente);
        }
    }

}
