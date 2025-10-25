
package BubbleSort.View;


public class Display {
     // Hiển thị mảng
    public void displayArray(int[] arr, String message) {
        System.out.println(message);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
    }

    // Hiển thị lời chào
    public void displayWelcome() {
        System.out.println("=== Bubble Sort Program (MVC) ===");
    }

}
