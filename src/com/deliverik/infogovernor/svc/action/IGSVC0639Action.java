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
import com.deliverik.infogovernor.svc.form.IGSVC0639Form;
import com.deliverik.infogovernor.svc.vo.IGSVC06391VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 人员工作了统计Action
 * </p>
 */
public class IGSVC0639Action extends BaseAction{

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGSVC0639Action.class);
		//BL取得
		IGSVC06BL ctlBL = (IGSVC06BL) getBean("igsvc06BL");
		//实例化dto
		IGSVC06DTO dto = new IGSVC06DTO();
		//form取得
		IGSVC0639Form form = (IGSVC0639Form) actionForm;
		//dto参数设定
		dto.setIgsvc0639Form(form);
		//页面初始化
		if("DISP".equals(mapping.getParameter())){
			log.debug("===============人员工作量统计页面初始化操作开始===============");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			Date date = new Date();
			String year = sdf.format(date);
			form.setYear(year);
			sdf = new SimpleDateFormat("MM");
			String month = sdf.format(date);
			form.setMonth(month);
			log.debug("===============人员工作量统计页面初始化操作结束===============");
		}
		//人员工作量 统计数据查询操作
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("=============人员工作量统计数据查询操作开始===========");
			dto = ctlBL.searchSummary(dto);
			//实例化vo
			IGSVC06391VO vo = new IGSVC06391VO();
			vo.setAcountJson(dto.getAcountJson());
			vo.setPresonsJson(dto.getPresonsJson());
			super.setVO(request, vo);
			log.debug("=============人员工作量统计数据查询操作结束===========");
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
