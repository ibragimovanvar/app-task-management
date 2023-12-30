package com.ibragimov.apptaskmanagement.model.template;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@MappedSuperclass
public abstract class UUIDModel extends MainModel {

    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4",strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

}
