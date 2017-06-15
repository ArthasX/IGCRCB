/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.action;

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
import com.deliverik.framework.workflow.prd.model.IG110Info;
import com.deliverik.framework.workflow.prd.model.IG111Info;
import com.deliverik.infogovernor.prr.bl.IGPRR06BL;
import com.deliverik.infogovernor.prr.dto.IGPRR06DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0601Form;
import com.deliverik.infogovernor.prr.model.condition.ProcessSearchCondImpl;
import com.deliverik.infogovernor.prr.vo.IGPRR06011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����ͨ�ò�ѯAction
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR0601Action extends BaseAction{

	@SuppressWarnings("unchecked")
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGPRR0601Action.class);
		//BLȡ��
		IGPRR06BL ctlBL = (IGPRR06BL) getBean("igPRR06BL");
		//ʵ����dto
		IGPRR06DTO dto = new IGPRR06DTO();
		
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		dto.setUser(user);
		
		//dto�����趨
		dto.setForm(actionForm);
		//formȡ��
		IGPRR0601Form form = (IGPRR0601Form) actionForm;
		dto.setPdid(form.getPdid());
			//��ȡ���̲�ѯҳ·��
		dto = ctlBL.searchForwardJsp(dto);
		
		
		//ȡ�����̶���ID
		if(null!=form.getPdid()&&form.getPdid().length() < 7){
			dto = ctlBL.searchProcessDefinitionIdAction(dto);
			form.setPdid(dto.getPdid());
		}
		//��ȡҳ����ʾͷ
		if(request.getSession().getAttribute("AD_ProcessQueryTitle") == null){
			dto = ctlBL.searchProcessQueryTitleAction(dto);
			request.getSession().setAttribute("AD_ProcessQueryTitle", dto.getProcessQueryShowColumnList());
			request.getSession().setAttribute("AD_ProcessQuery", dto.getProcessQueryList());
			request.getSession().setAttribute("AD_STATUS_DEFINITION", dto.getPsdList());
		}
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("===============����ͨ�ò�ѯҳ���ʼ��������ʼ================");
			
			log.debug("===============����ͨ�ò�ѯҳ���ʼ����������================");
		}
		if("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			log.debug("==============����ͨ�ò�ѯ������ʼ===============");
			//��ȡ��ҳBean
			getPaginDTO(request,"IGPRR0601");
			PagingDTO pDto = (PagingDTO)request.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())) {
				// ����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGPRR0601Form) request.getSession().getAttribute("IGPRR0601Form");
				if (form == null) {
					form = new IGPRR0601Form();
				} else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGPRR0601Form) request.getSession().getAttribute("IGPRR0601Form");
					if (form != null) {
						form.setFromCount(0);
					}
				}
			}
			//ʵ������ѯ����
			ProcessSearchCondImpl cond = new ProcessSearchCondImpl();
			this.copyProperties(cond, actionForm);
			//ȡ����ʾ��
			List<IG110Info> showColumnList = (List<IG110Info>) request.getSession().getAttribute("AD_ProcessQueryTitle");
			//ȡ�ò�ѯ����
			List<IG111Info> queryList = (List<IG111Info>) request.getSession().getAttribute("AD_ProcessQuery");
			cond.setQueryList(queryList);
			cond.setShowColumnList(showColumnList);
			dto.setProcessSearchCond(cond);
			int maxCnt = getMaxDataCount("IGWKM0601");
			dto.setPagingDto(pDto);
			dto.setMaxSearchCount(maxCnt);
			dto = ctlBL.searchProcessRecordAction(dto);
			//ʵ����vo
			IGPRR06011VO vo = new IGPRR06011VO();
			vo.setResult(dto.getResult());
			super.setVO(request, vo);
			log.debug("==============����ͨ�ò�ѯ��������===============");
		}
		//��������
		if("EXPORT".equals(mapping.getParameter())){
			log.debug("===============ͨ�ò�ѯ����������ʼ=================");
			dto.setResponse(response);
			//ʵ������ѯ����
			ProcessSearchCondImpl cond = new ProcessSearchCondImpl();
			this.copyProperties(cond, actionForm);
			//ȡ����ʾ��
			List<IG110Info> showColumnList = (List<IG110Info>) request.getSession().getAttribute("AD_ProcessQueryTitle");
			//ȡ�ò�ѯ����
			List<IG111Info> queryList = (List<IG111Info>) request.getSession().getAttribute("AD_ProcessQuery");
			cond.setQueryList(queryList);
			cond.setShowColumnList(showColumnList);
			dto.setProcessSearchCond(cond);
			dto = ctlBL.exportProcessRecordAction(dto);
			log.debug("===============ͨ�ò�ѯ������������=================");
			return null;
		}
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		} 
		//��ת������JSP
		if(StringUtils.isNotEmpty(dto.getForwardJsp())){
			return new ActionForward(dto.getForwardJsp());
		} else {
			return mapping.findForward("DISP");
		}
	}

}