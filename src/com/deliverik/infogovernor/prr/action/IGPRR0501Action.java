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
import com.deliverik.infogovernor.prr.bl.IGPRR05BL;
import com.deliverik.infogovernor.prr.dto.IGPRR05DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0501Form;
import com.deliverik.infogovernor.prr.vo.IGPRR05011VO;

/**
 * ����: �������ѯAction
 * ��������: �������ѯAction
 * ������¼: 2015/02/03
 * �޸ļ�¼: 
 */
public class IGPRR0501Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRR0501Action.class);
	
	/**
	 * �������ѯ����
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGPRR0501Form form = (IGPRR0501Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGPRR05BL ctlBL = (IGPRR05BL) getBean("igPRR05BL");
		IGPRR05DTO dto = new IGPRR05DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========�������ѯ���������ʾ����ʼ========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========�������ѯ���������ʾ��������========");
		}
		
		//������ѯ
		if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			
			log.debug("========�������ѯ����ʼ========");
			
			//��ȡ��ҳBean
			getPaginDTO(request,"IGPRR0501");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGPRR0501Form) request.getSession().getAttribute("IGPRR0501Form");
				if ( form == null ) {
					form = new IGPRR0501Form();
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
						form = (IGPRR0501Form) request.getSession().getAttribute("IGPRR0501Form");
						if (form !=null) {
							form.setFromCount(0);
						}
					  }
			}
			
			//pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("IGPRR0501");
			//�����ʶȡ��
			String orderVal = request.getParameter("orderVal");		
			
			//��ҳʱ���������ʶ
			if(StringUtils.isNotEmpty(orderVal)){
				form.setOrder(orderVal);
			}

			//�趨����ʽ
			if(StringUtils.isNotEmpty(form.getOrder())){
				if(StringUtils.isNotEmpty(orderVal)){
					if(orderVal.equals(form.getOrder())){
						if("DESC".equals(form.getSing())){
							form.setSing("ASC");
						}else{
							form.setSing("DESC");
						}
					}else{
						form.setSing("ASC");
					}
				}
			}
			
			dto.setIg483SearchCond(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchGroupAction(dto);
			//����VO
			IGPRR05011VO vo = new IGPRR05011VO();
			vo.setLst_IG483Info(dto.getLst_IG483Info());
			super.<IGPRR05011VO>setVO(request, vo);
			log.debug("========�������ѯ��������========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
