/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prj.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.prj.bl.IGPRJ01BL;
import com.deliverik.infogovernor.prj.dto.IGPRJ01DTO;
import com.deliverik.infogovernor.prj.form.IGPRJ0101DetailForm;
import com.deliverik.infogovernor.prj.vo.IGPRJ0101VO;
import com.deliverik.infogovernor.xls.prj.bl.IGPRJ0108ExcelBL;
import com.deliverik.infogovernor.xls.prj.dto.IGPRJ0108ExcelDTO;

/**
 * 概述: 项目日志导出Action处理
 * 功能描述：项目日志导出Action处理
 * 修改记录：
 */

public class IGPRJ0108Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRJ0108Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//获取BL接口实例
		IGPRJ01BL ctlBL = (IGPRJ01BL) getBean("igprj01BL");
		//DTO生成
		IGPRJ01DTO igprj01dto = new IGPRJ01DTO();
		//实例化FORM
		IGPRJ0101DetailForm  form = (IGPRJ0101DetailForm)actionForm;
		if("EXPORT".equals(mapping.getParameter())){
			igprj01dto.setProjectId(form.getPid().toString());
			 log.debug("========项目日志下载处理开始========");
			//查询项目日志
			igprj01dto = ctlBL.findAllProject(igprj01dto);
			// 报表导出DTO
			IGPRJ0108ExcelDTO excelDTO = new IGPRJ0108ExcelDTO();
			// 设置输出流
			//excelDTO.setResponse(res);
			// 设置模板标识
			excelDTO.setFileid("PRJ0108");
			// 设置导出数据
			excelDTO.setHistoryVOs(igprj01dto.getHistoryVOs());
			excelDTO.setCodeDetailList(igprj01dto.getCodeDetailList());
			// 模板导出处理
			IGPRJ0108ExcelBL excelBL = (IGPRJ0108ExcelBL) getBean("igprj0108ExcelBL");
			excelBL.initExcelToDownZip(excelDTO);
	       
	        req.setAttribute("form", form);
			
			//文件存在检测
			String sFileName = ResourceUtility.getString("HTML_FILE_ROOT_PATH")+"projectLog.zip";
			File objFile = new File(sFileName);
			
			if (!objFile.exists()) {
				addMessage(req,new ActionMessage("IGCO10000.E009"));
				return mapping.findForward("ERR");
			}
			//文件下载处理
			res.reset();
			res.setContentType("application/x-download;");
			try {
				String filename = "";
				filename = objFile.getName().substring(objFile.getName().indexOf("_")+1);
				
				res.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				log.debug("Exception:", e1);
			}
			
			// 输出流
			OutputStream output = null;
			// 输入流
			FileInputStream input = null;
			try {
				// 输出流取得
				output = res.getOutputStream();
				// 输入流取得
				input = new FileInputStream(sFileName);
				int actual = 0;
				byte[] b = new byte[1024];
				
				while ((actual = input.read(b)) > 0) {
					output.write(b,0,actual);
				}

				output.flush();
			} catch (Exception e) {
				log.error("DownloadAction Exception", e);
			} finally {
				try {
					// 关闭输入流
					input.close();
					input = null;
					// 关闭输出流
					output.close();
					output = null;
				} catch (Exception e) {
					log.error("DownloadAction Exception", e);
				}
			}
			log.debug("========项目日志下载处理终了========");
	        return null;
		}else if("SEARCH".equals(mapping.getParameter())){
			log.debug("========项目日志类别查询详细信息处理终了========");
			igprj01dto.setPlid(form.getPlid());
			igprj01dto.setProjectType(form.getPltype());
			igprj01dto.setProjectId(String.valueOf(form.getPid()));
			igprj01dto = ctlBL.searchProjectLogTypeMessage(igprj01dto);
			IGPRJ0101VO vo = new IGPRJ0101VO();
			if(igprj01dto.getPlcList()!=null){				
				vo.setPlcList(igprj01dto.getPlcList());
				vo.setPbsummaryList(igprj01dto.getPbsummaryList());
			}
			if(igprj01dto.getPlbList()!=null){
				vo.setPlbList(igprj01dto.getPlbList());
			}
			super.<IGPRJ0101VO>setVO(req, vo);
			log.debug("========项目日志类别查询详细信息处理终了========");
		}
		return mapping.findForward("DISP");
	}

}
