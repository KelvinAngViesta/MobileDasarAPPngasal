package quewquewcrew.appngasal.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import quewquewcrew.appngasal.R;
import quewquewcrew.appngasal.model.entity.Lapangan;
import quewquewcrew.appngasal.view.activity.DetailLapangan;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by User on 4/10/2017.
 */

public class UserGridARVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Lapangan> lapangans;
    public List<Lapangan> getLapangans() {
        return lapangans;
    }
    public void setLapangans(List<Lapangan> lapangans) {
        this.lapangans = lapangans;
    }
    String srch = "";
    ArrayList<Lapangan> Nlapangan;
    public Context context;
    public UserGridARVAdapter(List<Lapangan> lapangans,Context context)
    {
        this.lapangans = lapangans;
        this.context = context;
    }
    public UserGridARVAdapter() {
        this.lapangans = new ArrayList<>();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View _view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_futsal_grid, parent, false);
        return new UserGridARVAdapter.ItemUserViewHolder(_view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final UserGridARVAdapter.ItemUserViewHolder _holder = (UserGridARVAdapter.ItemUserViewHolder) holder;
        final Lapangan _lapang = this.lapangans.get(position);
        _holder.image.setImageResource(_lapang.getImg());
        _holder.name.setText(_lapang.getNameLap());
        _holder.harga.setText(String.valueOf(_lapang.getHarga()));
        ///Search
        Lapangan txt = lapangans.get(position);
        String nama = txt.getNameLap().toLowerCase(Locale.getDefault());
        if (nama.contains(srch)) {

            int startPos = nama.indexOf(srch);
            int endPos = startPos + srch.length();

            Spannable spanString = Spannable.Factory.getInstance().newSpannable(_holder.name.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.RED), startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            _holder.name.setText(spanString);
        }

        //Click Items
        _holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent _intent = new Intent(v.getContext(), DetailLapangan.class);
                _intent.putExtra("Lapangan", _lapang);
                v.getContext().startActivity(_intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return lapangans.size();
    }

    private class ItemUserViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView name, harga;

        public ItemUserViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.item_lapang_grid_image);
            name = (TextView) itemView.findViewById(R.id.item_lapang_grid_name);
            harga = (TextView) itemView.findViewById(R.id.item_lapang_grid_harga);
            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    String nama = name.getText().toString();
                }
            });
        }

    }
    public void setFilter(List<Lapangan> countryModels) {
        Nlapangan = new ArrayList<>();
        Nlapangan.addAll(countryModels);
        notifyDataSetChanged();
    }
}