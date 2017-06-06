package quewquewcrew.appngasal.view.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.media.Image;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
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

import java.util.ArrayList;
import java.util.List;

import quewquewcrew.appngasal.R;
import quewquewcrew.appngasal.model.entity.Lapangan;

public class DetailLapangan extends AppCompatActivity implements View.OnClickListener {

    Button btndate, btntimestart, btntimestop, btnbook;
    EditText etextdate, etexttimestart, etexttimestop;
    private int day, month, year, hours, minute;
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
        event();


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

                if(etextdate.getText().toString().matches(""))
                {
                    Toast.makeText(DetailLapangan.this,"Date Yang Dipilih tidak boleh kosong",Toast.LENGTH_LONG).show();
                }
                else if (etexttimestart.getText().toString().matches("") || etexttimestop.getText().toString().matches(""))
                {
                    Toast.makeText(DetailLapangan.this, "Waktu yang dipilih tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
                else if(ConvertTime(etexttimestart.getText().toString()) >= ConvertTime(etexttimestop.getText().toString()))
                {
                    Toast.makeText(DetailLapangan.this,"Jam Yang Dipilih tidak sesuai",Toast.LENGTH_LONG).show();
                }
                else if(((ConvertTime(etexttimestop.getText().toString())-ConvertTime(etexttimestart.getText().toString())))%3600 !=0)
                {
                    Toast.makeText(DetailLapangan.this,"Jam Yang Dipilih tidak sesuai",Toast.LENGTH_LONG).show();
                }
                 else
                 {
                     String tanggal = etextdate.getText().toString();
                     float jam = toHour(ConvertTime(etexttimestop.getText().toString())-ConvertTime(etexttimestart.getText().toString()));

                     Intent _intent = new Intent(view.getContext(),Komfirmasi.class);
                     _intent.putExtra("Lapangan",lapangs);
                     _intent.putExtra("Tanggal",tanggal);
                     _intent.putExtra("Jam", jam);

                     Toast.makeText(DetailLapangan.this,"next time",Toast.LENGTH_LONG).show();
                     view.getContext().startActivity(_intent);
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

    public static float toHour(int s) {

        int detik = s;
        return (float)detik / 3600;
    }

    public int ConvertTime(String s)
    {
        int waktu;
        waktu = toSecond(s);
        return waktu;
    }
    public static void doChangeActivity (Context context, Class destination) {
        Intent _intent = new Intent(context, destination);
        _intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(_intent);
    }

}
