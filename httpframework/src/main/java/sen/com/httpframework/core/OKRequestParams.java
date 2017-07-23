package sen.com.httpframework.core;

import com.squareup.okhttp.FormEncodingBuilder;

/**
 * Created by Administrator on 2017/7/23.
 */

public class OKRequestParams implements IRequestParams<OKRequestParams,FormEncodingBuilder> {


    private FormEncodingBuilder requestParams;


    public OKRequestParams() {
        requestParams = new FormEncodingBuilder();
    }


    public FormEncodingBuilder getRequestParams() {
        return requestParams;
    }


    @Override
    public OKRequestParams addParam(String key, String value) {
        requestParams.add(key, value);
        return this;
    }

    @Override
    public FormEncodingBuilder getRequestParm() {
        return this.requestParams;
    }
}
