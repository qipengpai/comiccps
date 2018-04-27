package com.qpp.comiccps.basics.entity.data;

public class FeedBackData {
	private String id = "";
	private String content = "";      //反馈内容
	private String backDate="";	      //反馈时间
	private String implDaye="";       //操作时间
	private String userId;
	private String userName;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getBackDate() {
		return backDate;
	}
	public void setBackDate(String backDate) {
		this.backDate = backDate;
	}
	public String getImplDaye() {
		return implDaye;
	}
	public void setImplDaye(String implDaye) {
		this.implDaye = implDaye;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
