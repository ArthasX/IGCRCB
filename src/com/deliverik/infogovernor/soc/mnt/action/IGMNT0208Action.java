/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.action;

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
import com.deliverik.framework.security.UserPermission;
import com.deliverik.infogovernor.soc.mnt.bl.IGMNT02BL;
import com.deliverik.infogovernor.soc.mnt.dto.IGMNT02DTO;
import com.deliverik.infogovernor.soc.mnt.form.IGMNT0206Form;
import com.deliverik.infogovernor.soc.mnt.vo.IGMNT02081VO;



/**
 * ����: �澯��־��ϸ��Ϣ����Action����
 * ��������: �澯��־��ϸ��Ϣ��ʾ
 * ������¼: 2012/02/16
 * �޸ļ�¼: 
 */
public class IGMNT0208Action extends BaseAction{
	static Log log=LogFactory.getLog(IGMNT0208Action.class);

	/**
	 * �¼�����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param request 
	 * @param response 
	 * @return 
	 * @throws Exception 
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ʵ����FORM
		IGMNT0206Form form = (IGMNT0206Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGMNT02BL ctlBL = (IGMNT02BL)getBean("igmnt02BL");//
		//ʵ����DTO
		IGMNT02DTO dto=new IGMNT02DTO();
		//���ʻ�����
		dto.setLocale(this.getLocale(request));
		//������������
		dto.setSoc0305SearchCond(form);
		//����BL��ѯ
		dto = ctlBL.searchSOC0305ByCond(dto);
		//����VO
		IGMNT02081VO vo = new IGMNT02081VO();
		vo.setSoc0305Info(dto.getSoc0305Info());
		super.<IGMNT02081VO>setVO(request, vo);
		
		//��ȡ�˵�Ȩ��
		UserPermission perm = (UserPermission)request.getSession().getAttribute("UserPermission");
		
		//���ø����˵�
		if(perm != null) {
			String actsortid = perm.getActsortid("ACT06MNT0201");//��ȡָ���˵�ID��ACTSORTID
			if(StringUtils.isNotEmpty(actsortid)){
				setSessionAttribute(request, "firstactid", actsortid.substring(0, 2));
				setSessionAttribute(request, "secondactid", actsortid.substring(0, 4));
			}
		}
		log.debug("========������־��ѯ��������========");
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
