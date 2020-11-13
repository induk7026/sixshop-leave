package com.sixshop.holiday.demo.holiday.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Number {
    SUM("합계", list -> {
        return getSum(list);
    });

    private final String name;
    private final Function<List<Double>, Double> expression;

    Number(String name, Function<List<Double>, Double> expression) {
        this.name = name;
        this.expression = expression;
    }

    private static Double getSum(List<Double> list) {
        return list.stream()
            .reduce(Double::sum)
            .get();
    }

    public Double calculate(List<LeaveHistory> list) {
        return expression.apply(list.stream().map(LeaveHistory::getDeductionHours).collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        List<LeaveHistory> list = new ArrayList<>();
        LeaveHistory leaveHistory = LeaveHistory.builder()
            .id(1L)
            .deductionHours(-1D)
            .build();
        
        list.add(leaveHistory);
        list.add(leaveHistory);
        list.add(leaveHistory);
        list.add(leaveHistory);
        System.out.println(Number.SUM.calculate(list));
    }
}