package servlet;

import entity.Specialty;
import entity.StudentGroup;
import service.SpecialtyService;
import service.StudentGroupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/groups")
public class StudentGroupServlet extends HttpServlet {

    SpecialtyService specialtyService = new SpecialtyService();
    StudentGroupService studentGroupService = new StudentGroupService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Specialty> allSpecs = specialtyService.findAll();
        req.setAttribute("allSpecs", allSpecs);
        req.getRequestDispatcher("groups.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int specialtyId = Integer.parseInt(req.getParameter("specialtyId"));
        List<StudentGroup> groups = studentGroupService.findGroupsBySpecialtyId(specialtyId);
        req.setAttribute("groups", groups);
        doGet(req, resp);
    }
}
