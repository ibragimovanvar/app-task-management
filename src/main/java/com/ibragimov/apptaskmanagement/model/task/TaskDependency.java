package com.ibragimov.apptaskmanagement.model.task;

import com.ibragimov.apptaskmanagement.model.enums.DependencyType;
import com.ibragimov.apptaskmanagement.model.template.LongModel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TaskDependency extends LongModel {

    @ManyToOne
    private Task task;

    @ManyToOne
    private Task dependencyTask;

    @Enumerated(EnumType.STRING)
    private DependencyType dependencyType;
}
