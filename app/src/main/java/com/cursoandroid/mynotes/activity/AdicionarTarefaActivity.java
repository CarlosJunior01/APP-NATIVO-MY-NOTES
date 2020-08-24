package com.cursoandroid.mynotes.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.cursoandroid.mynotes.R;
import com.cursoandroid.mynotes.helper.TarefaDAO;
import com.cursoandroid.mynotes.model.Tarefa;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class AdicionarTarefaActivity extends AppCompatActivity {

    private TextInputEditText editTarefa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);

        editTarefa = findViewById(R.id.textTarefa);

        FloatingActionButton fab = findViewById(R.id.fabSalvar);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Executa ação para o item salvar
                TarefaDAO tarefaDAO = new TarefaDAO( getApplicationContext());

                String nomeTarefa = editTarefa.getText().toString();

                if (!nomeTarefa.isEmpty()){
                    Tarefa tarefa = new Tarefa();
                    tarefa.setNomeTarefa(nomeTarefa);
                    tarefaDAO.salvar(tarefa);
                    finish();
                    Toast.makeText(AdicionarTarefaActivity.this, "Anotação salva", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    //Menus
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_adicionar_tarefa, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch ( item.getItemId()){
            case R.id.itemSalvar1 :
            case R.id.itemSalvar2 :
                //Executa ação para o item salvar
                TarefaDAO tarefaDAO = new TarefaDAO( getApplicationContext());

                String nomeTarefa = editTarefa.getText().toString();

                if (!nomeTarefa.isEmpty()){
                    Tarefa tarefa = new Tarefa();
                    tarefa.setNomeTarefa(nomeTarefa);
                    tarefaDAO.salvar(tarefa);
                    finish();

                    Toast.makeText(AdicionarTarefaActivity.this, "Anotação salva", Toast.LENGTH_SHORT).show();
                }

                Toast.makeText(AdicionarTarefaActivity.this, "Anotação salva", Toast.LENGTH_SHORT).show();
                break;

            case R.id.itemConfiguracao1 :
            case R.id.itemConfiguracao2 :
                Toast.makeText(AdicionarTarefaActivity.this, "Configurações", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemEditar :
                Toast.makeText(AdicionarTarefaActivity.this, "Editar", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);



    }

}