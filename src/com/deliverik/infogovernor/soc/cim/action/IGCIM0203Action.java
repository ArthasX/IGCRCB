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
import com.deliverik.infogovernor.soc.cim.form.IGCIM0203Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM02031VO;

/**
 * 概述: 资产域定义查询画面Action处理
 * 功能描述: 资产域定义查询画面Action处理
 * 创建记录: 2011/04/25
 * 修改记录: 
 */
public class IGCIM0203Action extends BaseAction{
	static Log log = LogFactory.getLog(IGCIM0203Action.class);


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
		IGCIM0203Form form = (IGCIM0203Form)actionForm;
		
		//BL取得
		IGCIM02BL ctlBL = (IGCIM02BL) getBean("igcim02BL");
		
		//DTO生成
		IGCIM02DTO dto = new IGCIM02DTO();
		dto.setLocale(this.getLocale(req));
		
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			
			//分页用DTO取得
			getPaginDTO(req,"IGCIM0203");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGCIM0203Form) req.getSession().getAttribute("IGCIM0203Form");
				if ( form== null){
					form = new IGCIM0203Form();
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
					form = (IGCIM0203Form) req.getSession().getAttribute("IGCIM0203Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//资产域定义查询处理
			log.debug("========资产域定义查询处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCIM0203");
			
			//DTO输入参数设定
			dto.setEiDomainDefSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//资产域定义检索逻辑调用
			dto = ctlBL.searchEiDomainDefAction(dto);
			
			//将资产域定义信息检索结果设定到VO中
			IGCIM02031VO vo = new IGCIM02031VO(dto.getEiDomainDefInfoList());
			
			super.<IGCIM02031VO>setVO(req,vo);
			
			log.debug("========资产域定义查询处理终了========");
		}
		if ("DELETE".equals(mapping.getParameter())){
			//资产域定义删除处理
			log.debug("========资产域定义删除处理开始========");
			
			//DTO输入参数设定
			dto.setDeleteEiddid(form.getDeleteEiddid());
			
			//资产域定义信息删除逻辑调用
			ctlBL.deleteEiDomainDefAction(dto);
			
			log.debug("========资产域定义删除处理终了========");
		}
		
		if ("SNAPSHOT".equals(mapping.getParameter())) {
			log.debug("========域手动快照生成处理开始========");
			
			dto.setIgcim0203Form(form);
			dto = ctlBL.handSnapshotAction(dto);
			
			
			log.debug("========域手动快照生成处理终了========");
			
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
