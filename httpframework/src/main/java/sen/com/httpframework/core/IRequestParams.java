package sen.com.httpframework.core;

/**
 * Created by Administrator on 2017/7/23.
 */

public interface IRequestParams<V,T> {
    V addParam(String key,String value);
    T getRequestParm();
}
