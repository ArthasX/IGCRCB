/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.soc.srv.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.soc.srv.bl.IGSRV02BL;
import com.deliverik.infogovernor.soc.srv.dto.IGSRV02DTO;
import com.deliverik.infogovernor.soc.srv.form.IGSRV0201Form;
import com.deliverik.infogovernor.soc.srv.vo.IGSRV02011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������ҳͨ�ò�ѯ ACTION
 * </p>
 * 
 * <p> 
 *   ����ʱ�� 2010/12/07  yangliang  ������ҳͨ�ò�ѯ 
 * </p>
 */

public class IGSRV0111Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSRV0111Action.class);
	
	/**
	 * <p>
	 * Description: �¼�action����
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
		//ʵ����FORM
		IGSRV0201Form form = (IGSRV0201Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGSRV02BL ctlBL = (IGSRV02BL) getBean("igsrv02BL");
		
		String forword = "DISP";

		//ʵ����DTO
		IGSRV02DTO dto = new IGSRV02DTO();
		if(form == null){
			request.setAttribute("provalue","");
		}else{
			if(form.getPrstatus()!=null){
				request.setAttribute("provalue",form.getPrstatus());
			}else{
				request.setAttribute("provalue","");
			}
		}
		dto = ctlBL.getProcessDefinitionAll(dto);
		request.setAttribute("list", dto.getProcessDefinitionList());
		request.getSession().setAttribute("ADlist", dto.getProcessDefinitionList());
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========ͨ�ò�ѯ���������ʾ����ʼ========");		
			saveToken(request);
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========ͨ�ò�ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		//
		if(form.getPrtitle()!=null){
			String str=new String(form.getPrtitle().getBytes("ISO-8859-1"),"UTF-8");
			form.setPrtitle(str);
		}
		//�¼���ѯ
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========ͨ�ò�ѯ����ʼ========");
			
			//��ȡ��ҳBean
			getPaginDTO(request,"IGSRV0111");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				form = (IGSRV0201Form) request.getSession().getAttribute("IGSRV0201Form");
				if ( form== null){
					form = new IGSRV0201Form();
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
					form = (IGSRV0201Form) request.getSession().getAttribute("IGSRV0201Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			int maxCnt = getMaxDataCount("IGSRV0111");
	
			form.setPrtype(null);
			
			if(StringUtils.isNotEmpty(form.getPdid())){
				form.setPrpdid(form.getPdid());
			}else{
				form.setPrpdid("0");
			}
			User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			form.setUserid_q(user.getUserid());
			String propentime = form.getPropentime();
			//�ڲ�ѯ��ʼ���ں�׷��ʱ��
			if(StringUtils.isNotEmpty(propentime)){
				form.setPropentime(propentime+" 00:00");
			}
			//�ڲ�ѯ�������ں�׷��ʱ��
			String prclosetime = form.getPrclosetime();
			if(StringUtils.isNotEmpty(prclosetime)){
				form.setPrclosetime(prclosetime+" 23:59");
			}
			//add 20111122 start --->
			//����porder�ֶ�
			dto.setPOrder(form.getPorder());
			//����psort�ֶ�
			dto.setPSort(form.getPsort());
			dto.setPrtitle(form.getPrtitle());
			dto.setPsort_order(form.getPsort_order());
			//����porder��psort�ֶ�ȡ������������õ�prtitle��
			dto = ctlBL.getSortOrder(dto);
			form.setPrtitle(dto.getPrtitle());
			form.setPsort_order(dto.getPsort_order());
			//add 20111122 end --->
			dto.setPrSearchCond(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto.setUser(user);
			//����BL��ѯ
			dto = ctlBL.getProcessRecords(dto);
			form.setPropentime(propentime);
			form.setPrclosetime(prclosetime);
			//add 20111122 ���ӹ����ֶεĴ��������޸ĵײ㣬���Դ��ֶε�ֵ����ӵ������ֶ���
			if(StringUtils.isNotEmpty(dto.getPrtitle()))
			{
				String[] param = dto.getPrtitle().split("&&&");
				form.setPrtitle(param[0]);
			}
			
			request.setAttribute("isAdmin",dto.getIsAdmin());
			saveToken(request);
			
			
			//����VO
			IGSRV02011VO vo = new IGSRV02011VO(dto.getProcessList());
			
			super.<IGSRV02011VO>setVO(request, vo);
			if(form.getPrstatus() == null){
				request.setAttribute("provalue","");
			}else{
				request.setAttribute("provalue",form.getPrstatus());
			}
			
			log.debug("========ͨ�ò�ѯ��������========");
		}
		if( "DEL".equals(mapping.getParameter())){
			if (form.getDelprid()!=null){
				List<IG500Info> ProcessRecordList = ctlBL.searchProcessRecordByKey(form.getDelprid());
				if(ProcessRecordList!=null && ProcessRecordList.size()>0){
				 dto.setPrid(form.getDelprid());
				 dto = ctlBL.delProcessRecord(dto);
				}
			}
			request.setAttribute("propentime", form.getPropentime());
			request.setAttribute("prclosetime", form.getPrclosetime());
			request.setAttribute("pdid", form.getPdid());
			request.setAttribute("prtitle",form.getPrtitle());
			request.setAttribute("fromCount",form.getFromCount());
			forword = "DISP2";
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward(forword);
	}
}
