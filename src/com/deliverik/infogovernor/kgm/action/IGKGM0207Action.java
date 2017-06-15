/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.kgm.bl.IGKGM02BL;
import com.deliverik.infogovernor.kgm.dto.IGKGM03DTO;
import com.deliverik.infogovernor.kgm.form.IGKGM0207Form;
import com.deliverik.infogovernor.kgm.vo.IGKGM02071VO;

/**
 * ����:֪ʶ������Action
 * ����������֪ʶ������Action
 * ������¼��wangxiaoqiang 2010/12/07
 * �޸ļ�¼��
 */
public class IGKGM0207Action extends BaseAction{

	static Log log = LogFactory.getLog(IGKGM0201Action.class);
	
	/**
	 * ֪ʶ�ǼǴ���
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
		IGKGM0207Form form = (IGKGM0207Form)actionForm;
		
		//BLȡ��
		IGKGM02BL ctlBL = (IGKGM02BL) getBean("igkgm02BL");
		
		//DTO����
		IGKGM03DTO dto = new IGKGM03DTO();
		
		

		 if( "INSERT".equals(mapping.getParameter())){
			//֪ʶ��¼����
			log.debug("========֪ʶ���ֵǼǴ���ʼ========");
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			//�趨֪ʶ�����ֵǼ���ID
			form.setKguserid(user.getUserid());
			//��ǰʱ��ȡ��
			Date nowDateTime = new Date();
			//��ǰʱ���ʽ��
			String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
			//��ǰʱ���趨
			form.setKgtime(datetime);
			//��Form�趨��Dto��
			dto.setIgkgm0207Form(form);
			dto.setUser(user);
			//���ֳ־û�
			dto = ctlBL.registKnowledgeGradeAction(dto);
			addMessage(req, new ActionMessage("IGKGM0207.I001"));
			log.debug("========֪ʶ���ֵǼǴ�������========");

		 }
		 if("SEARCH".equals(mapping.getParameter())){
			 
			 int maxCnt = getMaxDataCount("IGKGM0207");
			 dto.setMaxSearchCount(maxCnt);
		
			 //֪ʶIDȡ��
			 String knid = req.getParameter("knid");
			 
			 dto.setKnid(Integer.valueOf(knid));
			 //��ѯ֪ʶ���ֽ��
			 dto = ctlBL.searchKnowledgeGradeAction(dto);
			 //���ҵ��ϵͳ
			 dto = ctlBL.getKnowledgeAppImpact(dto);
			 
			 IGKGM02071VO vo = new IGKGM02071VO();
			 vo.setKnowledgeGradeList(dto.getKnowledgeGradeList());
			 vo.setKnowledgeAppImpactList(dto.getKnowledgeAppImpactList());
			 super.<IGKGM02071VO>setVO(req, vo);
			 
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
