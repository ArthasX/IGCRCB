/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.asset.bl.IGASM11BL;
import com.deliverik.infogovernor.asset.dto.IGASM11DTO;
import com.deliverik.infogovernor.asset.form.IGASM1120Form;
import com.deliverik.infogovernor.asset.vo.IGASM11201VO;

/**
 * ����:3D����֧��IP��ѯ 
 * ����������3D����֧��IP��ѯ
 * �����ˣ�����͢
 * ������¼�� 2013-02-01
 * �޸ļ�¼��
 */
public class IGASM1120Action extends BaseAction {
	static Log log = LogFactory.getLog(IGASM1120Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORMȡ��
		IGASM1120Form form = (IGASM1120Form)actionForm;
		
		//BLȡ��
		IGASM11BL ctlBL = (IGASM11BL) getBean("igasm11BL");
		
		//DTO����
		IGASM11DTO dto = new IGASM11DTO();
		String forward = "DISP";
		if("DISP".equals(mapping.getParameter())){
			log.debug("========3D����֧��IP��ѯ��ʼ========");
			log.debug("========3D����֧��IP��ѯ����========");
		}if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
		    log.debug("========3D����֧��IP��ѯ��ʼ========");
            //��ȡ��ҳBean
            getPaginDTO(request,"IGASM1120");
            PagingDTO pDto;
            pDto = (PagingDTO)request.getAttribute("PagingDTO");
            if ("SEARCH1".equals(mapping.getParameter())){
                //����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
                form = (IGASM1120Form) request.getSession().getAttribute("IGASM1120Form");
                if ( form== null){
                    form = new IGASM1120Form();
                }else {
                    if (request.getParameter("PAGING") == null) {
                        pDto.setFromCount(form.getFromCount());
                    } else {
                        form.setFromCount(pDto.getFromCount());
                    }
                }
            } else {
                if (request.getParameter("PAGING") == null) {
                    pDto.setFromCount(0);
                    form = (IGASM1120Form) request.getSession().getAttribute("IGASM1120Form");
                    if (form !=null) {
                        form.setFromCount(0);
                    }
                }
            }
 
            //�������¼��   
            int maxCnt = getMaxDataCount("IGASM1120");
            dto.setMaxSearchCount(maxCnt);
            dto.setPagingDto(pDto);
            //��form�Ž�dto��
            dto.setIgasm1120Form(form);
            //��ѯ��ǰ30���ά�������ʲ�
            dto = ctlBL.getEquipmentAndIpAction(dto);
            IGASM11201VO vo = new IGASM11201VO();
            vo.setEilist(dto.getEilist());
            super.<IGASM11201VO>setVO(request, vo);
            log.debug("========3D����֧��IP��ѯ����========");
        }
		return mapping.findForward(forward);
	}

}
