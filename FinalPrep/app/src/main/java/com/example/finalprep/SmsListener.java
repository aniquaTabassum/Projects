package com.example.finalprep;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

//import androidx.core.app.ActivityCompat;

public class SmsListener extends BroadcastReceiver {
    private static final String SmsReceived = "android.provider.Telephony.SMS_RECEIVED";
    private String msg = "";
    private String phone = "";
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction() == SmsReceived)
        {
            Bundle bundle = intent.getExtras();
            if(bundle!=null)
            {
                Object[] mypdu = (Object[])bundle.get("pdus");
                final SmsMessage[] message = new SmsMessage[mypdu.length];
                for(int i=0;i<mypdu.length;i++)
                {
                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
                    {
                        String format = bundle.getString("format");
                        message[i] = SmsMessage.createFromPdu((byte[])mypdu[i],format);
                    }
                    else {
                        message[i] = SmsMessage.createFromPdu((byte[])mypdu[i]);
                    }

                    msg = message[i].getMessageBody();
                    phone = message[i].getOriginatingAddress();
                    Toast.makeText(context, "message : "+msg+" "+phone,Toast.LENGTH_LONG).show();
                    SendSMS sms = new SendSMS();
                    sms.sendSmsMsgFnc("008801552333983","bhai tham ebar");
                }
            }
        }
    }


}