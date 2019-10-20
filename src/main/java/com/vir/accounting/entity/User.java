package com.vir.accounting.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author Admin
 *
 */
@Entity
public class User implements Serializable{

    private static final long serialVersionUID = 0x62A6DA99AABDA8A8L;
	
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer clientId;
    @Column
    private String clientName;
   
    @Column
    private String clientCode;
   
    @Column
    private String bseCode;
    
    @Column
    private String nseCode;
    
    @Column
    private String fnoCode;
    
    
    public User(Integer clientId, String clientName, String clientCode, String bseCode, String nseCode, String fnoCode) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.clientCode = clientCode;
        this.bseCode = bseCode;
        this.nseCode = nseCode;
        this.fnoCode =fnoCode;
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


	public String getFnoCode() {
		return fnoCode;
	}

	public void setFnoCode(String fnoCode) {
		this.fnoCode = fnoCode;
	}

	public String getNseCode() {
		return nseCode;
	}


	public void setNseCode(String nseCode) {
		this.nseCode = nseCode;
	}


	public User() {
    }

   
}
