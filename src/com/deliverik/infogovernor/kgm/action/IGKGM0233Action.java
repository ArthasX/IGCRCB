/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.kgm.action;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.kgm.bl.IGKGM02BL;
import com.deliverik.infogovernor.kgm.dto.IGKGM02DTO;
import com.deliverik.infogovernor.kgm.vo.IGKGM02331VO;
import com.google.gson.Gson;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ҵ��ϵͳ��ѯAction
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGKGM0233Action extends BaseAction{

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGKGM0233Action.class);
		//BLȡ��
		IGKGM02BL ctlBL = (IGKGM02BL) getBean("igkgm02BL");
		//ʵ������dto
		IGKGM02DTO dto = new IGKGM02DTO();
		//dto�����趨
		dto.setForm(actionForm);
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("================ҵ��ϵͳ��ѯ������ʼ=================");
			if(StringUtils.isNotEmpty(request.getParameter("exitsbussys"))){ 
//				URLDecoder.decode(request.getParameter("exitsbussys").toString(),"UTF-8");	
			
				request.setAttribute("exitsbussys", URLDecoder.decode(request.getParameter("exitsbussys").toString(),"UTF-8"));
			}
			ctlBL.searchBusinessSystem(dto);
			IGKGM02331VO vo = new IGKGM02331VO();
			vo.setBusinessSystemList(dto.getBusinessSystemList());
			super.<IGKGM02331VO>setVO(request, vo);
			
			log.debug("================ҵ��ϵͳ��ѯ��������=================");
		}else if("SEARCH".equals(mapping.getParameter())){
			String syscoding = request.getParameter("syscoding");
			dto.setBusinessSystemSyscoding(syscoding);
			dto = ctlBL.searchBusinessSystem(dto);
			Gson gson = new Gson();
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(gson.toJson(dto.getBusinessSystemList()));
			return null;
			
		}
		return mapping.findForward("DISP");
	}

}
