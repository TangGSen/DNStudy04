package sen.com.httpframework.core;

/**
 * Created by Administrator on 2017/7/23.
 */

public class HttpUtils implements HttpEngine{

    OkHttpEngine httpEngine ;
    public HttpUtils(){
        httpEngine = new OkHttpEngine();
    }
    @Override
    public void post(RequestParam param, String url,  HttpCallback httpCallback) {
        httpEngine.post(param,url,httpCallback);


    }

    @Override
    public void get(RequestParam param, String url, HttpCallback httpCallback) {
        httpEngine.get(param,url,httpCallback);
    }
}
