package dsa;

public class MergeSort {
    static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int mid = arr.length / 2;

        int[] leftArr = new int[mid];
        int[] rightArr = new int[arr.length - mid];

        int i = 0;
        int j = 0;

        for (i = 0; i < arr.length; i++) {
            if (i < mid) {
                leftArr[i] = arr[i];
            } else {
                rightArr[j] = arr[i];
                j++;
            }
        }
        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(leftArr, rightArr, arr);
    }

    static void merge(int[] leftArr, int[] rightArr, int[] arr) {
        int i = 0;
        int l = 0;
        int r = 0;

        while (l < leftArr.length && r < rightArr.length) {
            if (leftArr[l] < rightArr[r]) {
                arr[i] = leftArr[l];
                i++;
                l++;
            } else {
                arr[i] = rightArr[r];
                i++;
                r++;
            }
        }

        while (l < leftArr.length) {
            arr[i] = leftArr[l];
            i++;
            l++;
        }

        while (r < rightArr.length) {
            arr[i] = rightArr[r];
            i++;
            r++;
        }
    }

    public static void main(String[] args) {
        int[] array = { 4, 6, 5, 9, 8, 0, 3, 2, 7, 1 };
        mergeSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }
}
