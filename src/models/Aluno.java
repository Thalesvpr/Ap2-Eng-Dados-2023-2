package models;

import java.sql.Date;

public class Aluno {
    private int idAluno;
    private Integer fk_idContrato; // Foreign key, pode ser null
    private String nome;
    private Date dataNascimento;
    private int idade;
    private String telefone;
    private String email;

    // Getters and Setters
}
