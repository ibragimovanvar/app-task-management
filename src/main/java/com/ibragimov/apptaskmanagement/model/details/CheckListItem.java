package com.ibragimov.apptaskmanagement.model.details;

import com.ibragimov.apptaskmanagement.model.template.LongModel;
import com.ibragimov.apptaskmanagement.model.userdetails.User;
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
public class CheckListItem extends LongModel {

    private String name;

    @ManyToOne
    private CheckList checkList;

    private boolean resolved;

    @ManyToOne
    private User assignedUser;

}
