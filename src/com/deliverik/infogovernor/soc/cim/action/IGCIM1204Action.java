/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM12BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM12DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1204Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM12041VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ʲ���������Ϣ�汾�Ƚ�ACTION
 * </p>
 * 
 * @author wangxing@deliverik.com
 * @version 1.0
 */

public class IGCIM1204Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM1204Action.class);


	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//FORMȡ��
		IGCIM1204Form form = (IGCIM1204Form)actionForm;
		
		// ��ȡBL�ӿ�ʵ��
		IGCIM12BL ctlBL = (IGCIM12BL) getBean("igcim12BL");
		
		// ʵ����DTO
		IGCIM12DTO dto = new IGCIM12DTO();
		
		if( "SEARCH".equals(mapping.getParameter())){
			//�ʲ���������Ϣ�汾�Ƚϻ��������ʾ����
			log.debug("========�ʲ���������Ϣ�汾�Ƚϻ��������ʾ����ʼ========");
			
			//DTO��������趨
			dto.setIgcim1204form(form);
			
			User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			//�ʲ���������Ϣ�汾�Ƚϻ��������ʾ�߼�����
			dto = ctlBL.initIGCIM1204Action(dto);
			
			//���ʲ���������Ϣ�汾�Ƚϼ�������趨��VO��
			IGCIM12041VO vo = new IGCIM12041VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemList());
			//���ز鿴�ʲ�������ϢȨ�ޱ�ʶ
			vo.setFlag(dto.getFlag());
			super.<IGCIM12041VO>setVO(request, vo);
			
			//�߼���������е���Ϣ��ʾ
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(request, message);
				}
				
			}
			log.debug("========�ʲ���������Ϣ�汾�Ƚϻ��������ʾ��������========");
		}
		return mapping.findForward("DISP");
	}

}
