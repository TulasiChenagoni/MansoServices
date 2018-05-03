package com.mansopresk.mansoservices.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mansopresk.mansoservices.LoginActivity;
import com.mansopresk.mansoservices.R;
import com.mansopresk.mansoservices.RegistrationActivity;

import java.util.Timer;
import java.util.TimerTask;

import de.hdodenhof.circleimageview.CircleImageView;


public class HomeFragment extends Fragment
{
    ViewPager viewPager;
    private BookPageAdapter1 myViewPagerAdapter1;

    int images[] = {R.drawable.ac_repair_indicator,
            R.drawable.beauty_spa_indicator,
            R.drawable.carpentry_indicator,
            R.drawable.indicator_service,
            R.drawable.kgwash_indicator,
            R.drawable.plumb_indicator};

    private String[] text = {"AC Repair", "Beauty & Spa", "Carpentry", "Electricity", "Laundry","Plumbing"};

//    private int[] layouts = new int[]{
//            R.layout.list,
//            R.layout.beauty,
//            R.layout.carpentry,
//            R.layout.electricity,
//            R.layout.kg_wash,
//            R.layout.plumbing};

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


        myViewPagerAdapter1 = new BookPageAdapter1(getActivity(), images, text);

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
                        viewPager.setCurrentItem((viewPager.getCurrentItem()+1)%images.length);

                    }
                });
            }
        };
        timer = new Timer();
        timer.schedule(timerTask, 4000, 4000);


        return view;
    }

    public class BookPageAdapter1 extends PagerAdapter{
        Context context;
        int images[];
        String[] text;
        LayoutInflater layoutInflater;

        public BookPageAdapter1(Context context, int images[], String[] text) {
            this.context = context;
            this.images = images;
            this.text = text;
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == ((RelativeLayout) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View itemView = layoutInflater.inflate(R.layout.list, container, false);

            ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
            imageView.setImageResource(images[position]);

            TextView textView = (TextView) itemView.findViewById(R.id.text);
            textView.setText(text[position]);

            container.addView(itemView);

            //listening to image click
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    switch (position)
                    {
                        case 0:
                            Intent i1 = new Intent(getActivity(), LoginActivity.class);
                            startActivity(i1);
                            break;
                        case 1:
                            Intent i2 = new Intent(getActivity(), RegistrationActivity.class);
                            startActivity(i2);
                            break;
                        case 2:
                            Intent i3 = new Intent(getActivity(), LoginActivity.class);
                            startActivity(i3);
                            break;
                        case 3:
                            Intent i4 = new Intent(getActivity(), RegistrationActivity.class);
                            startActivity(i4);
                            break;
                        case 4:
                            Intent i5 = new Intent(getActivity(), LoginActivity.class);
                            startActivity(i5);
                            break;
                        case 5:
                            Intent i6 = new Intent(getActivity(), RegistrationActivity.class);
                            startActivity(i6);
                            break;
                    }

//                    Toast.makeText(context, "you clicked image " + (position + 1), Toast.LENGTH_LONG).show();
                }
            });

            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((RelativeLayout) object);
        }
    }




//    public class BookPageAdapter1 extends PagerAdapter
//    {
//        private LayoutInflater layoutInflater;
//        Context context;
//
//        public BookPageAdapter1(Context context)
//        {
//            this.context = context;
//        }
//
//        @Override
//        public Object instantiateItem(ViewGroup container, int position)
//        {
//            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//            View view = layoutInflater.inflate(layouts[position], container, false);
//
//            view.setOnClickListener(new View.OnClickListener() {
//
//                @Override
//                public void onClick(View v) {
//                    // TODO Auto-generated method stub
////                    Intent i = new Intent(context, AcRepair.class);
////                    Bundle b = new Bundle();
////                    final String id = arrayList.get(position).getId();
////                    b.putString("id", id);
////                    i.putExtras(b);
////                 context.startActivity(i);
//                    Toast.makeText(context, "hii", Toast.LENGTH_SHORT).show();
//                }
//            });
//
//            container.addView(view);
//
//            return view;
//        }
//
//        @Override
//        public int getCount() {
//            return layouts.length;
//        }
//
//
//
//
////        public Fragment getItem(int position) {
////            switch (position) {
////                case 0: // Fragment # 0 - This will show FirstFragment
////                   return newInstance();
////                case 1: // Fragment # 0 - This will show FirstFragment different title
////
////                case 2: // Fragment # 1 - This will show SecondFragment
//////                    return SecondFragment.newInstance(2, "Page # 3");
////                default:
////                    return null;
////            }
////        }
//        @Override
//        public boolean isViewFromObject(View view, Object obj) {
//            return view == obj;
//        }
//
//        @Override
//        public void destroyItem(ViewGroup container, int position, Object object) {
//            View view = (View) object;
//            container.removeView(view);
//        }
//    }


}
