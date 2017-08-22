package br.com.washington.projandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import br.com.washington.projandroid.adapter.ClienteAdapter;
import br.com.washington.projandroid.adapter.OnItemClickListener;
import br.com.washington.projandroid.adapter.TesteClick;
import br.com.washington.projandroid.api.ClienteAPI;
import br.com.washington.projandroid.dao.ClienteDAO;
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

        ClienteDAO dao = new ClienteDAO(this);
        List<Cliente> clientes = dao.buscaClientes();
        dao.close();

        this.recyclerView.setLayoutManager(layoutManager);
        this.recyclerView.setAdapter(new ClienteAdapter(clientes, new OnItemClickListener() {
            @Override
            public void onItemClick(Cliente cliente) {
                //Toast.makeText(this, "teste", Toast.LENGTH_SHORT).show();
            }
        }));

//        ClienteDAO dao = new ClienteDAO(this);
//        List<Cliente> clientes = dao.buscaClientes();
//        dao.close();
//        ArrayAdapter<Cliente> adapter = new ArrayAdapter<Cliente>(this, android.R.layout.simple_list_item_1, clientes);
//        this.recyclerView.setAdapter(adapter, new OnItemClickListener() {
//            @Override
//            public void onItemClick(Cliente cliente) {
//                Toast.makeText(getApplicationContext(), cliente.getNome(), Toast.LENGTH_SHORT).show();
//            }
//        }));

        Button novoCliente = (Button) findViewById(R.id.novo_cliente);
        novoCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Adicionar aluno", Toast.LENGTH_SHORT).show();
                Intent intentFormulario = new Intent(MainActivity.this, FormularioActivity.class);
                startActivity(intentFormulario);
            }
        });

        //this.recyclerView.setAdapter(new ClienteAdapter(ClienteAPI.clientes(), new TesteClick()));
    }



//    @Override
//    protected void onResume() {
//        super.onResume();
//        carregaDados();
//    }


}
