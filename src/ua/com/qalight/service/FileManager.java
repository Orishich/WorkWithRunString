package ua.com.qalight.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import ua.com.qalight.entity.CurrencyEntity;


public class FileManager {

	private static final String INPUT_FILE_PATH = 
			System.getProperty("user.dir") + 
			System.getProperty("file.separator") + 
			"files" + 
			System.getProperty("file.separator") + 
			"inputFile.txt";	
	
	private static final String OUTPUT_FILE_PATH = 
			System.getProperty("user.dir") + 
			System.getProperty("file.separator") + 
			"files" + 
			System.getProperty("file.separator") + 
			"outputFile.txt";

		
	public static Map<String, Double> readInputCurrencyValues(){
		HashMap<String, Double> inputCodeNbu = new HashMap<>();
		try (Scanner fileScanner = new Scanner (new File (INPUT_FILE_PATH))) {
			while (fileScanner.hasNextLine()) {
				String[] codeNbu = fileScanner.nextLine().split(", ");
				inputCodeNbu.put(codeNbu[0], Double.parseDouble(codeNbu[1]));
			}
			fileScanner.close();
		}
			catch (FileNotFoundException e) {
			}
					
		return inputCodeNbu;
	}
	

	public static void writeCurrencyValuesToFile(List<CurrencyEntity> currencies) {
		try (FileWriter writer = new FileWriter(OUTPUT_FILE_PATH, false)) {
			String outText = "";
			for (CurrencyEntity currencyEntity : currencies) {
				outText += currencyEntity.getCurrency().getShortName() + "(" + currencyEntity.getCurrency().getSymbol()
						+ ")" + " - " + CalculationService.getBuyPrice(currencyEntity) + "/"
						+ CalculationService.getSellPrice(currencyEntity) + " - " + currencyEntity.getValue() + "\n";
			}
			writer.write(outText);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}