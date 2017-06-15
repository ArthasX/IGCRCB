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
	 * 知识登记处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORM取得
		IGKGM0216Form form = (IGKGM0216Form)actionForm;
		
		//BL取得
		IGKGM02BL ctlBL = (IGKGM02BL) getBean("igkgm02BL");
		
		//关键字bl
		CodeDetailBL codeDetailBL = (CodeDetailBL) getBean("codeDetailBL");
		
		//DTO生成
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
			//知识信息查看
			log.debug("========知识登记查看处理开始========");
			
			Integer knid = Integer.valueOf(req.getParameter("knid"));
			form.setKnid(knid);
			
			dto.setUser(user);
			dto.setIgkgm0216Form(form);
			dto.setKnowledgeSearchCond(form);
			
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang 业务系统显示
			dto.setKnid(knid);
			dto = ctlBL.getKnowledgeAppImpact_Disp(dto);
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang 业务系统显示
			
			//add 查询知识审批人 leexuzhi 2011-1-10 start
			dto = ctlBL.getRoleKnApproveRole(dto);
			//add 查询知识审批人 leexuzhi 2011-1-10 end
			
			//查找是否有没提交的更新记录，total=0表示没有，total>0表示有
			dto = ctlBL.searchKnowledgeNotCheckAction(dto);
			int total = dto.getVersions();
			
			if(total > 0){
				String knproffer = dto.getKnowledge().getKnproffername();
				dto.addMessage(new ActionMessage( "IGCO10000.E011", "用户"+knproffer+":") );
				List<ActionMessage> messageList = dto.getMessageList();
				
				if( messageList != null && messageList.size() > 0 ) {
					for (ActionMessage message : messageList) {	
						addMessage(req, message);
					}
					
				}
				return mapping.findForward("FORBIDEN");
				
			}else{
				dto = ctlBL.searchUpdateKnowLedgeActionbyPK(dto);
				//设置显示信息
				form.setKnkey_p(form.getKnkey());
				form.setKnkeys(form.getKnkey_p().split(" "));
				dto = ctlBL.searchKnowledgeKeyAction(dto, codeDetailBL);
				IGKGM02012VO vo = new IGKGM02012VO();
				//<<<<<<<<<<<<<<add by wangxiaoqiang 业务系统显示
				vo.setKnowledgeAppImpactMap(dto.getKnowledgeAppImpactMap());
				//<<<<<<<<<<<<<< add by wangxiaoqiang 业务系统显示
				vo.setDefaultKeyList(dto.getKeysFromDB());
				vo.setRoleList(dto.getRoleList());
				vo.setKnowledge(dto.getKnowledgeList().get(0));
				vo.setKnowledgeProcessList(dto.getKnowledgeProcessList());
				super.<IGKGM02012VO> setVO(req.getSession(), vo);	
				log.debug("========知识登记编辑处理终了========");
			}
			
			
		} else if ("EDIT".equals(mapping.getParameter())){
			//知识信息修改
			log.debug("========知识登记查看保存开始========");
			form.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_INIT);//提交时将状态改为“草稿”：5
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
			log.debug("========知识登记查看保存终了========");
			addMessage(req, new ActionMessage("IGCO10000.I010","知识更新保存"));
			return mapping.findForward("DISP");
			
		}  else if ("CHECK".equals(mapping.getParameter())){
			//知识信息提交
			log.debug("========知识登记提交开始========");
			form.setKnstatus(IGKGMCONSTANTS.KNOWLEDGE_UN_APPROVE);//提交时将状态改为“未审核”：0
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
			log.debug("========知识登记提交终了========");
			addMessage(req, new ActionMessage("IGCO10000.I010","知识更新提交"));
			return mapping.findForward("DISP");
		}    
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		return mapping.findForward("DISP");
	}
}
