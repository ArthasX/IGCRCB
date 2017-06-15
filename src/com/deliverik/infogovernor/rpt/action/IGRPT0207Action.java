/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.rpt.bl.task.SOC0205BL;
import com.deliverik.infogovernor.rpt.dto.IGRPT02DTO;
import com.deliverik.infogovernor.rpt.form.IGRPT0207Form;
import com.deliverik.infogovernor.rpt.model.SOC0205Info;
import com.deliverik.infogovernor.rpt.vo.IGRPT02071VO;

/**
 * 概述: 报告管理附加报表处理Action
 * 创建记录:杨龙全 2012/06/14
 * 修改记录: 
 */
public class IGRPT0207Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGRPT0207Action.class);
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse resp) throws Exception {
		IGRPT0207Form form=(IGRPT0207Form) actionForm;
		//DTO生成
		IGRPT02DTO dto = new IGRPT02DTO();
		User user = (User) req.getSession().getAttribute(
				SESSION_KEY_LOGIN_USER);
		dto.setCurUser(user);
		dto.setIgrpt0207Form(form);
		if("DOWN".equals(mapping.getParameter())){
			log.debug("========Report down is run======");
			SimpleDateFormat noFormat=new SimpleDateFormat("yyyyMMdd_HHmmss");
			SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			//文件名字
			String realFileName = "";
			String showFileName="";
			//获取文件id
			
			String rmId = req.getParameter("rmId");
			String rootPath = ResourceUtility.getString("REPORT_WORD_PATH");

			// 报告管理BL取得
			SOC0205BL soc0205BL = (SOC0205BL)getBean("soc0205BL");
			//获取报告对象
			SOC0205Info rmInfo=soc0205BL.searchSOC0205ByPK(Integer.parseInt(rmId));
			//报告名字取得
			String fileName = rmInfo.getCreateDate();
			showFileName=rmInfo.getRmName()+rmInfo.getRmSuffix();
			try {
				realFileName = rootPath+rmInfo.getRmId()+"_"+noFormat.format(dateFormat.parse(fileName))+rmInfo.getRmSuffix();
			} catch (ParseException e) {
				log.error("IGRPT0307Action_Down Exception", e);
			}
			//文件存在检测
			File objFile = new File(realFileName);
			if (!objFile.exists()) {
				addMessage(req,new ActionMessage("IGRPT0107.E002"));
				return mapping.findForward("ERROR");
			}
			//文件下载处理
			resp.reset();
			resp.setContentType("application/x-download;");
			try {
				resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(showFileName, "UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			// 输出流
			OutputStream output = null;
			// 输入流
			FileInputStream input = null;
			try {
				// 输出流取得
				output = resp.getOutputStream();
				// 输入流取得
				input = new FileInputStream(objFile);
				int actual = 0;
				byte[] b = new byte[1024];
				
				while ((actual = input.read(b)) > 0) {
					output.write(b,0,actual);
				}
				output.flush();
			} catch (Exception e) {
				String simplename = e.getClass().getSimpleName(); 
				if(!"ClientAbortException".equals(simplename)){      
					log.error("IGRPT0307Action_Down Exception", e);  
				} 
			} finally {
				// 关闭输入流
				if(input!=null){
					input.close();
					input = null;
				}
				// 关闭输出流
				try {
					if(output!=null){
						output.close();
						output = null;
					}
				} catch (Exception e) {
					String simplename = e.getClass().getSimpleName();      
					if(!"ClientAbortException".equals(simplename)){      
						log.error("IGRPT0307Action_Down Exception", e);  
					} 
				}
			}
			List<ActionMessage> messageList = dto.getMessageList();
			if (messageList != null && messageList.size() > 0) {
				for (ActionMessage message : messageList) {
					addMessage(req, message);
				}
			}
			log.debug("========Report down is end======");
			return null;
		}
		IGRPT02071VO igrpt01071vo=new IGRPT02071VO();
		//设置vo
		igrpt01071vo.setReportName(dto.getReportName());
		igrpt01071vo.setReportAnnexationList(dto.getRaInfoList());
		//放入vo
		super.<IGRPT02071VO>setVO(req, igrpt01071vo);
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
