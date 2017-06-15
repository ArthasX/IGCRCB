/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.action;

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
import com.deliverik.infogovernor.soc.mnt.bl.IGMNT02BL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT02DTO;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0206Form;
import com.deliverik.infogovernor.soc.mnt.vo.IGMNT02061VO;

/**
 * ����: ������־��ѯ����Action����
 * ��������: ������־��ѯ����Action����
 * ������¼: 2011/06/09
 * �޸ļ�¼: 
 */
public class IGMNT0206Action extends BaseAction{
	static Log log=LogFactory.getLog(IGMNT0206Action.class);

	/**
	 * �¼�����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param request 
	 * @param response 
	 * @return 
	 * @throws Exception 
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGMNT0206Form form = (IGMNT0206Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGMNT02BL ctlBL = (IGMNT02BL)getBean("igmnt02BL");
		//ʵ����DTO
		IGMNT02DTO dto=new IGMNT02DTO();
		//���ʻ�����
		dto.setLocale(this.getLocale(request));
		//������־ҳ���ʼ����ʾ
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========������־��ѯ���������ʾ����ʼ========");
			dto = ctlBL.getEiImportProgrammeAction(dto);
			dto = ctlBL.getAlarmSeverity(dto);
			dto = ctlBL.getCiList(dto);
			request.getSession().setAttribute("alarmSeverityList", dto.getAlarmSeverityList());
			request.getSession().setAttribute("ADImpTypeList", dto.getImpTypeList());
			request.getSession().setAttribute("ciList", dto.getCiList());
			saveToken(request);
			log.debug("========������־��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		
		//������־��ѯ
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========������־��ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				form = (IGMNT0206Form) request.getSession().getAttribute("IGMNT0206Form");
			}
			//��ȡ��ҳBean���������ݵ�dto��
			getPaginDTO(request,"IGMNT0206");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			//�ж��Ƿ�����ϸ���棬�༭���淵�ز�ѯ����
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGMNT0206Form) request.getSession().getAttribute("IGMNT0206Form");
				if ( form== null){
					form = new IGMNT0206Form();
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
					form = (IGMNT0206Form) request.getSession().getAttribute("IGMNT0206Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼�����ֵ
			int maxCnt = getMaxDataCount("IGMNT0206");
			//������������
			dto.setSoc0305SearchCond(form);
			//��ѯ������¼������
			dto.setMaxSearchCount(maxCnt);
			//��ҳBean����
			pDto.setPageDispCount(20);
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchSOC0305Action(dto);
			//����VO
			IGMNT02061VO vo = new IGMNT02061VO();
			vo.setSoc0307List(dto.getSoc0307List());
			super.<IGMNT02061VO>setVO(request, vo);
			log.debug("========������־��ѯ��������========");
		}
		//����״̬���
		if("UPDATE".equals(mapping.getParameter())){
			log.debug("========����״̬�����ʼ========");
			dto.setIds(form.getIds());
			ctlBL.updateSOC0305(dto);
			log.debug("========����״̬�������=======");
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
