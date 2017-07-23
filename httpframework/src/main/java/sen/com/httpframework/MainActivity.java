package sen.com.httpframework;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import sen.com.httpframework.core.HttpCallback;
import sen.com.httpframework.core.HttpUtils;
import sen.com.httpframework.core.RequestParam;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    String apiKey = "c97ef6446ed7baa5d3a9b015ed9c5108";

    private Button okhttp;
    private Button xutils;
    private TextView tv_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        okhttp = (Button) findViewById(R.id.okhttp);
        xutils = (Button) findViewById(R.id.xutils);
        okhttp.setOnClickListener(this);
        xutils.setOnClickListener(this);
        tv_data = (TextView) findViewById(R.id.tv_data);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.okhttp){
            getDataFromOkhttp();
        }else if (v.getId() ==R.id.xutils){
            getDataFromXutils();
        }

    }

    public void getDataFromOkhttp(){
        String url = "http://api.tianapi.com/social/";
        RequestParam requestParam = new RequestParam();
        requestParam.addParam("key",apiKey).addParam("num",10+"");
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.post(requestParam, url, new HttpCallback<String>() {
            @Override
            public void onError(int code, String errorMsg) {
                tv_data.setText("Xutils:"+errorMsg);
            }

            @Override
            public void onSuccess(String result) {
                tv_data.setText("Xutils:"+result);
            }
        });
    }
    public void getDataFromXutils(){
        String url = "http://api.tianapi.com/social/";
        RequestParam requestParam = new RequestParam();
        requestParam.addParam("key",apiKey).addParam("num",10+"");
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.post(requestParam, url, new HttpCallback<String>() {
            @Override
            public void onError(int code, String errorMsg) {
                tv_data.setText("Xutils:"+errorMsg);
            }

            @Override
            public void onSuccess(String result) {
                tv_data.setText("Xutils:"+result);
            }
        });
    }
}
