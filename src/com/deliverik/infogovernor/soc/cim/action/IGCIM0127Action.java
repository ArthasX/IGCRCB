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
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0127Form;

/**
 * Ӧ�ù�ϵ�༭����Action����
 *
 * @author
 */
public class IGCIM0127Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0127Action.class);

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
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGCIM0127Form form = (IGCIM0127Form)actionForm;
		
		//BLȡ��
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		
		//DTO����
		IGCIM01DTO dto = new IGCIM01DTO();
		dto.setLocale(this.getLocale(req));
		dto = ctlBL.searchRelationListActionApp(dto);
		//���ӹ�������
		List<LabelValueBean> ADrelationList=dto.getRelationList();
		if(ADrelationList!=null&&ADrelationList.size()>0){
			if(form!=null){
				String eid=form.getPareid();
				
				StringBuffer flag= new StringBuffer();
				if("CM03010001".equals(eid)){
					flag.append("CR030100010010#003-003,");
					flag.append("CR010100010019#001-003,");
					flag.append("CR010100010024#001-002,");
					flag.append("CR030100050001#003-002,");
					flag.append("CR010100450001#001-003");
					flag.append("CR010100450002#001-003");
					flag.append("CR010100460001#001-003");
					flag.append("CR010100460002#001-003");
					flag.append("CR010100470001#001-003");
					
				}
				if("133".equals(eid)){
					//flag="242#003-001";
					flag.append("");
				}
				for (int i = 0; i < ADrelationList.size(); i++) {
					LabelValueBean lvb=ADrelationList.get(i);
					if(lvb.getValue()!=null&&!"".equals(lvb.getValue())){
						if(flag.toString().contains(lvb.getValue())){
							ADrelationList.remove(lvb);
							i=i-1;
						}
					}
				}
			}
		}
		req.getSession().setAttribute("ADrelationList", ADrelationList);
		
		//������ת�趨
		String forward = null;
		//
		if( "DISP".equals(mapping.getParameter())){
			//Ӧ�ù�ϵ�Ǽǻ��������ʾ����
			log.debug("========Ӧ�ù�ϵ�Ǽǻ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I001","Ӧ�ù�ϵ��Ϣ"));
			
			req.getSession().setAttribute("IGCIM0127Form", form);
			
			log.debug("========Ӧ�ù�ϵ�Ǽǻ��������ʾ��������========");
			
			saveToken(req);
			
			forward = "DISP";
		}

		if( "EDIT".equals(mapping.getParameter())){
			//Ӧ�ù�ϵ�༭����
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)) {
				//���·��ذ�ťʱ�ķ��ش���
				return mapping.findForward("BACK");
			}
			
			if (form.getMode().equals("0")){
				//�����ϵ�ǼǴ���
				log.debug("========Ӧ�ù�ϵ�ǼǴ���ʼ========");
				
				//DTO��������趨
				dto.setIgasm0807Form(form);
				if (isTokenValid(req, true)){
					//Ӧ�ù�ϵ�Ǽ��߼�����
					dto = ctlBL.insertEntityItemRelationActionApp(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				log.debug("========Ӧ�ù�ϵ�ǼǴ�������========");
				forward = "BACK";

			} else {
				//Ӧ�ù�ϵ�������
				log.debug("========Ӧ�ù�ϵ�������ʼ========");

				//DTO��������趨
				dto.setIgasm0807Form(form);
				
				//Ӧ�ù�ϵ����߼�����
				dto = ctlBL.updateEntityItemRelationActionApp(dto);
				
				log.debug("========Ӧ�ù�ϵ�����������========");
				forward = "BACK";
			}
		}
		
		if ("EDIT_DISP".equals(mapping.getParameter())){
			//Ӧ�ù�ϵ������������ʾ����
			log.debug("========Ӧ�ù�ϵ���������ʾ����ʼ========");
			
			//DTO��������趨
			dto.setIgasm0807Form(form);
			
			//Ӧ�ù�ϵ������������ʾ�߼�����
			dto = ctlBL.initIGCIM0127Action(dto);
			
			log.debug("========Ӧ�ù�ϵ���������ʾ��������========");

			saveToken(req);
			
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
