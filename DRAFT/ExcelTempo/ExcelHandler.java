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
	
	// Method that creates a file 
	public void createFile(String filePath, int numRows, String sheetName) {
		try   {  
		//creating an instance of HSSFWorkbook class  
		HSSFWorkbook workbook = new HSSFWorkbook();  
		//invoking creatSheet() method and passing the name of the sheet to be created   
		HSSFSheet sheet = workbook.createSheet(sheetName);    
		Row row;
		
		for (int i = 0; i < numRows; i++) {
			//creating the 0th row using the createRow() method  
			// Create a new row and set its height
	        row = sheet.createRow(i);
		}
		//creating the 0th row using the createRow() method  
		// Create a new row and set its height
        row = sheet.createRow(0);

        // Write data to the excel file
        row.createCell(0).setCellValue("Team");
        row.createCell(1).setCellValue("K");
        row.createCell(2).setCellValue("D");
        row.createCell(3).setCellValue("A");
        row.createCell(4).setCellValue("P");
        row.createCell(5).setCellValue("DF");
        
		FileOutputStream fileOut = new FileOutputStream(filePath);  
		workbook.write(fileOut);  
		//closing the Stream  
		fileOut.close();  
		//closing the workbook  
		workbook.close();  
		//prints the message on the console  
		System.out.println("Excel file has been generated successfully.");  
		}   
		catch (Exception e)   
		{  
		e.printStackTrace();  
		}  
	}
	
	// Method that reads a specific column in excel and inputs it to a linked list
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
	
	// Method that writes elements of a linked list to a specific file
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
	
	// Method that reads through a file and inputs its content to a linked list
	public static LinkedList<String> fileReader(String filePath) {
		LinkedList<String> list = new LinkedList<>();
			
		try {
			String str = "";
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((str = reader.readLine()) != null) { // reads and stores file content to LinkedList 
                list.addLast(str);
            } 
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// Method that returns a designated filePath from a user
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
	
	// Method that writes on a specific column
	public void writeAtSpecificColumn(String excelFilePath, int column, LinkedList <String> list) {
        
		try {
			FileInputStream inputStream = new FileInputStream(excelFilePath);
			HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
			HSSFSheet firstSheet = workbook.getSheetAt(0);
			int totalRows = firstSheet.getPhysicalNumberOfRows();

			for (int rowIndex = 0; rowIndex < totalRows; rowIndex++) {
				Row row = firstSheet.getRow(rowIndex);
				if (row == null) {
					row = firstSheet.createRow(rowIndex);
				}

				
				// Overwrite only a specific column (for example, column B)
				int columnIndex = column; // 0-based index, so 1 means the second column
				Cell cell = row.getCell(columnIndex);
				if (cell == null) {
					cell = row.createCell(columnIndex);
				}
				cell.setCellValue(list.get(rowIndex));
				
			}

			inputStream.close();

			FileOutputStream outputStream = new FileOutputStream(excelFilePath);
			workbook.write(outputStream);
			outputStream.close();

			workbook.close();
			
			System.out.println("Succesfully written to file");
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}   
	
}


