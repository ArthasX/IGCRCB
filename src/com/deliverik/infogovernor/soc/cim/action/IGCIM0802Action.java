package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM02BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM02DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0802Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM08021VO;

/**
 * 采集结果查询画面Action处理
 *
 * 更新说明 20130605,将SOC0120修改为查询CR03
 */
public class IGCIM0802Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0802Action.class);

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
		IGCIM0802Form form = (IGCIM0802Form)actionForm;
		
		//BL取得
		IGCIM02BL ctlBL = (IGCIM02BL) getBean("igcim02BL");		
		//DTO生成
		IGCIM02DTO dto = new IGCIM02DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//采集结果查询画面初期显示处理
			log.debug("========采集结果查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========采集结果查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//类型查询处理
			log.debug("========采集结果查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGCIM0802");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGCIM0802Form) req.getSession().getAttribute("IGCIM0802Form");
				if ( form == null ) {
					form = new IGCIM0802Form();
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
					form = (IGCIM0802Form) req.getSession().getAttribute("IGCIM0802Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCIM0802");
			
			//DTO输入参数设定
			//20130605---修改为查询cr03
//			dto.setImportVersionSearchCond(form);
			dto.setIgcim0802Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//类型信息检索逻辑调用
			//dto = ctlBL.searchImportVersionAction(dto);
			dto=ctlBL.searchCr03Action(dto);
			//将类型信息检索结果设定到VO中
			IGCIM08021VO vo = new IGCIM08021VO();
//			vo.setSoc0120List(dto.getImportVersionInfoList());
			vo.setCr03VWInfoList(dto.getCr03VWInfoList());
			super.<IGCIM08021VO>setVO(req, vo);
			
			log.debug("========采集结果查询处理终了========");
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
