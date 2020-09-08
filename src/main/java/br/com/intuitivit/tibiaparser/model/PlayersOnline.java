package br.com.intuitivit.tibiaparser.model;

import java.sql.Date;

public class PlayersOnline {

	private String world;
	private Integer online;
	private String location;
	private String pvpType;
	private Boolean battlEye;
	private String additionalInformation;
	
	private Date data;
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Boolean getBattlEye() {
		return battlEye;
	}
	public void setBattlEye(Boolean battlEye) {
		this.battlEye = battlEye;
	}
	public String getWorld() {
		return world;
	}
	public void setWorld(String world) {
		this.world = world;
	}
	public Integer getOnline() {
		return online;
	}
	public void setOnline(Integer online) {
		this.online = online;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPvpType() {
		return pvpType;
	}
	public void setPvpType(String pvpType) {
		this.pvpType = pvpType;
	}
	
	public String getAdditionalInformation() {
		return additionalInformation;
	}
	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}
	@Override
	public String toString() {
		return "PlayersOnline world=" + world + ", online=" + online + ", location=" + location + ", pvpType="
				+ pvpType + ", battlEye=" + battlEye + ", additionalInformation=" + additionalInformation ;
	}
	
	
	
}
