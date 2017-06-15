package com.deliverik.infogovernor.drm.action;

import java.io.PrintWriter;
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
import com.deliverik.infogovernor.drm.bl.IGDRM21BL;
import com.deliverik.infogovernor.drm.dto.IGDRM21DTO;
import com.deliverik.infogovernor.drm.form.IGDRM2103Form;
import com.deliverik.infogovernor.drm.vo.IGDRM21041VO;
import com.google.gson.Gson;

/**
 * 预案详细信息登记Action
 *
 * @author
 */
public class IGDRM2103Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM2103Action.class);

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
		IGDRM2103Form form = (IGDRM2103Form)actionForm;
		
		//BL取得
		IGDRM21BL ctlBL = (IGDRM21BL) getBean("igdrm21BL");
		
		//DTO生成
		IGDRM21DTO dto = new IGDRM21DTO();
		
		dto.setForm(form);
		//画面跳转设定
		String forward = null;

		if("DISP".equals(mapping.getParameter())){
			//设备登记画面初期显示处理
			log.debug("========设备登记画面初期显示处理开始========");
			String cattach = req.getParameter("cattach");
			String view = req.getParameter("view");
			//view 不为空即为查看
			if(StringUtils.isNotBlank(view)){
				if("0".equals(cattach)){
					ctlBL.initUeditorInfo(dto);
					form.setViewMode("1");
					return mapping.findForward("UEDITOR");
				}
				if("1".equals(cattach)){
					ctlBL.viewStoryboardInfo(dto);
					return mapping.findForward("STORYBOARD");
				}
				if("2".equals(cattach)){
					return mapping.findForward("FRAMEWORK");
				}
			}else{//新增或修改
				if("0".equals(cattach)){
					ctlBL.initUeditorInfo(dto);
					return mapping.findForward("UEDITOR");
				}
				if("1".equals(cattach)){
					ctlBL.initStoryboardInfo(dto);
					IGDRM21041VO vo = new IGDRM21041VO();
					vo.setPlanList(dto.getPlanList());
					super.<IGDRM21041VO>setVO(req, vo);
					return mapping.findForward("STORYBOARD");
				}
				if("2".equals(cattach)){
					// res.setContentType("text/html");
					// res.setCharacterEncoding("utf-8");
					// IGDRM2108Form ig2108Form = new IGDRM2108Form();
					// ig2108Form.setPlanEiid(Integer.valueOf(form.getEiid()));
					// dto.setForm(ig2108Form);
					// ctlBL.loadPlanOrgHTML(dto);
					// PrintWriter writer = res.getWriter();
					//
					// writer.write("<style>.table_style{	width:95% !important;}.table_style4{width:95%; 	border-collapse:collapse;	border:1px solid #959499;    text-align:left;"
					// +
					// "margin-top:10px;} .table_style4 td{border:1px solid #959499;text-indent: 0px;}.table_style4 th{text-align: left;	text-indent: 0px;}.td_style4 {	border:0px;}</style>"
					// + dto.getResultHTML());
					req.setAttribute("ctype", cattach);
					req.setAttribute("cid", form.getCid());
					req.setAttribute("planEiid", form.getEiid());

					return mapping.findForward("FRAMEWORK");
				}
			}
			log.debug("========设备登记画面初期显示处理终了========");
		} 

		if("INSERT".equals(mapping.getParameter())){
			String content = req.getParameter("content");
			String ciid = req.getParameter("ciid");
			dto.setContent(content);
			//更新
			if(StringUtils.isNotBlank(ciid)){
				int ciid_int = Integer.parseInt(ciid);
				dto.setCiid(ciid_int);
				form.setCiid(ciid_int);
				ctlBL.updatePlanInfoContent(dto);
			}else{//新增
				ctlBL.savePlanInfoContent(dto);
			}
			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");
	        PrintWriter out = res.getWriter();
	        Gson gson = new Gson();
        	out.write(gson.toJson("保存成功"));
        	out.flush();
            out.close();
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
