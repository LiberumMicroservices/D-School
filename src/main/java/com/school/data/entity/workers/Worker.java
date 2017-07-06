package com.school.data.entity.workers;

import com.school.data.entity.courses.Course;
import com.school.data.entity.school.School;
import com.school.data.entity.workers.enums.WorkerStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "worker")
public class Worker {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id", length = 6, nullable = false)
    private long id;

    @Column(name = "f_name")
    private String fName;

    @Column(name = "l_name")
    private String lName;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "date_of_enrolment")
    private LocalDate dateOfEnrolment;

    @Column(name = "date_end_contract")
    private LocalDate dateEndContract;

    @Column(name = "address")
    private String address;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone1")
    private String phone1;

    @Column(name = "phone2")
    private String phone2;

    @Column(name = "description", length = 250)
    private String description;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private WorkerStatus status;

    @Column(name = "")
    private int rank;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "worker_course",
            joinColumns = @JoinColumn(name = "worker_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses;

    public void addCourse(Course course){
        if(this.courses == null)
            this.courses = new HashSet<>();

        if(this.courses.add(course))
            course.addWorker(this);
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "school_id", nullable = false)
    private School school;

    // финансовая информация по работнику
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "worker", cascade = CascadeType.ALL)
    private WorkerPayment workerPayment;

    public Worker() {
    }

    public Worker(String fName, String lName, LocalDate birthday, LocalDate dateOfEnrolment, LocalDate dateEndContract, String address, String email, String password, String phone1, String phone2, String description, WorkerStatus status, int rank, Set<Course> courses, School school, WorkerPayment workerPayment) {
        this.fName = fName;
        this.lName = lName;
        this.birthday = birthday;
        this.dateOfEnrolment = dateOfEnrolment;
        this.dateEndContract = dateEndContract;
        this.address = address;
        this.email = email;
        this.password = password;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.description = description;
        this.status = status;
        this.rank = rank;
        this.courses = courses;
        this.school = school;
        this.workerPayment = workerPayment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getDateOfEnrolment() {
        return dateOfEnrolment;
    }

    public void setDateOfEnrolment(LocalDate dateOfEnrolment) {
        this.dateOfEnrolment = dateOfEnrolment;
    }

    public LocalDate getDateEndContract() {
        return dateEndContract;
    }

    public void setDateEndContract(LocalDate dateEndContract) {
        this.dateEndContract = dateEndContract;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public WorkerStatus getStatus() {
        return status;
    }

    public void setStatus(WorkerStatus status) {
        this.status = status;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public WorkerPayment getWorkerPayment() {
        return workerPayment;
    }

    public void setWorkerPayment(WorkerPayment workerPayment) {
        this.workerPayment = workerPayment;
    }
}