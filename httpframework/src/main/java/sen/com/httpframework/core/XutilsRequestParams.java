package sen.com.httpframework.core;

import org.xutils.http.RequestParams;

/**
 * Created by Administrator on 2017/7/23.
 */

public class XutilsRequestParams implements IRequestParams<XutilsRequestParams,RequestParams>{
    private RequestParams requestParams ;
    public XutilsRequestParams(){
        requestParams = new RequestParams();

    }


    @Override
    public XutilsRequestParams addParam(String key, String value) {
        requestParams.addQueryStringParameter(key,value);
        return this;
    }

    @Override
    public RequestParams getRequestParm() {
        return requestParams;
    }


}
