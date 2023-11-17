package DAO;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Professor {
    private static final String URL = "jdbc:mysql://localhost:3306/seubanco"; // Substitua com a URL do seu banco
    private static final String USUARIO = "seu_usuario";
    private static final String SENHA = "sua_senha";

    public void criarProfessor(Professor professor) {
        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "INSERT INTO professores (nome, especialidade) VALUES (?, ?)";
            try (PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, professor.getNome());
                statement.setString(2, professor.getEspecialidade());
                statement.executeUpdate();

                try (ResultSet resultSet = statement.getGeneratedKeys()) {
                    if (resultSet.next()) {
                        professor.setIdProfessor(resultSet.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Professor lerProfessor(int idProfessor) {
        Professor professor = null;
        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "SELECT * FROM professores WHERE idProfessor = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setInt(1, idProfessor);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        professor = new Professor();
                        professor.setIdProfessor(resultSet.getInt("idProfessor"));
                        professor.setNome(resultSet.getString("nome"));
                        professor.setEspecialidade(resultSet.getString("especialidade"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professor;
    }

    public List<Professor> lerTodosProfessores() {
        List<Professor> professores = new ArrayList<>();
        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "SELECT * FROM professores";
            try (Statement statement = conexao.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    while (resultSet.next()) {
                        Professor professor = new Professor();
                        professor.setIdProfessor(resultSet.getInt("idProfessor"));
                        professor.setNome(resultSet.getString("nome"));
                        professor.setEspecialidade(resultSet.getString("especialidade"));
                        professores.add(professor);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return professores;
    }

    public void atualizarProfessor(Professor professor) {
        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "UPDATE professores SET nome = ?, especialidade = ? WHERE idProfessor = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setString(1, professor.getNome());
                statement.setString(2, professor.getEspecialidade());
                statement.setInt(3, professor.getIdProfessor());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarProfessor(int idProfessor) {
        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "DELETE FROM professores WHERE idProfessor = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setInt(1, idProfessor);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
