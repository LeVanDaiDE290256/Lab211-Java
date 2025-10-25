
package SelectionSort.Controller;

import BubbleSort.View.Display;
import Candidate.View.Validator;
import SelectionSort.Model.SelectionSort;




public class Main {
    private SelectionSort model;
    private Display view;

    public Main(SelectionSort model, Display view) {
        this.model = model;
        this.view = view;
    }
    
    public void run(){
        view.displayWelcome();
        int n = Validator.getInt("Enter number of array ( >= 0 ): ",0, Integer.MAX_VALUE);
        
         // Gọi model sinh mảng
        model.generateArray(n);

        // Hiển thị mảng ban đầu
        view.displayArray(model.getArray(), "Unsorted array:");
        
         // Sắp xếp bằng Bubble Sort
        model.selectionSort();
        
        // Hiển thị mảng sau sắp xếp
        view.displayArray(model.getArray(), "Sorted array (Selection Sort): ");
    }
    // Hàm main chạy chương trình
    public static void main(String[] args) {
        SelectionSort model = new SelectionSort();
        Display view = new Display();
        Main controller = new Main(model, view);
        controller.run();
    }
}
