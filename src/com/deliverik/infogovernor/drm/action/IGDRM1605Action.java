/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.drm.bl.IGDRM16BL;
import com.deliverik.infogovernor.drm.dto.IGDRM16DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1604Form;
import com.deliverik.infogovernor.drm.vo.IGDRM16021VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
public class IGDRM1605Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGDRM1605Action.class);

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionform, HttpServletRequest request,
			HttpServletResponse res) throws Exception {
		
		// ���form
		IGDRM1604Form form = (IGDRM1604Form) actionform;
		IGDRM16BL ctlBL = (IGDRM16BL) getBean("igdrm16BL");
		// DTO����
		IGDRM16DTO dto = new IGDRM16DTO();
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("==============�¼���ѯ��ʼ=====================");
			//������ѯ
			dto.setIgdrm1604Form(form);
			
			//����blִ�в�ѯ����
			dto=ctlBL.getList(dto);	
			//���鵽�Ľ���ŵ�vo			 
			IGDRM16021VO vo = new IGDRM16021VO();			
			vo.setEventssScopesMap(dto.getEventssScopesMap());			
		    super.<IGDRM16021VO>setVO(request, vo);		
			log.debug("==============�¼���ѯ����=====================");
		}
		
		return mapping.findForward("DISP");
		
	}

}
