package com.wahyu.evakuasibencana;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class DashboardUserActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    
    private DrawerLayout drawerLayout;
    private MeowBottomNavigation meowBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_user);

        /*
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
         */

        meowBottomNavigation = findViewById(R.id.meowBottom);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open_nav,
                R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UserHomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

        //add item menu
        //meowBottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.nav_home));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.posko));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.ev));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.nav_berita));
        //meowBottomNavigation.add(new MeowBottomNavigation.Model(5, R.drawable.nav_info));

        meowBottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment fragment = null;

                switch (item.getId()){
                    /*case 1 :
                        fragment = new UserHomeFragment();
                        break;*/
                    case 1 :
                        fragment = new UserPoskoFragment();
                        break;
                    case 2 :
                        fragment = new UserEvakuasiFragment();
                        break;
                    case 3 :
                        fragment = new UserBeritaFragment();
                        break;
                    /*case 5 :
                        fragment = new UserAboutusFragment();
                        break;*/
                }
                loadFragment(fragment);
            }
        });

        meowBottomNavigation.setCount(1,"10");
        meowBottomNavigation.show(2, true);
        meowBottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {

            }
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,fragment)
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UserHomeFragment()).commit();
                break;

            case R.id.nav_posko:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UserPoskoFragment()).commit();
                break;

            case R.id.nav_evakuasi:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UserEvakuasiFragment()).commit();
                break;

            case R.id.nav_berita:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UserBeritaFragment()).commit();
                break;

            case R.id.nav_panduan:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UserPanduanFragment()).commit();
                break;

            case R.id.nav_about:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new UserAboutusFragment()).commit();
                break;

            case R.id.nav_logout:
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                break;    
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}