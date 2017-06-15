/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.taglib;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.Globals;
import org.apache.struts.taglib.TagUtils;
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.model.Action;

/**
 * ����: �˵�������ǩ
 * ��������: �˵�������ǩ
 * ������¼: 2011/09/23
 * �޸ļ�¼: 2011/09/23
 */
@SuppressWarnings("serial")
public class NavigationWriteTag extends TagSupport {
	
	/** �Զ��嵼������1 */
	protected String extname1;
	
	/** �Զ��嵼������2 */
	protected String extname2;
	
	/** �Զ��嵼������3 */
	protected String extname3;
	
	/** �Զ��嵼������4 */
	protected String extname4;
	
	public int doStartTag() throws JspException {
		
		String out = "";  //��ǩ����ַ���
		
		//�˵���ʶIDȡ��
		String actsortid = (String) pageContext.getSession().getAttribute("igactionid");
		
		//ActionBLȡ��
//		ActionBL actionBL = (ActionBL) WebApplicationSupport.getBean("actionBL");
		//�˵���Ϣȡ��
		UserPermission userPermission = (UserPermission) pageContext.getSession().getAttribute("UserPermission");
		List<Map<Action, List<Map<Action, List<Map<Action, List<Action>>>>>>> actionList = userPermission.getActionList();
		
		//���ݲ˵���ʶ��ϵ�����Ϣ
		if(StringUtils.isNotEmpty(actsortid) && actsortid.length() >= 2){
			for(Map<Action, List<Map<Action, List<Map<Action, List<Action>>>>>> map: actionList) {
				
				Set<Entry<Action, List<Map<Action, List<Map<Action, List<Action>>>>>>> set1 = map.entrySet();
				for(Iterator<Entry<Action, List<Map<Action, List<Map<Action, List<Action>>>>>>> iter1 = set1.iterator();iter1.hasNext();){
					Entry<Action, List<Map<Action, List<Map<Action, List<Action>>>>>> next1 = iter1.next();
					
					//�ҵ���Ӧ��һ���˵�
					if(actsortid.substring(0, 2).equals(next1.getKey().getActsortid())){
						
						//��һ���˵���ϵ�������Ϣ��
//						out = getActionLabel(next1.getKey().getActlabel());
						out = next1.getKey().getActlabel();
						
						//���˵���ʶ���ڵ���4ʱ�������ҵ������˵�
						if(actsortid.length() >= 4){
							
							//��¼�����˵���ϢList
							List<Map<Action, List<Map<Action, List<Action>>>>> list2 = next1.getValue();
							for (Map<Action, List<Map<Action, List<Action>>>> map2 : list2) {
								
								Set<Entry<Action, List<Map<Action, List<Action>>>>> set2 = map2.entrySet();
								for(Iterator<Entry<Action, List<Map<Action, List<Action>>>>> iter2 = set2.iterator();iter2.hasNext();){
									Entry<Action, List<Map<Action, List<Action>>>> next2 = iter2.next();
									
									//�ҵ���Ӧ�Ķ����˵�
									String subactsortid = actsortid.substring(0, 4);
									if(actsortid.length()>=8){
										subactsortid = actsortid.substring(0, 6);
									}
									if(subactsortid.equals(next2.getKey().getActsortid())){
										
										//�������˵���ϵ�������Ϣ��
//										out = out + " &gt;&gt; " + getActionLabel(next2.getKey().getActlabel());
										out = out + " &gt;&gt; " + next2.getKey().getActlabel();
										
										//���˵���ʶ���ڵ���6ʱ�������ҵ������˵�
										if(actsortid.length() >= 6){
											
											//��¼�����˵���ϢList
											List<Map<Action, List<Action>>> list3 = next2.getValue();
											for (Map<Action, List<Action>> map3 : list3) {
												
												Set<Entry<Action, List<Action>>> set3 = map3.entrySet();
												for(Iterator<Entry<Action, List<Action>>> iter3= set3.iterator();iter3.hasNext();){
													Entry<Action, List<Action>> next3 = iter3.next();
													String thactsortid = actsortid.substring(0, 6);
													if(actsortid.length()>=8){
														thactsortid = actsortid.substring(0, 8);
													}
													//�ҵ���Ӧ�������˵�
													if(thactsortid.equals(next3.getKey().getActsortid())){
														
														//�������˵���ϵ�������Ϣ��
//														out = out + " &gt;&gt; " + getActionLabel(next3.getKey().getActlabel());
														out = out + " &gt;&gt; " + next3.getKey().getActlabel();
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		//����ǩ���Բ�Ϊ��ʱ��������ϵ�������Ϣ��
		if(StringUtils.isNotEmpty(this.extname1)){
			out = out + " &gt;&gt; " + this.extname1;
		}
		
		if(StringUtils.isNotEmpty(this.extname2)){
			out = out + " &gt;&gt; " + this.extname2;
		}
		
		if(StringUtils.isNotEmpty(this.extname3)){
			out = out + " &gt;&gt; " + this.extname3;
		}
		
		if(StringUtils.isNotEmpty(this.extname4)){
			out = out + " &gt;&gt; " + this.extname4;
		}
		
		TagUtils.getInstance().write(pageContext, out);
		return (EVAL_BODY_INCLUDE);
	}

	/**
	 * �Զ��嵼������1ȡ��
	 * 
	 * @return �Զ��嵼������1
	 */
	public String getExtname1() {
		return extname1;
	}

	/**
	 * �Զ��嵼������1�趨
	 * 
	 * @param extname1 �Զ��嵼������1
	 */
	public void setExtname1(String extname1) {
		this.extname1 = extname1;
	}

	/**
	 * �Զ��嵼������2ȡ��
	 * 
	 * @return �Զ��嵼������2
	 */
	public String getExtname2() {
		return extname2;
	}

	/**
	 * �Զ��嵼������2�趨
	 * 
	 * @param extname2 �Զ��嵼������2
	 */
	public void setExtname2(String extname2) {
		this.extname2 = extname2;
	}

	/**
	 * �Զ��嵼������3ȡ��
	 * 
	 * @return �Զ��嵼������3
	 */
	public String getExtname3() {
		return extname3;
	}

	/**
	 * �Զ��嵼������3�趨
	 * 
	 * @param extname3 �Զ��嵼������3
	 */
	public void setExtname3(String extname3) {
		this.extname3 = extname3;
	}

	/**
	 * �Զ��嵼������4ȡ��
	 * 
	 * @return �Զ��嵼������4
	 */
	public String getExtname4() {
		return extname4;
	}

	/**
	 * �Զ��嵼������4�趨
	 * 
	 * @param extname4 �Զ��嵼������4
	 */
	public void setExtname4(String extname4) {
		this.extname4 = extname4;
	}
	
	/**
	 * �ͷ���Դ
	 */
	public void release(){
		super.release();
		this.extname1 = null;
		this.extname2 = null;
		this.extname3 = null;
		this.extname4 = null;
	}
	
	private String getActionLabel(String key) {
		MessageResources resources = MessageResources.getMessageResources("ApplicationResources"); 
		Locale currentLocale = Locale.getDefault();  
		currentLocale = (Locale)pageContext.getSession().getAttribute(Globals.LOCALE_KEY);
		if(currentLocale == null){
			currentLocale = Locale.getDefault();
		}
		return resources.getMessage(currentLocale,key);
		
	}
}
