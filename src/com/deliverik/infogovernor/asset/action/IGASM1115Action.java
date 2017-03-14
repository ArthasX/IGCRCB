package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.bl.IGASM11BL;
import com.deliverik.infogovernor.asset.dto.IGASM11DTO;
import com.deliverik.infogovernor.asset.form.IGASM1115Form;
import com.deliverik.infogovernor.asset.vo.IGASM11151VO;

/**
 * 设备选择画面Action处理
 *
 */
public class IGASM1115Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1115Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGASM1115Form form = (IGASM1115Form)actionForm;

		//BL取得
		IGASM11BL ctlBL = (IGASM11BL) getBean("igasm11BL");
		
		//DTO生成
		IGASM11DTO dto = new IGASM11DTO();
		
		//画面跳转参数
		String forward = null;
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========设备选择画面初期显示处理开始========");
			dto.setIgasm1115Form(form);
			ctlBL.getContainerNameByEiid(dto);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========设备选择画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		
		if("SEARCH".equals(mapping.getParameter())){
			//设备选择画面初期显示处理
			log.debug("========设备选择画面初期显示处理开始========");
			
			//分页用DTO取得
			getPaginDTO(req,"IGASM1115");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if (req.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGASM1115Form) req.getSession().getAttribute("IGASM1115Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}else{
				pDto.setFromCount(form.getFromCount());
			}
			
//			if ("SEARCH".equals(mapping.getParameter())){
//				//由详细画面，编辑画面返回查询画面时的再检索处理
//				form = (IGASM1115Form) req.getSession().getAttribute("IGASM1115Form");
//				if ( form== null){
//					form = new IGASM1115Form();
//				}else {
//					if (req.getParameter("PAGING") == null) {
//						pDto.setFromCount(form.getFromCount());
//					} else {
//						form.setFromCount(pDto.getFromCount());
//					}
//				}
//			} else {
//				if (req.getParameter("PAGING") == null) {
//					pDto.setFromCount(0);
//				}
//			}

			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM1115");
			
			//DTO输入参数设定
			dto.setIgasm1115Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//机房检索逻辑调用
			dto = ctlBL.initIGASM1115Action(dto);
			
			//将机房信息检索结果设定到VO中
			IGASM11151VO vo = new IGASM11151VO(
					dto.getComputerDeviceVWInfoList());
			
			super.<IGASM11151VO>setVO(req, vo);
			
			form.setSuccess("0");

			forward = "DISP";
			
			log.debug("========设备选择画面初期显示处理终了========");
		}
		
		if ("ADD".equals(mapping.getParameter())) {
			//设备选择画面初期显示处理
			log.debug("========设备设定处理开始========");
			//DTO输入参数设定
			dto.setIgasm1115Form(form);
			
			dto = ctlBL.setComputerDeviceAction(dto);
			
			form.setSuccess("1");
			
			forward = "DISP";
			
			log.debug("========设备设定处理终了========");
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
