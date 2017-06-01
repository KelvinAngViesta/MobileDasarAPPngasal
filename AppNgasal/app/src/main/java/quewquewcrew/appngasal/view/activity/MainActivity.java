package quewquewcrew.appngasal.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import quewquewcrew.appngasal.R;
import quewquewcrew.appngasal.model.entity.User;
import quewquewcrew.appngasal.model.entity.Lapangan;
import quewquewcrew.appngasal.model.session.SessionManager;
import quewquewcrew.appngasal.view.adapter.UserGridARVAdapter;
import quewquewcrew.appngasal.view.fragment.auth.Wallet;
import quewquewcrew.appngasal.view.fragment.auth.topup;
import quewquewcrew.appngasal.view.fragment.user.UserASCGrid;

import static android.R.attr.fragment;
import static android.R.attr.theme;
import static quewquewcrew.appngasal.model.entity.Lapangan.lapangans;


public class MainActivity extends ParentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



         /* checking the session */
        if (!SessionManager.with(getApplicationContext()).isuserlogin()) {
            this.doChangeActivity(getApplicationContext(), AuthActivity.class);
        }

//        TabLayout tb = (TabLayout) findViewById(R.id.tabs);
//
//        ViewPager vp = (ViewPager) findViewById(viewPager);
//        final ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
//        vp.setAdapter(adapter);
//        tb.setupWithViewPager(vp);
         this.changefragment(new UserASCGrid());
//          this.setTitle("Lapangan");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.topup)
        {
            changefragment(new topup());
        }
        else if(id== R.id.Wallet)
        {
            changefragment(new Wallet());
        }
        else if(id== R.id.logout)
        {
            SessionManager.with(getApplicationContext()).clearsession();
            doChangeActivity(getApplicationContext(), AuthActivity.class);
        }
//        switch (item.getItemId()){
//
//            case R.id.topup:
//                this.doChangeActivity(getApplicationContext(), MainActivity.class);
//                changefragment(new topup());
//
//            case R.id.Wallet:
//                this.doChangeActivity(getApplicationContext(), MainActivity.class);
//                changefragment(new Wallet());
//            case R.id.logout:
//
//                SessionManager.with(getApplicationContext()).clearsession();
//                doChangeActivity(getApplicationContext(), AuthActivity.class);
//                break;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
        return true;
    }
    public void changefragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.activity_main, fragment).commit();
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
    }
}


