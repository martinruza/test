package com.mru.example.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TestController {
	
	@RequestMapping("/compute")
    public int computeNumber(@RequestParam(value="input", defaultValue="43256791") int input) {
		
		//všechny číslice menší 3 (včetně) posune o jednu pozici doprava. Např: 43256791 => 45326791
		String inputString = String.valueOf( input);
		char[] inputField = inputString.toCharArray();
		
		if (inputField.length > 2) {
			for (int i = inputField.length -2; i > 0; i--) {
		         System.out.println(inputField[i] + " ");
		         
		         
		         if (inputField[i] <= '3' /*acii implicit conversion*/) {
		        	 char swap = inputField[i+1];
		        	 inputField[i+1] = inputField[i];
		        	 inputField[i] = swap;
		        	 
		         }
		    }
		}
		
		//všechny číslice 8 a 9 vynásobí 2. Např.: 45326791 => 453267181
		StringBuilder inputFiels2 = new StringBuilder("");
		for (int i = 0; i < inputField.length; i++) {
	         System.out.println(inputField[i] + " ");
	         
	          int digit = Integer.parseInt(String.valueOf(inputField[i]));
	          if (digit == 8 || digit == 9) {
	        	  digit = digit *2;
	          }
	          
			  //imlicit conversion from int to String and appended then
	          inputFiels2.append(digit);
	         
	    }
		String navrat = inputFiels2.toString() ; //String.copyValueOf(inputField);
		
		//všechny číslice 7 smaže: Např: 453267181 => 45326181
		navrat = navrat.replaceAll("7", "");
		
		
		//- ve výsledném čísle spočte počet sudých číslic a tímto počtem výsledné číslo vydělí a zaokrouhlí dolů na celá čísla. Např: 45326181 / 4 => 11331545
		inputField = navrat.toCharArray();
		int NumberOdd = 0;
		for (int i = 0; i<inputField.length ; i++) {
	         if ( Integer.parseInt(String.valueOf(inputField[i])) % 2 == 0 )
	        	 NumberOdd++;
	    }
		
		
		
		//
		
        return Integer.parseInt(navrat) / NumberOdd;
    }
	
}
