package com.cursoandroid.mynotes.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.cursoandroid.mynotes.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class TarefaDAO implements ITarefaDAO {

    private SQLiteDatabase escreve;
    private SQLiteDatabase ler;

    public TarefaDAO(Context context) {
        DbHelper db = new DbHelper(context);
        escreve = db.getWritableDatabase();
        ler = db.getReadableDatabase();
    }

    //Salvar Tarefas
    @Override
    public boolean salvar(Tarefa tarefa) {

        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());

        try {
            escreve.insert(DbHelper.TABELA_TAREFAS, null, cv );
            Log.e("INFO", "Tarefa salva com sucesso");
        }catch (Exception e){
        Log.e("INFO", "Erro ao salvar tarefa " + e.getMessage());
            return false;
        }
        return true;
    }
    //Atualizar Tarefas
    @Override
    public boolean atualizar(Tarefa tarefa) {
        return false;
    }
    //Deletar Tarefas
    @Override
    public boolean deletar(Tarefa tarefa) {
        return false;
    }
    //Listar Tarefas
    @Override
    public List<Tarefa> listar() {

        List<Tarefa> tarefas = new ArrayList<>();
        String sql = "SELECT * FROM " + DbHelper.TABELA_TAREFAS + " ;";
        Cursor c = ler.rawQuery(sql, null);

        while ( c.moveToNext() ){

            Tarefa tarefa = new Tarefa();

            Long id = c.getLong( c.getColumnIndex("id"));
            String nomeTarefa = c.getString( c.getColumnIndex("nome"));

            tarefa.setId( id );
            tarefa.setNomeTarefa( nomeTarefa );

            tarefas.add( tarefa );
        }
        return tarefas;
    }
}
