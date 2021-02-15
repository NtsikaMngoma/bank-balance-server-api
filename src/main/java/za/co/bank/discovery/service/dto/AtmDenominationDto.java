package za.co.bank.discovery.service.dto;

import java.io.Serializable;

public class AtmDenominationDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int key;
	private int count;

	public AtmDenominationDto(int key, int count) {
		this.key = key;
		this.count = count;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
