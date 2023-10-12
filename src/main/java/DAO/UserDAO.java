package DAO;

import conexao.Conexao;
import entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO {

    Conexao conexao = new Conexao();

    // CRUD CREATE
    public void inserirUser(User user){

        String sqlCreate = "INSERT INTO registro (nome, profissao, idade) VALUES (?, ?, ?)";

        try {
            Connection conn = conexao.conexao();
            PreparedStatement ps = conn.prepareStatement(sqlCreate);
            ps.setString(1, user.getNome());
            ps.setString(2, user.getProfissao());
            ps.setInt(3, user.getIdade());

            ps.executeUpdate();
            ps.close();

        } catch (Exception e){
            System.out.println(e);
        }
    }

    // CRUD READ
    public ArrayList<User> listDeUsuarios() {
        ArrayList<User> usuarios = new ArrayList<>();

        String sqlRead = "SELECT * FROM registro ORDER BY nome";

        try {
            Connection conn = conexao.conexao();
            PreparedStatement ps = conn.prepareStatement(sqlRead);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Integer cod_registro = Integer.parseInt(rs.getString(1));
                String nome = rs.getString(2);
                String profissao = rs.getString(3);
                Integer idade = Integer.parseInt(rs.getString(4));

                usuarios.add(new User(cod_registro, nome, profissao, idade));
            }

            conn.close();
            return usuarios;

        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    // CRUD DELETE
    public void deletarUsuariosDB(User user){
        String sqlDelete = "DELETE FROM registro WHERE cod_registro=?";

        try {
            Connection conn = conexao.conexao();
            PreparedStatement ps = conn.prepareStatement(sqlDelete);
            ps.setInt(1, user.getCod_registro());
            ps.executeUpdate();

            conn.close();

        } catch (Exception e){
            System.out.println(e);
        }
    }

}
