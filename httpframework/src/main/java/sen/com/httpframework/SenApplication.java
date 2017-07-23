package sen.com.httpframework;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Administrator on 2017/7/23.
 */

public class SenApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false);
    }
}
