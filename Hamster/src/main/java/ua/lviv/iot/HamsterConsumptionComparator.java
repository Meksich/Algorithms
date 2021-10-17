package ua.lviv.iot;

import java.util.Comparator;

public class HamsterConsumptionComparator implements Comparator<Hamster> {

    public int n;

    public HamsterConsumptionComparator(int n){
        this.n = n;
    }

    @Override
    public int compare(Hamster hamster1, Hamster hamster2) {
        return hamster1.count_hamster_consumption(n) - hamster2.count_hamster_consumption(n);
    }
}
