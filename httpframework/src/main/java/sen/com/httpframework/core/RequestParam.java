package sen.com.httpframework.core;

/**
 * Created by Administrator on 2017/7/23.
 */

public class RequestParam implements IRequestParams<RequestParam,OKRequestParams>{
    OKRequestParams xutilsRequestParams ;
    public RequestParam(){
        xutilsRequestParams = new OKRequestParams();
    }


    @Override
    public RequestParam addParam(String key, String value) {
        xutilsRequestParams.addParam(key,value);
        return this;
    }

    @Override
    public OKRequestParams getRequestParm() {
        return xutilsRequestParams;
    }
}
