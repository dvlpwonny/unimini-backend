package com.unimini.enums;

public enum MessageType {

	ENTER("ENTER"), CHAT("CHAT"), LEAVE("LEAVE");

	MessageType(String typeValue) {
		this.typeValue = typeValue;
	}

	private String typeValue;

	@Override
	public String toString() {
		return typeValue;
	}

}
