package org.system.service.algorithm;

/**
 * 快速排序
 * @author Administrator
 *
 */
public class Snippet
{
	public static void main(String[] args)
	{
		int [] arr = { 8, 1, 2, 3, 10, 4, 5, 9 };
		qsort(arr, 0, arr.length - 1);
		
		for (Integer integer : arr)
		{
			System.out.print(integer+" ");
		}
	}

	private static void qsort(int [] arr, int low, int high)
	{
		if (low < high)
		{
			int pivot = partition(arr, low, high); // 将数组分为两部分
			qsort(arr, low, pivot - 1); // 递归排序左子数组
			qsort(arr, pivot + 1, high); // 递归排序右子数组
		}
	}
	

	private static int partition(int [] arr, int low, int hight)
	{
		int pivotVal = arr[low];//枢轴记录
		while (low < hight)
		{
			while (low < hight && arr[hight] >= pivotVal)
				--hight;
			arr[low] = arr[hight]; //交换比枢轴小的记录到左端
			
			while (low < hight && arr[low] <= pivotVal)
				++low;
			arr[hight] = arr[low];//交换比枢轴小的记录到右端
		}
		
		arr[low] = pivotVal;// 扫描完成，枢轴到位
		
		return low;// 返回的是枢轴的位置
	}
}
