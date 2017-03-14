/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.taglib;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.asset.bl.task.IG225BL;
import com.deliverik.framework.asset.bl.task.IG800BL;
import com.deliverik.framework.asset.model.IG225Info;
import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.condition.IG225SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG800SearchCondImpl;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;

/**
 * ����: �ʲ���������ʾ��ǩ
 * ��������: �ʲ���������ʾ��ǩͨ�����ݲ�����ȡ��Ӧ����������Ϣ��ֵ
 * ������¼: 2013/05/13 LuJiayuan
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class EntityConfigTag extends TagSupport {
	
	/** �ʲ�ID */
	protected String eiid;
	
	/** �ʲ�����ID */
	protected String eid;
	
	/** ���������� */
	protected String cname;
	
	/** ������Label��ʶ */
	protected String clabel;
	
	/** �ʲ�ģ��esyscoding */
	protected String esyscoding;
	
	/** �ʲ��汾��*/
	protected String civersion;
	
	private static SOC0107BL configItemBL = (SOC0107BL) WebApplicationSupport.getBean("soc0107BL");
	
	public int doStartTag() throws JspException {
		
		String out = "";  //��ǩ����ַ���
		
		//IG800���������ȡ���������ֵ
		String value = null;
		
		SOC0107SearchCondImpl cond = new SOC0107SearchCondImpl();
		cond.setCid(eid);
		cond.setEiid(eiid);
		cond.setCiversion(civersion);
		List<SOC0107Info> info = configItemBL.searchSOC0107(cond);
		if(info != null && info.size() > 0){
			value = info.get(0).getCivalue();
		}else {
			value = "";
		}
		
		out = value;
		TagUtils.getInstance().write(pageContext, out);
		return (EVAL_BODY_INCLUDE);
	}

	public String getEiid() {
		return eiid;
	}
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}

	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getClabel() {
		return clabel;
	}
	public void setClabel(String clabel) {
		this.clabel = clabel;
	}

	public String getEsyscoding() {
		return esyscoding;
	}
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * @return the civersion
	 */
	public String getCiversion() {
		return civersion;
	}

	/**
	 * @param civersion the civersion to set
	 */
	public void setCiversion(String civersion) {
		this.civersion = civersion;
	}

	
	
	
}