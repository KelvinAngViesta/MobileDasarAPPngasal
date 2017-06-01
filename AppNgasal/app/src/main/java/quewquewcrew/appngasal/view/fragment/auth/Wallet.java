package quewquewcrew.appngasal.view.fragment.auth;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import quewquewcrew.appngasal.R;
import quewquewcrew.appngasal.model.entity.Topup;
import quewquewcrew.appngasal.view.activity.AuthActivity;
import quewquewcrew.appngasal.view.activity.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Wallet.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class Wallet extends Fragment {
    TextView textviewwallet;
    Button btnWallet;
    public Wallet() {
        // Required empty public constructor
    }
    private void init(View view) {
        textviewwallet = (TextView) view.findViewById(R.id.txtwallet);
        btnWallet = (Button) view.findViewById(R.id.btntop);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View _view = inflater.inflate(R.layout.fragment_wallet, container, false);
        init(_view);
        event();
        return _view;
    }
    private void event() {
    btnWallet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity) getActivity()).changefragment(new topup());
                }
            });
        }

}
