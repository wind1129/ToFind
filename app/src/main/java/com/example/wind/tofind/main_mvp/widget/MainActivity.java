package com.example.wind.tofind.main_mvp.widget;

import android.graphics.Color;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.wind.tofind.R;
import com.example.wind.tofind.ui.BaseActivity;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;

import butterknife.Bind;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Bind(R.id.nav_view)
    NavigationView navigationView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    private String currentType;

    @Override
    protected void initLayoutId() {
        layoutId = R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        super.initViews();
        setupDrawer();
        initNavigationView();
        replace(TabsFragment.MENU_NEWS);
    }

    private void initNavigationView() {
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.inflateMenu(R.menu.nav_menu_main);

        Menu menu = navigationView.getMenu();
        menu.getItem(0).setChecked(true);
        menu.getItem(0).setIcon(new IconicsDrawable(this).icon(GoogleMaterial.Icon.gmd_explore).color(Color.BLUE));
        menu.getItem(1).setIcon(new IconicsDrawable(this).icon(GoogleMaterial.Icon.gmd_face).color(Color.RED));

        Menu menuSub = menu.getItem(2).getSubMenu();
        menuSub.getItem(0).setIcon(new IconicsDrawable(this).icon(GoogleMaterial.Icon.gmd_share).color(Color.DKGRAY));
        menuSub.getItem(1).setIcon(new IconicsDrawable(this).icon(GoogleMaterial.Icon.gmd_settings).color(Color.GRAY));


    }

    private void setupDrawer() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    private void replace(String type){
        if(!type.equals(currentType)){
            currentType = type;
            replaceFragment(TabsFragment.newInstance(type), type);
        }

    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.nav_knowledge){
            replace(TabsFragment.MENU_NEWS);
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
