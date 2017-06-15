package com.deliverik.infogovernor.soc.cim.action;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM20BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM20DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM2001Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM20011VO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;

/**
 * 网络设备登记处理ACTION
 *
 */
public class IGCIM2001Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM2001Action.class);

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
				IGCIM2001Form form = (IGCIM2001Form)actionForm;
				
				//BL取得
				IGCIM20BL ctlBL = (IGCIM20BL) getBean("igcim20BL");
				
				//DTO生成
				IGCIM20DTO dto = new IGCIM20DTO();
				
				dto.setLocale(this.getLocale(req));
				
				//画面跳转设定
				String forward = null;
		
				if( "DISP".equals(mapping.getParameter())){
					//网络设备登记画面初期显示处理
					log.debug("========网络设备登记画面初期显示处理开始========");
					form = new IGCIM2001Form();
					
					Date nowDateTime = new Date();
					String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
					
					form.setEiinsdate(date);

					dto.setIgcim2001Form(form);
					
					dto = ctlBL.searchEntityItemLableAction(dto);

					IGSYM03DTO sym03dto = new IGSYM03DTO();
					IGSYM03BL treeBL = (IGSYM03BL) getBean("igsym03BL");
					sym03dto = treeBL.getRoleDomainTree(sym03dto);
					Map<String,TreeNode> treeNodeMap = sym03dto.getTreeNodeMap();
					if(treeNodeMap!=null&&!treeNodeMap.isEmpty()){			
						if(treeNodeMap.keySet()!=null&&!treeNodeMap.keySet().isEmpty()){
								Iterator<String> it=treeNodeMap.keySet().iterator();
								while(it.hasNext()){
									Object obj = it.next();
									String key=(String)obj;	
									TreeNode treeNode=treeNodeMap.get(key);
									if(ResourceUtility.getString("XB_QB").equals(treeNode.getId())){
										req.setAttribute("deforgsys", treeNode.getId());
										req.setAttribute("deforgname", treeNode.getName());
										break;
									}
								}
								
						}
					}
					req.setAttribute("IGCIM2001Form", form);
					
					addMessage(req, new ActionMessage("IGCO10000.I001","设备基本信息"));
					log.debug("========网络设备登记画面初期显示处理终了========");
					return mapping.findForward("DISP");
				}
				if( "INSERT".equals(mapping.getParameter())){
					//设备编辑处理
					if (form.getMode().equals("0")){
						//设备登记处理
						log.debug("========设备登记处理开始========");
						
						User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
						
						form.setEiuserid(user.getUserid());
						
						form.setEiusername(user.getUsername());
						
						//DTO输入参数设定
						dto.setIgcim2001Form(form);
						
						//设备信息登记逻辑调用
						dto = ctlBL.insertEntityItemAction(dto);
						
						//将登记完了的设备信息设定到VO中
						IGCIM20011VO vo = new IGCIM20011VO(dto.getIgcim2001Form());
						
						super.<IGCIM20011VO>setVO(req.getSession(), vo);
						
						log.debug("========网络设备登记处理终了========");
						
						forward = "DISP";

					}
				}
				
				if("RESULT".equals(mapping.getParameter())){
					if (req.getParameter("btn_add_conf")!=null) {
						//设备配置信息添加画面跳转
						saveToken(req);
						log.debug("========配置信息添加========");
						return mapping.findForward("CONF");
					}
					if (req.getParameter("btn_back")!=null) {
						//设备基本信息添加画面跳转
						log.debug("========基本信息添加========");
						return mapping.findForward("BACK");
					}
				}
		
				List<ActionMessage> messageList = dto.getMessageList();
				
				if( messageList != null && messageList.size() > 0 ) {
					for (ActionMessage message : messageList) {	
						addMessage(req, message);
					}
					
				}

				return mapping.findForward("DISP");
	}
}
