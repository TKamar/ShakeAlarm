
package com.tkdev.shakealarm.Classes;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import com.tkdev.shakealarm.Services.Service_RingAlarm;
import com.tkdev.shakealarm.Services.Service_SnoozeAlarm;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public final class ConstantsAndStatics {
	
	public static final String BUNDLE_KEY_ALARM_DETAILS = "com.tkdev.shakealarm.ALARM_DETAILS_BUNDLE";
	public static final String BUNDLE_KEY_ALARM_HOUR = "com.tkdev.shakealarm.ALARM_HOUR";
	public static final String BUNDLE_KEY_DATE_TIME = "com.tkdev.shakealarm.ALARM_DATE_TIME";
	public static final String BUNDLE_KEY_ALARM_MINUTE = "com.tkdev.shakealarm.ALARM_MINUTES";
	public static final String BUNDLE_KEY_ALARM_TYPE = "com.tkdev.shakealarm.ALARM_TYPE";
	public static final String BUNDLE_KEY_ALARM_VOLUME = "com.tkdev.shakealarm.ALARM_VOLUME";
	public static final String BUNDLE_KEY_SNOOZE_TIME_IN_MINS = "com.tkdev.shakealarm.SNOOZE_TIME_IN_MINS";
	public static final String BUNDLE_KEY_SNOOZE_FREQUENCY = "com.tkdev.shakealarm.SNOOZE_FREQUENCY";
	public static final String BUNDLE_KEY_IS_REPEAT_ON = "com.tkdev.shakealarm.IS_REPEAT_ON";
	public static final String BUNDLE_KEY_IS_SNOOZE_ON = "com.tkdev.shakealarm.IS_SNOOZE_ON";
	public static final String BUNDLE_KEY_IS_ALARM_ON = "com.tkdev.shakealarm.IS_ALARM_ON";
	public static final String BUNDLE_KEY_REPEAT_DAYS = "com.tkdev.shakealarm.REPEAT_DAYS";
	public static final int ALARM_TYPE_SOUND_ONLY = 0;
	public static final int ALARM_TYPE_VIBRATE_ONLY = 1;
	public static final int ALARM_TYPE_SOUND_AND_VIBRATE = 2;
	public static final String ACTION_DELIVER_ALARM = "com.tkdev.shakealarm.DELIVER_ALARM";
	public static final String BUNDLE_KEY_ALARM_DAY = "com.tkdev.shakealarm.ALARM_DAY";
	public static final String BUNDLE_KEY_ALARM_MONTH = "com.tkdev.shakealarm.ALARM_MONTH";
	public static final String BUNDLE_KEY_ALARM_YEAR = "com.tkdev.shakealarm.ALARM_YEAR";
	public static final String BUNDLE_KEY_ALARM_MESSAGE = "com.tkdev.shakealarm.ALARM_MESSAGE";
	public static final String BUNDLE_KEY_ALARM_TONE_URI = "com.tkdev.shakealarm.ALARM_TONE_URI";
	public static final String BUNDLE_KEY_HAS_USER_CHOSEN_DATE = "com.tkdev.shakealarm.HAS_USER_CHOSEN_DATE";
	public static final String ACTION_SNOOZE_ALARM = "com.tkdev.shakealarm.SNOOZE_ALARM";
	public static final String ACTION_CANCEL_ALARM = "com.tkdev.shakealarm.CANCEL_ALARM";
	public static final String SHARED_PREF_FILE_NAME = "com.tkdev.shakealarm.SHARED_PREF_FILE";
	public static final String ACTION_NEW_ALARM = "com.tkdev.shakealarm.ACTION_NEW_ALARM";
	public static final String ACTION_EXISTING_ALARM = "com.tkdev.shakealarm.ACTION_EXISTING_ALARM";
	public static final String ACTION_NEW_ALARM_FROM_INTENT = "com.tkdev.shakealarm.ACTION_NEW_ALARM_FROM_INTENT";
	public static final String EXTRA_PLAY_RINGTONE = "com.tkdev.shakealarm.EXTRA_PLAY_RINGTONE";
	public static final String BUNDLE_KEY_OLD_ALARM_HOUR = "com.tkdev.shakealarm.OLD_ALARM_HOUR";
	public static final String BUNDLE_KEY_OLD_ALARM_MINUTE = "com.tkdev.shakealarm.OLD_ALARM_MINUTE";
	public static final String BUNDLE_KEY_ALARM_ID = "com.tkdev.shakealarm.OLD_ALARM_ID";
	public static final String ACTION_DESTROY_RING_ALARM_ACTIVITY = "com.tkdev.shakealarm.DESTROY_RING_ALARM_ACTIVITY";
	public static final String SHARED_PREF_KEY_PERMISSION_WAS_ASKED_BEFORE = "com.tkdev.shakealarm.PERMISSION_WAS_ASKED_BEFORE";
	public static final String SHARED_PREF_KEY_DEFAULT_SHAKE_OPERATION = "com.tkdev.shakealarm.DEFAULT_SHAKE_OPERATION";
	public static final String SHARED_PREF_KEY_DEFAULT_POWER_BTN_OPERATION = "com.tkdev.shakealarm.DEFAULT_POWER_BTN_OPERATION";
	public static final String SHARED_PREF_KEY_SHAKE_SENSITIVITY = "com.tkdev.shakealarm.SHAKE_SENSITIVITY";
	public static final String SHARED_PREF_KEY_SHOW_BATTERY_OPTIM_DIALOG = "com.tkdev.shakealarm.SHOW_BATTERY_OPTIM_DIALOG";
	public static final float DEFAULT_SHAKE_SENSITIVITY = 3.2f;
	public static final int SNOOZE = 0;
	public static final int DISMISS = 1;
	public static final int DO_NOTHING = 2;
	public static final String SHARED_PREF_KEY_DEFAULT_SNOOZE_IS_ON = "com.tkdev.shakealarm.DEFAULT_SNOOZE_STATE";
	public static final String SHARED_PREF_KEY_DEFAULT_SNOOZE_INTERVAL = "com.tkdev.shakealarm.DEFAULT_SNOOZE_INTERVAL";
	public static final String SHARED_PREF_KEY_DEFAULT_SNOOZE_FREQ = "com.tkdev.shakealarm.DEFAULT_SNOOZE_FREQUENCY";
	public static final String SHARED_PREF_KEY_DEFAULT_ALARM_TONE_URI = "com.tkdev.shakealarm.DEFAULT_ALARM_TONE_URI";
	public static final String SHARED_PREF_KEY_DEFAULT_ALARM_VOLUME = "com.tkdev.shakealarm.DEFAULT_ALARM_VOLUME";
	public static final int THEME_AUTO_TIME = 0;
	public static final int THEME_LIGHT = 1;
	public static final int THEME_DARK = 2;
	public static final int THEME_SYSTEM = 3;
	public static final String SHARED_PREF_KEY_THEME = "com.tkdev.shakealarm.THEME";
	public static final String SHARED_PREF_KEY_AUTO_SET_TONE = "com.tkdev.shakealarm.AUTO_SET_TONE";
	public static final String WORK_TAG_ACTIVATE_ALARMS = "in.basulabs.WORK_ACTIVATE_ALARMS";


	public static void schedulePeriodicWork(Context context) {

		try {
			WorkManager.initialize(context, new Configuration.Builder().setMinimumLoggingLevel(Log.DEBUG).build());
		} catch (Exception ignored) {
		}

		Constraints constraint = new Constraints.Builder()
				.setRequiresBatteryNotLow(true)
				.build();

		PeriodicWorkRequest periodicWorkRequest = new PeriodicWorkRequest.Builder(Worker_ActivateAlarms.class, 1, TimeUnit.HOURS)
				.setInitialDelay(30, TimeUnit.MINUTES)
				.setConstraints(constraint)
				.build();

		WorkManager.getInstance(context)
		           .enqueueUniquePeriodicWork(WORK_TAG_ACTIVATE_ALARMS, ExistingPeriodicWorkPolicy.REPLACE, periodicWorkRequest);
	}


	public static void cancelScheduledPeriodicWork(Context context) {

		try {
			WorkManager.initialize(context, new Configuration.Builder().setMinimumLoggingLevel(Log.DEBUG).build());
		} catch (Exception ignored) {
		}

		WorkManager.getInstance(context).cancelUniqueWork(WORK_TAG_ACTIVATE_ALARMS);
	}

	public static int getTheme(int theme) {
		switch (theme) {
			case THEME_SYSTEM:
				return AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;
			case THEME_LIGHT:
				return AppCompatDelegate.MODE_NIGHT_NO;
			case THEME_DARK:
				return AppCompatDelegate.MODE_NIGHT_YES;
			default:
				if (LocalTime.now().isAfter(LocalTime.of(21, 59)) || LocalTime.now().isBefore(LocalTime.of(6, 0))) {
					return AppCompatDelegate.MODE_NIGHT_YES;
				} else {
					return AppCompatDelegate.MODE_NIGHT_NO;
				}
		}
	}


	public static void killServices(Context context, int alarmID) {

		if (Service_RingAlarm.isThisServiceRunning && Service_RingAlarm.alarmID == alarmID) {
			Intent intent1 = new Intent(context, Service_RingAlarm.class);
			context.stopService(intent1);
		} else if (Service_SnoozeAlarm.isThisServiceRunning && Service_SnoozeAlarm.alarmID == alarmID) {
			Intent intent1 = new Intent(context, Service_SnoozeAlarm.class);
			context.stopService(intent1);
		}
	}

	public static LocalDateTime getAlarmDateTime(LocalDate alarmDate, LocalTime alarmTime, boolean isRepeatOn, @Nullable ArrayList<Integer> repeatDays) {

		LocalDateTime alarmDateTime;

		if (isRepeatOn && repeatDays != null && repeatDays.size() > 0) {

			Collections.sort(repeatDays);

			alarmDateTime = LocalDateTime.of(LocalDate.now(), alarmTime);
			int dayOfWeek = alarmDateTime.getDayOfWeek().getValue();

			for (int i = 0; i < repeatDays.size(); i++) {
				if (repeatDays.get(i) == dayOfWeek) {
					if (alarmTime.isAfter(LocalTime.now())) {
						break;
					}
				} else if (repeatDays.get(i) > dayOfWeek) {
					alarmDateTime = alarmDateTime.with(TemporalAdjusters.next(DayOfWeek.of(repeatDays.get(i))));
					break;
				}
				if (i == repeatDays.size() - 1) {
					alarmDateTime = alarmDateTime.with(TemporalAdjusters.next(DayOfWeek.of(repeatDays.get(0))));
				}
			}

		} else {

			alarmDateTime = LocalDateTime.of(alarmDate, alarmTime);

			if (!alarmDateTime.isAfter(LocalDateTime.now())) {
				alarmDateTime = alarmDateTime.plusDays(1);
			}
		}

		return alarmDateTime.withSecond(0).withNano(0);
	}

	public static final int NOTIF_CHANNEL_ID_ALARM = 621;
	public static final int NOTIF_CHANNEL_ID_SNOOZE = 622;
	public static final int NOTIF_CHANNEL_ID_ERROR = 623;
	public static final int NOTIF_CHANNEL_ID_UPDATE = 625;
	public static final String SHARED_PREF_KEY_NOTIF_CHANNELS_DELETED = "com.tkdev.shakealarm.NotifChannelsDeleted";
	
}
