package com.nisuniversity.spring.entity;

public enum Role {
	ADMIN("ROLE_ADMIN"), USER("ROLE_USER");

	private String type;
	
	Role(String type){
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
	
}
