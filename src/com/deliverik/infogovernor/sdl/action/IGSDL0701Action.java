/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.action;

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
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.sdl.bl.IGSDL07BL;
import com.deliverik.infogovernor.sdl.dto.IGSDL07DTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0701Form;
import com.deliverik.infogovernor.sdl.vo.IGSDL07011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_统计查询ACTION
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */

public class IGSDL0701Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSDL0701Action.class);
	
	/**
	 * <p>
	 * Description:变更KPI统计查询ACTION处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author maozhipeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGSDL0701Form form = (IGSDL0701Form)actionForm;
		String forward = "DISP";
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========变更KPI统计查询画面初期显示处理开始========");
			form.setKpiYear(IGStringUtils.getCurrentYear());
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			form.setRadioValue("A");
			log.debug("========变更KPI统计查询画面初期显示处理终了========");
			return mapping.findForward(forward);
		}	
		//获取BL接口实例
		IGSDL07BL ctlBL = (IGSDL07BL) getBean("igSDL07BL");
		//实例化DTO
		IGSDL07DTO dto = new IGSDL07DTO();
		//统计查询
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========变更KPI统计查询处理开始========");
			
			dto.setIncidentKpiSearchCond(form);
			
			//构造VO
			IGSDL07011VO vo = new IGSDL07011VO();
			String radioValue = form.getRadioValue();
			if("B".equals(radioValue)){
				//紧急程度
				forward = "URGENCY";
				dto = ctlBL.searchIncidentKpiListAction(dto);
				vo.setIncidentKpiList(dto.getIncidentKpiList());
			}else if("C".equals(radioValue)){
				//事件类别+紧急程度
				forward = "TYPEANDURGENCY";
				dto = ctlBL.searchTypeMapAction(dto);
				vo.setIncidentKpiMap(dto.getIncidentKpiMap());
			}else if("D".equals(radioValue)){
				//紧急程度+事件类别
				forward = "URGENCYANDTYPE";
				dto = ctlBL.searchUrgencyMapAction(dto);
				vo.setIncidentKpiMap(dto.getIncidentKpiMap());
			}else{
				dto = ctlBL.searchIncidentKpiListAction(dto);
				vo.setIncidentKpiList(dto.getIncidentKpiList());
			}
			
			super.<IGSDL07011VO>setVO(request, vo);
			
			log.debug("========变更KPI统计查询处理终了========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward(forward);
	}

}
