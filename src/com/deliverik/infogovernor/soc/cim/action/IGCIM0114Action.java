/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0114Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01141VO;

/**
 * ����: �ɼ���ѯ������ϸ�Ա�
 * ��������: �ɼ���ѯ������ϸ�Ա�
 * ������¼: zhangnan 2013-6-6
 * �޸ļ�¼: 
 */
public class IGCIM0114Action extends BaseAction{

	//��־����ȡ��
	Log log = LogFactory.getLog(IGCIM0114Action.class);
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//BLȡ��
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		//ʵ����dto
		IGCIM01DTO dto = new IGCIM01DTO();
		//formȡ��
		IGCIM0114Form form = (IGCIM0114Form) actionForm;
		
		//dto�����趨
		dto.setIgcim0114Form(form);
		//ҳ���ʼ����ʾ����
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("=============����ԭ������ʾҳ���ʼ��������ʼ==============");
			
			//��ҳ��DTOȡ��
			getPaginDTO(request,"IGCIM0114");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			//�������ò�ѯ����
			log.debug("========�������ò�ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGCIM0114Form) request.getSession().getAttribute("IGCIM0114Form");
				if ( form== null){
					form = new IGCIM0114Form();
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
					form = (IGCIM0114Form) request.getSession().getAttribute("IGCIM0114Form");
					if (form !=null) { 
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCIM0114");
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//ȡ�òɼ����
			dto = ctlBL.getCR01InfoListByCommand2(dto);
			log.debug("=============����ԭ������ʾҳ���ʼ����������==============");
		}
		
		//ʵ����vo
		IGCIM01141VO vo = new IGCIM01141VO();
		vo.setCr01List1(dto.getCr01List1());
		vo.setCr01List2(dto.getCr01List2());
		vo.setCollecttime1(dto.getCollecttime1());
		vo.setCollecttime2(dto.getCollecttime2());
		vo.setHost(form.getHost());
		vo.setKeys(form.getKeys());
		super.<IGCIM01141VO>setVO(request, vo);
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
