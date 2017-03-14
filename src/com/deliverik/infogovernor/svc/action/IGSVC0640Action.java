/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.svc.bl.IGSVC06BL;
import com.deliverik.infogovernor.svc.dto.IGSVC06DTO;
import com.deliverik.infogovernor.svc.form.IGSVC0640Form;
import com.deliverik.infogovernor.svc.vo.IGSVC06401VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 年度工作趋势统计Action
 * </p>
 * 
 * @author wanglei@deliverik.com
 * @version 1.0
 */
public class IGSVC0640Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGSVC0640Action.class);
		//BL取得
		IGSVC06BL ctlBL = (IGSVC06BL) getBean("igsvc06BL");
		//实例化dto
		IGSVC06DTO dto = new IGSVC06DTO();
		//form取得
		IGSVC0640Form form = (IGSVC0640Form) actionForm;
		//dto参数设定
		dto.setIgsvc0640Form(form);
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("=============年度工作趋势统计页面初始化操作开始============");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			Date date = new Date();
			String year = sdf.format(date);
			form.setYear(year);
			log.debug("=============年度工作趋势统计页面初始化操作结束============");
		}
		//统计操作
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("==========统计数据查询操作开始========");
			dto = ctlBL.searchAnnualTrendVWAction(dto);
			//实例化vo
			IGSVC06401VO vo = new IGSVC06401VO();
			vo.setIncidentnum(dto.getIncidentnum());
			vo.setProblemnum(dto.getProblemnum());
			vo.setChangenum(dto.getChangenum());
			vo.setServicenum(dto.getServicenum());
			vo.setSfnum(dto.getSfnum());
			super.<IGSVC06401VO>setVO(request, vo);
			log.debug("==========统计数据查询操作结束========");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
