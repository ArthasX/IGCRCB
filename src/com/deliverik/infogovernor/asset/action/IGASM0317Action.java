package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.bl.IGASM03BL;
import com.deliverik.infogovernor.asset.dto.IGASM03DTO;
import com.deliverik.infogovernor.asset.form.IGASM0317Form;
import com.deliverik.infogovernor.asset.vo.IGASM03171VO;

/**
 * �豸�������༭����Action����
 *
 * @author
 */
public class IGASM0317Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0317Action.class);
	
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
		IGASM0317Form form = (IGASM0317Form)actionForm;
		
		//BLȡ��
		IGASM03BL ctlBL = (IGASM03BL) getBean("igasm03BL");
		
		//DTO����
		IGASM03DTO dto = new IGASM03DTO();
		
		//������ת�趨
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//�豸�������Ǽǻ��������ʾ����
			log.debug("========�豸�������Ǽǻ��������ʾ����ʼ========");
			form.setAddcount("");
			String maxcount = ResourceUtility.getString("MAXCOUNT");//�豸�������ÿ��������������
			form.setMaxcount(maxcount);
			form.setPareiid(req.getParameter("pareiid"));
			dto.setIgasm0317Form(form);
			dto = ctlBL.initIGASM0317Action(dto);
			addMessage(req, new ActionMessage("IGCO10000.I001","��������豸������Ϣ"));
			log.debug("========�豸�������Ǽǻ��������ʾ��������========");
			saveToken(req);
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//�豸�Ǽǻ�������ʾ����
			log.debug("========�豸�Ǽǻ�������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�豸�Ǽǻ�������ʾ��������========");
			saveToken(req);
			return mapping.findForward("DISP");
		}	
		if("DISP_BACK".equals(mapping.getParameter())){
			//�豸�������Ǽǻ��������ʾ����
			log.debug("========�豸�������Ǽǻ��������ʾ����ʼ========");
			//req.setAttribute("IGASM0317Form", req.getSession().getAttribute("IGASM0317Form"));
			addMessage(req, new ActionMessage("IGCO10000.I001","��������豸������Ϣ"));
			log.debug("========�豸�������Ǽǻ��������ʾ��������========");
			saveToken(req);
			return mapping.findForward("DISP");
		}
		
		if( "DISP_INSERT".equals(mapping.getParameter())){
			//�豸�������Ǽǻ��������ʾ����
			log.debug("========�豸�������Ǽǻ��������ʾ����ʼ========");
			
//			if(form == null){
//				form = (IGASM0317Form)req.getSession().getAttribute("IGASM0317Form");
//			}
			
			String[] eilabels = new String[Integer.valueOf(form.getAddcount())];
			String[] einames = new String[Integer.valueOf(form.getAddcount())];
			String[] ids = new String[Integer.valueOf(form.getAddcount())];
			String[] ids_default = new String[Integer.valueOf(form.getAddcount())];
			String[] serials = new String[Integer.valueOf(form.getAddcount())];

			for(int i=0,j=ids.length;i<j;i++){
				ids[i] = String.valueOf(i); 
				ids_default[i] = String.valueOf(i);
				eilabels[i] = "";
				einames[i] = form.getEiname();
				//serials[i] = String.valueOf(i);
			}
			form.setEilabels(eilabels);
			form.setEinames(einames);
			form.setIds(ids);
			form.setIds_default(ids_default);
			form.setSerials(serials);
			//dto.setIgasm0317Form(form);
			//dto = ctlBL.initIGASM0317Action(dto);
			//req.getSession().setAttribute("IGASM0317Form", form);
			addMessage(req, new ActionMessage("IGCO10000.I001","��������豸������Ϣ"));
			log.debug("========�豸�������Ǽǻ��������ʾ��������========");
			saveToken(req);
			return mapping.findForward("DISP");
		}
		
		if( "INSERT".equals(mapping.getParameter())){
			//�豸�������༭����
				//�豸�������ǼǴ���
				log.debug("========�豸�������ǼǴ���ʼ========");

				User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
				form.setEiuserid(user.getUserid());
				
				form.setEiusername(user.getUsername());
				
				//DTO��������趨
				dto.setIgasm0317Form(form);
				
				if (isTokenValid(req, true)){
					//�豸��Ϣ�Ǽ��߼�����
					dto = ctlBL.insertBatchEntityItemAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				IGASM03171VO vo = new IGASM03171VO();
				vo.setRelationList(dto.getRelationList());
				super.<IGASM03171VO>setVO(req, vo);
				form.setType("batch");
				req.setAttribute("IGASM0317Form", form);// �������
				log.debug("========�豸�������ǼǴ�������========");
				
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
