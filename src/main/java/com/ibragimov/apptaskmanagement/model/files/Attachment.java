package com.ibragimov.apptaskmanagement.model.files;


import com.ibragimov.apptaskmanagement.model.template.UUIDModel;
import jakarta.persistence.Column;
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
public class Attachment extends UUIDModel {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String originalName;

    @Column(nullable = false)
    private Long size;

    @Column(nullable = false)
    private String contentType;

}
