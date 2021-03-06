/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.csebank.lom.bl.IGLOM03BL;
import com.csebank.lom.bl.IGLOMCONSTANTS;
import com.csebank.lom.dto.IGLOM03DTO;
import com.csebank.lom.form.IGLOM0306Form;
import com.csebank.lom.util.CodeUtils;
import com.csebank.lom.util.LOMHelper;
import com.csebank.lom.vo.IGLOM03061VO;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;

/**
 * 还款Action
 * 
 */
public class IGLOM0306Action extends BaseAction {

	static Log log = LogFactory.getLog(IGLOM0306Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORM取得
		IGLOM0306Form form = (IGLOM0306Form)actionForm;
		
		//BL取得
		IGLOM03BL ctlBL = (IGLOM03BL) getBean("iglom03BL");
		
		//DTO生成
		IGLOM03DTO dto = new IGLOM03DTO();
		
		//当前用户信息
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUserid(user.getUserid());
		dto.setUsername(user.getUsername());
		//获取审批状态下拉列表
		List<LabelValueBean> statusList= LOMHelper.getItemsCodes(CodeUtils.LOANPAYDETAIL_LPDSTATUS);
		req.setAttribute("sp_status", subCollcetion(statusList));
		String forward = "";
		
		if( "DISP".equals(mapping.getParameter())){
			
			//还款查询画面初期显示处理
			log.debug("========还款查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========还款查询画面初期显示处理终了========");
			
			forward = "DISP";
			
			
		} else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			
			//还款查询处理
			log.debug("========还款查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGLOM0306");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGLOM0306Form) req.getSession().getAttribute("IGLOM0306Form");
				if ( form == null ) {
					form = new IGLOM0306Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGLOM0306Form) req.getSession().getAttribute("IGLOM0306Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大数取得
			int maxCnt = getMaxDataCount("IGLOM0306");
			//借款
			form.setLpdtype_q(IGLOMCONSTANTS.LPD_TYPE_LOAN);
			
			//DTO输入参数设定
			dto.setLoanPayDetailSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//还款信息检索逻辑调用
			dto = ctlBL.searchLoanPayDetailAction(dto);
			
			
			//将还款信息检索结果设定到VO中
			IGLOM03061VO vo = new IGLOM03061VO();
			vo.setLoanPayDetailList(dto.getLoanPayDetailList());
			
			super.<IGLOM03061VO>setVO(req, vo);
			
			log.debug("========还款查询处理终了========");
			
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
	/**
	 * 将取回的的下拉列表集合list进行切割，留已冲抵、已确认、已还款
	 * @param list
	 * @return
	 */
	private List<LabelValueBean> subCollcetion(List<LabelValueBean> list){
		List<LabelValueBean> resultList=new ArrayList<LabelValueBean>();
		if(list.size()!=0){
			
//			Object object;
			LabelValueBean bean=new LabelValueBean();
			bean.setLabel("");
			bean.setValue("");
			resultList.add(bean);
			for(int i=0;i<list.size();i++){
				bean=(LabelValueBean)list.get(i);
				if("5".equals(bean.getValue())){
					resultList.add(bean);
				}else if("4".equals(bean.getValue())){
					resultList.add(bean);
				}else if("0".equals(bean.getValue())){
					resultList.add(bean);
				}
			}
        
		}
		
		return resultList;
	}

}
