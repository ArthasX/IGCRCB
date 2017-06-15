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
import com.deliverik.infogovernor.asset.form.IGASM1101Form;
import com.deliverik.infogovernor.asset.vo.IGASM11011VO;

/**
 * 机房列表画面Action处理
 *
 */
public class IGASM1101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1101Action.class);

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
		IGASM1101Form form = (IGASM1101Form)actionForm;

		//BL取得
		IGASM11BL ctlBL = (IGASM11BL) getBean("igasm11BL");
		
		//DTO生成
		IGASM11DTO dto = new IGASM11DTO();
		
		if( "DISP".equals(mapping.getParameter())||"SEARCH".equals(mapping.getParameter())){
			//机房查询画面初期显示处理
			log.debug("========机房查询画面初期显示处理开始========");
			
			//分页用DTO取得
			getPaginDTO(req,"IGASM1101");

			PagingDTO pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGASM1101Form) req.getSession().getAttribute("IGASM1101Form");
				if ( form== null){
					form = new IGASM1101Form();
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
					form = (IGASM1101Form) req.getSession().getAttribute("IGASM1101Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM1101");
			
			//DTO输入参数设定
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//机房检索逻辑调用
			dto = ctlBL.initIGASM1101Action(dto);
			
			//将机房信息检索结果设定到VO中
			IGASM11011VO vo = new IGASM11011VO(dto.getComputerRoomVWInfoList());
			
			super.<IGASM11011VO>setVO(req, vo);
			
			log.debug("========机房查询画面初期显示处理终了========");
		}
		
		if ("DELETE".equals(mapping.getParameter())){
			//机房删除处理
			log.debug("========网络删除处理开始========");
			
			//DTO输入参数设定
			dto.setDeleteEntityItem(form.getDeleteEiid());
			
			//网络信息删除逻辑调用
			ctlBL.deleteComputerRoomInfoAction(dto);
			
			log.debug("========网络删除处理终了========");
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
