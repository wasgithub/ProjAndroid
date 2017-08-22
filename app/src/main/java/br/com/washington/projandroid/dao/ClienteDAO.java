package br.com.washington.projandroid.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import br.com.washington.projandroid.modelo.Cliente;

/**
 * Created by washington on 16/08/2017.
 */

public class ClienteDAO  extends SQLiteOpenHelper {

    public ClienteDAO(Context context) {
        super(context, "Agenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Clientes (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, endereco TEXT, telefone TEXT, longitude TEXT, latitude TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Clientes";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Cliente cliente) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaDadosDoCliente(cliente);

        db.insert("Clientes", null, dados);
    }

    @NonNull
    private ContentValues pegaDadosDoCliente(Cliente cliente) {
        ContentValues dados = new ContentValues();
        dados.put("nome", cliente.getNome());
        dados.put("endereco", cliente.getEndereco());
        dados.put("telefone", cliente.getTelefone());
        dados.put("longitude", cliente.getLongitude());
        dados.put("latitude", cliente.getLatitude());
        return dados;
    }

    public List<Cliente> buscaClientes() {

        String sql = "SELECT * FROM Clientes;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(sql, null);

        List<Cliente> clientes = new ArrayList<Cliente>();
        while (c.moveToNext()) {
            Cliente cliente = new Cliente();
            cliente.setId(c.getLong(c.getColumnIndex("id")));
            cliente.setNome(c.getString(c.getColumnIndex("nome")));
            cliente.setEndereco(c.getString(c.getColumnIndex("endereco")));
            cliente.setTelefone(c.getString(c.getColumnIndex("telefone")));
            cliente.setLongitude(c.getString(c.getColumnIndex("longitude")));
            cliente.setLatitude(c.getString(c.getColumnIndex("latitude")));

            clientes.add(cliente);
        }
        c.close();

        return clientes;
    }

    public void deleta(Cliente cliente) {
        SQLiteDatabase db = getWritableDatabase();

        String[] params = {String.valueOf(cliente.getId())};
        db.delete("Clientes", "id = ?", params);
        db.close();

    }

    public void altera(Cliente cliente) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaDadosDoCliente(cliente);
        String[] params = {String.valueOf(cliente.getId())};
        db.update("Clientes", dados, "id=?", params);

    }
}

