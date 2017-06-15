package com.deliverik.infogovernor.taglib;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;

/**	
 * 概述: 显示事检查项方法名
 * 创建记录：yukexin    2014-8-26 上午11:11:22	
 * 修改记录：null
 */	
public class CheckitemMethodByEiidWriteTag extends TagSupport{

	private static final long serialVersionUID = 1L;

	/** 检查项id  */	
	protected String eiid;
	/** 字数  */	
	protected Integer count;
	
	public int doStartTag() throws JspException {
		
		String out = "";
		
		SOC0107BL soc0107BL = (SOC0107BL) WebApplicationSupport.getBean("soc0107BL");
		try {
			if(null != eiid && !"".equals(eiid)){
				SOC0107SearchCondImpl cicond = new SOC0107SearchCondImpl();
				cicond.setEiid(eiid);
				List<SOC0107Info> configItemlist = soc0107BL.searchSOC0107(cicond, 0, 0);
				if(count != null){
					out = configItemlist.get(2).getCivalue();
					if(out.length() > count){
						out = out.substring(0, count) + "...";
					}
				}else{
					out = configItemlist.get(2).getCivalue();
				}
			}
			TagUtils.getInstance().write(pageContext, out);
			
		} catch (NumberFormatException e) {
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
	 * count取得
	 * @return count  count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * count设定
	 * @param count  count
	 */
	public void setCount(Integer count) {
		this.count = count;
	}


    
}