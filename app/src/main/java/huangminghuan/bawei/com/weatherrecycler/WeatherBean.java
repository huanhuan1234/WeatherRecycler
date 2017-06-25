package huangminghuan.bawei.com.weatherrecycler;

/**
 * Created by Huangminghuan on 2017/6/24.
 */

public class WeatherBean {
    private int inc;
    private String address;
    private String info;
    private String tem;
    private String date;

    public WeatherBean() {
    }

    public WeatherBean( String info, String tem, String date) {

        this.info = info;
        this.tem = tem;
        this.date = date;
    }

    @Override
    public String toString() {
        return "WeatherBean{" +

                " info='" + info + '\'' +
                ", tem='" + tem + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }





    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getTem() {
        return tem;
    }

    public void setTem(String tem) {
        this.tem = tem;
    }
}
