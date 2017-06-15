/*
\ * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.drm.bl.IGDRM16BL;
import com.deliverik.infogovernor.drm.dto.IGDRM16DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1602Form;
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
public class IGDRM1602Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM1602Action.class);

	/**
	 * 
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param req
	 * @param res
	 * @return
	 * @throws Exception
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse res) throws Exception {
		// ���form
		IGDRM1602Form form = (IGDRM1602Form) actionForm;
		// BLȡ��
		IGDRM16BL ctlBL = (IGDRM16BL) getBean("igdrm16BL");
		// DTO����
		IGDRM16DTO dto = new IGDRM16DTO();
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("==============�¼���ѯ��ʼ=====================");
			//��ȡ��ҳbean
			getPaginDTO(request,"IGDRM1602");
			PagingDTO pDto = (PagingDTO)request.getAttribute("PagingDTO");
			int maxCnt = getMaxDataCount("IGDRM1602");			
			//���ò�ѯ�������
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			//������ѯ
			dto.setIgdrm1602Form(form);
			//����blִ�в�ѯ����
			dto=ctlBL.getEventssList(dto);
			//���鵽�Ľ���ŵ�vo
			IGDRM16021VO vo = new IGDRM16021VO();
			vo.setEventssInfoList(dto.getEventssInfoList());
			super.<IGDRM16021VO>setVO(request, vo);
			log.debug("==============�¼���ѯ����=====================");
		}
		
		if( "DELETE".equals(mapping.getParameter())){
			log.debug("==============�¼�ɾ����ʼ=====================");
			dto.setIgdrm1602Form(form);
			ctlBL.deleteEventssAction(dto);
			log.debug("==============�¼�ɾ������=====================");
		}
		return mapping.findForward("DISP");
	}
}
