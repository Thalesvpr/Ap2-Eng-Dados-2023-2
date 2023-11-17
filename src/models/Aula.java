package models;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Aula {
    private int idAula;
    private Professor Professor;
    private String nome;
    private Time horarioInicio;
    private Time horarioFim;
    private String diaSemana;
    private ArrayList<Aluno> alunos;


    public Aula(models.Professor professor, String nome, Time horarioInicio, Time horarioFim, String diaSemana){
        Professor = professor;
        this.nome = nome;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.diaSemana = diaSemana;
        this.alunos = new ArrayList<>();
    }


    


    public Aula(int idAula, Professor professor, String nome, Time horarioInicio, Time horarioFim, String diaSemana) {
        this.idAula = idAula;
        Professor = professor;
        this.nome = nome;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.diaSemana = diaSemana;
        this.alunos = new ArrayList<>();
    }


    public void addAluno(Aluno aluno) {
        if (aluno != null) {
            alunos.add(aluno);
        }
    }


    public List<Aluno> getAlunos() {
        return alunos;
    }
}
