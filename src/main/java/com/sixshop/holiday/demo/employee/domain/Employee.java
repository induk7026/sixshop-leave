package com.sixshop.holiday.demo.employee.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sixshop.holiday.demo.holiday.domain.LeaveHistory;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Getter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Getter
@Table(name = "employee")
public class Employee {

    public static final int DEFAULT_INT = 15;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(insertable=false, updatable=false)
    private LocalDate joiningCompanyDate;
    private LocalDateTime updatedDate;
    private LocalDateTime createdDate;

    @OneToMany(mappedBy ="employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<LeaveHistory> leaveHistories = new ArrayList<>();

    @Transient
    @Column(insertable=false, updatable=false)
    private double statutoryAnnualLeave;

    @Transient
    @Column(insertable=false, updatable=false)
    private double totalAnnualLeave;
//    private double beLetOverLeaveDay;


    public double getStatutoryAnnualLeave() {
        Period period = Period.between(this.joiningCompanyDate, LocalDate.now()).minusYears(1);
        return statutoryAnnualLeave =  DEFAULT_INT + (Math.floor(period.getYears())/2);
    }

    public double getTotalAnnualLeave(){
        return getStatutoryAnnualLeave() - calculate();

    }

    public boolean checkLeave(){
        return 0 > getStatutoryAnnualLeave() - calculate();
    }

    private double calculate(){
        return this.leaveHistories
            .stream()
            .filter(LeaveHistory::isLeave)
            .filter(LeaveHistory::isMinus).mapToDouble(LeaveHistory::getDeductionHours).sum();
    }

    @Override
    public String toString(){
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
    }
}
