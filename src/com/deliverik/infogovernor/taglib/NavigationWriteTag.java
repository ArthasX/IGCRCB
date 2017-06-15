/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * 概述: 菜单导航标签
 * 功能描述: 菜单导航标签
 * 创建记录: 2011/09/23
 * 修改记录: 2011/09/23
 */
@SuppressWarnings("serial")
public class NavigationWriteTag extends TagSupport {
	
	/** 自定义导航名字1 */
	protected String extname1;
	
	/** 自定义导航名字2 */
	protected String extname2;
	
	/** 自定义导航名字3 */
	protected String extname3;
	
	/** 自定义导航名字4 */
	protected String extname4;
	
	public int doStartTag() throws JspException {
		
		String out = "";  //标签输出字符串
		
		//菜单标识ID取得
		String actsortid = (String) pageContext.getSession().getAttribute("igactionid");
		
		//ActionBL取得
//		ActionBL actionBL = (ActionBL) WebApplicationSupport.getBean("actionBL");
		//菜单信息取得
		UserPermission userPermission = (UserPermission) pageContext.getSession().getAttribute("UserPermission");
		List<Map<Action, List<Map<Action, List<Map<Action, List<Action>>>>>>> actionList = userPermission.getActionList();
		
		//根据菜单标识组合导航信息
		if(StringUtils.isNotEmpty(actsortid) && actsortid.length() >= 2){
			for(Map<Action, List<Map<Action, List<Map<Action, List<Action>>>>>> map: actionList) {
				
				Set<Entry<Action, List<Map<Action, List<Map<Action, List<Action>>>>>>> set1 = map.entrySet();
				for(Iterator<Entry<Action, List<Map<Action, List<Map<Action, List<Action>>>>>>> iter1 = set1.iterator();iter1.hasNext();){
					Entry<Action, List<Map<Action, List<Map<Action, List<Action>>>>>> next1 = iter1.next();
					
					//找到对应的一级菜单
					if(actsortid.substring(0, 2).equals(next1.getKey().getActsortid())){
						
						//将一级菜单组合到导航信息中
//						out = getActionLabel(next1.getKey().getActlabel());
						out = next1.getKey().getActlabel();
						
						//当菜单标识大于等于4时，可以找到二级菜单
						if(actsortid.length() >= 4){
							
							//记录二级菜单信息List
							List<Map<Action, List<Map<Action, List<Action>>>>> list2 = next1.getValue();
							for (Map<Action, List<Map<Action, List<Action>>>> map2 : list2) {
								
								Set<Entry<Action, List<Map<Action, List<Action>>>>> set2 = map2.entrySet();
								for(Iterator<Entry<Action, List<Map<Action, List<Action>>>>> iter2 = set2.iterator();iter2.hasNext();){
									Entry<Action, List<Map<Action, List<Action>>>> next2 = iter2.next();
									
									//找到对应的二级菜单
									String subactsortid = actsortid.substring(0, 4);
									if(actsortid.length()>=8){
										subactsortid = actsortid.substring(0, 6);
									}
									if(subactsortid.equals(next2.getKey().getActsortid())){
										
										//将二级菜单组合到导航信息中
//										out = out + " &gt;&gt; " + getActionLabel(next2.getKey().getActlabel());
										out = out + " &gt;&gt; " + next2.getKey().getActlabel();
										
										//当菜单标识大于等于6时，可以找到三级菜单
										if(actsortid.length() >= 6){
											
											//记录三级菜单信息List
											List<Map<Action, List<Action>>> list3 = next2.getValue();
											for (Map<Action, List<Action>> map3 : list3) {
												
												Set<Entry<Action, List<Action>>> set3 = map3.entrySet();
												for(Iterator<Entry<Action, List<Action>>> iter3= set3.iterator();iter3.hasNext();){
													Entry<Action, List<Action>> next3 = iter3.next();
													String thactsortid = actsortid.substring(0, 6);
													if(actsortid.length()>=8){
														thactsortid = actsortid.substring(0, 8);
													}
													//找到对应的三级菜单
													if(thactsortid.equals(next3.getKey().getActsortid())){
														
														//将三级菜单组合到导航信息中
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
		
		//当标签属性不为空时，将其组合到导航信息中
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
	 * 自定义导航名字1取得
	 * 
	 * @return 自定义导航名字1
	 */
	public String getExtname1() {
		return extname1;
	}

	/**
	 * 自定义导航名字1设定
	 * 
	 * @param extname1 自定义导航名字1
	 */
	public void setExtname1(String extname1) {
		this.extname1 = extname1;
	}

	/**
	 * 自定义导航名字2取得
	 * 
	 * @return 自定义导航名字2
	 */
	public String getExtname2() {
		return extname2;
	}

	/**
	 * 自定义导航名字2设定
	 * 
	 * @param extname2 自定义导航名字2
	 */
	public void setExtname2(String extname2) {
		this.extname2 = extname2;
	}

	/**
	 * 自定义导航名字3取得
	 * 
	 * @return 自定义导航名字3
	 */
	public String getExtname3() {
		return extname3;
	}

	/**
	 * 自定义导航名字3设定
	 * 
	 * @param extname3 自定义导航名字3
	 */
	public void setExtname3(String extname3) {
		this.extname3 = extname3;
	}

	/**
	 * 自定义导航名字4取得
	 * 
	 * @return 自定义导航名字4
	 */
	public String getExtname4() {
		return extname4;
	}

	/**
	 * 自定义导航名字4设定
	 * 
	 * @param extname4 自定义导航名字4
	 */
	public void setExtname4(String extname4) {
		this.extname4 = extname4;
	}
	
	/**
	 * 释放资源
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
