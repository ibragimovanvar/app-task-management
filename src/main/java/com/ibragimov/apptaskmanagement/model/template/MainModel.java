package com.ibragimov.apptaskmanagement.model.template;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ibragimov.apptaskmanagement.model.userdetails.User;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.sql.Timestamp;

@Data
@MappedSuperclass
public class MainModel {

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    @JsonIgnore
    @JoinColumn(updatable = false)
    @CreatedBy
    @ManyToOne(fetch = FetchType.LAZY)
    private User createdBy;

    @JsonIgnore
    @LastModifiedBy
    @ManyToOne(fetch = FetchType.LAZY)
    private User updatedBy;




}
