package com.ibragimov.apptaskmanagement.model.details;

import com.ibragimov.apptaskmanagement.model.files.Icon;
import com.ibragimov.apptaskmanagement.model.template.LongModel;
import jakarta.persistence.Entity;
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
public class View extends LongModel {

    private String name;

    @ManyToOne
    private Icon icon;
}
