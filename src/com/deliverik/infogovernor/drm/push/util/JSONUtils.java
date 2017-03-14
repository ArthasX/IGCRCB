package com.deliverik.infogovernor.drm.push.util;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;


public class JSONUtils {
    //֪ͨ����type
    public static final String NOTICETYPE="2";
    //������Ϣ����type
    public static final String FLOWTYPE="1";
	/**
	 * ����Ϣ��¼תΪJSON
	 * ���ַ���תΪ��ʶ���JSON��ʽ�ַ���
	 * noticeTime����Ϣ����ʱ��
	 * noticeContnt�� ��Ϣ����
	 * noticeUser����Ϣ����������
	 * noticeId:��ϢID
	 * target:����Ŀ��ID(prid)
	 * noticeType: 1 = ���̴����¼,2 = ϵͳ֪ͨ����
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
		typeMap.put("type","3");//ָ���������ͣ���Ϣ����
		typeMap.put("data",dataMap);
		typeMap.put("currentId", psdid);
		return gson.toJson(typeMap);
	}
	
	/**
	 * ����Ϣ��¼תΪJSON
	 * prid����ϢID
	 * psdid�����̽ڵ�ID
	 * bySerence�����̽ڵ�����
	 * statusTime:����״̬ʱ��
	 * target�� ����Ŀ��(prid)
	 * @return 0 = �ɹ�,1 = ʧ��
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
	 * ȡ��JSON�ַ���ָ��KEY��ֵ
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
	 * ȡ��JSON�ַ���ָ��KEY��ֵ
	 * @param jsonString
	 * @param key
	 * @return value
	 */
	public static String getJsonForMap(Map<String,Object> jsonMap){
		Gson gson = new Gson();
		return gson.toJson(jsonMap);
	}
}
