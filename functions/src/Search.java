public class Search {
    private int[] items;

    public Search() {
        this.items = new int[]{6, 1, 2, 7, 3, 12, 10,0,2,9};
    }

    public int linearSearch(int key) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == key) return i;
        }
        return -1;
    }

    public int binarySearch(int key) {
        int low = 0;
        int high = this.items.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (key == this.items[mid]) return mid;
            else if (key < this.items[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
