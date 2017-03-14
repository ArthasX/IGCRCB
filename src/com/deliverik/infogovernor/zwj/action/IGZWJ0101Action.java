/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.zwj.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.condition.UserSearchCondImpl;
import com.deliverik.infogovernor.zwj.bl.IGZWJ01BL;
import com.deliverik.infogovernor.zwj.dto.IGZWJ01DTO;
import com.deliverik.infogovernor.zwj.form.IGZWJ0101Form;
import com.deliverik.infogovernor.zwj.vo.IGZWJ01011VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 事件发起 查询人员信息
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGZWJ0101Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//日志对象取得
		Log log = LogFactory.getLog(IGZWJ0101Action.class);
		//BL取得
		IGZWJ01BL ctlBL = (IGZWJ01BL) getBean("igzwj01BL");
		//实例化dto
		IGZWJ01DTO dto = new IGZWJ01DTO();
		//form取得
		IGZWJ0101Form form = (IGZWJ0101Form) actionForm;
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========用户查询画面初期显示处理开始========");
			//设置机构初始值
			dto = ctlBL.searchOrgnameAction(dto);
		    if(form==null){
		    	IGZWJ0101Form lsrform = new IGZWJ0101Form();
		    	lsrform.setOrgidstr(dto.getOrg().getOrgsyscoding());
		    	lsrform.setOrgname(dto.getOrg().getOrgname());
		    	request.setAttribute("IGZWJ0101Form", lsrform);
		    }else{		    	
		    	form.setOrgidstr(dto.getOrg().getOrgsyscoding());
		    	form.setOrgname(dto.getOrg().getOrgname());
		    }
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			log.debug("========用户查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}	
		//用户查询
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========用户查询处理开始========");
			//获取分页Bean
			getPaginDTO(request,"IGZWJ0101");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGZWJ0101Form) request.getSession().getAttribute("IGZWJ0101Form");
				if ( form== null){
					form = new IGZWJ0101Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGZWJ0101Form) request.getSession().getAttribute("IGZWJ0101Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			int maxCnt = getMaxDataCount("IGCYB0101");
			UserSearchCondImpl cond = new UserSearchCondImpl();
			BeanUtils.copyProperties(cond, form);
			//将查询条件小写转换成大写
			cond.setUsername_q(cond.getUsername_q());
			cond.setOrgid(null);
			cond.setOrgid_like(form.getOrgidstr());
			dto.setUserSearchCond(cond);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			//调用BL查询
			dto = ctlBL.searchUserInfoAction(dto);
			//构造VO
			IGZWJ01011VO vo = new IGZWJ01011VO();
			vo.setUserList(dto.getUserList());
			super.<IGZWJ01011VO>setVO(request, vo);
			
			log.debug("========用户查询处理终了========");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
