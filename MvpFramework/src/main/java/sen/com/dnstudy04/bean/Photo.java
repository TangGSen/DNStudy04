package sen.com.dnstudy04.bean;

/**
 * Created by Administrator on 2017/7/23.
 */

public class Photo {
    private String url;
    private String des;

    public Photo(String url, String des) {
        this.url = url;
        this.des = des;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
