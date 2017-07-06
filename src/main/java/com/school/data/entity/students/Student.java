package com.school.data.entity.students;

import com.school.data.entity.courses.Course;
import com.school.data.entity.school.School;
import com.school.data.entity.students.enums.StudentStatus;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student {

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

    @Column(name = "address")
    private String address;

    @Column(name = "email")
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
    private StudentStatus status;

    @Column(name = "rank")
    private int rank;

    @ManyToMany
    @JoinTable(name = "course_student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses;

    public void addCourse(Course course){
        if(this.courses == null)
            this.courses = new HashSet<>();

        if(this.courses.add(course))
            course.addStudent(this);
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private Set<ResponsiblePerson> responsiblePersons;

    public void addResponsiblePerson(ResponsiblePerson responsiblePerson) {
        if(this.responsiblePersons == null)
            this.responsiblePersons = new HashSet<>();

        responsiblePerson.setStudent(this);
        this.responsiblePersons.add(responsiblePerson);
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "school_id", nullable = false)
    private School school;


    @OneToOne(fetch = FetchType.LAZY, mappedBy = "student", cascade = CascadeType.ALL)
    private StudentPayment studentPayment;

    public Student() {
    }

    public Student(String fName, String lName, LocalDate birthday, LocalDate dateOfEnrolment, String address, String email, String password, String phone1, String phone2, String description, StudentStatus status, int rank, Set<Course> courses, Set<ResponsiblePerson> responsiblePersons, School school, StudentPayment studentPayment) {
        this.fName = fName;
        this.lName = lName;
        this.birthday = birthday;
        this.dateOfEnrolment = dateOfEnrolment;
        this.address = address;
        this.email = email;
        this.password = password;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.description = description;
        this.status = status;
        this.rank = rank;
        this.courses = courses;
        this.responsiblePersons = responsiblePersons;
        this.school = school;
        this.studentPayment = studentPayment;
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

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
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

    public Set<ResponsiblePerson> getResponsiblePersons() {
        return responsiblePersons;
    }

    public void setResponsiblePersons(Set<ResponsiblePerson> responsiblePersons) {
        this.responsiblePersons = responsiblePersons;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public StudentPayment getStudentPayment() {
        return studentPayment;
    }

    public void setStudentPayment(StudentPayment studentPayment) {
        this.studentPayment = studentPayment;
    }
}