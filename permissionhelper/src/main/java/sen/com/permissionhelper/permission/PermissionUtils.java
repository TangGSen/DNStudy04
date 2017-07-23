package sen.com.permissionhelper.permission;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/23.
 */

public class PermissionUtils {
    private PermissionUtils() {
        throw new UnsupportedOperationException("can't to init PermissionUtils,it's all static in here");
    }

    public static boolean isOverSDK23() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }

    /**
     * 执行成功的方法
     * @param object
     * @param requestCode
     */
    public static void excuteSuccessMethod(Object object, int requestCode) {
        //找到该类下所有的方法
        Method[] methods = object.getClass().getDeclaredMethods();

        //找到有注解的method
        for (Method method : methods) {
            method.setAccessible(true);
            PermissionSuccess permissionSuccess = method.getAnnotation(PermissionSuccess.class);
            if (permissionSuccess == null)
                continue;
            int reqcode = permissionSuccess.value();
            if (reqcode == requestCode) {
                //如果注解上的跟请求吗一致的话那么就执行该方法
                try {
                    method.invoke(object, new Object[]{});
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 找出被拒绝的，或者没有赋予的权限
     * @param mObject
     * @param requestPermissions
     * @return
     */
    public static List<String> findDeniedPermissions(Object mObject, String[] requestPermissions) {
        List<String> list = new ArrayList<>();
        for (String string : requestPermissions) {
            int isGet = ContextCompat.checkSelfPermission(getActivityContext(mObject), string);
            if (isGet == PackageManager.PERMISSION_DENIED){
                list.add(string);
            }
        }
        return list;
    }

    /**
     * 获取Activity
     * @param mObject
     * @return
     */
    public  static Activity getActivityContext(Object mObject) {
        if (mObject instanceof Activity) {
            return (Activity) mObject;
        } else if (mObject instanceof Fragment) {
            return ((Fragment) mObject).getActivity();
        }
        return null;
    }

    /**
     *  执行拒绝权限的方法
     *
     */

    public static void excuteFailMethod(Object object, int requestCode) {
        //找到该类下所有的方法
        Method[] methods = object.getClass().getDeclaredMethods();

        //找到有注解的method
        for (Method method : methods) {
            method.setAccessible(true);
            PermissionFail permissionSuccess = method.getAnnotation(PermissionFail.class);
            if (permissionSuccess == null)
                continue;
            int reqcode = permissionSuccess.value();
            if (reqcode == requestCode) {
                //如果注解上的跟请求吗一致的话那么就执行该方法
                try {
                    method.invoke(object, new Object[]{});
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
