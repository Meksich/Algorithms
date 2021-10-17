package ua.lviv.iot;

public class Main {

    public static void main(String[] args) {
//      execute with command java -classpath E:\Jaba\algo-lab1_maven\src\main\java ua.lviv.iot.Main

        Container quick_sort = new Container(args[0], args[1]);

        quick_sort.generate_report();
    }
}
