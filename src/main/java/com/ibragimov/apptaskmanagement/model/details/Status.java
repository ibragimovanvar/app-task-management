package com.ibragimov.apptaskmanagement.model.details;

import com.ibragimov.apptaskmanagement.model.enums.StatusType;
import com.ibragimov.apptaskmanagement.model.project.Project;
import com.ibragimov.apptaskmanagement.model.project.Space;
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
public class Status extends LongModel {

    private String name;

    @ManyToOne
    private Space space;

    @ManyToOne
    private Project project;

    @ManyToOne
    private Category category;

    private String color;

    @Enumerated(EnumType.STRING)
    private StatusType statusType;

}
