/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.svc.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCondImpl;
import com.deliverik.infogovernor.svc.bl.IGSVC01BL;
import com.deliverik.infogovernor.svc.dto.IGSVC01DTO;
import com.deliverik.infogovernor.svc.form.IGSVC0100Form;
import com.deliverik.infogovernor.svc.vo.IGSVC01061VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_����̨_ͨ�ò�ѯACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSVC0110Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSVC0106Action.class);
	
	/**
	 * <p>
	 * Description: ͨ��action����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		IGSVC0100Form form = (IGSVC0100Form)actionForm;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========ͨ�ò�ѯ���������ʾ����ʼ========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========ͨ�ò�ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		//��ȡBL�ӿ�ʵ��
		IGSVC01BL ctlBL = (IGSVC01BL) getBean("igsvc01BL");
		//ʵ����DTO
		IGSVC01DTO dto = new IGSVC01DTO();
		//ͨ�ò�ѯ
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========ͨ�ò�ѯ����ʼ========");
			//��ȡ��ҳBean
			getPaginDTO(request,"IGSVC0106");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			//����ʱ��俪ʼ����Ĳ�ѯ������ֵ
			if ("SEARCH1".equals(mapping.getParameter())){
				form = (IGSVC0100Form) request.getSession().getAttribute("IGSVC0100Form");
				if ( form == null){
					form = new IGSVC0100Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(0);
						form = (IGSVC0100Form) request.getSession()
								.getAttribute("IGSVC0100Form");
						if (form != null) {
							form.setFromCount(0);
						}
					}
			}
			
			User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			String searchType = request.getParameter("searthType");
 
			if (request.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGSVC0100Form) request.getSession().getAttribute("IGSVC0100Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}else{
				pDto.setFromCount(form.getFromCount());
			}
			
//			pDto.setFromCount(form.getFromCount());
			
			IG677SearchCondImpl cond = new IG677SearchCondImpl();
			cond.setPpuserid(user.getUserid());
			cond.setPrtitle(form.getPrtitle());
			cond.setPrserialnum(form.getPrserialnum());
			cond.setPpproctime_from(form.getPropentime());
			cond.setPpproctime_to(form.getPrclosetime());
			cond.setPrpdid(form.getPrpdid());
			dto.setProcessInfoSearchCond(cond);
			int maxCnt = getMaxDataCount("IGSVC0106");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto.setPrSearchCond(form);
			//����BL��ѯ
			dto = ctlBL.getDoneProcessRecordsForLook(dto);
			WorkFlowDefinitionBL wfdBL = (WorkFlowDefinitionBL) getBean("workFlowDefinitionBL");
			IG380SearchCondImpl wfdCond = new IG380SearchCondImpl();
			wfdCond.setPtid(8);
			List<IG380Info> list = wfdBL.searchProcessDefinition(wfdCond);
			List<LabelValueBean> statusBeanList = new ArrayList<LabelValueBean>();
			if (list != null && list.size() > 0) {
				statusBeanList.add(new LabelValueBean());
				for (int i = 0; i < list.size(); i++) {
					statusBeanList.add(new LabelValueBean(list.get(i).getPdname(), list.get(i).getPdid()));
				}
			}
			request.setAttribute("statusBeanList", statusBeanList);
			//����VO
			IGSVC01061VO vo = new IGSVC01061VO();
			vo.setProcessRecordList(dto.getProcessList());
			vo.setDetailPgMap(dto.getDetailPgMap());
			super.<IGSVC01061VO>setVO(request, vo);
			List<ActionMessage> messageList = dto.getMessageList();
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(request, message);
				}
			}
			log.debug("========ͨ�ò�ѯ��������========");
		}
		return mapping.findForward("DISP");
	}

}
