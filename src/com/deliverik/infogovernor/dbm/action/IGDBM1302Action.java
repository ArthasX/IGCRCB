package com.deliverik.infogovernor.dbm.action;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import com.deliverik.infogovernor.dbm.bl.IGDBM13BL;
import com.deliverik.infogovernor.dbm.dto.IGDBM13DTO;
import com.deliverik.infogovernor.dbm.form.IGDBM1302Form;
import com.deliverik.infogovernor.dbm.model.WorkmanagerInfo;
import com.deliverik.infogovernor.dbm.vo.IGDBM13011VO;

/**
 * ��������Ǽǻ���Action����
 *
 */
public class IGDBM1302Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDBM1302Action.class);

	/**
	 * ��������ǼǴ���
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
		IGDBM1302Form form = (IGDBM1302Form)actionForm;
		
		//BLȡ��
		IGDBM13BL ctlBL = (IGDBM13BL) getBean("igdbm13BL");
		//����
//		AttachmentBL attachmentBL = (AttachmentBL)getBean("attachmentBL");
		//DTO����
		IGDBM13DTO dto = new IGDBM13DTO();
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		dto.setUser(user);
		
		if("DISP".equals(mapping.getParameter())){
			log.debug("========������Ϣ�������������ʾ����ʼ========");
			dto = ctlBL.dispWorkmanagerInfoAction(dto);
			IGDBM13011VO vo = new IGDBM13011VO();
			Map<String, List<WorkmanagerInfo>> map = new LinkedHashMap<String, List<WorkmanagerInfo>>();
			Map<Integer,String> mapType = new LinkedHashMap<Integer,String>();
			
			vo.setWeekList(dto.getWeekList());
			vo.setMonthList(dto.getMonthList());
			vo.setWorkmanagermap(map);
			vo.setMapType(mapType);
			form.setWmusername(user.getUsername());
			form.setWmuserid(user.getUserid());
			super.<IGDBM13011VO>setVO(req, vo);
			form.setWmfrequencymonthlastday(null);
			
			saveToken(req);
			log.debug("========������Ϣ�������������ʾ��������========");
			return mapping.findForward("DISP");
		}else if("INSERT".equals(mapping.getParameter())){
			log.debug("========������Ϣ��������ʼ========");
			dto.setIgdbm1302Form(form);
			dto.setUser(user);
			//����BL����
			if (isTokenValid(req, true)){
				dto = ctlBL.addWorkmanagerInfo(dto);
			}
			log.debug("========������Ϣ������������========");
		}else if("EDIT".equals(mapping.getParameter())){
			log.debug("========������Ϣ�༭����ʼ========");
			dto.setIgdbm1302Form(form);
			dto = ctlBL.editWorkmanagerInfo(dto);
			dto = ctlBL.editWorkmanagerInfoAction(dto);
			IGDBM13011VO vo = new IGDBM13011VO();
			Map<String, List<WorkmanagerInfo>> map = new LinkedHashMap<String, List<WorkmanagerInfo>>();
			Map<Integer,String> mapType = new LinkedHashMap<Integer,String>();
			
			vo.setWeekList(dto.getWeekList());
			vo.setMonthList(dto.getMonthList());
			vo.setWorkmanagermap(map);
			vo.setMapType(mapType);
			form.setWmusername(user.getUsername());
			form.setWmuserid(user.getUserid());
			super.<IGDBM13011VO>setVO(req, vo);
//			form.setWmfrequencymonthlastday(null);
			req.setAttribute("workmanager",dto.getInfo());
			log.debug("========������Ϣ�༭��������========");
		}else if("UPDATE".equals(mapping.getParameter())){
			log.debug("========������Ϣ�༭����ʼ========");
			dto.setIgdbm1302Form(form);
			dto = ctlBL.updateWorkmanager(dto);
			log.debug("========������Ϣ�༭��������========");
		}else if("REMIND".equals(mapping.getParameter())){
			log.debug("========������Ϣ�������Ѵ���ʼ========");
			dto.setIgdbm1302Form(form);
			dto = ctlBL.updateWorkmanagerInfoRemind(dto);
			log.debug("========������Ϣ�������Ѵ�������========");
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
