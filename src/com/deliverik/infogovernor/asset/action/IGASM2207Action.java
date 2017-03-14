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
import com.deliverik.infogovernor.asset.bl.IGASM22BL;
import com.deliverik.infogovernor.asset.dto.IGASM22DTO;
import com.deliverik.infogovernor.asset.form.IGASM2207Form;
import com.deliverik.infogovernor.asset.vo.IGASM22071VO;

/**
 * 概述: CI变更任务信息检索Action处理
 * 功能描述: CI变更任务信息检索Action处理
 * 创建记录: 2011/05/19
 * 修改记录: 
 */
public class IGASM2207Action extends BaseAction{
	static Log log = LogFactory.getLog(IGASM2207Action.class);


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
		IGASM2207Form form = (IGASM2207Form)actionForm;
		
		//BL取得
		IGASM22BL ctlBL = (IGASM22BL) getBean("igasm22BL");
		
		//DTO生成
		IGASM22DTO dto = new IGASM22DTO();

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGASM2207");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGASM2207Form) req.getSession().getAttribute("IGASM2207Form");
				if ( form== null){
					form = new IGASM2207Form();
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
					form = (IGASM2207Form) req.getSession().getAttribute("IGASM2207Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//CI变更任务查询处理
			log.debug("========CI变更任务查询处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM2003");
			
			//DTO输入参数设定
			dto.setCiTaskSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//CI变更任务检索逻辑调用
			dto = ctlBL.searchCITaskAction(dto);
			
			//CI变更任务信息检索结果设定到VO中
			IGASM22071VO vo = new IGASM22071VO(dto.getCiTaskInfoList());
			
			super.<IGASM22071VO>setVO(req,vo);
			
			log.debug("========CI变更任务查询处理终了========");
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
