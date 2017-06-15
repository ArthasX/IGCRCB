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
import com.deliverik.infogovernor.soc.vir.bl.IGVIR10BL;
import com.deliverik.infogovernor.soc.vir.dto.IGVIR10DTO;
import com.deliverik.infogovernor.soc.vir.form.IGVIR1006Form;
import com.deliverik.infogovernor.soc.vir.vo.IGVIR10061VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 虚拟化用户首页Action
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGVIR1006Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGVIR1006Action.class);
		//BL取得
		IGVIR10BL ctlBL = (IGVIR10BL) getBean("igvir10BL");
		//实例化dto
		IGVIR10DTO dto = new IGVIR10DTO();
		//用户对象取得
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//form取得
		IGVIR1006Form form = (IGVIR1006Form) actionForm;
		//dto参数设定
		dto.setUser(user);
		dto.setVmname(form.getVmname());
		dto.setPowerState(form.getPowerState());
		dto.setVcid(form.getVcid());
		if("DISP".equals(mapping.getParameter())){
			log.debug("==================虚拟化用户首页初始化操作开始==================");
			dto = ctlBL.initUserHomePageAction(dto);
			//实例化vo
			IGVIR10061VO vo = new IGVIR10061VO();
			vo.setMyOpenProcessList(dto.getMyOpenProcessList());
			vo.setOwnVMList(dto.getVmList());
			vo.setTemplateList(dto.getTemplateList());
			super.<IGVIR10061VO>setVO(request, vo);
			log.debug("==================虚拟化用户首页初始化操作结束==================");
		}
		if("CHANGEVM".equals(mapping.getParameter())){
			log.debug("================改变虚机状态操作开始================");
			dto = ctlBL.changeVMAction(dto);
			PrintWriter out = null;
            try {
                out = new PrintWriter(new OutputStreamWriter(response.getOutputStream(), "utf-8"));
                out.print("success");
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
			log.debug("================改变虚机状态操作结束================");
			return null;
		}
		return mapping.findForward("DISP");
	}

}
