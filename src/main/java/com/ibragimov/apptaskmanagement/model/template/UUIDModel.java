package com.ibragimov.apptaskmanagement.model.template;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@MappedSuperclass
public abstract class AbsLongModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
