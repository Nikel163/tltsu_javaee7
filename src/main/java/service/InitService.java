package service;

import entity.Course;
import entity.Specialty;
import entity.Student;
import entity.StudentGroup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class InitService {

    private final Random rd = new Random();

    private final CourseService courseService = new CourseService();
    private final SpecialtyService specialtyService = new SpecialtyService();
    private final StudentService studentService = new StudentService();
    private final StudentGroupService studentGroupService = new StudentGroupService();

    private final String[] firstNames = {"Harry","Ross", "Bruce","Cook", "Carolyn","Morgan", "Albert","Walker", "Randy",
            "Reed", "Larry","Barnes", "Lois","Wilson", "Jesse","Campbell", "Ernest","Rogers", "Theresa","Patterson",
            "Henry","Simmons", "Michelle","Perry", "Frank","Butler", "Shirley"};

    private final String[] patronymics = {"Brooks", "Rachel","Edwards", "Christopher","Perez", "Thomas","Baker", "Sara",
            "Moore", "Chris","Bailey", "Roger","Johnson", "Marilyn","Thompson", "Anthony","Evans", "Julie","Hall",
            "Paula","Phillips", "Annie","Hernandez", "Dorothy","Murphy", "Alice","Howard"};

    private final String[] lastNames = {"Ruth","Jackson", "Debra","Allen", "Gerald","Harris", "Raymond","Carter",
            "Jacqueline","Torres", "Joseph","Nelson", "Carlos","Sanchez", "Ralph","Clark", "Jean","Alexander",
            "Stephen","Roberts", "Eric","Long", "Amanda","Scott", "Teresa","Diaz", "Wanda","Thomas"};

    private Date startDate;
    private Date endDate;
    {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            startDate = sdf.parse("01-01-1997");
            endDate = sdf.parse("31-12-1999");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        studentService.clearTable();
        studentGroupService.clearTable();
        courseService.clearTable();
        specialtyService.clearTable();

        Course course1 = new Course(1, "1 course"); courseService.create(course1);
        Course course2 = new Course(2, "2 course"); courseService.create(course2);
        Course course3 = new Course(3, "3 course"); courseService.create(course3);
        Course course4 = new Course(4, "4 course"); courseService.create(course4);

        Specialty spec1 = new Specialty(1, "CT", "Communication Technology", "CommTech");
        Specialty spec2 = new Specialty(2, "CS", "Computer Science", "CompSci");
        Specialty spec3 = new Specialty(3, "CSaT", "Computer Science and Technology", "CompSciTech");
        Specialty spec4 = new Specialty(4, "EPE", "Electric Power Engineering", "ElecPowEng");
        Specialty spec5 = new Specialty(5, "MT", "Mobile Technology", "MobTech");
        Specialty spec6 = new Specialty(6, "TT", "Telecommunication Technology", "Telecom");
        Specialty spec7 = new Specialty(7, "ME", "Microelectronics", "Micro");
        Specialty spec8 = new Specialty(8, "IE", "Industrial Engineering", "IndEng");
        Specialty spec9 = new Specialty(9, "RT", "Robotics", "Robots");

        specialtyService.create(spec1);
        specialtyService.create(spec2);
        specialtyService.create(spec3);
        specialtyService.create(spec4);
        specialtyService.create(spec5);
        specialtyService.create(spec6);
        specialtyService.create(spec7);
        specialtyService.create(spec8);
        specialtyService.create(spec9);

        StudentGroup group1 = new StudentGroup(1, "CT-001", spec1);     studentGroupService.create(group1);
        StudentGroup group2 = new StudentGroup(2, "CT-002", spec1);     studentGroupService.create(group2);
        StudentGroup group3 = new StudentGroup(3, "CS-001", spec2);     studentGroupService.create(group3);
        StudentGroup group4 = new StudentGroup(4, "CS-002", spec2);     studentGroupService.create(group4);
        StudentGroup group5 = new StudentGroup(5, "CSaT-001", spec3);   studentGroupService.create(group5);
        StudentGroup group6 = new StudentGroup(6, "CSaT-002", spec3);   studentGroupService.create(group6);
        StudentGroup group7 = new StudentGroup(7, "EPE-001", spec4);    studentGroupService.create(group7);
        StudentGroup group8 = new StudentGroup(8, "MT-001", spec5);     studentGroupService.create(group8);
        StudentGroup group9 = new StudentGroup(9, "TT-001", spec6);     studentGroupService.create(group9);
        StudentGroup group10 = new StudentGroup(10, "TT-002", spec6);   studentGroupService.create(group10);
        StudentGroup group11 = new StudentGroup(11, "ME-001", spec7);   studentGroupService.create(group11);
        StudentGroup group12 = new StudentGroup(12, "IE-001", spec8);   studentGroupService.create(group12);
        StudentGroup group13 = new StudentGroup(13, "RT-001", spec9);   studentGroupService.create(group13);

        for (int i = 0; i < 6; i++) {
            studentService.create(new Student(group1, course1, getRandomLastName(), getRandomName(), getRandomPatronymic(), getRandomSer(), getRandomNum(), getRandomDate()));
            studentService.create(new Student(group2, course2, getRandomLastName(), getRandomName(), getRandomPatronymic(), getRandomSer(), getRandomNum(), getRandomDate()));
            studentService.create(new Student(group3, course1, getRandomLastName(), getRandomName(), getRandomPatronymic(), getRandomSer(), getRandomNum(), getRandomDate()));
            studentService.create(new Student(group4, course2, getRandomLastName(), getRandomName(), getRandomPatronymic(), getRandomSer(), getRandomNum(), getRandomDate()));
            studentService.create(new Student(group5, course3, getRandomLastName(), getRandomName(), getRandomPatronymic(), getRandomSer(), getRandomNum(), getRandomDate()));
            studentService.create(new Student(group6, course3, getRandomLastName(), getRandomName(), getRandomPatronymic(), getRandomSer(), getRandomNum(), getRandomDate()));
            studentService.create(new Student(group7, course4, getRandomLastName(), getRandomName(), getRandomPatronymic(), getRandomSer(), getRandomNum(), getRandomDate()));
            studentService.create(new Student(group8, course1, getRandomLastName(), getRandomName(), getRandomPatronymic(), getRandomSer(), getRandomNum(), getRandomDate()));
            studentService.create(new Student(group9, course2, getRandomLastName(), getRandomName(), getRandomPatronymic(), getRandomSer(), getRandomNum(), getRandomDate()));
            studentService.create(new Student(group10, course3, getRandomLastName(), getRandomName(), getRandomPatronymic(), getRandomSer(), getRandomNum(), getRandomDate()));
            studentService.create(new Student(group11, course4, getRandomLastName(), getRandomName(), getRandomPatronymic(), getRandomSer(), getRandomNum(), getRandomDate()));
            studentService.create(new Student(group12, course2, getRandomLastName(), getRandomName(), getRandomPatronymic(), getRandomSer(), getRandomNum(), getRandomDate()));
            studentService.create(new Student(group13, course3, getRandomLastName(), getRandomName(), getRandomPatronymic(), getRandomSer(), getRandomNum(), getRandomDate()));
        }

    }

    public String getRandomName() {
        return firstNames[rd.nextInt(firstNames.length)];
    }

    public String getRandomLastName() {
        return lastNames[rd.nextInt(lastNames.length)];
    }

    public String getRandomPatronymic() {
        return patronymics[rd.nextInt(patronymics.length)];
    }

    public int getRandomSer() {
        return rd.nextInt(8999) + 1000;
    }

    public int getRandomNum() {
        return rd.nextInt(899999) + 100000;
    }

    public Date getRandomDate() {
        long start = startDate.getTime();
        long end = endDate.getTime();
        long randomTime = ThreadLocalRandom.current().nextLong(start, end);
        return new Date(randomTime);
    }
}
