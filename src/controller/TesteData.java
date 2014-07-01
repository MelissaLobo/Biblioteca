package controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TesteData {

   @Test
   public void testDataAtual(){
        System.out.println(new Date());
   }
   
   @Test
   public void testDataAtualCalendar(){
	   
	   Calendar dataAtual = Calendar.getInstance();
	   System.out.println(dataAtual.getTime());
       
	   dataAtual.add(Calendar.DAY_OF_MONTH, 21);
	  
	   dataAtual.add(Calendar.HOUR, 24);
	   
	   System.out.println(dataAtual.getTime());
	   
	   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = sdf.format(dataAtual.getTime()); 
		System.out.println(date); //1
        
   }

	
}
