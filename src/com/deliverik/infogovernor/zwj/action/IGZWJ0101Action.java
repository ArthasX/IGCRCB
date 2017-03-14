/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.zwj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.condition.UserSearchCondImpl;
import com.deliverik.infogovernor.zwj.bl.IGZWJ01BL;
import com.deliverik.infogovernor.zwj.dto.IGZWJ01DTO;
import com.deliverik.infogovernor.zwj.form.IGZWJ0101Form;
import com.deliverik.infogovernor.zwj.vo.IGZWJ01011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �¼����� ��ѯ��Ա��Ϣ
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGZWJ0101Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGZWJ0101Action.class);
		//BLȡ��
		IGZWJ01BL ctlBL = (IGZWJ01BL) getBean("igzwj01BL");
		//ʵ����dto
		IGZWJ01DTO dto = new IGZWJ01DTO();
		//formȡ��
		IGZWJ0101Form form = (IGZWJ0101Form) actionForm;
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========�û���ѯ���������ʾ����ʼ========");
			//���û�����ʼֵ
			dto = ctlBL.searchOrgnameAction(dto);
		    if(form==null){
		    	IGZWJ0101Form lsrform = new IGZWJ0101Form();
		    	lsrform.setOrgidstr(dto.getOrg().getOrgsyscoding());
		    	lsrform.setOrgname(dto.getOrg().getOrgname());
		    	request.setAttribute("IGZWJ0101Form", lsrform);
		    }else{		    	
		    	form.setOrgidstr(dto.getOrg().getOrgsyscoding());
		    	form.setOrgname(dto.getOrg().getOrgname());
		    }
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========�û���ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}	
		//�û���ѯ
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========�û���ѯ����ʼ========");
			//��ȡ��ҳBean
			getPaginDTO(request,"IGZWJ0101");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGZWJ0101Form) request.getSession().getAttribute("IGZWJ0101Form");
				if ( form== null){
					form = new IGZWJ0101Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGZWJ0101Form) request.getSession().getAttribute("IGZWJ0101Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			int maxCnt = getMaxDataCount("IGCYB0101");
			UserSearchCondImpl cond = new UserSearchCondImpl();
			BeanUtils.copyProperties(cond, form);
			//����ѯ����Сдת���ɴ�д
			cond.setUsername_q(cond.getUsername_q());
			cond.setOrgid(null);
			cond.setOrgid_like(form.getOrgidstr());
			dto.setUserSearchCond(cond);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchUserInfoAction(dto);
			//����VO
			IGZWJ01011VO vo = new IGZWJ01011VO();
			vo.setUserList(dto.getUserList());
			super.<IGZWJ01011VO>setVO(request, vo);
			
			log.debug("========�û���ѯ��������========");
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
