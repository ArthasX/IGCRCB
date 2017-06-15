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
	 * 知识登记处理
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

		// FORM取得
		IGKGM0201Form form = (IGKGM0201Form) actionForm;

		// BL取得
		IGKGM02BL ctlBL = (IGKGM02BL) getBean("igkgm02BL");

		//关键字bl
		CodeDetailBL codeDetailBL = (CodeDetailBL) getBean("codeDetailBL");

		// DTO生成
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

			log.debug("========知识登记处理开始========");
			form.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_INIT);// 草稿状态：5
			dto.setIgkgm0201Form(form);
			dto.setUser(user);
			dto = ctlBL.insertAction(dto);

			log.debug("========知识登记处理终了========");

		}else if ("PROINITSAVE".equals(mapping.getParameter())) {
			log.debug("========知识登记处理开始========");
			form.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_INIT);// 草稿状态：5
			form.setProcessId(0,form.getProid());
			dto.setIgkgm0201Form(form);
			dto.setUser(user);
			dto = ctlBL.insertAction(dto);
			log.debug("========知识登记处理终了========");
		} else if ("PROINITCHECK".equals(mapping.getParameter())) {
			// 知识登记处理，保存，同时提交
			log.debug("========知识登记保存并提交开始========");
			form.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_UN_APPROVE);// 提交状态：0
			form.setProcessId(0,form.getProid());
			dto.setIgkgm0201Form(form);
			dto.setUser(user);
			dto = ctlBL.insertAction(dto);
			log.debug("========知识登记保存并提交终了========");
		}else if ("INITCHECK".equals(mapping.getParameter())) {
			// 知识登记处理，保存，同时提交
			log.debug("========知识登记保存并提交开始========");
			form.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_UN_APPROVE);// 提交状态：0
			dto.setIgkgm0201Form(form);
			dto.setUser(user);
			dto = ctlBL.insertAction(dto);
			log.debug("========知识登记保存并提交终了========");
		} else if ("DISP".equals(mapping.getParameter())) {
			dto = ctlBL.searchKnowledgeKeyAction(dto, codeDetailBL);
			dto = ctlBL.getSystem_typeList(dto);
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang 业务系统增加
			form.setSystem_typeList(dto.getSystem_typeList());
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang 业务系统增加
			//add 查询知识审批人 leexuzhi 2011-1-10 start
			dto = ctlBL.getRoleKnApproveRole(dto);
			//add 查询知识审批人 leexuzhi 2011-1-10 end
			IGKGM02011VO vo = new IGKGM02011VO();
			vo.setRoleList(dto.getRoleList());
			vo.setDefaultKeyList(dto.getKeysFromDB());
			// 知识查询画面再显示处理
			log.debug("========知识查询画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========知识查询画面再显示处理终了========");
			super.<IGKGM02011VO> setVO(req.getSession(), vo);
			return mapping.findForward("DISP");
		}else if ("ADD".equals(mapping.getParameter())) {
			if(null != req.getParameter("proid") || ("null").equals(req.getParameter("proid"))){
				form.setProid(Integer.valueOf(req.getParameter("proid")));
			}
			//根据流程ID查找流程名称
			dto.setProcessID(req.getParameter("proid"));
			dto = ctlBL.searchProcessRecordByKey(dto);
			form.setProcess_name(dto.getProcessName());
			//form.setProcessName(dto.getProcessName());
			form.setKntitle(dto.getProcessName());
			form.setKntelareaname(dto.getKntelareaname());
			dto = ctlBL.searchKnowledgeKeyAction(dto, codeDetailBL);
			dto = ctlBL.getSystem_typeList(dto);
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang 业务系统增加
			form.setSystem_typeList(dto.getSystem_typeList());
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang 业务系统增加
			
			//add 查询知识审批人 leexuzhi 2011-1-10 start
			dto = ctlBL.getRoleKnApproveRole(dto);
			//add 查询知识审批人 leexuzhi 2011-1-10 end
			IGKGM02011VO vo = new IGKGM02011VO();
			
			vo.setRoleList(dto.getRoleList());
			vo.setDefaultKeyList(dto.getKeysFromDB());
			// 知识查询画面再显示处理
			log.debug("========知识查询画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========知识查询画面再显示处理终了========");
			super.<IGKGM02011VO> setVO(req.getSession(), vo);
			return mapping.findForward("DISP");
		} else if ("READ".equals(mapping.getParameter())) {
			// 知识信息查看
			log.debug("========知识登记查看处理开始========");
			dto = ctlBL.searchKnowledgeKeyAction(dto, codeDetailBL);
			int cdd = Integer.valueOf(req.getParameter("knversion"));
			Integer knid = Integer.valueOf(req.getParameter("knid"));
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang 业务系统显示
			dto.setKnid(knid);
			dto = ctlBL.getKnowledgeAppImpact_Disp(dto);
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang 业务系统显示
			form.setKnid(knid);
			dto.setIgkgm0201Form(form);
			dto.setKnowledgeSearchCond(form);
			dto = ctlBL.searchKnowLedgeActionbyPK(dto);
			form.setKnkey_p(form.getKnkey());
			form.setKnkey("");
			//add 查询知识审批人 leexuzhi 2011-1-10 start
			dto = ctlBL.getRoleKnApproveRole(dto);
			//add 查询知识审批人 leexuzhi 2011-1-10 end
			form.setKnkeys(form.getKnkey_p().split(" "));
			// 设置显示信息
			IGKGM02011VO vo = new IGKGM02011VO();
			vo.setRoleList(dto.getRoleList());
			vo.setDefaultKeyList(dto.getKeysFromDB());
			vo.setKnowledge(dto.getKnowledgeList().get(0));
			vo.setKnowledgeProcessList(dto.getKnowledgeProcessList());
			//<<<<<<<<<<<<<<add by wangxiaoqiang 业务系统显示
			vo.setKnowledgeAppImpactList(dto.getKnowledgeAppImpactList());
			vo.setKnowledgeAppImpactMap(dto.getKnowledgeAppImpactMap());
			//<<<<<<<<<<<<<< add by wangxiaoqiang 业务系统显示
			super.<IGKGM02011VO> setVO(req.getSession(), vo);
			log.debug("========知识登记编辑处理终了========");
			return mapping.findForward("DISP");

		} else if ("EDIT".equals(mapping.getParameter())) {
			// 知识信息修改
			log.debug("========知识登记查看保存开始========");
			form.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_INIT);// 提交状态：0
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
			log.debug("========知识登记查看保存终了========");
			addMessage(req, new ActionMessage("IGCO10000.I005", "知识"));

		} else if ("CHECK".equals(mapping.getParameter())) {
			// 知识信息提交
			log.debug("========知识登记提交开始========");
			form.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_UN_APPROVE);// 提交时将状态改为“未审核”：0
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
			
			dto.addMessage(new ActionMessage("IGCO10000.I005", "知识信息"));
			log.debug("========知识登记提交终了========");

		}
		else if ("CHECKPASS".equals(mapping.getParameter())) {
			// 知识信息提交
			log.debug("========知识审批时更新操作开始========");
			form.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_APPROVEED);// 提交时将状态改为“未审核”：0
			dto.setUser(user);
			dto.setIgkgm0201Form(form);
			dto.setKnowledgeSearchCond(form);
			if(StringUtils.isNotEmpty(req.getParameter("delFiles"))){
				dto.setDelFiles(req.getParameter("delFiles"));
			}
			dto = ctlBL.updateKnowLedgeAction(dto);
			log.debug("========知识审批时更新操作终了========");

		}
		// 逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}

		}
		return mapping.findForward("DISP");
	}
}
