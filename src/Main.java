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
        
        Aluno aluno1 = new Aluno("Luis", LocalDate.of(1997, 1, 27), "21996558585", "luis@gmail.com");
        Aluno aluno2 = new Aluno("Manoela", LocalDate.of(1999, 3, 27), "21998558585", "manoela@gmail.com");
        Aluno aluno3 = new Aluno("Matheus", LocalDate.of(1985, 1, 15), "21996552000", "matheus@gmail.com");
        Aluno aluno4 = new Aluno("Larissa", LocalDate.of(1993, 5, 20), "21987759085", "larissa@gmail.com");
        Aluno aluno5 = new Aluno("Lourdes", LocalDate.of(2000, 4, 30), "21996532675", "lourdes@gmail.com");

        System.out.println("Comecei a printar os objetos de pessoa criados em memoria\n");
        System.out.println(aluno1);
        System.out.println(aluno2);
        System.out.println(aluno3);
        System.out.println(aluno4);
        System.out.println(aluno5);

        ConnectionFactory fabricaDeConexao = new ConnectionFactory();
        Connection connection = fabricaDeConexao.connectionFactory();

        AlunoDAO adao = new AlunoDAO(connection);

        adao.createAluno(aluno1);
        adao.createAluno(aluno2);
        adao.createAluno(aluno3);
        adao.createAluno(aluno4);
        adao.createAluno(aluno5);



    }
}
