package com.mansopresk.mansoservices;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.mansopresk.mansoservices.fragments.ForCorporateFragment;
import com.mansopresk.mansoservices.fragments.HomeFragment;
import com.mansopresk.mansoservices.fragments.AboutUsFragment;
import com.mansopresk.mansoservices.fragments.ServicesFragment;
import com.mansopresk.mansoservices.fragments.AreaCoverageFragment;
import com.mansopresk.mansoservices.fragments.ContactUsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        addTabs(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);


//        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
//        mToolbar.setTitle("JOBS");
        //mToolbar.setLogo(R.drawable.tcs);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.login_menu:
                return true;
            case R.id.register_menu:
//        Intent i = new Intent(this,ImagesActivity.class);
//        startActivity(i);
                return true;
            case R.id.partner_menu:
                return true;
            default:

        return super.onOptionsItemSelected(item);
        }
    }
}
