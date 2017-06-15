/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.svc.bl.IGSVC06BL;
import com.deliverik.infogovernor.svc.dto.IGSVC06DTO;
import com.deliverik.infogovernor.svc.form.IGSVC0638Form;
import com.deliverik.infogovernor.svc.vo.IGSVC06381VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 故障类型平均解决时间统计Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGSVC0638Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGSVC0638Action.class);
		//BL取得
		IGSVC06BL ctlBL = (IGSVC06BL) getBean("igsvc06BL");
		//实例化dto
		IGSVC06DTO dto = new IGSVC06DTO();
		//form取得
		IGSVC0638Form form = (IGSVC0638Form) actionForm;
		//dto参数设定
		dto.setIgsvc0638Form(form);
		//页面初始化操作
		if("DISP".equals(mapping.getParameter())){
			log.debug("============故障类型平均解决时间统计页面初始化操作开始============");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			Date date = new Date();
			String year = sdf.format(date);
			form.setYear(year);
			sdf = new SimpleDateFormat("MM");
			String month = sdf.format(date);
			form.setMonth(month);
			log.debug("============故障类型平均解决时间统计页面初始化操作结束============");
		}
		//统计数据查询
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("===========故障类型平均结束时间统计数据查询操作开始=============");
			dto = ctlBL.searchIncidentAveSolveTimeAction(dto);
			//实例化vo
			IGSVC06381VO vo = new IGSVC06381VO();
			vo.setIncidentAveSolveTimeDate(dto.getIncidentAveSolveTimeDate());
			super.<IGSVC06381VO>setVO(request, vo);
			log.debug("===========故障类型平均结束时间统计数据查询操作结束=============");
		}
		return mapping.findForward("DISP");
	}

}
