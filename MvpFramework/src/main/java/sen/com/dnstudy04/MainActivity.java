package sen.com.dnstudy04;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.List;

import sen.com.dnstudy04.adapter.PhotoAdapter;
import sen.com.dnstudy04.bean.Photo;
import sen.com.dnstudy04.present.MainPresent;
import sen.com.dnstudy04.view.IPhotoView;

public class MainActivity extends BaseActivity<IPhotoView,MainPresent> implements IPhotoView {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.listview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        basePresent.getData();

    }

    @Override
    public MainPresent getPresent() {
       return new MainPresent(this);

    }


    @Override
    public void showLoadding() {
        Toast.makeText(this, "正在获取数据", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showPhoto(List<Photo> photos) {
        mRecyclerView.setAdapter(new PhotoAdapter(this, photos));
    }
}
