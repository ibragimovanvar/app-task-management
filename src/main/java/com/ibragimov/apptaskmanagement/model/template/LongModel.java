package com.ibragimov.apptaskmanagement.model.template;

import jakarta.persistence.*;
import lombok.Data;


@Data
@MappedSuperclass
public abstract class LongModel extends MainModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
