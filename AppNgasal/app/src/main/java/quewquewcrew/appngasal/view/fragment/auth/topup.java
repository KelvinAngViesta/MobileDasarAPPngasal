package quewquewcrew.appngasal.view.fragment.auth;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import quewquewcrew.appngasal.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link topup.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link topup#newInstance} factory method to
 * create an instance of this fragment.
 */
public class topup extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View _view = inflater.inflate(R.layout.fragment_topup, container, false);

        return _view;
    }


}