package com.school.data.entity.school;

import com.school.data.entity.courses.Course;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "address")
    private String address;

    @Column(name = "description", length = 250)
    private String description;

    @Column(name = "tenancy_price")
    private int tenancyPrice;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "school_id", nullable = false)
    private School school;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "rooms_courses",
            joinColumns = @JoinColumn(name = "room_id"),
            inverseJoinColumns = @JoinColumn( name = "course_id"))
    private Set<Course> courses;

    public void addCourse(Course course){
        if(this.courses == null)
            courses = new HashSet<>();

        if(this.courses.add(course))
            course.addRoom(this);
    }

    public Room() {
    }

    public Room(String title, String address, String description, int tenancyPrice, School school, Set<Course> courses) {
        this.title = title;
        this.address = address;
        this.description = description;
        this.tenancyPrice = tenancyPrice;
        this.school = school;
        this.courses = courses;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTenancyPrice() {
        return tenancyPrice;
    }

    public void setTenancyPrice(int tenancyPrice) {
        this.tenancyPrice = tenancyPrice;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
