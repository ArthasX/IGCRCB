package com.deliverik.infogovernor.event;

public interface Event {
	
	public String getDestination();
	
	public String getTimestamp();
	
	public String getContent();
	
	public String getEventType();
	
	public String getTitle();

}
