/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ�������
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWPUtils {
	
	/** ����ִ���������ͣ���һ�� */
	public static final String TASK_EXECUTE_TYPE_ONCE = "0";
	
	/** ����ִ���������̣��� */
	public static final String TASK_EXECUTE_TYPE_DAY = "1";
	
	/** ����ִ���������̣��� */
	public static final String TASK_EXECUTE_TYPE_WEEK = "2";
	
	/** ����ִ���������̣��� */
	public static final String TASK_EXECUTE_TYPE_MONTH = "3";
	
	/** ����ִ���������̣����� */
	public static final String TASK_EXECUTE_TYPE_QUARTER = "4";
	
	/** ����ʽ������*/
	public static final String TASK_MODE_SMS = "0";
	
	/** ����ʽ������*/
	public static final String TASK_MODE_WORK = "1";
	
	/** ���ɱ�ʶ */
	public static final String ASSIGN_FLAG_YES = "assign";
	
	/** �Ƿ����JOB���� */
	public static final String IS_ADD_JOB_YES = "1";
	
	/** �Ƿ����JOB���� */
	public static final String IS_ADD_JOB_NO = "0";
	
	/** ���췽�� */
	private IGDWPUtils(){};
	
	/** ����ʵ�� */
	private static IGDWPUtils entity = null;
	
	/**
	 * ʵ��ȡ��
	 * @return ʵ��
	 */
	public static IGDWPUtils getInstance(){
		if(entity == null){
			entity = new IGDWPUtils();
		}
		return entity;
	}

	/**
	 * ȡ�����õ�����
	 * @return ���̶���ID����
	 */
	@SuppressWarnings("unchecked")
	public List<String> getProcessDefinitions(){
		String filename = this.getClass().getResource("").getPath() + "IGDWP-config.xml";
		List<String> list = new ArrayList<String>();
		try{
			//ʵ����buider
			SAXBuilder sb = new SAXBuilder();
			//���������ļ�
			Document doc = sb.build(new FileInputStream(filename));
			//ȡ�ø��ڵ�
			Element root = doc.getRootElement();
			Element child = root.getChild("processes");
			for(Iterator<Element> iter = child.getChildren("process").iterator();iter.hasNext();){
				Element next = iter.next();
				String pdid = next.getAttributeValue("pdid");
				list.add(pdid);
			}
		}catch (Exception e) {
			throw new RuntimeException("���������ļ�ʧ��",e);
		}
		return list;
	}
}
