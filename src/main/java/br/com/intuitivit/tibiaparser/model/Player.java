package br.com.intuitivit.tibiaparser.model;

import java.sql.Date;

public class Player {

	private String rank;
	private String name;
	private String vocation;
	private Integer lvl;
	private String world;
	private Date joiningDate;
	private Integer worldId;
	private Date data;
	private Date lastLogin;
	private Integer guildId;
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVocation() {
		return vocation;
	}
	public void setVocation(String vocation) {
		this.vocation = vocation;
	}
	public Integer getLvl() {
		return lvl;
	}
	public void setLvl(Integer lvl) {
		this.lvl = lvl;
	}
	public String getWorld() {
		return world;
	}
	public void setWorld(String world) {
		this.world = world;
	}
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public Integer getWorldId() {
		return worldId;
	}
	public void setWorldId(Integer worldId) {
		this.worldId = worldId;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public Integer getGuildId() {
		return guildId;
	}
	public void setGuildId(Integer guildId) {
		this.guildId = guildId;
	}
	
	

}
