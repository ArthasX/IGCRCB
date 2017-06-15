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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM04BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM04DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0402Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM04021VO;

/**
 * ���ͻ�����Ϣ�༭����Action����
 *
 */
public class IGCIM0402Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0402Action.class);

	/**
	 * �¼�����
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
		IGCIM0402Form form = (IGCIM0402Form)actionForm;
		
		//BLȡ��
		IGCIM04BL ctlBL = (IGCIM04BL) getBean("igcim04BL");
		
		//DTO����
		IGCIM04DTO dto = new IGCIM04DTO();
		
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//���͵Ǽǻ��������ʾ����
			log.debug("========���͵Ǽǻ��������ʾ����ʼ========");
			req.setAttribute("IGCIM0402Form", new IGCIM0402Form());
			
			//�ʲ������ѯ����
			dto = ctlBL.searchEntityTypesNums(dto);
			IGCIM04021VO vo = new IGCIM04021VO();
			//�ʲ������
			vo.setTypes1(dto.getTypes1());
			//�ʲ�С����
			vo.setTypes2(dto.getTypes2());
			super.<IGCIM04021VO>setVO(req.getSession(), vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","ģ�ͻ�����Ϣ"));
			log.debug("========���͵Ǽǻ��������ʾ��������========");
			saveToken(req);
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//���͵Ǽǻ�������ʾ����
			log.debug("========���͵Ǽǻ�������ʾ����ʼ========");
			
			dto.setIgcim0402Form(form);
			saveToken(req);
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���͵Ǽǻ�������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//���ͱ༭����
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//���͵Ǽǻ��水�·��ذ�ťʱ�ķ��ش���
				if (form.getMode().equals("1")){
					//�������Ͳ�ѯ����
					return mapping.findForward("BACK");
				}
			}
			
			if (form.getMode().equals("0")){
				//���͵ǼǴ���
				log.debug("========���͵ǼǴ���ʼ========");
				
				//DTO��������趨
				dto.setEntity(form);
				dto.setIgcim0402Form(form);
				
				if (isTokenValid(req, true)){
				//������Ϣ�Ǽ��߼�����
					dto = ctlBL.insertEntityAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				//���Ǽ����˵�������Ϣ�趨��VO��
				IGCIM04021VO vo = new IGCIM04021VO(dto.getEntity());
				
				super.<IGCIM04021VO>setVO(req.getSession(), vo);
				
				log.debug("========���͵ǼǴ�������========");
				
				forward = "DISP";
				
			} else {
				//���ͱ������
				log.debug("========���ͻ�����Ϣ�������ʼ========");
				
				//DTO��������趨
				dto.setEntity(form);
				dto.setIgcim0402Form(form);
				
				//������Ϣ����߼�����
				dto = ctlBL.updateEntityAction(dto);
				
				log.debug("========���ͻ�����Ϣ�����������========");
				
//				forward = "BACK";
				return null;
			}
		}
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========���ͻ�����Ϣ���������ʾ����ʼ========");
			req.getSession().setAttribute("eid", form.getEidStr());
			dto.setIgcim0402Form(form);
			
			dto = ctlBL.initIGCIM0402Action(dto);
			
			//�ʲ������ѯ����
			dto = ctlBL.searchEntityTypesNums(dto);
			IGCIM04021VO vo = new IGCIM04021VO();
			//�ʲ������
			vo.setTypes1(dto.getTypes1());
			//�ʲ�С����
			vo.setTypes2(dto.getTypes2());
			super.<IGCIM04021VO>setVO(req.getSession(), vo);
			log.debug("========���ͻ�����Ϣ���������ʾ��������========");
			
			forward = "DISP";
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward(forward);
	}
}
