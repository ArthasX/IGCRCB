package com.deliverik.infogovernor.drm.action;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.drm.bl.IGDRM04BL;
import com.deliverik.infogovernor.drm.dto.IGDRM04DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0406Form;
import com.deliverik.infogovernor.drm.vo.IGDRM04061VO;
import com.deliverik.infogovernor.drm.vo.IGDRM04071VO;

/**
 * 应急资源  弹出页 (选择和快捷新增)
 *
 */
public class IGDRM0406Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0406Action.class);

	/**
	 * 
	 * 处理
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@Override
    @SuppressWarnings("unchecked")
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGDRM0406Form form = (IGDRM0406Form)actionForm;
		
		//BL取得
		IGDRM04BL ctlBL = (IGDRM04BL) getBean("igdrm04BL");
		
		//DTO生成
		IGDRM04DTO dto = new IGDRM04DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			form.setEsyscodingbegin(form.getEsyscoding());
			log.debug("========资产项HELP查询画面初期显示处理开始========");
			if(StringUtils.isEmpty(form.getEname()) && StringUtils.isNotEmpty(form.getEsyscoding())){
				dto.setEsyscoding(form.getEsyscoding());
				dto = ctlBL.searchEntityNameActionSOC(dto);
				form.setEname(dto.getEname());
			}
			//重新查询需清除缓存
			req.getSession().removeAttribute("ADSelectEntity");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========资产项HELP查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}
		//查看资产详细信息
		if("DETAIL".equals(mapping.getParameter())){
			
			dto.setForm(form);
			log.info("================查看资产详细信息开始===================");
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			dto= ctlBL.getEntityFullInfo(dto);
			//配置详细信息画面初期显示逻辑调用
		
			//将设备配置信息检索结果设定到VO中
			IGDRM04071VO vo = new IGDRM04071VO(dto.getSoc0124Info(),dto.getSoc0129InfoVWMap());
			super.<IGDRM04071VO>setVO(req.getSession(), vo);
			addMessage(req, new ActionMessage("IGCO10000.I001","资产配置信息"));
			
			log.info("================查看资产详细信息结束===================");
		}
		

		if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())||"SEARCH2".equals(mapping.getParameter())){
			log.debug("========资产项查询HELP处理开始========");

			//分页用DTO取得
			getPaginDTO(req,"IGDRM0406");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGDRM0406Form) req.getSession().getAttribute("IGDRM0406Form");
				if ( form== null){
					form = new IGDRM0406Form();
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
					form = (IGDRM0406Form) req.getSession().getAttribute("IGDRM0406Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}

			form.setEistatus("0");
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGDRM0406");
			dto.setSp_eiid(form.getSp_eiid());
			dto.setMaxSearchCount(maxCnt);
			dto.setForm(form);
			
			Set<String> set = (Set<String>)req.getSession().getAttribute("ADSelectEntity");
			if(set != null && set.size() > 0) {
				form.setSelectId(set.toArray(new String[0]));
			} else {
				form.setSelectId(null);
			}
			dto.setForm(form);
			dto.setPagingDto(pDto);
				dto = ctlBL.searchEntityItem0406Action(dto);
			//将资产项信息检索结果设定到VO中
			IGDRM04061VO vo = new IGDRM04061VO(dto.getSoc0124List());
			
			super.<IGDRM04061VO>setVO(req, vo);
			
			log.debug("========资产项HELP查询处理终了========");
		}
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
				
		return mapping.findForward("DISP");
	}
}
