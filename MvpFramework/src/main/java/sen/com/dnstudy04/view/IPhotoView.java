package sen.com.dnstudy04.view;

import java.util.List;

import sen.com.dnstudy04.bean.Photo;

/**
 * Created by Administrator on 2017/7/23.
 */

public interface IPhotoView {
    void showLoadding();

    void showPhoto(List<Photo> photos);


}
