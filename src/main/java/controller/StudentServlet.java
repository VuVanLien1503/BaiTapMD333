package controller;

import model.Student;
import service.my_class.ClassroomService;
import service.my_class.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
            case "create":
                showCreate(request,response);
                break;
            case "edit":
                showEdit(request, response);
                break;
            case "delete":
                showDelete(request, response);
                break;
            default:
                listStudent(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request,response);
                break;
            case "edit":
                editStudent(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "search":
                search(request,response);
                break;
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        Date date1 = null;

//        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        int classroom_id = Integer.parseInt(request.getParameter("classroom"));

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date1 = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Student student = new Student( name, date1, address, phone, email, classroom_id);
        studentService.create(student);
        request.setAttribute("message", "Tao Thanh cong");
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
            request.setAttribute("listClassroom",classroomService.selectAll());
            RequestDispatcher dispatcher=request.getRequestDispatcher("views/create.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("student", studentService.findById(id));
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/delete.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String value = request.getParameter("search");
        List<Student> list = studentService.findByName("%"+value+"%");
        request.setAttribute("listStudent", list);
        request.setAttribute("listClassroom", classroomService.selectAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/display.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        studentService.delete(id);
        try {
            response.sendRedirect("/student");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editStudent(HttpServletRequest request, HttpServletResponse response) {
        Date date1 = null;

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        int classroom_id = Integer.parseInt(request.getParameter("classroom"));

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date1 = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Student student = new Student(id, name, date1, address, phone, email, classroom_id);
        studentService.update(student);
        request.setAttribute("message", "Cập Nhật Thành Công");
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void listStudent(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("listStudent", studentService.selectAll());
        request.setAttribute("listClassroom", classroomService.selectAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/display.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private void showEdit(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("student", studentService.findById(id));
        request.setAttribute("listClassroom", classroomService.selectAll());
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
