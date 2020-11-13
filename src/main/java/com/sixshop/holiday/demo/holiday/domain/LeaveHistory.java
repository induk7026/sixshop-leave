package com.sixshop.holiday.demo.holiday.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sixshop.holiday.demo.employee.domain.Employee;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Table(name = "leave_history")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
public class LeaveHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private LeaveType type;

    @Enumerated(EnumType.STRING)
    private CalculationType calculationType;

    private double deductionHours;

    private LocalDateTime startDate;

    private LocalDateTime andDate;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(name = "last_modified_at", updatable = true)
    private LocalDateTime lastModifiedDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="employee_id")
    private Employee employee;

    public boolean isLeave(){
        return LeaveType.DEDUCTION_LEAVE_TYPE.contains(this.type);
    }
    public boolean isMinus(){
        return CalculationType.MINUS == this.calculationType;
    }

    @Override
    public String toString(){
        return new ReflectionToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).toString();
    }
}
