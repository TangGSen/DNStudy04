package sen.com.dnstudy04.modle;

import java.util.List;

import sen.com.dnstudy04.bean.Photo;

/**
 * Created by Administrator on 2017/7/23.
 */

public interface IPhotoModule {
    void loadPoto(OnLoadComplete complete);

    interface OnLoadComplete {
        void onSuccess(List<Photo> photos);
    }
}
