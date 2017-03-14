/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.syslog.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.syslog.bl.IGLOG004BL;
import com.deliverik.infogovernor.syslog.dto.IGLOG0041DTO;
import com.deliverik.infogovernor.syslog.form.IGLOG0041Form;
import com.deliverik.infogovernor.syslog.vo.IGLOG0041VO;

/**
 * <p>
 * Title : InfoGovernor ��־����ģ�����
 * </p>
 * <p>
 * Description: ��ѯACTION
 * </p>
 * 
 * @author wangrongguagn@deliverik.com
 * @version 1.0
 */

public class IGLOG0041Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOG0041Action.class);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param mapping
	 *            ActionMapping
	 * @param form
	 *            ActionForm
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		//ʵ����DTO
		IGLOG0041DTO dto = new IGLOG0041DTO();
		
		//ʵ����form��
		IGLOG0041Form form = (IGLOG0041Form) actionForm;
		
		//ʵ����ctrolBL
		IGLOG004BL ctlBL = (IGLOG004BL) getBean("iglog004BL");
		
		
		//�����ѯҳ
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("====��־����ģ������ѯ����ʼ====");
			
			//��form�����dto������
			dto.setIgLog0041Form(form);
			
			//��ҳ��DTOȡ��
			getPaginDTO(request,"IGLOG0041");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			//�ж��Ƿ��ǵ�һҳ
			if (request.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGLOG0041Form) request.getSession().getAttribute("IGLOG0041Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			
			//���÷�ҳ����
			int maxCnt = getMaxDataCount("IGLOG0041");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			
			//������������ѯ����ģ��
			dto = ctlBL.searchMss00004(dto);
			
			//ʵ��������vo
			IGLOG0041VO vo = new IGLOG0041VO(dto.getMss00004InfoList());
			
			super.<IGLOG0041VO> setVO(request, vo);
			
			log.debug("====��־����ģ������ѯ�������====");
		}
		
		if( "CHANGE_STATUS".equals(mapping.getParameter())){
			log.debug("========�ı����ģ��״̬��ʼ========");
			//DTO��������趨
			dto.setIgLog0041Form(form);
			
			//����ģ��״̬
			dto = ctlBL.changeTempstate(dto);
			
			log.debug("========�ı����ģ��״̬����========");
		}

		return mapping.findForward("DISP");
	}

}
