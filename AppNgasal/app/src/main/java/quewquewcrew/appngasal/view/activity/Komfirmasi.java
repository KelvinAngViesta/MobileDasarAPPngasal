package quewquewcrew.appngasal.view.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.icu.text.DecimalFormat;
import android.support.annotation.StringDef;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import quewquewcrew.appngasal.R;
import quewquewcrew.appngasal.model.entity.Lapangan;
import quewquewcrew.appngasal.model.session.SessionManager;

import static quewquewcrew.appngasal.view.activity.ParentActivity.doChangeActivity;

public class Komfirmasi extends AppCompatActivity implements View.OnClickListener {
    private Lapangan lapang;
    Button btnpem;
    String tgl;
    int total,waktu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lapang = (Lapangan) getIntent().getExtras().get("Lapangan");
        setContentView(R.layout.activity_komfirmasi);
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
        Intent i = getIntent();

        tgl = i.getExtras().getString("Tanggal");
        TextView tanggal = (TextView) findViewById(R.id.id_tanggal_booking);
        tanggal.setText(tgl);

        waktu = i.getIntExtra("Jam",0);
        TextView waktu1 = (TextView)findViewById(R.id.id_waktu_booking);
        waktu1.setText(String.valueOf(waktu)+" " + "JAM");

        int hargalap = lapang.getHarga();
        total = waktu * hargalap;

        TextView harga = (TextView) findViewById(R.id.id_total_harga);
        harga.setText(String.valueOf(total));
        TextView hargalaps = (TextView)findViewById(R.id.item_lapang_grid_harga);
        hargalaps.setText(String.valueOf(lapang.getHarga()));
        TextView namalapang = (TextView) findViewById(R.id.item_lapang_grid_name);
        namalapang.setText(lapang.getNameLap());

        btnpem = (Button)findViewById(R.id.btngtopem);

        btnpem.setOnClickListener(this);

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
            doChangeActivity(getApplication(),Topup.class);
        } else if (id == R.id.home) {
            doChangeActivity(getApplication(), MainActivity.class);
        }
        else if (id == R.id.logout) {
            SessionManager.with(getApplicationContext()).clearsession();
            doChangeActivity(getApplicationContext(), AuthActivity.class);
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if(v== btnpem)
        {
            Intent _intent = new Intent(v.getContext(),Pembayaran.class);
            _intent.putExtra("Pembayaran",total);
            _intent.putExtra("Waktu",waktu);
            _intent.putExtra("Lapangan",lapang);
            _intent.putExtra("Tanggal",tgl);
            v.getContext().startActivity(_intent);
        }
    }
}
