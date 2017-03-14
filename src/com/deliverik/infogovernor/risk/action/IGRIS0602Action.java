package com.deliverik.infogovernor.risk.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
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
import com.deliverik.infogovernor.risk.bl.IGRIS06BL;
import com.deliverik.infogovernor.risk.dto.IGRIS06DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0602Form;
import com.deliverik.infogovernor.risk.vo.IGRIS06021VO;
import com.deliverik.infogovernor.risk.vo.IGRIS06022VO;
import com.deliverik.infogovernor.risk.vo.IGRIS06071VO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;

/**
 * 检查项编辑画面Action处理
 *
 * @author
 */
public class IGRIS0602Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0602Action.class);

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
		IGRIS0602Form form = (IGRIS0602Form)actionForm;
		//BL取得
		IGRIS06BL ctlBL = (IGRIS06BL) getBean("igris06BL");
		//获取当前用户
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//获取查询资产类别BL接口实例
		IGSYM03BL ctl03BL = (IGSYM03BL) getBean("igsym03BL");
		//实例化类别dto
		IGSYM03DTO igsym03dto = new IGSYM03DTO();
		//获取当前用户
		igsym03dto.setSubtype("999021");
		//获取带类别树的dto
		igsym03dto = ctl03BL.getAssetDomainTree(igsym03dto, "IGBP19", user);
		//初始化类别列表
		List<IGRIS06022VO> labelAndValueList = new ArrayList<IGRIS06022VO>();
		labelAndValueList.add(new IGRIS06022VO());
		//获取类别 遍历
		Map<String, TreeNode> treeMap = igsym03dto.getTreeNodeMap();
		for(Map.Entry<String, TreeNode> entry : treeMap.entrySet()){
			TreeNode treeNode = entry.getValue();
			LinkedHashMap<String, TreeNode> linkHashMap = treeNode.getChildTreeNodeMap();
			for(Map.Entry<String, TreeNode> subEntry : linkHashMap.entrySet()){
				TreeNode subTreeNode = subEntry.getValue();
				labelAndValueList.add(new IGRIS06022VO(subTreeNode.getName(),subTreeNode.getId()));
			}
		}
		//保存到request
		req.setAttribute("labelAndValueList", labelAndValueList);
		//DTO生成
		IGRIS06DTO dto = new IGRIS06DTO();
		
		//画面跳转设定
		String forward = null;

		if( "DISP".equals(mapping.getParameter())){
			//检查项登记画面初期显示处理
			log.debug("========检查项登记画面初期显示处理开始========");
			form = new IGRIS0602Form();
			//向form 设置用户
			form.setEiuserid(user.getUserid());
			form.setEiusername(user.getUsername());
			form.setMguserid(user.getUserid());
			form.setMgusername(user.getUsername());
			Date nowDateTime = new Date();
			String date = CommonDefineUtils.DATE_FORMAT.format(nowDateTime);
			
			form.setEiinsdate(date);
			
			dto.setIgris0602Form(form);
			
			//获取编号
			dto = ctlBL.searchEntityItemLableAction(dto);
			
			req.setAttribute("IGRIS0602Form", form);
			saveToken(req);
			IGRIS06071VO vo = new IGRIS06071VO();
			vo.setCheckfrequencyList(dto.getCheckfrequencyList());
			vo.setSoc0109List(dto.getSoc0109List());
			super.setVO(req, vo);
			addMessage(req, new ActionMessage("IGCO10000.I001","检查项基本信息"));
			log.debug("========检查项登记画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//检查项登记画面再显示处理
			log.debug("========检查项登记画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========检查项登记画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	
		
		if( "INSERT".equals(mapping.getParameter())){
			//检查项编辑处理
			if (form.getMode().equals("0")){
				//检查项登记处理
				log.debug("========检查项登记处理开始========");

				form.setEiorgsyscoding(user.getOrgid());
				form.setEiuserid(user.getUserid());
				form.setEiusername(user.getUsername());
				form.setEiname(form.getCivalue()[0]);
				form.setEidesc(form.getCivalue()[1]);
				form.setEimethod(form.getCivalue()[2]);
				//登记时间
				form.setEiinsdate(form.getCivalue()[5]);
				
				dto.setAttachFile(form);//设置form
				//DTO输入参数设定
				dto.setIgris0602Form(form);
				if (isTokenValid(req, true)) {
					
					//检查项信息登记逻辑调用
					dto = ctlBL.insertEntityItemAction(dto);
					
					//将登记完了的检查项信息设定到VO中
					IGRIS06021VO vo = new IGRIS06021VO(dto.getIgris0602Form());
					//编号
					req.getSession().setAttribute("eilabel", dto.getIgris0602Form().getEilabel());
					//检查项ID
					req.getSession().setAttribute("eiiddd",dto.getEiid()+"");
					super.<IGRIS06021VO>setVO(req.getSession(), vo);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
				}
				
				
				log.debug("========检查项登记处理终了========");
				
				forward = "DISP";

			}
		}else if( "INSERTWINDOW".equals(mapping.getParameter())){
			//检查项编辑处理
//			PrintWriter out = null;
//			out = new PrintWriter( new OutputStreamWriter(res.getOutputStream(), "utf-8"));
			if (form.getMode().equals("0")){
				//检查项登记处理
				log.debug("========检查项登记处理开始========");

				form.setEiorgsyscoding(user.getOrgid());
				form.setEiuserid(user.getUserid());
				form.setEiusername(user.getUsername());
				form.setEiname(form.getCivalue()[0]);
				form.setEidesc(form.getCivalue()[1]);
				form.setEimethod(form.getCivalue()[2]);
				
				dto.setAttachFile(form);//设置form
				//DTO输入参数设定
				dto.setIgris0602Form(form);
				if (isTokenValid(req, true)) {
					
					//检查项信息登记逻辑调用
					dto = ctlBL.insertEntityItemAction(dto);
					//将登记完了的检查项信息设定到VO中
					IGRIS06021VO vo = new IGRIS06021VO(dto.getIgris0602Form());
//					String ret = form.getEiid()+","+ form.getEiversion()+"," + form.getEiname();
//					out.print(ret);
					//编号
					req.getSession().setAttribute("eiidWindow", dto.getEiid());
					
					super.<IGRIS06021VO>setVO(req.getSession(), vo);
			
					PrintWriter out = null;
					try {
						out = new PrintWriter( new OutputStreamWriter(res.getOutputStream(), "utf-8"));
							StringBuffer text = new StringBuffer();
							String classType = "";
							if(dto.getIgris0602Form().getCivalue()[4].equals("999021001")){
								classType = "机房";
							}else if(dto.getIgris0602Form().getCivalue()[4].equals("999021002")){
								classType = "网络";
							}else if(dto.getIgris0602Form().getCivalue()[4].equals("999021003")){
								classType = "系统";
							}else if(dto.getIgris0602Form().getCivalue()[4].equals("999021004")){
								classType = "桌面安全";
							}else if(dto.getIgris0602Form().getCivalue()[4].equals("999021005")){
								classType = "访问控制";
							}else if(dto.getIgris0602Form().getCivalue()[4].equals("999021006")){
								classType = "开发";
							}else if(dto.getIgris0602Form().getCivalue()[4].equals("999021007")){
								classType = "其他";
							}
							
							text.append(dto.getEiid())
								.append("_").append(dto.getIgris0602Form().getEiname())
								.append("_").append(dto.getIgris0602Form().getEidesc())
								.append("_").append(dto.getIgris0602Form().getEimethod())
								.append("_").append(classType);
						out.print(text.toString());
					} catch (Exception e) {
						out.print("");
						e.printStackTrace();
						addMessage(req, new ActionMessage("IGCO10000.E130",e.getMessage()));
					} finally{
						out.close();
					}
					
					
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
				}				
				log.debug("========检查项登记处理终了========");
				return null;
			}
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
