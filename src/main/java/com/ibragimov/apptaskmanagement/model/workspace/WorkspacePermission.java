package com.ibragimov.apptaskmanagement.model.workspace;

import com.ibragimov.apptaskmanagement.model.enums.WorkspacePermissionName;
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
public class WorkspacePermission extends UUIDModel {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private WorkspaceRole workspaceRole;

    @Enumerated(EnumType.STRING)
    private WorkspacePermissionName permission;

}
