package ua.lviv.iot;

public class Hamster {
    public Integer daily;
    public Integer avarice;

    public Hamster(Integer daily, Integer avarice){
        this.daily = daily;
        this.avarice = avarice;
    }

    public Integer count_hamster_consumption(int n){
        return daily + (n*avarice);
    }
}
