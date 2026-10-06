package com.domain;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass 
@Getter 
@Setter 
public abstract class Auditable{
    @Column (updatable = false)
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    @Column (updatable = false)
    private String creadoPor;
    private String modificadoPor;
    private Boolean eliminado;

    @PrePersist 
    public void AntesDeCrear() {
        this.fechaCreacion = LocalDateTime.now();
        this.creadoPor = "SISTEMA";
        this.eliminado = false;
    }
    @PreUpdate 
    public void AntesDeActualizar() {
        this.fechaModificacion = LocalDateTime.now();
        this.modificadoPor = "SISTEMA";
    }

}
