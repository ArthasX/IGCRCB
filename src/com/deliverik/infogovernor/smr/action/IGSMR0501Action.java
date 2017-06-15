/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.action;

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
import com.deliverik.infogovernor.smr.bl.IGSMR05BL;
import com.deliverik.infogovernor.smr.dto.IGSMR05DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0501Form;
import com.deliverik.infogovernor.smr.vo.IGSMR05011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ʷ���ݷ�����Ϣform
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGSMR0501Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGSMR0501Action.class);
		//BLȡ��
		IGSMR05BL ctlBL = (IGSMR05BL) getBean("igSMR05BL");
		//ʵ����dto
		IGSMR05DTO dto = new IGSMR05DTO();
		//formȡ��
		IGSMR0501Form form = (IGSMR0501Form) actionForm;
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("===========������Ϣȡ��ҳ���ʼ��������ʼ===========");
			dto.setIgsmr0501Form(form);
			dto = ctlBL.searchRegulatoryHistoryListAction(dto);
			IGSMR05011VO vo = new IGSMR05011VO();
			vo.setReportHistoryVWInfoList(dto.getReportHistoryVWInfoList());
			super.<IGSMR05011VO>setVO(request, vo);
			log.debug("===========������Ϣȡ��ҳ���ʼ����������===========");
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
