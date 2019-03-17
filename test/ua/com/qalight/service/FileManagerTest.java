package ua.com.qalight.service;

import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import ua.com.qalight.entity.CurrencyEntity;
import ua.com.qalight.util.CurrencyMapper;

class FileManagerTest {
	
	@Test
	void testReadInputCurrencyValues() {
		Map<String, Double> currencyMap = FileManager.readInputCurrencyValues();
		assertNotNull(currencyMap);
		assertEquals(27.38, currencyMap.get("840"), 3);
		assertEquals(32.73, currencyMap.get("978"), 3);
		assertEquals(3.68, currencyMap.get("643"), 5);
	}
	
	@Test
	void testWriteCurrencyValuesToFile() {
		Map<String, Double> currencyMap = new HashMap<String, Double>();
		currencyMap.put("840", 10.00);
		currencyMap.put("978", 1.00);
		List<CurrencyEntity> currencies = CurrencyMapper.getFromMap(currencyMap);
		
		FileManager.writeCurrencyValuesToFile(currencies);
		String filePath = System.getProperty("user.dir") + System.getProperty("file.separator")
		+ "files" + System.getProperty("file.separator") + "outputFile.txt";
		
		try (FileReader fileReader = new FileReader(filePath);
				BufferedReader bufferedReader = new BufferedReader(fileReader)){
			String result = "";
			String text = "";
			while ((text = bufferedReader.readLine()) != null) {
				result += text; 
			}
//			
//			String expectedResult = "USD($) - 11.0/10.5 - 10.0EUR(€) - 1.1/1.05 - 1.0";
//			assertEquals(expectedResult, result);
			
			assertTrue(result.contains("USD($) - "));
			assertTrue(result.contains("EUR(€) - "));
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
	
	@AfterAll
	public static void rewriteOriginData() {
		Map<String, Double> currencyMap = FileManager.readInputCurrencyValues();
		List<CurrencyEntity> currencyEntities = CurrencyMapper.getFromMap(currencyMap);

		FileManager.writeCurrencyValuesToFile(currencyEntities);
	}

}