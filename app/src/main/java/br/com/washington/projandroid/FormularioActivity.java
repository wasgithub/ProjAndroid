package br.com.washington.projandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import br.com.washington.projandroid.dao.ClienteDAO;
import br.com.washington.projandroid.modelo.Cliente;

public class FormularioActivity extends AppCompatActivity {

    private FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        helper = new FormularioHelper(this);

        Intent intent = getIntent();
        Cliente cliente = (Cliente) intent.getSerializableExtra("cliente");
        if(cliente != null){
            helper.preencheFormulario(cliente);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_formulario_ok:
                Cliente cliente = helper.pegaCliente();
                ClienteDAO dao = new ClienteDAO(this);

                if(cliente.getId() != 0){
                    dao.altera(cliente);
                } else {
                    dao.insere(cliente);
                }
                dao.close();

                Toast.makeText(FormularioActivity.this, "Cliente " + cliente.getNome() + " salvo!", Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.menu_formulario_cancel:
                Toast.makeText(FormularioActivity.this, "Cancelado pelo usuario", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
