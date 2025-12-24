package com.cast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility
{
	public int getRandomNum()
	{
		Random random=new Random();
		int r=random.nextInt(5000);
		return r;
	}
	
	public String getSystemDateYYYYMMDD()
	{
		Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");//Take MM always in Caps
		String actualdate=sim.format(date);
		return actualdate;
	}
	public String getRequireddateYYYYMMDD(int days)
	{
		Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
		sim.format(date);
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqDate=sim.format(cal.getTime());
		return reqDate;
	}
	
	
}
