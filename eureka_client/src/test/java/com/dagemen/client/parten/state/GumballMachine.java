package com.dagemen.client.parten.state;

public class GumballMachine {


    private static final int SALD_OUT = 0;//售完
    private static final int NO_QUARTER = 1;//没有硬币
    private static final int HAS_QUARTER = 2;//有硬币
    private static final int SOLD = 3;//售出

    int state = SALD_OUT;//初始数量
    int count = 0;//糖果数量

    public GumballMachine(int count) {
        this.count = count;
    }


    public void insertQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("you can't insert another quarter");
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("you inserted a quarter");
        } else if (state == SALD_OUT) {
            System.out.println("you cant't insert a quarter , the machine sald out! ");
        } else if (state == SOLD) {
            System.out.println("please wait ,we're already giving you a gumball");
        }
    }

    public void ejectQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("quarter returned");
            state = NO_QUARTER;
        } else if (state == NO_QUARTER) {
            System.out.println("you  haven't inserted a quarter");
        } else if (state == SALD_OUT) {
            System.out.println("you can't eject , you  haven't inserted a quarter yet ");
        } else if (state == SOLD) {
            System.out.println("sorry, you already turned the crank ");
        }
    }

    public void turnCrank() {
        if (state == HAS_QUARTER) {
            System.out.println("you turned ....");
            state = SOLD;
            dispense();
        } else if (state == NO_QUARTER) {
            System.out.println("you truned but there's no quarter,please ");
        } else if (state == SALD_OUT) {
            System.out.println("you can't eject , you  haven't inserted a quarter yet ");
        } else if (state == SOLD) {
            System.out.println("sorry, you already turned the crank ");
        }
    }

    public void dispense() {
        if (state == SOLD) {
            System.out.println("A gumball comee rolling out the  slot ");
            count--;
            if (count == 0) {
                System.out.println("Oops ,out of gumball");
                state = SALD_OUT;
            } else {
                state = NO_QUARTER;
            }
        } else if (state == HAS_QUARTER) {
            System.out.println(" No gumball dispensed ");
        } else if (state == NO_QUARTER) {
            System.out.println(" you need to pay fisrt ");
        } else if (state == SALD_OUT) {
            System.out.println(" No gumball dispensed ");
        }
    }
}
