/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.action;

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
import com.deliverik.infogovernor.smr.bl.IGSMR08BL;
import com.deliverik.infogovernor.smr.dto.IGSMR08DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0803Form;
import com.deliverik.infogovernor.smr.vo.IGSMR08031VO;


/**
 * ����:��ر�����ϸҳ ��ѯaction
 * ������������ر�����ϸҳ ��ѯaction
 * �����ˣ��
 * ������¼�� 2013/09/04
 * �޸ļ�¼��
 */
public class IGSMR0803Action extends BaseAction{
	
	/**��־����ȡ��*/
	static Log log = LogFactory.getLog(IGSMR0803Action.class);
	
	/**
	 * ��ر�����ϸҳ  ��ѯ
	 * 
	 * */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//controlBLȡ��
		IGSMR08BL ctlBL = (IGSMR08BL) getBean("igSMR08BL");
		
		//ʵ����dto
		IGSMR08DTO dto = new IGSMR08DTO();
		
		//����ѯ��formȡ��
		IGSMR0803Form form = (IGSMR0803Form) actionForm;
		
		/*ҳ���ʼ��*/
		if("DISP".equals(mapping.getParameter())){
			log.debug("==================ҳ���ʼ��������ʼ=====================");
			
			log.debug("==================ҳ���ʼ����������=====================");
		}
		
		/*��ѯ����*/
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("==================��ѯ������ʼ=====================");
			
			//��form�е����ݷ�װ��dto
			dto.setIgsmr0803Form(form);
			
			//����controlBL��ѯ(�Ѳ�ѯ���������ٴη�װ��dto��)
			dto = ctlBL.searchListForDetailAction(dto);
			
			//vo�����趨
			IGSMR08031VO vo = new IGSMR08031VO();
			
			//��ѯ��Ϣ���Ϸ�װ��vo��
			vo.setDetailMap(dto.getDetailMap());
			
			//�жϸ�����Ա�������ѯ����
			if(StringUtils.isNotEmpty(form.getUserid())){
				//��Ա��ѯ
				vo.setFlag("2");
			}else{
				//������ѯ
				vo.setFlag("1");
			}
			
			//��vo����request�д���JSP��   
			super.<IGSMR08031VO>setVO(request, vo);
			
			log.debug("==================��ѯ��������=====================");
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

