package com.deliverik.infogovernor.drm.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.drm.bl.IGDRM21BL;
import com.deliverik.infogovernor.drm.dto.IGDRM21DTO;
import com.deliverik.infogovernor.drm.form.IGDRM2102Form;
import com.deliverik.infogovernor.drm.vo.IGDRM21021VO;
import com.google.gson.Gson;

/**
 * 预案登记Action
 *
 * @author
 */
public class IGDRM2102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM2102Action.class);

	/**
	 * 预案登记
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
		IGDRM2102Form form = (IGDRM2102Form)actionForm;
		
		//BL取得
		IGDRM21BL ctlBL = (IGDRM21BL) getBean("igdrm21BL");
		
		//DTO生成
		IGDRM21DTO dto = new IGDRM21DTO();
		
		//画面跳转设定
		String forward = null;

		HashMap<String, String> contextTypeMap = new HashMap<String, String>();
		contextTypeMap.put("gif", "image/bmp");
		contextTypeMap.put("jpg", "image/jpg");
		contextTypeMap.put("jpeg", "image/jpeg");
		contextTypeMap.put("png", "image/png");
		contextTypeMap.put("txt", "text/plain");
		contextTypeMap.put("xml", "text/xml");
		contextTypeMap.put("xls", "application/msexcel");
		contextTypeMap.put("xlsx", "application/msexcel");
		contextTypeMap.put("doc", "application/msword");
		contextTypeMap.put("docx", "application/msword");
		contextTypeMap.put("ppt", "application/mspowerpoint");

		if("DISP".equals(mapping.getParameter())){
			//设备登记画面初期显示处理
			log.debug("========设备登记画面初期显示处理开始========");
			
			dto.setForm(form);
			
			dto = ctlBL.getPlanSectionTree(dto);
			
			dto = ctlBL.initPlanInfo4Create(dto);
			
			IGDRM21021VO vo = new IGDRM21021VO();
			Gson gson = new Gson();
			String json = gson.toJson(dto.getPlanSectionTree());
			vo.setPlanSectionTreeJson(json);
			vo.setEntityItemVWInfo(dto.getEntityItemVWInfo());
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			super.<IGDRM21021VO>setVO(req.getSession(), vo);
			log.debug("========设备登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} 
		
		if("VIEW".equals(mapping.getParameter())){
			//设备登记画面初期显示处理
			log.debug("========设备登记画面初期显示处理开始========");
			
			dto.setForm(form);
			
			dto = ctlBL.getPlanSectionTree(dto);
			
			dto = ctlBL.initPlanInfo4Create(dto);
			
			dto = ctlBL.loadAllReservePlan(dto);
			
			IGDRM21021VO vo = new IGDRM21021VO();
			Gson gson = new Gson();
			String json = gson.toJson(dto.getPlanSectionTree());
			vo.setTreeMap(dto.getTreeMap());
			vo.setPlanSectionTreeJson(json);
			vo.setEntityItemVWInfo(dto.getEntityItemVWInfo());
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			super.<IGDRM21021VO>setVO(req.getSession(), vo);
			log.debug("========设备登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if ("FILE".equals(mapping.getParameter())) {
			String fileName = req.getParameter("fileName");
			// 文件类型
			String type = req.getParameter("type");
			if (StringUtils.isNotEmpty(fileName) && contextTypeMap.get(type) != null) {
				String labelName = req.getParameter("labelName");
				// 文件二级目录
				String dirName = req.getParameter("dirName");
				if (StringUtils.isNotEmpty(labelName)) {
					labelName = URLDecoder.decode(labelName, "utf8");
					res.setHeader("Content-disposition", "attachment; filename=" + new String(labelName.getBytes("gb2312"), "8859_1"));
				}else{
					res.setHeader("Content-disposition", "attachment; filename=" + new String("附件".getBytes("gb2312"), "8859_1") + "." + type);
				}
				res.setContentType(contextTypeMap.get(type));

				String dir = ResourceUtility.getString("PALN_ATTA") + dirName + "/" + fileName;
				File file = new File(dir);
				 InputStream reader = null;
				int len = 0;
				OutputStream out = res.getOutputStream();
		        byte[] bytes = new byte[1024];
				if (file.exists()&&file.canRead()) {
					reader = new FileInputStream(file.getPath());
					while ((len = reader.read(bytes)) > 0) {
						out.write(bytes, 0, len);
					}
				}

			}
			return null;
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward(forward);
	}
}
