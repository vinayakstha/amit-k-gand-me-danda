public class Heap {
    void insert(int a[], int n, int data) {
        n = n + 1;
        a[n] = data;
        int i = n;
        while (i > 0) {
            int p = (i - 1) / 2;
            if (a[p] < a[i]) {
                swap(a, p, i);
                i = p;
            } else {
                break;
            }
        }
    }

    void delete(int a[], int n) {
        a[0] = a[n];
        n = n - 1;
        int i = 0;
        while (i < n) {
            int largest = Integer.MIN_VALUE;
            if (2 * i + 1 <= n && a[2 * i + 1] > a[largest]) {
                largest = 2 * i + 1;
            }
            if (2 * i + 2 <= n && a[2 * i + 2] > a[largest]) {
                largest = 2 * i + 2;
            }
            if (a[largest] > a[i]) {
                swap(a, largest, i);
            } else {
                return;
            }
        }
    }

    void swap(int a[], int p, int i) {
        int temp = a[p];
        a[p] = a[i];
        a[i] = temp;
    }
}
