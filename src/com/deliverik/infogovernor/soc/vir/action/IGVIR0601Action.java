/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.vir.bl.IGVIR06BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR06DTO;

/**
 * ����: �������ˣ����⻯������ʾ
 * ��������: ���⻯������ʾAction
 * ������¼: 2013/12/25
 * �޸ļ�¼: 
 */
public class IGVIR0601Action extends BaseAction {

	static Log log = LogFactory.getLog(IGVIR0601Action.class);

	/**
	 * ���ð�����ϵ��ʾ����
	 *
	 * @param mapping ActionMapping 
	 * @param actionForm ActionForm 
	 * @param req HttpServletRequest 
	 * @param res HttpServletResponse 
	 * @return ActionForward
	 * @throws Exception
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//BLȡ��
		IGVIR06BL ctlBL = (IGVIR06BL) getBean("igvir06BL");
		
		//DTO����
		IGVIR06DTO dto = new IGVIR06DTO();
		
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========VMTopoMap_FuXinApp��ʾ��ʼ========");
			//��ϵ��xml��ѯ
			String eiid=req.getParameter("EIID");
			dto.setEiid(eiid);
			dto = ctlBL.getVMWareTree(dto);
			String treeXml = dto.getTreeXml();
			System.out.println(treeXml);
			req.setAttribute("treeXml", treeXml);
			if(StringUtils.isNotEmpty(eiid)){
				req.setAttribute("eiid", eiid);
			}else{
				req.setAttribute("eiid", dto.getEiid());
			}
			
			log.debug("========VMTopoMap_FuXinApp��ʾ����========");
		}
		
		return mapping.findForward("DISP");
	}
}
