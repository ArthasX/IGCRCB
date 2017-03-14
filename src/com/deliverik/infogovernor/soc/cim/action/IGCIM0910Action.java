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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM09BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM09DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0910Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM09101VO;

/**
 * 设备查询画面Action处理
 *
 */
public class IGCIM0910Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0910Action.class);

	/**
	 * 事件处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception IGCIM0912.jsp
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGCIM0910Form form = (IGCIM0910Form)actionForm;
		
		//BL取得
		IGCIM09BL ctlBL = (IGCIM09BL) getBean("igcim09BL");
		
		//DTO生成
		IGCIM09DTO dto = new IGCIM09DTO();
		dto.setLocale(this.getLocale(req));
		if( "DISP".equals(mapping.getParameter())){
			//设备查询画面初期显示处理
			log.debug("========设备查询画面初期显示处理开始========");
		
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========设备查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//设备查询画面再显示处理
			log.debug("========设备查询画面再显示处理开始========");
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========设备查询画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGCIM0910");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//设备查询处理
			log.debug("========设备查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGCIM0910Form) req.getSession().getAttribute("IGCIM0910Form");
				if ( form== null){
					form = new IGCIM0910Form();
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
					form = (IGCIM0910Form) req.getSession().getAttribute("IGCIM0910Form");
					//form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DEVICE);
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCIM0910");
			
			//DTO输入参数设定
			
			dto.setIgcim0910Form(form);
			
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//设备检索逻辑调用
			dto = ctlBL.searchEntityItemAction(dto);
			

			//将设备信息检索结果设定到VO中
			IGCIM09101VO vo = new IGCIM09101VO(dto.getEntityVWInfoList());
			vo.setDomainid(dto.getDomainid());
			vo.setDomainversion(dto.getDomainversion());
			vo.setShowRelationMap(dto.getShowRelationMap());
			vo.setCreatetime(dto.getCreatetime());
			
			super.<IGCIM09101VO>setVO(req, vo);
			
			log.debug("========设备查询处理终了========");
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
