package com.ibragimov.apptaskmanagement.model;


import com.ibragimov.apptaskmanagement.model.template.LongModel;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task extends LongModel {

    private String name;

    private String description;

    @ManyToOne
    private Status status;

    @ManyToOne
    private Priority priority;

    @ManyToOne
    private Task parentTask;

    private Date startedDate;

    private boolean hasStartTime;

    private Date dueDate;

    private boolean hasDueDate;

    private Long estimateTime;

    private Date activedDate;




}
