package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM16BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM16DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1632Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM16321VO;

/**
 * 密码关联关系画面Action处理
 *
 */
public class IGCIM1632Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM1632Action.class);

	/**
	 * 事件处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
				IGCIM1632Form form = (IGCIM1632Form)actionForm;
				
				//BL取得
				IGCIM16BL ctlBL = (IGCIM16BL) getBean("igcim16BL");
				
				//DTO生成
				IGCIM16DTO dto = new IGCIM16DTO();
				dto.setLocale(this.getLocale(req));
				//画面跳转设定
				String forword = null;
				
				if( "DISP".equals(mapping.getParameter()) || "REDISP".equals(mapping.getParameter())){
					//设备关系管理画面初期显示处理
					log.debug("========密码关系管理画面初期显示处理开始========");
					if ("REDISP".equals(mapping.getParameter())){
						form = (IGCIM1632Form) req.getSession().getAttribute("IGCIM1632Form");
					}
					
					//查询记录最大件数取得
					int maxCnt = getMaxDataCount("IGCIM1632");
					
					//DTO输入参数设定
					dto.setIgcim1632Form(form);
					
					dto.setMaxSearchCount(maxCnt);
					User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
					
					dto.setUser(user);
					dto = ctlBL.initIGCIM1632BelongAction(dto);
					
					//将类型关系管理信息检索结果设定到VO中
					IGCIM16321VO vo = new IGCIM16321VO();
					
					vo.setEntityItemData(dto.getSoc0124Info());
					
					//返回查看资产配置信息权限标识
					vo.setFlag(dto.getFlag());
					vo.setEiorgname(dto.getEiorgname());
					//设置依赖关系列表
					vo.setSoc0119List(dto.getSoc0119List());
					super.<IGCIM16321VO>setVO(req.getSession(), vo);
					saveToken(req);
					log.debug("========密码关系管理画面初期显示处理终了========");
					
					forword = "DISP";
				}
				
				
				
				
				
				if ("DELETE".equals(mapping.getParameter())){
					//设备关系删除处理
					log.debug("========设备关系删除处理开始========");
					
					form.getEiid();
					
					//DTO输入参数设定
					dto.setDeleteEntityItemRelation(form.getDeleteEirid());
					
					dto = ctlBL.delRelation(dto);
					
					log.debug("========设备关系删除处理终了========");
					
					
					forword = "DISP";
				}

				//逻辑处理过程中的信息显示
				List<ActionMessage> messageList = dto.getMessageList();
				
				if( messageList != null && messageList.size() > 0 ) {
					for (ActionMessage message : messageList) {	
						addMessage(req, message);
					}
					
				}

				return mapping.findForward(forword);
			}
}
