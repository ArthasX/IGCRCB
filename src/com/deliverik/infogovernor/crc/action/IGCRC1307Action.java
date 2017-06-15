/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.crc.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.bl.IGASM05BL;
import com.deliverik.infogovernor.asset.dto.IGASM42DTO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ĵ�����Action
 * </p>
 * 
 * @author ʷ����@deliverik.com
 * @version 1.0
 */
public class IGCRC1307Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCRC1307Action.class);
	
	/**
	 * <p>
	 * Description: ҳ���ѯaction����
	 * </p>
	 * 
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		log.debug("================�ĵ�����ͳ��Action��ʼ=============");
				
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		IGASM05BL igasm05BL = (IGASM05BL)getBean("igasm05BL");
		IGASM42DTO igasm42dto = new IGASM42DTO();
		
		if("INSERT".equals(mapping.getParameter())){
			
			igasm42dto.setUserid(user.getUserid());
			
			igasm42dto.setEiid(new Integer(request.getParameter("eiid")));
			
			SimpleDateFormat format = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
			igasm42dto.setDowntime(format.format(new Date()));
			igasm42dto.setDownlocation("1");
			igasm05BL.downFileInsertData(igasm42dto);
			
		}
		return mapping.findForward("DISP");
	}
}
