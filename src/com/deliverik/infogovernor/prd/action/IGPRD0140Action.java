/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.action;

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
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0101Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01011VO;

/**
 * 流程定义历史查询Action处理
 *
 * @author wanglongyu@deliverik.com
 */
public class IGPRD0140Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0140Action.class);

	/**
	 * 流程定义查询处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGPRD0101Form form = (IGPRD0101Form)actionForm;
		
		//BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		//DTO生成
		IGPRD01DTO dto = new IGPRD01DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//流程定义查询画面初期显示处理
			log.debug("========流程定义查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			saveToken(req);
			log.debug("========流程定义查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if ( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//流程定义查询处理
			log.debug("========流程历史版本查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGPRD0101");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGPRD0101Form) req.getSession().getAttribute("IGPRD0101Form");
				if ( form == null ) {
					form = new IGPRD0101Form();
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
					form = (IGPRD0101Form) req.getSession().getAttribute("IGPRD0101Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGPRD0101");
			
			dto.setProcessDefinitionSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//通用模板ID

			Integer[] ptidForType = new Integer[6];
			ptidForType[0] = IGPRDCONSTANTS.PROCESS_DEFINITION_COMMON_TEMPLATE_ID;
			ptidForType[1] = IGPRDCONSTANTS.PROCESS_DEFINITION_ID;
			ptidForType[2] = IGPRDCONSTANTS.PROCESS_DEFINITION_PD;
			ptidForType[3] = IGPRDCONSTANTS.PROCESS_DEFINITION_CD;
			ptidForType[4] = IGPRDCONSTANTS.PROCESS_DEFINITION_DD;
			ptidForType[5] = IGPRDCONSTANTS.PROCESS_DEFINITION_SD;
			form.setPrTypeArray(ptidForType);

			//流程定义信息检索逻辑调用
			dto = ctlBL.searchHistoryProcessDefinitionAction(dto);
			//将流程定义信息检索结果设定到VO中
			IGPRD01011VO vo = new IGPRD01011VO(dto.getProcessDefinitionList());
			
			super.<IGPRD01011VO>setVO(req, vo);
			
			req.setAttribute("tmpmap", dto.getMap());
			
			saveToken(req);
			
			log.debug("========流程历史版本查询处理终了========");
		} else if( "UPGRADE".equals(mapping.getParameter())){
			log.debug("========流程定义升版处理开始========");
			if (isTokenValid(req, true)){
				dto.setPdid(form.getPdid());
				//调用BL新增
				dto = ctlBL.upgradeProcessDefAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			form.setPdid(null);//不清空查询不好使
			log.debug("========流程定义升版处理终了========");
		} else if( "COPY".equals(mapping.getParameter())){
			log.debug("========流程定义复制处理开始========");
			if (isTokenValid(req, true)){
				dto.setPdid(form.getPdid());
				//调用BL新增
				dto = ctlBL.copyProcessDefAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			form.setPdid(null);//不清空查询不好使
			log.debug("========流程定义复制处理终了========");
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
