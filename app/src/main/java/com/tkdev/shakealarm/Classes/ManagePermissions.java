package com.tkdev.shakealarm.Classes;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.tkdev.shakealarm.Activities.Activity_AlarmsList;

import java.lang.reflect.Array;
import java.util.List;

public class ManagePermissions {

    private Activity activity;
    private String[] list;
    private int code;

    public ManagePermissions(Activity_AlarmsList activity_alarmsList, String[] list, int permissionsRequestCode) {
        this.activity = activity_alarmsList;
        this.list = list;
        this.code = permissionsRequestCode;
    }

    // Check permissions at runtime
    public void checkPermissions() {
        if (isPermissionsGranted() != PackageManager.PERMISSION_GRANTED) {
            showAlert();
        } else {
            Toast.makeText(activity, "Permissions already granted.", Toast.LENGTH_SHORT).show();
        }
    }


    // Check permissions status
    private int isPermissionsGranted() {
        // PERMISSION_GRANTED : Constant Value: 0
        // PERMISSION_DENIED : Constant Value: -1
        int counter = 0;
        for (String permission : list) {
            counter += ContextCompat.checkSelfPermission(activity, permission);
        }
        return counter;
    }


    // Find the first denied permission
    private String deniedPermission() {
        for (String permission : list) {
            if (ContextCompat.checkSelfPermission(activity, permission)
                    == PackageManager.PERMISSION_DENIED
            ) return permission;
        }
        return "";
    }


    // Show alert dialog to request permissions
    private void showAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Need permission(s)");
        builder.setMessage("Some permissions are required to do the task.");
        builder.setNeutralButton("Cancel", null);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                requestPermissions();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    // Request the permissions at run time
    private void requestPermissions() {
        String permission = deniedPermission();
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
            // Show an explanation asynchronously
            Toast.makeText(activity, "Should show an explanation.", Toast.LENGTH_SHORT).show();
        } else {
            ActivityCompat.requestPermissions(activity, list, code);
        }
    }


    // Process permissions result
    public Boolean processPermissionsResult (int requestCode, String[] permissions, int[] grantResults) {
        int result = 0;
        if (grantResults != null) {
            for (int item : grantResults) {
                result += item;
            }
        }
        if (result == PackageManager.PERMISSION_GRANTED)
            return true;
        return false;
    }
}