package com.ibragimov.apptaskmanagement.service;

import com.ibragimov.apptaskmanagement.api.request.payload.MemberBody;
import com.ibragimov.apptaskmanagement.api.request.payload.WorkspaceBody;
import com.ibragimov.apptaskmanagement.api.request.payload.WorkspacePermissionBody;
import com.ibragimov.apptaskmanagement.api.request.payload.WorkspaceRoleBody;
import com.ibragimov.apptaskmanagement.api.response.ApiResponse;
import com.ibragimov.apptaskmanagement.dao.*;
import com.ibragimov.apptaskmanagement.exception.WorkspaceExistException;
import com.ibragimov.apptaskmanagement.model.enums.WorkspacePermissionName;
import com.ibragimov.apptaskmanagement.model.enums.WorkspaceRoleName;
import com.ibragimov.apptaskmanagement.model.userdetails.User;
import com.ibragimov.apptaskmanagement.model.workspace.Workspace;
import com.ibragimov.apptaskmanagement.model.workspace.WorkspacePermission;
import com.ibragimov.apptaskmanagement.model.workspace.WorkspaceRole;
import com.ibragimov.apptaskmanagement.model.workspace.WorkspaceUser;
import com.ibragimov.apptaskmanagement.service.template.WorkspaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
@RequiredArgsConstructor
public class WorkspaceServiceImpl implements WorkspaceService {


    private final WorkspaceRepository workspaceRepository;
    private final AttachmentRepository attachmentRepository;
    private final WorkspaceRoleRepository workspaceRoleRepository;
    private final WorkspacePermissionRepository workspacePermissionRepository;
    private final WorkspaceUserRepository workspaceUserRepository;
    private final UserRepository userRepository;

    /**
     * @param workspace - workspace, which will be created
     * @param user      - user, who created workspace
     *                  what this method does - creates workspace and assigns roles and permissions
     */

    private void assignRolesAndPermissions(Workspace workspace, User user) {
        WorkspaceRole ownerRole = workspaceRoleRepository.save(new WorkspaceRole(workspace, WorkspaceRoleName.ROLE_OWNER.toString(), null));
        WorkspaceRole adminRole = workspaceRoleRepository.save(new WorkspaceRole(workspace, WorkspaceRoleName.ROLE_ADMIN.toString(), null));
        WorkspaceRole memberRole = workspaceRoleRepository.save(new WorkspaceRole(workspace, WorkspaceRoleName.ROLE_MEMBER.toString(), null));
        WorkspaceRole guestRole = workspaceRoleRepository.save(new WorkspaceRole(workspace, WorkspaceRoleName.ROLE_GUEST.toString(), null));

        WorkspacePermissionName[] permissionNames = WorkspacePermissionName.values();

        List<WorkspacePermission> workspacePermissionList = new ArrayList<>();

        for (WorkspacePermissionName permissionName : permissionNames) {
            workspacePermissionList.add(new WorkspacePermission(ownerRole, permissionName));
            if (permissionName.getWorkspaceRoleNames().contains(WorkspaceRoleName.ROLE_ADMIN))
                workspacePermissionList.add(new WorkspacePermission(adminRole, permissionName));
            if (permissionName.getWorkspaceRoleNames().contains(WorkspaceRoleName.ROLE_MEMBER))
                workspacePermissionList.add(new WorkspacePermission(memberRole, permissionName));
            if (permissionName.getWorkspaceRoleNames().contains(WorkspaceRoleName.ROLE_GUEST))
                workspacePermissionList.add(new WorkspacePermission(guestRole, permissionName));
        }

        workspacePermissionRepository.saveAll(workspacePermissionList);
        WorkspaceUser workspaceUser = new WorkspaceUser(workspace, user, ownerRole, new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis()));
        workspaceUserRepository.save(workspaceUser);
    }

    /**
     * @param workspaceBody - request body, contains workspace name, color and avatar
     * @param user          - current user, which creates workspace
     * @return - response with additional data
     * @throws WorkspaceExistException - if workspace with this name already exists
     */

    @Override
    public ApiResponse addWorkspace(WorkspaceBody workspaceBody, User user) throws WorkspaceExistException {

        // Check if workspace with this name already exists
        if (workspaceRepository.existsByOwnerIdAndName(user.getId(), workspaceBody.getName())) {
            throw new WorkspaceExistException("Workspace with this name already exists");
        }

        // Create workspace
        Workspace workspace = new Workspace();
        workspace.setName(workspaceBody.getName());
        workspace.setColor(workspaceBody.getColor());
        workspace.setOwner(user);
        assert workspaceBody.getAvatarId() != null;
        workspace.setAvatar(attachmentRepository.findById(workspaceBody.getAvatarId()).orElse(null));
        workspaceRepository.save(workspace);

        // Assign roles and permissions
        assignRolesAndPermissions(workspace, user);

        // Add additional data
        Map<Object, Object> additionalData = new HashMap<>();
        additionalData.put("workspaceId", workspace.getId());

        // Return response
        return new ApiResponse("Workspace successfully created", true, additionalData);
    }

    @Override
    public ApiResponse updateWorkspace(Long id, WorkspaceBody workspaceBody, User user) {

        return null;
    }

    @Override
    public ApiResponse deleteWorkspace(Long id) {
        return null;
    }

    @Override
    public ApiResponse changeOwnerWorkspace(Long id, UUID ownerId, User user) {
        return null;
    }

    @Override
    public ApiResponse addOrEditOrRemove(Long id, MemberBody memberBody) {
        return null;
    }

    @Override
    public ApiResponse joinToWorkspace(Long id, User user) {
        return null;
    }

    @Override
    public List<MemberBody> viewMembersOrGuests(Long workspaceId, User user) {
        return null;
    }

    @Override
    public List<Workspace> viewWorkspaces(User user) {
        return null;
    }

    @Override
    public ApiResponse addRoleToWorkspace(WorkspaceRoleBody roleBody, User user) {
        return null;
    }

    @Override
    public ApiResponse addPermissionToRole(WorkspacePermissionBody permissionBody, User user) {
        return null;
    }

    @Override
    public ApiResponse deletePermissionFromRole(WorkspacePermissionBody permissionBody, User user) {
        return null;
    }
}
