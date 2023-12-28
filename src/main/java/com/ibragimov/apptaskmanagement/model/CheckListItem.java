package com.ibragimov.apptaskmanagement.model;

import com.ibragimov.apptaskmanagement.model.template.LongModel;
import jakarta.persistence.ManyToOne;


public class CheckListItem extends LongModel {

    private String name;

    @ManyToOne
    private CheckList checkList;

    private boolean resolved;

    @ManyToOne
    private User assignedUser;

}
