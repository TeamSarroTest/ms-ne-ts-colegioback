package com.hg.microservices.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "Student")
@Table(name="\"Students\"", schema="public")
@OnDelete(action= OnDeleteAction.CASCADE)
@PrimaryKeyJoinColumn(name="id",foreignKey = @ForeignKey(name="fk_student_person"))
public class Student extends Person implements Serializable {

    private static final long serialVersionUID=1L;

    @Column(name="schoolarship",columnDefinition = "boolean DEFAULT 'false'")
    private Boolean schoolarship= false;

    //State=1, Inscrito:2, Retirado:3, Graduado, etc
    @Column(name="state", columnDefinition="integer DEFAULT '1'")
    private Integer state =1;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Boolean getSchoolarship() {
        return schoolarship;
    }

    public void setSchoolarship(Boolean schoolarship) {
        this.schoolarship = schoolarship;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
