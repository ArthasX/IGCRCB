/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0407Form;
import com.deliverik.infogovernor.sym.vo.IGSYM04071VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��ɫ����_��ɫ������ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
 
public class IGSYM0407Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0407Action.class);
	
	/**
	 * <p>
	 * Description: ��ɫ������action����
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
		IGSYM0407Form form = (IGSYM0407Form)actionForm;
		
		//��ȡBL�ӿ�ʵ��
		IGSYM04BL ctlBL = (IGSYM04BL) getBean("igsym04BL");
		
		//ʵ����DTO
		IGSYM04DTO dto = new IGSYM04DTO();
		
		dto.setUserRoleVWSearchCond(form);
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��ɫ�����˲�ѯ���������ʾ����ʼ========");
			//����BL��ѯ
			dto = ctlBL.searchRoleManagerAction(dto);
			
			//��ʼ����ѡ��
			Map<Integer, UserInfo> userInfoMap = dto.getUserInfoMap();
			if(userInfoMap != null) {
				List<String> uridList = new ArrayList<String>();
				Set<Map.Entry<Integer, UserInfo>> set = userInfoMap.entrySet();
				for(Iterator<Map.Entry<Integer, UserInfo>> iter = set.iterator();iter.hasNext();){
					Map.Entry<Integer, UserInfo> entry = iter.next();
					//������
					if("1".equals(entry.getValue().getRolemanager())) {
						uridList.add(entry.getKey().toString());
					}
				}
				if(!uridList.isEmpty()) {
					String[] uridArray = new String[uridList.size()];
					for(int i = 0; i < uridList.size(); i++) {
						uridArray[i] = uridList.get(i);
					}
					form.setUrids(uridArray);
					form.setHasManager("1");
				}
			}
			//����VO
			IGSYM04071VO vo = new IGSYM04071VO(dto.getUserInfoMap());	
			super.<IGSYM04071VO>setVO(request, vo);
			log.debug("========��ɫ�����˲�ѯ���������ʾ��������========");
		} else if( "SAVE".equals(mapping.getParameter())){
			log.debug("========���ý�ɫ�����˴���ʼ========");
			dto.setUrid(form.getUrids());
			dto.setUserRoleSearchCond(form);
			//����BL��ѯ
			dto = ctlBL.saveRoleManagerAction(dto);
			//����VO
			IGSYM04071VO vo = new IGSYM04071VO(dto.getUserInfoMap());	
			super.<IGSYM04071VO>setVO(request, vo);
			log.debug("========���ý�ɫ�����˴�������========");
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
