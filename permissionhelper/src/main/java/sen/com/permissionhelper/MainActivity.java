package sen.com.permissionhelper;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import sen.com.permissionhelper.permission.PermissionFail;
import sen.com.permissionhelper.permission.PermissionHelper;
import sen.com.permissionhelper.permission.PermissionSuccess;

public class MainActivity extends AppCompatActivity {
    private final static int REQUEST_PERMISSION_CODE = 0x001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PermissionHelper.with(this)
                .setRequestCode(REQUEST_PERMISSION_CODE)
                .setRequestPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .request();

    }

    @PermissionSuccess(REQUEST_PERMISSION_CODE)
    public void readFile(){

    }

    /**
     * 拒绝权限
     */
    @PermissionFail(REQUEST_PERMISSION_CODE)
    public void denidWriteSD(){

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PermissionHelper.onRequestPermissionsResult(this,requestCode,permissions,grantResults);
    }
}
