package com.work;

public abstract class AddBook {

    public void add(int a){
        System.out.println(a);

    }

    public abstract void test();

    public int add(float a){
        System.out.println(a);

        return 0;
    }


    public void add(int a,int b, int c) {
        System.out.println(a);
        System.out.println(a+b);
        System.out.println(a+b+c);
    }
}
