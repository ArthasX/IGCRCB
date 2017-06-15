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
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0402Form;
import com.deliverik.infogovernor.sym.vo.IGSYM04021VO;
import com.deliverik.infogovernor.util.PRJHelper;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��Ȩ����_��ɫ��ȨACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM0402Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0402Action.class);
	
	/**
	 * <p>
	 * Description: ��ɫ��Ȩaction����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGSYM0402Form form = (IGSYM0402Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGSYM04BL ctlBL = (IGSYM04BL) getBean("igsym04BL");
		//ʵ����DTO
		IGSYM04DTO dto = new IGSYM04DTO();
		if ("SEARCH".equals(mapping.getParameter())){
			//��ɫ��Ȩ��ѯ
			log.debug("========��ɫ��Ȩ��ѯ����ʼ========");
			saveToken(request);
			String flag = request.getParameter("flag");
			if(flag == null){
				//String orgname = new String(request.getParameter("orgname").getBytes("iso-8859-1"),"UTF-8");
				//String username = new String(request.getParameter("username").getBytes("iso-8859-1"),"UTF-8");
				//form.setOrgname(orgname);
				//form.setUsername(username);
				dto.setUserid(request.getParameter("userid"));
				dto.setOrgid(request.getParameter("orgid"));
			}
		
			
			dto.setUserRoleVWSearchCond(form);
			//����BL��ѯ
			dto = ctlBL.searchUserRoleAction(dto);
			//��������Ȩ��ɫ����ʱ��������
			if(flag == null){
				form.setOrgname(dto.getOrgname());
				form.setUsername(dto.getUsername());
			}
			
			List<Role> roleList = dto.getRoleList();
			List<UserRoleInfo> ownRoleList = dto.getOwnRoleList();
			for(int i=0;i<ownRoleList.size();i++){
				for(int j=0;j<roleList.size();j++){
					if(ownRoleList.get(i).getRoleid().equals(roleList.get(j).getRoleid())){
						roleList.remove(j);
						break;
					}
				}
			}
			//����VO
			IGSYM04021VO vo = new IGSYM04021VO(roleList,ownRoleList);
			vo.setRoleMap(PRJHelper.getRoleMap(roleList));
			super.<IGSYM04021VO>setVO(request, vo);

			log.debug("========��ɫ��Ȩ��ѯ��������========");
			return mapping.findForward("DISP");
		}
		//��ɫ��Ȩ
		if ("GRANT".equals(mapping.getParameter())){
			log.debug("========��ɫ��Ȩ����ʼ========");
			//ɾ���û���ɫ
			if("0".equals(form.getMode())){
				dto.setUrid(form.getUrid());
				ctlBL.revokeUserRoleAction(dto);
			}else{//����û���ɫ
				if (isTokenValid(request, true)){
					dto.setRoleids(form.getRoleids());
					dto.setUserid(form.getUserid());
					dto.setOrgid(form.getOrgid());
					ctlBL.grantUserRoleAction(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
			}

			log.debug("========��ɫ��Ȩ��������========");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
