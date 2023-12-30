package com.ibragimov.apptaskmanagement.model.task;

import com.ibragimov.apptaskmanagement.model.template.LongModel;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TimeTracked extends LongModel {

    @ManyToOne
    private Task task;

    private Timestamp startedAt;

    private Timestamp stoppedAt;

}
