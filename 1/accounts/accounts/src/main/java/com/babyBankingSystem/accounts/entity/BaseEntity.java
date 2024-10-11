package com.babyBankingSystem.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Auditable;

import java.util.Date;

@EntityListeners(Auditable.class)
@ToString
@Setter
@Getter
public class BaseEntity {

    private String createdBy;
    private Date createdAt;
    private String updatedBy;
}
