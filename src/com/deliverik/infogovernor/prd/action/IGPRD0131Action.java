/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.action;

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
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0131Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01311VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ������Χѡ��action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRD0131Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGPRD0131Action.class);
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		//ʵ����dto
		IGPRD01DTO dto = new IGPRD01DTO();
		//formȡ��
		IGPRD0131Form form = (IGPRD0131Form) actionForm;
		dto.setPdid(form.getPdid());
		String forward = "DISP";
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("=============���̻�����Χѡ��ҳ���ʼ��������ʼ==============");
			//ҳ����Ϣ�趨
			dto.setIgprd0131Form(form);
			//����BL��ѯ
			dto = ctlBL.getProcessOrgDefAction(dto);
			//��ѯ�����Ƿ�ռ��
			dto = ctlBL.isProcessDefinitionInUse(dto);
			saveToken(request);
			request.setAttribute("isInUse", dto.getIsProcessDefinitionInUse());
			//ʵ����vo
			IGPRD01311VO vo = new IGPRD01311VO();
			vo.setOrgTreeMap(dto.getOrgTreeMap());
			vo.setPordList(dto.getPordList());
			super.<IGPRD01311VO>setVO(request, vo);
			if(StringUtils.isNotEmpty(form.getViewhistory())&&"1".equals(form.getViewhistory())){
				forward = "VIEWHISTORY";
			}
			log.debug("=============���̻�����Χѡ��ҳ���ʼ����������==============");
		}
		//����
		if("INSERT".equals(mapping.getParameter())){
			if(isTokenValid(request,true)){
				//ҳ����Ϣ�趨
				dto.setIgprd0131Form(form);
				//ɾ������
				if("0".equals(form.getModel())){
					dto = ctlBL.removeProcessOrg(dto);
				//��������
				}else{
					dto = ctlBL.addProcessOrg(dto);
				}
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		return mapping.findForward(forward);
	}

}
