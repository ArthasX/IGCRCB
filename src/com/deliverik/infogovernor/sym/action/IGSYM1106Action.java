/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.action;

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
import com.deliverik.infogovernor.sym.bl.IGSYM11BL;
import com.deliverik.infogovernor.sym.dto.IGSYM11DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1106Form;
import com.deliverik.infogovernor.sym.vo.IGSYM11061VO;
import com.deliverik.infogovernor.sym.vo.IGSYM11062VO;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��������_������ϸ��Ϣ����Action����
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public class IGSYM1106Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSYM1106Action.class);

	/**
	 * ������ϸ��Ϣ����Action����
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
		IGSYM1106Form form = (IGSYM1106Form)actionForm;
		
		
		//BLȡ��
		IGSYM11BL ctlBL = (IGSYM11BL) getBean("igsym11BL");
		
		//DTO����
		IGSYM11DTO dto = new IGSYM11DTO();
		
		String forward = "DISP";

		if( "DISP".equals(mapping.getParameter())){
			if("1".equals(req.getParameter("back"))){
				if(!"1".equals(form.getClevel())){
					form.setCcid(form.getPccid());
				}
				form.setCid(form.getPcid());
			}else if("2".equals(req.getParameter("back"))){
				form.setClevel("1");
			}else if("3".equals(req.getParameter("back"))){
				if(!"1".equals(form.getClevel())){
					form.setCid(form.getPcid());
				}
			}
			//������ϸ��Ϣ��ѯ���������ʾ����
			log.debug("========������ϸ��Ϣ��ѯ���������ʾ����ʼ========");
			
			//DTO��������趨
			dto.setIgsym1106Form(form);
			
			//������ϸ��Ϣ���������ʾ�����߼�����
			dto = ctlBL.initIGSYM1106Action(dto);
			
			//��������ϸ��Ϣ��������趨��VO��
			IGSYM11061VO vo = new IGSYM11061VO(dto.getCodeCategoryInfo(),
					dto.getCodeDetailList(),dto.getCodeDetail());
			
			super.<IGSYM11061VO>setVO(req.getSession(), vo);
			
			super.<IGSYM11062VO>setVO(req.getSession(),  new IGSYM11062VO(dto.getCodeCategoryInfo(),
					dto.getCodeDetail()));

			log.debug("========������ϸ��Ϣ���������ʾ��������========");
		}
		
		if ("DELETE".equals(mapping.getParameter())){
			//������ϸɾ������
			log.debug("========������ϸɾ������ʼ========");
			//DTO��������趨
			dto.setIgsym1106Form(form);
			
			//��������ɾ�������߼�����
			ctlBL.deleteCodeDetailAction(dto);
			
			form.setCid(null);
			
			log.debug("========������ϸɾ����������========");
		}
		
		if ("BACK".equals(mapping.getParameter())){
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				
				if("1".equals(form.getClevel())){
					//���ش���
					forward = "BACK1";
				}else{
					
					//DTO��������趨
					dto.setIgsym1106Form(form);
					
					//������ϸ��Ϣ���������ʾ�����߼�����
					dto = ctlBL.initIGSYM1106BackAction(dto);
					
					//��������ϸ��Ϣ��������趨��VO��
					IGSYM11061VO vo = new IGSYM11061VO(dto.getCodeCategoryInfo(),
							dto.getCodeDetailList(),dto.getCodeDetail());
					
					super.<IGSYM11061VO>setVO(req, vo);
					
					super.<IGSYM11062VO>setVO(req.getSession(),  new IGSYM11062VO(dto.getCodeCategoryInfo(),
							dto.getCodeDetail()));
					//���ش���
					forward = "BACK";
				}
			}

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
