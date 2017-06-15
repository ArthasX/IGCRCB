package com.deliverik.infogovernor.nms.event;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import nl.justobjects.pushlet.core.Dispatcher;
import nl.justobjects.pushlet.core.Event;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 概述: 拓扑扫描进度信息实时推送
 * 功能描述: 拓扑扫描进度信息实时推送
 * 创建记录: 2013/12/20
 * 修改记录:
 */
public class IGNMS0101Pushlet {
	
    static Log log = LogFactory.getLog(IGNMS0101Pushlet.class);

	/** 事件标识 */
	public final static String eventID = "/Push_IGNMS0101";

	/**
	 * 推送数据处理 页面通过获取参数集合中的key获取对应值
	 * 
	 * @param param
	 *            参数集合
	 */
	public synchronized static void pushData(Map<String, String> param) {
        log.debug("=========== 事件推送开始 ==========");
		// 创建事件
		Event event = Event.createDataEvent(eventID);
		if (param != null) {
			// 封装参数信息
			for (String key : param.keySet()) {
			    String value = param.get(key);
			    if (StringUtils.isNotEmpty(value)) {
			        event.setField(key, toISO88591(param.get(key)));
			    }
			}
		}
		// 向请求“/Push_IGNMS0101”的事件推送数据
		Dispatcher.getInstance().multicast(event);
        log.debug("=========== 事件推送结束 ==========");
	}

	/**
	 * 中文转码
	 * @param str 内容
	 * @return 转码后的内容
	 */
	public static String toISO88591(String str) {
		try {
			str = new String(str.getBytes("UTF-8"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			log.error("转码错误", e);
			return "transcoding error";
		}
		return str;
	}
}
