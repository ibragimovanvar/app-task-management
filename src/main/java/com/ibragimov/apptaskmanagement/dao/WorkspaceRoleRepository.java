package com.ibragimov.apptaskmanagement.dao;

import com.ibragimov.apptaskmanagement.model.workspace.Workspace;
import com.ibragimov.apptaskmanagement.model.workspace.WorkspaceRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceRoleRepository extends JpaRepository<WorkspaceRole, Long> {
}
