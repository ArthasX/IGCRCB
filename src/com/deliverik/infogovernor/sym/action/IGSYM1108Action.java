/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.action;

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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.sym.bl.IGSYM11BL;
import com.deliverik.infogovernor.sym.dto.IGSYM11DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1101Form;
import com.deliverik.infogovernor.sym.vo.IGSYM11011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_基础数据_数据分类列表画面Action处理
 * </p>
 * 
 * @version 1.0
 */

public class IGSYM1108Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1108Action.class);

	/**
	 * 数据分类列表画面Action处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		IGSYM1101Form form = (IGSYM1101Form)actionForm;
		//BL取得
		IGSYM11BL ctlBL = (IGSYM11BL) getBean("igsym11BL");
		
		//DTO生成
		IGSYM11DTO dto = new IGSYM11DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//数据分类列表画面初期显示处理
			log.debug("========数据分类列表画面初期显示处理开始========");
			
			getPaginDTO(req,"IGSYM1101");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("IGSYM1101");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			dto = ctlBL.initIGSYM1101Action(dto);
			
			IGSYM11011VO vo = new IGSYM11011VO(dto.getCodeCategoryInfoList());
			
			super.<IGSYM11011VO>setVO(req, vo);
			
			log.debug("========数据分类列表画面初期显示处理终了========");
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
