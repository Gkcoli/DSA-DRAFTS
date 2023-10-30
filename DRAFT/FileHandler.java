import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

public class FileHandler {
	
	
	public LinkedList<String> teamCompositionReader(String filePath) {
		LinkedList<String> names = new LinkedList<>();
		LinkedList <String> defaultTeam = new LinkedList<>(); 
	        defaultTeam.add("Team Name");
	        defaultTeam.add("Member 1");
	        defaultTeam.add("Member 2");
	        defaultTeam.add("Member 3");
	        defaultTeam.add("Member 4");
	        defaultTeam.add("Member 5");
		
	    // Checks if file is empty
	    // If empty, inputs default team to file
	    FileHandler handler = new FileHandler();
		if (handler.fileCounter(filePath) == 0) 
			names.addAll(defaultTeam);
			
		try {
			String str = "";
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((str = reader.readLine()) != null) { // reads and stores file content to Stack 
                names.addLast(str);
            } 
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return names;
	}
	
	public LinkedList<String> fileReader(String filePath) {
		LinkedList<String> list = new LinkedList<>();
			
		try {
			String str = "";
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((str = reader.readLine()) != null) { // reads and stores file content to Stack 
                list.addLast(str);
            } 
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public void fileWriter(LinkedList <String> teamCreds, String filepath) {
		try {
		    FileWriter file = new FileWriter(filepath);
		    BufferedWriter output = new BufferedWriter(file);
		    
		    while (teamCreds.size() != 0) {
		    	// Writes the string to the file
		    	String creds = teamCreds.pop();
		    	output.write(creds+"\n");
		    }
		    output.close();
		    }
		    catch (Exception e) {
		      e.getStackTrace();
		    }
	}
	
	public int fileCounter(String filePath) {
		int count = 0;
		try {
			String str = "";
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((str = reader.readLine()) != null) { 
                count++;
            } 
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public String checkUser(String User) {
		String filePath = "";
		
		if (User.equalsIgnoreCase("User1")) {
			filePath = "C:/Users/jeric/eclipse-workspace/TeleMastersValorantTournamentManager/src/Team1.txt";
		} else if (User.equalsIgnoreCase("User2")) {
			filePath = "C:/Users/jeric/eclipse-workspace/TeleMastersValorantTournamentManager/src/Team2.txt";
		} else if (User.equalsIgnoreCase("User3")) {
			filePath = "C:/Users/jeric/eclipse-workspace/TeleMastersValorantTournamentManager/src/Team3.txt";
		} else if (User.equalsIgnoreCase("User4")) {
			filePath = "C:/Users/jeric/eclipse-workspace/TeleMastersValorantTournamentManager/src/Team4.txt";
		} 
		
		return filePath;
	}
}
