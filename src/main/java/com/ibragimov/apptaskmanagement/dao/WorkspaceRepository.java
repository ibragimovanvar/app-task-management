package com.ibragimov.apptaskmanagement.dao;

import com.ibragimov.apptaskmanagement.model.workspace.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {

    boolean existsByOwnerIdAndName(UUID ownerId, String name);

    @Query(value = "select * from workspace_user join workspace on workspace_user.workspace_id = workspace.id where workspace_user.user_id = ?1", nativeQuery = true)
    List<Workspace> findAllByUserId(UUID userId);

}
