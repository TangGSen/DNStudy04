package sen.com.httpframework.core;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by Administrator on 2017/7/23.
 */

public class XutilsHttpEngine implements HttpEngine {
    private Handler mHandler = new Handler(Looper.getMainLooper());
    @Override
    public void post(RequestParam param, String url, final HttpCallback httpCallback) {
//        RequestParams xutilsParam = param.getRequestParm().getRequestParm();
//        xutilsParam.setUri(url);
//        x.http().post(xutilsParam, new Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess( String result) {
//                final String results = result;
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        httpCallback.onSuccess(results);
//                    }
//                });
//
//            }
//
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//                final String msg = ex.getMessage();
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        httpCallback.onError(0,msg);
//                    }
//                });
//
//            }
//
//            @Override
//            public void onCancelled(CancelledException cex) {
//
//            }
//
//            @Override
//            public void onFinished() {
//
//            }
//        });
    }

    @Override
    public void get(RequestParam param, String url, HttpCallback httpCallback) {

    }
}
