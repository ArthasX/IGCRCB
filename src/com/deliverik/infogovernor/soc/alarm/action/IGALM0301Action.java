/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.alarm.action;

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
import com.deliverik.infogovernor.soc.alarm.bl.IGALM03BL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM03DTO;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0301Form;
import com.deliverik.infogovernor.soc.alarm.vo.IGALM03011VO;

/**
 * ��ض�������
 * @author wangxing
 * 2013.08.01
 */
public class IGALM0301Action extends BaseAction {

	static Log log = LogFactory.getLog(IGALM0301Action.class);
	

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGALM0301Form form = (IGALM0301Form)actionForm;
		
		//BLȡ��
		IGALM03BL ctlBL = (IGALM03BL) getBean("igalm03BL");
		//DTO����
		IGALM03DTO dto = new IGALM03DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��ض����ѯ���������ʾ����ʼ========");
			log.debug("========��ض����ѯ���������ʾ��������========");
		}
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========��ض�����ͼ��ѯ����ʼ========");
			//��ȡ��ҳBean���������ݵ�dto��
			getPaginDTO(request,"IGALM0102");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			//�ж��Ƿ�����ϸ���棬�༭���淵�ز�ѯ����
			if ( "SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGALM0301Form) request.getSession().getAttribute("IGALM0301Form");
				if ( form== null){
					form = new IGALM0301Form();
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
					form = (IGALM0301Form) request.getSession().getAttribute("IGALM0301Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			String flag =request.getParameter("flag");
			//��ѯ��¼�����ֵ
			int maxCnt = getMaxDataCount("IGALM0102");
			//������������
			dto.setIgalm0301Form(form);
			//��ѯ������¼������
			dto.setMaxSearchCount(maxCnt);
			//��ҳBean����
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchIGALM03Action(dto);
			//����VO
			IGALM03011VO vo = new IGALM03011VO();
			vo.setCrm06InfoList(dto.getCrm06InfoList());
			vo.setFlag(flag);
			super.<IGALM03011VO>setVO(request, vo);
			log.debug("========��ض�����ͼ��ѯ��������========");
		}else if("ChangeStatus".equals(mapping.getParameter())){
			log.debug("========��ض���״̬�޸Ĵ���ʼ========");
			dto.setIgalm0301Form(form);
			dto = ctlBL.changeStatus(dto);
			log.debug("========��ض���״̬�޸Ĵ������========");
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
