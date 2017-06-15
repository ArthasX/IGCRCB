/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.smr.bl.IGSMR08BL;
import com.deliverik.infogovernor.smr.dto.IGSMR08DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0801Form;
import com.deliverik.infogovernor.smr.vo.IGSMR08011VO;
import com.deliverik.infogovernor.xls.smr.bl.IGSMR0801ExcelBL;
import com.deliverik.infogovernor.xls.smr.bl.IGSMR0802ExcelBL;
import com.deliverik.infogovernor.xls.smr.dto.IGSMR0801ExcelDTO;
import com.deliverik.infogovernor.xls.smr.dto.IGSMR0802ExcelDTO;

/**
 * 概述:填报考核 
 * 功能描述：填报考核 
 * 创建人：赵梓廷
 * 创建记录： 2013-09-02
 * 修改记录：
 */
public class IGSMR0801Action extends BaseAction {
	
	 /** 按机构考核导出模板标识 */
    private static final String IG_SMR_MODE1 = "SMR0801G";
    
	 /** 按人员考核导出模板标识 */
    private static final String IG_SMR_MODE2 = "SMR0801U";
	
	static Log log = LogFactory.getLog(IGSMR0801Action.class);
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGSMR0801Form form = (IGSMR0801Form)actionForm;
						
		//BL取得
		IGSMR08BL ctlBL = (IGSMR08BL) getBean("igSMR08BL");
						
		//DTO生成
		IGSMR08DTO dto = new IGSMR08DTO();
		String forward = "DISP";
		if("DISP".equals(mapping.getParameter())){
			log.debug("填报考核初始化开始！");
			
			log.debug("填报考核初始化结束！");
		}
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("填报考核处理开始！");
			//将form放进dto中
			dto.setIgsmr0801Form(form);
			//实例化vo
			IGSMR08011VO vo = new IGSMR08011VO();
			//判断form中类型的值，如果是1，按机构查询，如果是2 按人员查询
			if("1".equals(form.getAssesstype())){
				dto = ctlBL.initSMR0801ByOrgAction(dto);				
				vo.setList(dto.getList());
				vo.setOrgsum(dto.getOrgsum());
			}
			if("2".equals(form.getAssesstype())){
				dto = ctlBL.initSMR0801ByUserAction(dto);
				vo.setMap(dto.getMap());
				vo.setUsersum(dto.getUsersum());
			}
			super.<IGSMR08011VO>setVO(req, vo);
			forward = "SEARCH";
			log.debug("填报考核处理结束！");
		}
       
        if("EXPORT".equals(mapping.getParameter())){
        	log.debug("填报考核按机构考核导出开始！");
            //把form里面的数据放进dto里
        	dto.setIgsmr0801Form(form);			
			//判断form中类型的值，如果是1，按机构查询，如果是2 按人员查询
			if("1".equals(form.getAssesstype())){
				IGSMR0801ExcelDTO excelDTO = new IGSMR0801ExcelDTO(); 
				//将考核时间放进dto中
				excelDTO.setAssessstartdate(form.getAssessstartdate());
				excelDTO.setAssessoverdate(form.getAssessoverdate());
				//调用BL方法按条件查询返回dto
				dto = ctlBL.initSMR0801ByOrgAction(dto);
				  //将查询结果放进dto中
				excelDTO.setList(dto.getList());
				excelDTO.setOrgsum(dto.getOrgsum());          
	            // 设置输出流
	            excelDTO.setResponse(res);
	            // 设置模板标识
	            excelDTO.setFileid(IG_SMR_MODE1); 
	            // 报表导出处理
	            IGSMR0801ExcelBL excelBL = (IGSMR0801ExcelBL) getBean("igsmr0801ExcelBL");
	            excelBL.initExcel(excelDTO);
			}
            if("2".equals(form.getAssesstype())){
            	//调用BL方法按条件查询返回dto
    			dto = ctlBL.initSMR0801ByUserAction(dto);
    			IGSMR0802ExcelDTO excelDTO = new IGSMR0802ExcelDTO();  
    			//将考核时间放进dto中
    			excelDTO.setAssessstartdate(form.getAssessstartdate());
    			excelDTO.setAssessoverdate(form.getAssessoverdate());
    			 //将查询结果放进dto中
    			excelDTO.setMap(dto.getMap());
    			excelDTO.setUsersum(dto.getUsersum());          
                // 设置输出流
                excelDTO.setResponse(res);
                // 设置模板标识
                excelDTO.setFileid(IG_SMR_MODE2);          
                // 报表导出处理
                IGSMR0802ExcelBL excelBL = (IGSMR0802ExcelBL) getBean("igsmr0802ExcelBL");
                excelBL.initExcel(excelDTO);
            }                    
            log.debug("填报考核导出结束！");
            return null;        	
        }
		return mapping.findForward(forward);
	}

}
