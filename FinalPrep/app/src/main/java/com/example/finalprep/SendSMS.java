package com.example.finalprep;

//import android.Manifest;
//import android.content.pm.PackageManager;
//import android.os.Build;
import android.telephony.SmsManager;
//import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.app.ActivityCompat;

//import static androidx.core.app.ActivityCompat.requestPermissions;

public class SendSMS extends AppCompatActivity {

    void sendSmsMsgFnc(String mblNumVar, String smsMsgVar)
    { SmsManager smsMgrVar = SmsManager.getDefault();
        smsMgrVar.sendTextMessage(mblNumVar, null, smsMsgVar, null, null);
    }


}
