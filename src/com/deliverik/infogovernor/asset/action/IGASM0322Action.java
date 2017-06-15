package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.form.IGASM0301Form;
import com.deliverik.infogovernor.asset.vo.IGASM03011VO;
import com.deliverik.infogovernor.util.ASMHelper;

/**
 * ������Ϣ����Action����
 *
 */
public class IGASM0322Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0322Action.class);

	/**
	 * ����
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
		IGASM0301Form form = (IGASM0301Form)actionForm;
		
		//BLȡ��
		IGASM03BL ctlBL = (IGASM03BL) getBean("igasm03BL");
		
		//DTO����
		IGASM03DTO dto = new IGASM03DTO();
		
		dto.setIgASM0301Form(form);
		//dto.setFilepath("F:/SOC/AIX XML Resource/config-view.xml");
		
		dto.setFilepath(ASMHelper.XML_FILE_PATH+form.getEiid()+File.separator+"config-view.xml_"+form.getEiversion()+"."+form.getEismallversion());
		
		if( "DISP".equals(mapping.getParameter())){
			//������Ϣ���������ʾ����
			log.debug("========������Ϣ���������ʾ����ʼ========");
			log.debug("========������Ϣ���������ʾ��������========");
			
		}else if( "PARSE".equals(mapping.getParameter())){
			//������Ϣ�����������
			log.debug("========������Ϣ��������ʼ========");		
			
			dto = ctlBL.initXMLInfo(dto);
			
			IGASM03011VO vo = new IGASM03011VO();
			vo.setTreeNodeMap(dto.getTreeNodeMap());
			super.<IGASM03011VO>setVO(req, vo);
			req.setAttribute("IGASM0301Form", form);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========��������Ϣ������������========");
			
		}else if( "READ".equals(mapping.getParameter())){
			//������Ϣ�����������
			log.debug("========������Ϣ�����Ϣ��ʾ����ʼ========");		
			
			dto = ctlBL.readXMLNodeInfo(dto);

			IGASM03011VO vo = new IGASM03011VO();
			vo.setInfoMap(dto.getInfoMap());
			super.<IGASM03011VO>setVO(req, vo);
			req.setAttribute("IGASM0301Form", form);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========������Ϣ�����Ϣ��ʾ��������========");
			
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
