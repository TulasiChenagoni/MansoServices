package com.mansopresk.mansoservices;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.mansopresk.mansoservices.fragments.ForCorporateFragment;
import com.mansopresk.mansoservices.fragments.HomeFragment;
import com.mansopresk.mansoservices.fragments.AboutUsFragment;
import com.mansopresk.mansoservices.fragments.ServicesFragment;
import com.mansopresk.mansoservices.fragments.AreaCoverageFragment;
import com.mansopresk.mansoservices.fragments.ContactUsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private ViewPager viewPager;
    private TabLayout tabLayout;

    private Boolean isFabOpen = false;
    private FloatingActionButton fab, fab1, fab2;
    private Animation fab_open, fab_close, rotate_forward, rotate_backward;


    String choice[]={"LOGIN","REGISTER","SIGNUP AS PARTNER"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);

        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        rotate_forward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forward);
        rotate_backward = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_backward);

        fab.setOnClickListener(this);
        fab1.setOnClickListener(this);
        fab2.setOnClickListener(this);


        viewPager = (ViewPager) findViewById(R.id.viewpager);
        addTabs(viewPager);


        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);


        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("MansoServices");
//        mToolbar.setLogo(R.drawable.tcs);
//
//        mToolbar.setNavigationIcon(R.drawable.left_arrow);
//        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                // Your code
//                finish();
//            }
//        });
    }

        @Override
        public void onClick (View view){


            int id = view.getId();
            switch (id)
            {
                case R.id.fab:
                    animateFAB();
                    break;

                case R.id.fab1:
                    Intent i = new Intent(this, LoginActivity.class);
                    startActivity(i);
                    break;

                case R.id.fab2:
                    Intent i1 = new Intent(this, RegistrationActivity.class);
                    startActivity(i1);
                    break;

            }
        }

    private void addTabs(ViewPager viewPager)
    {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new HomeFragment(),"HOME");
        adapter.addFrag(new AboutUsFragment(), "ABOUT US");
        adapter.addFrag(new ServicesFragment(), "SERVICES");
        adapter.addFrag(new AreaCoverageFragment(), "AREA COVERAGE");
        adapter.addFrag(new ForCorporateFragment(), "FOR CORPORATE");
        adapter.addFrag(new ContactUsFragment(), "CONTACT US");

        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu)
//    {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.login, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item)
//    {
//        switch (item.getItemId()) {
//            case R.id.login_menu:
//                return true;
//            case R.id.register_menu:
////        Intent i = new Intent(this,ImagesActivity.class);
////        startActivity(i);
//                return true;
//            case R.id.partner_menu:
//                return true;
//            default:
//
//        return super.onOptionsItemSelected(item);
//        }
//    }

    public void toolLogin(View view)
    {
        AlertDialog.Builder ad = new AlertDialog.Builder(this);
        ad.setItems(choice, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {
                switch (i)
                {
                    case 0:
                        Intent intent1 = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent1);
                        break;

                    case 1:
                        Intent intent2 = new Intent(MainActivity.this, RegistrationActivity.class);
                        startActivity(intent2);
                        break;

                    case 2:
                        Toast.makeText(MainActivity.this, "Partner", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        ad.create().show();
    }

    public void animateFAB() {

        if (isFabOpen)
        {

            fab.startAnimation(rotate_backward);
            fab1.startAnimation(fab_close);
            fab2.startAnimation(fab_close);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isFabOpen = false;
            Toast.makeText(this, "fab close", Toast.LENGTH_SHORT).show();

        }
        else
        {

            fab.startAnimation(rotate_forward);
            fab1.startAnimation(fab_open);
            fab2.startAnimation(fab_open);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isFabOpen = true;
            Toast.makeText(this, "fab open", Toast.LENGTH_SHORT).show();

        }
    }
}
