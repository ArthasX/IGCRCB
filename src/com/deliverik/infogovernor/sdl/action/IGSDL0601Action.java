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
import com.deliverik.infogovernor.sdl.bl.IGSDL06BL;
import com.deliverik.infogovernor.sdl.dto.IGSDL06DTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0601Form;
import com.deliverik.infogovernor.sdl.vo.IGSDL06011VO;

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

public class IGSDL0601Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSDL0601Action.class);
	
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
		IGSDL0601Form form = (IGSDL0601Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========变更KPI统计查询画面初期显示处理开始========");
			form.setKpiYear(IGStringUtils.getCurrentYear());
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========变更KPI统计查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}	
		//获取BL接口实例
		IGSDL06BL ctlBL = (IGSDL06BL) getBean("igSDL06BL");
		//实例化DTO
		IGSDL06DTO dto = new IGSDL06DTO();
		//统计查询
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========变更KPI统计查询处理开始========");
			
			dto.setChangeKpiSearchCond(form);
			
			//调用BL查询
			dto = ctlBL.searchChangeKpiAction(dto);
			
			//构造VO
			IGSDL06011VO vo = new IGSDL06011VO(dto.getChangeKpiList());
			
			super.<IGSDL06011VO>setVO(request, vo);
			
			log.debug("========变更KPI统计查询处理终了========");
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
