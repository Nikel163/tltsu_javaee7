package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Data
@Table(name = "students")
@NoArgsConstructor
public class Student implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private StudentGroup group;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @Column(name = "f")
    private String f;

    @Column(name = "i")
    private String i;

    @Column(name = "o")
    private String o;

    @Column(name = "passport_ser")
    private Integer passportSer;

    @Column(name = "passport_num")
    private Integer passportNum;

    @Column(name = "born_date")
    private Date bornDate;

    public Student(StudentGroup group, Course course, String f, String i, String o,
                   Integer passportSer, Integer passportNum, Date bornDate) {
        this.group = group;
        this.course = course;
        this.f = f;
        this.i = i;
        this.o = o;
        this.passportSer = passportSer;
        this.passportNum = passportNum;
        this.bornDate = bornDate;
    }

    public String bornDateToString() {
        return new SimpleDateFormat("dd-MM-yyyy").format(bornDate);
    }
}
