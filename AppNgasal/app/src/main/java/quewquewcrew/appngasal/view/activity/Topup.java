package quewquewcrew.appngasal.view.activity;

import android.content.Intent;
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

public class Topup extends AppCompatActivity {

    public Topup tops;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topup);


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
            btn.setText(getString(R.string.topups,numpanel));

            //TODO : Set on-click callback
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Topup.this,"Click" + numpanel ,Toast.LENGTH_SHORT).show();
                }});

            //Add to radiogroup:
            group.addView(btn);
        }

    }


}
