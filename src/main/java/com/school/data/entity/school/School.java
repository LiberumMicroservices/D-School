package com.school.data.entity.school;

import com.school.data.entity.courses.Course;
import com.school.data.entity.students.Student;
import com.school.data.entity.workers.Worker;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "school")
public class School {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description", length = 250)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    private Set<Student> students;

    public void addStudent(Student student){
        if(this.students == null)
            this.students = new HashSet<>();

        student.setSchool(this);
        this.students.add(student);
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    private Set<Worker> workers;

    public void addWorker(Worker worker){
        if(this.workers == null)
            this.workers = new HashSet<>();

        worker.setSchool(this);
        this.workers.add(worker);
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    private Set<Room> rooms;

    private void addRoom(Room room){
        if(this.rooms == null)
            this.rooms = new HashSet<>();

        room.setSchool(this);
        this.rooms.add(room);
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "school")
    private Set<Course> courses;

    public void addCourse(Course course){
        if(this.courses == null)
            this.courses = new HashSet<>();
        course.setSchool(this);
        this.courses.add(course);
    }

    public School() {
    }

    public School(String name, String description, Set<Student> students, Set<Worker> workers, Set<Room> rooms, Set<Course> courses) {
        this.name = name;
        this.description = description;
        this.students = students;
        this.workers = workers;
        this.rooms = rooms;
        this.courses = courses;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(Set<Worker> workers) {
        this.workers = workers;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
