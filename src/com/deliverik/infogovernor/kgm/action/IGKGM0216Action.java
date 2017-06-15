package com.deliverik.infogovernor.kgm.action;

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
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.kgm.bl.IGKGM02BL;
import com.deliverik.infogovernor.kgm.bl.IGKGMCONSTANTS;
import com.deliverik.infogovernor.kgm.dto.IGKGM03DTO;
import com.deliverik.infogovernor.kgm.form.IGKGM0216Form;
import com.deliverik.infogovernor.kgm.vo.IGKGM02012VO;

public class IGKGM0216Action extends BaseAction{

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
		IGKGM0216Form form = (IGKGM0216Form)actionForm;
		
		//BLȡ��
		IGKGM02BL ctlBL = (IGKGM02BL) getBean("igkgm02BL");
		
		//�ؼ���bl
		CodeDetailBL codeDetailBL = (CodeDetailBL) getBean("codeDetailBL");
		
		//DTO����
		IGKGM03DTO dto = new IGKGM03DTO();
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		if ("EDIT".equals(mapping.getParameter()) || "CHECK".equals(mapping.getParameter())) {
			String[] keys = form.getKnkeys();
			String[] key_p = null;
			if(form.getKnkey_p().indexOf(" ") != -1){
				key_p = form.getKnkey_p().split(" ");
			}else{
				key_p = new String[1];
				key_p[0] = form.getKnkey_p();
			}
			String key = "";
			if (null != keys) {
				for (int i = 0; i < keys.length; i++) {
					if (key.indexOf(keys[i]) == -1) {
						key = key + " " + keys[i];
					}
				}

			}
			if (null != key_p) {
				for (int i = 0; i < key_p.length; i++) {
					if (key.indexOf(key_p[i]) == -1) {
						key = key + " " + key_p[i];
					}
				}
			}

			form.setKnkey(key);
		}
		  if ("READ".equals(mapping.getParameter())){
			//֪ʶ��Ϣ�鿴
			log.debug("========֪ʶ�Ǽǲ鿴����ʼ========");
			
			Integer knid = Integer.valueOf(req.getParameter("knid"));
			form.setKnid(knid);
			
			dto.setUser(user);
			dto.setIgkgm0216Form(form);
			dto.setKnowledgeSearchCond(form);
			
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang ҵ��ϵͳ��ʾ
			dto.setKnid(knid);
			dto = ctlBL.getKnowledgeAppImpact_Disp(dto);
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang ҵ��ϵͳ��ʾ
			
			//add ��ѯ֪ʶ������ leexuzhi 2011-1-10 start
			dto = ctlBL.getRoleKnApproveRole(dto);
			//add ��ѯ֪ʶ������ leexuzhi 2011-1-10 end
			
			//�����Ƿ���û�ύ�ĸ��¼�¼��total=0��ʾû�У�total>0��ʾ��
			dto = ctlBL.searchKnowledgeNotCheckAction(dto);
			int total = dto.getVersions();
			
			if(total > 0){
				String knproffer = dto.getKnowledge().getKnproffername();
				dto.addMessage(new ActionMessage( "IGCO10000.E011", "�û�"+knproffer+":") );
				List<ActionMessage> messageList = dto.getMessageList();
				
				if( messageList != null && messageList.size() > 0 ) {
					for (ActionMessage message : messageList) {	
						addMessage(req, message);
					}
					
				}
				return mapping.findForward("FORBIDEN");
				
			}else{
				dto = ctlBL.searchUpdateKnowLedgeActionbyPK(dto);
				//������ʾ��Ϣ
				form.setKnkey_p(form.getKnkey());
				form.setKnkeys(form.getKnkey_p().split(" "));
				dto = ctlBL.searchKnowledgeKeyAction(dto, codeDetailBL);
				IGKGM02012VO vo = new IGKGM02012VO();
				//<<<<<<<<<<<<<<add by wangxiaoqiang ҵ��ϵͳ��ʾ
				vo.setKnowledgeAppImpactMap(dto.getKnowledgeAppImpactMap());
				//<<<<<<<<<<<<<< add by wangxiaoqiang ҵ��ϵͳ��ʾ
				vo.setDefaultKeyList(dto.getKeysFromDB());
				vo.setRoleList(dto.getRoleList());
				vo.setKnowledge(dto.getKnowledgeList().get(0));
				vo.setKnowledgeProcessList(dto.getKnowledgeProcessList());
				super.<IGKGM02012VO> setVO(req.getSession(), vo);	
				log.debug("========֪ʶ�ǼǱ༭��������========");
			}
			
			
		} else if ("EDIT".equals(mapping.getParameter())){
			//֪ʶ��Ϣ�޸�
			log.debug("========֪ʶ�Ǽǲ鿴���濪ʼ========");
			form.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_INIT);//�ύʱ��״̬��Ϊ���ݸ塱��5
			dto.setUser(user);
			dto.setIgkgm0216Form(form);
			dto.setKnowledgeSearchCond(form);
			if(StringUtils.isNotEmpty(req.getParameter("delFiles"))){
				dto.setDelFiles(req.getParameter("delFiles"));
			}
			if(StringUtils.isNotEmpty(req.getParameter("delKgw"))){
				dto.setDelKgm(req.getParameter("delKgw"));
			}
			dto = ctlBL.insertKnowledgeAction(dto);
			log.debug("========֪ʶ�Ǽǲ鿴��������========");
			addMessage(req, new ActionMessage("IGCO10000.I010","֪ʶ���±���"));
			return mapping.findForward("DISP");
			
		}  else if ("CHECK".equals(mapping.getParameter())){
			//֪ʶ��Ϣ�ύ
			log.debug("========֪ʶ�Ǽ��ύ��ʼ========");
			form.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_UN_APPROVE);//�ύʱ��״̬��Ϊ��δ��ˡ���0
			dto.setUser(user);
			dto.setIgkgm0216Form(form);
			dto.setKnowledgeSearchCond(form);
			if(StringUtils.isNotEmpty(req.getParameter("delFiles"))){
				dto.setDelFiles(req.getParameter("delFiles"));
			}
			if(StringUtils.isNotEmpty(req.getParameter("delKgw"))){
				dto.setDelKgm(req.getParameter("delKgw"));
			}
			dto = ctlBL.insertKnowledgeAction(dto);
			log.debug("========֪ʶ�Ǽ��ύ����========");
			addMessage(req, new ActionMessage("IGCO10000.I010","֪ʶ�����ύ"));
			return mapping.findForward("DISP");
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
