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
import com.deliverik.infogovernor.soc.alarm.bl.IGALM01BL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM01DTO;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0102Form;
import com.deliverik.infogovernor.soc.alarm.vo.IGALM01021VO;

/**
 * Server Xml�ϴ���ʷ��ѯ����
 * @author Xudong Wang 
 * 2013.07.31
 */
public class IGALM0102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGALM0102Action.class);

	/**
	 * Server Xml�ϴ���ʷ��ѯ����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGALM0102Form form = (IGALM0102Form)actionForm;
		
		//BLȡ��
		IGALM01BL ctlBL = (IGALM01BL) getBean("igalm01BL");
		//DTO����
		IGALM01DTO dto = new IGALM01DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========Server Xml�ϴ���ʷ��ѯ���������ʾ����ʼ========");
			log.debug("========Server Xml�ϴ���ʷ��ѯ���������ʾ��������========");
		}
		//Server Xml�ϴ���ʷ��ѯ
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========Server Xml�ϴ���ʷ��ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				form = (IGALM0102Form) request.getSession().getAttribute("IGALM0102Form");
			}
			//��ȡ��ҳBean���������ݵ�dto��
			getPaginDTO(request,"IGALM0102");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			//�ж��Ƿ�����ϸ���棬�༭���淵�ز�ѯ����
			if ( "SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGALM0102Form) request.getSession().getAttribute("IGALM0102Form");
				if ( form== null){
					form = new IGALM0102Form();
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
					form = (IGALM0102Form) request.getSession().getAttribute("IGALM0102Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼�����ֵ
			int maxCnt = getMaxDataCount("IGALM0102");
			//������������
			dto.setCrm05SearchCond(form);
			//��ѯ������¼������
			dto.setMaxSearchCount(maxCnt);
			//��ҳBean����
			pDto.setPageDispCount(12);
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchALM0102Action(dto);
			//����VO
			IGALM01021VO vo = new IGALM01021VO();
			vo.setIgalm0102List(dto.getIgalm0102List());
			super.<IGALM01021VO>setVO(request, vo);
			log.debug("========Server Xml�ϴ���ʷ��ѯ��������========");
		}
		if("IMPORT".equals(mapping.getParameter())){
			log.debug("========����ָ��ģ���ϴ�����ʼ========");
			dto.setIgalm0102Form(form);
			dto = ctlBL.importPerfTemplateAction(dto);
			log.debug("========����ָ��ģ���ϴ���������========");
		} 
		
		if("DELETE".equals(mapping.getParameter())){
			log.debug("========����ָ��ģ��ɾ����ʼ========");
			dto.setIgalm0102Form(form);
			dto = ctlBL.deleteALM0102Action(dto);
			log.debug("========����ָ��ģ��ɾ������========");
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
