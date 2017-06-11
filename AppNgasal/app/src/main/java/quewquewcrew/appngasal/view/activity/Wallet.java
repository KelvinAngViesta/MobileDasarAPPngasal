package quewquewcrew.appngasal.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import quewquewcrew.appngasal.R;
import quewquewcrew.appngasal.model.entity.User;
import quewquewcrew.appngasal.model.session.SessionManager;

import static quewquewcrew.appngasal.view.activity.ParentActivity.doChangeActivity;

public class Wallet extends AppCompatActivity implements View.OnClickListener {
    private User users;
    Button btntops;
    TextView txthome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        users = SessionManager.with(getApplicationContext()).getuserloggedin();
        TextView txtwallet = (TextView)findViewById(R.id.txtwallet);
        txtwallet.setText(String.valueOf(users.getWallet()));
        //setbuttontops
        btntops= (Button)findViewById(R.id.btntop);
        btntops.setOnClickListener(this);
        txthome = (TextView)findViewById(R.id.home);
        txthome.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v==btntops)
        {
            doChangeActivity(getApplication(),Topup.class);
        }
        else if(v==txthome)
        {
            doChangeActivity(getApplication(),MainActivity.class);
        }
    }
}
