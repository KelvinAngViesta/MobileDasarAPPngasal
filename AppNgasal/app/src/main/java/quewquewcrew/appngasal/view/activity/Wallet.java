package quewquewcrew.appngasal.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import quewquewcrew.appngasal.R;
import quewquewcrew.appngasal.model.entity.Topups;

import static quewquewcrew.appngasal.view.activity.ParentActivity.doChangeActivity;

public class Wallet extends AppCompatActivity implements View.OnClickListener {
    private Topups tops;
    Button btntops;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        Intent intents = getIntent();
        int wallets = intents.getIntExtra("Topups",0);
        TextView txtwallet = (TextView)findViewById(R.id.txtwallet);
        txtwallet.setText(String.valueOf(wallets));
        //setbuttontops
        btntops= (Button)findViewById(R.id.btntop);
        btntops.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v==btntops)
        {
            doChangeActivity(getApplicationContext(),Topup.class);
        }
    }
}
