
package BubbleSort.Model;

import java.util.Random;


public class BubbleSort {
     private int[] arr;

    // Tạo mảng ngẫu nhiên với n phần tử
    public void generateArray(int n) {
        Random rand = new Random();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100); // số ngẫu nhiên từ 0-99
        }
    }

    // Trả về mảng hiện tại
    public int[] getArray() {
        return arr;
    }

    // Bubble Sort
    public void bubbleSort() {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // nếu không đổi chỗ thì kết thúc
        }
    }
}
