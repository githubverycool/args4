package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateUtil {
	public static void main(String[] args) throws ParseException {
		// Date date = new Date();
		// String pattern = "yyyy/MM/ ";
		// String format = format(pattern, date);
		// System.out.println(format);
		// System.out.println(getCurrentDateTime());
		System.out.println(format(DEFAUL_PATTERN,
				add(System.currentTimeMillis(), Calendar.YEAR, 1)));
	}

	public static final String DEFAUL_PATTERN = "yyyy-MM-dd hh:mm:ss";

	public static String getCurrentDateTime() {
		return format(DEFAUL_PATTERN, new Date());
	}

	public static String getCurrentDateTime(String pattern) {
		return format(pattern, new Date());
	}

	public static Long getCurrentTimeMillis() {
		return System.currentTimeMillis();
	}

	public static String format(String pattern, Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	public static Date parse(String pattern, String source) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(source);
		} catch (ParseException e) {
			throw new RuntimeException("时间解析异常", e);
		}
	}

	public static Date parse(String source) {
		SimpleDateFormat sdf = new SimpleDateFormat(DEFAUL_PATTERN);
		try {
			return sdf.parse(source);
		} catch (ParseException e) {
			throw new RuntimeException("时间解析异常", e);
		}
	}

	public static Long parseToTime(String source) {
		return parse(source).getTime();
	}

	/**
	 * 转换成long类型的时间值
	 * @param pattern 时间的描述格式
	 * @param source 字符串类型的时间
	 * @return
	 */
	public static Long parseToTime(String pattern, String source) {
		return parse(pattern, source).getTime();
	}

	/**
	 * 将一种时间格式转换成另一种时间格式
	 * @param source 当前时间的字符串形式
	 * @param sourcePattern 当前时间的字符串格式
	 * @param targetPattern 期望转换的字符串时间格式
	 * @return
	 */
	public static String convertPattern(String source, String sourcePattern,
			String targetPattern) {
		Date date = parse(sourcePattern, source);
		return format(targetPattern, date);
	}

	/**
	 * 根据字段获取当前时间的值
	 * @param millis 日期的long类型时间值
	 * @param calendarField 获取的日期字段
	 * @return 返回获取日期字段的值
	 */
	public static int getCurrent(int calendarField) {
		return get(System.currentTimeMillis(), calendarField);
	}

	/**
	 * 根据字段获取值
	 * @param millis 日期的long类型时间值
	 * @param calendarField 获取的日期字段
	 * @return 返回获取日期字段的值
	 */
	public static int get(long millis, int calendarField) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(millis);
		return c.get(calendarField);
	}

	/**
	 * 对日期进行加减
	 * @param millis 日期的long类型时间值
	 * @param calendarField 进行加减的日期字段
	 * @param value 加减的值,若减使用负数
	 * @return 进行加减后的日期(Date)类型
	 */
	public static Date add(long millis, int calendarField, int value) {
		Calendar c = Calendar.getInstance(Locale.CHINA);
		c.setTimeInMillis(millis);
		c.add(calendarField, value);
		return c.getTime();
	}

}
