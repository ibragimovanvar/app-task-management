package com.ibragimov.apptaskmanagement.model.project;

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
public class ProjectUser extends LongModel {

    @ManyToOne
    private Project project;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private TaskPermission taskPermission;

}
