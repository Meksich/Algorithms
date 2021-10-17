package ua.lviv.iot;

import java.util.Arrays;

class PriorityQueue {
    private Element[] heap;
    private int heapSize, capacity;
    int max, min;

    public Element[] getHeap() { return heap; }

    public PriorityQueue() {
        capacity = 1;
        heap = new Element[this.capacity];
        heapSize = 0;
    }

    public void clear() {
        heap = new Element[capacity];
        capacity = 1;
        heapSize = 0;
    }

    public int size() {
        return heapSize;
    }

    public void add(int value, int priority) {
        Element[] temp = heap;
        heap = new Element[++capacity];
        System.arraycopy(temp, 0, heap, 0, temp.length);

        Element newEl = new Element(value, priority);

        heap[++heapSize] = newEl;
        int pos = heapSize-1;
        while (pos != 0 && newEl.priority < heap[(pos-1)/2].priority) {
            heap[pos] = heap[(pos-1)/2];
            pos -=1;
            pos /=2;
        }
        heap[pos] = newEl;
    }

    public Element poll() {
        if (isEmpty()){
            return null;
        }
        int parent, child;
        Element item, temp;

        item = heap[0];
        temp = heap[--heapSize];

        parent = 0;
        child = 1;
        while (child <= heapSize) {
            if (child < heapSize && heap[child].priority > heap[child + 1].priority)
                child++;
            if (temp.priority <= heap[child].priority)
                break;

            heap[parent] = heap[child];
            parent = child;
            child *= 2;
            child += 1;
        }
        heap[parent] = temp;
        if (heapSize == 0){
            clear();
        }

        return item;
    }

    public Element peek() {
        return heap[0];
    }

    private boolean isEmpty() {
        return heapSize == 0;
    }

    public int var_1_ex(int[] array) {
        int i = 0;
        int j = array.length-1;
        min = i;
        max = j;
        while(i < j){
            if (array[max]-array[i+1] > array[j-1]-array[min]){
                if(array[max]-array[++i]>array[max]-array[min])
                    min = i;}
            else if(array[--j]-array[min]>array[max]-array[min])
                    max = j;
        }
        return array[max]-array[min];
    }

    public int var_1(int[] array, int start, int end) {
        min = start-1;
        max = start-1;
        for(int i=start; i < end; i++) {
            if(array[i] < array[min])
                min=i;
            else if(array[i] > array[max])
                max=i;
            if(max<min)
                max=min;
        }
        return array[max]-array[min];
    }

    public int var_2(int[] array){
        int delta = 0;
        for(int i=0; i<array.length-1; i++){
            if(array[i]<array[i+1])
                delta += array[i+1]-array[i];
        }
        return delta;
    }

    public int var_3(int[] array){
        int bestDealEver = var_1(array, 1, array.length); //Best deal in whole array
        int bestBounds_l = min; //Index of buy date if we do only one most profitable deal
        int bestBounds_r = max; //Index of sell date if we do only one most profitable deal
        int nextBestDeal = Math.max(var_1(array, 1, bestBounds_l), //This code search for next most profitable deal
                var_1(array, bestBounds_r+1, array.length)); //if we made Best Deal
        //Next two lines of code check whether there are 2 more profitable deals
        //during Best deal
        int firstDealInsideBest = var_1(array, bestBounds_l+1, bestBounds_r-1);//
        int secondDealInsideBest = var_1(array, max+1, bestBounds_r+1);
        //While we can do 2 deals we check what is more profitable
        return Math.max((bestDealEver + nextBestDeal), (firstDealInsideBest + secondDealInsideBest));
        //There is no other option to make more profitable deal, I swear
    }

    public static int[] removeTheElement(int[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
            return arr;
        }
        int[] anotherArray = new int[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) continue;
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}