/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
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
import com.deliverik.infogovernor.soc.cim.form.IGCIM0213Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM02131VO;

/**
 * 概述: 域CI查询画面Action处理
 * 功能描述: 域CI查询画面Action处理
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
public class IGCIM0213Action extends BaseAction{
	static Log log = LogFactory.getLog(IGCIM0213Action.class);
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
		IGCIM0213Form form = (IGCIM0213Form)actionForm;
		
		//BL取得
		IGCIM02BL ctlBL = (IGCIM02BL) getBean("igcim02BL");
		
		//DTO生成
		IGCIM02DTO dto = new IGCIM02DTO();
		dto.setLocale(this.getLocale(req));
		if ("DISP".equals(mapping.getParameter())) {
			// 域CI查询画面初期显示处理
			log.debug("========域CI查询画面初期显示处理========");
			
			dto = ctlBL.searchIGCIM0213Action(dto);
			
			req.getSession().setAttribute("ADDomainList", dto.getDomainList());
			
			req.getSession().setAttribute("ADTypeList", dto.getTypeList());
			
			log.debug("========域CI查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGCIM0213");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGCIM0213Form) req.getSession().getAttribute("IGCIM0213Form");
				if ( form== null){
					form = new IGCIM0213Form();
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
					form = (IGCIM0213Form) req.getSession().getAttribute("IGCIM0213Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//导入对象查询处理
			log.debug("========域CI查询处理开始========");
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCIM0213");
			
			//DTO输入参数设定
			dto.setIgcim0213Form(form);
			
			dto.setEiDomainDetailVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//导入对象检索逻辑调用
			dto = ctlBL.searchDoaminCiInfoAction(dto);
			//将导入对象信息检索结果设定到VO中
			IGCIM02131VO vo = new IGCIM02131VO();
			
			vo.setSoc0138InfoList(dto.getSOC0138InfoList());
			
			vo.setEilabel(form.getEilabel());
			
			vo.setSoc0136infoList(dto.getSOC0136InfoList());
			super.<IGCIM02131VO>setVO(req,vo);
			
			log.debug("========域CI查询处理终了========");
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
