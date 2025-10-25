
package BubbleSort.Controller;

import BubbleSort.Model.BubbleSort;
import BubbleSort.View.Display;
import Candidate.View.Validator;




public class Main {
    private BubbleSort model;
    private Display view;

    public Main(BubbleSort model, Display view) {
        this.model = model;
        this.view = view;
    }

    

    public void run() {

        view.displayWelcome();
        int n = Validator.getInt("Enter number of array ( >= 0 ): ", 0, Integer.MAX_VALUE);

        // Gọi model sinh mảng
        model.generateArray(n);

        // Hiển thị mảng ban đầu
        view.displayArray(model.getArray(), "Unsorted array:");

        // Sắp xếp bằng Bubble Sort
        model.bubbleSort();

        // Hiển thị mảng sau sắp xếp
        view.displayArray(model.getArray(), "Sorted array (Bubble Sort): ");
    }

    // Hàm main chạy chương trình
    public static void main(String[] args) {
        BubbleSort model = new BubbleSort();
        Display view = new Display();
        Main controller = new Main(model, view);
        controller.run();
    }
}
