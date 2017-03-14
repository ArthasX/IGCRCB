/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
import com.deliverik.infogovernor.prd.bl.IGPRD10BL;
import com.deliverik.infogovernor.prd.dto.IGPRD10DTO;
import com.deliverik.infogovernor.prd.form.IGPRD1001Form;
import com.deliverik.infogovernor.prd.vo.IGPRD10011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̶����ѯAction
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRD1001Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGPRD1001Action.class);
		//BLȡ��
		IGPRD10BL ctlBL = (IGPRD10BL) getBean("igprd10BL");
		//formȡ��
		IGPRD1001Form form = (IGPRD1001Form) actionForm;
		//ʵ����dto
		IGPRD10DTO dto = new IGPRD10DTO();
		//dto�����趨
		dto.setForm(actionForm);
		//���̶����ѯ����
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("===============���̶����ѯ������ʼ=================");
			if(form.getPtid() == null || form.getPtid() == 0){
				form.setPtid(IGPRDCONSTANTS.PROCESS_DEFINITION_COMMON_TEMPLATE_ID);
			}
			//��ҳ��DTOȡ��
			getPaginDTO(request,"IGPRD1001");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGPRD1001Form) request.getSession().getAttribute("IGPRD1001Form");
				if ( form == null ) {
					form = new IGPRD1001Form();
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
					form = (IGPRD1001Form) request.getSession().getAttribute("IGPRD1001Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGPRD0101");
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//���̶�����Ϣ�����߼�����
			dto = ctlBL.searchLastProcessDefinitionAction(dto);
			//ʵ����vo
			IGPRD10011VO vo = new IGPRD10011VO();
			vo.setProcessDefinitionList(dto.getProcessDefinitionList());
			super.setVO(request, vo);
			log.debug("===============���̶����ѯ��������=================");
		}
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
