/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.form.IGASM2502Form;
import com.deliverik.infogovernor.asset.vo.IGASM25011VO;

/**
 * 概述: 服务记录明细页面查询
 * 功能描述：服务记录明细页面查询action 
 * 创建人：赵敏 
 * 创建记录： 2012-7-13 
 * 修改记录：
 */
public class IGASM2502Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2101Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// FORM取得
		IGASM2502Form form = (IGASM2502Form) actionForm;
		String eiid = request.getParameter("eiid");
		String beginTime = request.getParameter("beginTime");
		String endTime = request.getParameter("endTime");
		form.setEiid_q(eiid);
		form.setBeginTime(beginTime);
		form.setEndTime(endTime);
		// BL取得
		IGASM25BL ctlBL = (IGASM25BL) getBean("igasm25BL");

		// DTO生成
		IGASM25DTO dto = new IGASM25DTO();

		log.debug("========服务记录明细页面查询处理开始========");
		dto.setIgasm2502Form(form);
		//调用服务记录统计方法
		dto = ctlBL.searchEntityItemRelationDetailVW(dto);
		//将服务记录统计检索结果设定到VO中
		IGASM25011VO vo = new IGASM25011VO();
		vo.setFwcsSumCount(dto.getFwcsSumCount());
		vo.setFwpjfSumStore(dto.getFwpjfSumStore());
		vo.setEntityItemRelationDetailVWInfo(dto.getEntityItemRelationDetailVWInfo());
		vo.setBeginTime_q(form.getBeginTime());
		vo.setEndTime_q(form.getEndTime());
		vo.setEiname_like(dto.getEiname_like());
		super.<IGASM25011VO>setVO(request, vo);
		log.debug("========服务记录明细页面查询处理结束========");

		return mapping.findForward("DISP");
	}

}
