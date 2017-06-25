package huangminghuan.bawei.com.weatherrecycler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.ll)
    LinearLayout ll;

    ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        // 为 item add remove 时增加动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        for (int i = 0; i < 10; i++) {
            HashMap<String, String> map = new HashMap<String, String>();

            map.put("key", "北京" + i);

            list.add(map);
        }

        MyAdapter adapter = new MyAdapter(this, list);

        recyclerView.setAdapter(adapter);

//        添加分割线
       /* recyclerView.addItemDecoration(

                new HorizontalDividerItemDecoration.Builder(MainActivity.this)
                        .color(Color.BLACK)
                       // .sizeResId(R.dimen.divider)
                        //.marginResId(R.dimen.leftmargin, R.dimen.rightmargin)
                        .build());*/
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void setOnItemClickListener(int position, View v) {

                Intent intent=new Intent(MainActivity.this,TwoActivity.class);
                intent.putExtra("address",list.get(position).get("key"));
                startActivity(intent);
            }
        });
    }


}
