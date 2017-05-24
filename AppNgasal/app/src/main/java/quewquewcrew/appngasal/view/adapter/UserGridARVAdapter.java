package quewquewcrew.appngasal.view.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
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
        _holder.alamat.setText(_lapang.getAlamatLap());
        _holder.kecamatan.setText(_lapang.getKecamatan());
        _holder.notel.setText(_lapang.getNotel());
        _holder.harga.setText(String.valueOf(_lapang.getHarga()));

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
        private TextView name, alamat,kecamatan,notel,harga;

        public ItemUserViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.item_lapang_grid_image);
            name = (TextView) itemView.findViewById(R.id.item_lapang_grid_name);
            alamat = (TextView) itemView.findViewById(R.id.item_lapang_grid_alamat);
            kecamatan = (TextView) itemView.findViewById(R.id.item_lapang_grid_kecamatan);
            notel = (TextView) itemView.findViewById(R.id.item_lapang_grid_notel);
            harga = (TextView) itemView.findViewById(R.id.item_lapang_grid_harga);
        }
    }
}
