/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr;

import br.edu.utfpr.util.BCrypt;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Filipe
 */

@WebServlet("/bcrypt")
public class BcryptServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			
		String  originalPassword = "qwerty";
		final int ROUNDS = 12;
		response.getWriter().append("<BR>Senha: ").append(originalPassword)
		.append(" Rounds: " + ROUNDS).append("<BR>");
		
		for(int i = 1; i <= 10; i++){
			long initTime = System.currentTimeMillis();
	        String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(ROUNDS));
	        System.out.println(generatedSecuredPasswordHash);         
	         
	        boolean matched = BCrypt.checkpw(originalPassword, generatedSecuredPasswordHash);
	        System.out.println(matched);
	        
	        long endTime = System.currentTimeMillis();
	        response.getWriter().append(" Hash " + i + ": ").
	        append(generatedSecuredPasswordHash)
	        .append(" Tempo: " + (endTime - initTime) + " ms").append("<BR>");	        
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}

