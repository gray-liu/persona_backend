package com.thoughtworks.xbyi.persona.domain.entity;

import com.thoughtworks.xbyi.persona.infrastructure.BasePersistentObject;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="persona_demographic")
@Data
@EqualsAndHashCode(callSuper=false)
public class Demographic extends BasePersistentObject {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column
    private String name;

    @Column
    private Integer gender;

    @Column
    private Integer age;

    @Column
    private String telephone;

    @Column
    private String email;

    @Column
    private String address;
}
