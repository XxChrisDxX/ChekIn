import java.awt.List;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Database {
	
	private String line = ""; 
	public Database(){
	}

	public ArrayList<String> readEventList() throws IOException{
		FileReader file = new FileReader("database.dat");
		BufferedReader input = new BufferedReader(file);
		String event = "";
		ArrayList<String> events = new ArrayList<String>();
		line = input.readLine();
		int length = line.length();
		int index = line.indexOf(',');
		int limit = line.lastIndexOf(',');
		if(line.indexOf(':')==length-1){
			input.close();
			file.close();
			events.add("No Events");
			return events;
		}
		else{
		while(index!=limit){
			event = line.substring(index+1, line.indexOf(',', index+1));
			events.add(event);
			index = line.indexOf(',', index+1);
		}
		events.add(line.substring(limit+1, length));
		}		
		file.close();
		input.close();
		return events;
	}	
	
	public void writeEventList(String event) throws IOException{
		StringBuilder add = new StringBuilder(150);
		File main = new File("database.dat");
		File temp = new File("temp.dat");
		BufferedReader input = new BufferedReader(new FileReader(main));
		BufferedWriter out = new BufferedWriter(new FileWriter(temp, true));	
		line = input.readLine();
		add.append(line.substring(0, line.length()));
		add.append(",");
		add.append(event);
		add.append("\n");
		out.write(add.toString());
		while((line = input.readLine()) != null){
			out.write(line+"\n");	
		}
		input.close();
		out.close();
		main.delete();
		boolean successful = temp.renameTo(main);
	}
	
	public void deleteEventList(String event) throws IOException{
		StringBuilder add = new StringBuilder(150);
		File main = new File("database.dat");
		File temp = new File("temp.dat");
		BufferedReader input = new BufferedReader(new FileReader(main));
		BufferedWriter out = new BufferedWriter(new FileWriter(temp, true));	
		line = input.readLine();
		add.append(line.substring(0, line.indexOf(event)-1));
		add.append(line.substring(line.indexOf(event)+event.length(),line.length()));
		add.append("\n");
		out.write(add.toString());
		while((line = input.readLine()) != null){
			out.write(line+"\n");	
		}
		input.close();
		out.close();
		main.delete();
		boolean successful = temp.renameTo(main);
		
	}
	
	public boolean readName(String data) throws IOException{
		FileReader file = new FileReader("database.dat");
		BufferedReader input = new BufferedReader(file);
		String name = "";
		while((line = input.readLine()) != null){
			int length = line.length();
			for(int i = 0; i<length;i++){
				if(line.charAt(i)==':'){
					name = line.substring(0,i);
					if(data.equalsIgnoreCase(name)){
						file.close();
						input.close();
						return true;
					}
					else
						break;
				}
			}
				
		}
		file.close();
		input.close();
		return false;
	}
	
	public ArrayList<String> findUser(String data) throws IOException{
		FileReader file = new FileReader("database.dat");
		BufferedReader input = new BufferedReader(file);
		String name = "";
		ArrayList<String> users = new ArrayList<String>();
		input.readLine();
		while((line = input.readLine()) != null){
			int length = line.indexOf(':');
			name = line.substring(0,length);
			if(name.toLowerCase().contains(data.toLowerCase())){
				users.add(name);
			}
		}
		file.close();
		input.close();
		return users;
	}
	
	public ArrayList<String> readEventStats() throws IOException{
		FileReader file = new FileReader("database.dat");
		BufferedReader input = new BufferedReader(file);
		String dob;
		String event;
		String eventname;
		String eventdate;
		String age;
		int index;
		int limit;
		ArrayList<String> events = new ArrayList<String>();
		input.readLine();
		while((line = input.readLine()) != null){
			index = line.indexOf(',');
			limit = line.lastIndexOf(',');				
			dob = line.substring(line.lastIndexOf(':')+1, line.indexOf('%'));
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			LocalDate dobDate = LocalDate.parse(dob,formatter);
			age = Integer.toString(Period.between(dobDate, LocalDate.now()).getYears());
			while(index!=limit){
				event = line.substring(index+1, line.indexOf(',', index+1));
				eventdate = event.substring(event.indexOf(' ')+1, event.length());
				eventname = event.substring(0, event.indexOf(' '));
				events.add(eventname);
				events.add(eventdate);
				events.add(age);
				index = line.indexOf(',', index+1);
			}
			event = (line.substring(limit+1, line.indexOf(']')));
			eventdate = event.substring(event.indexOf(' ')+1, event.length());
			eventname = event.substring(0, event.indexOf(' '));
			events.add(eventname);
			events.add(eventdate);
			events.add(age);
		}
		file.close();
		input.close();
		return events;
	}	
	
	
	public ArrayList<String> readEventAll() throws IOException{
		FileReader file = new FileReader("database.dat");
		BufferedReader input = new BufferedReader(file);
		String event;
		String eventname;
		int index;
		int limit;
		ArrayList<String> events = new ArrayList<String>();
		input.readLine();
		while((line = input.readLine()) != null){
			index = line.indexOf(',');
			limit = line.lastIndexOf(',');
			while(index!=limit){
				event = line.substring(index+1, line.indexOf(',', index+1));
				eventname = event.substring(0, event.indexOf(' '));
				events.add(eventname);
				index = line.indexOf(',', index+1);
			}
			events.add(line.substring(limit+1, line.indexOf(' ',limit+1)));			
		}
		file.close();
		input.close();
		return events;
	}	
	
	public ArrayList<String> readEvent(String data) throws IOException{
		FileReader file = new FileReader("database.dat");
		BufferedReader input = new BufferedReader(file);
		String name = "";
		String event;
		int index;
		int limit;
		ArrayList<String> events = new ArrayList<String>();
		while((line = input.readLine()) != null){
			int length = line.indexOf(':');
			name = line.substring(0,length);
			if(name.equalsIgnoreCase(data)){
				index = line.indexOf(',');
				limit = line.lastIndexOf(',');
				while(index!=limit){
					event = line.substring(index+1, line.indexOf(',', index+1));
					events.add(event);
					index = line.indexOf(',', index+1);
				}
				events.add(line.substring(limit+1, line.indexOf(']')));
			}
		}
		file.close();
		input.close();
		return events;
	}
	
	public boolean readPermissions(String data) throws IOException{
		FileReader file = new FileReader("database.dat");
		BufferedReader input = new BufferedReader(file);
		String name = "";
		while((line = input.readLine()) != null){
			int length = line.length();

			for(int i = 0; i<length;i++){
				if(line.charAt(i)==':'){
					name = line.substring(0,i);
					if(data.equalsIgnoreCase(name)){
						int permissionIndex = line.indexOf('%');
						if(line.charAt(permissionIndex+1)=='1'){
							file.close();
							input.close();
							return true;//for admin permissions
						}
						else{
							file.close();
							input.close();
							return false;//for normal user
						}
					}
					else
						break;
				}
			}
				
		}
		file.close();
		input.close();
		return false;
	}
	public String readEmail(String data) throws IOException{
		FileReader file = new FileReader("database.dat");
		BufferedReader input = new BufferedReader(file);
		String name = "";
		String Email = "";
		int emailIndex;
		while((line = input.readLine()) != null){
			int length = line.length();

			for(int i = 0; i<length;i++){
				if(line.charAt(i)==':'){
					name = line.substring(0,i);
					if(data.equalsIgnoreCase(name)){
						emailIndex = line.indexOf(':', i+1);
						Email = line.substring(i+1, emailIndex);
						file.close();
						input.close();
						return Email;
					}
					else
						break;
				}
			}
				
		}
		file.close();
		input.close();
		return "";
	}
	
	public String readBirth(String data) throws IOException{
		FileReader file = new FileReader("database.dat");
		BufferedReader input = new BufferedReader(file);
		String name = "";
		String birth = "";
		while((line = input.readLine()) != null){
			int length = line.length();

			for(int i = 0; i<length;i++){
				if(line.charAt(i)==':'){
					name = line.substring(0,i);
					if(data.equalsIgnoreCase(name)){
						birth = line.substring(line.lastIndexOf(':')+1,line.indexOf('%'));
						file.close();
						input.close();
						return birth;
					}
					else
						break;
				}
			}
				
		}
		file.close();
		input.close();
		return "";
	}
	
	public void writeUser(String data) throws IOException{
		PrintWriter out = new PrintWriter(new FileWriter("database.dat", true));
		out.println(data);
		out.close();
	}
	
	
	public void writeEvent(String data, String event) throws IOException{
		StringBuilder add = new StringBuilder(150);
		File main = new File("database.dat");
		File temp = new File("temp.dat");
		BufferedReader input = new BufferedReader(new FileReader(main));
		BufferedWriter out = new BufferedWriter(new FileWriter(temp, true));
		String name = "";
		
		while((line = input.readLine()) != null){
			int length = line.indexOf(':');
					name = line.substring(0,length);
					if(name.equalsIgnoreCase(data)){
						line.indexOf(']');
						add.append(line.substring(0,line.indexOf(']')));
						add.append(",");
						add.append(event);
						add.append("]\n");
						out.write(add.toString());
					}
					else
						out.write(line+"\n");	
			
		}
		input.close();
		out.close();
		main.delete();
		boolean successful = temp.renameTo(main);
	}

	public void writeEmail(String data, String email) throws IOException{
		StringBuilder add = new StringBuilder(150);
		File main = new File("database.dat");
		File temp = new File("temp.dat");
		BufferedReader input = new BufferedReader(new FileReader(main));
		BufferedWriter out = new BufferedWriter(new FileWriter(temp, true));
		String name = "";
		
		while((line = input.readLine()) != null){
			int length = line.indexOf(':');
					name = line.substring(0,length);
					if(name.equalsIgnoreCase(data)){
						add.append(line.substring(0,length));
						add.append(":");
						add.append(email);
						add.append(line.substring(line.indexOf(':', length+1), line.length() ));
						out.write(add.toString());
					}
					else
						out.write(line+"\n");	
			
		}
		input.close();
		out.close();
		main.delete();
		boolean successful = temp.renameTo(main);
	}
	
	public void writePermissions(String data, int Permission) throws IOException{
		StringBuilder add = new StringBuilder(150);
		File main = new File("database.dat");
		File temp = new File("temp.dat");
		BufferedReader input = new BufferedReader(new FileReader(main));
		BufferedWriter out = new BufferedWriter(new FileWriter(temp, true));
		String name = "";
		
		while((line = input.readLine()) != null){
			int length = line.indexOf(':');
					name = line.substring(0,length);
					if(name.equalsIgnoreCase(data)){
						int permissionIndex = line.indexOf('%');
						add.append(line.substring(0,permissionIndex+1));
						add.append(Permission);
						add.append(line.substring(permissionIndex+2, line.length() ));
						add.append("\n");
						out.write(add.toString());
					}
					else
						out.write(line+"\n");	
			
		}
		input.close();
		out.close();
		main.delete();
		boolean successful = temp.renameTo(main);
	}

	public static void main(String args[]) throws IOException{
		new Database();
	}
}
