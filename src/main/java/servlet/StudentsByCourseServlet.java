package servlet;

import entity.Course;
import entity.Specialty;
import entity.Student;
import entity.StudentGroup;
import service.CourseService;
import service.SpecialtyService;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/st_course")
public class StudentsByCourseServlet extends HttpServlet {

    CourseService courseService = new CourseService();
    StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Course> allCourses = courseService.findAll();
        req.setAttribute("allCourses", allCourses);
        req.getRequestDispatcher("students_by_course.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int courseId = Integer.parseInt(req.getParameter("courseId"));
        List<Student> students = studentService.findStudentsByCourseId(courseId);
        req.setAttribute("students", students);
        doGet(req, resp);
    }
}
