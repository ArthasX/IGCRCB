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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR10BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR10DTO;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR10001VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���⻯��������Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR1000Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGVIR1000Action.class);
		//BLȡ��
		IGVIR10BL ctlBL = (IGVIR10BL) getBean("igvir10BL");
		//ʵ����dto
		IGVIR10DTO dto = new IGVIR10DTO();
		//��ȡģ���б�
		if("TAMPLATELIST".equals(mapping.getParameter())){
			log.debug("================��ȡģ���б������ʼ================");
			dto = ctlBL.getTemplateList(dto);
			//ʵ����vo
			IGVIR10001VO vo = new IGVIR10001VO();
			vo.setTemplateList(dto.getTemplateList());
			super.<IGVIR10001VO>setVO(request, vo);
			log.debug("================��ȡģ���б��������================");
		}
		return mapping.findForward("DISP");
	}

}
