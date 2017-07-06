package com.school.data.entity.courses;

import com.school.data.entity.school.Room;
import com.school.data.entity.school.School;
import com.school.data.entity.students.Student;
import com.school.data.entity.workers.Worker;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description", length = 250)
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToMany
    @JoinTable(name = "course_student",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"))
    private Set<Student> students;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "worker_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn( name = "worker_id"))
    private Set<Worker> workers;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "rooms_courses",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn( name = "room_id"))
    private Set<Room> rooms;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "school_id", nullable = false)
    private School school;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private Set<PaymentCourse> paymentCourses;

    public Course() {
    }

    public Course(String title, String description, BigDecimal price, LocalDate startDate, LocalDate endDate, Set<Student> students, Set<Worker> workers, Set<Room> rooms, School school, Set<PaymentCourse> paymentCourses) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.students = students;
        this.workers = workers;
        this.rooms = rooms;
        this.school = school;
        this.paymentCourses = paymentCourses;
    }

    public void addStudent(Student student){
        if(this.students == null)
            this.students = new HashSet<>();

        if(this.students.add(student))
            student.addCourse(this);
    }

    public void addWorker(Worker worker){
        if(this.workers == null)
            this.workers = new HashSet<>();
        if(this.workers.add(worker))
            worker.addCourse(this);
    }

    public void addRoom(Room room){
        if(this.rooms == null)
            this.rooms = new HashSet<>();

        if(this.rooms.add(room))
            room.addCourse(this);
    }

    public void addPaymentCourse(PaymentCourse paymentCourse){
        if(this.paymentCourses == null)
            this.paymentCourses = new HashSet<>();

        paymentCourse.setCourse(this);
        this.paymentCourses.add(paymentCourse);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Set<PaymentCourse> getPaymentCourses() {
        return paymentCourses;
    }

    public void setPaymentCourses(Set<PaymentCourse> paymentCourses) {
        this.paymentCourses = paymentCourses;
    }
}
