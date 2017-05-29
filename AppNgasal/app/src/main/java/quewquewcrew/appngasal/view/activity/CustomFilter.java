//package quewquewcrew.appngasal.view.activity;
//
//import android.widget.Filter;
//
//import java.util.ArrayList;
//
//import quewquewcrew.appngasal.model.entity.Lapangan;
//import quewquewcrew.appngasal.view.adapter.UserGridARVAdapter;
//
///**
// * Created by User on 5/25/2017.
// */
//
//public class CustomFilter extends Filter {
//    UserGridARVAdapter adapters;
//    ArrayList<Lapangan> filterList;
//
//    public CustomFilter(ArrayList<Lapangan> filterList,UserGridARVAdapter adapters)
//    {
//
//        this.adapters = adapters;
//        this.filterList = filterList;
//    }
//
//    @Override
//    protected FilterResults performFiltering(CharSequence constraint) {
//        FilterResults results = new FilterResults();
//        if(constraint != null && constraint.length()>0)
//        {
//            constraint = constraint.toString().toUpperCase();
//            ArrayList<Lapangan> filterLapangan =new ArrayList<>();
//            for (int i=0;i<filterList.size();i++)
//            {
//                if (filterList.get(i).getNameLap().toUpperCase().contains(constraint))
//                {
//                    filterLapangan.add(filterList.get(i));
//                }
//                else
//                {
//                    results.count=filterList.size();
//                    results.values=filterList;
//                }
//            }
//        }
//        return results;
//    }
//
//    @Override
//    protected void publishResults(CharSequence constraint, FilterResults results) {
//        adapters.getLapangans();
//    }
//}
