package huangminghuan.bawei.com.weatherrecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Huangminghuan on 2017/6/24.
 */

public class TwoAdapter extends RecyclerView.Adapter<TwoAdapter.TViewHolder> {

    Context context;
    List<WeatherBean> list;
    public TwoAdapter(Context context, List<WeatherBean> list) {
        this.list=list;
        this.context=context;
    }

    @Override
    public TwoAdapter.TViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TViewHolder tViewHolder=new TViewHolder(View.inflate(context,R.layout.two_item,null));

        return tViewHolder;

    }

    @Override
    public void onBindViewHolder(TwoAdapter.TViewHolder holder, int position) {

        holder.iv.setImageResource(R.mipmap.ic_launcher);
        holder.info.setText(list.get(position).getInfo());
        holder.tem.setText(list.get(position).getTem());
        holder.date.setText(list.get(position).getDate());
    }

    @Override
    public int getItemCount() {

        return list==null?0:list.size();
    }
   public class TViewHolder extends RecyclerView.ViewHolder{
       ImageView iv;
       TextView info;
       TextView tem;
       TextView date;
       public TViewHolder(View itemView) {

           super(itemView);
           iv = (ImageView) itemView.findViewById(R.id.iv);
           info = (TextView) itemView.findViewById(R.id.tv_info);
           tem = (TextView) itemView.findViewById(R.id.tv_tem);
           date = (TextView) itemView.findViewById(R.id.tv_date);
       }
   }
}
