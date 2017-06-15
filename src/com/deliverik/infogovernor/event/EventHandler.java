package com.deliverik.infogovernor.event;

public interface EventHandler {
	public Status fireEvent(Event event);
	
	public void loadProfile(Profile profile);
}
