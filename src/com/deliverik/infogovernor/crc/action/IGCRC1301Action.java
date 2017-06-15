/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.crc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.crc.bl.IGCRC13BL;
import com.deliverik.infogovernor.crc.dto.IGCRC1301DTO;
import com.deliverik.infogovernor.crc.form.IGCRC1301Form;
import com.deliverik.infogovernor.crc.vo.IGCRC1301VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 文档信息查询Action
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public class IGCRC1301Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCRC1301Action.class);
	
	/**
	 * <p>
	 * Description: 页面查询action处理
	 * </p>
	 * 
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("================文档信息查询Action开始=============");
		//实例化FORM
		IGCRC1301Form form = (IGCRC1301Form)actionForm;
		//获取BL接口实例
		IGCRC13BL crcBL = (IGCRC13BL)getBean("igcrc13bl");
		//实例化DTO
		IGCRC1301DTO dto = new IGCRC1301DTO();

		//获取发起角色列表
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
		dto.setUser(user);
		
		//文档信息查询
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========文档信息查询处理开始========");
			//获取分页Bean
			PagingDTO pDTO = getPaginDTO(request,"IGCRC1301");
			
			int maxCnt = getMaxDataCount("IGCRC1301");
			
			dto.setIgcrc1301Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDTO);
			//调用BL查询 
			dto = crcBL.searchEntityItemAction(dto);
			//构造VO
			IGCRC1301VO vo = new IGCRC1301VO();
			vo.setIgcrc1301VWList(dto.getEntityItemVWInfoList());
			request.getSession().setAttribute("isManager", dto.getIsManeger()==null?"0":dto.getIsManeger());
			super.<IGCRC1301VO>setVO(request, vo);
			log.debug("========文档信息查询处理终了========");
		}
		
		//文档信息查询
		if( "OPENSEARCH".equals(mapping.getParameter())){
			log.debug("========文档信息查询处理开始========");
			//获取分页Bean
			PagingDTO pDTO = getPaginDTO(request,"IGCRC1301");
			int maxCnt = getMaxDataCount("IGCRC1301");
			dto.setIgcrc1301Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDTO);
			//调用BL查询 
			dto = crcBL.openSearchEntityItemAction(dto);
			//构造VO
			IGCRC1301VO vo = new IGCRC1301VO();
			vo.setIgcrc1301VWList(dto.getEntityItemVWInfoList());
			request.setAttribute("pidid", request.getParameter("pidid"));
			super.<IGCRC1301VO>setVO(request, vo);
			log.debug("========文档信息查询处理终了========");
		}
		return mapping.findForward("DISP");
	}
}
