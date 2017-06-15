package com.deliverik.infogovernor.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.SOC0117VWBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118VWBL;
import com.deliverik.framework.soc.asset.model.SOC0117VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.entity.SOC0117VWPK;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VWPK;

/**	
 * 概述: eiid,id -- > ename
 */	
public class GetMOdelNameByEiid extends TagSupport{

	private static final long serialVersionUID = 1L;

	/** 数据库id  */	
	protected String id;

	/** 资产eiid  */	
	protected String eiid;
	
	
	public int doStartTag() throws JspException {
		
		String out = "";
		
		SOC0118VWBL soc0118VWBL = (SOC0118VWBL) WebApplicationSupport.getBean("soc0118VWBL");
		SOC0117VWBL soc0117VWBL = (SOC0117VWBL) WebApplicationSupport.getBean("soc0117VWBL");
		try {
			if(StringUtils.isNotEmpty(eiid)&&StringUtils.isNotEmpty(id)){
				SOC0118VWInfo info = soc0118VWBL.searchEntityItemByKey(new SOC0118VWPK(Integer.parseInt(id),Integer.parseInt(eiid)));
				if(info!=null) {
					SOC0117VWInfo temp = soc0117VWBL.searchEntityByKey(new SOC0117VWPK(Integer.parseInt(id),info.getEid()));
					if(temp!=null){
						out = temp.getEname();
					}else{
						out = "";
					}
				}else{
					out = "";
				}
				
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
	 * @return eiid  eiid
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * eiid设定
	 * @param eiid  eiid
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
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