package controller;

import service.my_class.ClassroomService;
import service.my_class.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "StudentServlet", value = "/student")
public class StudentServlet extends HttpServlet {
    private final StudentService studentService;
    private final ClassroomService classroomService;


    public StudentServlet() {
        studentService = new StudentService();
        classroomService = new ClassroomService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "edit":
                showEdit(request,response);
                break;
            default:
                listStudent(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    private void listStudent(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("listStudent", studentService.selectAll());
        request.setAttribute("listClassroom",classroomService.selectAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/display.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("student",studentService.findById(id));
        request.setAttribute("listClassroom",classroomService.selectAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
