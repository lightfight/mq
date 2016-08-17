package com.lightfight.mq;

import java.io.Serializable;

public class PlayerTO implements Serializable {

	/**  **/
	private static final long serialVersionUID = -4608209697546014561L;

	private long pid;
	
	private String pname;

	private int fightforce;

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getFightforce() {
		return fightforce;
	}

	public void setFightforce(int fightforce) {
		this.fightforce = fightforce;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append("pid = ").append(pid).append(", ");
		builder.append("pname = ").append(pname).append(", ");
		builder.append("fightforce = ").append(fightforce);
		
		return builder.toString();
	}

}
