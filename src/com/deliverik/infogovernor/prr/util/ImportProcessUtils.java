/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:流程导出工具类 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("unchecked")
public class ImportProcessUtils {
	
	/** 对象实例 */
	private static ImportProcessUtils entity = null;
	
	/** 信息存储对象 */
	private Map<String, Object> map = new HashMap<String, Object>();

	/**
	 * 构造方法
	 */
	private ImportProcessUtils(){}
	
	/**
	 * 实例取得
	 * @return 对象实例
	 */
	public static ImportProcessUtils getInstance(){
		if(entity == null){
			entity = new ImportProcessUtils(); 
			entity.init();
		}
		return entity;
	}
	
	/**
	 * 初始化
	 */
	public void init(){
		//实例化buider
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
			//加载配置文件
			doc = sb.build(new FileInputStream(webPath + "/WEB-INF/importProcess.xml"));
		}catch (Exception e) {
			throw new RuntimeException("加载配置文件失败");
		}
		//取得根节点
		Element root = doc.getRootElement();
		//取得配置项
		List<Element> list = root.getChildren();
		for(Element e:list){
			String key = e.getChildText("key");
			String type = e.getChildText("type");
			Object value = getValue(e,type);
			map.put(key, value);
		}
		
	}
	
	/**
	 * 取得配置内容
	 * @param e xml节点
	 * @param type 配置类型
	 * @return 配置对象
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
	 * 配置取得
	 * @param key 配置标识
	 * @return 配置对象
	 */
	public Object get(String key){
		return map.get(key);
	}
	
	/**
	 * 时间戳取得
	 * @return 时间戳
	 */
	public String getTimestamp(){
		return IGStringUtils.getAttKey();
	}
}
