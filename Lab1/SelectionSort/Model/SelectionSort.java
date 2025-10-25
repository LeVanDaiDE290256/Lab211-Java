
package SelectionSort.Model;

import java.util.Random;


public class SelectionSort {
    private int[] arr;
    
    // Sinh mảng ngẫu nhiên trong khoảng [0, 100]
    public void generateArray(int n) {
        Random rand = new Random();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(101); // 0 -> 100
        }
    }
    
     // Trả về mảng hiện tại
    public int[] getArray() {
        return arr;
    }
    
    // Selection Sort tăng dần
    public void selectionSort() {
        if (arr == null || arr.length < 2) return;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // hoán đổi
            int tmp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = tmp;
        }
    }
}
