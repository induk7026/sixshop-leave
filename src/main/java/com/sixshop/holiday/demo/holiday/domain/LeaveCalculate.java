package com.sixshop.holiday.demo.holiday.domain;

import java.util.List;
import java.util.function.Function;

public enum LeaveCalculate {

    SUM("남은 휴가", list ->{
        return getSum(list);
    });

    private final String name;
    private final Function<List<Double>, Double> expression;

    LeaveCalculate(String name, Function<List<Double>, Double> expression) {
        this.name = name;
        this.expression = expression;
    }

    public Double calculate(List<Double> list) {
        if(list.size() == 0){
            return 0d;
        }
        return expression.apply(list);
    }

    private static Double getSum(List<Double> list) {
        return list.stream()
            .reduce(Double::sum)
            .get();
    }


}
