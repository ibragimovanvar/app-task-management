package com.ibragimov.apptaskmanagement.model.details;

import com.ibragimov.apptaskmanagement.model.task.Task;
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
public class CheckList extends LongModel {

    private String name;

    @ManyToOne
    private Task task;

}
