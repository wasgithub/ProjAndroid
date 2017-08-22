package br.com.washington.projandroid;

import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import br.com.washington.projandroid.modelo.Cliente;

/**
 * Created by washington on 16/08/2017.
 */

public class FormularioHelper {

    private final EditText campoNome;
    private final EditText campoEndereco;
    private final EditText campoTelefone;
    private final EditText campoLatitude;
    private final EditText campoLogintude;
    private Cliente cliente;

    public FormularioHelper(FormularioActivity activity){

        campoNome = (EditText) activity.findViewById(R.id.formulario_cliente);
        campoEndereco = (EditText) activity.findViewById(R.id.formulario_endereco);
        campoTelefone = (EditText) activity.findViewById(R.id.formulario_telefone);
        campoLatitude = (EditText) activity.findViewById(R.id.formulario_latitude);
        campoLogintude = (EditText) activity.findViewById(R.id.formulario_logintude);
        cliente = new Cliente();
    }

    public Cliente pegaCliente() {
        cliente.setNome(campoNome.getText().toString());
        cliente.setEndereco(campoEndereco.getText().toString());
        cliente.setTelefone(campoTelefone.getText().toString());
        cliente.setLatitude(campoLatitude.getText().toString());
        cliente.setLatitude(campoLogintude.getText().toString());

        return cliente;
    }

    public void preencheFormulario(Cliente cliente) {

        campoNome.setText(cliente.getNome());
        campoEndereco.setText(cliente.getEndereco());
        campoTelefone.setText(cliente.getTelefone());
        campoLatitude.setText(cliente.getLatitude());
        campoLogintude.setText(cliente.getLongitude());
        this.cliente = cliente;

    }
}
