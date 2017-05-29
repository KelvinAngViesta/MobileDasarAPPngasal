package quewquewcrew.appngasal.view.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.media.Image;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import org.w3c.dom.Text;

import quewquewcrew.appngasal.R;
import quewquewcrew.appngasal.model.entity.Lapangan;

public class DetailLapangan extends AppCompatActivity implements View.OnClickListener {

    Button btndate,btntime;
    EditText etextdate,etexttime;
    private int day,month,year,hours,minute;
    private Lapangan lapangs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lapangs = (Lapangan)getIntent().getExtras().get("Lapangan");
        setContentView(R.layout.activity_detail_lapangan);

        TextView namalapang = (TextView) findViewById(R.id.item_lapang_grid_name);
        namalapang.setText(lapangs.getNameLap());
        TextView namaKecamatan = (TextView) findViewById(R.id.item_lapang_grid_kecamatan);
        namaKecamatan.setText(lapangs.getKecamatan());
        TextView namaAlamat = (TextView) findViewById(R.id.item_lapang_grid_alamat);
        namaAlamat.setText(lapangs.getAlamatLap());
        TextView noHp = (TextView) findViewById(R.id.item_lapang_grid_notel);
        noHp.setText(lapangs.getNotel());
        TextView harga = (TextView)findViewById(R.id.item_lapang_grid_harga);
        harga.setText(String.valueOf(lapangs.getHarga()));
        ImageView imgViews = (ImageView) findViewById(R.id.item_lapang_grid_image);
        imgViews.setImageResource(lapangs.getImg());
        btndate = (Button)findViewById(R.id.btndate);
        etextdate = (EditText)findViewById(R.id.etextdate);
        btntime = (Button)findViewById(R.id.btntime);
        etexttime = (EditText) findViewById(R.id.etexttime);
        btndate.setOnClickListener(this);
        btntime.setOnClickListener(this);
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        if(v==btndate){
            final Calendar calender = Calendar.getInstance();
            day =calender.get(Calendar.DAY_OF_MONTH);
            month = calender.get(Calendar.MONTH);
            year = calender.get(Calendar.YEAR);
            DatePickerDialog datepickerdialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    etextdate.setText(dayOfMonth + "/" + (month+1) + "/" + year );

                }
            }
            ,day,month,year);
            datepickerdialog.show();
        }
        if(v==btntime){
            final Calendar calendar = Calendar.getInstance();
            hours = calendar.get(calendar.HOUR_OF_DAY);
            minute = calendar.get(calendar.MINUTE);
            TimePickerDialog timepickerdialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    etexttime.setText(hourOfDay + ":" + minute);

                }
            },hours,minute ,false);
            timepickerdialog.show();
        }
    }



}
