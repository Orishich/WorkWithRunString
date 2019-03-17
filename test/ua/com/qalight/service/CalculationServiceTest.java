package ua.com.qalight.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ua.com.qalight.entity.Currency;
import ua.com.qalight.entity.CurrencyEntity;

class CalculationServiceTest {

	@Test
	void testGetSellPrice() {
		CurrencyEntity currencyEntity = new CurrencyEntity(Currency.EUR, 10.0);
		assertEquals(11.0, CalculationService.getSellPrice(currencyEntity), 0.1);
	}
	
	@Test
	void testGetBuyPrice() {
		CurrencyEntity currencyEntity = new CurrencyEntity(Currency.EUR, 10.0);
		assertEquals(10.5, CalculationService.getBuyPrice(currencyEntity), 0.1);
	}
}