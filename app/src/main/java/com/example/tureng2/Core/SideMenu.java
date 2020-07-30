package com.example.tureng2.Core;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.tureng2.Database_Operations.DbOperations;
import com.example.tureng2.R;
import com.example.tureng2.Sub_Core.DailyTalks;
import com.google.android.material.navigation.NavigationView;



@SuppressLint("Registered")
public class SideMenu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Context context;
    private DbOperations db;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        db = new DbOperations(context);
    }

    public void createDrawer()
    {
        try {
            drawerLayout = ( (Activity)context).findViewById(R.id.drawer_layout);
            navigationView = ( (Activity)context).findViewById(R.id.nav_view);
            navigationView.bringToFront();
            ActionBarDrawerToggle toggle = new
                    ActionBarDrawerToggle(((Activity)context),drawerLayout,toolbar,R.string.common_google_play_services_enable_text,R.string.common_google_play_services_enable_text);
            drawerLayout.addDrawerListener(toggle);
            toggle.syncState();
            navigationView.setNavigationItemSelectedListener((NavigationView.OnNavigationItemSelectedListener) context);
            navigationView.setCheckedItem(R.id.nav_home);
        }
        catch (Exception e)
        {
            Log.e("Core/SideMenu","CreateDrawer Exception", e);
        }
    }

    public SideMenu(@NonNull Context context)
    {
        this.context = context;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        try {
            db = new DbOperations(context);

            switch (menuItem.getItemId()) {
                case R.id.nav_home:
                    Intent intent = new Intent(context, HomeScreen.class);
                    context.startActivity(intent);
                    break;
                case R.id.nav_dailytalk:
                    intent = new Intent(context, DailyTalks.class);
                    context.startActivity(intent);
                    break;
                case R.id.nav_profile:
                    intent = new Intent(context, UserScreen.class);
                    context.startActivity(intent);
                    break;
                case R.id.nav_logout:
                    db.logout();
                    break;
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
        catch (Exception e)
        {
            Log.e("Core/SideMenu","Navigation Item Selected Exception", e);
            return false;
        }
    }
}
