package com.ibragimov.apptaskmanagement.dao;

import com.ibragimov.apptaskmanagement.model.workspace.WorkspaceUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkspaceUserRepository extends JpaRepository<WorkspaceUser, Long> {
}
