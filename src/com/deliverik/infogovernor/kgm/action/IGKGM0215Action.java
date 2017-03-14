/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.action;

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
import com.deliverik.infogovernor.kgm.bl.IGKGM02BL;
import com.deliverik.infogovernor.kgm.dto.IGKGM03DTO;
import com.deliverik.infogovernor.kgm.form.IGKGM0215Form;
import com.deliverik.infogovernor.kgm.vo.IGKGM02051VO;

/**
 * ����:֪ʶ����ϸҳ��ѯAction
 * ����������֪ʶ���ѯAction
 * ������¼��wangxiaoqiang 2010/12/07
 * �޸ļ�¼��
 */
public class IGKGM0215Action extends BaseAction {

	static Log log = LogFactory.getLog(IGKGM0205Action.class);

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
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//ʵ����FORM
		IGKGM0215Form form = (IGKGM0215Form)actionForm;
		
		//DTO����
		IGKGM03DTO dto = new IGKGM03DTO();
		
		if ("DETAIL".equals(mapping.getParameter())){
			//֪ʶ��Ϣ�鿴
			log.debug("========֪ʶ��ϸ��Ϣ�鿴����ʼ========");
			
			dto.setKnid(form.getKnid());//֪ʶID
			
			dto.setPrid(form.getPrid());//��֪ʶ��ϸҳ�������ID
			
			dto.setSfid(form.getSfid());//��֪ʶ��ϸҳ��ķ��񹤵�ID
			
			dto.setKnversion(form.getKnversion());//֪ʶ�汾
			
			IGKGM02BL igkgm02BL = (IGKGM02BL) getBean("igkgm02BL");

			dto = igkgm02BL.searchKnowLedgeDetailActionbyPK(dto);
			
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang ҵ��ϵͳ��ʾ
			dto = igkgm02BL.getKnowledgeAppImpact(dto);
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang ҵ��ϵͳ��ʾ
			
			//������ʾ��Ϣ
			IGKGM02051VO vo = new IGKGM02051VO();
			vo.setKnowledge(dto.getKnowledge());
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang ҵ��ϵͳ��ʾ
			vo.setKnowledgeAppImpactList(dto.getKnowledgeAppImpactList());
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang ҵ��ϵͳ��ʾ
			if(dto.getKnowledgeProcessList()!=null && dto.getKnowledgeProcessList().size()>0){
				vo.setKnowledgeProcessList(dto.getKnowledgeProcessList());				
			}
			super.<IGKGM02051VO> setVO(req.getSession(), vo);		
			log.debug("========֪ʶ��ϸ��Ϣ�鿴��������========");
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
