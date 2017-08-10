package br.com.washington.projandroid.modelo;

/**
 * Created by washington on 07/08/2017.
 */

public class Cliente {
    private final String nomeCliente;
    private final String telefoneCliente;
    private final String enderecoCliente;
    private final String logintudeCliente;
    private final String latitudeCliente;

    public Cliente(String nomeCliente, String telefoneCliente, String enderecoCliente, String logintudeCliente, String latitudeCliente ) {
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.enderecoCliente = enderecoCliente;
        this.logintudeCliente = logintudeCliente;
        this.latitudeCliente = latitudeCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public String getEnderecoCliente() {
        return enderecoCliente;
    }

    public String getLogintudeCliente() {
        return logintudeCliente;
    }

    public String getLatitudeCliente() {
        return latitudeCliente;
    }
}
