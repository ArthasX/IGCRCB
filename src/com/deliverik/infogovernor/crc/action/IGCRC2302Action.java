/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.crc.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.crc.bl.IGCRC23BL;
import com.deliverik.infogovernor.crc.bl.IGCRC23ExcelBL;
import com.deliverik.infogovernor.crc.dto.IGCRC2301DTO;
import com.deliverik.infogovernor.crc.dto.IGCRC2301ExcelDTO;
import com.deliverik.infogovernor.crc.form.IGCRC2301Form;
import com.deliverik.infogovernor.crc.vo.IGCRC2301VO;

/**	
 * 概述: 程序开发统计钻取action
 * 功能描述： 程序开发统计钻取action
 * 创建记录：史凯龙    2014-8-15 下午1:55:43	
 * 修改记录：
 *          
 */	
public class IGCRC2302Action extends BaseAction {
	//日志对象取得
	static Log log = LogFactory.getLog(IGCRC2302Action.class);

	/**	
	 * 功能：页面查询action处理
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * 修改记录：
	 *          	
	 */	
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		log.debug("================程序开发统计钻取Action开始=============");
		//form取得
		IGCRC2301Form form = (IGCRC2301Form)actionForm;
		//BL取得
		IGCRC23BL igcrc23bl = (IGCRC23BL)getBean("igcrc23bl");
		//实例化dto
		IGCRC2301DTO dto = new IGCRC2301DTO();
		PagingDTO pDto = getPaginDTO(request, "IGCRC1304");
		dto.setIgcrc2301Form(form);
		if("SEARCH".equals(mapping.getParameter())){
			//查询工单详细信息
			int maxCnt = getMaxDataCount("IGCRC1304");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto = igcrc23bl.searchIG500ItemAction(dto);
			IGCRC2301VO vo = new IGCRC2301VO();
			//获取查询的带合计的数据列表和总合计列表
			vo.setProcessList(dto.getProcessList());
			super.<IGCRC2301VO>setVO(request, vo);
		}
		log.debug("================程序开发统计钻取Action结束=============");
		return mapping.findForward("DISP");
	}
}
