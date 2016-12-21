package com.example.alvaro.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreditoFragment extends Fragment {

    TimerTask tm;
    Timer t;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    MainActivity mainActivity;

    public CreditoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_credito, container, false);
        mainActivity = (MainActivity) getActivity();
        img1 = (ImageView) v.findViewById(R.id.img1);
        img2 = (ImageView) v.findViewById(R.id.img2);
        img3 = (ImageView) v.findViewById(R.id.img3);
        img1.setVisibility(View.VISIBLE);
        img2.setVisibility(View.INVISIBLE);
        img3.setVisibility(View.INVISIBLE);

        TimerTask tm = new TimerTask() {
            @Override
            public void run() {
                mainActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (img1.getVisibility() == View.VISIBLE){
                            img1.setVisibility(View.INVISIBLE);
                            img2.setVisibility(View.VISIBLE);
                        }else if (img2.getVisibility() == View.VISIBLE){
                            img2.setVisibility(View.INVISIBLE);
                            img3.setVisibility(View.VISIBLE);
                        }else if (img3.getVisibility() == View.VISIBLE){
                            img3.setVisibility(View.INVISIBLE);
                            t.cancel();
                            mainActivity.cambiaFragment(2);
                        }

                    }
                });

            }
        };

        t = new Timer();
        t.schedule(tm, 1000, 500);

        return  v;
    }

}
