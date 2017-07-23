package sen.com.httpframework.core;

/**
 * Created by Administrator on 2017/7/23.
 */

public interface HttpCallback<T> {

    void onError(int code ,String errorMsg);

    void onSuccess(T t);
}
