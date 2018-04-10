package com.mansopresk.mansoservices.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mansopresk.mansoservices.R;


public class ContactUsFragment extends Fragment
{

    TextView first_no, second_no,mail_tv;

    public ContactUsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);

        first_no = view.findViewById(R.id.first_no);
        second_no = view.findViewById(R.id.second_no);
        mail_tv = view.findViewById(R.id.mail_tv);

        first_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+"91 799 355 2864"));
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });

        second_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+"91 916 028 5374"));
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);
            }
        });

        mail_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType("text/html");
                intent.putExtra(Intent.EXTRA_EMAIL, "info@mansopresk.com");
//                intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
//                intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");

                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });

        return view;
    }
}
