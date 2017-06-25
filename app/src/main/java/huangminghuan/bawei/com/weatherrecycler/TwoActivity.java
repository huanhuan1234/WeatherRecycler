package huangminghuan.bawei.com.weatherrecycler;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

public class TwoActivity extends Activity {





    List<WeatherBean> list=new ArrayList<>();
    private RecyclerView recyclerView2;
    private TextView tv_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        ButterKnife.bind(this);

        recyclerView2 = (RecyclerView) findViewById(R.id.recyclerView2);
        tv_address = (TextView) findViewById(R.id.address2);

        String address = getIntent().getStringExtra("address");
        tv_address.setText(address);

        initDate();
        recyclerView2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //添加Item 添加的时候的动画
        recyclerView2.setItemAnimator(new DefaultItemAnimator());

        //创建适配器
        TwoAdapter adapter = new TwoAdapter(this, list);
        recyclerView2.setAdapter(adapter);
        //廷加分割线
     /*   recyclerView2.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(TwoActivity.this)
                .color(Color.BLACK)
                .build());
    }*/


    }
    private void initDate() {
        for (int i = 0; i <3 ; i++) {
            WeatherBean weatherBean = new WeatherBean();
            weatherBean.setInfo("多云");
            weatherBean.setTem("2~1"+i+"C");
            weatherBean.setDate("2~17");
            list.add(weatherBean);
        }
    }

}
