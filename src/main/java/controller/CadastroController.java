package controller;

import DAO.UserDAO;
import conexao.Conexao;
import entity.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/Cadastro", "/main", "/insertUsuario", "/deleteUsuario"})
public class CadastroController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    //Conexao conexao = new Conexao();
    User user = new User();

    UserDAO userDAO = new UserDAO();

    public CadastroController() {
        super();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().append("list");
        String action = req.getServletPath();

        if (action.equals("/main")) {
            listarUsuarios(req, resp);
        } else if (action.equals("/insertUsuario")) {
            novoUser(req, resp);
        } else if (action.equals("/deleteUsuario")) {
            deletarUsuario(req, resp);
        } else {
            resp.sendRedirect("error404.jsp");
        }
    }

    protected void listarUsuarios(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<User> list = userDAO.listDeUsuarios();

        req.setAttribute("usuarios", list);
        RequestDispatcher rd = req.getRequestDispatcher("usuario.jsp");
        rd.forward(req, resp);
    }

    protected void novoUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user.setNome(req.getParameter("nome"));
        user.setProfissao(req.getParameter("profissao"));
        user.setIdade(Integer.parseInt(req.getParameter("idade")));

        userDAO.inserirUser(user);

        resp.sendRedirect("main");
    }

    protected void deletarUsuario(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer cod_id = Integer.parseInt(req.getParameter("cod_registro"));

        user.setCod_registro(cod_id);

        userDAO.deletarUsuariosDB(user);

        resp.sendRedirect("main");
    }
}
