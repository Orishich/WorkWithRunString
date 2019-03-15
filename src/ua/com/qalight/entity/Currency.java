package ua.com.qalight.entity;

public enum Currency {

	USD("$", "USD", 840),
	EUR("€", "EUR", 978),
	RUB("₽", "RUB", 643);
	
	private final String symbol;
	private final String shortName;
	private final Integer code;
	
	Currency(String symbol, String shortName, Integer code) {
		this.symbol = symbol;
		this.shortName = shortName;
		this.code = code;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getShortName() {
		return shortName;
	}

	public Integer getCode() {
		return code;
	}

}