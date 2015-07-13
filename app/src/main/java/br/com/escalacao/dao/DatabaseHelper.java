package br.com.escalacao.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

/**
 * Created by pablo on 12/07/15.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String BANCO_DE_DADOS = "Escalacao";
    private static final int VERSAO = 1;

    public DatabaseHelper(Context context){
        super(context, BANCO_DE_DADOS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(getSqlCriacaoTabelaPlayer());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private String getSqlCriacaoTabelaPlayer(){
        return "CREATE TABLE PLAYER (" +
                                    " _ID INTERGER PRIMARY KEY," +
                                    " NOME TEXT," +
                                    " APELIDO TEXT," +
                                    " POSICAO TEXT);";
    }
}
