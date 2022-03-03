/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce308;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 2019-e-edlund
 */
public class EvenOdd {

    public static void main(String[] args) throws InterruptedException {
        EvenOdd eo = new EvenOdd();
        Thread even = new Thread(() -> eo.fillEven(100));
        Thread odd = new Thread(() -> eo.fillOdd(100));
        even.start();
        odd.start();
        even.join();
        odd.join();
        System.out.println(eo.list);
        System.out.println(eo.list.size());

    }
    private final List<Integer> list = new ArrayList<>();

    public void fillEven(int max) {
        for (int i = 2; i < max; i += 2) {
            list.add(i);

        }
    }

    public void fillOdd(int max) {
        for (int i = 1; i < max; i += 2) {
            list.add(i);

        }
    }

}
