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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0111Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01111VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����Դ���ݱȽϰ汾action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGCIM0111Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGCIM0111Action.class);
		//blȡ��
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		//dtoʵ����
		IGCIM01DTO dto = new IGCIM01DTO();
		//formȡ��
		IGCIM0111Form form = (IGCIM0111Form) actionForm;
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("==========����Դ���ݱȽϰ汾������ʼ===========");
			//dto�����趨
			dto.setIgcim0111Form(form);
			//����BL��ѯҪ�Ƚϵ������汾��Ϣ
			dto = ctlBL.compareVersionsAction(dto);
			//ʵ����vo
			IGCIM01111VO vo = new IGCIM01111VO(dto.getCompareVersionsMap());
//			vo.setEntityItem(dto.getEntityItem());
			vo.setHost(form.getHost());
			super.<IGCIM01111VO>setVO(request, vo);
			log.debug("==========����Դ���ݱȽϰ汾��������===========");
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
