package com.ibragimov.apptaskmanagement.model.details;

import com.ibragimov.apptaskmanagement.model.enums.TaskPermission;
import com.ibragimov.apptaskmanagement.model.template.LongModel;
import com.ibragimov.apptaskmanagement.model.userdetails.User;
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
public class CategoryUser extends LongModel {

    private String name;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private TaskPermission taskPermission;

}
