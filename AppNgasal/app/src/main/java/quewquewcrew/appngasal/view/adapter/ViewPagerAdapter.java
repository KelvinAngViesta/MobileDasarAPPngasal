package quewquewcrew.appngasal.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import quewquewcrew.appngasal.view.fragment.user.UserASCGrid;

import java.util.ArrayList;

/**
 * Created by User on 6/7/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> ArrFrag = new ArrayList<>();
    private ArrayList<String> title = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        this.addFragment(new UserASCGrid(), "List Lapangan");
        this.addFragment(new UserASCGrid(), "Filter");
    }

    private void addFragment(Fragment fragments, String setTitle) {
        ArrFrag.add(fragments);
        title.add(setTitle);
    }

    @Override
    public Fragment getItem(int position) {
        return ArrFrag.get(position);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return title.get(position);
    }

    @Override
    public int getCount() {
        return ArrFrag.size();
    }
}
