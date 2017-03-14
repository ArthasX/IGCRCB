package com.deliverik.infogovernor.risk.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.risk.bl.IGRIS06BL;
import com.deliverik.infogovernor.risk.dto.IGRIS06DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0604Form;
import com.deliverik.infogovernor.risk.vo.IGRIS06022VO;
import com.deliverik.infogovernor.risk.vo.IGRIS06041VO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;
import com.deliverik.infogovernor.sym.model.FormFileInfo;

/**
 * 检查项配置信息修改画面Action处理
 *
 */
public class IGRIS0604Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0604Action.class);

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
		IGRIS0604Form form = (IGRIS0604Form)actionForm;
		
		//BL取得
		IGRIS06BL ctlBL = (IGRIS06BL) getBean("igris06BL");
		
		//DTO生成
		IGRIS06DTO dto = new IGRIS06DTO();
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADcheckCount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
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
				labelAndValueList.add(new IGRIS06022VO(subTreeNode.getName(),subTreeNode.getId().split("_")[1]));
			}
		}
		//保存到request
		req.setAttribute("labelAndValueList", labelAndValueList);
		
		
		if( "DISP".equals(mapping.getParameter())){
			//检查项配置信息登记画面初期显示处理
			log.debug("========检查项配置信息登记画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGRIS0604");

			//DTO输入参数设定
			dto.setIgris0604Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setUser(user);
			form.setCheckersion(form.getEiversion());
			form.setSelecteiversion(form.getEiversion()+"");
			//检查项配置信息登记画面初期显示逻辑调用
			dto = ctlBL.initIGRIS0604Action(dto);
			//先清空附件列表
			form.setAttachmentList(new ArrayList<Attachment>());
			if (form.getCivalue()[3]!=null &&!form.getCivalue()[3].equals("")) {
				AttachmentBL attachmentBL=(AttachmentBL) getBean("attachmentBL");		
				List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(form.getCivalue()[3]);
				form.setAttachmentList(attachmentList);
			}
			
			form.setHiddenmguserid(dto.getHiddenmguserid());
			//将检查项配置信息检索结果设定到VO中
			IGRIS06041VO vo = new IGRIS06041VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoMap());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			vo.setItemList(dto.getItemList());
			vo.setCheckVersionMap(dto.getCheckVersionMap());
			vo.setRiskToZhRelateList(dto.getRiskToZhRelateList());
			vo.setIgris0604Form(form);
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			super.<IGRIS06041VO>setVO(req.getSession(), vo);
			
			req.getSession().setAttribute("identyFlag", dto.getIdentyFlag());
			req.getSession().setAttribute("looksign", form.getLooksign());
			req.getSession().setAttribute("hiddenmguserid", dto.getHiddenmguserid());
			addMessage(req, new ActionMessage("IGCO10000.I001","检查项属性信息"));
			saveToken(req);
			log.debug("========检查项配置信息登记画面初期显示处理终了========");
			forward = "DISP";
		} else if( "EDIT".equals(mapping.getParameter())){
			//检查项配置信息编辑
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//检查项配置信息编辑画面按下返回按钮时的返回处理
				if (form.getRoute().equals("0")){
					//返回检查项查询画面
					return mapping.findForward("BACK1");
				} else {
					//返回检查项登记画面
					return mapping.findForward("BACK2");
				}
			}

			log.debug("========检查项配置信息编辑处理开始========");
			String[] civalue =  form.getCivalue();
			form.setCivalue(civalue);
			//DTO输入参数设定
			dto.setIgris0604Form(form);
			if (isTokenValid(req, true)){
				//类型配置信息编辑逻辑调用
				dto = ctlBL.editEntityItemAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			//先清空附件列表
			form.setAttachmentList(new ArrayList<Attachment>());
			if (form.getCivalue()[3]!=null &&!form.getCivalue()[3].equals("")) {
				AttachmentBL attachmentBL=(AttachmentBL) getBean("attachmentBL");		
				List<Attachment> attachmentList = attachmentBL.searchAttachmentsByAttkey(form.getCivalue()[3]);
				form.setAttachmentList(attachmentList);
			}
			log.debug("========检查项配置信息编辑处理终了========");
			//清空附件上传
			form.setFileList(new ArrayList<FormFileInfo>());
			forward = "DISP";
		}else if("LOADFILE".equals(mapping.getParameter())){
			//附件下载
			if ("LOADFILE".equals(mapping.getParameter())){
				log.debug("========通知附件下载处理开始========");
				String attId = req.getParameter("attid");	
				String type = "sym";
				req.setAttribute("type", type);
				req.setAttribute("attId", attId);

				log.debug("========通知附件下载处理结束========");
				return mapping.findForward("LOADFILE");
			}
		}else if("STATUS".equals(mapping.getParameter())){
			//form存入dto
			dto.setIgris0604Form(form);
			//更新检查项状态
			dto.setUser(user);
			int success = ctlBL.updateCheckItemStatus(dto);
			if(success < 1){
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			forward = "DISP";
		}
		
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		form.setDeletekeys("");
		return mapping.findForward(forward);
	}
}
