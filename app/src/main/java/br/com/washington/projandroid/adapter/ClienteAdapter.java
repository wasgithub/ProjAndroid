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

        holder.nome_cli.setText(cliente.getNome());
        holder.tel_cli.setText(cliente.getTelefone());
        holder.end_cli.setText(cliente.getEndereco());
        holder.lat_cli.setText(cliente.getLatitude());
        holder.lon_cli.setText(cliente.getLongitude());
    }

    @Override
    public int getItemCount() {
        return this.clientes.size();
    }


    static class ClienteViewHolder extends RecyclerView.ViewHolder {

        final TextView nome_cli;
        final TextView tel_cli;
        final TextView end_cli;
        final TextView lat_cli;
        final TextView lon_cli;

        public ClienteViewHolder(View itemView) {
            super(itemView);
            this.nome_cli = (TextView) itemView.findViewById(R.id.nomeCliente);
            this.tel_cli = (TextView) itemView.findViewById(R.id.telefoneCliente);
            this.end_cli = (TextView) itemView.findViewById(R.id.enderecoCliente);
            this.lat_cli = (TextView) itemView.findViewById(R.id.logintudeCliente);
            this.lon_cli = (TextView) itemView.findViewById(R.id.latitudeCliente);
        }
    }

}
