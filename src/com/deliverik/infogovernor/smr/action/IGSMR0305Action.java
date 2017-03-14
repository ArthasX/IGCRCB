/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.pdf.xmlbl.IGPDF01BL;
import com.deliverik.infogovernor.smr.bl.IGSMR03BL;
import com.deliverik.infogovernor.smr.dto.IGSMR03DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0304Form;
import com.deliverik.infogovernor.smr.vo.IGSMR03051VO;

/**
 * 概述:通用查询action 
 * 功能描述：通用查询action
 * 创建人：赵梓廷
 * 创建记录： 2013-08-14
 * 修改记录：
 */
public class IGSMR0305Action extends BaseAction {

	static Log log = LogFactory.getLog(IGSMR0305Action.class);
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//form取得
		IGSMR0304Form form = (IGSMR0304Form)actionForm;
		//BL取得
		IGSMR03BL ctlBL = (IGSMR03BL) getBean("igSMR03BL");	
		//报表导出BL取得
        IGPDF01BL igPDF01BL = (IGPDF01BL) getBean("igPDF01BL");
		//DTO生成
		IGSMR03DTO dto = new IGSMR03DTO();								
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);		
		dto.setUser(user);						
		String forward = "DISP";
		if("DISP".equals(mapping.getParameter())){
			//将form放进dto中
			dto.setIgsmr0304Form(form);
			getPaginDTO(request,"IGSMR0305");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			int maxCnt = getMaxDataCount("IGSMR0305");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto = ctlBL.init0305Action(dto);
			IGSMR03051VO vo = new IGSMR03051VO();
			vo.setList_rhs(dto.getList_rhs());
			super.<IGSMR03051VO>setVO(request, vo);
		}
		
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========报表查询处理开始========");
			//将form放进dto中
			dto.setIgsmr0304Form(form);
			
			//获取分页Bean
			getPaginDTO(request,"IGSMR0305");

			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGSMR0304Form) request.getSession().getAttribute("IGSMR0304Form");
				if ( form== null){
					form = new IGSMR0304Form();
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
					form = (IGSMR0304Form) request.getSession().getAttribute("IGSMR0304Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGSYM0305");
			
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto = ctlBL.init0305Action(dto);
			IGSMR03051VO vo = new IGSMR03051VO();
			vo.setList_rhs(dto.getList_rhs());
			super.<IGSMR03051VO>setVO(request, vo);
					
			log.debug("========报表查询处理终了========");
		}else if("EXPORT".equals(mapping.getParameter())){
			log.debug("========PDF导出处理开始========");
			Integer[] prids = form.getPrids();
            String[] prpdids = form.getPrpdids();
            List<String> fileNames = new ArrayList<String>();
            // 导出pdf报表文件
            for (int i = 0; i < prids.length; i++) {
                String fileName = igPDF01BL.createPdf(prpdids[i], prids[i]);
                fileNames.add(fileName);
            }
            // 打包下载报表文件
            igPDF01BL.toZipAndDownload(fileNames, response);
            forward = "DISPONSE";
			log.debug("========PDF导出处理结束========");
			return null;
		}
		return mapping.findForward(forward);
	}

}
