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
import android.view.View.OnClickListener;
import android.widget.Toast;

import org.w3c.dom.Text;

import quewquewcrew.appngasal.R;
import quewquewcrew.appngasal.model.entity.Lapangan;

public class DetailLapangan extends AppCompatActivity implements View.OnClickListener {

    Button btndate,btntimestart,btntimestop,btnbook;
    EditText etextdate,etexttimestart,etexttimestop;
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
        //btn date
        btndate = (Button)findViewById(R.id.btndate);
        btnbook = (Button)findViewById(R.id.btnbooking);
        etextdate = (EditText)findViewById(R.id.etextdate);
        etextdate.setFocusable(false);
        //btn time start
        btntimestart = (Button)findViewById(R.id.btntimestrat);
        etexttimestart= (EditText) findViewById(R.id.etexttimestart);
        etexttimestart.setFocusable(false);
        //btn time stop
        btntimestop = (Button) findViewById(R.id.btntimestop);
        etexttimestop = (EditText) findViewById(R.id.etexttimestop);
        etexttimestop.setFocusable(false);


        btnbook.setOnClickListener(this);
        btndate.setOnClickListener(this);
        btntimestop.setOnClickListener(this);
        btntimestart.setOnClickListener(this);
        if(etexttimestart.getText().toString().matches("") || etexttimestop.getText().toString().matches(""))
        {
            btnbook.setEnabled(false);
        }
        else
        {
            btnbook.setEnabled(true);
            event();
        }


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
        if (v == btndate) {
            final Calendar calender = Calendar.getInstance();
            day = calender.get(Calendar.DAY_OF_MONTH);
            month = calender.get(Calendar.MONTH);
            year = calender.get(Calendar.YEAR);
            DatePickerDialog datepickerdialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    etextdate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                }
            }
                    , day, month, year);

            datepickerdialog.show();
        }
        if (v == btntimestart) {
            final Calendar calendar = Calendar.getInstance();
            hours = calendar.get(calendar.HOUR_OF_DAY);
            minute = calendar.get(calendar.MINUTE);

            TimePickerDialog timepickerdialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    etexttimestart.setText(hourOfDay + ":" + minute);

                }
            }, hours, minute, true);
            timepickerdialog.show();
        }

        if (v == btntimestop) {
            final Calendar calendar = Calendar.getInstance();
            hours = calendar.get(calendar.HOUR_OF_DAY);
            minute = calendar.get(calendar.MINUTE);

            TimePickerDialog timepickerdialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                    etexttimestop.setText(hourOfDay + ":" + minute);

                }
            }, hours, minute, true);
            timepickerdialog.show();
        }

    }


    private void event()
    {
        btnbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if(ConvertTime(etexttimestart.getText().toString()) > ConvertTime(etexttimestop.getText().toString()))
                 {
                     btnbook.setEnabled(false);
                 }
                 else
                 {
                     Toast.makeText(DetailLapangan.this,"Udah bisa next bro",Toast.LENGTH_LONG).show();
                 }
            }

        });
    }

    public static int toSecond(String s)
    {
        String[] Waktu = s.split(":");
        int jam = Integer.parseInt(Waktu[0]);
        int menit = Integer.parseInt(Waktu[1]);
        int Jamkedetik = jam * 3600;
        int Menitkedetik = menit * 60;
        return Jamkedetik + Menitkedetik;
    }

    public static int toHour(String s) {
        String waktu = s;
        int detik = Integer.parseInt(waktu);
        return detik / 3600;
    }

    public int ConvertTime(String s)
    {
        int waktu;
        waktu = toSecond(s);
        return waktu;
    }


}
