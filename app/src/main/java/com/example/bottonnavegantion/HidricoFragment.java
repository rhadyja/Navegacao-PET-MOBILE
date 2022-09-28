package com.example.bottonnavegantion;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HidricoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HidricoFragment extends Fragment {

    public ImageView imageView;
    public Lista<AreaClicavel> list = new Lista(); //lista para guardar as linhas (areas clicaveis) do arquivo

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HidricoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HidricoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HidricoFragment newInstance(String param1, String param2) {
        HidricoFragment fragment = new HidricoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hidrico, container, false);

        imageView = (ImageView) view.findViewById(R.id.image);

        imageView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(getActivity(), "clicou", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    public void verificarAreaDoClique(double x, double y) {
        //receber uma lista, x do clique e y do clique
        //verificar cada índice da lista
        for (int k = 1; k < list.size(); k++) {
            if (list.consultar(0).getAtual() == list.consultar(k).getAtual()) {
                if (list.consultar(k).getX1() < x && x < list.consultar(k).getX2()
                        && list.consultar(k).getY1() < y && y < list.consultar(k).getY2()) { //verificando area que foi clicada
                    imageView.setImageResource(list.consultar(k).getProximo());//fazer troca da imagem atual pela proxima
                    break;
                }
            }
            break;
        }

        for (int i = 1; i < list.size(); i++) { //percorrendo a lista
            if (list.consultar(i).getX1() < x && x < list.consultar(i).getX2()
                    && list.consultar(i).getY1() < y && y < list.consultar(i).getY2()) { //verificando area que foi clicada
                imageView.setImageResource(list.consultar(i).getProximo()); //fazer troca da imagem atual pela proxima
                break;
            }
            for (int j = i + 1; j < list.size() - 1; j++) {
                if (list.consultar(i).getProximo() == list.consultar(j).getAtual()) {
                    i = j - 1;
                    break;
                }
                break;
            }
        }
    }

    public void onBackPressed() {
        for (int k = 1; k < list.size(); k++) {
            imageView.setImageResource(list.consultar(k).getAtual());//fazer troca da imagem atual pela proxima
            break;
        }
    }
}