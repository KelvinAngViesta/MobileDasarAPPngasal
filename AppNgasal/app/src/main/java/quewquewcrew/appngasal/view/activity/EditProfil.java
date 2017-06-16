package quewquewcrew.appngasal.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import quewquewcrew.appngasal.R;
import quewquewcrew.appngasal.model.entity.User;
import quewquewcrew.appngasal.model.session.SessionManager;
import static quewquewcrew.appngasal.view.activity.ParentActivity.doChangeActivity;

public class EditProfil extends AppCompatActivity implements View.OnClickListener {
    public User users;
    TextView txtusername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profil);
        users = SessionManager.with(getApplicationContext()).getuserloggedin();
        txtusername = (TextView)findViewById(R.id.edpname);
        txtusername.setText(users.getName());
        TextView txtemail =(TextView)findViewById(R.id.edpemail);
        txtemail.setText(users.getEmail());

        txtusername.setOnClickListener(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case android.R.id.home:
                doChangeActivity(getApplicationContext(),MainActivity.class);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        if(v == txtusername)
        {
            doChangeActivity(getApplicationContext(),EditProfilv2.class);
        }

    }


}
