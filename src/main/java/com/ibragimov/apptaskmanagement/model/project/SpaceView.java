package com.ibragimov.apptaskmanagement.model.project;

import com.ibragimov.apptaskmanagement.model.details.View;
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
public class SpaceView extends LongModel {

    @ManyToOne
    private Space space;

    @ManyToOne
    private View view;
}
