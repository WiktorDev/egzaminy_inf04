public class SortAlgorithms {
    private int[] items;

    public SortAlgorithms() {
        this.items = new int[]{6, 1, 2, 7, 3, 12, 10,0,2,9};
    }

    /**
     * BubbleSort
     */
    public void bubbleSort() {
        for (int i = 0; i < this.items.length - 1; i++) {
            for (int j = 0; j < this.items.length - i - 1; j++) {
                if (this.items[j] > this.items[j + 1]) {
                    int temp = this.items[j];
                    this.items[j] = this.items[j + 1];
                    this.items[j + 1] = temp;
                }
            }
        }
    }

    /**
     * InsertionSort
     */
    public void insertionSort() {
        for (int i = 1; i < this.items.length ; i++) {
            int key = this.items[i];
            int j = i - 1;
            while (j >= 0 && this.items[j] > key) {
                this.items[j + 1] = this.items[j];
                j--;
            }
            this.items[j + 1] = key;
        }
    }

    /**
     * SelectionSort
     */
    public void selectionSort() {
        for (int i = 0; i < this.items.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < this.items.length; j++) {
                if (this.items[j] < this.items[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = this.items[i];
            this.items[i] = this.items[minIndex];
            this.items[minIndex] = temp;
        }
    }

    /**
     * QuickSort
     */
    public void quickSort() {
        this.quickSortRec(0, this.items.length - 1);
    }
    private void quickSortRec(int low, int high) {
        if (low < high) {
            int pivot = this.partition(low, high);
            this.quickSortRec(low, pivot - 1);
            this.quickSortRec(pivot + 1, high);
        }
    }
    private int partition(int low, int high) {
        int pivot = this.items[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (this.items[j] <= pivot) {
                i++;
                int temp = this.items[i];
                this.items[i] = this.items[j];
                this.items[j] = temp;
            }
        }

        int temp = this.items[i+1];
        this.items[i+1] = this.items[high];
        this.items[high] = temp;

        return i+1;
    }

    public void print() {
        for (int item : this.items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
