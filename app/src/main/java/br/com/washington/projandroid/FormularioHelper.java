package br.com.washington.projandroid;

import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import br.com.washington.projandroid.modelo.Cliente;

/**
 * Created by washington on 16/08/2017.
 */

public class FormularioHelper {

    private final EditText nomeCliente;
    private final EditText telefoneCliente;
    private final EditText enderecoCliente;
    private final EditText logintudeCliente;
    private final EditText latitudeCliente;
    private Cliente cliente;

    public FormularioHelper(FormularioActivity activity){

        nomeCliente = (EditText) activity.findViewById(R.id.formulario_cliente);
        telefoneCliente = (EditText) activity.findViewById(R.id.formulario_endereco);
        enderecoCliente = (EditText) activity.findViewById(R.id.formulario_telefone);
        logintudeCliente = (EditText) activity.findViewById(R.id.formulario_logintude);
        latitudeCliente = (EditText) activity.findViewById(R.id.formulario_latitude);
       //cliente = new Cliente(nomeCliente, telefoneCliente, enderecoCliente, logintudeCliente, latitudeCliente );
    }

}
