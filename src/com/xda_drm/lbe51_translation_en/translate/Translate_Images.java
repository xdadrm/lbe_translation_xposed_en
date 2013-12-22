package com.xda_drm.lbe51_translation_en.translate;

import java.util.logging.Handler;

import com.xda_drm.lbe51_translation_en.R;

import android.content.res.Resources;
import android.content.res.XModuleResources;
import android.content.res.XResources;
import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.IXposedHookZygoteInit;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;


public class Translate_Images implements IXposedHookZygoteInit, IXposedHookInitPackageResources{
    private static String MODULE_PATH = null;

    
    @Override
    public void initZygote(IXposedHookZygoteInit.StartupParam startupParam) throws Throwable    {
        // XResources.setSystemWideReplacement("android", "bool", "config_unplugTurnsOnScreen", false);
        MODULE_PATH = startupParam.modulePath;
        //      XposedBridge.log("XDA_DRM: Zygote Init ...");
    }

    @Override
    public void handleInitPackageResources(InitPackageResourcesParam resparam) throws Throwable    {
//      XposedBridge.log("XDA_DRM: Testing to Replacing LBE Strings ...");
        if (!resparam.packageName.equals("com.lbe.security"))
            return;

        ExceptionHandler handler = new ExceptionHandler();
       	Thread.setDefaultUncaughtExceptionHandler(handler);

//      XposedBridge.log("XDA_DRM: Replacing LBE Strings ...");
      XModuleResources modRes = XModuleResources.createInstance(MODULE_PATH, resparam.res);
      try { resparam.res.setReplacement("com.lbe.security", "drawable", "adware_banner_view_normal", modRes.fwd(R.drawable.adware_banner_view_normal)); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.security", "drawable", "adware_banner_view_press", modRes.fwd(R.drawable.adware_banner_view_press)); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.security", "drawable", "blocked", modRes.fwd(R.drawable.blocked)); } catch(RuntimeException e) { };          
      try { resparam.res.setReplacement("com.lbe.security", "drawable", "ic_splash", modRes.fwd(R.drawable.ic_splash)); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.security", "drawable", "phone_intercept_hint_bg_normal", modRes.fwd(R.drawable.phone_intercept_hint_bg_normal)); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.security", "drawable", "phone_intercept_hint_bg_pressed", modRes.fwd(R.drawable.phone_intercept_hint_bg_pressed)); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.security", "drawable", "private_applock_not_start", modRes.fwd(R.drawable.private_applock_not_start)); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.security", "drawable", "root_mode_auth_off", modRes.fwd(R.drawable.root_mode_auth_off)); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.security", "drawable", "root_mode_auto_on", modRes.fwd(R.drawable.root_mode_auto_on)); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.security", "drawable", "home_swipe_up_guide_text", modRes.fwd(R.drawable.home_swipe_up_guide_text)); } catch(RuntimeException e) { };

    }

}