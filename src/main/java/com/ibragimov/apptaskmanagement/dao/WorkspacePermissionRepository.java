package com.ibragimov.apptaskmanagement.dao;

import com.ibragimov.apptaskmanagement.model.workspace.Workspace;
import com.ibragimov.apptaskmanagement.model.workspace.WorkspacePermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspacePermissionRepository extends JpaRepository<WorkspacePermission, Long> {
}
