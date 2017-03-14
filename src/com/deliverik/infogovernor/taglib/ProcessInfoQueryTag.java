/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����: �Զ������̱���ѯ�������ɱ�ǩ
 * ��������: �Զ������̱���ѯ�������ɱ�ǩ
 * ������¼: 2013/03/13
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class ProcessInfoQueryTag extends TagSupport{

	/** ������ */
	protected String pidname;
	
	/** ��ʾ���� */
	protected String label;
	
	/** ��С */
	protected String size;
	
	/** �Զ�����ʽ */
	protected String style;
	
	/** ���� */
	protected String name;
	
	/** ���� */
	protected String property;
	
	/** ������ʽ */
	protected String styleClass;
	
	/** �������Ͷ������� */
	protected String pdid;
	
	/** �����Զ�����ʽ */
	protected String styleTagName;
	
	/** ����������ʽ */
	protected String styleClassTagName;

	/**
	 * ������ȡ��
	 * @return ������
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * ��ʾ����ȡ��
	 * @return ��ʾ����
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * ��Сȡ��
	 * @return ��С
	 */
	public String getSize() {
		return size;
	}

	/**
	 * �Զ�����ʽȡ��
	 * @return �Զ�����ʽ
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * �������趨
	 * @param pidname ������
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * ��ʾ�����趨
	 * @param label ��ʾ����
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * ��С�趨
	 * @param size ��С
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * �Զ�����ʽ�趨
	 * @param style �Զ�����ʽ
	 */
	public void setStyle(String style) {
		this.style = style;
	}
	
	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getName() {
		return name;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getProperty() {
		return property;
	}

	/**
	 * �����趨
	 * @param ����
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * �����趨
	 * @return ����
	 */
	public void setProperty(String property) {
		this.property = property;
	}

	/**
	 * ������ʽȡ��
	 * @return ������ʽ
	 */
	public String getStyleClass() {
		return styleClass;
	}

	/**
	 * ������ʽ�趨
	 * @param styleClass ������ʽ
	 */
	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	/**
	 * �������Ͷ�������ȡ��
	 * @return �������Ͷ�������
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * �������Ͷ��������趨
	 * @param pdid �������Ͷ�������
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
	/**
	 * �����Զ�����ʽȡ��
	 * @return �����Զ�����ʽ
	 */
	public String getStyleTagName() {
		return styleTagName;
	}

	/**
	 * �����Զ�����ʽ�趨
	 * @param styleTagName �����Զ�����ʽ
	 */
	public void setStyleTagName(String styleTagName) {
		this.styleTagName = styleTagName;
	}

	/**
	 * ����������ʽȡ��
	 * @return ����������ʽ
	 */
	public String getStyleClassTagName() {
		return styleClassTagName;
	}

	/**
	 * ����������ʽ�趨
	 * @param styleClassTagName ����������ʽ
	 */
	public void setStyleClassTagName(String styleClassTagName) {
		this.styleClassTagName = styleClassTagName;
	}

	/**
	 * ��дdoStartTag��ʽ���ɲ�ѯ��������
	 */
	public int doStartTag() throws JspException{
		String out = getOut();
		if(StringUtils.isNotEmpty(out)){
			TagUtils.getInstance().write(pageContext, out);
		}
		return SKIP_BODY;
	}
	
	/**
	 * ��ǰ����ֵȡ��
	 * @return ��ǰ����ֵ
	 */
	public String getValue(){
		//������ʱ����ֵΪ��
		String returnValue="";
		//ȡ��session����
		HttpSession session = pageContext.getSession();
		//ȡ�ô洢ֵ�Ķ�������
		String processinfoname = StringUtils.isEmpty(property)?name:property;
		//ȡ����������
		String propertyName = processinfoname.indexOf("[")>-1?processinfoname.substring(0,processinfoname.indexOf("[")):processinfoname;
		//ȡ��session�д洢ֵ�Ķ���
		Object obj = session.getAttribute(StringUtils.isNotEmpty(name)?name:propertyName);
		//����洢ֵ�Ķ���Ϊ�գ�ȡ������ֵ
		if(obj!=null){
			try {
				//�õ��洢ֵ�������Ե�get��������
				String modName = "get"+propertyName.substring(0,1).toUpperCase()+propertyName.substring(1);
				//�����õ����Ե�get��������
				Method method = obj.getClass().getMethod(modName);
				//������ڸ÷��������Է���ִ�У�ȡ������ֵ
				if(method!=null){
					//����÷����ķŻ�ֵΪ�ַ�����������,ȡ�õ�������
					if(method.getReturnType().toString().contains("[Ljava.lang.String")){
						//��������и�����������ȡ������
						if(processinfoname.indexOf("[")>-1){
							//ȡ������
							Integer index = Integer.valueOf(processinfoname.substring(processinfoname.indexOf("[")+1,processinfoname.indexOf("]")));
							//ȡ������
							String[] strs = (String[]) method.invoke(obj);
							//�õ�����ֵ
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
	 * ������б������е�����
	 * @return
	 */
	public String addFixed(){
		StringBuffer str = new StringBuffer();
		//�����С��Ϊ�գ�Ϊ��ָ����С
		if(StringUtils.isNotEmpty(size)){
			str.append(" size=\"").append(size).append("\"");
		}
		//����Զ�����ʽ��Ϊ�գ�Ϊ��ָ��������ʽ
		if(StringUtils.isNotEmpty(style)){
			str.append(" style=\"").append(style).append("\"");
		}
		//�������ʽ��ΪΪ��Ϊ��ָ������ʽ
		if(StringUtils.isNotEmpty(styleClass)){
			str.append(" class=\"").append(styleClass).append("\"");
		}
		return str.toString();
	}
	
	/**
	 * ȡ�ñ�
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String getOut(){
		//�趨��ʱ���������Ϊ��
		String returnValue = "";
		//ȡ��session����
		HttpSession session = pageContext.getSession();
		//ȡ��session�б���Ϣmap
		Map<String, IG007Info> processInfoQueryMap = (Map<String, IG007Info>) session.getAttribute("AD_ProcessInfoQueryMap");
		//�趨��ǰ����ʱΪ��
		IG007Info pi = null;
		//�������Ϣmap��Ϊ�գ��ӱ���Ϣmap���ҵ���ǰ��
		if(processInfoQueryMap!=null){
			pi = processInfoQueryMap.get(pidname);
		}
		//�������Ϣmap�в����ڵ�ǰ������ȥ���ݿ��ѯ
		if(pi==null){
			//ȡ�ñ�BL
			IG007BL ig007BL = (IG007BL) WebApplicationSupport.getBean("ig007BL");
			//�趨����ѯ����
			IG007SearchCondImpl cond = new IG007SearchCondImpl();
			cond.setPidid_like(pdid);
			cond.setPidname(pidname);
			//����BL��ѯ����Ϣ
			List<IG007Info> list = ig007BL.searchIG007Info(cond);
			//������ڶ�汾��Ϣ��ȡ���汾����
			if(list!=null&&list.size()>0){
				pi = list.get(0);
				for(IG007Info pid:list){
					if(Integer.valueOf(pi.getPidid())<Integer.valueOf(pid.getPidid())){
						pi = pid;
					}
				}
			}
		}
		//������ڱ���Ϣ��ƴ�ӱ�����
		if(pidname!=null&&pi!=null){
			//ȡ�ñ��洢��������
			String processinfoname = StringUtils.isEmpty(property)?name:property;
			//ȡ�ñ���������
			String propertyName = processinfoname.indexOf("[")>-1?processinfoname.substring(0,processinfoname.indexOf("[")):processinfoname;
			//���������ַ���
			StringBuffer out = new StringBuffer();
			//ƴ�ӱ���ʾ���ƣ����ָ����ʾ���ƣ���ʾָ�����ƣ�������ʾ������
			out.append("<span");
			out.append(styleClassTagName!=null&&!styleClassTagName.isEmpty()?" class=\""+styleClassTagName+"\"":"");
			out.append(styleTagName!=null&&!styleTagName.isEmpty()?" style=\""+styleTagName+"\"":"");
			out.append(">");
			out.append(StringUtils.isNotEmpty(label)?label:pidname).append("��");
			out.append("</span>");
			//Ϊ������ı���Ϊ������
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
			//�����б���ѡ��ť�Ͷ�ѡ�������б���
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
