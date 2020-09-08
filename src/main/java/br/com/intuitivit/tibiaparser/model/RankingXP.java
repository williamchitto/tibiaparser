package br.com.intuitivit.tibiaparser.model;

import java.sql.Date;

public class RankingXP {

	private Integer rank;
	private String name;
	private String vocation;
	private Integer lvl;
	private Long points;
	private String world;
	private Integer worldId;
	private Date data;
	
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getWorld() {
		return world;
	}
	public void setWorld(String world) {
		this.world = world;
	}
	public Integer getWorldId() {
		return worldId;
	}
	public void setWorldId(Integer worldId) {
		this.worldId = worldId;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
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
	public Long getPoints() {
		return points;
	}
	public void setPoints(Long points) {
		this.points = points;
	}
	@Override
	public String toString() {
		return "RankingXP rank=" + rank + ", name=" + name + ", vocation=" + vocation + ", lvl=" + lvl + ", points="
				+ points + ", world=" + world + ", worldId=" + worldId;
	}

	
	
}
