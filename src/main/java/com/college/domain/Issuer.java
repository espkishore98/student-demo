package com.college.domain;

public class Issuer {
	String issuerkey;
	String issuerSecretKey;

	
	public String getIssuerkey() {
		return issuerkey;
	}
	public void setIssuerkey(String issuerkey) {
		this.issuerkey = issuerkey;
	}
	public String getIssuerSecretKey() {
		return issuerSecretKey;
	}
	public void setIssuerSecretKey(String issuerSecretKey) {
		this.issuerSecretKey = issuerSecretKey;
	}
	public Issuer() {
		super();
	}
	public Issuer(String issuerkey, String issuerSecretKey) {
		super();
		this.issuerkey = issuerkey;
		this.issuerSecretKey = issuerSecretKey;
	}
	@Override
	public String toString() {
		return "Issuer [issuerkey=" + issuerkey + ", issuerSecretKey=" + issuerSecretKey + "]";
	}

}
