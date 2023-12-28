package com.ibragimov.apptaskmanagement.model;


import com.ibragimov.apptaskmanagement.model.enums.AccessType;
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
public class Category extends LongModel {

    private String name;

    @ManyToOne
    private Project project;

    @Enumerated(EnumType.STRING)
    private AccessType accessType;

    private boolean archived;

    private String color;


}
