package sen.com.dnstudy04.modle;

import java.util.ArrayList;
import java.util.List;

import sen.com.dnstudy04.bean.Photo;

/**
 * Created by Administrator on 2017/7/23.
 */

public class PhotoMoudleImp implements IPhotoModule {
    @Override
    public void loadPoto(OnLoadComplete complete) {
        List<Photo> list = new ArrayList<>();
        list.add(new Photo("http://img.my.csdn.net/uploads/201407/26/1406383299_1976.jpg", "好漂亮"));
        list.add(new Photo("http://www.zhlzw.com/UploadFiles/Article_UploadFiles/201204/20120412123913661.jpg", "好漂亮"));
        list.add(new Photo("http://pic38.nipic.com/20140227/12551654_084024717124_2.jpg", "好漂亮"));
        list.add(new Photo("http://img.my.csdn.net/uploads/201407/26/1406383291_6518.jpg", "好漂亮"));
        list.add(new Photo("http://img.my.csdn.net/uploads/201407/26/1406383291_8239.jpg", "好漂亮"));
        list.add(new Photo("http://img.my.csdn.net/uploads/201407/26/1406383290_9329.jpg", "好漂亮"));
        list.add(new Photo("http://img.my.csdn.net/uploads/201407/26/1406383290_1042.jpg", "好漂亮"));
        list.add(new Photo("http://img.my.csdn.net/uploads/201407/26/1406383275_3977.jpg", "好漂亮"));
        list.add(new Photo("http://img.my.csdn.net/uploads/201407/26/1406383265_8550.jpg", "好漂亮"));
        list.add(new Photo("http://img.my.csdn.net/uploads/201407/26/1406383264_3954.jpg", "好漂亮"));
        list.add(new Photo("http://img.my.csdn.net/uploads/201407/26/1406383264_4787.jpg", "好漂亮"));
        list.add(new Photo("http://img.my.csdn.net/uploads/201407/26/1406383264_8243.jpg", "好漂亮"));
        list.add(new Photo("http://img.my.csdn.net/uploads/201407/26/1406383248_3693.jpg", "好漂亮"));
        list.add(new Photo("http://img.my.csdn.net/uploads/201407/26/1406383243_5120.jpg", "好漂亮"));
        list.add(new Photo("http://img.my.csdn.net/uploads/201407/26/1406383242_3127.jpg", "好漂亮"));
        list.add(new Photo("http://img.my.csdn.net/uploads/201407/26/1406383242_9576.jpg", "好漂亮"));
        list.add(new Photo("http://img.my.csdn.net/uploads/201407/26/1406383242_1721.jpg", "好漂亮"));
        list.add(new Photo("http://img.my.csdn.net/uploads/201407/26/1406383219_5806.jpg", "好漂亮"));
        list.add(new Photo("http://img.my.csdn.net/uploads/201407/26/1406383214_7794.jpg", "好漂亮"));
        list.add(new Photo("http://img.my.csdn.net/uploads/201407/26/1406383213_4418.jpg", "好漂亮"));
        list.add(new Photo("http://img.my.csdn.net/uploads/201407/26/1406383213_3557.jpg", "好漂亮"));

        complete.onSuccess(list);
    }
}
