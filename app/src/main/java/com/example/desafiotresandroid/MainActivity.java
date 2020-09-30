package com.example.desafiotresandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.desafiotresandroid.api.Api;
import com.example.desafiotresandroid.api.RetrofitClient;
import com.example.desafiotresandroid.modelo.RespuestaApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    FragmentoUno fragmentoUno;
    TextView pregunta, categoria, dificultad;
    String preg, cat, dif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //se inicia vistas
        pregunta = findViewById(R.id.txPreggg);
        categoria = findViewById(R.id.txCattt);
        dificultad= findViewById(R.id.txDifff);

        //retrofit
        Api api = RetrofitClient.getRetrofit().create(Api.class);
        Call<RespuestaApi> call = api.getQuestion();

        call.enqueue(new Callback<RespuestaApi>() {
            @Override
            public void onResponse(Call<RespuestaApi> call, Response<RespuestaApi> response) {
                pregunta.setText(response.body().getResults().get(0).getQuestion());
                categoria.setText(response.body().getResults().get(0).getCategory());
                dificultad.setText(response.body().getResults().get(0).getDifficulty());

                //recibo el texto de TEXT VIEW pregunta, lo convierto en un String y lo asigno a preg
                preg=pregunta.getText().toString();
                cat=categoria.getText().toString();
                dif=dificultad.getText().toString();

                //le paso los parametros a fragmentoUno y se incia transaccion
                fragmentoUno = FragmentoUno.newInstance(preg, cat,dif);
                getSupportFragmentManager().beginTransaction().add(R.id.contenedorFragmentos, fragmentoUno).commit();

            }

            @Override
            public void onFailure(Call<RespuestaApi> call, Throwable t) {

                Log.e("ERROR", t.toString());
                Toast.makeText(MainActivity.this, "Existe un error", Toast.LENGTH_SHORT).show();
            }

        });


    }//oncreate

}//class