package com.cadastro.usuarios.domain.model;
import com.cadastro.usuarios.domain.enums.Role;

public class User {

    private Long id;
    private String name;
    private String email;
    private Role role;
    private Boolean activo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public User(Long id, String name, String email, Role role, Boolean activo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.activo = activo;
    }
}
