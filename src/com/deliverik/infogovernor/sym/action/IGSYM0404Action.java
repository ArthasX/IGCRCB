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
import com.deliverik.framework.user.model.RoleAction;
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0404Form;
import com.deliverik.infogovernor.sym.vo.IGSYM04041VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��Ȩ����_�˵���ȨACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM0404Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0404Action.class);
	
	/**
	 * <p>
	 * Description: �˵���Ȩaction����
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
		IGSYM0404Form form = (IGSYM0404Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGSYM04BL ctlBL = (IGSYM04BL) getBean("igsym04BL");
		//ʵ����DTO
		IGSYM04DTO dto = new IGSYM04DTO();
		if ("SEARCH".equals(mapping.getParameter())){
			//�˵���Ȩ��ѯ
			log.debug("========�˵���Ȩ��ѯ����ʼ========");
			
			
			String flag = request.getParameter("flag");
			if(flag == null){
				//String rolename = new String(request.getParameter("rolename").getBytes("iso-8859-1"),"UTF-8");
				//form.setRolename(rolename);
				dto.setRoleid(Integer.valueOf(request.getParameter("roleid")));
			}
			
			if(form.getRoleid() != null && form.getRoleid() != 0) {
				dto.setRoleid(form.getRoleid());
			}
			
			dto.setRoleActionSearchCond(form);
			//����BL��ѯ
			dto = ctlBL.searchRoleActionAction(dto);
			
			if(flag == null){
				form.setRolename(dto.getRolename());
			}
			//ѡ������Ȩ�˵�
			List<RoleAction> roleActionList = dto.getRoleActionList();
			String[] actidArray = new String[roleActionList.size()];
			for(int i=0;i<roleActionList.size();i++){
				actidArray[i] = roleActionList.get(i).getActname();
			}
			form.setActionids(actidArray);
			saveToken(request);
			//����VO
			IGSYM04041VO vo = new IGSYM04041VO(dto.getActionList());
			super.<IGSYM04041VO>setVO(request, vo);

			log.debug("========�˵���Ȩ��ѯ��������========");
		}
		//�˵���Ȩ��ɾ��ԭ�е������
		if ("GRANT".equals(mapping.getParameter())){
				log.debug("========�˵���Ȩ����ʼ========");
				dto.setActionids(form.getActionids());
				dto.setRoleid(form.getRoleid());
				
				if (isTokenValid(request, true)){
					//����BL����
					ctlBL.roleActionAction(dto);
				}else{
					addMessage(request, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				
				log.debug("========�˵���Ȩ��������========");
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
