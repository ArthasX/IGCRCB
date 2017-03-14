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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.asset.bl.IGASM26BL;
import com.deliverik.infogovernor.asset.dto.IGASM26DTO;
import com.deliverik.infogovernor.asset.form.IGASM2601Form;
import com.deliverik.infogovernor.asset.vo.IGASM26011VO;

/**
 * 概述: 服务商资源池统计页面 
 * 功能描述：服服务商资源池统计页面action 
 * 创建人：赵敏 
 * 创建记录： 2012-08-31 
 * 修改记录：
 */
public class IGASM2601Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2601Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// FORM取得
		IGASM2601Form form = (IGASM2601Form) actionForm;

		// BL取得
		IGASM26BL ctlBL = (IGASM26BL) getBean("igasm26BL");

		// DTO生成
		IGASM26DTO dto = new IGASM26DTO();

		if ("DISP".equals(mapping.getParameter())) {
			log.debug("========服务商资源池统计页面初始化开始========");
			//获取当前系统日期
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy/MM/dd");
			String currentTime = sf.format(cal.getTime());
			int year = cal.get(cal.YEAR);
			//设置默认查询日期
//			form.setBeginTime_q(currentTime);
			//查询条件内登记时间默认为从年初到当前日
			form.setBeginTime_q(String.valueOf(year+"/01/01"));
			form.setEndTime_q(currentTime);
			
			log.debug("========服务商资源池统计面初始化结束========");
		}
		if ("SEARCH".equals(mapping.getParameter())) {
			log.debug("========服务商资源池统计处理开始========");
			//分页用DTO取得
			getPaginDTO(request, "IGASM2601");			
			PagingDTO pDto = (PagingDTO)request.getAttribute("PagingDTO");
			//判断form是否为空
			if (form == null) {
				//form为空时，初始化form
				form = new IGASM2601Form();
			} else {
				//进行分页处理
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(form.getFromCount());
				} else {
					form.setFromCount(pDto.getFromCount());
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM2601");
			//将查询结果的结果数封装到dto中
			dto.setMaxSearchCount(maxCnt);
			//将分页实体封装到dto中
			dto.setPagingDto(pDto);
			//获取查询条件
			dto.setIgasm2601Form(form);
			//调用服务商资源池统计方法
			dto = ctlBL.searchEntityItemRelationVW(dto);
			//将服务记录统计检索结果设定到VO中
			IGASM26011VO vo = new IGASM26011VO();
			//设置查询时间
			vo.setEntityItemAndConfigItemVWInfoList(dto.getEntityItemAndConfigItemVWInfoList());
			super.<IGASM26011VO>setVO(request, vo);
			log.debug("========服务商资源池统计处理结束========");
		}
		return mapping.findForward("DISP");
	}

}
