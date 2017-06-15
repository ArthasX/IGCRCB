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
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1101Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM11011VO;

/**
 * 应用查询画面Action处理
 *
 */
public class IGCIM1101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM1101Action.class);

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
		IGCIM1101Form form = (IGCIM1101Form)actionForm;
		
		//BL取得
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		
		//DTO生成
		IGCIM01DTO dto = new IGCIM01DTO();
		dto.setLocale(this.getLocale(req));
		if( "DISP".equals(mapping.getParameter())){
			//应用查询画面初期显示处理
			log.debug("========应用查询画面初期显示处理开始========");
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========应用查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGCIM1101");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//应用查询处理
			log.debug("========应用查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGCIM1101Form) req.getSession().getAttribute("IGCIM1101Form");
				if ( form== null){
					form = new IGCIM1101Form();
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION);
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
					form = (IGCIM1101Form) req.getSession().getAttribute("IGCIM1101Form");
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION);
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCIM1101");
			form.setEsyscoding("999003001");
			
			//DTO输入参数设定
			dto.setEntityItemVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//应用检索逻辑调用
			dto = ctlBL.searchEntityItemActionApp(dto);
			
			//将应用信息检索结果设定到VO中
			IGCIM11011VO vo = new IGCIM11011VO(dto.getEntityItemVWInfoList());
			
			super.<IGCIM11011VO>setVO(req, vo);
			
			log.debug("========应用查询处理终了========");
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
