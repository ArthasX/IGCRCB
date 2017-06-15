/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
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
import com.deliverik.framework.workflow.prd.bl.task.IG413BL;
import com.deliverik.framework.workflow.prd.model.IG413Info;
import com.deliverik.infogovernor.prd.bl.IGPRD01BL;
import com.deliverik.infogovernor.prd.dto.IGPRD01DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0126Form;
import com.deliverik.infogovernor.prd.vo.IGPRD01062VO;

/**
 * ������ѯAction����
 *
 * @author liupeng@deliverik.com
 */
public class IGPRD0126Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRD0126Action.class);

	/**
	 * ������ѯ����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGPRD0126Form form = (IGPRD0126Form)actionForm;
		
		//BLȡ��
		IGPRD01BL ctlBL = (IGPRD01BL) getBean("igPRD01BL");
		
		//DTO����
		IGPRD01DTO dto = new IGPRD01DTO();
		
		//ǰ������Ӳ�ѯ���������ʾ����		
		log.debug("========ǰ�����������ʾ����ʼ========");		
		dto.setIgPRD0126Form(form);
	
		if ("Disp".equals(mapping.getParameter())) {		 
					
			//��������Ϣ��������趨��VO��
			dto = ctlBL.searchPreProcessEventDefAction(dto);			
			req.setAttribute("pdid", form.getPdid());
			req.setAttribute("psdid", form.getPsdid());	
			req.setAttribute("form", form);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			saveToken(req);
			log.debug("========ǰ�����������ʾ��������========");
		 }else if ("List".equals(mapping.getParameter())) {
		  		
				//��������Ϣ��������趨��VO��
				dto = ctlBL.searchPreProcessEventDefAction(dto);		
				IGPRD01062VO vo = new IGPRD01062VO(dto.getProcessEventDefList());
			
				super.<IGPRD01062VO>setVO(req, vo);
				req.setAttribute("pdid", form.getPdid());
				req.setAttribute("psdid", form.getPsdid());	
				req.setAttribute("form", form);
				addMessage(req, new ActionMessage("IGCO10000.I003"));
				log.debug("========ǰ�����������ʾ��������========");
		  }
		 else if ("Insert".equals(mapping.getParameter())) {
			 
			 if(form.getMode().equals("1")){
				 dto = ctlBL.updatePreProcessEventDefAction(dto); 
			 }
			 else{
				 if (isTokenValid(req, true)){
					//����BL����
					dto = ctlBL.insertPreProcessEventDefAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			 }	
			//��������Ϣ��������趨��VO��
			dto = ctlBL.searchPreProcessEventDefAction(dto);
			
			IGPRD01062VO vo = new IGPRD01062VO(dto.getProcessEventDefList());
			
			req.setAttribute("pdid", form.getPdid());
			req.setAttribute("psdid", form.getPsdid());
			req.setAttribute("form", form);
			super.<IGPRD01062VO>setVO(req, vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========ǰ�����������ʾ��������========");
		 }else if ("Update".equals(mapping.getParameter())) {
			  
			//	dto = ctlBL.updatePreProcessEventDefAction(dto);
			IG413BL bl = (IG413BL)getBean("ig413BL");
		    IG413Info processEventDef= bl.searchIG413InfoByKey(form.getPedid());
			form.setPedid(processEventDef.getPedid());
			form.setPdid(processEventDef.getPdid());
			form.setPsdid(processEventDef.getPsdid());
			form.setPedactionid(processEventDef.getPedactionid());
			form.setPedec(processEventDef.getPedec());
			form.setPedorder(processEventDef.getPedorder());
			form.setPedtype(processEventDef.getPedtype());
			form.setPedblid(processEventDef.getPedblid());
			form.setMode("1");
				//��������Ϣ��������趨��VO��				
			IGPRD01062VO vo = new IGPRD01062VO(dto.getProcessEventDefList());
			req.setAttribute("pdid", form.getPdid());
			req.setAttribute("psdid", form.getPsdid());
			req.setAttribute("form", form);	
			super.<IGPRD01062VO>setVO(req, vo);
				
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========ǰ�����������ʾ��������========");
		}else if ("Delete".equals(mapping.getParameter())) {
			  
			dto = ctlBL.deletePreProcessEventDefAction(dto);
				
			//��������Ϣ��������趨��VO��				
			IGPRD01062VO vo = new IGPRD01062VO(dto.getProcessEventDefList());

			super.<IGPRD01062VO>setVO(req, vo);
			req.setAttribute("pdid", form.getPdid());
			req.setAttribute("psdid", form.getPsdid());
			req.setAttribute("form", form);	
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========ǰ�����������ʾ��������========");
	  }
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		if(StringUtils.isNotEmpty(form.getViewhistory()) && "1".equalsIgnoreCase(form.getViewhistory())){
			//��ʷ�汾�µĲ鿴
			return mapping.findForward("VIEWHISTORY");
		}
		return mapping.findForward("DISP");
	}
}
