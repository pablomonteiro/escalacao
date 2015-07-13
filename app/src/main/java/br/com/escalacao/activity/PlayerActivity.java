package br.com.escalacao.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import br.com.escalacao.R;
import br.com.escalacao.dao.PlayerDao;
import br.com.escalacao.domain.Player;

public class PlayerActivity extends Activity {

    private TextView nome;
    private TextView apelido;
    private Spinner posicao;

    private PlayerDao dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        instanciaDadosDaView();
        preencheListaDePosicoes();
        this.dao = new PlayerDao(this);
    }

    public void cancelar(View view){
//        this.onDestroy();
        this.startActivity(new Intent(this, MenuActivity.class));
    }

    public void incluir(View view){
        Player player = buscaPlayerDaView();
        long resultado = this.dao.inserir(player);
        if(resultado != -1 ){
            limpaDadosDaView();
            Toast.makeText(this, getString(R.string.registro_salvo), Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, getString(R.string.erro_salvar), Toast.LENGTH_SHORT).show();
        }
    }

    private void preencheListaDePosicoes(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.posicoes, android.R.layout.simple_spinner_item
        );
        posicao = (Spinner) findViewById(R.id.spinnerPosicao);
        posicao.setAdapter(adapter);
    }

    private Player buscaPlayerDaView(){
        String nome = this.nome.getText().toString();
        String apelido = this.apelido.getText().toString();
        return new Player(nome, apelido, null);
    }

    private void instanciaDadosDaView(){
        this.nome = (TextView) findViewById(R.id.nome_player);
        this.apelido = (TextView) findViewById(R.id.apelido);
    }

    private void limpaDadosDaView(){
        this.nome.setText("");
        this.apelido.setText("");
    }

}
