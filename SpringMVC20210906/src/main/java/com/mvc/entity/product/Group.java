package com.mvc.entity.product;

public class Group {
	private Integer gid;//分類IP
	private String gname;//分類名稱
	
	public Group() {
	}
	
	public Group(Integer gid, String gname) {
		super();
		this.gid = gid;
		this.gname = gname;
	}

	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}

	@Override
	public String toString() {
		return "Group [gid=" + gid + ", gname=" + gname + "]";
	}
	
	
	
}
