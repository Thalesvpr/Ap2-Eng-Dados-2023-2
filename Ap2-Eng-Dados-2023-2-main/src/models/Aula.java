package models;

import java.sql.Time;

public class Aula {
    private int idAulas;
    private int fk_idProfessor;
    private String nome;
    private Time horarioInicio;
    private Time horarioFim;
    private String diaSemana;
}
