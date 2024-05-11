package com.works.days_3.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.works.days_3.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Inflater;

public class Util {

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    public static boolean isValidPassword(String s) {
        Pattern PASSWORD_PATTERN = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_])[A-Za-z\\d\\W_]{8,24}$");
        return s.length() >= 8 && PASSWORD_PATTERN.matcher(s).matches();
    }

    public static void alert(Context context, String message) {
        Toast toast = new Toast(context);
        View view = View.inflate(context, R.layout.custom_alert, null);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        TextView txtMessage = view.findViewById(R.id.alert_message);
        txtMessage.setText(message);
        toast.setGravity(0, 0, 100);
        toast.show();
    }

}
