package com.deliverik.infogovernor.drm.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
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
import com.deliverik.infogovernor.drm.bl.IGDRM04BL;
import com.deliverik.infogovernor.drm.dto.IGDRM04DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0412Form;
import com.deliverik.infogovernor.drm.vo.IGDRM04021VO;
import com.deliverik.infogovernor.drm.vo.IGDRM04121VO;
import com.google.gson.Gson;

/**
 * 类型基本信息编辑画面Action处理
 *
 */
public class IGDRM0412Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0412Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGDRM0412Form form = (IGDRM0412Form)actionForm;
		
		//BL取得
		IGDRM04BL ctlBL = (IGDRM04BL) getBean("igdrm04BL");
		
		//DTO生成
		IGDRM04DTO dto = new IGDRM04DTO();
		
		//画面跳转设定
		String forward = null;
		//获取发起角色列表
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		if( "DISP".equals(mapping.getParameter())){
			//类型登记画面初期显示处理
			log.debug("========类型登记画面初期显示处理开始========");
			req.setAttribute("IGDRM0412Form", new IGDRM0412Form());
			
			addMessage(req, new ActionMessage("IGCO10000.I001","分类基本信息"));
			log.debug("========类型登记画面初期显示处理终了========");
			saveToken(req);
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//类型登记画面再显示处理
			log.debug("========类型登记画面再显示处理开始========");
			
			dto.setIgdrm0412Form(form);
			saveToken(req);
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========类型登记画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "INSERT".equals(mapping.getParameter())){
			//类型编辑处理
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//类型登记画面按下返回按钮时的返回处理
				if (form.getMode().equals("1")){
					//返回类型查询画面
					return mapping.findForward("BACK");
				}
			}
			
			if (form.getMode().equals("0")){
				//类型登记处理
				log.debug("========类型登记处理开始========");
				
				//DTO输入参数设定
				dto.setEntity(form);
				dto.setIgdrm0412Form(form);
				
				if (isTokenValid(req, true)){
				//类型信息登记逻辑调用
					dto = ctlBL.insertEntityAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				//将登记完了的类型信息设定到VO中
				IGDRM04121VO vo = new IGDRM04121VO(dto.getEntity());
				
				super.<IGDRM04121VO>setVO(req.getSession(), vo);
				
				log.debug("========类型登记处理终了========");
				
				forward = "DISP";
				
			} else {
				//类型变更处理
				log.debug("========类型基本信息变更处理开始========");
				
				//DTO输入参数设定
				dto.setEntity(form);
				dto.setIgdrm0412Form(form);
				
				//类型信息变更逻辑调用
				dto = ctlBL.updateEntityAction(dto);
				
				log.debug("========类型基本信息变更处理终了========");
				
				forward = "BACK";
			}
		}
		if ("EDIT".equals(mapping.getParameter())){
			log.debug("========类型基本信息变更初期显示处理开始========");
			dto.setIgdrm0412Form(form);
			
			dto = ctlBL.initIGDRM0412Action(dto);
			
			log.debug("========类型基本信息变更初期显示处理终了========");

			forward = "DISP";
		}
		if ("TREE".equals(mapping.getParameter())){
			log.debug("========应急资源树处理开始========");
			if(!"allTree".equals(form.getEsyscoding())){
				dto.setRootEsyscoding("000");
			}else{
				dto.setRootEsyscoding("allTree");
			}
			dto = ctlBL.initNewNodeMap(dto);
			IGDRM04021VO vo = new IGDRM04021VO();
			Gson g = new Gson();
			vo.setNodeMapJson(g.toJson(dto.getNodeMap()));
			super.<IGDRM04021VO>setVO(req, vo);
			log.debug("========应急资源树处理终了========");
			forward = "DISP";
		}
		if ("AJAXCONFIG".equals(mapping.getParameter())){
			log.debug("========获得资产属性处理开始========");
			dto.setIgdrm0412Form(form);
			PrintWriter out = null;
			try {
				String result = ctlBL.getConfigList(dto);
                out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
                out.print(result);
            } catch (Exception e) {
                log.error("AjaxAction Exception", e);
            } finally {
                if (out != null){
                    out.close();
                }
            }
			forward = "null";
			
			log.debug("========获得资产属性处理终了========");
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
