package com.ibragimov.apptaskmanagement.api.request.payload;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkspaceBody {

    @NotBlank
    private String name;

    @NotBlank
    private String color;

    @Nullable
    private UUID avatarId;

}
