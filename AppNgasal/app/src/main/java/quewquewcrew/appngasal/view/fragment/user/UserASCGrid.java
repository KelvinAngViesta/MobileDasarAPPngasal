package quewquewcrew.appngasal.view.fragment.user;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import quewquewcrew.appngasal.R;
import quewquewcrew.appngasal.model.entity.Lapangan;
import quewquewcrew.appngasal.model.entity.User;
import quewquewcrew.appngasal.model.session.SessionManager;
import quewquewcrew.appngasal.view.activity.AuthActivity;
import quewquewcrew.appngasal.view.adapter.UserGridARVAdapter;
import quewquewcrew.appngasal.view.adapter.ViewPagerAdapter;

import static quewquewcrew.appngasal.R.id.viewPager;
import static quewquewcrew.appngasal.model.entity.Lapangan.lapangans;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserASCGrid extends Fragment implements SearchView.OnQueryTextListener {
    String srch="";
    private Context context;
    private RecyclerView rv;
    private UserGridARVAdapter adapter;

    public UserASCGrid() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


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


        context=getActivity();
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View _view = inflater.inflate(R.layout.fragment_user_ascgrid, container, false);

        /* initiate & instantiate */
        adapter = new UserGridARVAdapter();
        rv = (RecyclerView) _view.findViewById(R.id.user_ascgrid_rv);

        /* setting */
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new GridLayoutManager(getContext(),1));
        adapter.setLapangans(Lapangan.lapangans);
        rv.setAdapter(adapter);
        return _view;
    }
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<Lapangan> filteredModelList = filter(Lapangan.lapangans, newText);
        if (filteredModelList.size() > 0) {
            adapter.setFilter(filteredModelList);
            return true;
        } else {
            return false;
        }
    }

    private List<Lapangan> filter(List<Lapangan> models, String query) {

        query = query.toLowerCase();
        this.srch=query;

        final List<Lapangan> filteredModelList = new ArrayList<>();
        for (Lapangan model : models) {
            final String text = model.getNameLap().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        adapter = new UserGridARVAdapter(filteredModelList,getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return filteredModelList;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        TextView searchText = (TextView)
                searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchText.setHint("Search Lapangan...");
        searchView.setOnQueryTextListener(this);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
