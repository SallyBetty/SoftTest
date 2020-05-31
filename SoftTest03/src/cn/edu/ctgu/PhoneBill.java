package cn.edu.ctgu;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class PhoneBill {

	private static Date StrToDate(String str) {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = null;
		try {
			try {
				date = format.parse(str);
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return date;
	}

	public static String getPhoneBill(String startingTime, String endingTime) {

		long callMinute;
		Date startT, endT;
		startT = StrToDate(startingTime);
		endT = StrToDate(endingTime);
		DecimalFormat decimalFormat = new DecimalFormat("######0.00");

		long between;
		Calendar call1 = Calendar.getInstance();
		call1.setTime(startT);
		Calendar call2 = Calendar.getInstance();
		call2.setTime(endT);

		between = call2.getTime().getTime() - call1.getTime().getTime();
		if (between < 0) {
			callMinute = ((call2.getTime().getTime() - call1.getTime().getTime()) / 1000);
		} else {
			callMinute = (between / 1000 + 59) / 60;
		}

		// 判断接通时间是否发生在转换的日期
		if ((call1.get(Calendar.MONTH) == Calendar.MARCH && call1.get(Calendar.DATE) >= 29
				&& call1.get(Calendar.DATE) <= 31 && call1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
				|| ((call1.get(Calendar.MONTH) == Calendar.APRIL && call1.get(Calendar.DATE) >= 1
						&& call1.get(Calendar.DATE) <= 4 && call1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY))) {
//			System.out.println("需要进行时制转换");
			if (call1.get(Calendar.HOUR_OF_DAY) < 2 && call2.get(Calendar.HOUR_OF_DAY) >= 3)
				callMinute -= 60;
		} else {// 判断结束时间是否在发生转换的日期
			if ((call2.get(Calendar.MONTH) == 3 && call2.get(Calendar.DATE) >= 29 && call2.get(Calendar.DATE) <= 31
					&& call2.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
					|| ((call2.get(Calendar.MONTH) == 4 && call2.get(Calendar.DATE) >= 1
							&& call2.get(Calendar.DATE) <= 4 && call2.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY))) {
				if (call2.get(Calendar.HOUR_OF_DAY) > 3) {
					callMinute -= 60;
				}
			}
		}

		// 将位于转换的时间段内的时间都看作已经转换之后的
		if (call1.get(Calendar.MONTH) == Calendar.OCTOBER && call1.get(Calendar.DATE) >= 25
				&& call1.get(Calendar.DATE) <= 31 && call1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			if (call1.get(Calendar.HOUR_OF_DAY) == 2) {
				callMinute += 60;
			}
		} else {
			if (call2.get(Calendar.MONTH) == Calendar.OCTOBER && call2.get(Calendar.DATE) >= 25
					&& call2.get(Calendar.DATE) <= 31 && call2.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
				if (call2.get(Calendar.HOUR_OF_DAY) == 2) {
					callMinute += 60;
				}
			}
		}

		if (callMinute > 1800 || callMinute < 0) {
			return "时间错误";
		} else if (callMinute <= 20) {
			return decimalFormat.format(0.05 * callMinute);
		} else {
			return decimalFormat.format(1.00 + (callMinute - 20) * 0.1);
		}
	}
}
