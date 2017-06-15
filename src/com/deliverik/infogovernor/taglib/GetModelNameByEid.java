package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.SOC0117VWBL;
import com.deliverik.framework.soc.asset.model.SOC0117VWInfo;
import com.deliverik.framework.soc.asset.model.entity.SOC0117VWPK;

/**	
 * 概述: eid,id -- > ename
 */	
public class GetModelNameByEid extends TagSupport{

	private static final long serialVersionUID = 1L;

	/** 数据库id  */	
	protected String id;

	/** 资产模型eid  */	
	protected String eid;
	
	
	public int doStartTag() throws JspException {
		
		String out = "";
		
		SOC0117VWBL soc0117VWBL = (SOC0117VWBL) WebApplicationSupport.getBean("soc0117VWBL");
		try {
			if(StringUtils.isNotEmpty(eid)&&StringUtils.isNotEmpty(id)){
					SOC0117VWInfo temp = soc0117VWBL.searchEntityByKey(new SOC0117VWPK(Integer.parseInt(id),eid));
					if(temp!=null){
						out = temp.getEname();
					}else{
						out = "";
					}
				}else{
					out = "";
				}
				
			TagUtils.getInstance().write(pageContext, out);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (BLException e) {
			e.printStackTrace();
		} 
		
		return (EVAL_BODY_INCLUDE);
	}

	/**
	 * eiid取得
	 * @return eid  eid
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * eiid设定
	 * @param eiid  eid
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

}