/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.taglib;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prd.bl.task.IG007BL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;

/**
 * 概述: 自定义流程表单查询条件生成标签
 * 功能描述: 自定义流程表单查询条件生成标签
 * 创建记录: 2013/03/13
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class ProcessInfoQueryTag extends TagSupport{

	/** 表单名称 */
	protected String pidname;
	
	/** 显示名称 */
	protected String label;
	
	/** 大小 */
	protected String size;
	
	/** 自定义样式 */
	protected String style;
	
	/** 名称 */
	protected String name;
	
	/** 属性 */
	protected String property;
	
	/** 引用样式 */
	protected String styleClass;
	
	/** 流程类型定义主键 */
	protected String pdid;
	
	/** 文字自定义样式 */
	protected String styleTagName;
	
	/** 文字引用样式 */
	protected String styleClassTagName;

	/**
	 * 表单名称取得
	 * @return 表单名称
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * 显示名称取得
	 * @return 显示名称
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * 大小取得
	 * @return 大小
	 */
	public String getSize() {
		return size;
	}

	/**
	 * 自定义样式取得
	 * @return 自定义样式
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * 表单名称设定
	 * @param pidname 表单名称
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * 显示名称设定
	 * @param label 显示名称
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * 大小设定
	 * @param size 大小
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * 自定义样式设定
	 * @param style 自定义样式
	 */
	public void setStyle(String style) {
		this.style = style;
	}
	
	/**
	 * 名称取得
	 * @return 名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 属性取得
	 * @return 属性
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * 名称设定
	 * @param 名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 属性设定
	 * @return 属性
	 */
	public void setProperty(String property) {
		this.property = property;
	}

	/**
	 * 引用样式取得
	 * @return 引用样式
	 */
	public String getStyleClass() {
		return styleClass;
	}

	/**
	 * 引用样式设定
	 * @param styleClass 引用样式
	 */
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	/**
	 * 流程类型定义主键取得
	 * @return 流程类型定义主键
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程类型定义主键设定
	 * @param pdid 流程类型定义主键
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
	/**
	 * 文字自定义样式取得
	 * @return 文字自定义样式
	 */
	public String getStyleTagName() {
		return styleTagName;
	}

	/**
	 * 文字自定义样式设定
	 * @param styleTagName 文字自定义样式
	 */
	public void setStyleTagName(String styleTagName) {
		this.styleTagName = styleTagName;
	}

	/**
	 * 文字引用样式取得
	 * @return 文字引用样式
	 */
	public String getStyleClassTagName() {
		return styleClassTagName;
	}

	/**
	 * 文字引用样式设定
	 * @param styleClassTagName 文字引用样式
	 */
	public void setStyleClassTagName(String styleClassTagName) {
		this.styleClassTagName = styleClassTagName;
	}

	/**
	 * 重写doStartTag方式生成查询条件内容
	 */
	public int doStartTag() throws JspException{
		String out = getOut();
		if(StringUtils.isNotEmpty(out)){
			TagUtils.getInstance().write(pageContext, out);
		}
		return SKIP_BODY;
	}
	
	/**
	 * 当前属性值取得
	 * @return 当前属性值
	 */
	public String getValue(){
		//定义临时属性值为空
		String returnValue="";
		//取得session对象
		HttpSession session = pageContext.getSession();
		//取得存储值的对象名称
		String processinfoname = StringUtils.isEmpty(property)?name:property;
		//取得属性名称
		String propertyName = processinfoname.indexOf("[")>-1?processinfoname.substring(0,processinfoname.indexOf("[")):processinfoname;
		//取得session中存储值的对象
		Object obj = session.getAttribute(StringUtils.isNotEmpty(name)?name:propertyName);
		//如果存储值的对象不为空，取得属性值
		if(obj!=null){
			try {
				//拿到存储值对象属性的get方法名称
				String modName = "get"+propertyName.substring(0,1).toUpperCase()+propertyName.substring(1);
				//反射拿到属性的get方法对象
				Method method = obj.getClass().getMethod(modName);
				//如果存在该方法，尝试反射执行，取到属性值
				if(method!=null){
					//如果该方法的放回值为字符串数组类型,取得到该数组
					if(method.getReturnType().toString().contains("[Ljava.lang.String")){
						//如果属性中给定了索引，取到索引
						if(processinfoname.indexOf("[")>-1){
							//取到索引
							Integer index = Integer.valueOf(processinfoname.substring(processinfoname.indexOf("[")+1,processinfoname.indexOf("]")));
							//取得数组
							String[] strs = (String[]) method.invoke(obj);
							//拿到返回值
							if(strs!=null&&strs.length>0){
								returnValue = strs[index];
							}
						};
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return returnValue;
	}
	
	/**
	 * 添加所有表单都固有的属性
	 * @return
	 */
	public String addFixed(){
		StringBuffer str = new StringBuffer();
		//如果大小不为空，为表单指定大小
		if(StringUtils.isNotEmpty(size)){
			str.append(" size=\"").append(size).append("\"");
		}
		//如果自定义样式不为空，为表单指定行内样式
		if(StringUtils.isNotEmpty(style)){
			str.append(" style=\"").append(style).append("\"");
		}
		//如果类样式不为为，为表单指定类样式
		if(StringUtils.isNotEmpty(styleClass)){
			str.append(" class=\"").append(styleClass).append("\"");
		}
		return str.toString();
	}
	
	/**
	 * 取得表单
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getOut(){
		//设定临时输出表单内容为空
		String returnValue = "";
		//取得session对象
		HttpSession session = pageContext.getSession();
		//取得session中表单信息map
		Map<String, IG007Info> processInfoQueryMap = (Map<String, IG007Info>) session.getAttribute("AD_ProcessInfoQueryMap");
		//设定当前表单临时为空
		IG007Info pi = null;
		//如果表单信息map不为空，从表单信息map中找到当前表单
		if(processInfoQueryMap!=null){
			pi = processInfoQueryMap.get(pidname);
		}
		//如果表单信息map中不存在当前表单，则去数据库查询
		if(pi==null){
			//取得表单BL
			IG007BL ig007BL = (IG007BL) WebApplicationSupport.getBean("ig007BL");
			//设定表单查询条件
			IG007SearchCondImpl cond = new IG007SearchCondImpl();
			cond.setPidid_like(pdid);
			cond.setPidname(pidname);
			//调用BL查询表单信息
			List<IG007Info> list = ig007BL.searchIG007Info(cond);
			//如果存在多版本信息，取最大版本定义
			if(list!=null&&list.size()>0){
				pi = list.get(0);
				for(IG007Info pid:list){
					if(Integer.valueOf(pi.getPidid())<Integer.valueOf(pid.getPidid())){
						pi = pid;
					}
				}
			}
		}
		//如果存在表单信息，拼接表单内容
		if(pidname!=null&&pi!=null){
			//取得表单存储对象名称
			String processinfoname = StringUtils.isEmpty(property)?name:property;
			//取得表单属性名称
			String propertyName = processinfoname.indexOf("[")>-1?processinfoname.substring(0,processinfoname.indexOf("[")):processinfoname;
			//定义表单输出字符串
			StringBuffer out = new StringBuffer();
			//拼接表单显示名称，如果指定显示名称，显示指定名称，否则显示表单名称
			out.append("<span");
			out.append(styleClassTagName!=null&&!styleClassTagName.isEmpty()?" class=\""+styleClassTagName+"\"":"");
			out.append(styleTagName!=null&&!styleTagName.isEmpty()?" style=\""+styleTagName+"\"":"");
			out.append(">");
			out.append(StringUtils.isNotEmpty(label)?label:pidname).append("：");
			out.append("</span>");
			//为本框和文本域按为本框处理
			if("0".equals(pi.getPidtype())||"9".equals(pi.getPidtype())){
				out.append("<input type=\"text\" name=\"");
				out.append(propertyName);
				out.append("\" ");
				out.append(addFixed());
				String value = getValue();
				if(StringUtils.isNotEmpty(value)){
					out.append(" value=\"").append(value).append("\" ");
				}
				out.append("/>");
			//下拉列表，单选按钮和多选框按下拉列表处理
			}else if("2".equals(pi.getPidtype())||"B".equals(pi.getPidtype())||"C".equals(pi.getPidtype())||"E".equals(pi.getPidtype())){
				out.append("<select name=\"");
				out.append(propertyName);
				out.append("\" ");
				out.append(addFixed());
				out.append(">");
				out.append("<option value=\"\"></option>");
				String str = pi.getPidoption();
				if(StringUtils.isNotEmpty(str)){
					String value = getValue();
					String[] options = str.split("#");
					for(String s:options){
						if(StringUtils.isNotEmpty(s)){
							if(StringUtils.isNotEmpty(value)&&s.equals(value)){
								out.append("<option value=\"").append(s).append("\" selected=\"true\" >").append(s).append("</option>");
							}else{
								out.append("<option value=\"").append(s).append("\">").append(s).append("</option>");
							}
						}
					}
				}
				out.append("</select>");
			}
			out.append("<input type=\"hidden\" name=\"varnames\" value=\"").append(pidname).append("\"/>");
			returnValue = out.toString();
		}
		return returnValue;
	}
	
}
