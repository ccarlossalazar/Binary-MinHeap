public class MinHeap {
    // Here we create our instance variables for the array to store our heap elements
    // We also have the size of our heap and the capacity for our min heap
        private int[] heap;
        private int size;
        private int capacity;
    
     // Here we initialize our heap array with capacity and our size is initialized to 0
    public MinHeap(int capacity) {
        this.capacity = capacity;
            heap = new int[capacity];
            size = 0;
        }
    // We create methods for parent node, leftChild node, rightChild node, and swap
    private int parent(int index) {
            return (index - 1) / 2;
        }
    
    private int leftChild(int index) {
            return 2 * index + 1;
        }
    
    private int rightChild(int index) {
            return 2 * index + 2;
        }
    
    private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }
    
            //used to display out minHeap array
    public void display() {
        System.out.println("Current Min-Heap:");
            for (int i = 0; i < size; i++) {
                System.out.print(heap[i] + " ");
        }
            System.out.println();
        }
    // Insert method that returns heap is full if size is greater than capacity
     // inserts current value at the end or swaps it with the parent index if it is smaller
        public void insert(int value) {
            if (size >= capacity) {
                System.out.println("Heap is full.");
                return;
        }
            heap[size] = value;
            int currentIndex = size;
            size++; // increments size every time it is called
            while (currentIndex > 0 && heap[currentIndex] < heap[parent(currentIndex)]) {
                swap(currentIndex, parent(currentIndex));
                currentIndex = parent(currentIndex);
        }
        }
    // Method to extract min from our heap and 
    public int extract_min() {
            if (size <= 0) {
                System.out.println("Heap is empty cannot extract at this moment");
                return -1;
        }
            int min = heap[0];
            heap[0] = heap[size - 1];
            size--;
            heapify(0);
            return min;
        }
    // we use this method to recursively run through the nodes and make sure they are placed correctly after an extraction
    private void heapify(int index) {
        int left = leftChild(index);
        int right = rightChild(index);
        int smalltemp = index;
    if (left < size && heap[left] < heap[smalltemp]) {
                smalltemp = left;
    }
    if (right < size && heap[right] < heap[smalltemp]) {
                smalltemp = right;
    }
    if (smalltemp != index) {
                swap(index, smalltemp);
                heapify(smalltemp);
    }
    }
    public static void main(String[] args) {
            MinHeap minHeap = new MinHeap(10);
        minHeap.insert(80);
        minHeap.insert(35);
        minHeap.insert(60);
        minHeap.insert(45);
        minHeap.insert(100);
        minHeap.insert(23);
        minHeap.insert(48);
        minHeap.insert(79);
        minHeap.insert(94);
        minHeap.insert(18);
    // called display method to display our min heap array
    minHeap.display(); 
    System.out.println("Extracted min: " + minHeap.extract_min()); 
    minHeap.display(); 
    }
    }


    
   
