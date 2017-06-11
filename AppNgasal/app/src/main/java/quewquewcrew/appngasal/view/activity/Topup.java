package quewquewcrew.appngasal.view.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import quewquewcrew.appngasal.R;
import quewquewcrew.appngasal.model.entity.User;
import quewquewcrew.appngasal.model.session.SessionManager;
import static quewquewcrew.appngasal.view.activity.ParentActivity.doChangeActivity;

public class Topup extends AppCompatActivity {
private User users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);
        final ProgressDialog progress = new ProgressDialog(this);
        progress.setMessage("loading ...");
        progress.show();
        Thread _thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(2000);
                    progress.dismiss();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        _thread.start();
        createRadioButtons();
    }

    private void createRadioButtons() {
        RadioGroup group = (RadioGroup)findViewById(R.id.RGroup);

        int [] numpanels = getResources().getIntArray(R.array.topups);

        //create Radio Buttons

        for(int i =0;i<numpanels.length;i++)
        {
            final int numpanel = numpanels[i];
            RadioButton btn = new RadioButton(this);
            btn.setTextSize(16);
            btn.setText(getString(R.string.topups,numpanel));
            //TODO : Set on-click callback
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Topup.this,"Click" + numpanel ,Toast.LENGTH_SHORT).show();
                    users = SessionManager.with(getApplicationContext()).getuserloggedin();
                    int temp = users.getWallet();
                    int tambah = temp + numpanel;
                    users.setWallet(tambah);
                    SessionManager sessionManager = SessionManager.with(getApplicationContext());
                    sessionManager.createsession(users);
                    Toast.makeText(Topup.this,"Berhasil Top-up Sebesar " + numpanel ,Toast.LENGTH_SHORT).show();
                    doChangeActivity(getApplicationContext(),MainActivity.class);
                }


            });

            //Add to radiogroup:
            group.addView(btn);
            //Select default button:
        }

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
            doChangeActivity(getApplication(),Topup.class);
        }
        else if(id==R.id.home)
        {
            doChangeActivity(getApplication(),MainActivity.class);
        }
        else if(id == R.id.Wallet)
        {
            doChangeActivity(getApplication(),Wallet.class);
        }
        else if(id== R.id.logout)
        {
            SessionManager.with(getApplicationContext()).clearsession();
            doChangeActivity(getApplicationContext(), AuthActivity.class);
        }
        return true;
    }

}
