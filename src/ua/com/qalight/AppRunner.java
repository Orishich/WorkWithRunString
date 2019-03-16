package ua.com.qalight;

import java.util.List;
import java.util.Map;

import ua.com.qalight.entity.CurrencyEntity;
import ua.com.qalight.service.FileManager;
import ua.com.qalight.util.CurrencyMapper;

public class AppRunner {

	public static void main(String[] args) {
		
		runWithTimeout(24);
		
	}
	
	static void runWithTimeout(int hours) {
		while (true) {
			Map<String, Double> currencyMap = FileManager.readInputCurrencyValues();
			List<CurrencyEntity> currencyEntities = CurrencyMapper.getFromMap(currencyMap);
			
			for (CurrencyEntity currencyEntity : currencyEntities) {
				FileManager.writeCurrencyValuesToFile(currencyEntity, currencyMap);
			}
			
			try {
				Thread.sleep(1000*60*60*hours);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}