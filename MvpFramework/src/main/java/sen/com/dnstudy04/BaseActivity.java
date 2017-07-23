package sen.com.dnstudy04;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import sen.com.dnstudy04.present.BasePresent;

/**
 * Created by Administrator on 2017/7/23.
 */

public abstract class BaseActivity<V,T extends BasePresent<V>> extends AppCompatActivity {

    protected T basePresent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        basePresent = getPresent();
        basePresent.attach((V)this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        basePresent.dettach((V)this);
    }

    public abstract T getPresent() ;
}
