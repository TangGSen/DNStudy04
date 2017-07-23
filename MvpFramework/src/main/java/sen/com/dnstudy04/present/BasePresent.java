package sen.com.dnstudy04.present;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2017/7/23.
 */

public abstract class BasePresent<T> {
    //持有ＵＩ接口的弱引用
     protected WeakReference<T> viewRef;

    public void attach(T t){
        viewRef = new WeakReference<T>(t);
    };

    public void dettach(T t){
        viewRef.clear();
        viewRef = null;
    }

    public abstract void getData();
}
