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
import com.deliverik.framework.soc.asset.EntityItemKeyWords;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM17BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM17DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1702Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM17021VO;

/**
 * 数据库-用户变更日志信息画面Action处理
 *
 */
public class IGCIM1702Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM1702Action.class);

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
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
				IGCIM1702Form form = (IGCIM1702Form)actionForm;
				
				//BL取得
				IGCIM17BL ctlBL = (IGCIM17BL) getBean("igcim17BL");
				
				//DTO生成
				IGCIM17DTO dto = new IGCIM17DTO();
				
				dto.setIgcim1702Form(form);
				
				//查询CI类型
				dto.setEsyscoding(EntityItemKeyWords.DATABASE_ESYSCODING);
				dto= ctlBL.searchSoc0113Info(dto);
				
				if ("INSERT".equals(mapping.getParameter())){
					//日志信息保存
					log.debug("========日志信息保存处理显示开始========");
					log.debug("========日志信息保存处理显示终了========");
				}
				if ("DELETE".equals(mapping.getParameter())){
					//日志信息删除
					log.debug("========日志信息删除处理显示开始========");
					log.debug("========日志信息删除处理显示终了========");
				}
				if("DISP".equals(mapping.getParameter())){
					log.debug("========日志预处理显示开始========");
					IGCIM17021VO vo = new IGCIM17021VO();
					
					vo.setCiTypes(dto.getSoc0113List());
					super.setVO(req, vo);
					
					log.debug("========日志预处理显示终了========");
					
				}
				
				if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
					//分页用DTO取得
					getPaginDTO(req,"IGCIM1702");
					
					PagingDTO pDto;
					
					pDto = (PagingDTO)req.getAttribute("PagingDTO");
					//设备查询处理
					log.debug("========设备查询处理开始========");
					if ("SEARCH1".equals(mapping.getParameter())){
						//由详细画面，编辑画面返回查询画面时的再检索处理
						form = (IGCIM1702Form)req.getSession().getAttribute("IGCIM1702Form");
						if ( form== null){
							form = new IGCIM1702Form();
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
							form = (IGCIM1702Form) req.getSession().getAttribute("IGCIM1702Form");
							if (form !=null) {
								form.setFromCount(0);
							}
						}
					}
				
				
					int maxCnt = getMaxDataCount("IGCIM1702");
					
					dto.setFormName("IGCIM1702Form");
					
					dto.setMaxSearchCount(maxCnt);
					
					dto.setPagingDto(pDto);
					
					dto.setIgcim1702Form(form);
					
					ctlBL.searchSoc0153List(dto);
					
					IGCIM17021VO vo = new IGCIM17021VO(dto.getSoc0153List());
					
					vo.setCiTypes(dto.getSoc0113List());
					
					super.setVO(req, vo);
					
					log.debug("========日志信息查找处理显示终了========");
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
