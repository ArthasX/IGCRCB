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
import com.deliverik.infogovernor.asset.form.IGASM2007Form;
import com.deliverik.infogovernor.asset.vo.IGASM20071VO;

/**
 * 概述: 导入对象信息查询画面Action处理
 * 功能描述: 导入对象信息查询画面Action处理
 * 创建记录: 2011/05/04
 * 修改记录: 
 */
public class IGASM2007Action extends BaseAction{
	static Log log = LogFactory.getLog(IGASM2007Action.class);
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
		IGASM2007Form form = (IGASM2007Form)actionForm;
		
		//BL取得
		IGASM20BL ctlBL = (IGASM20BL) getBean("igasm20BL");
		
		//DTO生成
		IGASM20DTO dto = new IGASM20DTO();
		
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGASM2007");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGASM2007Form) req.getSession().getAttribute("IGASM2007Form");
				if ( form== null){
					form = new IGASM2007Form();
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
					form = (IGASM2007Form) req.getSession().getAttribute("IGASM2007Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//导入对象查询处理
			log.debug("========导入对象查询处理开始========");
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM2007");
			
			//DTO输入参数设定
			dto.setImportVersionSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//导入对象检索逻辑调用
			dto = ctlBL.searchImportVersionAction(dto);
			//将导入对象信息检索结果设定到VO中
			IGASM20071VO vo = new IGASM20071VO(dto.getImportVersionInfoList());
			
			super.<IGASM20071VO>setVO(req,vo);
			
			log.debug("========导入对象查询处理终了========");
		}
		if ("DELETE".equals(mapping.getParameter())){
			//导入对象删除处理
			log.debug("========导入对象删除处理开始========");
			
			//DTO输入参数设定
			dto.setDeleteImpeiid(form.getDeleteImpeiid());
			
			//导入对象信息删除逻辑调用
			ctlBL.deleteImportVersionAction(dto);
			
			log.debug("========导入对象删除处理终了========");
		}
		if ("CHANGE_STATUS".equals(mapping.getParameter())){
			log.debug("========导入对象状态变化处理开始========");
			//DTO输入参数设定
			dto.setImpeiname(form.getImpeiname_eq());
			
			dto.setImpversion(form.getImpversion());
			
			dto.setDeleteflag(form.getDeleteflag());
			
			//导入对象信息调整逻辑调用
			ctlBL.changeDeleteFlagAction(dto);
			
			addMessage(req, new ActionMessage("IGASM2007.I001"));
			log.debug("========导入对象状态变化处理终了========");
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
