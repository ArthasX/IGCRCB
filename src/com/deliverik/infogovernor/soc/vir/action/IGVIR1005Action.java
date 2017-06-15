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
import com.deliverik.infogovernor.soc.vir.vo.IGVIR10051VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���⻯����Ա��ҳAction
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR1005Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGVIR1005Action.class);
		//BLȡ��
		IGVIR10BL ctlBL = (IGVIR10BL) getBean("igvir10BL");
		//ʵ����dto
		IGVIR10DTO dto = new IGVIR10DTO();
		//formȡ��
//		IGVIR1005Form form = (IGVIR1005Form) actionForm;
		log.debug("===========���⻯������ҳ��ʼ��������ʼ==========");
		//ʵ����vo
		IGVIR10051VO vo = new IGVIR10051VO();
		dto.setIgvir10051VO(vo);
		dto = ctlBL.initManageHomePageAction(dto);
		super.<IGVIR10051VO>setVO(request, vo);
		log.debug("===========���⻯������ҳ��ʼ����������==========");
		return mapping.findForward("DISP");
	}

}
