/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
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
import com.deliverik.infogovernor.asset.bl.IGASM20BL;
import com.deliverik.infogovernor.asset.dto.IGASM20DTO;
import com.deliverik.infogovernor.asset.form.IGASM2013Form;
import com.deliverik.infogovernor.asset.vo.IGASM20131VO;

/**
 * 概述: 域CI查询画面Action处理
 * 功能描述: 域CI查询画面Action处理
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
public class IGASM2013Action extends BaseAction{
	static Log log = LogFactory.getLog(IGASM2013Action.class);
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
		IGASM2013Form form = (IGASM2013Form)actionForm;
		
		//BL取得
		IGASM20BL ctlBL = (IGASM20BL) getBean("igasm20BL");
		
		//DTO生成
		IGASM20DTO dto = new IGASM20DTO();
		
		if ("DISP".equals(mapping.getParameter())) {
			// 域CI查询画面初期显示处理
			log.debug("========域CI查询画面初期显示处理========");
			
			dto = ctlBL.searchIGASM2013Action(dto);
			
			req.getSession().setAttribute("ADDomainList", dto.getDomainList());
			
			req.getSession().setAttribute("ADTypeList", dto.getTypeList());
			
			log.debug("========域CI查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGASM2013");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGASM2013Form) req.getSession().getAttribute("IGASM2013Form");
				if ( form== null){
					form = new IGASM2013Form();
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
					form = (IGASM2013Form) req.getSession().getAttribute("IGASM2013Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//导入对象查询处理
			log.debug("========域CI查询处理开始========");
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM2013");
			
			//DTO输入参数设定
			dto.setIgasm2013Form(form);
			
			dto.setEiDomainDetailVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//导入对象检索逻辑调用
			dto = ctlBL.searchDoaminCiInfoAction(dto);
			//将导入对象信息检索结果设定到VO中
			IGASM20131VO vo = new IGASM20131VO();
			
			vo.setEiDomainDetailVWInfoList(dto.getEiDomainDetailVWInfoList());
			
			vo.setEilabel(form.getEilabel());
			
			vo.setEiDomainDetailCIInfoList(dto.getEiDomainDetailCIInfoList());
			super.<IGASM20131VO>setVO(req,vo);
			
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
