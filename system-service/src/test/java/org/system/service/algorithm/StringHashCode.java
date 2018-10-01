package org.system.service.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * https://segmentfault.com/a/1190000010799123
 * @author Administrator
 *
 */
public class StringHashCode
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println("gdejicbegh".hashCode());
		System.out.println("hgebcijedg".hashCode());
		
		String a="abc";
        String b="abc";
        System.out.println(a.equals(b));
        System.out.println(a==b);
        
        String c=new String("abc");
        System.out.println(a.equals(c));
        System.out.println(a==c);
        
        String d=new String("abc");
        System.out.println(c.equals(d));
        System.out.println(c==d);
        
        System.out.println((26*26)>>28);
	}

	public static Integer hashCode(String str, Integer multiplier)
	{
		int hash = 0;
		for (int i = 0; i < str.length(); i++)
		{
			hash = multiplier * hash + str.charAt(i);
		}

		return hash;
	}

	/**
	 * 计算 hash code 冲突率，顺便分析一下 hash code 最大值和最小值，并输出
	 * 
	 * @param multiplier
	 * @param hashs
	 */
	public static void calculateConflictRate(Integer multiplier, List<Integer> hashs)
	{
		Comparator<Integer> cp = (x, y) -> x > y ? 1 : (x < y ? -1 : 0);
		int maxHash = hashs.stream().max(cp).get();
		int minHash = hashs.stream().min(cp).get();

		// 计算冲突数及冲突率
		int uniqueHashNum = (int) hashs.stream().distinct().count();
		int conflictNum = hashs.size() - uniqueHashNum;
		double conflictRate = (conflictNum * 1.0) / hashs.size();

		System.out.println(
				String.format("multiplier=%4d, minHash=%11d, maxHash=%10d, conflictNum=%6d, conflictRate=%.4f%%",
						multiplier, minHash, maxHash, conflictNum, conflictRate * 100));
	}
	
	 /**
	 * 将整个哈希空间等分成64份，统计每个空间内的哈希值数量
	 * @param hashs
	 */
	public static Map<Integer, Integer> partition(List<Integer> hashs) {
	    // step = 2^32 / 64 = 2^26
	    final int step = 67108864;
	    List<Integer> nums = new ArrayList<>();
	    Map<Integer, Integer> statistics = new LinkedHashMap<>();
	    int start = 0;
	    for (long i = Integer.MIN_VALUE; i <= Integer.MAX_VALUE; i += step) {
	        final long min = i;
	        final long max = min + step;
	        int num = (int) hashs.parallelStream()
	                .filter(x -> x >= min && x < max).count();

	        statistics.put(start++, num);
	        nums.add(num);
	    }

	    // 为了防止计算出错，这里验证一下
	    int hashNum = nums.stream().reduce((x, y) -> x + y).get();
	    assert hashNum == hashs.size();

	    return statistics;
	}
}
