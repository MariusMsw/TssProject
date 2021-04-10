package com.mariusmihai.licenta;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class FileInput {

    private int K;
    private int N;
    private List<Interval> S;
    private int M;
    private List<Interval> T;
}
