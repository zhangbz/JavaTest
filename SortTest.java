//package com.sort; 添加了package之后，直接java SortTest会报错java.lang.NoClassDefFoundError

public class SortTest {
	public static void main(String[] args) {
		int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};

		print("排序之前：", a);//通过引用操作对象本身

		//insertSort(a);
		//shellSort(a);
		//selectSort(a);
		//heapSort(a);
		//bobbleSort(a);
		quickSort(a, 0, a.length-1);
		print("排序之后：", a);
	}
	//1.插入排序，使用与少量数据的排序，时间复杂度O(n2)， 是稳定的排序算法，原地排序。
	private static void  insertSort(int[] array) { //main方法是静态的，只能调用static方法，所以这些方法也得是静态的
		for (int i = 1; i < array.length; i++) {
			//待插入元素
			int temp = array[i];
			int j = 0;//j在for循环外也会用到，所以要定义在外面
			for (j = i - 1; j >= 0; j--) {
				//将大于temp的元素往后移动一位
				if (array[j] > temp) {
					array[j + 1] = array[j];
				} else {
					break;
				}
			}
			array[j + 1] = temp;
		}
	}
	//2.希尔排序，平均时间复杂度为O(nlogn)，是不稳定的排序。
	private static void shellSort(int[] array) {
		int d = array.length;

		while(true) {
			d = d / 2;
			for (int x = 0; x < d; x++)
			{
				for (int i = x + d; i < array.length; i += d)
				{
					int temp = array[i];
					int j;
					for (j = i - d; j >= 0; j -= d)
					{
						if (array[j] > temp)
						{
							array[j + d] = array[j];
						} else {
							break;
						}
					}
					array[j + d] = temp;
				}
			}
			if (d == 1)
			{
				break;
			}

		}
	}
	//3.简单选择排序，O(n2)，不稳定。
	private static void selectSort(int[] array) {
		for (int i = 0; i < array.length; i++)
		{
			//int min = array[i];
			int n = i;

			for (int j = i + 1; j < array.length; j++)
			{
				if (array[j] < array[n])
				{
					//min = array[j];
					n = j;
				}
			}
			//array[n] = array[i];
			//array[i] = min;

			swap(array, i, n);
		}
	}
	//4.堆排序，不稳定，O(nlogn)是一种树形选择排序，是对直接选择排序的有效改进。堆排序通过树形结构保存部分比较结果，可减少比较次数。
	private static void heapSort(int[] array) {
		//循环建堆
		for(int i = 0; i < array.length; i++) {
			//建堆
			buildMaxHeap(array, array.length - 1 - i);
			//交换堆顶和最后一个元素
			swap(array, 0, array.length - 1 - i);
		}
	}
	//对array数组从0到lastIndex建大顶堆
	private static void buildMaxHeap(int[] array, int lastIndex) {
		//从lastIndex处节点(最后一个节点)的父节点开始
		for (int i = (lastIndex - 1) / 2; i >= 0; i--)
		{
			//k保存正在判断的节点
			int k = i;
			//如果当前k节点的子节点存在
			while(k*2+1 <= lastIndex) {
				//k节点的左子节点的索引
				int biggerIndex = 2*k+1;
				//如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
				if(biggerIndex < lastIndex) {
					//如果右节点的值较大
					if(array[biggerIndex+1]>array[biggerIndex]) {
						//biggerIndex总是记录较大子节点的索引
						biggerIndex++;
					}
				}
				//如果k节点的值小于其较大的子节点的值
				if(array[k] < array[biggerIndex]) {
					swap(array, k, biggerIndex);
					//将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}
	//5.冒泡排序，稳定，O(n2)
	private static void bobbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++)
		{
			for (int j = 0; j < array.length - 1 - i; j++)
			{
				if (array[j] > array[j + 1])
				{
					//int temp = array[j];
					//array[j] = array[j + 1];
					//array[j + 1] = temp;
					swap(array, j, j + 1);
				}
			}
		}
	}
	//6.快排，（平均）时间复杂度O(nlogn),最坏时间复杂度O(n2)，不稳定。
	//当n较大时使用快排比较好，当序列基本有序时用快排反而不好。
	private static void quickSort(int[] array, int begin, int end) {
		if (begin < end)
		{
			int key  = array[begin];
			int i = begin;
			int j = end;

			while(i < j) {
				while (i < j && array[j] > key)
				{
					j--;
				}
				if (i < j)
				{
					array[i] = array[j];
					i++;
				}

				while(i < j && array[i] < key) {
					i++;
			    }
				if (i < j)
				{
					array[j] = array[i];
					j--;
				}
			}
			array[i] = key;

			quickSort(array, begin, i-1);
			quickSort(array, i+1, end);
		}
	}
	//交换

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	//打印
	private static void print(String str, int[] array) {//函数定义时，具体实现要用形参
		System.out.println(str);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}