/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import com.deliverik.framework.utility.IGStringUtils;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:���̵��������� 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class ImportProcessUtils {
	
	/** ����ʵ�� */
	private static ImportProcessUtils entity = null;
	
	/** ��Ϣ�洢���� */
	private Map<String, Object> map = new HashMap<String, Object>();

	/**
	 * ���췽��
	 */
	private ImportProcessUtils(){}
	
	/**
	 * ʵ��ȡ��
	 * @return ����ʵ��
	 */
	public static ImportProcessUtils getInstance(){
		if(entity == null){
			entity = new ImportProcessUtils(); 
			entity.init();
		}
		return entity;
	}
	
	/**
	 * ��ʼ��
	 */
	public void init(){
		//ʵ����buider
		SAXBuilder sb = new SAXBuilder();
		Document doc = null;
		try{
			String webPath = this.getClass().getResource("").getPath().replaceAll("^\\/", "");
			webPath = webPath.substring(0,webPath.indexOf("/com/"));
			webPath = webPath.replaceAll("[\\\\\\/]WEB-INF[\\\\\\/]classes[\\\\\\/]?", "/");
			webPath = webPath.replaceAll("[\\\\\\/]+", "/");
			webPath = webPath.replaceAll("%20", " ");
			if (webPath.matches("^[a-zA-Z]:.*?$")) {

			} else {
				webPath = "/" + webPath;
			}
			webPath += "/";
			webPath = webPath.replaceAll("[\\\\\\/]+", "/");
			//���������ļ�
			doc = sb.build(new FileInputStream(webPath + "/WEB-INF/importProcess.xml"));
		}catch (Exception e) {
			throw new RuntimeException("���������ļ�ʧ��");
		}
		//ȡ�ø��ڵ�
		Element root = doc.getRootElement();
		//ȡ��������
		List<Element> list = root.getChildren();
		for(Element e:list){
			String key = e.getChildText("key");
			String type = e.getChildText("type");
			Object value = getValue(e,type);
			map.put(key, value);
		}
		
	}
	
	/**
	 * ȡ����������
	 * @param e xml�ڵ�
	 * @param type ��������
	 * @return ���ö���
	 */
	private Object getValue(Element e, String type) {
		Object obj = null;
		if("string".equals(type)){
			obj = e.getChildText("value");
		}
		if("list".equals(type)){
			List<Element> list = e.getChild("values").getChildren();
			List<String> valList = new ArrayList<String>();
			for(Element el:list){
				valList.add(el.getText());
			}
			obj = valList;
		}
		if("map".equals(type)){
			List<Element> list = e.getChild("values").getChildren();
			Map<String, String> map = new LinkedHashMap<String, String>();
			for(Element el:list){
				map.put(el.getChildText("key"), el.getChildText("value"));
			}
			obj = map;
		}
		return obj;
	}
	
	/**
	 * ����ȡ��
	 * @param key ���ñ�ʶ
	 * @return ���ö���
	 */
	public Object get(String key){
		return map.get(key);
	}
	
	/**
	 * ʱ���ȡ��
	 * @return ʱ���
	 */
	public String getTimestamp(){
		return IGStringUtils.getAttKey();
	}
}
