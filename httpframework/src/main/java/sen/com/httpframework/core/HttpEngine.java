package sen.com.httpframework.core;

/**
 * Created by Administrator on 2017/7/23.
 */

public interface HttpEngine {

    void post(RequestParam param, String url, HttpCallback httpCallback);

    void get(RequestParam param, String url, HttpCallback httpCallback);
}
