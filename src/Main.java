import listaencadeada.Disciplina;
import listaencadeada.ListaEncadeada;
import listasequencial.Aluno;
import listasequencial.ListaSequencial;

import java.sql.PreparedStatement;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        ListaSequencial<Aluno> alunos = new ListaSequencial<>(60);

        System.out.println("Digite quantos alunos você quer inserir (menor que 60):");
        int quantidadeDeAlunos = scan.nextInt();
        scan.nextLine();
        if (quantidadeDeAlunos > 60){
            throw new IllegalArgumentException("O número que você digitou excede o limite.");
        }

        for (int i = 0; i < quantidadeDeAlunos; i++) {
            System.out.println("Digite um RGM para ser inserido na lista:");
            String rgm = scan.nextLine().trim();
            alunos.adicionaNoFim(new Aluno(rgm));
            alunos.buscaPorIndice(i).setDisciplinas(new ListaEncadeada<Disciplina>());
            boolean continua = true;
            while (continua){
                System.out.println("Digite o nome da disciplina que você que adicionar na lista:");
                String disciplina = scan.nextLine();
                System.out.println("Digite a nota dessa disciplina para ser adicionada:");
                double nota = scan.nextDouble();
                scan.nextLine();
                alunos.buscaPorIndice(i).getDisciplinas().adicionaNoInicioOuNoFim(new Disciplina(disciplina, nota));
                System.out.println("Mais disciplina? (s/n)");
                char resposta = scan.next().trim().charAt(0);
                scan.nextLine();
                continua = (resposta == 's') ? continua : false;
            }
        }

        for (int i = 0; i < alunos.tamanho(); i++){
            System.out.println(alunos.buscaPorIndice(i));
            System.out.println(alunos.buscaPorIndice(i).getDisciplinas());
        }


    }
}
