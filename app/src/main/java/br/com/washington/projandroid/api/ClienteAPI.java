package br.com.washington.projandroid.api;

import java.util.ArrayList;
import java.util.List;

import br.com.washington.projandroid.modelo.Cliente;

/**
 * Created by washington on 07/08/2017.
 */

public class ClienteAPI {
    public static List<Cliente> clientes() {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("WAS", "999999", "RUA TESTE ", "999", "8888"));
        clientes.add(new Cliente("ALEXANDRE", "888888", "RUA 888 ", "999", "8888"));

        return clientes;
    }

}
