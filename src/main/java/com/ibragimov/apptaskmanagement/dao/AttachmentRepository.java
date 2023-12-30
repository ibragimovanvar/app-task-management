package com.ibragimov.apptaskmanagement.dao;

import com.ibragimov.apptaskmanagement.model.files.Attachment;
import com.ibragimov.apptaskmanagement.model.workspace.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AttachmentRepository extends JpaRepository<Attachment, UUID> {
}
