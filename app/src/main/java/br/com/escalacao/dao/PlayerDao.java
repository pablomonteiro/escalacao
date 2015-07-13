package br.com.escalacao.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import br.com.escalacao.domain.Player;

/**
 * Created by pablo on 12/07/15.
 */
public class PlayerDao {

    private static final String TABELA = "PLAYER";

    private DatabaseHelper helper;
    private SQLiteDatabase db;

    public PlayerDao(Context context){
        helper = new DatabaseHelper(context);
    }

    private SQLiteDatabase getDb(){
        return (db == null) ? db = helper.getWritableDatabase() : db;
    }

    public void close(){
        helper.close();
    }

    public long inserir(Player player){
        ContentValues values = new ContentValues();
        values.put(PlayerColumnsProperties.NOME, player.getNome());
        values.put(PlayerColumnsProperties.APELIDO, player.getApelido());
        values.put(PlayerColumnsProperties.POSICAO, player.getPosicao());
        long resultado = getDb().insert(TABELA, null, values);
        close();
        return resultado;
    }

}
