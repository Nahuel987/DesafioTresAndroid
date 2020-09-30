package com.example.desafiotresandroid;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentoUno#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoUno extends Fragment {


    ImageView imagenDesafioLatam;

    //variables que recibiran los datos enviados desde la actividad
    TextView preguntaView,categoriaView,dificultadView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentoUno() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentoUno.
     */
    // TODO: Rename and change types and number of parameters

    public static FragmentoUno newInstance(String param1, String param2) {
        FragmentoUno fragment = new FragmentoUno();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    //constructor personalizado que recibira los datos desde la actividad
    public static FragmentoUno newInstance(String pregunta, String categoria, String dificultad) {

    //public static FragmentoUno newInstance(String pregunta, String categoria) {

        FragmentoUno fragment = new FragmentoUno();
        Bundle arguments = new Bundle();
        arguments.putString("PREGUNTA", pregunta);
        arguments.putString("CATEGORIA", categoria);
        arguments.putString("DIFICULTAD", dificultad);
        fragment.setArguments(arguments);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView( LayoutInflater inflater,   ViewGroup container,
                               Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_fragmento_uno, container, false);

        final String pregunta = Objects.requireNonNull(getArguments()).getString("PREGUNTA");
        final String categoria = Objects.requireNonNull(getArguments().getString("CATEGORIA"));
        final String dificultad = Objects.requireNonNull(getArguments().getString("DIFICULTAD"));

        inciciaVista(view);

        preguntaView.setText(pregunta);
        categoriaView.setText(categoria);
        dificultadView.setText(dificultad);

        return view;
    }

    private void inciciaVista(View view) {
        preguntaView = view.findViewById(R.id.txPregunta);
        categoriaView = view.findViewById(R.id.txCategoria);
        dificultadView = view.findViewById(R.id.txDificultad);
    }

}//class
