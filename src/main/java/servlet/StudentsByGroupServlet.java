package servlet;

import entity.Student;
import entity.StudentGroup;
import service.StudentGroupService;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/st_group")
public class StudentsByGroupServlet extends HttpServlet {

    StudentGroupService studentGroupService = new StudentGroupService();
    StudentService studentService = new StudentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<StudentGroup> allGroups = studentGroupService.findAll();
        req.setAttribute("allGroups", allGroups);
        req.getRequestDispatcher("students_by_group.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int groupId = Integer.parseInt(req.getParameter("groupId"));
        List<Student> students = studentService.findStudentsByGroupId(groupId);
        req.setAttribute("students", students);
        doGet(req, resp);
    }
}
