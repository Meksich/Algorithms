package ua.lviv.iot;

public class Element {
    public int data;
    public int priority;

    public Element(int number, int priority) {
        this.data = number;
        this.priority = priority;
    }
    public String toString() {
        return "Element : "+ data +"\nPriority : "+ priority;
    }
}
