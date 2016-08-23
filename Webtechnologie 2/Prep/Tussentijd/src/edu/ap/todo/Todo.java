package edu.ap.todo;

import java.util.ArrayList;

import edu.ap.jdbc.*;

public class Todo {	

	public void add(String startdate, String enddate, String priority, String description){
		JDBConnection connection = null;
		try {			
			connection = JDBConnection.getJDBConnection();
			connection.openConnection("todo", "root", "");
			String insertSQL = "INSERT INTO TODO(startdate, enddate, priority, description) VALUES('" + startdate + "','" + enddate + "'," + priority + "'," + description + ");";
			connection.executeInsert(insertSQL);
		} catch (Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public void list(){
		JDBConnection connection = null;
		ArrayList<String> todos = null;
		try {			
			connection = JDBConnection.getJDBConnection();
			connection.openConnection("Todo", "root", "");
		} catch (Exception ex){
			System.out.println(ex.getMessage());
		}
		String selectSQL = "SELECT * FROM TODO;";
		todos = connection.selectAll(selectSQL);
		
		for(String s: todos) {
			String[] fields = s.split(";");
			System.out.println("<tr><td>" + fields[0] + "</td>" + "<td>" + fields[1] + "</td>" + "<td>" + fields[2] + "</td></tr>");
		}
	}

}
