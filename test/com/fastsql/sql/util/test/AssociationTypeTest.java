package com.fastsql.sql.util.test;


import org.junit.BeforeClass;
import org.junit.Test;

public class AssociationTypeTest {
	enum Alunos {  
	    JOAO, PEDRO, LUCAS  
	}  
	  
	enum Alunas {  
	    MARCIA, REGINA, LUISA  
	} 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	public void simpleTest() throws ClassNotFoundException{
		 // Isto funciona OK...  
        Enum en1 = Enum.valueOf (Alunos.class, "JOAO");  
        System.out.println (en1); // imprime JOAO  
        // e isto também funciona OK (provavelmente é o que você vai ter de usar), embora  
        // tenha um "SuppressWarnings" meio chato:  
        Class klass2 = Class.forName ("Alunos");  
        @SuppressWarnings ("unchecked") Enum en2 = Enum.valueOf (klass2, "PEDRO");  
        System.out.println (en2); // imprime PEDRO  
        // O que vem a seguir requer, de qualquer maneira, a importação   
        // da classe Alunos, portanto não é bem o que você quer:  
        Class<Alunas> klass3 = Alunas.class; // veja a declaração  
        Alunas al3 = Enum.valueOf (klass3, "MARCIA");  
        System.out.println (al3); // imprime MARCIA  
        // Se em vez de Alunas.class tivéssemos Class.forName ("Alunas")   
        // o caso é um pouco pior, já que temos de   
        @SuppressWarnings ("unchecked") Class<Alunas> klass4 =   
            (Class<Alunas>) Class.forName ("Alunas");  
        Alunas al4 = Enum.valueOf (klass4, "REGINA");  
        System.out.println (al4); // imprime REGINA  
        // Note que o "SuppressWarnings" deve ser usado apenas quando se sabe  
        // o que está fazendo. Vamos fazer um cast errado de propósito:  
        @SuppressWarnings ("unchecked") Class<Alunas> klass5 =   
            (Class<Alunas>) Class.forName ("Alunos"); // O compilador deixa passar...  
        // A linha a seguir provoca, em tempo de execução, um   
        // IllegalArgumentException ("No enum const class Alunos.LUISA")  
        Alunas al5 = Enum.valueOf (klass5, "LUISA");  
        System.out.println (al5); 
	}

}
