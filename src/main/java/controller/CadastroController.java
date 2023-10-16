package controller;

import DAO.UserDAO;
import entity.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/Cadastro", "/main", "/insertUsuario", "/selectUsuario", "/updateUsuario", "/deleteUsuario"})
public class CadastroController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    User user = new User();

    UserDAO userDAO = new UserDAO();

    public CadastroController() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();

        if (action.equals("/main")) {
            listarUsuarios(req, resp);
        } else if (action.equals("/insertUsuario")) {
            novoUser(req, resp);
        } else if (action.equals("/deleteUsuario")) {
            deletarUsuario(req, resp);
        } else if(action.equals("/selectUsuario")){
            selectUsuarios(req, resp);
        } else if(action.equals("/updateUsuario")) {
            updateUsuarios(req, resp);
        } else {
            resp.sendRedirect("error404.jsp");
        }

    }

    protected void listarUsuarios(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<User> list = userDAO.listDeUsuarios();

        System.out.println(list);

        req.setAttribute("users", list);
        RequestDispatcher rd = req.getRequestDispatcher("usuario.jsp");
        rd.forward(req, resp);
        System.out.println(req);
        System.out.println(resp);
    }

    protected void novoUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            user.setNome(req.getParameter("nome"));
            user.setProfissao(req.getParameter("profissao"));
            user.setIdade(Integer.parseInt(req.getParameter("idade")));

            userDAO.inserirUser(user);

            resp.sendRedirect("main");
    }

    protected void updateUsuarios(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user.setCod_registro(Long.parseLong(req.getParameter("cod_registro")));
        user.setNome(req.getParameter("nome"));
        user.setProfissao(req.getParameter("profissao"));
        user.setIdade(Integer.parseInt(req.getParameter("idade")));

        userDAO.updateUser(user);

        resp.sendRedirect("main");
    }

    protected void selectUsuarios(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long cod_id = Long.parseLong(req.getParameter("cod_registro"));

        user.setCod_registro(cod_id);

        userDAO.selectUser(user);

        req.setAttribute("cod_registro", user.getCod_registro());
        req.setAttribute("nome", user.getIdade());
        req.setAttribute("profissao", user.getNome());
        req.setAttribute("idade", user.getProfissao());

        RequestDispatcher rd = req.getRequestDispatcher("edit.jsp");
        rd.forward(req, resp);
    }

    protected void deletarUsuario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long cod_id = Long.parseLong(req.getParameter("cod_registro"));

        user.setCod_registro(cod_id);

        userDAO.deletarUsuariosDB(user);

        resp.sendRedirect("main");
    }
}
