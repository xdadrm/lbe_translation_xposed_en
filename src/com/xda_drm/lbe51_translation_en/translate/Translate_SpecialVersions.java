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


public class Translate_SpecialVersions implements IXposedHookZygoteInit, IXposedHookInitPackageResources{
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
Integer older=0;


// Require UTF-8 16 bit Characters - see http://www.irongeek.com/homoglyph-attack-generator.php
try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_Today","﻿Τοԁау"); } catch(RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_Yesterday","﻿Үеѕτеʀԁау"); } catch(RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_Before_Yesterday","ΒеｆοʀеҮеѕτеʀԁау"); } catch(RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_Tomorrow","ΤοМοᏒᏒοѡ"); } catch(RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_After_Tomorrow","AｆτеʀΤοМοᏒᏒοѡ"); } catch(RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_Before_Dawn","﻿ΒеｆοʀеⅮаѡɴ"); } catch(RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_AM","ΑϺ﻿"); } catch(RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_Noon","﻿Νооɴ"); } catch(RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_PM","РМ"); } catch(RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_Night","﻿Νіɡһτ"); } catch(RuntimeException e) { };

// Version Dependent Strings
      try { resparam.res.setReplacement("com.lbe.security", "string", "Battery_NotifMode","Battery logging"); } catch(RuntimeException e) { };
      try { resparam.res.setReplacement("com.lbe.security", "string", "Battery_NotifMode_Des","Battery always under control"); } catch(RuntimeException e) { };

      // Should only be loaded for LBE 5.1.4722 (and earlier ?)

      try { resparam.res.setReplacement("com.lbe.security", "string", "Update_VirusEngine_Title","Virus detection engine updates"); }
        catch(RuntimeException e) { 
        	older=1;
        };

        if(older>0) { try { resparam.res.setReplacement("com.lbe.security", "string", "AV_Update_CurrentVer","Virus database version :%1$s"); } catch(RuntimeException e) { };
        }
      
