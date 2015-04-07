//package com.sort; �����package֮��ֱ��java SortTest�ᱨ��java.lang.NoClassDefFoundError
import java.util.ArrayList;
import java.util.List;

public class SortTest {
	public static void main(String[] args) {
		int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};

		print("����֮ǰ��", a);//ͨ�����ò���������

		//insertSort(a);
		//shellSort(a);
		//selectSort(a);
		//heapSort(a);
		//bobbleSort(a);
		//quickSort(a, 0, a.length-1);
		//mergeSort(a, 0, a.length-1);
		radixSort(a);
		print("����֮��", a);
	}
	//1.���������������������ݵ�����ʱ�临�Ӷ�O(n2)�� ���ȶ��������㷨��ԭ������
	private static void  insertSort(int[] array) { //main�����Ǿ�̬�ģ�ֻ�ܵ���static������������Щ����Ҳ���Ǿ�̬��
		for (int i = 1; i < array.length; i++) {
			//������Ԫ��
			int temp = array[i];
			int j = 0;//j��forѭ����Ҳ���õ�������Ҫ����������
			for (j = i - 1; j >= 0; j--) {
				//������temp��Ԫ�������ƶ�һλ
				if (array[j] > temp) {
					array[j + 1] = array[j];
				} else {
					break;
				}
			}
			array[j + 1] = temp;
		}
	}
	//2.ϣ������ƽ��ʱ�临�Ӷ�ΪO(nlogn)���ǲ��ȶ�������
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
	//3.��ѡ������O(n2)�����ȶ���
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
	//4.�����򣬲��ȶ���O(nlogn)��һ������ѡ�������Ƕ�ֱ��ѡ���������Ч�Ľ���
	//������ͨ�����νṹ���沿�ֱȽϽ�����ɼ��ٱȽϴ�����
	private static void heapSort(int[] array) {
		//ѭ������
		for(int i = 0; i < array.length; i++) {
			//����
			buildMaxHeap(array, array.length - 1 - i);
			//�����Ѷ������һ��Ԫ��
			swap(array, 0, array.length - 1 - i);
		}
	}
	//��array�����0��lastIndex���󶥶�
	private static void buildMaxHeap(int[] array, int lastIndex) {
		//��lastIndex���ڵ�(���һ���ڵ�)�ĸ��ڵ㿪ʼ
		for (int i = (lastIndex - 1) / 2; i >= 0; i--)
		{
			//k���������жϵĽڵ�
			int k = i;
			//�����ǰk�ڵ���ӽڵ����
			while(k*2+1 <= lastIndex) {
				//k�ڵ�����ӽڵ������
				int biggerIndex = 2*k+1;
				//���biggerIndexС��lastIndex����biggerIndex+1�����k�ڵ�����ӽڵ����
				if(biggerIndex < lastIndex) {
					//����ҽڵ��ֵ�ϴ�
					if(array[biggerIndex+1]>array[biggerIndex]) {
						//biggerIndex���Ǽ�¼�ϴ��ӽڵ������
						biggerIndex++;
					}
				}
				//���k�ڵ��ֵС����ϴ���ӽڵ��ֵ
				if(array[k] < array[biggerIndex]) {
					swap(array, k, biggerIndex);
					//��biggerIndex����k����ʼwhileѭ������һ��ѭ�������±�֤k�ڵ��ֵ�����������ӽڵ��ֵ
					k = biggerIndex;
				} else {
					break;
				}
			}
		}
	}
	//5.ð�������ȶ���O(n2)
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
	//6.���ţ���ƽ����ʱ�临�Ӷ�O(nlogn),�ʱ�临�Ӷ�O(n2)�����ȶ���
	//��n�ϴ�ʱʹ�ÿ��űȽϺã������л�������ʱ�ÿ��ŷ������á�
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
	//7.�鲢�����ȶ����򣬷�ԭ�����򣬿ռ临�Ӷ�O(n)��ʱ�临�Ӷ�O(nlongn)
	// �ٶȽ����ڿ��ţ�һ�����ڶ��������򣬵��Ǹ�����������������
	private static void mergeSort(int array[], int low, int high) {
		if (low < high)
		{
			mergeSort(array, low, (low + high) / 2);
			mergeSort(array, (low + high) / 2 + 1, high);
			merge(array, low, (low + high) / 2, high);
		}
	}
	//�鲢�����������ϲ�
	private static void merge(int[] array, int low, int mid, int high) {
		int[] b = new int[high - low + 1];
		int s = low;
		int t = mid + 1;
		int k = 0;
		while(s <= mid && t <= high) {
			if (array[s] <= array[t])
			{
				b[k++] = array[s++];
			}else {
				b[k++] = array[t++];
			}
		}
		while(s <= mid) b[k++] = array[s++];
		while(t <= high)b[k++] = array[t++];
	    for (int i = 0; i < b.length; i++)
		{
			array[low + i] = b[i];
		}
	}
	//8.���������ȶ���ʱ�临�Ӷ�O(d(n+r)),dΪλ����rΪ����
	private static void radixSort(int[] array) {
		//�ҵ��������ȷ��Ҫ������
		int max = 0;
		for (int i = 0; i < array.length; i++)
		{
			if (max < array[i])
			{
				max = array[i];
			}
		}
		//�ж�λ��
		int times = 0;
		while(max > 0){
			max = max / 10;
			times++;
		} 
		//����ʮ������
		List<ArrayList> queue = new ArrayList<ArrayList>();
		for (int i = 0; i < 10; i++)
		{
			ArrayList queue1 = new ArrayList();
			queue.add(queue1);
		}
		//����times�η�����ռ�
		for (int i = 0; i < times; i++)
		{
			//����
			for (int j = 0; j < array.length; j++)
			{
				int x = array[j] % (int)Math.pow(10, i+1) /(int)Math.pow(10, i);//ע��������i����j
				ArrayList queue2 = queue.get(x);
				queue2.add(array[j]);
				queue.set(x, queue2);
			}
			//�ռ�
			int count = 0;
		    for (int j = 0; j < 10; j++)
		    {
			    while (queue.get(j).size() > 0)
			    {
				    ArrayList<Integer> queue3 = queue.get(j);
				    array[count] = queue3.get(0);
				    queue3.remove(0);
				    count++;
			    }
		    }
		}
	}
	//����
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	//��ӡ
	private static void print(String str, int[] array) {//��������ʱ������ʵ��Ҫ���β�
		System.out.println(str);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}