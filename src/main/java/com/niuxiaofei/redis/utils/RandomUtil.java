package com.niuxiaofei.redis.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 
 * @ClassName: RandomUtil 
 * @Description: 随机数工具类
 * @author:nxf 
 * @date: 2019年7月11日 上午11:23:15
 */
public class RandomUtil {
	/**
	 * 
	 * @Title: random 
	 * @Description:方法1：返回min-max之间的随机整数（包含min和max值），
	 * 例如返回1-3之间的随机数，那么返回1或2或3都是正确的，返回4就不对。 (5分)
	 * @param min
	 * @param max
	 * @return
	 * @return: int
	 */
	public static int random(int min, int max){
		Random r = new Random();
		int i = r.nextInt(max - min +1) + min;
		return i;
	}
	
	/**
	 * 
	 * @Title: subRandom 
	 * @Description:方法2：在最小值min与最大值max之间截取subs个不重复的随机数。
	 * 例如在1-10之间取3个不重复的随机数，那么[2,6,9]是对的，[3,5,5]则不对，因为5重复了。
	 * 应用场景：在100篇文章中随机取10篇文章，月考可能会使用到。 (8分)
	 * @param min
	 * @param max
	 * @param subs
	 * @return
	 * @return: int[]
	 */
	public static int[] subRandom (int min, int max, int subs){
		int[] array = new int[subs];
		Set<Integer> set = new HashSet<Integer>();
		while(set.size()!=subs) {
			set.add(random(min, max));
		}
		int j =0;
		for (Integer integer : set) {
			array[j]=integer;
			j++;
		}
		return array;
	}
	/**
	 * 
	 * @Title: randomCharacter 
	 * @Description:方法3：返回1个1-9,a-Z之间的随机字符。 (8分)
	 * @return
	 * @return: char
	 */
	
	public static char randomCharacter (){
		String str = "123456789";
		/*qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
*/		int i = RandomUtil.random(1,str.length()-1);
		return str.charAt(i);
	}

	/**
	 * 
	 * @Title: randomString 
	 * @Description:方法4：返回参数length个字符串(5分)，方法内部要调用randomCharacter()方法 (4分)
	 * @param length
	 * @return
	 * @return: String
	 */
	public static String randomString(int length){
		String str = "";
		for (int i = 0; i < length; i++) {
			char c = randomCharacter();
			str += c;
		}
		return str;
	}
	
	/**
	 * 随机男女
	 * @return
	 */
	public static String randomSex(){
		String str = "男女";
		String sex = "";
		int i = RandomUtil.random(1,str.length()-1);
		return sex+str.charAt(i);
	}
	
	/**
	 * 随机字母
	 * @return
	 */
	public static char randomEmail(){
		String str = "qwertyuiopasdfghjklzxcvbnm";
		int i = RandomUtil.random(1,str.length()-1);
		return str.charAt(i);
	}

	/**
	 * 
	 * @param 随机字母长度
	 * @return
	 */
	public static String randomEmail(int length){
		String str = "";
		for (int i = 0; i < length; i++) {
			char c = randomEmail();
			str += c;
		}
		return str;
	}
	
	/**
	 * 数组定义com后缀 随机生成com后缀
	 * @return
	 */
	public static String randomCom(){
		String [] str = {"@qq.com","@163.com","@sian.com","@gmail.com","@sohu.com","@hotmail.com"};
		int i = RandomUtil.random(1,str.length-1);
		return str[i];
	}
}
