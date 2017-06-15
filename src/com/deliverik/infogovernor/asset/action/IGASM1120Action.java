/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
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
 * 概述:3D机房支持IP查询 
 * 功能描述：3D机房支持IP查询
 * 创建人：赵梓廷
 * 创建记录： 2013-02-01
 * 修改记录：
 */
public class IGASM1120Action extends BaseAction {
	static Log log = LogFactory.getLog(IGASM1120Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORM取得
		IGASM1120Form form = (IGASM1120Form)actionForm;
		
		//BL取得
		IGASM11BL ctlBL = (IGASM11BL) getBean("igasm11BL");
		
		//DTO生成
		IGASM11DTO dto = new IGASM11DTO();
		String forward = "DISP";
		if("DISP".equals(mapping.getParameter())){
			log.debug("========3D机房支持IP查询开始========");
			log.debug("========3D机房支持IP查询终了========");
		}if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
		    log.debug("========3D机房支持IP查询开始========");
            //获取分页Bean
            getPaginDTO(request,"IGASM1120");
            PagingDTO pDto;
            pDto = (PagingDTO)request.getAttribute("PagingDTO");
            if ("SEARCH1".equals(mapping.getParameter())){
                //由详细画面，编辑画面返回查询画面时的再检索处理
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
 
            //获得最大记录数   
            int maxCnt = getMaxDataCount("IGASM1120");
            dto.setMaxSearchCount(maxCnt);
            dto.setPagingDto(pDto);
            //将form放进dto中
            dto.setIgasm1120Form(form);
            //查询提前30天的维保到期资产
            dto = ctlBL.getEquipmentAndIpAction(dto);
            IGASM11201VO vo = new IGASM11201VO();
            vo.setEilist(dto.getEilist());
            super.<IGASM11201VO>setVO(request, vo);
            log.debug("========3D机房支持IP查询终了========");
        }
		return mapping.findForward(forward);
	}

}
