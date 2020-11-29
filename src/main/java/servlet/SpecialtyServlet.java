package servlet;

import entity.Specialty;
import service.SpecialtyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/specs")
public class SpecialtyServlet extends HttpServlet {

    private final SpecialtyService specialtyService = new SpecialtyService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Specialty> allSpecs = specialtyService.findAll();
        req.setAttribute("allSpecs", allSpecs);
        req.getRequestDispatcher("specs.jsp").forward(req, resp);
    }
}
