import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelHandler {
	String fileDirectory = "C:/Users/jeric/eclipse-workspace/TeleMastersValorantTournamentManager/src/";
	public static void createSheet(LinkedList <String> list, String filePath, String teamName) {
		try {  
			//declare file name to be create   
			String filename = filePath;  
			//creating an instance of HSSFWorkbook class   
			HSSFWorkbook workbook = new HSSFWorkbook();  
			//invoking creatSheet() method and passing the name of the sheet to be created   
			HSSFSheet sheet = workbook.createSheet(teamName);   
		
			//creating the 0th row using the createRow() method  
			HSSFRow rowhead = sheet.createRow((short)0);  
			//creating cell by using the createCell() method and setting the values to the cell by using the setCellValue() method  
			rowhead.createCell(0).setCellValue(teamName);   
			
			//creating the 1st row using the createRow() method  
			HSSFRow row1 = sheet.createRow((short)1);  
			//creating cell by using the createCell() method and setting the values to the cell by using the setCellValue() method  
			row1.createCell(0).setCellValue(list.get(1));   
			
			//creating the 2nd row using the createRow() method  
			HSSFRow row2 = sheet.createRow((short)2);  
			//creating cell by using the createCell() method and setting the values to the cell by using the setCellValue() method  
			row2.createCell(0).setCellValue(list.get(2));  
			
			//creating the 3rd row using the createRow() method  
			HSSFRow row3 = sheet.createRow((short)3);  
			//creating cell by using the createCell() method and setting the values to the cell by using the setCellValue() method  
			row3.createCell(0).setCellValue(list.get(3));  
			
			//creating the 4th row using the createRow() method  
			HSSFRow row4 = sheet.createRow((short)4);  
			//creating cell by using the createCell() method and setting the values to the cell by using the setCellValue() method  
			row4.createCell(0).setCellValue(list.get(4));  
			
			//creating the 5th row using the createRow() method  
			HSSFRow row5 = sheet.createRow((short)5);  
			//creating cell by using the createCell() method and setting the values to the cell by using the setCellValue() method  
			row5.createCell(0).setCellValue(list.get(5));  
		
			FileOutputStream fileOut = new FileOutputStream(filename);  
			workbook.write(fileOut);  
			//closing the Stream  
			fileOut.close();  
			//closing the workbook  
			workbook.close();  
	
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
	}
	
	public static LinkedList <String> readExcelFile(String fileName, int column) throws Exception {
		LinkedList <String> names = new LinkedList<>();
	        // Create a FileInputStream object to read the excel file
	        FileInputStream fileInputStream = new FileInputStream(fileName);

	        // Create a XSSFWorkbook object to work with the excel file
	        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

	        // Get the first sheet in the workbook
	        HSSFSheet sheet = workbook.getSheetAt(0);

	        // Iterate over each row in the sheet
	        for (Row row : sheet) {
	            // Get the first cell in the row
	            Cell cell = row.getCell(column);

	            // Check the cell type and display the value accordingly
	            if (cell != null) {
	                switch (cell.getCellType()) {
	                    case Cell.CELL_TYPE_STRING:
	                    	names.add(cell.getStringCellValue());
	                        break;
	                    default:
	                        System.out.print("Unknown value" + "\t");
	                        break;
	                }
	            }
	           
	        }

	        // Close the workbook and the file input stream
	        workbook.close();
	        fileInputStream.close();
	
		return names;
	}
	
	public static void addRowToExcel(String filePath, String sheetName, String input) {
	    try {
	        // Open the excel file
	        FileInputStream fileInputStream = new FileInputStream(filePath);
	        HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);

	        // Get the specified sheet
	        HSSFSheet sheet = workbook.getSheet(sheetName);

	        // Create a new row and add the input to the first cell
	        Row newRow = sheet.createRow(sheet.getLastRowNum() + 1);
	        newRow.createCell(0).setCellValue(input);

	        // Save the changes to the excel file
	        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
	        workbook.write(fileOutputStream);
	        fileOutputStream.close();
	        workbook.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
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
	
	public static LinkedList<String> fileReader(String filePath) {
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
	
	public static String checkUser(String User) {
		String filePath = "";
		
		if (User.equalsIgnoreCase("User1")) {
			filePath = "C:/Users/jeric/eclipse-workspace/TeleMastersValorantTournamentManager/src/Team1.xlsx";
		} else if (User.equalsIgnoreCase("User2")) {
			filePath = "C:/Users/jeric/eclipse-workspace/TeleMastersValorantTournamentManager/src/Team2.xlsx";
		} else if (User.equalsIgnoreCase("User3")) {
			filePath = "C:/Users/jeric/eclipse-workspace/TeleMastersValorantTournamentManager/src/Team3.xlsx";
		} else if (User.equalsIgnoreCase("User4")) {
			filePath = "C:/Users/jeric/eclipse-workspace/TeleMastersValorantTournamentManager/src/Team4.xlsx";
		} else {
			return "";
		}
		
		return filePath;
	}
}
