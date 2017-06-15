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
import com.deliverik.infogovernor.sdl.bl.IGSDL05BL;
import com.deliverik.infogovernor.sdl.dto.IGSDL05DTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0504Form;
import com.deliverik.infogovernor.sdl.vo.IGSDL05041VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_统计查询ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSDL0504Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSDL0504Action.class);
	
	/**
	 * <p>
	 * Description:统计查询ACTION处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author sunkaiyu@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGSDL0504Form form = (IGSDL0504Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========统计查询画面初期显示处理开始========");
			form.setYear(IGStringUtils.getCurrentYear());
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========统计查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}	
		//获取BL接口实例
		IGSDL05BL ctlBL = (IGSDL05BL) getBean("igSDL05BL");
		//实例化DTO
		IGSDL05DTO dto = new IGSDL05DTO();
		//统计查询
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========统计查询处理开始========");
			
			dto.setSdlYearSummarySearchCond(form);
			
			//调用BL查询
			dto = ctlBL.searchSdlYearSummaryAction(dto);
			
			//构造VO
			IGSDL05041VO vo = new IGSDL05041VO(dto.getSdlYearSummaryList());
			
			super.<IGSDL05041VO>setVO(request, vo);
			
			log.debug("========统计查询处理终了========");
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
