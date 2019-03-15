package ua.com.qalight.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ua.com.qalight.entity.Currency;
import ua.com.qalight.entity.CurrencyEntity;

public class CurrencyMapper {

	public static List<CurrencyEntity> getFromMap(Map<String, Double> currencyMap) {
		Set<CurrencyEntity> currencyEntities = new HashSet<>();
		Currency[] currencies = Currency.values();
		for (String key : currencyMap.keySet()) {
			for (int i = 0; i < currencies.length; i++) {
				if(currencies[i].getCode().equals(Integer.parseInt(key))) {
					CurrencyEntity currencyEntity = new CurrencyEntity();
					currencyEntity.setCurrency(currencies[i]);
					currencyEntity.setValue(currencyMap.get(key));
					currencyEntities.add(currencyEntity);
				}
			}
		}
		
		return new ArrayList<CurrencyEntity>(currencyEntities);
	}
}