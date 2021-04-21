public class ArrayUtil{
	//problem 1
	public static void reverse(String[] array){
		for (int j = 0; j < array.length / 2;j++){
			String store = array[j];
			array[j] = array[array.length - j - 1];
			array[array.length - j - 1] = store;
		}
	}
	//problem 2
	//problem 3
	//problem 4
	//problem 5
	public static int findMinValue(int[] array){
		int min = array[0];
		for (int element: array){
			min = Math.min(min, element);
		}
		return min;
	}

	public static int findMaxValue(int[] array){
		int max = array[0];
		for (int element: array){
			max = Math.max(max, element);
		}
		return max;
	}
	//problem 6
	public static int[] findMinIndex(int[] array){
		int min = findMinValue(array);
		int count=0;
		for (int element:array){
			if (element == min){
				count++;
			}
		}

		int[] minIndices = new int[count];
		int indexCount = 0;
		for (int j = 0; j < array.length; j++){
			if(array[j] == min){
				minIndices[indexCount++] = j;
			}
		}
		return minIndices;
	}

	public static int[] findMaxIndex(int[] array){
		int max = findMaxValue(array);
		int count = 0;
		for(int element: array){
			if (element == max){
				count++;
			}
		}
		int[] maxIndices = new int[count];
		int indexCount = 0;
		for (int j=0; j<array.length; j++){
			if(array[j] == max){
				maxIndices[indexCount++] = j;
			}
		}

		return maxIndices;
	}

}