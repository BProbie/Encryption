package com.probie.Worder;

public class Randomer {

    private volatile static Randomer INSTANCE;

    public synchronized static Randomer getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Randomer();
        }
        return INSTANCE;
    }

    public int getRandomInteger(int min, int max) {
        if (max >= min) {
            if (min >= 0) {
                return (int) (Math.random()*(max-min+1)+min);
            } else {
                if (max >= 0) {
                    return (int) (Math.random()*(max-min+2)+min-1);
                } else {
                    return (int) (Math.random()*(max-min+1)+min-1);
                }
            }
        }
        return -1;
    }

    public char getRandomAscll() {
        return (char) getRandomInteger(0, 2048);
    }

    public char getRandomAscllUnsigned() {
        return (char) getRandomInteger(33, 127);
    }

}