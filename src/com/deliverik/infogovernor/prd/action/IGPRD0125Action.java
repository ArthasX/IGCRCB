/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prd.action;

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
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0125Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01101VO;
import com.deliverik.infogovernor.prd.vo.IGPRD01251VO;
/**
 * 流程表单级联Action
 *
 */

public class IGPRD0125Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRD0125Action.class);
	
	/**
	 * <p>
	 * Description: 授权处理action
	 * </p>
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		//BL取得
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");	
		//DTO生成
		IGPRD01DTO dto = new IGPRD01DTO();
		
		IGPRD0125Form form = (IGPRD0125Form)actionForm;
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========表单联动初始页处理开始========");
			
			form.setPdid(request.getParameter("pdid"));
			//自定义流程信息查询
			getPaginDTO(request,"IGPRD0101");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			pDto.setFromCount(0);
			pDto.setTotalCount(0);
			
			int maxCnt = getMaxDataCount("IGPRD0101");
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			IG380SearchCondImpl cond = new IG380SearchCondImpl();
			cond.setPdid(form.getPdid());
			dto.setProcessDefinitionSearchCond(cond);
			dto = ctlBL.searchProcessDefinitionAction(dto);
			IG380Info processDefinition = dto.getProcessDefinitionList().get(0);
			form.setPdname(processDefinition.getPdname());
			form.setPddesc(processDefinition.getPddesc());
			form.setPldpdid(processDefinition.getPdid());
			form.setInitiativepidid(null);
			form.setPassivitypidid(null);
			dto.setProcessLinkageDefSearchCond(form);
			dto = ctlBL.searchProcessLinkageDef(dto);
			form.setPdid(processDefinition.getPdid());
			IGPRD01251VO vo = new IGPRD01251VO();
			vo.setProcessLinkageDefList(dto.getProcessLinkageDefList());
			super.<IGPRD01251VO>setVO(request,vo);
			log.debug("========表单联动初始页处理终了========");
			if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
				//历史版本下的查看
				return mapping.findForward("VIEWHISTORY");
			}else{
				return mapping.findForward("DISP");
			}
		} else if ("INSERTDISP".equals(mapping.getParameter())){//添加参与者
			log.debug("========表单联动插入页面初始化开始========");
			
			form.setPdid(request.getParameter("pdid"));
			log.debug("========表单联动插入页面初始化终了========");
			return mapping.findForward("DISP");
		}//联动表单添加功能 
		else if("INSERT".equals(mapping.getParameter())){
			//实例化FORM
			
			form.setPdid(request.getParameter("pdid"));
			form.setPldpdid(form.getPdid());
			dto.setIgPRD0125Form(form);
			ctlBL.insertProcessLinkageDef(dto);
			addMessage(request, new ActionMessage("IGPRD0125.I002"));
			return mapping.findForward("DISP");
		}//联动表单删除功能
		else if("DELETE".equals(mapping.getParameter())){
			ctlBL.deleteProcessLinkageDef(request.getParameter("plid"));
			addMessage(request, new ActionMessage("IGPRD0125.I001"));
			return mapping.findForward("DISP");
		}
		//主动表单选择 
		else if("SETINITIAL".equals(mapping.getParameter())){
			int maxCnt = getMaxDataCount("IGPRD0125");
			getPaginDTO(request,"IGPRD0125");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			pDto.setFromCount(0);
			pDto.setTotalCount(0);
			IGPRD01DTO igprd01dto = new IGPRD01DTO();
			igprd01dto.setMaxSearchCount(maxCnt);
			igprd01dto.setPagingDto(pDto);
			IG007SearchCondImpl cond = new IG007SearchCondImpl();
			cond.setPdid(request.getParameter("pdid"));
			if(StringUtils.isNotEmpty(request.getParameter("pidmode"))) {
				cond.setPidmode(request.getParameter("pidmode"));
			}
			igprd01dto.setProcessInfoDefSearchCond(cond);
			igprd01dto = ctlBL.searchProcessInfoDefAction(igprd01dto);
			IGPRD01101VO vo = new IGPRD01101VO(igprd01dto.getProcessInfoDefList());
			super.<IGPRD01101VO>setVO(request, vo);
			return mapping.findForward("DISP");
		}
		//联动表单选择
		else if("SETPASSIVITY".equals(mapping.getParameter())){
			int maxCnt = getMaxDataCount("IGPRD0125");
			getPaginDTO(request,"IGPRD0125");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			pDto.setFromCount(0);
			pDto.setTotalCount(0);
			IGPRD01DTO igprd01dto = new IGPRD01DTO();
			igprd01dto.setMaxSearchCount(maxCnt);
			igprd01dto.setPagingDto(pDto);
			IG007SearchCondImpl cond = new IG007SearchCondImpl();
			cond.setPdid(request.getParameter("pdid"));
			cond.setPidmode(IGPRDCONSTANTS.PROCESSINFODEF_MODE_PUBLIC);
			if(StringUtils.isNotEmpty(request.getParameter("pidmode"))) {
				cond.setPidmode(request.getParameter("pidmode"));
			}
			igprd01dto.setProcessInfoDefSearchCond(cond);
			igprd01dto = ctlBL.searchProcessInfoDefAction(igprd01dto);
			IGPRD01101VO vo = new IGPRD01101VO(igprd01dto.getProcessInfoDefList());
			super.<IGPRD01101VO>setVO(request, vo);
			return mapping.findForward("DISP");
		}
		
		return mapping.findForward("DISP");
	}
	
}
