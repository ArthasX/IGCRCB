package com.deliverik.infogovernor.drm.action;

import java.util.Date;
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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.drm.bl.IGDRM21BL;
import com.deliverik.infogovernor.drm.dto.IGDRM21DTO;
import com.deliverik.infogovernor.drm.form.IGDRM2101Form;
import com.deliverik.infogovernor.drm.vo.IGDRM21011VO;
import com.deliverik.infogovernor.drm.vo.IGDRM21012VO;

/**
 * Ԥ���Ǽ�Action
 *
 * @author
 */
public class IGDRM2101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM2101Action.class);

	/**
	 * Ԥ���Ǽ�
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
		IGDRM2101Form form = (IGDRM2101Form)actionForm;
		
		//BLȡ��
		IGDRM21BL ctlBL = (IGDRM21BL) getBean("igdrm21BL");
		
		//DTO����
		IGDRM21DTO dto = new IGDRM21DTO();
		
		//������ת�趨
		String forward = "DISP";

		if( "DISP".equals(mapping.getParameter())){
			//�豸�Ǽǻ��������ʾ����
			log.debug("========�豸�Ǽǻ��������ʾ����ʼ========");
			form = new IGDRM2101Form();
			
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			
			form.setEiinsdate(date);

			dto.setForm(form);
			
			dto = ctlBL.searchEntityItemLableAction(dto);
			req.setAttribute("IGDRM2101Form", form);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","�豸������Ϣ"));
			log.debug("========�豸�Ǽǻ��������ʾ��������========");
			return mapping.findForward("DISP");
		} 

		if( "INSERT".equals(mapping.getParameter())){
			//�豸�༭����
			if (form.getMode().equals("0")){
				//�豸�ǼǴ���
				log.debug("========�豸�ǼǴ���ʼ========");
				
				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
				form.setEiuserid(user.getUserid());
				
				form.setEiusername(user.getUsername());
				
				//DTO��������趨
				dto.setForm(form);
				
				//�豸��Ϣ�Ǽ��߼�����
				dto = ctlBL.insertEntityItemAction(dto);
				
				//���Ǽ����˵��豸��Ϣ�趨��VO��
				IGDRM21011VO vo = new IGDRM21011VO();
				
				super.<IGDRM21011VO>setVO(req.getSession(), vo);
				
				req.setAttribute("btn1Val", "���Ԥ����Ϣ");
				req.setAttribute("btn1Url", "IGDRM2102_Disp.do?eiid="+form.getEiidStr()+"&eid="+form.getEid());
				req.setAttribute("btn2Val", "����");
				req.setAttribute("btn2Url", "IGDRM2101_Disp.do");
				
				log.debug("========�豸�ǼǴ�������========");
				
				forward = "DISP";

			}
			if(form.getMode().equals("1")){
				log.debug("========�豸���´���ʼ========");
				dto.setForm(form);
				dto = ctlBL.updateEntityItemAction(dto);
				log.debug("========�豸���´�������========");
				
				forward = "BACK";
			}
		}
		//ҵ��ϵͳѡ���ʼ��
		if("BSINIT".equals(mapping.getParameter())){
			
			getPaginDTO(req,"IGDRM0401");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM0301");
			if (req.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			//DTO��������趨
			dto.setForm(form);
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//�ʲ������߼�����
			dto = ctlBL.searchEntityDisp(dto);
			
			//���ʲ���Ϣ��������趨��VO��
			IGDRM21011VO vo = new IGDRM21011VO();
			vo.setEntityVWItemList(dto.getEntityItemVWInfoList());
			super.<IGDRM21011VO>setVO(req, vo);
			forward = "DISP";
		}
		
		// ��ʼ��ҳ��
		if("EDIT".equals(mapping.getParameter())){
			dto.setForm(form);
			dto = ctlBL.initSoc0118EditInfo(dto);
			IGDRM21012VO vo = new IGDRM21012VO(dto);
			super.<IGDRM21012VO>setVO(req, vo);
			form.setMode("1");
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
