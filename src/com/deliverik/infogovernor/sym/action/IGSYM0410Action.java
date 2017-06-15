/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.action;


import java.util.ArrayList;
import java.util.HashMap;
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
import com.deliverik.framework.user.model.Role;
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0410Form;
import com.deliverik.infogovernor.sym.model.RoleReport;
import com.deliverik.infogovernor.sym.vo.IGSYM04101VO;

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

public class IGSYM0410Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0410Action.class);
	
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
		IGSYM0410Form form = (IGSYM0410Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGSYM04BL ctlBL = (IGSYM04BL) getBean("igsym04BL");
		//ʵ����DTO
		IGSYM04DTO dto = new IGSYM04DTO();
		if ("SEARCH".equals(mapping.getParameter())){
			//������Ȩ��ѯ
			log.debug("========������Ȩ��ѯ����ʼ========");
			saveToken(request);				
			
			dto.setIgSYM0410Form(form);
			dto = ctlBL.roleReportFileDefinitionAction(dto);
			//����BL��ѯ
			dto = ctlBL.searchRoleReportAction(dto);
			//��������Ȩ��ɫ����ʱ��������
			
			List<Role> roleList = dto.getRoleList();
			List<Role> yroleList = new ArrayList<Role>();
			List<RoleReport> ownRoleList = dto.getRoleReportList();

			for(int i=0;i<ownRoleList.size();i++){
				for(int j=0;j<roleList.size();j++){
					if(ownRoleList.get(i).getRoleid().equals(roleList.get(j).getRoleid())){
						yroleList.add(roleList.get(j));
						roleList.remove(j);
						break;
					}
				}
			}

			//����VO
			IGSYM04101VO vo = new IGSYM04101VO(roleList,yroleList);
			vo.setRoleMap(this.getRoleMap(roleList));
			super.<IGSYM04101VO>setVO(request, vo);

			log.debug("========������Ȩ��ѯ��������========");
			return mapping.findForward("DISP");
		}
		//��ɫ��Ȩ
		if ("GRANT".equals(mapping.getParameter())){
			log.debug("========������Ȩ����ʼ========");
			//ɾ�������ɫ
			if("0".equals(form.getMode())){
				dto.setRoleids(form.getRoleidy());
				dto.setRfdid(form.getRfdid());
				ctlBL.revokeRoleReportAction(dto);
				addMessage(request, new ActionMessage("IGSYM0410.I002"));
			}else{//��ӱ����ɫ
				dto.setRoleids(form.getRoleids());
				dto.setRfdid(form.getRfdid());
				ctlBL.grantRoleReportAction(dto);
				addMessage(request, new ActionMessage("IGSYM0410.I001"));		
			}

			log.debug("========������Ȩ��������========");
		}
		return mapping.findForward("DISP");
	}

	public  Map<String,List<Role>> getRoleMap(List<Role> roleList){
    	if(roleList.size() == 0){
    		return null;
    	}
    	Map<String,List<Role>> retMap = new HashMap<String, List<Role>>();
    	for (Role role : roleList) {
    		String roleType = role.getRoletype();
    		if(!retMap.containsKey(roleType)){
    			retMap.put(roleType, new ArrayList<Role>());
    		}
    		retMap.get(roleType).add(role);
		}
    	return retMap;
    }

}
