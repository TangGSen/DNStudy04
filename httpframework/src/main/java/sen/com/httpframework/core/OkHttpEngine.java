package sen.com.httpframework.core;

import android.os.Handler;
import android.os.Looper;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Administrator on 2017/7/23.
 */

public class OkHttpEngine implements HttpEngine {
    private Handler mHandler = new Handler(Looper.getMainLooper());
    @Override
    public void post(RequestParam param, String url, final HttpCallback httpCallback) {
        OkHttpClient mOkHttpClient =new OkHttpClient();
        FormEncodingBuilder okBuidler = param.getRequestParm().getRequestParams();

        Request request = new Request.Builder()
                .url(url)
                .post(okBuidler.build())
                .build();
        mOkHttpClient.newCall(request).enqueue(new Callback(){
            @Override
            public void onFailure(Request request, IOException e) {
                final String results = e.getMessage();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        httpCallback.onSuccess(results);
                    }
                });

            }

            @Override
            public void onResponse(Response response) throws IOException {
                final String results = new String(response.body().bytes());
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        httpCallback.onSuccess(results);
                    }
                });
            }
        });
    }

    @Override
    public void get(RequestParam param, String url, HttpCallback httpCallback) {

    }
}
