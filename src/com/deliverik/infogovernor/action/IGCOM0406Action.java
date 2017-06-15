/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.bl.IGCOM04BL;
import com.deliverik.infogovernor.dto.IGCOM04DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 领导仪表盘首页Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGCOM0406Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGCOM0406Action.class);
		//BL取得
		IGCOM04BL ctlBL = (IGCOM04BL) getBean("igcom04BL");
		//实例化dto
		IGCOM04DTO dto = new IGCOM04DTO();
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("===============领导仪表盘初始化操作开始===============");
			//流程主题本月事件数量取得处理
			ctlBL.getCurrentMouthEventCount(dto);
			
			//流程主题本月问题数量取得处理
			ctlBL.getCurrentMouthProblemCount(dto);
			
			// TODO 巡检
			//流程主题首页各中心工作数量取得处理
			ctlBL.getAllTypeWorkCount(dto);
			
			//生成流程主题首页年度事件数量及平均解决时间xml
			ctlBL.setEventAvgCost(dto);
			request.setAttribute("lfy1", dto.getResultXML());

//			//生成流程主题首页年度变更数量及平均解决率xml
//			ctlBL.setproChangeAvgSuccess(dto);
//			req.setAttribute("lfy3", dto.getResultXML());
			//生成每个月的整改数量及检查数量的XML
//			ctlBL.statisticsZhenggaiTotal(dto);
			ctlBL.searchProblemAvgSuccess(dto);
			request.setAttribute("lfy3", dto.getResultXML());
			
			ctlBL.searchProblemTotalByMonth(dto);
			request.setAttribute("chartxml", dto.getResultXML());
			
			//生成三饼xml
			ctlBL.setproincidentInfo(dto);
			request.setAttribute("incidentPie", dto.getResultXML());
			
			//生成一饼xml
//			ctlBL.setKnowledgeInfo(dto);
			request.setAttribute("knowPie", dto.getResultXML());
			
			//生成流程主题首页变更计划日历xml
//			ctlBL.setChangePlan(dto);
			
			request.setAttribute("eventcount", dto.getCurrentMouthEventCount());
			
			request.setAttribute("problemcount", dto.getCurrentMouthProblemCount());
			String[] workResult = dto.getAllTypeWorkCount().split(",");
			request.setAttribute("workcount", workResult[0]);
			request.setAttribute("worktype", workResult[1]);
			
			request.setAttribute("jsptype", request.getParameter("type"));
			log.debug("===============领导仪表盘初始化操作结束===============");
		}
		return mapping.findForward("DISP");
	}

}
