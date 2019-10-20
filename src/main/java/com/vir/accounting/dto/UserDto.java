package com.vir.accounting.dto;


/**
 * 
 * @author Admin
 *
 */
public class UserDto {
	private Integer clientId;
    
    private String clientName;
   
    private String clientCode;
   
    private String bseCode;
    
    private String nseCode;
    

    private String fnoCode;
    
    public String getFnoCode() {
		return fnoCode;
	}

	public void setFnoCode(String fnoCode) {
		this.fnoCode = fnoCode;
	}

	public UserDto(Integer clientId, String clientName, String clientCode, String bseCode, String nseCode, String fnoCode) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientCode = clientCode;
        this.bseCode = bseCode;
        this.nseCode = nseCode;
        this.fnoCode =fnoCode;
    }

    public UserDto() {
    }

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientCode() {
		return clientCode;
	}

	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	public String getBseCode() {
		return bseCode;
	}

	public void setBseCode(String bseCode) {
		this.bseCode = bseCode;
	}

	public String getNseCode() {
		return nseCode;
	}

	public void setNseCode(String nseCode) {
		this.nseCode = nseCode;
	}



}
