package com.deliverik.infogovernor.nms.event;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

import nl.justobjects.pushlet.core.Event;
import nl.justobjects.pushlet.core.EventPullSource;

@SuppressWarnings("serial")
public class TestPullPlushlet extends EventPullSource implements Serializable{
	int i =1;

		@Override
		protected long getSleepTime() {
			return 5000; // 刷新时间
		}

		@Override
		protected Event pullEvent() {
			String s = "你好" + i++ + "次";
			Event event = Event.createDataEvent("/ID001");// 事件标识
			s = toISO88591(s);
			event.setField("msg", s);// 封装参数
			return event;
		}
		
		public static String toISO88591(String str) {  
	        try {  
	            str = new String(str.getBytes("UTF-8"), "ISO-8859-1");  
	        } catch (UnsupportedEncodingException ex) {  
	            ex.printStackTrace();  
	        }  
	        return str;  
	    }  


}