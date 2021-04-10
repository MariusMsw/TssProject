package com.mariusmihai.licenta;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SolveLicentaProblem {

    private int K, N, M;
    private final List<Interval> S = new ArrayList<>();
    private final List<Interval> T = new ArrayList<>();

    public Optional<Interval> solveProblem() {
        readFromFile();
        int l = 0, r = 0;
        while (l < N && r < M) {
            int maxim = Math.max(S.get(l).getX(), T.get(r).getX());
            int minim = Math.min(S.get(l).getY(), T.get(r).getY());

            if (minim - maxim >= K) {
                return Optional.of(new Interval(maxim, maxim + K));
            }

            if (S.get(l).getY() < T.get(r).getY()) {
                l++;
            } else if (S.get(l).getY() > T.get(r).getY()) {
                r++;
            } else {
                l++;
                r++;
            }
        }
        return Optional.empty();
    }

    private void readFromFile() {
        try {
            Scanner scanner = new Scanner(new File("licenta.in"));
            K = scanner.nextInt();
            N = scanner.nextInt();
            checkEntryValues(K, N, 1);
            for (int i = 0; i < N; i++) {
                S.add(new Interval(scanner.nextInt(), scanner.nextInt()));
            }
            checkIntervalsAreEligible(S);
            M = scanner.nextInt();
            checkEntryValues(K, N, M);
            for (int i = 0; i < M; i++) {
                T.add(new Interval(scanner.nextInt(), scanner.nextInt()));
            }
            checkIntervalsAreEligible(T);

            S.stream().sorted(Comparator.comparingInt(Interval::getX));
            T.stream().sorted(Comparator.comparingInt(Interval::getX));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void checkEntryValues(int K, int N, int M) {
        if (K < 1 || K >= Math.pow(10, 9)) {
            throw new ValueNotInRangeException("K not in [1, 10^9)");
        }
        if (N < 1 || N > Math.pow(10, 5)) {
            throw new ValueNotInRangeException("N not in [1, 10^5)");
        }
        if (M < 1 || M > Math.pow(10, 5)) {
            throw new ValueNotInRangeException("M not in [1, 10^5)");
        }
    }

    private void checkIntervalsAreEligible(List<Interval> intervals) {
        for (Interval interval : intervals) {
            if (interval.getX() < 0 || interval.getX() >= interval.getY() || interval.getY() >= Math.pow(10, 9)) {
                throw new ValueNotInRangeException("Interval not eligible");
            }
        }
    }
}
