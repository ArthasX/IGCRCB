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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.bl.IGASM31BL;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;
import com.deliverik.infogovernor.asset.form.IGASM3104Form;
import com.deliverik.infogovernor.asset.vo.IGASM31041VO;

/**
 * 风险指标配置信息详细画面Action处理
 *
 */
public class IGASM3104Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM3104Action.class);

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
		IGASM3104Form form = (IGASM3104Form)actionForm;
		//BL取得
		IGASM31BL ctlBL = (IGASM31BL) getBean("igasm31BL");
		//DTO生成
		IGASM31DTO dto = new IGASM31DTO();
		dto.setRiid(Integer.parseInt(form.getEiid()));
		dto.setRimdesc(form.getRimdesc());
		dto.setRimsql(form.getRimsql());
		dto.setRimtype(form.getRimtype());
		dto.setFingerprint(form.getFingerprint());
		req.getSession().setAttribute("ADcount", 0);
		req.getSession().setAttribute("ADcheckCount", 0);
		req.getSession().setAttribute("ADmapcount", 0);
		
		String forward = "null";
		
		if( "DISP".equals(mapping.getParameter())){
			//风险指标配置信息登记画面初期显示处理
			log.debug("========风险指标配置信息登记画面初期显示处理开始========");
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM3104");
			PagingDTO pDto = new PagingDTO(null,0,0,0);
			//DTO输入参数设定

			dto.setPagingDto(pDto);
			dto.setIgasm3104Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			form.setCheckersion(form.getEiversion());
			form.setSelecteiversion(form.getEiversion()+"");
			dto = ctlBL.checkEntityItemDomain(dto);
			//风险指标配置信息登记画面初期显示逻辑调用
			dto = ctlBL.initIGASM3104Action(dto);
			
			//dto = ctlBL.searchEntityItemAction(dto);
			//将风险指标配置信息检索结果设定到VO中
			IGASM31041VO vo = new IGASM31041VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemVWInfoMap());
			//返回查看资产配置信息权限标识
			vo.setFlag(dto.getFlag());
			vo.setLooksign(form.getLooksign());
			vo.setEiorgname(dto.getEiorgname());
			vo.setSearchRiskIndexSearchVWList(dto.getSearchRiskIndexSearchVWList());
			Map<Integer, List<LabelValueBean>> map = form.getSelectedListMap();
			Set<Map.Entry<Integer,List<LabelValueBean>>> set = map.entrySet();
			for(Iterator<Map.Entry<Integer,List<LabelValueBean>>> iter = set.iterator();iter.hasNext();){
				Map.Entry<Integer,List<LabelValueBean>> entry = iter.next();
				req.getSession().setAttribute("ADlist"+entry.getKey(), entry.getValue());
			}
			req.getSession().setAttribute("identyFlag", dto.getIdentyFlag());
			req.getSession().setAttribute("hiddenmguserid", dto.getHiddenmguserid());
			req.getSession().setAttribute("looksign", form.getLooksign());
			vo.setCheckVersionMap(dto.getCheckVersionMap());
			
			vo.setSelecteiversion(Integer.parseInt(dto.getSearchRiskIndexSearchVWList().get(0).getEiversion()));
			super.<IGASM31041VO>setVO(req.getSession(), vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I001","风险指标属性信息"));
			saveToken(req);
			log.debug("========风险指标配置信息登记画面初期显示处理终了========");
			forward = "DISP";
		} else if( "EDIT".equals(mapping.getParameter())){
			//风险指标配置信息编辑
			if (isCancelled(req)||(req.getParameter("btn_back")!=null)){
				//风险指标配置信息编辑画面按下返回按钮时的返回处理
				if (form.getRoute().equals("0")){
					//返回风险指标查询画面
					return mapping.findForward("BACK1");
				} else {
					//返回风险指标登记画面
					return mapping.findForward("BACK2");
				}
			}
			log.debug("========风险指标配置信息编辑处理开始========");
			
			String[] civalue =  form.getCivalue();
			//设定属性中管理人ID
			civalue[6]= form.getHiddenmguserid();
			form.setCivalue(civalue);
			//DTO输入参数设定
			dto.setIgasm3104Form(form);
			//DTO输入参数设定
			if (isTokenValid(req, true)){
				//类型配置信息编辑逻辑调用
				dto = ctlBL.editEntityItemAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}

			log.debug("========风险指标配置信息编辑处理终了========");
			ctlBL.insertMaintenance(dto);
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
