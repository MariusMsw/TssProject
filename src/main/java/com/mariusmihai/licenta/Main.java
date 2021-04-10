package com.mariusmihai.licenta;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Optional<Interval> result = new SolveLicentaProblem().solveProblem();
        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("-1");
        }
    }
}
