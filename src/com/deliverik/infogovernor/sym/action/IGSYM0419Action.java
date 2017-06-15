/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.Role;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0419Form;
import com.deliverik.infogovernor.sym.vo.IGSYM04191VO;

/**
 * @Description: ���ݽ�ɫ���Ͳ�ѯû�иý�ɫ���û�Action
 * @History 2010-6-22     �½� 
 * 			2011-4-15	SYS0306  ��������Ĭ��ֵ
 * @Version V2.0
 */
 
public class IGSYM0419Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0419Action.class);
	
	/**
	 * <p>
	 * Description: ���ݽ�ɫ���Ͳ�ѯû�иý�ɫ���û�action����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 */

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		//ʵ����FORM
		IGSYM0419Form form = (IGSYM0419Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGSYM04BL ctlBL = (IGSYM04BL)getBean("igsym04BL");
		//ʵ����DTO
		IGSYM04DTO dto = new IGSYM04DTO();
		
		dto.setRoleid(form.getRoleid());
		dto.setUrid(form.getUrids());

		if("DISP".equals(mapping.getParameter())){
			
			log.debug("========���ݽ�ɫ���Ͳ�ѯû�иý�ɫ���û���ʼ========");
			
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			form.setUserid_q(null);
			form.setUsername_q(null);
			form.setOrgname(null);
			form.setOrgidstr(null);
			form.setOrgname(null);
			// SYS0306 begin
			IGSYM03BL ctlBL03 = (IGSYM03BL) getBean("igsym03BL");
			Map<String, TreeNode> treeNodeMap= ctlBL03.getRoleDomainsTree(form.getRoleid().toString());
			if(treeNodeMap!=null&&!treeNodeMap.isEmpty()){			
				if(treeNodeMap.keySet()!=null&&!treeNodeMap.keySet().isEmpty()){
						Iterator<String> it=treeNodeMap.keySet().iterator();
						while(it.hasNext()){
							Object obj = it.next();
							String key=(String)obj;	
							TreeNode treeNode=(TreeNode)treeNodeMap.get(key);
							request.setAttribute("deforgsys", treeNode.getId());
							request.setAttribute("deforgname", treeNode.getName());
							break;
						}
						
				}
			}
			// SYS0306 end
			log.debug("========���ݽ�ɫ���Ͳ�ѯû�иý�ɫ���û�����========");
			
		} else if ("SEARCH".equals(mapping.getParameter())) {

			log.debug("========���ݽ�ɫ���Ͳ�ѯû�иý�ɫ���û���ʼ========");

			//��ȡ��ҳBean
			getPaginDTO(request,"IGSYM0419");

			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if (request.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
			}else{
				pDto.setFromCount(form.getFromCount());
				form = (IGSYM0419Form)request.getSession().getAttribute("IGSYM0419Form");
			}
			
			Set<String> set = (Set<String>)request.getSession().getAttribute("ADSelectUser");
			if(set != null && set.size() > 0) {
				form.setUrids(set.toArray(new String[0]));
			} else {
				form.setUrids(null);
			}
			
			int maxCnt = getMaxDataCount("IGSYM0419");

			dto.setUserNotRoleVWSearchCond(form);

			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			//��ȡ��ǰ��Role
			Role role = ctlBL.searchRoleByRoleId(dto).getRole();
			//����BL��ѯ
			if(StringUtils.isNotEmpty(role.getFingerPrint())){
				dto = ctlBL.searchUserNoByRoleTypeSyn(dto);//��ͬ����ɫʱֻ��ͬ���û�
			}else {
				dto = ctlBL.searchUserNoByRoleType(dto);
			}
			//����VO
			IGSYM04191VO vo = new IGSYM04191VO(dto.getUserNotRoleList() , dto.getRole());	
			
			super.<IGSYM04191VO>setVO(request, vo);
			
			log.debug("========���ݽ�ɫ���Ͳ�ѯû�иý�ɫ���û�����========");
			
		} else if ("SAVE".equals(mapping.getParameter())) {

			log.debug("========���ݽ�ɫ��������û���ʼ========");
			Set<String> set = (Set<String>)request.getSession().getAttribute("ADSelectUser");
			dto.setUrid(set.toArray(new String[0]));
			request.getSession().removeAttribute("ADSelectUser");
			//����BL��ѯ
			ctlBL.saveRoleUser(dto);
			
			/*PrintWriter out = response.getWriter();
			
			out.println("<script language='javascript'>");
			
			out.println("window.opener.location.href = '/InfoGovernor/IGSYM0418_Disp?roleid = " + dto.getRoleid() + "';");
			out.println("window.close();");
			out.println("<script>");
			
			out.close();*/

			//����VO

			form.setRoleid(dto.getRoleid());
			form.setSign("1");
			//IGSYM04191VO vo = new IGSYM04191VO("1" , String.valueOf(dto.getRoleid()));	
			
			//super.<IGSYM04191VO>setVO(request, vo);
			
			log.debug("========���ݽ�ɫ��������û�����========");

			
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
