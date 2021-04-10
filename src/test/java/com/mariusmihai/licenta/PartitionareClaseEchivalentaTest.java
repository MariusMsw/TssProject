package com.mariusmihai.licenta;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PartitionareClaseEchivalentaTest {

    @Test
    void givenCorrectInput_whenSolveProblem_thenOk() {
        Utils.writeInFile(4, 2, List.of(new Interval(1, 10), new Interval(11, 13)),
                2, List.of(new Interval(2, 4), new Interval(5, 12)));
        Optional<Interval> result = new SolveLicentaProblem().solveProblem();
        assert (result.isPresent());
        assertEquals(5, result.get().getX());
        assertEquals(9, result.get().getY());
    }


}