package com.acadpendragon.system.dto;

import com.acadpendragon.system.entities.User;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

public class UserDTO {

    private Long id;
    private String nome;
    private String email;
    private boolean pagamento;
    private LocalDate registrationDate;
    private Integer timeSinceRegistration;
    private String turma;

    public UserDTO(User user) {
        BeanUtils.copyProperties(user, this);
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPagamento() {
        return pagamento;
    }

    public void setPagamento(boolean pagamento) {
        this.pagamento = pagamento;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getTimeSinceRegistration() {
        return timeSinceRegistration;
    }

    public void setTimeSinceRegistration(Integer timeSinceRegistration) {
        this.timeSinceRegistration = timeSinceRegistration;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }
}