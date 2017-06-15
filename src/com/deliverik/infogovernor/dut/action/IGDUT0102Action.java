/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.action;

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
import com.deliverik.infogovernor.dut.bl.IGDUT01BL;
import com.deliverik.infogovernor.dut.dto.IGDUT01DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0102Form;
import com.deliverik.infogovernor.dut.vo.IGDUT01021VO;

/**
 * 
 * 值班检查管理查询列表Action
 *
 */
public class IGDUT0102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDUT0102Action.class);

	/**
	 * 事件处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORM取得
		IGDUT0102Form form = (IGDUT0102Form)actionForm;
		
		//BL取得
		IGDUT01BL ctlBL = (IGDUT01BL) getBean("igdut01BL");
		
		//DTO生成
		IGDUT01DTO dto = new IGDUT01DTO();
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			
			//值班查询画面初期显示处理
			log.debug("========值班查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========值班查询画面初期显示处理终了========");
			
			forward = "DISP";
			
			
		} else if("REDISP".equals(mapping.getParameter())){
			
			//值班查询画面再显示处理
			log.debug("========值班查询画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========值班查询画面再显示处理终了========");
			
			forward = "DISP";
			
			
		}	else if ("CHANGE".equals(mapping.getParameter())){
			
			log.debug("========值班状态停用/启用处理开始========");
			//DTO输入参数设定
			dto.setIgDUT0102Form(form);
			
			ctlBL.changeDutyAuditDefAction(dto);
			
			log.debug("========值班状态停用/启用处理终了========");
			
			forward = "CHANGE";
			
		} else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//值班查询处理
			log.debug("========值班查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGDUT0102");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGDUT0102Form) req.getSession().getAttribute("IGDUT0102Form");
				if ( form == null ) {
					form = new IGDUT0102Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGDUT0102Form) req.getSession().getAttribute("IGDUT0102Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGDUT0102");
			
			//DTO输入参数设定
//			form.setEstatus(null);
			dto.setDutyAuditDefSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//值班信息检索逻辑调用
			dto = ctlBL.searchDutyAuditDefAction(dto);
			
			
			//将值班信息检索结果设定到VO中
			IGDUT01021VO vo = new IGDUT01021VO();
			vo.setDutyAuditList(dto.getDutyAuditList());
			
			super.<IGDUT01021VO>setVO(req, vo);
			
			log.debug("========值班查询处理终了========");
			
			forward = "DISP";
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forward);
	}
}
