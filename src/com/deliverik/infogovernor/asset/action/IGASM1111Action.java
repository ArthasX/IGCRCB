package com.deliverik.infogovernor.asset.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
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
import com.deliverik.infogovernor.asset.form.IGASM1111Form;
import com.deliverik.infogovernor.asset.vo.IGASM11111VO;
import com.deliverik.infogovernor.asset.vo.IGASM11201VO;

/**
 * 机柜列表画面Action处理
 *
 */
public class IGASM1111Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1111Action.class);

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
		IGASM1111Form form = (IGASM1111Form)actionForm;

		//BL取得
		IGASM11BL ctlBL = (IGASM11BL) getBean("igasm11BL");
		
		//DTO生成
		IGASM11DTO dto = new IGASM11DTO();
		
		//画面跳转参数
		String forward = null;
		
		if( "DISP".equals(mapping.getParameter()) || "SEARCH".equals(mapping.getParameter())){
			//机柜选择画面初期显示处理
			log.debug("========机柜列表画面初期显示处理开始========");
			
			//分页用DTO取得
			getPaginDTO(req,"IGASM1111");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGASM1111Form) req.getSession().getAttribute("IGASM1111Form");
				if ( form== null){
					form = new IGASM1111Form();
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
					form = (IGASM1111Form) req.getSession().getAttribute("IGASM1111Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}

			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM1111");
			
			//DTO输入参数设定
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//机房检索逻辑调用
			dto = ctlBL.initIGASM1111Action(dto);
			
			//将机房信息检索结果设定到VO中
			IGASM11111VO vo = new IGASM11111VO(
					dto.getComputerContainerVWInfoList());
			
			super.<IGASM11111VO>setVO(req, vo);
			
			forward = "DISP";
			
			log.debug("========机柜列表画面初期显示处理终了========");
		}
		
		if ("DELETE".equals(mapping.getParameter())){
			//机柜删除处理
			log.debug("========机柜删除处理开始========");
			
			//DTO输入参数设定
			dto.setDeleteEntityItem(form.getDeleteEiid());
			
			//机柜删除逻辑调用
			ctlBL.deleteComputerContainerInfoAction(dto);
			
			forward = "DISP";

			log.debug("========机柜删除处理终了========");
		}
		if ("Detail".equals(mapping.getParameter())){
			//查询机柜设备详细
			log.debug("========设备详细处理开始========");
			String eiid = null;
			if(StringUtils.isEmpty(form.getComputerContainerId())){
				 eiid=req.getSession().getAttribute("eiid").toString();
				 dto.setComputerContainerId(eiid);
				 forward = "Detail2";
			}else{
				dto.setComputerContainerId(form.getComputerContainerId());
				req.getSession().setAttribute("eiid", form.getComputerContainerId());
				forward = "Detail1";
			}	
			dto = ctlBL.getEquipmentAndIpAction(dto);
			IGASM11201VO vo = new IGASM11201VO();			
			vo.setEilist(dto.getEilist());
			super.<IGASM11201VO>setVO(req, vo);						
			log.debug("========设备详细处理终了========");
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
