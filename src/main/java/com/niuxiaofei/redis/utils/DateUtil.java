package com.niuxiaofei.redis.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 
 * @ClassName: DateUtil
 * @Description: 日期工具类
 * @author:nxf
 * @date: 2019年7月17日 上午8:11:10
 */
public class DateUtil {
	/**
	 * 
	 * @Title: getAge
	 * @Description:根据传入的日期获取年龄
	 * @param src
	 * @return
	 * @return: int
	 */
	public static int getAge(Date src) {
		Calendar c = Calendar.getInstance();
		Date date = new Date();
		c.setTime(date);
		Date time = c.getTime();
		int nowYear = c.getWeekYear();

		c.setTime(src);
		Date time2 = c.getTime();
		int birthYear = time2.getYear();
		return nowYear - birthYear;
	}

	/**
	 * 
	 * @Title: getDateByMonthInit
	 * @Description:根据传入的参数获取该日期的月初日期，例如给定的日期为“2019-09-19 19:29:39”， 返回“2019-09-01
	 *                                                    00:00:00”
	 * @param src
	 * @return
	 * @return: Date
	 */
	public static Date getDateByMonthInit(Date src) {
		Calendar c = Calendar.getInstance();
		c.setTime(src);
		c.set(Calendar.DATE, 1);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();

	}

	/**
	 * 
	 * @Title: getDateByMonthLast
	 * @Description:根据传入的参数获取该日器的月末日期，例如给定的日期为“2019-09-19 19:29:39”， 返回“2019-09-30
	 *                                                    23:59:59”，注意月大月小以及闰年。
	 * @param src
	 * @return
	 * @return: Date
	 */
	public static Date getDateByMonthLast(Date src) {
		Calendar c = Calendar.getInstance();
		c.setTime(src);
		c.add(Calendar.MONTH, 1);
		Date time = c.getTime();
		Date date = getDateByMonthInit(time);

		c.setTime(date);
		c.add(Calendar.SECOND, -1);
		return c.getTime();
	}

	/**
	 * 
	 * @Title: getDaysByFuture
	 * @Description:求未来日期离今天还剩的天数
	 * @param future
	 * @return
	 * @return: int
	 */
	public static int getDaysByFuture(Date future) {
		long futureTime = future.getTime();
		Date date = new Date();
		long nowTime = date.getTime();
		long l = (futureTime - nowTime) / (1000 * 60 * 24 * 60);
		return (int) l;
	}

	/**
	 * 
	 * @Title: getDaysByDeparted
	 * @Description:求过去日期离今天过去的天数
	 * @param departed
	 * @return
	 * @return: int
	 */
	public static int getDaysByDeparted(Date departed) {
		long oldTime = departed.getTime();
		Date date = new Date();
		long nowTime = date.getTime();
		long l = (nowTime - oldTime) / (1000 * 60 * 24 * 60);
		return (int) l;
	}

	// 2010年1月1日至今任意随机时间

	public static Date randomDate(Date startDate) {
		// 用当前时间获取日历类
		Calendar c = Calendar.getInstance();
		// 当前时间的毫秒值.. 即从1970到现在的毫米数
		long endMillis = c.getTimeInMillis();
		// System.out.println("endMillis="+endMillis);

		// 用传入的日期初始化日历类Calendar

		c.setTime(startDate);
		// 获取开始时间的毫米数
		long startMillis = c.getTimeInMillis();
		// System.out.println("startMillis="+startMillis);

		long x = (long) (Math.random() * (endMillis - startMillis + 1)) + startMillis;
		// System.out.println("x="+x);

		// 用时间差创建日历类
		c.setTimeInMillis(x);

		return c.getTime();
	}

}
