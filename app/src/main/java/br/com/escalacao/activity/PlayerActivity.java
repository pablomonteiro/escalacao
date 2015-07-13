package br.com.escalacao.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import br.com.escalacao.R;

public class PlayerActivity extends Activity {

    private Spinner posicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        preencheListaDePosicoes();
    }

    private void preencheListaDePosicoes(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.posicoes, android.R.layout.simple_spinner_item
        );
        posicao = (Spinner) findViewById(R.id.spinnerPosicao);
        posicao.setAdapter(adapter);
    }

}
