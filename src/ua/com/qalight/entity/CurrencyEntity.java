package ua.com.qalight.entity;

import ua.com.qalight.service.CalculationService;

public class CurrencyEntity {

	private Currency currency;
	private Double value;
	
	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public CurrencyEntity(Currency currency, Double value) {
		this.currency = currency;
		this.value = value;
	}

	public CurrencyEntity() {
	}
	

	@Override
	public String toString() {
		return currency.getShortName() + "(" + currency.getSymbol() 
		+ ")" + "-" + CalculationService.getSellPrice(currencyEntity) + " - " + CalculationService.getBuyPrice(currencyEntity) + "\n";

				
//				currency + "-" + value;
	}
	
}