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
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.drm.bl.IGDRM15BL;
import com.deliverik.infogovernor.drm.dto.IGDRM15DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1501Form;
import com.deliverik.infogovernor.drm.form.IGDRM1514Form;
import com.deliverik.infogovernor.drm.vo.IGDRM15141VO;



/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:��ѵ�ƻ���ѯ ������
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
public class IGDRM1514Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM1514Action.class);

	/**
	 * 
	 * 
	 * @param mapping
	 * @param actionForm
	 * @param request
	 * @param res
	 * @return
	 * @throws Exception
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse res) throws Exception {
		// ���form
		IGDRM1514Form form = (IGDRM1514Form) actionForm;
		// BLȡ��
		IGDRM15BL ctlBL = (IGDRM15BL) getBean("igdrm15BL");
		// DTO����
		IGDRM15DTO dto = new IGDRM15DTO();
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("==============��ѵ�ƻ���ѯ��ʼ=====================");
			//��ȡ��ҳbean
			getPaginDTO(request,"IGDRM1514");
			PagingDTO pDto = (PagingDTO)request.getAttribute("PagingDTO");
			int maxCnt = getMaxDataCount("IGDRM1514");			
			//���ò�ѯ�������
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			//������ѯ
			
			IGDRM1501Form drm1501Form = new IGDRM1501Form();
			
			BeanUtils.copyProperties(form, drm1501Form);
			
			dto.setIgdrm1514Form(form);
			
			dto.setIgdrm1501Form(drm1501Form);
			//����blִ�в�ѯ����
			dto=ctlBL.searchTrainplanList(dto);
			//���鵽�Ľ���ŵ�vo
			IGDRM15141VO vo = new IGDRM15141VO();
			vo.setTrainplanInfoList(dto.getTrainplanInfoList());
			super.<IGDRM15141VO>setVO(request, vo);
			log.debug("==============��ѵ�ƻ���ѯ����=====================");
		}
		
		
		return mapping.findForward("DISP");
	}
}
