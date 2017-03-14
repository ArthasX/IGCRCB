package com.deliverik.infogovernor.kgm.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

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
import com.deliverik.infogovernor.kgm.bl.IGKGM02BL;
import com.deliverik.infogovernor.kgm.dto.IGKGM03DTO;
import com.deliverik.infogovernor.kgm.form.IGKGM0228Form;
import com.deliverik.infogovernor.kgm.vo.IGKGM02011VO;

public class IGKGM0228Action extends BaseAction{

	static Log log = LogFactory.getLog(IGKGM0228Action.class);
	
	/**
	 * 知识批量导出
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORM取得
		IGKGM0228Form form = (IGKGM0228Form)actionForm;
		
		//BL取得
		IGKGM02BL ctlBL = (IGKGM02BL) getBean("igkgm02BL");
		
		//DTO生成
		IGKGM03DTO dto = new IGKGM03DTO();
		
		if( "REPORT".equals(mapping.getParameter())){
	    	

			//知识查询处理
			log.debug("========知识查询处理开始========");
            
			//DTO输入参数设定
			dto.setIgkgm0228Form(form);
			
			//知识信息检索逻辑调用
			dto = ctlBL.exportKnowLedgeAction(dto);
			
			//将知识类型信息检索结果设定到VO中
			IGKGM02011VO vo = new IGKGM02011VO();
			vo.setKnowledgeList(dto.getKnowledgelist());
			
			req.setAttribute("vo", vo);
			req.setAttribute("form", form);
			
			log.debug("========知识查询处理终了========");
			
	    }else if("DOWN".equals(mapping.getParameter())){
	    	
	    	log.debug("========知识下载处理开始========");
	    	dto.setSessionID(req.getSession().getId());
	    	dto = ctlBL.downKnowLedgeAction(dto);
			req.setAttribute("form", form);
			
			//文件存在检测
			String sFileName = ResourceUtility.getString("HTML_FILE_ROOT_PATH")+"allKnowledge.zip";
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
			log.debug("========知识下载处理终了========");
			return null;
	    }
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		return mapping.findForward("DISP");
	}
}