//      try { resparam.res.setReplacement("com.lbe.security", "string", "AD_Behavior_Title",". Contains adware may have the following behavior :"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "AD_No_Risk_App","Risk Software (%1$d)"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "AD_Style_Force_Window",". Popup ads."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "AV_Cancel_Message","Antivirus has not been completed , whether to terminate the scan ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "AV_NoVirus","Your phone is safe. remember to always check later"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "AV_ToolStoragePath","[ Risk Tool Location ]"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Battery_Action_ActiveMode","Activate &lt;font color=\"#17A4F5\">%1$s &lt;/font>"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Battery_Bright_CheckMsg","Lowest screen brightness detection , may cause your phone screen dims short time , please do not worry. Selection without detection, will use the default 12% brightness as the minimum brightness.Â Minimum brightness is detected ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Battery_Bright_Min","LBE recommended minimum brightness of your screen is limited to %1$d%%, protected screen eyesight !"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Battery_Condition_BatteryLow","Battery is low (&lt;%1$d%%)"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Battery_Condition_LevelChange","&lt;font color=\"#17A4F5\"> &lt;U>%1$s &lt;/U> &lt;/font>, &lt;font color=\"#17A4F5\"> &lt;U>%2$s &lt;/U> &lt;/font> Effective"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Battery_Consumption_Save","LBE security master to help you quit %1$s background task processes , cell phone battery extended using 8 minutes ."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Battery_CustomModes","Custom Modes"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Battery_Delete_NightTip","Delete this Night Mode tasks ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Battery_Delete_TriggerTip","Whether to delete the current configuration , personalized task ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Battery_Exception_Empty","There are no additional conditions for it. Want more, you can ontact us QQ or Twitter"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Battery_Log_Service_Stop" ,"%> _ &lt;% , The battery assistant laid off"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Battery_NightMode_Enter","Night Mode begins :"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Battery_NightMode_Exit","After clocking modes :"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Battery_Shortcut_NotSupport","Since your current system prohibits Andrews calls this operation , setting is invalid , please forgive me !"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Battery_Shortcut_NotSupport_AIR","Your current Android disable automatic switching flight mode , but also hope know"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Battery_Shortcut_NotSupport_GPS","Your current Android disable automatic switch GPS positioning, but also look know"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Battery_Shortcut_NotSupport_GPS_AIR","Your current Android GPS and disable the automatic switch flight mode, but also look know"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Battery_Shortcut_Vibration","Shock"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Battery_ShowToastDes","Battery Optimize changes the phone status alert"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "block_error_tips_message","When blocking mode select \" Off \", \" empty number \", \" stop\" mode, if you encounter MMI code error , please call forwarding feature, you can directly dial telephone operator services directly open ( free ) ."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "call_phone_error","No cards or network anomalies , can not make calls !"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "copyright","Copyright Â© 2012-2013 LBE security masterÂ All Rights Reserved"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "download_unknown_title","&lt;Untitled>"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Canceling","Cancelling ..."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Clip","Streamline"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Date_Formatter","In MM -dd- yy HH points at sub- mm"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Inform","Report"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Loading","Loading ..."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Low_Memory","Phone memory is exhausted ! Delete some files to free up space ."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Operating","Being executed ..."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_After_Tomorrow","Acquired"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_AM","Morning"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_Before_Dawn","Early in the morning"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_Before_Yesterday","The day before yesterday"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_Formatter","HH point mm Minute"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_Night","At night"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_Noon","Noon"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_PM","Afternoon"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_Today","Today"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_Tomorrow","Tomorrow"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Generic_Time_Yesterday","Yesterday"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Action_Accept_Colored","&lt;font color=#478800> allow &lt;/font>"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Action_Prompt","Prompt"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Action_Prompt_Colored","&lt;font color=#FF8A00> Tip &lt;/font>"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Action_Reject_Colored","&lt;font color=#DF0000> Reject &lt;/font>"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_App_Count","%1$d models"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_App_NewApp","Click to view %1$s relevant authority"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_App_NewApps","%1$d paid software you configure permissions"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_App_NewAppsWithAdware","%1$d paid software you configure permissions (%2$d models including advertising )"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_App_Trusted","Inspection Software (%1$d)"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Conflict_LBE_Step1","Click the \" Settings"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Conflict_LBE_Step2","Close \" active defense service "); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Conflict_MIUI_Step1","Click on \"Software Permission manager "); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Conflict_MIUI_Step2_V4","Close the \"Software Permission manager "); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Conflict_MIUI_Step2_V5","Close the \" authority to monitor "); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Conflict_MIUI_Title","Millet phone built LBE active defense services Please refer to th following steps to turn off"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Conflict_Verify","Will you turn off the built in accordance with the process of active defense services ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Perm_Call","Phone"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Perm_CallLog_Hint","%1$s has Permission to access the call log"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Perm_CallMonitor_Desc","Listener call content , control volume, etc."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Perm_CallMonitor_Hint","%1$s has Permission monitor conversations , control volume, etc."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Perm_CallState_Hint","%1$s has Permission for phone calls , call, hang up and other state"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Perm_Call_Hint","%1$s ask for permission to answer or hang up the phone"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Perm_Contact_Hint","%1$s shall have access to the contact list software"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Perm_Location_Hint","%1$s has Permission to locate your mobile phone"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Perm_MobileNetwork_Hint","%1$s has Permission to access the network"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Perm_PhoneID_Desc","Get your phone PIN, including IMEI, IMSI, phone number , etc."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Perm_PhoneID_Hint","%1$s has Permission for your phone ID"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Perm_Recorder_Hint","%1$s shall be entitled pictures or recording software"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Perm_SendSMS_Hint","%1$s has Permission to send SMS"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Perm_Settings_Hint","%1$s has Permission to modify system settings"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Perm_SMS_Hint","%1$s has Permission to access SMS inbox"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Perm_WIFINetwork_Hint","%1$s has Permission to access the network"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "HIPS_Root_Shuame_2","Please use your computer to access :"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Home_About_mail","E-mail : &lt;a href=mailto:lbe@lbesec.com> lbe@lbesec.com &lt;/a>"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Home_About_phones","Tel : &lt;a href=tel:01085997019> 010-85997019 &lt;/a>"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Home_About_urls","&lt;p> official website : &lt;a href=http://www.lbesec.com> www.lbesec.com &lt;/a> &lt;/p> &lt;p> Product microblogging : &lt;a href = http://weibo.com/lbesec> LBE group &lt;/a> &lt;/p>"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Home_BackupEmpty","No backup file , click Create Backup button to back up"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Home_DeleteConfirm","Are you sure you want to delete the backup files?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Home_Disturb_Block","Call blocking"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Home_Exit_Warning","Close LBE security master security service , your phone will lose protection, whether to continue ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Home_Feedback_CreatingLogErrorFile","Report an error log is being generated ..."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Home_Feedback_Sending","Submitting feedback ..."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Home_First_Check_Tips","There is a risk of your phone , come examination under the bar !"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Home_Now_Loading","Loading ..."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Home_Onekey_Check","START NOW"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Home_Optimize_OneClick","OneClick Optimize"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Home_RestoreConfirm","Restore this backup, all your settings will be lost Are you sure ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Keyguard_ForgetPassword","Forgot your password ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "miui_sms_block_desc","MIUI system default priority on SMS intercept , if you want to use LBE security master blocking spam messages , you need to configure the following:"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "miui_step_2","2 Click the phone menu button, the pop-up menu , click on \"Settings ."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "miui_step_3","3 Slide the list in the end portion , click on \" Advanced Settings ."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "miui_step_4","4 Click Close \"System Message Priority\" , which allows third-party application intercepts the SMS notification ."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Nft_Mgr_Title","Notification Manager"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "notification_filename_separator",","); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Patch_Action_Get","Get System Patch"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Patch_Action_Install","Install system patches"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Patch_Cancel_Warn","Being cloud acquisition system patches, you are sure to cancel it ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Patch_Check_Fixed","Vulnerabilities have been fixed"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Patch_Check_Fixed_Dest","You have successfully installed LBE MasterKey bug fixes, security vulnerabilities have been fixed"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Patch_Description","MasterKey risk vulnerability allows hackers to inject arbitrary application becomes Trojans, in case you are not aware of complete control of your phone, steal privacy and suction fees LBE Master Key patches installed on your phone can help the immune vulnerability , this patch can be run independently from the LBE security master , immediately repair"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Patch_Description_RootFree","MasterKey risk vulnerability allows hackers to inject arbitrary application becomes Trojans, in case you are not aware of complete control of your phone, steal privacy and suction fees LBE Master Key patches installed on your phone can help the immune vulnerability , this patch can be run independently from the LBE security master Free ROOT active defense services require that you first fix this vulnerability , please fix this vulnerability"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Patch_Download_Failure","Failed to get the system to fit your phone patch , please try again later"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Patch_Download_Success","System patch is ready , install"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Patch_Installed_AutoReboot","System patch installation is successful , the phone will be in %1$d seconds after the automatic restart"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Patch_Installed_Tips","System patch installation is successful , immediately restart the phone to turn on protection"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Patch_Title","MasterKey vulnerabilities exist on your system"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_AddBlack_OrNot","Whether to join the blacklist ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_Affirm_Clear","Confirm Clear all selections do ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_Affirm_Delete","Confirm to delete the selected number?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_Alert_AddBlack_Content","Whether immediately strange number :%s added to the blacklist , refusing again harassed ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_Alert_Add_White","Whether to restore SMS and call records to the system ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_Alert_Vibrate","When you make a call, the other party will be switched on security master vibrating alert , this feature is available in the toolbox of communication enhanced communication setting , whether you use the vibration function turned on ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_Block_Reason_Pattern","All intercept"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_Block_Reason_Smart","Intelligence intercept"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_Block_Type_AllAllow","All reception"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_Block_Type_ALlReject","All intercept"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_Block_Type_Black","Intercept only blacklist"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_Block_Type_Norm","Smart intercept mode"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_Clear_ALL_IpNoUse","Sure you want to clear all NA IP dialing number?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_Clear_ALL_Log_Message","Sure you want to clear all the interception record it ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_Custom_Whitelist","White List"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_Data_Upload_Declare","LBE security master invites you to use cloud security services. Cloud-enabled security service , LBE can be more accurate intercept harassment , you can also feel free to report harassment. Cloud security services will not only waste your WIFI network data traffic . You can use it .Will you use ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_Mark_AddMark_Content","Whether the number tag ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_mark_strange_message","You have just received a strange number %1$s call, ask whether you are causing harassment ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_mark_thanks_for_mark","Thanks for your mark !"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_MsgBlock_Fail_Hint","Intercept SMS unsuccessful ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_ReportMessageTitle","Report Spam messages"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_Report_SpamSms_Message","Confirm Report this text?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_Rule_No","Intercept"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_Rule_Smart","Intelligence intercept"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Phone_Whitelist","White List"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Plugin_AppLock_Install","Whether to download and install privacy space ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Plugin_Delete_Message","You are trying to uninstall %1$s. After unloading ,%1$s will be removed from the system , whether to continue ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Pref_Main_CleanShortcut","Add a shortcut to the desktop key clean-up"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Pref_Main_Password_Confirm","Confirm Password:"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Pref_Main_Password_New","Password:"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Pref_Main_Phone_Service","Communication Firewall Service"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Pref_Main_Professional_DeepWarning","On this mode, the operation involving garbage , are completely removed, use with caution ."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Pref_Traffic_Adjust_PhoneQuery","Phone"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Pref_Traffic_Clean_Dialog","All traffic statistics will be cleared , whether to continue ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "private_add_fakeUser_warning","Set false users, safety quiz fail , continue to set ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "private_alert_recover_sms","Whether the privacy of communication to the system data recovery"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "private_choose_entrance","Choose entrance:"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "private_delete_calllog","Are you sure you want to delete this call log ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "private_delete_message","Are you sure you delete the entire message thread ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "private_delete_msg","Are you sure you delete this message ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "private_download_privatespace_default","The module is being upgraded , so stay tuned ..."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "private_entrance_privacy_name","Privacy Space"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "private_entrance_private_phone","Privacy contacts"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "private_phones","Privacy Space"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "private_phones_AddNewAccount","Add a Privacy Space account"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Scan_Back_Warn_Content","Examination has not been completed , whether you want to exit Acceleration examination ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Scan_Back_Warn_Title","Exit examination ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Scan_Check_RunningApp_Name","Background application %1$d models , memory remaining %2$s"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Scan_Check_VirusDetail","In %1$s threat detected%2$s"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Scan_Check_VirusDetail_Warning","In %1$s risk detected%2$s"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Scan_Result_Excellent","Mobile has been optimized to perfection!"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Scan_Result_Good","Almost done, please continue to optimize!"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Scan_Result_Poor","Phone there are more risks , please Optimize Now !"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Shortcut_FirstUse_Hint","Please choose your favorite way to start the LBE Desktop shortcut :"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr","Software Manager"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_App2SD_MIUIV5","Please note: Your phone system MIUI V5, in the part of the development version , restart the phone after moving the software , the software will disappear , be careful to use this feature.Or cancel use ."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_App2SD_ToSD_Warning","\"%1$s\" software itself does not recommend that you move to the SD card to run , forced to move may cause the software to run an unknown error ."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_AppUninstall_SDCleanPrompt","Whether uninstall %1$d one is selected the software ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_AppUninstall_SysWarning","Built-in software to streamline the system may result in serious consequences. Please click on the unlock button to continue ."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_NewApp","Software is not configured"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_NewApp_Configuration","%1$d shall wait for configuration software"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_Ram_Warning","Memory usage is too high , oh !"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_SDHelper","Package management"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_SDHelper_ApkInfo","%1$s Installation package name :%2$s Storage path : %3$s Last Modified: %4$s"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_SDHelper_InstallWait","The following packages you want to install because of signature or version issue , the need to replace the installation will cause the old data is lost. Click OK to start replacing the installation, or click Cancel to exit"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_SDHelper_NoApk","Your SD card is no APK package file."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_SDHelper_NoFile","Removed %1$d an invalid APK packages."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_SDHelper_SkipDifSig","%1$d signatures different installation to be skipped , please uninstall before installing ."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_SDHelper_Type","Package Category"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_SysUninstall","System software uninstall"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_SysUninstall_Enabled_Empty","There are no friends to streamline the system software"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_SysUninstall_FreezeClean","LBE security master is to help you freeze %1$s, reducing the burden on the system ."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_SysUninstall_Guide","This feature is only for advanced users !Security master can help you clean up the system junk software that comes with But accidentally deleted critical software may cause the system crash Use caution !"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_SysUninstall_HIPS_Required","Active defense service is not turned on , you can not streamline the system"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_SysUninstall_NoSD","Streamline the system need to backup to SD card , please try again later installed SD"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_SysUninstall_NoSpace","System space , free system space or choose other smaller packages recovery."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_SysUninstall_RootClean2","LBE security master has helped you to uninstall %1$s, reducing the burden on the system ."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_SysUninstall_RWarning","Please note: Your recovery software, files containing the optimized speed (odex), if from other systems or equipment be streamlined , it may not be used."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_SysUninstall_Summary","Total %1$d models software has streamlined %2$d models software"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_SysUninstall_UninsFail","Failed to streamline"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_SysUninstall_Uninstalling","Being streamlined :%1$s"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_SysUninstall_UWarning","Please note: You streamlined software, files containing the optimized acceleration (odex), through the recovery mode to restore to other systems or devices may not be used ."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SoftMgr_SysUninstall_Warning","You sure you want to streamline the software? If the streamlined system to operate normally, manual recovery"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SysOpt_Boost","Manager auto start"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SysOpt_Boost_AppWidget","You are using %1$s desktop plug-ins. To avoid Desktop exception from start housekeeper does not intercept the desktop plug-in applications .Please remove %1$s desktop plug and try again"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SysOpt_Boost_Service","System is using %1$s to provide critical services ( input method ) . To avoid mobile paralyzed from start housekeeper does not intercept these applications ."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SysOpt_Cache_File_Cleaned_Toast","Congratulations, you've finished cleaning up junk files , the total clean up junk files %1$s, you can shoot more than %2$d HD photos . Please keep your rubbish ."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SysOpt_Cache_None","Congratulations ! Your mobile phone is very clean, no cache file remains ."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SysOpt_Cache_SD_Cleaned_Toast","Congratulations, you've cleaned up the remaining documents, the total clean up residual files %1$s, you can shoot more than %2$d HD photos . Please keep cleaning residues ."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SysOpt_Cache_SD_More_Package","%1$s , etc."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SysOpt_Cache_Sys_Cleaned_Toast","Congratulations, you've cleaned up the software cache, the total clearing cache file %1$s, you can shoot more than %2$d HD photos"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SysOpt_EmptyFolder","%1$d an empty directory"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SysOpt_LogFile","%1$d a debug file"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SysOpt_Residual_None","Congratulations ! Your mobile phone is very clean, no residual files after uninstalling the software ."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SysOpt_Rubbish_None","Congratulations ! Your mobile phone is very clean, no useless junk files remain ."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SysOpt_Selected_SizeHuge","Directory of your choice larger files , clean up may also need to remove some of the data , make sure that you selected ."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SysOpt_TaskMgr_AddToWhite","Edit whitelist"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SysOpt_TaskMgr_AddWhite","White List"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "SysOpt_Uninstall_Left","LBE security master detects the following software has been uninstalled , but still remained on the SD card , temporary files , whether to clear ?"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Traffic_Graph_Legend_Month","Used this month"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Traffic_Monitor_Alarm","You have to use more than 90% this month flow of packages , in order to avoid traffic overruns, we recommend that you use caution !"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Traffic_Monitor_Dataplan_Amount","Total:"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Traffic_Monitor_Overproof_Alarm","You have to use more than 100 percent this month, traffic packages have traffic overruns, we recommend that you immediately off the net !"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Traffic_Monitor_Today_Hint","Traffic Today:"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Traffic_Monitor_Usage_Hint","This month:"); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "Update_Check","Checking for updates ..."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "wifi_recommended_body","Starting this %s download now may shorten your battery life and / or result in excessive usage of your mobile data connection, which can lead to charges by your mobile operator depending on your data plan.Â Click%s below to begin this download the next time you are connected to a WiFi network."); } catch(RuntimeException e) { };
//      try { resparam.res.setReplacement("com.lbe.security", "string", "wifi_required_body" , "You must use WiFi to complete this %s download.Click%s to begin this download the next time you are connected to a WiFi network."); } catch(RuntimeException e) { };
        }

}