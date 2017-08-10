package br.com.washington.projandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import br.com.washington.projandroid.adapter.ClienteAdapter;
import br.com.washington.projandroid.adapter.OnItemClickListener;
import br.com.washington.projandroid.adapter.TesteClick;
import br.com.washington.projandroid.api.ClienteAPI;
import br.com.washington.projandroid.modelo.Cliente;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.recyclerView = (RecyclerView) findViewById(R.id.ClienteRecyclerView);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        this.recyclerView.setLayoutManager(layoutManager);
        this.recyclerView.setAdapter(new ClienteAdapter(ClienteAPI.clientes(), new OnItemClickListener() {
            @Override
            public void onItemClick(Cliente cliente) {
                Toast.makeText(getApplicationContext(), cliente.getNomeCliente(), Toast.LENGTH_SHORT).show();
            }
        }));

        //this.recyclerView.setAdapter(new ClienteAdapter(ClienteAPI.clientes(), new TesteClick()));
    }
}
