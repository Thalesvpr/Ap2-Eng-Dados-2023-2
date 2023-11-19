import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import models.Aluno;
import models.Aula;
import models.Contrato;
import models.Professores;
import dao.ConnectionFactory;
import dao.AlunoDAO;
import dao.ContratoDAO;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Aluno aluno1 = new Aluno("Tiago", LocalDate.of(1997, 1, 27), "21996558585", "tiago@gmail.com");
        Aluno aluno2 = new Aluno("Antônio", LocalDate.of(1999, 3, 27), "21998558585", "antonio@gmail.com");
        Aluno aluno3 = new Aluno("Larissa", LocalDate.of(1985, 1, 15), "21996552000", "larissa@gmail.com");
        Aluno aluno4 = new Aluno("Isabela", LocalDate.of(1993, 5, 20), "21987759085", "isa@gmail.com");
        Aluno aluno5 = new Aluno("Tatiana", LocalDate.of(2000, 4, 30), "21999999999", "tatiana@gmail.com");
        Aluno aluno6 = new Aluno("Ana", LocalDate.of(2002, 7, 21), "21981667879", "ana@gmail.com");

        ConnectionFactory fabricaDeConexao = new ConnectionFactory();
        Connection connection = fabricaDeConexao.connectionFactory();

        AlunoDAO adao = new AlunoDAO(connection);

        System.out.println("Insercao de dados na tabela 'Aluno'\n");

        adao.createAluno(aluno1);
        adao.createAluno(aluno2);
        adao.createAluno(aluno3);
        adao.createAluno(aluno4);
        adao.createAluno(aluno5);
        adao.createAluno(aluno6);

        System.out.println(aluno1);
        System.out.println(aluno2);
        System.out.println(aluno3);
        System.out.println(aluno4);
        System.out.println(aluno5);
        System.out.println(aluno6);

        System.out.println("\n----------------");
        System.out.println("Metodo para consultar um elemento especifico da tabela 'Aluno'\n");

        Aluno alunoX = adao.getAlunoById(aluno1);
        Aluno alunoY = adao.getAlunoById(aluno2);

        System.out.println(alunoX);
        System.out.println(alunoY);

        System.out.println("\n----------------");
        System.out.println("Atualizacao de dados na tabela 'Aluno'\n");

        System.out.println("Atualiza email");
        System.out.println(adao.getAlunoById(aluno4));
        adao.updateEmail(aluno4, "bela@gmail.com");
        System.out.println(adao.getAlunoById(aluno4));
        System.out.println("");

        System.out.println("Atualiza telefone");
        System.out.println(adao.getAlunoById(aluno5));
        adao.updateTelefone(aluno5, "21988888888");
        System.out.println(adao.getAlunoById(aluno5));

        System.out.println("\n----------------");
        System.out.println("Delecao de dados na tabela 'Aluno'\n");

        System.out.println(adao.getAlunoById(aluno6));
        adao.deleteAluno(aluno6);
        adao.getAlunoById(aluno6);

        System.out.println("\n----------------");
        System.out.println("Metodo para consultar todos os elementos da tabela 'Aluno'\n");

        ArrayList<Aluno> alunos = adao.getAllAlunos();

        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }
}
