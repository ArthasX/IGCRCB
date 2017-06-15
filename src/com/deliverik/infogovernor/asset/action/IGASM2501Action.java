/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.asset.bl.IGASM25BL;
import com.deliverik.infogovernor.asset.dto.IGASM25DTO;
import com.deliverik.infogovernor.asset.form.IGASM2501Form;
import com.deliverik.infogovernor.asset.vo.IGASM25011VO;

/**
 * 概述: 服务记录统计查询页面 
 * 功能描述：服务记录统计查询页面action 
 * 创建人：赵敏 
 * 创建记录： 2012-7-12 
 * 修改记录：
 */
public class IGASM2501Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2101Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// FORM取得
		IGASM2501Form form = (IGASM2501Form) actionForm;

		// BL取得
		IGASM25BL ctlBL = (IGASM25BL) getBean("igasm25BL");

		// DTO生成
		IGASM25DTO dto = new IGASM25DTO();

		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========服务记录统计页面初始化开始========");
			//获取当前系统日期
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
			String currentTime = sf.format(cal.getTime());
			//设置默认查询日期
			form.setBeginTime_q(currentTime);
			form.setEndTime_q(currentTime);

			log.debug("========服务记录统计页面初始化结束========");
		}
		if ("SEARCH".equals(mapping.getParameter())) {
			log.debug("========服务记录统计页面查询处理开始========");
			//获取查询条件
			dto.setBeginTime_q(form.getBeginTime_q());
			dto.setEndTime_q(form.getEndTime_q());
			dto.setEiname_like(form.getEiname_like());
			//调用服务记录统计方法
			dto = ctlBL.searchEntityItemRelationVW(dto);
			//将服务记录统计检索结果设定到VO中
			IGASM25011VO vo = new IGASM25011VO();
			vo.setHjSumCount(dto.getHjSumCount());
			vo.setPxSumCount(dto.getPxSumCount());
			vo.setSbSumCount(dto.getSbSumCount());
			vo.setYySumCount(dto.getYySumCount());
			//设置查询时间
			vo.setBeginTime_q(form.getBeginTime_q());
			vo.setEndTime_q(form.getEndTime_q());
			vo.setEntityItemRelationVWInfoList(dto.getEntityItemRelationVWInfoList());
			super.<IGASM25011VO>setVO(request, vo);
			log.debug("========服务记录统计页面查询处理结束========");
		}
		return mapping.findForward("DISP");
	}

}
