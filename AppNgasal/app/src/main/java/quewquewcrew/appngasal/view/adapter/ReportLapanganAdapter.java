package quewquewcrew.appngasal.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import quewquewcrew.appngasal.R;
import quewquewcrew.appngasal.model.entity.Lapangan;
import quewquewcrew.appngasal.model.entity.User;
import quewquewcrew.appngasal.model.session.SessionManager;

/**
 * Created by User on 6/13/2017.
 */

public class ReportLapanganAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Lapangan> lapangans;
    public List<Lapangan> getLapangans(ArrayList<Lapangan> lapangans) {
        return this.lapangans;
    }

    private List<User> users;
    public List<User>getUsers(ArrayList<User> users){return this.users;}
    public ReportLapanganAdapter(){this.lapangans = new ArrayList<>();
    this.users = new ArrayList<>();}

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View _view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detailpesanan_grid, parent, false);
        return new ReportLapanganAdapter.ItemReport(_view);
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ReportLapanganAdapter.ItemReport _holder = (ReportLapanganAdapter.ItemReport) holder;
        final Lapangan _lapang = this.lapangans.get(position);
        final User _user = this.users.get(position);
        _holder.images.setImageResource(_lapang.getImg());
        _holder.namelap.setText(_lapang.getNameLap());
        _holder.harga.setText(String.valueOf(_lapang.getHarga()));
        _holder.namakec.setText(_lapang.getKecamatan());
        _holder.username.setText(_user.getName());
    }

    @Override
    public int getItemCount() {
        return lapangans.size();
    }

    private class ItemReport extends RecyclerView.ViewHolder {
        private ImageView images;
        private TextView namelap, harga,namakec,username;

        public ItemReport(View itemView) {
            super(itemView);
            images = (ImageView) itemView.findViewById(R.id.itemreportimg);
            namelap = (TextView) itemView.findViewById(R.id.itemreportnamalap);
            namakec = (TextView) itemView.findViewById(R.id.itemreportnamakecamatan);
            harga = (TextView) itemView.findViewById(R.id.itemreportharga);
            username =  (TextView)itemView.findViewById(R.id.namauser);
        }

    }
}
