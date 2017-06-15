/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.vir.bl.IGVIR30BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR30DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR3003Form;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR30031VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:自动部署进度显示Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR3003Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGVIR3003Action.class);
		//BL取得
		IGVIR30BL ctlBL = (IGVIR30BL) getBean("igvir30BL");
		//实例化dto
		IGVIR30DTO dto = new IGVIR30DTO();
		//form取得
		IGVIR3003Form form = (IGVIR3003Form) actionForm;
		//登陆用户取得
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//dto参数设定
		dto.setIgvir3003Form(form);
		dto.setUser(user);
		//自动部署进度页面显示
		if("DISP".equals(mapping.getParameter())){
			log.debug("===========自动部署进度页面初始化操作开始============");
			dto = ctlBL.getApplyVMListAction(dto);
			//实例化vo
			IGVIR30031VO vo = new IGVIR30031VO();
			vo.setVcd03List(dto.getVcd03List());
			vo.setPid(dto.getPid());
			super.<IGVIR30031VO>setVO(request, vo);
			log.debug("===========自动部署进度页面初始化操作结束============");
		}
		//自动部署进度
		if("GETPROGRESS".equals(mapping.getParameter())){
			log.debug("========自动部署进度数据查询操作开始=======");
			PrintWriter out = null;
            try {
            	out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
	        	dto = ctlBL.getApplyVMDataListAction(dto);
	        	out.print(dto.getJsonResult());
            } catch (Exception e) {
                out.print("");
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null)
                    out.close();
            }
			log.debug("========自动部署进度数据查询操作结束=======");
		}
		return mapping.findForward("DISP");
	}

}
