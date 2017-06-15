package com.deliverik.infogovernor.soc.cim.action;

import java.io.File;
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
import com.deliverik.infogovernor.asset.bl.IGASM03BL;
import com.deliverik.infogovernor.asset.dto.IGASM03DTO;
import com.deliverik.infogovernor.asset.form.IGASM0341Form;
import com.deliverik.infogovernor.asset.vo.IGASM03011VO;
import com.deliverik.infogovernor.util.ASMHelper;

/**
 * �豸�����ļ���ʷ�汾�Ƚ�Action IGCIM0142Action
 *
 */
public class IGCIM0142Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0121Action.class);

	/**
	 * �Ƚϴ���
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGASM0341Form form = (IGASM0341Form)actionForm;
		
		//BLȡ��
		IGASM03BL ctlBL = (IGASM03BL) getBean("igasm03BL");
		
		//DTO����
		IGASM03DTO dto = new IGASM03DTO();
		
		dto.setFilepath(ASMHelper.XML_FILE_PATH+form.getEiid()+File.separator+"config-view.xml_"+form.getPre());
		dto.setOtherfilepath(ASMHelper.XML_FILE_PATH+form.getEiid()+File.separator+"config-view.xml_"+form.getNext());
		if ("DISP".equals(mapping.getParameter())){
			//�豸�޸Ĵ�����ʾ
			log.debug("========�豸�޸Ĵ�����ʾ��ʼ========");
			dto.setIgasm0341Form(form);
			dto = ctlBL.compareXMLInfoByVersion(dto);
			
			IGASM03011VO vo = new IGASM03011VO();
//			vo.setMap1(dto.getMap1());
//			vo.setMap2(dto.getMap2());
			vo.setSection_list(dto.getSection_list());
			vo.setCommand_list1(dto.getCommand_list1());
			vo.setCommand_list2(dto.getCommand_list2());
			vo.setOutput_list1(dto.getOutput_list1());
			vo.setOutput_list2(dto.getOutput_list2());
			vo.setCommand_color_list(dto.getCommand_color_list());
			vo.setOutput_color_list(dto.getOutput_color_list());
			
			super.<IGASM03011VO>setVO(req, vo);
			
			log.debug("========�豸�޸Ĵ�����ʾ����========");
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
