package com.ibragimov.apptaskmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ibragimov.apptaskmanagement.model.enums.AccessType;
import com.ibragimov.apptaskmanagement.model.template.LongModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
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
public class Project extends LongModel {

    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Space space;

    @Enumerated
    private AccessType accessType;

    private boolean archived = false;

    private String color;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Attachment attachment;

}
