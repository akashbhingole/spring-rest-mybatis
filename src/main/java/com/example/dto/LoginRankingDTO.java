package com.example.dto;

public class LoginRankingDTO {
    private String username;
    private int loginCount;
    private int rank;
    private int tieCount;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getLoginCount() {
		return loginCount;
	}
	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getTieCount() {
		return tieCount;
	}
	public void setTieCount(int tieCount) {
		this.tieCount = tieCount;
	}
    
    
}
