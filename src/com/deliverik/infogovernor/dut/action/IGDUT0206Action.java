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
import com.deliverik.infogovernor.dut.bl.IGDUT02BL;
import com.deliverik.infogovernor.dut.dto.IGDUT02DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0206Form;
import com.deliverik.infogovernor.dut.vo.IGDUT02061VO;

/**
 * 值班启动Action
 */
public class IGDUT0206Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDUT0206Action.class);

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
		IGDUT0206Form form = (IGDUT0206Form)actionForm;
		
		//BL取得
		IGDUT02BL ctlBL = (IGDUT02BL) getBean("igdut02BL");
		
		//DTO生成
		IGDUT02DTO dto = new IGDUT02DTO();
		
		String forward = "null";
		
		if ("CHANGE".equals(mapping.getParameter())){
			
			log.debug("========值班状态停用/启用处理开始========");
			//DTO输入参数设定
			dto.setIgDUT0206Form(form);
			
			ctlBL.changeDutyPlanAction(dto);
			
			log.debug("========值班状态停用/启用处理终了========");
			
			forward = "CHANGE";
			
		} else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//值班查询处理
			log.debug("========值班查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGDUT0206");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGDUT0206Form) req.getSession().getAttribute("IGDUT0206Form");
				if ( form == null ) {
					form = new IGDUT0206Form();
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
					form = (IGDUT0206Form) req.getSession().getAttribute("IGDUT0206Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGDUT0206");
			
			//DTO输入参数设定
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			dto.setIgDUT0206Form(form);
			
			//值班信息检索逻辑调用
			dto = ctlBL.searchDutyPlanAction(dto);
			//将值班信息检索结果设定到VO中
			IGDUT02061VO vo = new IGDUT02061VO();
			vo.setDutyPlanList(dto.getDutyPlanList());
			
			super.<IGDUT02061VO>setVO(req, vo);
			
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
