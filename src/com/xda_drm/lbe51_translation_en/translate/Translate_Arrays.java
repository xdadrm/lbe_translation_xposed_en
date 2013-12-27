package com.xda_drm.lbe51_translation_en.translate;

//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.util.logging.Handler;

//import com.xda_drm.lbe51_translation_en.R;

//import android.content.res.Resources;
import android.content.res.XModuleResources;
//import android.content.res.XResources;
import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.IXposedHookZygoteInit;
//import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_InitPackageResources.InitPackageResourcesParam;

//import de.robv.android.xposed.IXposedHookLoadPackage;
//import de.robv.android.xposed.XposedBridge;
//import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;


public class Translate_Arrays implements IXposedHookZygoteInit, IXposedHookInitPackageResources{
    private static String MODULE_PATH = null;

    
    @Override
    public void initZygote(IXposedHookZygoteInit.StartupParam startupParam) throws Throwable    {
        // XResources.setSystemWideReplacement("android", "bool", "config_unplugTurnsOnScreen", false);
        MODULE_PATH = startupParam.modulePath;
    }

    @Override
    public void handleInitPackageResources(InitPackageResourcesParam resparam) throws Throwable    {
        if (!resparam.packageName.equals("com.lbe.security"))
            return;

        ExceptionHandler handler = new ExceptionHandler();
       	Thread.setDefaultUncaughtExceptionHandler(handler);

      XModuleResources modRes = XModuleResources.createInstance(MODULE_PATH, resparam.res);


try { resparam.res.setReplacement("com.lbe.security", "array","addblacktype",new String[]{
    "Add from Contacts",
    "Add from Call History",
    "Add from the message list",
    "Manually add",
    "Added by region",
    "From the classification markings added"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","addwhitetype",new String[]{
    "Add from Contacts",
    "Add from Call History",
    "Add from the message list",
    "Manually add",
    "Added by region"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","addnouseiptype",new String[]{
    "Add from Contacts",
    "Add from Call History",
    "Add from the message list",
    "Manually add"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","select_sim",new String[]{
    "From the card 1",
    "From the card 2"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","stopmsgtype_options",new String[]{
    "Smart block mode",
    "block only blacklist",
    "Receive only whitelist",
    "Block all",
    "Accept all",
    "Only accept contacts",
    "Custom mode"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","endcalltype",new String[]{
    "Shutdown",
    "Empty number",
    "Shutdown",
    "Hang up"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","stopcalltype_values",new String[]{
    "0",
    "1",
    "2",
    "3",
    "4"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","trafficBillingDay",new String[]{
    "1st",
    "2nd",
    "3rd",
    "4th",
    "5th",
    "6th",
    "7th",
    "8th",
    "9th",
    "10th",
    "11th",
    "12th",
    "13th",
    "14th",
    "15th",
    "16th",
    "17th",
    "18th",
    "19th",
    "20th",
    "21st",
    "22nd",
    "23rd",
    "24th",
    "25th",
    "26th",
    "27th",
    "28th",
    "29th",
    "30th",
    "31st"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","trafficBillingDay_values",new String[]{
    "1",
    "2",
    "3",
    "4",
    "5",
    "6",
    "7",
    "8",
    "9",
    "10",
    "11",
    "12",
    "13",
    "14",
    "15",
    "16",
    "17",
    "18",
    "19",
    "20",
    "21",
    "22",
    "23",
    "24",
    "25",
    "26",
    "27",
    "28",
    "29",
    "30",
    "31"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","msglog_oparete",new String[]{
    "Delete",
    "Reply SMS",
    "Call this number",
    "Add to whitelist",
    "Add to blacklist"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","calllog_oparete",new String[]{
    "Delete",
    "Reply SMS",
    "Call this number",
    "Add to whitelist",
    "Add to blacklist",
    "Restored to the system call log"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","preference_stopcalltype_options",new String[]{
    "Turn off night disturb mode",
    "Block only blacklist",
    "Receive only whitelist",
    "Block all",
    "Accept all",
    "Receive only the white list and contacts"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","preference_stopcalltype_values",new String[]{
    "0",
    "1",
    "2",
    "3",
    "4",
    "5"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","user_defined",new String[]{
    "WhiteList",
    "Blacklist",
    "Contact",
    "Recently had contact numbers",
    "Keyword",
    "Intelligence block"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","user_phone_defined",new String[]{
    "WhiteList",
    "Blacklist",
    "Contact",
    "Recently had contact numbers"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","select_allow",new String[]{
    "Receive",
    "Ignore"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","select_reject",new String[]{
    "Block",
    "Ignore"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","traffic_refresh",new String[]{
    "High",
    "In",
    "Low"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","traffic_refresh_values",new String[]{
    "2000",
    "3000",
    "4000"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","traffic_autodim",new String[]{
    "10 seconds",
    "15 seconds",
    "20 seconds",
    "Always show"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","traffic_autodim_values",new String[]{
    "10000",
    "15000",
    "20000",
    "-1"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","location_bg",new String[]{
    "Gorgeous",
    "Refreshing",
    "Concise"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","location_bg_values",new String[]{
    "0",
    "1",
    "2"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","flowwindow_style",new String[]{
    "Standard",
    "Fresh"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","flowwindow_style_values",new String[]{
    "0",
    "1"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","notify_hips_event",new String[]{
    "All requests prompted",
    "Only prompts rejected requests",
    "Any request without prompting"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","notify_hips_event_values",new String[]{
    "0",
    "1",
    "2"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","record_telephony_event",new String[]{
    "Record all software",
    "Record only untrusted software"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","record_telephony_event_values",new String[]{
    "0",
    "1"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","auto_ip_callist",new String[]{
    "Dialing numbers from other provinces",
    "Call numbers outside the city",
    "When all the numbers dialed"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","auto_ip_callist_value",new String[]{
    "0",
    "2",
    "1"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","virus_antivirus_antilib",new String[]{
    "Virus | Category : Infection -type virus",
    "Worm | Category: Worm",
    "Trojan | Category: Trojans",
    "G-Ware | Category: rogue software",
    "AdWare | Category : Advertising items",
    "RiskWare | Category: rogue software",
    "Tool | Category: Tools Software",
    "prv | Privacy steal Reveal the user 's private information",
    "rmt | Remote Control Remote Server Control via Mobile",
    "pay | Malicious SP automatic subscription service , resulting in chargeback",
    "spr | spread malicious Proliferation of malicious code automatically",
    "exp | Tariff consumption Automatic frequent networking or SMS Consumption rates resulting lightweight",
    "sys | System Damage Some damage to the system Affect system stability Reduce system security",
    "fra | decoy fraud Fake SMS Block SMS",
    "rog | hooliganism Malicious occupy system resources Pop-up ads and other hooliganism",
    "sms | SMS malicious behavior in behavior",
    "spy | spyware malicious behavior in class act",
    "bkd | contains backdoor malicious acts",
    "rtt | malicious acts contain mention the right to act",
    "gen | By heuristic rules and broad-spectrum detection There may be false positives",
    "ads | contain adware",
    "default | unknown threats"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","traffic_cell_type",new String[]{
    "Sort by monthly flow",
    "Sort by today's traffic",
    "Sort by software name"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","calibration_period",new String[]{
    "Every three days",
    "Weekly",
    "Every day",
    "Manual Calibration"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","showpowerquantitylower",new String[]{
    "10%",
    "20%",
    "30%",
    "40%",
    "50%"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","auto_update_period",new String[]{
    "Close",
    "Every one day",
    "Every two days",
    "Every three days",
    "Every four days",
    "Every five days",
    "Every six days",
    "Every seven days"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","auto_update_period_values",new String[]{
    "0",
    "1",
    "2",
    "3",
    "4",
    "5",
    "6",
    "7"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","hips_batch_operation",new String[]{
    "Allow all",
    "All Tips",
    "Reject All"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","hips_batch_operation_ar",new String[]{
    "Allow all",
    "Reject All"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","defaultfilesuffix",new String[]{
    "epub",
    "chm",
    "ndk",
    "umd",
    "pdf"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","filesuffix",new String[]{
    "avi",
    "wmv",
    "flv",
    "mov",
    "3gp",
    "mp4",
    "mpg",
    "rmvb",
    "mp3",
    "wav",
    "wma",
    "mid",
    "flac",
    "lrc",
    "m4a",
    "krc",
    "apk",
    "f4v",
    "dat",
    "tsk",
    "db3"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","filesuffix_id",new String[]{
    "1",
    "2",
    "4",
    "8",
    "16",
    "32",
    "64",
    "128",
    "256",
    "512",
    "1024",
    "2048",
    "4096",
    "8192",
    "16384",
    "32768",
    "65536",
    "131072",
    "262144",
    "524288",
    "1048576"
} );} catch (RuntimeException e) { };
    try { resparam.res.setReplacement("com.lbe.security", "array","misscalltype",new String[] {
        "Ringtones and vibration",
        "Ring",
        "Vibration"
    } );}catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","misscalltype_value",new String[]{
    "0",
    "1",
    "2"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","miss_alert_time",new String[]{
    "Every 5 minutes",
    "Every 10 minutes",
    "Every 20 minutes"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","miss_alert_time_value",new String[]{
    "5",
    "10",
    "20"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","desktop_home_launch_mode",new String[]{
    "Click the Home button",
    "Double-click the Home button"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","lbe_shortcut_start_mode",new String[]{
    "Notice to enter the main",
    "Desktop shortcut"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","blocklog_save_time",new String[]{
    "One week",
    "One Month",
    "Permanent preservation"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","blocklog_save_time_values",new String[]{
    "0",
    "1",
    "2"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","phone_marker_operator",new String[]{
    "Transfer to other classifications",
    "Deleted from the classification",
    "Add to blacklist"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","private_contact_operator",new String[]{
    "Call",
    "Texting",
    "Edit",
    "Delete"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","private_call_operator",new String[]{
    "Texting",
    "Delete",
    "Restored to the phone"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","private_message_operator",new String[]{
    "Call a contact",
    "Remove this session",
    "Restored to the phone"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","private_message_dialog_operator",new String[]{
    "Delete this message",
    "Restored to the phone"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","phone_block_type",new String[]{
    "Call and SMS",
    "Call",
    "SMS"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","battery_scene_killtask_interval_values",new String[]{
    "1",
    "5",
    "10"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","anti_adware_user_feedback_type",new String[]{
    "Block ads fail",
    "The software is free of adware",
    "After the program exception block ads",
    "Can not be displayed on the Close button banner",
    "Cancel"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","desktop_float_toggles_labels",new String[]{
    "Flight mode",
    "Bluetooth",
    "Screen brightness",
    "Touch",
    "Synchronous",
    "WIFI",
    "GPS",
    "Mobile network",
    "Screen Rotation"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","homepage_more_options_labels",new String[]{
    "Antivirus",
    "Active Defense",
    "Notification bar",
    "Privacy Space",
    "Call blocking",
    "Antitheft",
    "Communication",
    "Backup restore"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","home_settings_labels",new String[]{
    "Desktop Shortcut",
    "Add shortcut to the desktop Oneclick clean-up",
    "Oneclick clean white list",
    "Password Protection",
    "System Settings"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","home_about_labels",new String[]{
    "Software Updates",
    "Feedback",
    "Software rate",
    "Share with friends",
    "Join with us"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","sdapk_sortypes",new String[]{
    "Sort by Name",
    "Sort by size",
    "Sort by time"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","sdapk_types",new String[]{
    "All Packages",
    "New Version Package",
    "Old versions of packages",
    "Installed packages",
    "Not Installed Packages",
    "Certification exception Packages",
    "Repeat the installation package"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","sdapk_status",new String[]{
    "Your SD card does not exist any packages",
    "Your SD card is not upgradable packages exist",
    "Your SD card is not old version package exists",
    "Your SD card is not already installed package exists",
    "Your SD card is not installed package does not exist",
    "Your SD card is no certification exceptions exist packages",
    "Your SD card is no duplicate packages exist"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","task_sortypes",new String[]{
    "Sort by name/type",
    "Sort by memory consumption",
    "Sort by CPU usage"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","hipsapk_sortypes",new String[]{
    "Sort by Name",
    "Sort by the number of permissions",
    "Sort by time"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","hipsapk_types",new String[]{
    "Monitored Software",
    "Inspection Software"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","scan_item_type",new String[]{
    "Automatic entry",
    "Manual entry",
    "Security"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","toggles_add_options",new String[]{
    "Quick switch",
    "Applications",
    "LBE functional items"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","questions",new String[]{
    "My best friend",
    "My favorite people",
    "My father's birthday",
    "My mother's birthday",
    "My wife's name/birthday",
    "I Primary/Secondary/University School Name",
    "My favorite novel",
    "My favorite movie",
    "My favorite anime",
    "My favorite sport",
    "My favorite star",
    "My favorite singer"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","unlock_types",new String[]{
    "Graphics Unlocking",
    "Password to unlock"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","traffic_mobile_graph_wave_colors",new String[]{
    "#605fcaff",
    "#8026acee"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","traffic_mobile_graph_warn_colors",new String[]{
    "#70fe7e71",
    "#80db2c1b"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","hardware_basic_info",new String[]{
    "A brand",
    "2 Model",
    "3 Android version",
    "4 main camera",
    "5 front camera",
    "6 IMEI",
    "7 running memory",
    "8 Internal capacity",
    "9 built-in SD card capacity",
    "A weight"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","hardware_cpu_info",new String[]{
    "1 CPU Type",
    "2 Cores",
    "3 Frequency"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","hardware_screen_info",new String[]{
    "1 GPU renderer",
    "2 GPU supplier",
    "3 GPU version",
    "4 Resolution",
    "5 Screen Size",
    "6 Material",
    "7 pixel density",
    "8 Multi-touch"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","hardware_network_info",new String[]{
    "1 network standard",
    "2 WIFI ​​support information",
    "3 GPS support information",
    "4 Bluetooth support information"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","hardware_sensor_name",new String[]{
    "Acceleration sensor",
    "Magnetic field sensor",
    "Orientation Sensor",
    "Gyro",
    "Light sensor",
    "Pressure Sensor",
    "Temperature Sensor",
    "Proximity sensor",
    "Gravity Sensor",
    "Linear Acceleration Sensor",
    "Rotation vector sensor",
    "Relative humidity sensor",
    "Temperature sensor"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","hardware_rank",new String[]{
    "Model ranking",
    "Models defeated percentage"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","hardware_antutu_keys",new String[]{
    "Main camera",
    "Front camera",
    "Screen Size",
    "Material"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","app_install_manage_mode_title",new String[]{
    "Allow automatic installation",
    "Tip automatically installed",
    "Disable the automatic installation"
} );} catch (RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array","app_install_manage_mode_desc",new String[]{
    "Allows automatic installation software, prompt notification bar after installation",
    "There dialog box prompts to install, requires you to manually confirm",
    "A complete ban on the behavior of the software is automatically installed"
} );} catch (RuntimeException e) { };

// new since 5.1.5202
try { resparam.res.setReplacement("com.lbe.security", "array", "yellow_correction_no_num",new String[]{ "Modify Contact","add or modify numbers","other problems"}); } catch(RuntimeException e) { };
try { resparam.res.setReplacement("com.lbe.security", "array", "yellow_correction_has_num",new String[]{ "business name is incorrect","corrections Merchant Other information","private number"}); } catch(RuntimeException e) { };

//new since 5.1.5310
try { resparam.res.setReplacement("com.lbe.security", "array", "misscalltype",new String[]{"Ring and Vibrate","Ring","Vibrate"}); } catch(RuntimeException e) { };
// try { resparam.res.setReplacement("com.lbe.security", "array", "special_thanks_list",new String[]{".....","..",".."}); } catch(RuntimeException e) { };



    }

}