package com.deliverik.infogovernor.svc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.svc.bl.IGPROCESSType;
import com.deliverik.infogovernor.svc.bl.IGSVC07BL;
import com.deliverik.infogovernor.svc.dto.IGSVC07DTO;
import com.deliverik.infogovernor.svc.form.IGSVC0604Form;
import com.deliverik.infogovernor.svc.vo.IGSVC05131VO;

public class IGSVC0604Action extends BaseAction {

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {

		IGSVC0604Form form = (IGSVC0604Form)actionForm;
		IGSVC07BL ctlBL = (IGSVC07BL) getBean("igsvc07BL");
		IGSVC07DTO dto = new IGSVC07DTO();
		String prassetid = req.getParameter("prassetid");
		String type = req.getParameter("type");
		String propentime_from = req.getParameter("propentime_from");
		String propentime_to = req.getParameter("propentime_to");
		String prtype = req.getParameter("prtype");
		String userId = req.getParameter("userId");
		
		req.setAttribute("prtype", prtype);
		
		if(null != userId && !"".equals(userId)){
			form.setPpuserid(userId);
			form.setPpproctime("not");
			form.setPpstatus("V");
		}
		if(null != prassetid && !"".equals(prassetid)){
			form.setPrassetid(Integer.valueOf(prassetid));
		}
		if(null != type && !"".equals(type)){
			form.setPrassetcategory(type);
		}
		form.setPropentime(propentime_from);
		form.setPrclosetime(propentime_to);
		if(IGPROCESSType.WORK_PRTYPE.equals(prtype)){
			form.setIsWork(1);
			form.setPrtype(null);
		}else{
			form.setIsWork(0);
			form.setPrtype(prtype);
		}
		
		getPaginDTO(req,"IGSVC0604");
		PagingDTO pDto;
		pDto = (PagingDTO)req.getAttribute("PagingDTO");
//		pDto.setFromCount(form.getFromCount());
		int maxCnt = getMaxDataCount("IGSVC0604");
		dto.setPrSearchCond(form);		
		dto.setMaxSearchCount(maxCnt);
		dto.setPagingDto(pDto);

		IGSVC05131VO vo = new IGSVC05131VO();
		String forward = null;
		if(null != type){
			dto = ctlBL.findSummaryCountForOperationTask(dto);
			vo.setProcessRecordList(dto.getProcessRecordList());
			forward = "DISP";
			
		} else {
			dto.setProcessRecordInfoSearchCond(form);
			dto = ctlBL.findSummaryCountForPersonTask(dto);
			
			if(!"GD".equals(prtype)){
				//流程列表
				vo.setProcessRecordInfo(dto.getProcessRecordInfo());
			}else{
				//工单列表
				vo.setProcessGdRecordInfoList(dto.getProcessGdRecordInfoList());
			}
			forward = "PERSON";
		}
		
		super.<IGSVC05131VO>setVO(req, vo);
		
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward(forward);
	}

}
