package com.br.library.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column
    private Boolean active = true;

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @PrePersist
    private void createEntity() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = createdAt;
    }

    @PreUpdate
    private void updateEntity() {
        this.updatedAt = LocalDateTime.now();
    }
}
