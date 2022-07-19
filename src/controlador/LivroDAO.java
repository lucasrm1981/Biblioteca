/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Livro;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LivroDAO {

    private Connection connection;
    Long id_livro;
    int quantidade;
    String titulo,
            autor,
            categoria,
            editora,
            edicao,
            isbn,
            status,
            corredor,
            prateleira;

    public LivroDAO() {
        this.connection = new ConnectionDB().getConnection();
    }

    public void salvar(Livro objLivro) {
        try {
            String sql;
            /* Caso nao venha um valor no ID ele adiciona um novo livro e caso passe um ID valido atualiza os dados de acordo como ID recebido*/
            if (String.valueOf(objLivro.getId_Livro()).isEmpty()) {
                sql = "INSERT INTO livros (id_livro,titulo,autor,categoria,editora,edicao,isbn,quantidade,status,corredor,prateleira) VALUES(null,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, objLivro.getTitulo());
                stmt.setString(2, objLivro.getAutor());
                stmt.setString(3, objLivro.getCategoria());
                stmt.setString(4, objLivro.getEditora());
                stmt.setString(5, objLivro.getEdicao());
                stmt.setString(6, objLivro.getIsbn());
                stmt.setString(7, objLivro.getQuantidade());
                stmt.setString(8, objLivro.getStatus().toUpperCase());// Converte a Stgring em Maiuscula
                stmt.setString(9, objLivro.getCorredor().toUpperCase());// Converte a Stgring em Maiuscula
                stmt.setString(10, objLivro.getPrateleira().toUpperCase());// Converte a Stgring em Maiuscula
                stmt.execute();
                stmt.close();

            } else {
                sql = "UPDATE livros SET titulo = ?, autor = ?, categoria = ?, editora = ?, edicao = ?, isbn = ?, quantidade = ?, status = ?, corredor = ?, prateleira = ? WHERE livros.id_livro = ?";

                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(11, objLivro.getId_Livro());
                stmt.setString(1, objLivro.getTitulo());
                stmt.setString(2, objLivro.getAutor());
                stmt.setString(3, objLivro.getCategoria());
                stmt.setString(4, objLivro.getEditora());
                stmt.setString(5, objLivro.getEdicao());
                stmt.setString(6, objLivro.getIsbn());
                stmt.setString(7, objLivro.getQuantidade());
                stmt.setString(8, objLivro.getStatus());
                stmt.setString(9, objLivro.getCorredor());
                stmt.setString(10, objLivro.getPrateleira());

                stmt.execute();
                stmt.close();

            }
        } catch (SQLException u) {
            //throw new RuntimeException(u);
            u.getMessage();
            JOptionPane.showMessageDialog(null, "Você digitou um Número Inválido.", "Dado Inválido!!", JOptionPane.ERROR_MESSAGE);
            
            System.exit(0);// Finalizando o Sistema
        }
    }

    public ArrayList buscar(Livro objLivro) {
        try {
            String sql = "";
            if (!objLivro.getTitulo().isEmpty()) {
                sql = "SELECT * FROM livros WHERE titulo LIKE '%" + objLivro.getTitulo() + "%'  ";

            } else if (!objLivro.getAutor().isEmpty()) {
                sql = "SELECT * FROM livros WHERE autor LIKE '%" + objLivro.getAutor() + "%' ";
            } else if (!objLivro.getEdicao().isEmpty()) {
                sql = "SELECT * FROM livros WHERE edicao LIKE '%" + objLivro.getEdicao() + "%' ";
            }
            ArrayList dado = new ArrayList();

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                dado.add(new Object[]{
                    rs.getInt("id_livro"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getString("categoria"),
                    rs.getString("editora"),
                    rs.getString("edicao"),
                    rs.getString("isbn"),
                    rs.getString("quantidade"),
                    rs.getString("status"),
                    rs.getString("corredor"),
                    rs.getString("prateleira")
                });

            }
            ps.close();
            rs.close();
            connection.close();

            return dado;
        } catch (SQLException e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, "Erro preencher o ArrayList buscar", "Listagem", JOptionPane.ERROR_MESSAGE);
            return null;
        }

    }

    public void deletar(Livro objLivro) {
        try {
            String sql;
            if (!String.valueOf(objLivro.getId_Livro()).isEmpty()) {
                sql = "DELETE FROM livros WHERE livros.id_livro = ?";
                PreparedStatement stmt = connection.prepareStatement(sql);

                stmt.setString(1, objLivro.getId_Livro());
                stmt.execute();
                stmt.close();

            }
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

    public ArrayList listarTodos() {
        try {

            ArrayList dado = new ArrayList();

            PreparedStatement ps = connection.prepareStatement("SELECT * FROM livros");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                dado.add(new Object[]{
                    rs.getInt("id_livro"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getString("categoria"),
                    rs.getString("editora"),
                    rs.getString("edicao"),
                    rs.getString("isbn"),
                    rs.getString("quantidade"),
                    rs.getString("status"),
                    rs.getString("corredor"),
                    rs.getString("prateleira")
                });

            }
            ps.close();
            rs.close();
            connection.close();

            return dado;
        } catch (SQLException e) {
            e.getMessage();
            JOptionPane.showMessageDialog(null, e + " Erro preencher o ArrayList do listarTodos", "Listagem", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public static void testarConexao() throws SQLException {
        try (Connection objConnection = new ConnectionDB().getConnection()) {
            JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso! ", "Banco de Dados", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
