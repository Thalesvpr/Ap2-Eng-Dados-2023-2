package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/academia";

    public void criarProfessor(Professor professor) {
        try (Connection conexao = DriverManager.getConnection(URL)) {
            String sql = "INSERT INTO Professor (nome, especialidade) VALUES (?, ?)";
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
        try (Connection conexao = DriverManager.getConnection(URL)) {
            String sql = "SELECT * FROM Professor WHERE idProfessor = ?";
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
        try (Connection conexao = DriverManager.getConnection(URL)) {
            String sql = "SELECT * FROM Professor";
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
        try (Connection conexao = DriverManager.getConnection(URL)) {
            String sql = "UPDATE Professor SET nome = ?, especialidade = ? WHERE idProfessor = ?";
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
        try (Connection conexao = DriverManager.getConnection(URL)) {
            String sql = "DELETE FROM Professor WHERE idProfessor = ?";
            try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                statement.setInt(1, idProfessor);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
