package sen.com.dnstudy04.present;

import java.util.List;

import sen.com.dnstudy04.bean.Photo;
import sen.com.dnstudy04.modle.IPhotoModule;
import sen.com.dnstudy04.modle.PhotoMoudleImp;
import sen.com.dnstudy04.view.IPhotoView;

/**
 * Created by Administrator on 2017/7/23.
 */

public class MainPresent extends BasePresent<IPhotoView> {
    IPhotoView iPhotoView;

    IPhotoModule iPhotoModule;

    public MainPresent(IPhotoView iPhotoView) {
        this.iPhotoView = iPhotoView;
        iPhotoModule = new PhotoMoudleImp();
    }



    @Override
    public void getData() {
        iPhotoView.showLoadding();
        iPhotoModule.loadPoto(new IPhotoModule.OnLoadComplete() {
            @Override
            public void onSuccess(List<Photo> photos) {
                iPhotoView.showPhoto(photos);
            }
        });
    }
}
