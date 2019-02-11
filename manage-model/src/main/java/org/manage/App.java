package org.manage;

import java.util.Random;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
   
        System.out.println(getRandomInt(1));
    }
    /**随机数字*/
	public static final char[] charArrInt = "0123456789".toCharArray();

	/**
	 * 生成给定长度的随机数字
	 */
	public static String getRandomInt(int length){
		Random random = new Random();
		char[] newCharArr = new char[length];
		for (int i = 0; i < newCharArr.length; i++) {
			newCharArr[i] = charArrInt[random.nextInt(charArrInt.length)];
		}
		return new String(newCharArr);
	}
}
