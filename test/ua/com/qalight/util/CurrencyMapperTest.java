package ua.com.qalight.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import ua.com.qalight.entity.CurrencyEntity;

class CurrencyMapperTest {

	@Test
	void testGetFromMap() {
		Map<String, Double> currencyMap = new HashMap<String, Double>();
		currencyMap.put("840", 10.11);
		currencyMap.put("978", 20.22);
		List<CurrencyEntity> currencies = CurrencyMapper.getFromMap(currencyMap);
		
		assertNotNull(currencies);
		assertEquals(2, currencies.size());
		
		assertEquals(Long.valueOf(840), Long.valueOf(currencies.get(0).getCurrency().getCode()));
 		assertEquals(20.22, currencies.get(1).getValue(), 0.01);
	}

}