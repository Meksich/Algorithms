package ua.lviv.iot;

import java.util.* ;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Priority Queue Test\n");

        PriorityQueue pq = new PriorityQueue();
        int[] arr = {167, 26, 16, 18, 99, 92, 1, 2, 165, 4, 65, 100, 166, 4, 54, 6};
        System.out.println(pq.var_3(arr));
        boolean stop = false;
        do {
            System.out.println("\n---------------------------------------------------------------\n" +
                    "\nPriority Queue Operations\n");
            System.out.println("Add. Add new element");
            System.out.println("Poll. Remove poll element");
            System.out.println("Peek. Peek poll element");
            System.out.println("Clear. Clear heap");
            System.out.println("Size. Return heap size");
            System.out.println("Stop. Stop program");

            String choice = scan.next();
            switch (choice) {
                case "add" :
                case "Add" :
                    System.out.println("Enter Element value and priority");
                    pq.add(scan.nextInt(), scan.nextInt() );
                    break;
                case "poll" :
                case "Poll" :
                    System.out.println("\nElement removed :\n");
                    Element poll = pq.poll();
                    if (poll == null){System.out.println("Noooooooooooooooo! Queue is empty, you cannot delete element!\n");}
                    else{System.out.println(poll);}
                    break;
                case "peek" :
                case "Peek" :
                    System.out.println("\nPeeked element : \n");
                    if (pq.peek() == null){System.out.println("Noooooooooooooooo! Queue is empty, you cannot peek element!\n");}
                    else{System.out.println(pq.peek());}
                    break;
                case "clear" :
                case "Clear" :
                    System.out.println("\nPriority queue cleared");
                    pq.clear();
                    break;
                case "size" :
                case "Size" :
                    System.out.println("\nSize = "+ pq.size() );
                    break;
                case "stop" :
                case "Stop" :
                    stop = true;
                    break;
                default :
                    System.out.println("\nWrong entry \n ");
                    break;
            }
        } while (!stop);
    }
}
