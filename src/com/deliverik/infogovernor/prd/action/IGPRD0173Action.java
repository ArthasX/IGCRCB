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
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0173Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01731VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �Զ������̱�����Ԥ��Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRD0173Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGPRD0173Action.class);
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		//ʵ����dto
		IGPRD01DTO dto = new IGPRD01DTO();
		//formȡ��
		IGPRD0173Form form = (IGPRD0173Form) actionForm;
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("===========�Զ������̱�����Ԥ��������ʼ===========");
			//dto�����趨
			dto.setIgprd0173Form(form);
			//����BL��ѯ�������
			dto = ctlBL.searchColumnInfoAction(dto);
			//ʵ����vo
			IGPRD01731VO vo = new IGPRD01731VO();
			vo.setPidInfo(dto.getPidInfo());
			super.<IGPRD01731VO>setVO(request, vo);
			request.getSession().setAttribute("AD_columnInfoMap", dto.getColumnInfoMap());
			log.debug("===========�Զ������̱�����Ԥ����������===========");
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
