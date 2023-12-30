package com.ibragimov.apptaskmanagement.service.template;

import com.ibragimov.apptaskmanagement.api.request.payload.WorkspaceBody;
import com.ibragimov.apptaskmanagement.api.request.payload.MemberBody;
import com.ibragimov.apptaskmanagement.api.request.payload.WorkspacePermissionBody;
import com.ibragimov.apptaskmanagement.api.request.payload.WorkspaceRoleBody;
import com.ibragimov.apptaskmanagement.api.response.ApiResponse;
import com.ibragimov.apptaskmanagement.exception.WorkspaceExistException;
import com.ibragimov.apptaskmanagement.model.userdetails.User;
import com.ibragimov.apptaskmanagement.model.workspace.Workspace;

import java.util.List;
import java.util.UUID;

public interface WorkspaceService {

    ApiResponse addWorkspace(WorkspaceBody workspaceBody, User user) throws WorkspaceExistException;

    ApiResponse updateWorkspace(Long id, WorkspaceBody workspaceBody, User user);

    ApiResponse deleteWorkspace(Long id);

    ApiResponse changeOwnerWorkspace(Long id, UUID ownerId, User user);

    ApiResponse addOrEditOrRemove(Long id, MemberBody memberBody);

    ApiResponse joinToWorkspace(Long id, User user);
    List<MemberBody> viewMembersOrGuests(Long workspaceId, User user);

    List<Workspace> viewWorkspaces(User user);

    ApiResponse addRoleToWorkspace(WorkspaceRoleBody roleBody, User user);
    ApiResponse addPermissionToRole(WorkspacePermissionBody permissionBody, User user);
    ApiResponse deletePermissionFromRole(WorkspacePermissionBody permissionBody, User user);

}
