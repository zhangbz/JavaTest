//package com.sort; �����package֮��ֱ��java SortTest�ᱨ��java.lang.NoClassDefFoundError

public class SortTest {
	public static void main(String[] args) {
		int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};

		print("����֮ǰ��", a);//ͨ�����ò���������

		//insertSort(a);
		//shellSort(a);
		//selectSort(a);
		//heapSort(a);
		//bobbleSort(a);
		quickSort(a, 0, a.length-1);
		print("����֮��", a);
	}
	//1.��������ʹ�����������ݵ�����ʱ�临�Ӷ�O(n2)�� ���ȶ��������㷨��ԭ������
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
	//4.�����򣬲��ȶ���O(nlogn)��һ������ѡ�������Ƕ�ֱ��ѡ���������Ч�Ľ���������ͨ�����νṹ���沿�ֱȽϽ�����ɼ��ٱȽϴ�����
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