/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.taglib;

import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prr.bl.task.IG483BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.drm.bl.task.EmergencyRelationBL;
import com.deliverik.infogovernor.drm.model.EmergencyRelationInfo;
import com.deliverik.infogovernor.drm.model.condition.EmergencyRelationSearchCondImpl;

/**
 * 概述: 应急指挥流程关联应急处置流程列表
 * 功能描述: 应急指挥流程关联应急处置流程列表
 * 创建记录: 2015/04/29
 * 修改记录:
 */
@SuppressWarnings("serial")
public class EmergencyRelationTag extends TagSupport {
	
	/** 应急指挥流程ID */
	protected Integer parprid;
	
	
	public Integer getParprid() {
		return parprid;
	}

	public void setParprid(Integer parprid) {
		this.parprid = parprid;
	}


	public int doStartTag() throws JspException {
		
		EmergencyRelationBL emergencyRelationBL = (EmergencyRelationBL) WebApplicationSupport.getBean("emergencyRelationBL");
		
		IG500BL ig500BL = (IG500BL) WebApplicationSupport.getBean("ig500BL");
		
		IG483BL ig483BL = (IG483BL) WebApplicationSupport.getBean("ig483BL");
		
		EmergencyRelationSearchCondImpl cond = new EmergencyRelationSearchCondImpl();
		
		cond.setParprid(this.parprid);
		
		List<EmergencyRelationInfo> erList = emergencyRelationBL.searchEmergencyRelationInfo(cond, 0, 0);
		if(erList.size()>0){
			StringBuilder html =new StringBuilder( " <div class='record_list'><div class='title'> <div class='name'>应急处置</div> </div> "
					+	"<table cellspacing='2' class='table_style'>"
					+   "<tr><th width='15%'>工单号</th><th width='15%'>应急处置名称</th><th width='15%'>发起时间</th>" +
//					"<th width='15%'>类型</th>" +
					"<th width='15%'>状态</th>"
					//+ "<th width='15%'>处理人</th>"
					+ "</tr>");
			try{
			for (EmergencyRelationInfo emergencyRelationInfo : erList) {
				//单一场景
				if("1".equals(emergencyRelationInfo.getCldType())){
					IG500Info ig500Info = ig500BL.searchIG500InfoByKey(emergencyRelationInfo.getCldprid());
					html.append("<tr><td><a href='javascript:void(0)' onclick=\"showRelatedProcess('"+emergencyRelationInfo.getCldprid()+"','WDP','"+emergencyRelationInfo.getCldType()+"')\">"+ig500Info.getPrserialnum()+"</a></td>");
					html.append("<td>"+ig500Info.getPrtitle()+"</td>");
					html.append("<td>"+ig500Info.getPropentime()+"</td>");
//					html.append("<td>单一</td>");
					if(StringUtils.isNotEmpty(ig500Info.getPrclosetime())){
						html.append("<td>"+"关闭"+"</td>");
					}else{
						html.append("<td>"+"恢复中"+"</td>");
					}
//					html.append("<td>"+ProcessDefineTypeValueBean.getConfigInfo(ig500Info.getPrid())+"</td>");
					html.append(""
							//+ "<td>"+ProcessDisposePersonValueBean.getDisposePersonInfo(ig500Info.getPrid()+"",ig500Info.getPrstatus())+"</td>"
							+ "</tr>");
				}else{
					//组合场景
					IG483Info ig483Info = ig483BL.searchIG483ByPK(emergencyRelationInfo.getCldprid());
					html.append("<tr><td><a href='javascript:void(0)' onclick=\"showRelatedProcess('"+emergencyRelationInfo.getCldprid()+"','WDP','"+emergencyRelationInfo.getCldType()+"')\">"+ig483Info.getPgrserialnum()+"</a></td>");
					html.append("<td>"+ig483Info.getPgrtitle()+"</td>");
					html.append("<td>"+ig483Info.getPgropentime()+"</td>");
					html.append("<td>组合</td>");
					if(StringUtils.isNotEmpty(ig483Info.getPgrclosetime())){
						html.append("<td>"+"关闭"+"</td>");
					}else{
						html.append("<td>"+"恢复中"+"</td>");
					}
					html.append(""
						//	+ "<td>"+"</td>"
									+ "</tr>");
				}
			}
			html.append("</table><div>");
			TagUtils.getInstance().write(pageContext,html.toString());
			return (EVAL_BODY_INCLUDE);
			}catch(Exception e){
				return (SKIP_BODY);
			}
		}else{
			return (SKIP_BODY);
		}
                        
	}


}