package com.ibragimov.apptaskmanagement.model;

import com.ibragimov.apptaskmanagement.model.template.UUIDModel;
import jakarta.persistence.Entity;
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
}
