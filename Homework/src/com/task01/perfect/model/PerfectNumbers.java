package com.task01.perfect.model;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumbers {

    private int max;

    private List<Integer> pns;

    public PerfectNumbers() {
        pns = new ArrayList<>();
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public List<Integer> getPns() {
        return pns;
    }

    public void setPns(List<Integer> pns) {
        this.pns = pns;
    }
}
