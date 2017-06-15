/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
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
import com.deliverik.infogovernor.prd.vo.IGPRD01012VO;

/**
 * 流程定义查询Action处理
 *
 */
public class IGPRD0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0101Action.class);

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
			log.debug("========流程定义查询处理开始========");
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
			
			if(StringUtils.isEmpty(form.getPttype())){
				form.setPttype(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_WD);
			}
			dto.setPttype(form.getPttype());
			dto = ctlBL.searchProcessTemplateAction(dto);

			Integer[] ptidForType = new Integer[1];
			if(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_WD.equals(form.getPttype())){
				ptidForType = new Integer[6];
				ptidForType[0] = IGPRDCONSTANTS.PROCESS_DEFINITION_COMMON_TEMPLATE_ID;
				ptidForType[1] = IGPRDCONSTANTS.PROCESS_DEFINITION_ID;
				ptidForType[2] = IGPRDCONSTANTS.PROCESS_DEFINITION_PD;
				ptidForType[3] = IGPRDCONSTANTS.PROCESS_DEFINITION_CD;
				ptidForType[4] = IGPRDCONSTANTS.PROCESS_DEFINITION_DD;
				ptidForType[5] = IGPRDCONSTANTS.PROCESS_DEFINITION_SD;
			}else{
				ptidForType[0] = dto.getProcessTemplate().getPtid();
			}
			
			form.setPrTypeArray(ptidForType);

			//流程定义信息检索逻辑调用
			dto = ctlBL.searchLastProcessDefinitionAction(dto);
			
			//将流程定义信息检索结果设定到VO中
			IGPRD01011VO vo = new IGPRD01011VO(dto.getProcessDefinitionList());
			
			super.<IGPRD01011VO>setVO(req.getSession(), vo);
			
			req.setAttribute("tmpmap", dto.getMap());
			
			saveToken(req);
			
			log.debug("========流程定义查询处理终了========");
		} else if("UPGRADE".equals(mapping.getParameter())){
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
		} else if("COPY".equals(mapping.getParameter())){
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
		} else if("IMPORT".equals(mapping.getParameter())){
			log.debug("========流程定义导入处理开始========");
			if (isTokenValid(req, true)){
				dto.setIgPRD0101Form(form);
				//调用BL
				dto = ctlBL.importProcessDefAction(dto);
				if(dto.getErrorMessages() != null && dto.getErrorMessages().size() > 0){
					IGPRD01012VO vo = new IGPRD01012VO();
					vo.setErrorMessages(dto.getErrorMessages());
					super.<IGPRD01012VO>setVO(req, vo);
					return mapping.findForward("ERROR");
				}
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("========流程定义导入处理终了========");
		} else if("EXPORT".equals(mapping.getParameter())){
			log.debug("========流程定义导出处理开始========");
			dto.setIgPRD0101Form(form);
			//调用BL
			ctlBL.exportProcessDefAction(dto);
			form.setPdid(null);//不清空查询不好使
			log.debug("========流程定义导出处理终了========");
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		if("EXPORT".equals(mapping.getParameter())) {
			return new ActionForward("/download.do?type=pd_export&filepath=" + dto.getFilepath_export());
		} else {
			return mapping.findForward("DISP");
		}
	}
}
