package quewquewcrew.appngasal.view.activity;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import quewquewcrew.appngasal.R;
import quewquewcrew.appngasal.model.entity.Lapangan;

public class DetailLapangan extends AppCompatActivity {
    private Lapangan lapangs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lapangs = (Lapangan)getIntent().getExtras().get("Lapangan");
        setContentView(R.layout.activity_detail_lapangan);


//        TextView namalapang = (TextView) findViewById(R.id.item_lapang_grid_name);
//        namalapang.setText(lapangs.getNameLap());
//        TextView namaKecamatan = (TextView) findViewById(R.id.item_lapang_grid_kecamatan);
//        namaKecamatan.setText(lapangs.getKecamatan());
//        TextView namaAlamat = (TextView) findViewById(R.id.item_lapang_grid_alamat);
//        namaAlamat.setText(lapangs.getAlamatLap());
//        TextView noHp = (TextView) findViewById(R.id.item_lapang_grid_notel);
//        noHp.setText(lapangs.getNotel());
        ImageView imgViews = (ImageView) findViewById(R.id.item_lapang_grid_image);
        imgViews.setImageResource(lapangs.getImg());
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
            onBackPressed();
            break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
