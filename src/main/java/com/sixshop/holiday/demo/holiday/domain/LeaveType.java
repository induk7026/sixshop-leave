package com.sixshop.holiday.demo.holiday.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum LeaveType {

    FAMILY_EVENT("경조사", CalculationType.MINUS),
    ANNUAL_LEAVE("연차", CalculationType.MINUS),
    AM_HALF_DAY("오전 반차", CalculationType.MINUS),
    AM_QUARTER_DAY("오전 반반차", CalculationType.MINUS),
    PM_HALF_DAY("오후 반차", CalculationType.MINUS),
    PM_QUARTER_DAY("오후 반반차", CalculationType.MINUS),
    SICK_LEAVE("병가", CalculationType.MINUS),
    MATERNITY_LEAVE("출산 휴가", CalculationType.MINUS),
    EXTRA_LEAVE("가산 휴가", CalculationType.PLUS),
    UNKNOWN(null, null);

    public static final List<LeaveType> DEDUCTION_LEAVE_TYPE = Collections.unmodifiableList(
        Arrays.asList(ANNUAL_LEAVE, AM_HALF_DAY, AM_QUARTER_DAY, PM_HALF_DAY, PM_QUARTER_DAY)
    );

    public static final List<LeaveType> CHANGEABLE_LEAVE_TYPE = Collections.unmodifiableList(
        Arrays.asList(ANNUAL_LEAVE, AM_HALF_DAY, AM_QUARTER_DAY, PM_HALF_DAY, PM_QUARTER_DAY)
    );

    private String name;
    private CalculationType calculationType;

    LeaveType(String name, CalculationType calculationType) {
        this.name = name;
        this.calculationType = calculationType;
    }

    public String getName() {
        return name;
    }

    public CalculationType getCalculationType() {
        return calculationType;
    }

    public static boolean isChangeableLeaveType(LeaveType leaveType){
        return CHANGEABLE_LEAVE_TYPE.contains(leaveType);
    }

    public static boolean isNotChangeableLeaveType(LeaveType leaveType){
        return !isChangeableLeaveType(leaveType);
    }
}
