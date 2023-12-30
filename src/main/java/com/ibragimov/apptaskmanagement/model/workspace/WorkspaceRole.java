package com.ibragimov.apptaskmanagement.model.workspace;

import com.ibragimov.apptaskmanagement.model.enums.WorkspaceRoleName;
import com.ibragimov.apptaskmanagement.model.template.UUIDModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class WorkspaceRole extends UUIDModel {


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Workspace workspace;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private WorkspaceRoleName extendsRole;
}
