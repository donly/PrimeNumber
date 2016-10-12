/**
 * Homework of week 3
 * 
 * 题目：
 * 用“埃氏筛法”求 2～10000 以内的素数。2～10000 以内的数，先去掉 2 的倍数，再去掉 3 的倍数，再去掉 4 的倍数，……依此类推，最后剩下的就是素数。
 * 要求使用数组，使用数组的长度，使用增强的 for 语句
 */
package com.chendonglin.week3;

/**
 * 用“埃氏筛法”求 2～10000 以内的素数
 * 
 * @author Chen Donglin
 * @version 1.0
 */
public class PrimeNumber {

	/**
	 * 程序执行入口
	 * @param args 启动参数数组
	 */
	public static void main(String[] args) {
		// 10000 以内的素数
		int maxNumber = 10000;
		
		// 使用数组
		boolean isPrime[] = new boolean[maxNumber];
		isPrime[0] = isPrime[1] = false;
		
		// 使用数组的长度
		for (int i=2; i<isPrime.length; i++) {
			isPrime[i] = true;
		}
		
		int max = (int) Math.ceil(Math.sqrt(maxNumber));   
		for (int i=2; i < max; i++) {
			if (isPrime[i]) {
				for (int j=i*i; j<maxNumber; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		
		// 使用增强的 for 语句
		int num = 0;
		int lineCounter = 1;
		for (boolean p : isPrime) {
			if (p) {
				System.out.printf("%4d ", num);
				lineCounter++;
			}
			
			if (lineCounter % 10 == 0) {
				System.out.println();
				lineCounter = 1;
			}
			
			num++;
		}
	}

}
