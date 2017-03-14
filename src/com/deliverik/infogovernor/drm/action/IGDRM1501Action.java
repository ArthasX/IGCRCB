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
import com.deliverik.infogovernor.drm.bl.IGDRM15BL;
import com.deliverik.infogovernor.drm.dto.IGDRM15DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1501Form;
import com.deliverik.infogovernor.drm.vo.IGDRM15011VO;




/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:��ѵ�ƻ���ѯAction
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
public class IGDRM1501Action extends BaseAction {

	

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			//��־����ȡ�� 
			Log log = LogFactory.getLog(IGDRM1501Action.class);
				
			//BLȡ��
			IGDRM15BL ctlBL = (IGDRM15BL) getBean("igdrm15BL");
				
			//ʵ����DTO
			IGDRM15DTO dto = new IGDRM15DTO();
				
			//formȡ�� 
		   	IGDRM1501Form form = (IGDRM1501Form)actionForm;
		   		
		   	//dto�����趨 
		   	dto.setIgdrm1501Form(form);
		   	if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())) {
		   		log.debug("========�û���ѯ����ʼ========");
				//��ȡ��ҳBean
				getPaginDTO(request,"IGDRM1501");
				PagingDTO pDto;
				pDto = (PagingDTO)request.getAttribute("PagingDTO");
				if ("SEARCH1".equals(mapping.getParameter())){
					//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
					form = (IGDRM1501Form) request.getSession().getAttribute("IGDRM1501Form");
					if (form == null) {
						form = new IGDRM1501Form();
					} else {
						if (request.getParameter("PAGING") == null) {
							pDto.setFromCount(form.getFromCount());
						} else {
							form.setFromCount(pDto.getFromCount());
						}
					}
				} else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(0);
						form = (IGDRM1501Form) request.getSession().getAttribute("IGDRM1501Form");
						if (form !=null) {
							form.setFromCount(0);
						}
					}
				}
				int maxCnt = getMaxDataCount("IGDRM1501");
				dto.setMaxSearchCount(maxCnt);
				dto.setPagingDto(pDto);
				dto = ctlBL.searchTrainplanList(dto);
				IGDRM15011VO vo = new IGDRM15011VO();
				vo.setTrainplanInfoList(dto.getTrainplanInfoList());
				super.<IGDRM15011VO>setVO(request, vo);
				log.debug("========�û���ѯ��������========");
		   	}else if("SEARCH_DETAIL".equals(mapping.getParameter())){
		   		log.debug("========��ѵ�ƻ�����ѵ�������ȡֵ����ʼ========");
				dto = ctlBL.searchTrainPlanMissionAction(dto);
				// ���鵽�Ľ���ŵ�vo
				IGDRM15011VO vo = new IGDRM15011VO();
				vo.setTrainmissionInfoList(dto.getTrainmissionInfoList());
				vo.setTrainplanInfo(dto.getTrainplanInfo());
				vo.setResultList(dto.getResultList());
				super.setVO(request, vo);
				log.debug("========��ѵ�ƻ�����ѵ�������ȡֵ�������========");
		   	}
		   	return mapping.findForward("DISP");
	}
}
