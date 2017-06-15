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
import com.deliverik.infogovernor.prd.bl.IGPRD02BL;
import com.deliverik.infogovernor.prd.dto.IGPRD02DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0202Form;
import com.deliverik.infogovernor.prd.vo.IGPRD02021VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̶��������ʾAction
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRD0202Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGPRD0202Action.class);
		//BLȡ��
		IGPRD02BL ctlBL = (IGPRD02BL) getBean("igprd02BL");
		//ʵ����dto
		IGPRD02DTO dto = new IGPRD02DTO();
		//formȡ��
		IGPRD0202Form form = (IGPRD0202Form) actionForm;
		//dto�����趨
		dto.setPdid(form.getPdid());
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("===============���̼�����ʾ������ʼ===============");
			dto = ctlBL.initProccessDefinitionInfoAction(dto);
			
			//ʵ����vo
			IGPRD02021VO vo = new IGPRD02021VO();
			vo.setFlowChartHeight(dto.getFlowChartHeight());
			vo.setFlowChartXML(dto.getFlowChartXML());
			vo.setVoList(dto.getVoList());
			super.<IGPRD02021VO>setVO(request, vo);
			log.debug("===============���̼�����ʾ��������===============");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}