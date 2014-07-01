package controller;

import junit.framework.Assert;

import org.junit.Test;

public class TesteEnum {

   @Test
   public void testSemEnum(){
	   LivroX livro = new LivroX();
	   livro.status = "disponicveldssad";
	   System.out.println(livro.status);
	   Assert.assertEquals(livro.status, "disponivel");
   }
   
   @Test
   public void testEnum(){
	   LivroY livro = new LivroY();
	   livro.status = Status.DISPONIVEL;
	   System.out.println(livro.status);
	   Assert.assertEquals(livro.status, Status.DISPONIVEL);
   }
	
}

class LivroX{
	
	public String status;
	
}

class LivroY{
	
	public Status status;
	
}

enum Status{
	DISPONIVEL,NAO
}