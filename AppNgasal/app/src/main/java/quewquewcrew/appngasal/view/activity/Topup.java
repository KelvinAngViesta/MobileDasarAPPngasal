package quewquewcrew.appngasal.view.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import quewquewcrew.appngasal.R;
import quewquewcrew.appngasal.model.entity.Topups;
import quewquewcrew.appngasal.model.session.SessionManager;
import static quewquewcrew.appngasal.view.activity.ParentActivity.doChangeActivity;

public class Topup extends AppCompatActivity {

    public Topups tops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);


        createRadioButtons();
        int SavedValue = getTopups(this);
        Toast.makeText(this,"saved value" + SavedValue,Toast.LENGTH_SHORT).show();
    }

    private void createRadioButtons() {
        RadioGroup group = (RadioGroup)findViewById(R.id.RGroup);

        int [] numpanels = getResources().getIntArray(R.array.topups);

        //create Radio Buttons

        for(int i =0;i<numpanels.length;i++)
        {
            final int numpanel = numpanels[i];
            RadioButton btn = new RadioButton(this);
            btn.setText(getString(R.string.topups,numpanel));

            //TODO : Set on-click callback
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Topup.this,"Click" + numpanel ,Toast.LENGTH_SHORT).show();
                    Intent _intent = new Intent(v.getContext(),Wallet.class);
                    _intent.putExtra("Topups",numpanel);
                    v.getContext().startActivity(_intent);

                }


            });

            //Add to radiogroup:
            group.addView(btn);
            //Select default button:
            if(numpanel== getTopups(this))
            {
                btn.setChecked(true);

            }
        }

    }

    private void savetopup(int numpanel) {
        SharedPreferences prefs = this.getSharedPreferences("AppPreferens",MODE_PRIVATE);
        SharedPreferences.Editor editors = prefs.edit();
        editors.putInt("Numstring",numpanel);
        editors.apply();
    }
    static public int getTopups(Context ctx) {
        SharedPreferences prefs = ctx.getSharedPreferences("AppPreferens",MODE_PRIVATE);
        //// TODO: change default value.
        return prefs.getInt("Topups", 0);

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
            doChangeActivity(getApplicationContext(),Topup.class);
        }
        else if(id==R.id.home)
        {
            doChangeActivity(getApplicationContext(),MainActivity.class);
        }
        else if(id == R.id.Wallet)
        {
            doChangeActivity(getApplicationContext(),Wallet.class);
        }
        else if(id== R.id.logout)
        {
            SessionManager.with(getApplicationContext()).clearsession();
            doChangeActivity(getApplicationContext(), AuthActivity.class);
        }
        return true;
    }

}
