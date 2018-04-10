package com.mansopresk.mansoservices.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mansopresk.mansoservices.R;

import java.util.Timer;
import java.util.TimerTask;


public class ForCorporateFragment extends Fragment
{

    ViewPager viewPager;
    private BookPageAdapter myViewPagerAdapter;
    private int[] layouts = new int[]{
            R.layout.corpo_office,
            R.layout.corpo_hand,
            R.layout.corpo_gd,R.layout.corpo_desk};
    Timer timer;

    public ForCorporateFragment()
    {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_for_corporate, container, false);

        viewPager = view.findViewById(R.id.corpo_viewpager);

        myViewPagerAdapter = new BookPageAdapter(getContext());

        viewPager.setAdapter(myViewPagerAdapter);

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

        return view;
    }



    public class BookPageAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;
        Context context;

        public BookPageAdapter(Context context)
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
