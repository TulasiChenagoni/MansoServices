package com.mansopresk.mansoservices.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.mansopresk.mansoservices.R;
import com.mansopresk.mansoservices.RegistrationActivity;

import java.util.Timer;
import java.util.TimerTask;

import de.hdodenhof.circleimageview.CircleImageView;


public class HomeFragment extends Fragment
{
    ViewPager viewPager;
    private BookPageAdapter1 myViewPagerAdapter1;
    private int[] layouts = new int[]{
            R.layout.corpo_office,
            R.layout.corpo_hand,
            R.layout.corpo_gd,R.layout.corpo_desk};
    Timer timer;

    Button home_book;

    CircleImageView home_carpenter,home_ac,home_call,home_clients;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home, container, false);

        viewPager = view.findViewById(R.id.home_viewpager);

//        home_book = view.findViewById(R.id.home_book);
        home_carpenter = view.findViewById(R.id.home_carpenter);
//        home_ac = view.findViewById(R.id.home_ac);
//        home_call = view.findViewById(R.id.home_call);
//        home_clients = view.findViewById(R.id.home_client);

//        home_book.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getActivity(), RegistrationActivity.class);
//                startActivity(i);
//                ((Activity) getActivity()).overridePendingTransition(0,0);
//            }
//        });

        home_carpenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
//                ViewPager viewPager_home = getActivity().findViewById(R.id.viewpager);
//                viewPager_home.setCurrentItem(2);

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fr1, new ServicesFragment());
                fragmentTransaction.commit();

        }
        });

//        home_ac.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ViewPager viewPager_home = getActivity().findViewById(R.id.viewpager);
//                viewPager_home.setCurrentItem(2);
//            }
//        });
//
//        home_call.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ViewPager viewPager_home = getActivity().findViewById(R.id.viewpager);
//                viewPager_home.setCurrentItem(5);
//            }
//        });
//
//        home_clients.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ViewPager viewPager_home = getActivity().findViewById(R.id.viewpager);
//                viewPager_home.setCurrentItem(4);
//            }
//        });


        myViewPagerAdapter1 = new BookPageAdapter1(getContext());

        viewPager.setAdapter(myViewPagerAdapter1);

        TimerTask timerTask = new TimerTask()
        {
            @Override
            public void run()
            {
                viewPager.post(new Runnable(){

                    @Override
                    public void run()
                    {
                        viewPager.setCurrentItem((viewPager.getCurrentItem()+1)%layouts.length);
                    }
                });
            }
        };
        timer = new Timer();
        timer.schedule(timerTask, 4000, 4000);

        return  view;
    }

    public class BookPageAdapter1 extends PagerAdapter
    {
        private LayoutInflater layoutInflater;
        Context context;

        public BookPageAdapter1(Context context)
        {
            this.context = context;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position)
        {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }

}
