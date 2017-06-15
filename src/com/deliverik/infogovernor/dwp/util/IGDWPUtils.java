/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dwp.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 日常工作计划工具类
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWPUtils {
	
	/** 任务执行周期类型：仅一次 */
	public static final String TASK_EXECUTE_TYPE_ONCE = "0";
	
	/** 任务执行周期流程：日 */
	public static final String TASK_EXECUTE_TYPE_DAY = "1";
	
	/** 任务执行周期流程：周 */
	public static final String TASK_EXECUTE_TYPE_WEEK = "2";
	
	/** 任务执行周期流程：月 */
	public static final String TASK_EXECUTE_TYPE_MONTH = "3";
	
	/** 任务执行周期流程：季度 */
	public static final String TASK_EXECUTE_TYPE_QUARTER = "4";
	
	/** 任务方式：短信*/
	public static final String TASK_MODE_SMS = "0";
	
	/** 任务方式：工作*/
	public static final String TASK_MODE_WORK = "1";
	
	/** 分派标识 */
	public static final String ASSIGN_FLAG_YES = "assign";
	
	/** 是否添加JOB：是 */
	public static final String IS_ADD_JOB_YES = "1";
	
	/** 是否添加JOB：否 */
	public static final String IS_ADD_JOB_NO = "0";
	
	/** 构造方法 */
	private IGDWPUtils(){};
	
	/** 对象实例 */
	private static IGDWPUtils entity = null;
	
	/**
	 * 实例取得
	 * @return 实例
	 */
	public static IGDWPUtils getInstance(){
		if(entity == null){
			entity = new IGDWPUtils();
		}
		return entity;
	}

	/**
	 * 取得配置的流程
	 * @return 流程定义ID集合
	 */
	@SuppressWarnings("unchecked")
	public List<String> getProcessDefinitions(){
		String filename = this.getClass().getResource("").getPath() + "IGDWP-config.xml";
		List<String> list = new ArrayList<String>();
		try{
			//实例化buider
			SAXBuilder sb = new SAXBuilder();
			//加载配置文件
			Document doc = sb.build(new FileInputStream(filename));
			//取得根节点
			Element root = doc.getRootElement();
			Element child = root.getChild("processes");
			for(Iterator<Element> iter = child.getChildren("process").iterator();iter.hasNext();){
				Element next = iter.next();
				String pdid = next.getAttributeValue("pdid");
				list.add(pdid);
			}
		}catch (Exception e) {
			throw new RuntimeException("加载配置文件失败",e);
		}
		return list;
	}
}
