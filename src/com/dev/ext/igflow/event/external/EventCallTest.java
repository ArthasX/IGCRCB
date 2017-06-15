package com.dev.ext.igflow.event.external;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowExternalBL;
import com.deliverik.framework.platform.WebApplicationSupport;

public class EventCallTest {

	/**
	 * @param args
	 * @throws BLException 
	 */
	public void test() throws BLException{
		
		FlowExternalBL bl = (FlowExternalBL)WebApplicationSupport.getBean("flowExternalBL");
		IGParam param = new IGParam();
		param.setParam1("param1");
		param.setParam2("param2");
		param.setParam3(3455);
		bl.eventHandler("eventID", param);
	}

}
