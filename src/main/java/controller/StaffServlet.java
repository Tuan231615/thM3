package controller;

import model.Staff;
import service.StaffService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StaffServlet", value = "/staffs")
public class StaffServlet extends HttpServlet {

   private StaffService staffService = new StaffService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                showFormCreate(request, response);
                break;
            case "edit":
                showFormEdit(request, response);
                break;
            case "delete":
                showFormDelete(request, response);
                break;
            default:
                list(request, response);
                break;
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showFormDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/delete.jsp");
        request.setAttribute("staff", staff);
        dispatcher.forward(request, response);
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.findById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/edit.jsp");
        request.setAttribute("staff", staff);
        dispatcher.forward(request, response);
    }

    private void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Staff> staff = staffService.findAll();
        request.setAttribute("staffs", staff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createStaff(request, response);
                break;
            case "edit":
                editStaff(request, response);
                break;
            case "delete":
                deleteStaff(request, response);
                break;
        }
    }

    private void deleteStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        staffService.remove(id);
        List<Staff> staff = staffService.findAll();
        request.setAttribute("staff", staff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/delete.jsp");
        dispatcher.forward(request, response);
    }

    private void editStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        double salary = Double.parseDouble(request.getParameter("salary"));
        int id_der = Integer.parseInt(request.getParameter("id_der"));
        Staff staff = new Staff(id, name, email, address, phoneNumber, salary, id_der);
        staffService.update(id, staff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void createStaff(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        double salary = Double.parseDouble(request.getParameter("salary"));
        int id_der = Integer.parseInt(request.getParameter("id_der"));
        Staff staff = new Staff(id, name, email, address, phoneNumber, salary, id_der);
        staffService.save(staff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/create.jsp");
        dispatcher.forward(request, response);
    }
}
