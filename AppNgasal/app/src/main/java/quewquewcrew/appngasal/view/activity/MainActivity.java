package quewquewcrew.appngasal.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
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
import quewquewcrew.appngasal.view.adapter.ViewPagerAdapter;
import quewquewcrew.appngasal.view.fragment.user.UserASCGrid;

import static quewquewcrew.appngasal.R.id.viewPager;
import static quewquewcrew.appngasal.model.entity.Lapangan.lapangans;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lapangans.clear();
        Lapangan lapa = new Lapangan("The Kop","Jl.Krakatau No-32c","MedanBaru","087749068666",100000);
        lapa.setImg(R.drawable.lap1);
        Lapangan lapb = new Lapangan("Mega Futsal","Jl.Krakatau No 183c","MedanArea","087749068666",50000);
        lapb.setImg(R.drawable.lap1);
        Lapangan lapc = new Lapangan("Maritim Futsal","Jl.Krakatau No 32c","MedanBaru","087749068666",100000);
        lapc.setImg(R.drawable.lap1);
        Lapangan lapd = new Lapangan("Abadi Futsal","Jl.Krakatau No 32c","MedanBaru","087749068666",100000);
        lapd.setImg(R.drawable.lap1);
        lapangans.add(lapa);
        lapangans.add(lapb);
        lapangans.add(lapc);
        lapangans.add(lapd);

        User a = new User("STMIK - Mikroskil Medan", "a@mobile.id", "password");
        User b = new User("Kampus A", "b@mobile.id", "password");
        User c = new User("Kampus B", "c@mobile.id", "password");
        User d = new User("Kampus C", "d@mobile.id", "password");
        User e = new User("Kampus D - Thamrin Plaza", "e@mobile.id", "password");
        User f = new User("f", "f@mobile.id", "password");
        User g = new User("g", "g@mobile.id", "password");
        User h = new User("h", "h@mobile.id", "password");
        User i = new User("i", "i@mobile.id", "password");
        User j = new User("j", "j@mobile.id", "password");
        User k = new User("k", "k@mobile.id", "password");
        User l = new User("l", "l@mobile.id", "password");
        User.users.add(a);
        User.users.add(b);
        User.users.add(c);
        User.users.add(d);
        User.users.add(e);
        User.users.add(f);
        User.users.add(g);
        User.users.add(h);
        User.users.add(i);
        User.users.add(j);
        User.users.add(k);
        User.users.add(l);

         /* checking the session */
        if (!SessionManager.with(getApplicationContext()).isuserlogin()) {
            this.doChangeActivity(getApplicationContext(), AuthActivity.class);
        }

        TabLayout tb = (TabLayout) findViewById(R.id.tabs);

        ViewPager vp = (ViewPager) findViewById(viewPager);
        final ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);
        tb.setupWithViewPager(vp);
//          this.changefragment(new UserASCGrid());
          this.setTitle("Lapangan");
    }
    public static void doChangeActivity (Context context, Class destination) {
        Intent _intent = new Intent(context, destination);
        _intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(_intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                SessionManager.with(getApplicationContext()).clearsession();
                doChangeActivity(getApplicationContext(), AuthActivity.class);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
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
