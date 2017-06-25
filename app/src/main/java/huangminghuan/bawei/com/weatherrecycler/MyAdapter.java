package huangminghuan.bawei.com.weatherrecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by Huangminghuan on 2017/6/24.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CViewHolder> {
    Context context;
    ArrayList<HashMap<String,String>> list;
    public MyAdapter(Context context, ArrayList<HashMap<String,String>> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public MyAdapter.CViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CViewHolder cViewHolder =new CViewHolder(View.inflate(context,R.layout.listveiw_item,null));

        return cViewHolder;
    }

    @Override
    public void onBindViewHolder(MyAdapter.CViewHolder holder, final int position) {

        HashMap<String,String> map= list.get(position);
            holder.tv.setText(map.get("key"));

        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.setOnItemClickListener(position,view);
            }
        });



    }

    @Override
    public int getItemCount() {

        return list==null? 0:list.size();
    }

    public class CViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        LinearLayout ll;
        public CViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.textViewAddress);
            ll = (LinearLayout) itemView.findViewById(R.id.ll1);

        }
    }


    public interface OnItemClickListener{
        void setOnItemClickListener(int position,View view);
    }
    OnItemClickListener onItemClickListener;
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;

    }

}
