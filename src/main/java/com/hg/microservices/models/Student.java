package com.hg.microservices.models;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "\"StudentCourse\"",
            joinColumns =  @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(

                            name = "fk_student_course",
                            foreignKeyDefinition = "FOREIGN KEY (student_id)\n" +
                                    "        REFERENCES public.\"Students\" (id) MATCH SIMPLE\n" +
                                    "        ON UPDATE CASCADE\n" +
                                    "        ON DELETE CASCADE",
                            value = ConstraintMode.CONSTRAINT
                    )
            ),

            inverseJoinColumns =  @JoinColumn(
                    name = "course_key",
                    referencedColumnName = "key",
                    foreignKey = @ForeignKey(

                            name = "fk_course_student",
                            foreignKeyDefinition = "FOREIGN KEY (course_key)\n" +
                                    "        REFERENCES public.\"Courses\" (key) MATCH SIMPLE\n" +
                                    "        ON UPDATE CASCADE\n" +
                                    "        ON DELETE CASCADE",
                            value = ConstraintMode.CONSTRAINT
            )
    ),
            uniqueConstraints = @UniqueConstraint(name = "composite_key",columnNames = {"student_id","course_key"})

    )
    private List<Course> enrolled_courses;

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

    public List<Course> getEnrolled_courses() {
        return enrolled_courses;
    }

    public void setEnrolled_courses(List<Course> enrolled_courses) {
        this.enrolled_courses = enrolled_courses;
    }
}
