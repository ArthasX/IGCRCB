package com.dev.hac.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.dev.hac.bl.IGHAC01BL;
import com.dev.hac.dto.IGHAC01DTO;
import com.dev.hac.form.IGHAC0101Form;
import com.dev.hac.vo.IGHAC01011VO;
import com.google.gson.Gson;

/**
 * HAC��״��������action
 * @author lvixn
 *
 */
public class IGHAC0101Action extends BaseAction {
static Log log = LogFactory.getLog(IGHAC0101Action.class);
	
	/**
	 * <p>
	 * Description: HAC������Ϣ����Action
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 */

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��ȡBL�ӿ�ʵ��
		IGHAC01BL ctlBL = (IGHAC01BL) getBean("ighac01BL");
		//ʵ����DTO
		IGHAC01DTO dto = new IGHAC01DTO();
	
		if("TREE".equals(mapping.getParameter())){
			IGHAC0101Form form = (IGHAC0101Form)actionForm;

			
			dto.setIghac0101form(form);
			
				dto = ctlBL.searchCodeTreeAction(dto);
				
				IGHAC01011VO vo = new IGHAC01011VO();
				
				//�򵥴ֱ�,����Map���Ҳ����
		        vo.setJsonstr(new Gson().toJson(dto.getHacList()));
				super.<IGHAC01011VO>setVO(request, vo);
			
		}
		
		return mapping.findForward("DISP");
	}
}
