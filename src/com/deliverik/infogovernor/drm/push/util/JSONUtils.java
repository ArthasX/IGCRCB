package com.deliverik.infogovernor.drm.push.util;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;


public class JSONUtils {
    //通知发布type
    public static final String NOTICETYPE="2";
    //流程信息发布type
    public static final String FLOWTYPE="1";
	/**
	 * 将消息记录转为JSON
	 * 将字符串转为可识别的JSON格式字符串
	 * noticeTime：消息推送时间
	 * noticeContnt： 消息内容
	 * noticeUser：消息发布人姓名
	 * noticeId:消息ID
	 * target:推送目标ID(prid)
	 * noticeType: 1 = 流程处理记录,2 = 系统通知发布
	 */
	public static String getNotisJSON(String noticeTime,String noticeContnt,String noticeUser,String noticeId,String noticeType,String target,String psdid){
		Gson gson = new Gson();
		HashMap<String,Object> typeMap = new HashMap<String,Object>();
		HashMap<String,String> dataMap = new HashMap<String,String>();
		dataMap.put("noticeTime", noticeTime);
		dataMap.put("noticeContnt", noticeContnt);
		dataMap.put("noticeUser", noticeUser);
		dataMap.put("noticeId", noticeId);
		dataMap.put("noticeType", noticeType);
		typeMap.put("target", target);
		typeMap.put("type","3");//指挥流程推送，消息发布
		typeMap.put("data",dataMap);
		typeMap.put("currentId", psdid);
		return gson.toJson(typeMap);
	}
	
	/**
	 * 将消息记录转为JSON
	 * prid：消息ID
	 * psdid：流程节点ID
	 * bySerence：流程节点排序
	 * statusTime:进入状态时间
	 * target： 推送目标(prid)
	 * @return 0 = 成功,1 = 失败
	 */
	public static String getProcessInfoJSON(String psdid,String bySerence,String statusTime,String useTime,String target){
		Gson gson = new Gson();
		HashMap<String,Object> typeMap = new HashMap<String,Object>();
		HashMap<String,String> dataMap = new HashMap<String,String>();
		dataMap.put("psdid", psdid);
		dataMap.put("bySerence", bySerence);
		dataMap.put("statusTime", statusTime);
		dataMap.put("useTime", useTime);
		typeMap.put("target", target);
		typeMap.put("type","2");
		typeMap.put("data",dataMap);
		return gson.toJson(typeMap);
	}
	
	/***
	 * 取得JSON字符串指定KEY的值
	 * @param jsonString
	 * @param key
	 * @return value
	 */
	public static String getValueForJSON(String jsonString,String key){
		Gson gson = new Gson();
		@SuppressWarnings("unchecked")
		HashMap<String,String> typeMap = gson.fromJson(jsonString, HashMap.class);
		return typeMap.get(key);
	}
	
	/***
	 * 取得JSON字符串指定KEY的值
	 * @param jsonString
	 * @param key
	 * @return value
	 */
	public static String getJsonForMap(Map<String,Object> jsonMap){
		Gson gson = new Gson();
		return gson.toJson(jsonMap);
	}
}
