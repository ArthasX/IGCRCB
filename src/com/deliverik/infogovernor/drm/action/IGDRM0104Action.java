package com.deliverik.infogovernor.drm.action;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCondImpl;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.bl.task.IG480BL;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.infogovernor.drm.bl.IGDRM01BL;
import com.deliverik.infogovernor.drm.dto.IGDRM01DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0104Form;
import com.deliverik.infogovernor.drm.vo.IGDRM01041VO;
import com.google.gson.Gson;

/**
 * 场景资产查询Action处理
 *
 */
public class IGDRM0104Action extends BaseAction {

    static Log log = LogFactory.getLog(IGDRM0104Action.class);

    /**
     * 场景资产查询Action处理
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
        //
    	//设置高亮菜单
		UserPermission perm = (UserPermission)req.getSession().getAttribute("UserPermission");
		if(perm != null) {
			String actsortid = perm.getActsortid("ACT29DRM0201");	//获取指定菜单ID的ACTSORTID
			if(StringUtils.isNotEmpty(actsortid)){
				setSessionAttribute(req, "firstactid", actsortid.substring(0, 2));
				setSessionAttribute(req, "secondactid", actsortid.substring(0, 4));
			} // end if 
		} // end if 
        log.debug("========场景资产查询处理开始 ========");
        IGDRM0104Form form = (IGDRM0104Form)actionForm;
        IGDRM01DTO dto = new IGDRM01DTO();
        IGDRM01BL ctlBL =(IGDRM01BL)getBean("igdrm01BL");
        dto.setLocale(this.getLocale(req));
        Gson g = new Gson();
		if( "DISP".equals(mapping.getParameter())){
			
			clearSessionFormData(req);
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setLoginUser(user);
			ctlBL.initIgdrm0102Action(dto);
			IGDRM01041VO vo = new IGDRM01041VO();
        	vo.setPlanTypeValues(dto.getPlanTypeValues());
        	vo.setNodeMapJson(g.toJson(dto.getNodeMap()));
        	super.<IGDRM01041VO>setVO(req, vo);
			return mapping.findForward("DISP");
		}else if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGDRM0102");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGDRM0104Form) req.getSession().getAttribute("IGDRM0104Form");
				if ( form== null){
					form = new IGDRM0104Form();
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
					form = (IGDRM0104Form) req.getSession().getAttribute("IGDRM0104Form");
					clearSessionFormData(req);
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGDRM0104");
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setLoginUser(user);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			dto.setIgdrm0104Form(form);
			req.getSession().setAttribute("IGDRM0104Form", form);
        	ctlBL.searchPlan(dto);
        	IGDRM01041VO vo = new IGDRM01041VO();
        	vo.setNodeMapJson(g.toJson(dto.getNodeMap()));
        	vo.setPlanTypeValues(dto.getPlanTypeValues());
        	vo.setPlanList(dto.getPlanList());
        	super.<IGDRM01041VO>setVO(req, vo);
        }else if("AJAX".equals(mapping.getParameter())){
			log.debug("========校验是否可以修订处理开始========");
			PrintWriter out = null;
			try {
				IG380BL ig380BL = (IG380BL) getBean("ig380BL");
				//资产属性实体表
				SOC0107BL soc0107BL = (SOC0107BL) getBean("soc0107BL");
				out = new PrintWriter(new OutputStreamWriter(res.getOutputStream(), "utf-8"));
				//修订资产eiid
				String eiid = req.getParameter("eiid");
				SOC0129SearchCondImpl ciCond = new SOC0129SearchCondImpl();
				ciCond.setEsyscoding_q("999060");
				ciCond.setEiid(eiid);
				ciCond.setEkey2("1");
				ciCond.setCname("场景应急处置步骤");
				List<SOC0129Info> ciList = soc0107BL.searchConfigItemVW(ciCond);
				
				String pdid = ciList.get(0).getCivalue().split("_")[0];
				
				String pdfid = pdid.substring(0, 5);
				String version = pdid.substring(5, 7);
				
				String newid = pdfid + StringUtils.leftPad(String.valueOf(Integer.parseInt(version)+1), 2, "0");
				
				SOC0129SearchCondImpl s129Cond = new SOC0129SearchCondImpl();
				s129Cond.setEsyscoding_q("999060");
				s129Cond.setEiid(eiid);
				s129Cond.setEkey2("1");
				s129Cond.setCname("场景类型");
				List<SOC0129Info> s129List = soc0107BL.searchConfigItemVW(s129Cond);
				String sceneType = s129List.get(0).getCivalue().split("_")[0];
				if(StringUtils.isNotEmpty(sceneType)&&"1".equals(sceneType)){//组合场景
					IG480BL ig480BL = (IG480BL) getBean("ig480BL");
					IG480Info ig480info = ig480BL.searchIG480ByPK(newid);
					String result = "";
					if (ig480info != null) {
						result = "1";
					} else {
						result = "0";
					}
					out.print(result);
				}else{//单一场景
				IG380SearchCondImpl cond = new IG380SearchCondImpl();
				cond.setPdid(newid);
				List<IG380Info> pdList = ig380BL.searchIG380Info(cond);
				
				String result = "";
				
				if (pdList != null && pdList.size() > 0) {
					result = "1";
				} else {
					result = "0";
				}
				out.print(result);
				}
			} catch (Exception e) {
				out.print("");
				log.error("AjaxAction Exception", e);
			} finally {
				if (out != null)
					out.close();
			}
			
			log.debug("========校验是否可以修订处理结束========");
			return null;
		}else if( "setTimeInit".equals(mapping.getParameter())){
			log.debug("========场景修订提醒周期显示画面初期显示处理开始========");
			String eiid = form.getEiid();
			SOC0107BL soc0107BL = (SOC0107BL) getBean("soc0107BL");
			SOC0118BL soc0118BL = (SOC0118BL) getBean("soc0118BL");
			
			SOC0118Info soc0118Info = soc0118BL.searchEntityItemByKey(new Integer(eiid));
			SOC0107SearchCondImpl soc0107SearchCond = new SOC0107SearchCondImpl();
			soc0107SearchCond.setEiid(eiid);
			soc0107SearchCond.setCid("CI30000001016");
			List<SOC0107Info> soc0107List = soc0107BL.searchSOC0107(soc0107SearchCond);
			
			String time = soc0107List.get(0).getCivalue();
			IGDRM01041VO vo = new IGDRM01041VO();
			// 设备资产基本信息
			vo.setSoc0118Info(soc0118Info);
			// 场景修订提示周期
			vo.setCycleTime(time);
			// 设备ID
			vo.setEiid(eiid);
        	super.<IGDRM01041VO>setVO(req, vo);
			log.debug("========场景修订提醒周期显示画面初期显示处理终了========");
			return mapping.findForward("setTimeInit");
			
		}else if("setTimeSubmit".equals(mapping.getParameter())){
			log.debug("========场景修订提醒周期显示画面提交处理开始========");
//			int cycleTime = 0;
//			if(null!=form.getCycleTime()&&""!=form.getCycleTime()){
//				cycleTime = Integer.valueOf(form.getCycleTime());
//			}
			//通过EIID和表单的cid查询相应表单的实体数据<可能会有多个版本数据 但每个版本只有一条>
			//String eiid = form.getEiid();
			//ctlBL.updateCyleTime(eiid,cycleTime);
			// 添加定时任务
			//itemRemindTacticsPollingJobInit jobinit = new itemRemindTacticsPollingJobInit();
			//jobinit.addJob(eiid,cycleTime);
			log.debug("========场景修订提醒周期显示画面提交处理终了========");
			return null;
		}
		
        log.debug("========场景查询处理结束 ========");
        return mapping.findForward("DISP");
    }
}
