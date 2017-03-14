/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.vir.bl.IGVIR10BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR10DTO;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR10071VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��Դ������ҳAction
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR1007Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGVIR1007Action.class);
		//BLȡ��
		IGVIR10BL ctlBL = (IGVIR10BL) getBean("igvir10BL");
		//ʵ����dto
		IGVIR10DTO dto = new IGVIR10DTO();
		//��¼�û�ȡ��
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//dto�����趨
		dto.setUser(user);
		log.debug("==========��Դ������ҳ��ʼ��������ʼ==========");
		dto = ctlBL.initResourceManageHomePageAction(dto);
		//ʵ����vo
		IGVIR10071VO vo = new IGVIR10071VO();
		vo.setTemplateList(dto.getTemplateList());
		vo.setPihList(dto.getPihList());
		vo.setHostMap(dto.getHostMap());
		vo.setVmReportMap(dto.getVmReportMap());
		vo.setPrRecportMap(dto.getPrRecportMap());
		super.<IGVIR10071VO>setVO(request, vo);
		log.debug("==========��Դ������ҳ��ʼ����������==========");
		return mapping.findForward("DISP");
	}

}
