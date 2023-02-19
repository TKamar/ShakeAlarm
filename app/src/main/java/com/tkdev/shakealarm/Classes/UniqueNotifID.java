
package com.tkdev.shakealarm.Classes;

import java.util.Date;

public class UniqueNotifID {

	public static int getID(){
		return (int)((new Date().getTime() / 1000L) % Integer.MAX_VALUE);
	}

}
