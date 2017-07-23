package sen.com.permissionhelper.permission;

import android.app.Activity;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;

import java.util.List;

/**
 * Created by Administrator on 2017/7/23.
 */

public class PermissionHelper {
    //这个代表的是Activity 或者是Fragment
    Object mObject;

    int mRequestCode;

    String[] requestPermissions;


    private PermissionHelper(Object obj){
        this.mObject = obj;
    }

    public static PermissionHelper with(Activity activity){
        return new PermissionHelper(activity);
    }

    public static PermissionHelper with(Fragment fragment){
        return new PermissionHelper(fragment);
    }
     public PermissionHelper setRequestCode(int requestCode){
         this.mRequestCode = requestCode;
        return this;
    }

    public PermissionHelper setRequestPermissions(String... requestPermissions){
        this.requestPermissions = requestPermissions;
        return this;
    }

    /**
     * 发起请求和判断
     */
    public void request() {
      //1.先判断是否是6.0以上的版本
        //2.如果不是，直接运行，但是由于不知道执行什么方法，需要通过注解，反射
        //3.如果是6.0以上，需要判断有没限权
        //4.如果没有权限，那么申请权限
        //5如果有权限那么，直接注解反射运行

        if (!PermissionUtils.isOverSDK23()){
            PermissionUtils.excuteSuccessMethod(mObject,mRequestCode);
            return;
        }

        //找出传来权限中没有权限的
        List<String> deniedPermissions = PermissionUtils.findDeniedPermissions(mObject,requestPermissions);

        if (deniedPermissions.size()==0){
            //就是权限已经有了
            PermissionUtils.excuteSuccessMethod(mObject,mRequestCode);
        }else{
            ActivityCompat.requestPermissions(
                     PermissionUtils.getActivityContext(mObject),
                    deniedPermissions.toArray(new String[deniedPermissions.size()])
                    ,mRequestCode);
        }

    }

    public static void onRequestPermissionsResult(Object object,int requestCode, String[] permissions, int[] grantResults) {
        //回调中再次获取看看有没有赋予权限
        //找出传来权限中没有权限的
        List<String> deniedPermissions = PermissionUtils.findDeniedPermissions(object,permissions);
        if (deniedPermissions.size()==0){
            //就是权限已经有了
            PermissionUtils.excuteSuccessMethod(object,requestCode);
        }else{
            //说明，有权限没有赋予，走失败方法
            PermissionUtils.excuteFailMethod(object,requestCode);
        }
    }


}
