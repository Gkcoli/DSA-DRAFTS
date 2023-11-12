package telemasters;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHandler {
	String fileDirectory = "C:/Users/carlo/OneDrive/Desktop/pransue/School/FIRST YEAR/ECLIPSE/telemasters/src/";
	Stats stats = new Stats();
	// Method that creates a file 
	public void createFile(String filePath, int numRows, String sheetName) {
		try   {  
		//creating an instance of HSSFWorkbook class  
		XSSFWorkbook workbook = new XSSFWorkbook();  
		//invoking creatSheet() method and passing the name of the sheet to be created   
		XSSFSheet sheet = workbook.createSheet(sheetName);    
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
		System.out.println("Excel file has been generated successfully.");  }   
		catch (Exception e) {  
		e.printStackTrace();  }  
	}
	
	// Method that reads a specific column in excel and inputs it to a linked list
	public static LinkedList <String> readExcelFile(String fileName, int column) throws Exception {
		LinkedList <String> names = new LinkedList<>();
	        // Create a FileInputStream object to read the excel file
	        FileInputStream fileInputStream = new FileInputStream(fileName);

	        // Create a XSSFWorkbook object to work with the excel file
	        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

	        // Get the first sheet in the workbook
	        XSSFSheet sheet = workbook.getSheetAt(0);

	        // Iterate over each row in the sheet
	        for (Row row : sheet) {
	            // Get the first cell in the row
	            Cell cell = row.getCell(column);

	            // Check the cell type and display the value accordingly
	            if (cell != null) {
	               names.add(cell.getStringCellValue());           
	            }
	        }

	        // Close the workbook and the file input stream
	        workbook.close();
	        fileInputStream.close();
	
		return names;
	}
	
	// Method that reads a specific cell in excel and inputs it to a linked list
	public static String readSpecificCell(String fileName, int row, int col) throws Exception {

		
	        // Create a FileInputStream object to read the excel file
	        FileInputStream fileInputStream = new FileInputStream(fileName);

	        // Create a XSSFWorkbook object to work with the excel file
	        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

	        // Get the first sheet in the workbook
	        XSSFSheet sheet = workbook.getSheetAt(0);

	        // Iterate over each row in the sheet
	        Cell cell = sheet.getRow(row).getCell(col);
	        String data = (cell != null) ? cell.getRichStringCellValue().toString() : "";


	        // Close the workbook and the file input stream
	        // workbook.close();
	        // fileInputStream.close();

			if (data == null) {
				return null;
			}
			else {  return data;  }
	
		
	}
	
	public static LinkedList <String> readSpecificColumn(String fileName, int column) throws Exception {
		LinkedList <String> names = new LinkedList<>();
	        // Create a FileInputStream object to read the excel file
	        FileInputStream fileInputStream = new FileInputStream(fileName);

	        // Create a XSSFWorkbook object to work with the excel file
	        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

	        // Get the first sheet in the workbook
	        XSSFSheet sheet = workbook.getSheetAt(0);

	        // Iterate over each row in the sheet
	        for (Row row : sheet) {
				if (row != sheet.getRow(0)) {
					Cell cell = row.getCell(column);
					if (cell != null) {
	              	names.add(cell.getStringCellValue());           
	            	}
				}
	            // Get the first cell in the row
	            

	            // Check the cell type and display the value accordingly
	            
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
			filePath = "C:/Users/carlo/OneDrive/Desktop/pransue/School/FIRST YEAR/ECLIPSE/telemasters/src/Team1.xlsx";
		} else if (User.equalsIgnoreCase("User2")) {
			filePath = "C:/Users/carlo/OneDrive/Desktop/pransue/School/FIRST YEAR/ECLIPSE/telemasters/src/Team2.xlsx";
		} else if (User.equalsIgnoreCase("User3")) {
			filePath = "C:/Users/carlo/OneDrive/Desktop/pransue/School/FIRST YEAR/ECLIPSE/telemasters/src/Team3.xlsx";;
		} else if (User.equalsIgnoreCase("User4")) {
			filePath = "C:/Users/carlo/OneDrive/Desktop/pransue/School/FIRST YEAR/ECLIPSE/telemasters/src/Team4.xlsx";;
		} else {
			return "";
		}
		
		return filePath;
	}
	
	public static String checkTeam(String Team) {
		String filePath = "";
		 
		if (Team.equalsIgnoreCase("Team 1")) {
			filePath = "C:/Users/carlo/OneDrive/Desktop/pransue/School/FIRST YEAR/ECLIPSE/telemasters/src/Team1.xlsx";
		} else if (Team.equalsIgnoreCase("Team 2")) {
			filePath = "C:/Users/carlo/OneDrive/Desktop/pransue/School/FIRST YEAR/ECLIPSE/telemasters/src/Team2.xlsx";
		} else if (Team.equalsIgnoreCase("Team 3")) {
			filePath = "C:/Users/carlo/OneDrive/Desktop/pransue/School/FIRST YEAR/ECLIPSE/telemasters/src/Team3.xlsx";;
		} else if (Team.equalsIgnoreCase("Team 4")) {
			filePath = "C:/Users/carlo/OneDrive/Desktop/pransue/School/FIRST YEAR/ECLIPSE/telemasters/src/Team4.xlsx";;
		} else {
			return "";
		}
		
		return filePath;
	}
	
	public String columnSum(String filePath, int colIndex) {
	    int sum = 0;

	    try {
	        FileInputStream inputStream = new FileInputStream(filePath);
	        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	        XSSFSheet sheet = workbook.getSheetAt(0);

	        // Iterate over each row in the sheet, starting from the second row
	        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
	            Row row = sheet.getRow(rowIndex);
	            if (row != null) {
	                Cell cell = row.getCell(colIndex);
	                if (cell != null) {
	                    if (cell.getCellType() == CellType.NUMERIC) {
	                        sum += (int) cell.getNumericCellValue();
	                    } else if (cell.getCellType() == CellType.STRING) {
	                        try {
	                            sum += Integer.parseInt(cell.getStringCellValue());
	                        } catch (NumberFormatException e) {
	                            System.out.println("Non-numeric value found at row " + rowIndex + ", column " + colIndex);
	                        }
	                    }
	                }
	            }
	        }

	        inputStream.close();
	        workbook.close();

	        String result = String.valueOf(sum);
	        return result;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return ""; // Return an empty string if there's an error
	}
	//merge
	public static void main(String[] args) {
        LinkedList<LeaderEntry> leadersKills = new LinkedList<>();
        LinkedList<LeaderEntry> leadersDefuses = new LinkedList<>();
        LinkedList<LeaderEntry> leadersPlants = new LinkedList<>();
        LinkedList<LeaderEntry> leadersSupport = new LinkedList<>();
        LinkedList<LeaderEntry> leadersMatchMVP = new LinkedList<>();


        String[] fileNames = {
            "C:/Users/carlo/OneDrive/Desktop/pransue/School/FIRST YEAR/ECLIPSE/telemasters/src/Team1.xlsx",
            "C:/Users/carlo/OneDrive/Desktop/pransue/School/FIRST YEAR/ECLIPSE/telemasters/src/Team2.xlsx",
            "C:/Users/carlo/OneDrive/Desktop/pransue/School/FIRST YEAR/ECLIPSE/telemasters/src/Team3.xlsx",
            "C:/Users/carlo/OneDrive/Desktop/pransue/School/FIRST YEAR/ECLIPSE/telemasters/src/Team4.xlsx"
        };

        for (String fileName : fileNames) {
            readExcelFile(fileName, leadersKills, leadersDefuses, leadersPlants, leadersSupport, leadersMatchMVP);
        }

        LeaderEntry maxKills = mergeSort(leadersKills, 2);
        LeaderEntry maxDefuses = mergeSort(leadersDefuses, 6);
        LeaderEntry maxPlants = mergeSort(leadersPlants, 5);
        LeaderEntry maxSupport = mergeSort(leadersSupport, 4);
        LeaderEntry MatchMVP = mergeSortMatchMVP(leadersMatchMVP);

        writeResultsToExcel(maxKills, maxDefuses, maxPlants, maxSupport, MatchMVP);
    }

    public static void readExcelFile(String fileName, LinkedList<LeaderEntry> leadersKills, LinkedList<LeaderEntry> leadersDefuses, LinkedList<LeaderEntry> leadersPlants, LinkedList<LeaderEntry> leadersSupport, LinkedList<LeaderEntry> leadersMatchMVP) {
        try {
            FileInputStream excelFile = new FileInputStream(new File(fileName));
            try (XSSFWorkbook workbook = new XSSFWorkbook(excelFile)) {
				XSSFSheet sheet = workbook.getSheetAt(0);

				for (Row row : sheet) {
				    String playerName = row.getCell(0).getStringCellValue();
				    int kills = readSpecificColumnInt(row, 1); // Read column 2 using index 1
				    int defuses = readSpecificColumnInt(row, 5); // Read column 5 using index 4
				    int plants = readSpecificColumnInt(row, 4);
				    int support = readSpecificColumnInt(row, 3);
				    int deaths = readSpecificColumnInt(row, 2);
				    
				    leadersKills.add(new LeaderEntry(playerName, kills, 0, 0, 0, 0)); // Initialize other values to 0
				    leadersDefuses.add(new LeaderEntry(playerName, 0, defuses, 0, 0, 0)); // Initialize other values to 0
				    leadersPlants.add(new LeaderEntry(playerName, 0, 0, plants, 0, 0)); // Initialize other values to 0
				    leadersSupport.add(new LeaderEntry(playerName, 0, 0, 0, support, 0)); // Initialize other values to 0
				    leadersMatchMVP.add(new LeaderEntry(playerName, kills, 0, 0, support, deaths));


				}
			}
            excelFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int readSpecificColumnInt(Row row, int columnIndex) {
        Cell cell = row.getCell(columnIndex);
        if (cell != null) {
            if (cell.getCellType() == CellType.NUMERIC) {
                return (int) cell.getNumericCellValue();
            } else if (cell.getCellType() == CellType.STRING) {
                try {
                    return Integer.parseInt(cell.getStringCellValue());
                } catch (NumberFormatException e) {
                    return 0; 
                }
            }
        }
        return 0; 
    }

    public static LeaderEntry mergeSort(LinkedList<LeaderEntry> leaders, int columnIndex) {
        if (leaders.size() <= 1) {
            return leaders.getFirst();
        }

        int mid = leaders.size() / 2;
        LinkedList<LeaderEntry> left = new LinkedList<>(leaders.subList(0, mid));
        LinkedList<LeaderEntry> right = new LinkedList<>(leaders.subList(mid, leaders.size()));

        LeaderEntry maxLeft = mergeSort(left, columnIndex);
        LeaderEntry maxRight = mergeSort(right, columnIndex);

        if (columnIndex == 2) {
            return (maxLeft.getKills() >= maxRight.getKills()) ? maxLeft : maxRight;
        } else if (columnIndex == 6) {
            return (maxLeft.getDefuses() >= maxRight.getDefuses()) ? maxLeft : maxRight;
        } else if (columnIndex == 5) {
            return (maxLeft.getPlants() >= maxRight.getPlants()) ? maxLeft : maxRight;
        } else if (columnIndex == 4) {
            return (maxLeft.getSupport() >= maxRight.getSupport()) ? maxLeft : maxRight;
        } else {
            return null;
        }
    }
    
    public static LeaderEntry mergeSortMatchMVP(LinkedList<LeaderEntry> leaders) {
        if (leaders.size() <= 1) {
            return leaders.getFirst();
        }

        int mid = leaders.size() / 2;
        LinkedList<LeaderEntry> left = new LinkedList<>(leaders.subList(0, mid));
        LinkedList<LeaderEntry> right = new LinkedList<>(leaders.subList(mid, leaders.size()));

        LeaderEntry maxLeft = mergeSortMatchMVP(left);
        LeaderEntry maxRight = mergeSortMatchMVP(right);

        // Compare the values individually for Match MVP
        int maxLeftValue = maxLeft.getKills() + maxLeft.getSupport() - maxLeft.getDeaths();
        int maxRightValue = maxRight.getKills() + maxRight.getSupport() - maxRight.getDeaths();

        return (maxLeftValue >= maxRightValue) ? maxLeft : maxRight;
    }

    
    public static void writeResultsToExcel(LeaderEntry maxKills, LeaderEntry maxDefuses, LeaderEntry maxPlants, LeaderEntry maxSupport, LeaderEntry MatchMVP) {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("LeagueLeaders");

            // Create the header row
            Row rowHeader = sheet.createRow(0);
            rowHeader.createCell(0).setCellValue("Category");
            rowHeader.createCell(1).setCellValue("Value");
            rowHeader.createCell(2).setCellValue("Player Name");

            // Create the max defuses row
            Row rowMaxDefuse = sheet.createRow(1);
            rowMaxDefuse.createCell(0).setCellValue("Defuse");
            rowMaxDefuse.createCell(1).setCellValue(maxDefuses.getDefuses());
            rowMaxDefuse.createCell(2).setCellValue(maxDefuses.getPlayerName());

            // Create the max kills row
            Row rowMaxKills = sheet.createRow(2);
            rowMaxKills.createCell(0).setCellValue("Kills");
            rowMaxKills.createCell(1).setCellValue(maxKills.getKills());
            rowMaxKills.createCell(2).setCellValue(maxKills.getPlayerName());
            
            // Create the plants row
            Row rowMaxPlants = sheet.createRow(3);
            rowMaxPlants.createCell(0).setCellValue("Plants");
            rowMaxPlants.createCell(1).setCellValue(maxPlants.getPlants());
            rowMaxPlants.createCell(2).setCellValue(maxPlants.getPlayerName());
            
            // Create the max support row
            Row rowMaxSupport = sheet.createRow(4);
            rowMaxSupport.createCell(0).setCellValue("Support");
            rowMaxSupport.createCell(1).setCellValue(maxSupport.getSupport());
            rowMaxSupport.createCell(2).setCellValue(maxSupport.getPlayerName());
            
            
            Row rowMatchMVP = sheet.createRow(5);
            rowMatchMVP.createCell(0).setCellValue("Match MVP");
            rowMatchMVP.createCell(1).setCellValue(MatchMVP.getKills());
            rowMatchMVP.createCell(2).setCellValue(MatchMVP.getDeaths());
            rowMatchMVP.createCell(3).setCellValue(MatchMVP.getSupport());
            rowMatchMVP.createCell(4).setCellValue(MatchMVP.getPlayerName());

            // Save the workbook to a file
            FileOutputStream outputStream = new FileOutputStream("C:/Users/carlo/OneDrive/Desktop/pransue/School/FIRST YEAR/ECLIPSE/telemasters/src/LeagueLeaders.xlsx");
            workbook.write(outputStream);
            outputStream.close();
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //end of merge
    public void updateLabels(LeagueStats leagueStats) {
        try (FileInputStream fis = new FileInputStream("C:/Users/carlo/OneDrive/Desktop/pransue/School/FIRST YEAR/ECLIPSE/telemasters/src/LeagueLeaders.xlsx");
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
            XSSFSheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

            // Replace these variables with actual cell locations
            String mostKillsName = getCellValue(sheet.getRow(2).getCell(2));
            String mostKillCount = getCellValue(sheet.getRow(2).getCell(1));
            String mostPlantsName = getCellValue(sheet.getRow(3).getCell(2));
            String mostPlantCount = getCellValue(sheet.getRow(3).getCell(1));
            String supportName = getCellValue(sheet.getRow(4).getCell(2));
            String supporAssistCount = getCellValue(sheet.getRow(4).getCell(1));
            String mostDefusesName = getCellValue(sheet.getRow(1).getCell(2));
            String mostDefusesCount = getCellValue(sheet.getRow(1).getCell(1));
            String matchMVPName =  getCellValue(sheet.getRow(5).getCell(4));
            String matchMVPKDA = ( getCellValue(sheet.getRow(5).getCell(1)) + "/" + getCellValue(sheet.getRow(5).getCell(2)) + "/" +  getCellValue(sheet.getRow(5).getCell(3)));
            
            // Update the JLabels in LeagueStats
            leagueStats.updateLabels(mostKillsName, mostKillCount, mostPlantsName, mostPlantCount, supportName, supporAssistCount, mostDefusesName, mostDefusesCount, matchMVPName, matchMVPKDA );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private String getCellValue(Cell cell) {
        if (cell != null) {
            CellType cellType = cell.getCellType();
            switch (cellType) {
                case STRING:
                    return cell.getStringCellValue();
                case NUMERIC:
                    // Check if it's a whole number (integer)
                    if (DateUtil.isCellDateFormatted(cell) || cell.getNumericCellValue() != (int) cell.getNumericCellValue()) {
                        return String.valueOf(cell.getNumericCellValue());
                    } else {
                        return String.valueOf((int) cell.getNumericCellValue());
                    }
                default:
                    return ""; 
            }
        }
        return "";
    }




	// Method that writes on a specific column
	public void writeAtSpecificColumn(String excelFilePath, int column, LinkedList <String> list) {
        
		try {
			FileInputStream inputStream = new FileInputStream(excelFilePath);
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet firstSheet = workbook.getSheetAt(0);
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
					cell = row.getCell(columnIndex);
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
	
	public static void writeIntAtSpecificCell(String excelFilePath, int row, int column, int value) {
	    try {
	        FileInputStream inputStream = new FileInputStream(excelFilePath);
	        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
	        XSSFSheet firstSheet = workbook.getSheetAt(0);

	        Row currentRow = firstSheet.getRow(row);
	        if (currentRow == null) {
	            currentRow = firstSheet.createRow(row);
	        }

	        // Overwrite only the specific cell
	        Cell cell = currentRow.createCell(column);
	        cell.setCellValue(value);

	        inputStream.close();

	        FileOutputStream outputStream = new FileOutputStream(excelFilePath);
	        workbook.write(outputStream);
	        outputStream.close();

	        workbook.close();

	        System.out.println("Successfully written to file");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}



	// Method that writes on a specific column
	public static void writeAtSpecificRow(String excelFilePath, int rowIndex, LinkedList <String> list) {
        
		try {
			FileInputStream inputStream = new FileInputStream(excelFilePath);
			try (XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
				XSSFSheet firstSheet = workbook.getSheetAt(0);
				
				for (int colIndex = 0; colIndex < list.size(); colIndex++) {
					Row row = firstSheet.getRow(rowIndex);
					if (row == null) {
						row = firstSheet.createRow(rowIndex);
					}

					// Overwrite only a specific column (for example, column B)
					// 0-based index, so 1 means the second column
					Cell cell = row.getCell(colIndex);
					if (cell == null) {
						cell = row.getCell(rowIndex);
					}
					cell.setCellValue(list.get(colIndex));
					
				}

				// for (int colIndex = 0; colIndex < list.size(); colIndex++) {
				// 	Row row = firstSheet.getRow(rowIndex);
				// 	Cell cell = row.getCell(rowIndex);
				// 	if (cell == null) {
				// 		cell = row.getCell(rowIndex);
				// 	}
				// 	cell.setCellValue(list.get(colIndex));
					

				inputStream.close();

				FileOutputStream outputStream = new FileOutputStream(excelFilePath);
				workbook.write(outputStream);
				outputStream.close();
			}
			System.out.println("Succesfully written to file");
		
	 } catch (Exception e) {
			e.printStackTrace(); 
		}
	}  
 

	public static LinkedList <String> readTable(String fileName, JTable table) throws Exception {
		LinkedList <String> data = new LinkedList<>();
	        // Create a FileInputStream object to read the excel file
	        FileInputStream fileInputStream = new FileInputStream(fileName);

	        // Create a XSSFWorkbook object to work with the excel file
	        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

	        // Get the first sheet in the workbook
	        XSSFSheet sheet = workbook.getSheetAt(0);

			DefaultTableModel model = (DefaultTableModel) table.getModel();

	        // Iterate over each row in the sheet
	        for (int rowIndex = 1; rowIndex <= model.getRowCount(); rowIndex++) {
	            Row row = sheet.getRow(rowIndex);
				for (int colIndex = 1; colIndex < model.getColumnCount(); colIndex++) {
					Cell cell = row.getCell(colIndex);
					model.setValueAt(cell, rowIndex-1, colIndex);
				}
	        }
	        // Close the workbook and the file input stream
	        workbook.close();
	        fileInputStream.close();
		return data;
	}

	public static void writeTable(String excelFilePath, JTable table) {
        
		try {
			FileInputStream inputStream = new FileInputStream(excelFilePath);
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet firstSheet = workbook.getSheetAt(0);
			
			DefaultTableModel model = (DefaultTableModel) table.getModel();

			for (int rowIndex = 1; rowIndex < model.getRowCount()+1; rowIndex++) {
			Row row = firstSheet.getRow(rowIndex);
				for (int colIndex = 1; colIndex < model.getColumnCount(); colIndex++) {
					Object value = table.getValueAt(rowIndex-1, colIndex);
					if (value != null) {
                        row.createCell(colIndex).setCellValue(value.toString());
                    }
				}
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

