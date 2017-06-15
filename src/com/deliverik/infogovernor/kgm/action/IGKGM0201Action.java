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
import com.deliverik.infogovernor.kgm.form.IGKGM0201Form;
import com.deliverik.infogovernor.kgm.vo.IGKGM02011VO;

public class IGKGM0201Action extends BaseAction {

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
	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {

		// FORMȡ��
		IGKGM0201Form form = (IGKGM0201Form) actionForm;

		// BLȡ��
		IGKGM02BL ctlBL = (IGKGM02BL) getBean("igkgm02BL");

		//�ؼ���bl
		CodeDetailBL codeDetailBL = (CodeDetailBL) getBean("codeDetailBL");

		// DTO����
		IGKGM03DTO dto = new IGKGM03DTO();

		User user = (User) req.getSession()
				.getAttribute(SESSION_KEY_LOGIN_USER);
		if ("INSERT".equals(mapping.getParameter())
				|| "INITCHECK".equals(mapping.getParameter())
				|| "EDIT".equals(mapping.getParameter())
				|| "CHECK".equals(mapping.getParameter())
				|| "PROINITSAVE".equals(mapping.getParameter())
				|| "PROINITCHECK".equals(mapping.getParameter())
				|| "CHECKPASS".equals(mapping.getParameter())
				) {
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
						if(key.equals("")){
							key = keys[i];
						}else{
							key = key + " " + keys[i];
						}
						
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
		if ("INSERT".equals(mapping.getParameter())) {

			log.debug("========֪ʶ�ǼǴ���ʼ========");
			form.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_INIT);// �ݸ�״̬��5
			dto.setIgkgm0201Form(form);
			dto.setUser(user);
			dto = ctlBL.insertAction(dto);

			log.debug("========֪ʶ�ǼǴ�������========");

		}else if ("PROINITSAVE".equals(mapping.getParameter())) {
			log.debug("========֪ʶ�ǼǴ���ʼ========");
			form.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_INIT);// �ݸ�״̬��5
			form.setProcessId(0,form.getProid());
			dto.setIgkgm0201Form(form);
			dto.setUser(user);
			dto = ctlBL.insertAction(dto);
			log.debug("========֪ʶ�ǼǴ�������========");
		} else if ("PROINITCHECK".equals(mapping.getParameter())) {
			// ֪ʶ�ǼǴ������棬ͬʱ�ύ
			log.debug("========֪ʶ�ǼǱ��沢�ύ��ʼ========");
			form.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_UN_APPROVE);// �ύ״̬��0
			form.setProcessId(0,form.getProid());
			dto.setIgkgm0201Form(form);
			dto.setUser(user);
			dto = ctlBL.insertAction(dto);
			log.debug("========֪ʶ�ǼǱ��沢�ύ����========");
		}else if ("INITCHECK".equals(mapping.getParameter())) {
			// ֪ʶ�ǼǴ������棬ͬʱ�ύ
			log.debug("========֪ʶ�ǼǱ��沢�ύ��ʼ========");
			form.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_UN_APPROVE);// �ύ״̬��0
			dto.setIgkgm0201Form(form);
			dto.setUser(user);
			dto = ctlBL.insertAction(dto);
			log.debug("========֪ʶ�ǼǱ��沢�ύ����========");
		} else if ("DISP".equals(mapping.getParameter())) {
			dto = ctlBL.searchKnowledgeKeyAction(dto, codeDetailBL);
			dto = ctlBL.getSystem_typeList(dto);
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang ҵ��ϵͳ����
			form.setSystem_typeList(dto.getSystem_typeList());
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang ҵ��ϵͳ����
			//add ��ѯ֪ʶ������ leexuzhi 2011-1-10 start
			dto = ctlBL.getRoleKnApproveRole(dto);
			//add ��ѯ֪ʶ������ leexuzhi 2011-1-10 end
			IGKGM02011VO vo = new IGKGM02011VO();
			vo.setRoleList(dto.getRoleList());
			vo.setDefaultKeyList(dto.getKeysFromDB());
			// ֪ʶ��ѯ��������ʾ����
			log.debug("========֪ʶ��ѯ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========֪ʶ��ѯ��������ʾ��������========");
			super.<IGKGM02011VO> setVO(req.getSession(), vo);
			return mapping.findForward("DISP");
		}else if ("ADD".equals(mapping.getParameter())) {
			if(null != req.getParameter("proid") || ("null").equals(req.getParameter("proid"))){
				form.setProid(Integer.valueOf(req.getParameter("proid")));
			}
			//��������ID������������
			dto.setProcessID(req.getParameter("proid"));
			dto = ctlBL.searchProcessRecordByKey(dto);
			form.setProcess_name(dto.getProcessName());
			//form.setProcessName(dto.getProcessName());
			form.setKntitle(dto.getProcessName());
			form.setKntelareaname(dto.getKntelareaname());
			dto = ctlBL.searchKnowledgeKeyAction(dto, codeDetailBL);
			dto = ctlBL.getSystem_typeList(dto);
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang ҵ��ϵͳ����
			form.setSystem_typeList(dto.getSystem_typeList());
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang ҵ��ϵͳ����
			
			//add ��ѯ֪ʶ������ leexuzhi 2011-1-10 start
			dto = ctlBL.getRoleKnApproveRole(dto);
			//add ��ѯ֪ʶ������ leexuzhi 2011-1-10 end
			IGKGM02011VO vo = new IGKGM02011VO();
			
			vo.setRoleList(dto.getRoleList());
			vo.setDefaultKeyList(dto.getKeysFromDB());
			// ֪ʶ��ѯ��������ʾ����
			log.debug("========֪ʶ��ѯ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========֪ʶ��ѯ��������ʾ��������========");
			super.<IGKGM02011VO> setVO(req.getSession(), vo);
			return mapping.findForward("DISP");
		} else if ("READ".equals(mapping.getParameter())) {
			// ֪ʶ��Ϣ�鿴
			log.debug("========֪ʶ�Ǽǲ鿴����ʼ========");
			dto = ctlBL.searchKnowledgeKeyAction(dto, codeDetailBL);
			int cdd = Integer.valueOf(req.getParameter("knversion"));
			Integer knid = Integer.valueOf(req.getParameter("knid"));
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang ҵ��ϵͳ��ʾ
			dto.setKnid(knid);
			dto = ctlBL.getKnowledgeAppImpact_Disp(dto);
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang ҵ��ϵͳ��ʾ
			form.setKnid(knid);
			dto.setIgkgm0201Form(form);
			dto.setKnowledgeSearchCond(form);
			dto = ctlBL.searchKnowLedgeActionbyPK(dto);
			form.setKnkey_p(form.getKnkey());
			form.setKnkey("");
			//add ��ѯ֪ʶ������ leexuzhi 2011-1-10 start
			dto = ctlBL.getRoleKnApproveRole(dto);
			//add ��ѯ֪ʶ������ leexuzhi 2011-1-10 end
			form.setKnkeys(form.getKnkey_p().split(" "));
			// ������ʾ��Ϣ
			IGKGM02011VO vo = new IGKGM02011VO();
			vo.setRoleList(dto.getRoleList());
			vo.setDefaultKeyList(dto.getKeysFromDB());
			vo.setKnowledge(dto.getKnowledgeList().get(0));
			vo.setKnowledgeProcessList(dto.getKnowledgeProcessList());
			//<<<<<<<<<<<<<<add by wangxiaoqiang ҵ��ϵͳ��ʾ
			vo.setKnowledgeAppImpactList(dto.getKnowledgeAppImpactList());
			vo.setKnowledgeAppImpactMap(dto.getKnowledgeAppImpactMap());
			//<<<<<<<<<<<<<< add by wangxiaoqiang ҵ��ϵͳ��ʾ
			super.<IGKGM02011VO> setVO(req.getSession(), vo);
			log.debug("========֪ʶ�ǼǱ༭��������========");
			return mapping.findForward("DISP");

		} else if ("EDIT".equals(mapping.getParameter())) {
			// ֪ʶ��Ϣ�޸�
			log.debug("========֪ʶ�Ǽǲ鿴���濪ʼ========");
			form.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_INIT);// �ύ״̬��0
			dto.setUser(user);
			dto.setIgkgm0201Form(form);
			dto.setKnowledgeSearchCond(form);
			if(StringUtils.isNotEmpty(req.getParameter("delFiles"))){
				dto.setDelFiles(req.getParameter("delFiles"));
			}
			if(StringUtils.isNotEmpty(req.getParameter("delKgw"))){
				dto.setDelKgm(req.getParameter("delKgw"));
			}
			dto = ctlBL.updateKnowLedgeAction(dto);
			log.debug("========֪ʶ�Ǽǲ鿴��������========");
			addMessage(req, new ActionMessage("IGCO10000.I005", "֪ʶ"));

		} else if ("CHECK".equals(mapping.getParameter())) {
			// ֪ʶ��Ϣ�ύ
			log.debug("========֪ʶ�Ǽ��ύ��ʼ========");
			form.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_UN_APPROVE);// �ύʱ��״̬��Ϊ��δ��ˡ���0
			dto.setUser(user);
			form.setKnproffername(user.getUsername());
			dto.setIgkgm0201Form(form);
			dto.setKnowledgeSearchCond(form);
			if(StringUtils.isNotEmpty(req.getParameter("delFiles"))){
				dto.setDelFiles(req.getParameter("delFiles"));
			}
			if(StringUtils.isNotEmpty(req.getParameter("delKgw"))){
				dto.setDelKgm(req.getParameter("delKgw"));
			}
			dto = ctlBL.updateKnowLedgeAction(dto);
			
			dto.addMessage(new ActionMessage("IGCO10000.I005", "֪ʶ��Ϣ"));
			log.debug("========֪ʶ�Ǽ��ύ����========");

		}
		else if ("CHECKPASS".equals(mapping.getParameter())) {
			// ֪ʶ��Ϣ�ύ
			log.debug("========֪ʶ����ʱ���²�����ʼ========");
			form.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED);// �ύʱ��״̬��Ϊ��δ��ˡ���0
			dto.setUser(user);
			dto.setIgkgm0201Form(form);
			dto.setKnowledgeSearchCond(form);
			if(StringUtils.isNotEmpty(req.getParameter("delFiles"))){
				dto.setDelFiles(req.getParameter("delFiles"));
			}
			dto = ctlBL.updateKnowLedgeAction(dto);
			log.debug("========֪ʶ����ʱ���²�������========");

		}
		// �߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}

		}
		return mapping.findForward("DISP");
	}
}
