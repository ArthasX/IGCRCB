package com.deliverik.infogovernor.asset.action;

import java.util.Iterator;
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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.bl.IGASM27BL;
import com.deliverik.infogovernor.asset.dto.IGASM27DTO;
import com.deliverik.infogovernor.asset.form.IGASM2704Form;
import com.deliverik.infogovernor.asset.vo.IGASM27041VO;

/**
 * 风险点配置信息详细画面Action处理
 *
 */
public class IGASM2704Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2704Action.class);

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
		IGASM2704Form form = (IGASM2704Form)actionForm;
		
		//BL取得
		IGASM27BL ctlBL = (IGASM27BL) getBean("igasm27BL");
		
		//DTO生成
		IGASM27DTO dto = new IGASM27DTO();
		
		req.getSession().setAttribute("ADcount", 0);
		
		req.getSession().setAttribute("ADcheckCount", 0);
		
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			//风险点配置信息登记画面初期显示处理
			log.debug("========风险点配置信息登记画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM2704");

			//DTO输入参数设定
			dto.setIgasm2704Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			form.setCheckersion(form.getEiversion());
			form.setSelecteiversion(form.getEiversion()+"");
			//风险点配置信息登记画面初期显示逻辑调用
			dto = ctlBL.initIGASM2704Action(dto);
			
			//将风险点配置信息检索结果设定到VO中
			IGASM27041VO vo = new IGASM27041VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoMap());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			vo.setEiorgname(dto.getEiorgname());
			vo.setRiskPointList(dto.getRiskPointList());
			vo.setCheckVersionMap(dto.getCheckVersionMap());
			vo.setSearchRiskCheckList(dto.getSearchRiskCheckList());
			vo.setRiskToZhRelateList(dto.getRiskToZhRelateList());
			vo.setIgASM2704Form(dto.getIgasm2704Form());
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			super.<IGASM27041VO>setVO(req.getSession(), vo);
			req.getSession().setAttribute("identyFlag", dto.getIdentyFlag());
			req.getSession().setAttribute("hiddenmguserid", dto.getHiddenmguserid());
			req.getSession().setAttribute("looksign", form.getLooksign());
			addMessage(req, new ActionMessage("IGCO10000.I001","风险点属性信息"));
			saveToken(req);
			log.debug("========风险点配置信息登记画面初期显示处理终了========");
			forward = "DISP";
		} else if( "EDIT".equals(mapping.getParameter())){
			//风险点配置信息编辑
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//风险点配置信息编辑画面按下返回按钮时的返回处理
				if (form.getRoute().equals("0")){
					//返回风险点查询画面
					return mapping.findForward("BACK1");
				} else {
					//返回风险点登记画面
					return mapping.findForward("BACK2");
				}
			}

			log.debug("========风险点配置信息编辑处理开始========");
			//获取属性值
			String[] civalue =  form.getCivalue();
			//设定属性中管理人ID
			civalue[1]= form.getHiddenmguserid();
			form.setCivalue(civalue);
			//DTO输入参数设定
			dto.setIgasm2704Form(form);
			if (isTokenValid(req, true)){
				//类型配置信息编辑逻辑调用
				dto = ctlBL.editEntityItemAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}

			log.debug("========风险点配置信息编辑处理终了========");
			forward = "DISP";
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
