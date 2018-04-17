package com.mansopresk.mansoservices.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mansopresk.mansoservices.R;

import de.hdodenhof.circleimageview.CircleImageView;


public class ServicesFragment extends Fragment
{
    CircleImageView ac,beauty,carpenter,electricity,kgwash,plumbing;

    public ServicesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_services, container, false);

        ac = view.findViewById(R.id.ac);
        beauty = view.findViewById(R.id.beauty);
        carpenter = view.findViewById(R.id.carpenter);
        electricity = view.findViewById(R.id.electricty);
        kgwash = view.findViewById(R.id.kgwash);
        plumbing = view.findViewById(R.id.plumbing);

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "AC Repair", Toast.LENGTH_SHORT).show();
            }
        });

        beauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Beauty & Spa", Toast.LENGTH_SHORT).show();
            }
        });

        carpenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Carpentry", Toast.LENGTH_SHORT).show();
            }
        });

        electricity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Electricity", Toast.LENGTH_SHORT).show();
            }
        });

        kgwash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Kg Wash", Toast.LENGTH_SHORT).show();
            }
        });

        plumbing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Plumbing", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}
