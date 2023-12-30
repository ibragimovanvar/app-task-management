package com.ibragimov.apptaskmanagement.model.task;

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
public class TaskHistory extends LongModel {

    @ManyToOne
    private Task task;

    private String changedFieldName;

    private String before;

    private String after;

    private String data;

}
