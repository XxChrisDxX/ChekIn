import java.io.*;
import java.util.Scanner;

public class Database {
	
	private String line = ""; 
	public Database(){
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
		boolean successful = temp.renameTo(main);
	}

	public static void main(String args[]) throws IOException{
		new Database();
	}
}
