package quewquewcrew.appngasal.view.activity;

import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

import quewquewcrew.appngasal.R;
import quewquewcrew.appngasal.model.entity.Lapangan;
import quewquewcrew.appngasal.model.session.SessionManager;

import static quewquewcrew.appngasal.view.activity.ParentActivity.doChangeActivity;

public class Komfirmasi extends AppCompatActivity {
    private Lapangan lapang;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lapang = (Lapangan) getIntent().getExtras().get("Lapangan");
        setContentView(R.layout.activity_komfirmasi);
        Intent i = getIntent();

        TextView tanggal = (TextView) findViewById(R.id.id_tanggal_booking);
        tanggal.setText(i.getExtras().getString("Tanggal"));

        float waktu = i.getFloatExtra("Jam",0f);
        TextView waktu1 = (TextView)findViewById(R.id.id_waktu_booking);
        waktu1.setText(String.valueOf(waktu)+" " + "JAM");

        int hargalap = lapang.getHarga();
        double total = waktu * hargalap;

        TextView harga = (TextView) findViewById(R.id.id_total_harga);
        harga.setText(String.valueOf(total));
        TextView namalapang = (TextView) findViewById(R.id.item_lapang_grid_name);
        namalapang.setText(lapang.getNameLap());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.topup) {
            doChangeActivity(getApplicationContext(),Topup.class);
        } else if (id == R.id.home) {
            doChangeActivity(getApplicationContext(), MainActivity.class);
        }
        else if (id == R.id.logout) {
            SessionManager.with(getApplicationContext()).clearsession();
            doChangeActivity(getApplicationContext(), AuthActivity.class);
        }
        return true;
    }

}
