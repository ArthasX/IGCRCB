/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.taglib;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;

/**
 * 概述: 流程当前处理人标签
 * 功能描述：根据流程id和状态取得当前处理人
 * 创建记录：
 */
public class ProcessParticipantForStatusWriteTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	

	private static IG337BL ig337BL = (IG337BL) WebApplicationSupport.getBean("ig337BL");
	private static IG500BL ig500BL = (IG500BL) WebApplicationSupport.getBean("ig500BL");

	/** 流程id */
	protected String prid;
	
	/** 流程状态 */
	protected String prstatus;
	
	// 流程当人处理人缓存，Key: prid_prstatus
//	protected static HashMap<String, StringBuffer> processParticipantsMap = new HashMap<String, StringBuffer>();
	
	public int doStartTag() throws JspException {
		
		// 处理人缓存Key
//		String mapKey = this.getPrid() + "_" + this.getPrstatus();
		// 从缓存获取处理人信息
//		StringBuffer processParticipants =  processParticipantsMap.get(mapKey);
		
		// 如果处理人信息在缓存不存在
//		if(null == processParticipants){
			StringBuffer processParticipants = new StringBuffer();
			List<String> lst_Status = null;
			try {
				lst_Status = ig500BL.searchCurrentStatus(new Integer(prid));
			} catch (BLException e) {
				lst_Status = new ArrayList<String>();
			}
		    IG337SearchCondImpl cond337 = new IG337SearchCondImpl();
			cond337.setPrid(new Integer(prid));
			List<IG337Info> list_337 =  new ArrayList<IG337Info>();
			for(String status : lst_Status) {
				cond337.setPpstatus_q(status);
				// 查询处理人信息
				list_337.addAll(ig337BL.getIG337Infos(cond337));
			}
			if(list_337.size() > 0){
				for(int i = 0; i < list_337.size(); i++){
					IG337Info info = list_337.get(i);
					if(StringUtils.isEmpty(info.getPpusername())){
						if(processParticipants.indexOf("未指定") == -1) {
							processParticipants.append("未指定、");
						}
						continue;
					}
					processParticipants.append(info.getPpusername());
					if(i < list_337.size() - 1){
						processParticipants.append("、");
					}
				}
			} else {
				processParticipants.append("");
			}
			
//			processParticipantsMap.put(mapKey, processParticipants);
//		}
	    if(processParticipants.toString().endsWith("、")) {
	    	TagUtils.getInstance().write(pageContext,  processParticipants.substring(0, processParticipants.length()-1).toString());
	    } else {
	    	TagUtils.getInstance().write(pageContext,  processParticipants.toString());
	    }
		processParticipants = null;
		cond337 = null;
		list_337 = null;
		return (EVAL_BODY_INCLUDE);
	}

	
	/**
	 * 释放资源
	 */
	public void release() {
        super.release();
        this.prid = null;
        this.prstatus = null;
    }
	
	/**
	 * 流程id取得
	 * @return prid 流程id
	 */
	public String getPrid() {
		return prid;
	}

	/**
	 * 流程id设定
	 * @param prid 流程id
	 */
	public void setPrid(String prid) {
		this.prid = prid;
	}

	/**
	 * 流程状态取得
	 * @return prstatus 流程状态
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 流程状态设定
	 * @param prstatus 流程状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

}