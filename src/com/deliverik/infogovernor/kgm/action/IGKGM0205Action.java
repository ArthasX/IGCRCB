/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.kgm.action;

import java.util.List;

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
import com.deliverik.infogovernor.kgm.bl.IGKGM02BL;
import com.deliverik.infogovernor.kgm.dto.IGKGM03DTO;
import com.deliverik.infogovernor.kgm.form.IGKGM0203Form;
import com.deliverik.infogovernor.kgm.vo.IGKGM02051VO;

/**
 * 概述:知识库查询Action
 * 功能描述：知识库查询Action
 * 创建记录：wangxiaoqiang 2010/12/07
 * 修改记录：
 */
public class IGKGM0205Action extends BaseAction {

	static Log log = LogFactory.getLog(IGKGM0205Action.class);

	/**
	 * 处理
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
		IGKGM0203Form form = (IGKGM0203Form)actionForm;
		
		//BL取得
		IGKGM02BL ctlBL = (IGKGM02BL) getBean("igkgm02BL");
		
		//DTO生成
		IGKGM03DTO dto = new IGKGM03DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//知识查询画面初期显示处理
			log.debug("========知识查询画面初期显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========知识查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}  else if( "SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			//知识查询处理
			log.debug("========知识查询处理开始========");
			
			//分页用DTO取得
			getPaginDTO(req,"IGKGM0203");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGKGM0203Form) req.getSession().getAttribute("IGKGM0203Form");
				if ( form == null ) {
					form = new IGKGM0203Form();
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
					form = (IGKGM0203Form) req.getSession().getAttribute("IGKGM0203Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//排序开始
			//排序标识取得
			String orderVal = req.getParameter("orderVal");		
			if(StringUtils.isEmpty(form.getSelectstatus())){
				return mapping.findForward("DISP");
			}
			//翻页时保存排序标识
			if(StringUtils.isNotEmpty(orderVal)){
				form.setOrder(orderVal);
			}
			//增加默认的排序
			else{
				if(StringUtils.isEmpty(form.getOrder()))
				{
					form.setOrder("knserial");
				}
				if(StringUtils.isEmpty(form.getSing())){
					form.setSing("DESC");
				}
			}

			//设定排序方式
			if(StringUtils.isNotEmpty(form.getOrder())){
			if(StringUtils.isNotEmpty(orderVal)){
				if(orderVal.equals(form.getOrder())){
					if("DESC".equals(form.getSing())){
						form.setSing("ASC");
					}else{
						form.setSing("DESC");
					}
				}else{
					form.setSing("ASC");
				}
			  }
			}
			if(StringUtils.isEmpty(orderVal)){
				form.setOrder(form.getOrder());
			}else{
				form.setOrder(orderVal);
			}
			
			
			//排序结束
			
			int maxCnt = getMaxDataCount("IGKGM0106");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			//DTO输入参数设定
			dto.setIgkgm0203Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//知识信息检索逻辑调用
			dto = ctlBL.searchKnowLedgeInfoAction(dto);
			
			//将知识类型信息检索结果设定到VO中
			IGKGM02051VO vo = new IGKGM02051VO();
			vo.setKnowLedgeInfoList(dto.getKnowLedgeInfoList());
			super.<IGKGM02051VO>setVO(req, vo);
			req.setAttribute("showFlag", form.getShowFlag());
			log.debug("========知识查询处理终了========");
		} else if ("READ".equals(mapping.getParameter())){
			//知识信息查看
			log.debug("========知识详细信息查看处理开始========");
			
			//查询流程详细
			String knid = req.getParameter("knid");
			//设定知识ID
			dto.setKnid(Integer.valueOf(knid));
			//设定知识版本号
			String knversion = req.getParameter("knversion");
			
			dto.setKnversion(Integer.valueOf(knversion));
			
			IGKGM02BL igkgm02BL = (IGKGM02BL) getBean("igkgm02BL");

			dto = igkgm02BL.searchKnowledgeDetailAction(dto);
			
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang 业务系统显示
			dto = ctlBL.getKnowledgeAppImpact(dto);
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang 业务系统显示
			
			//查找是否有没提交的更新记录，total=0表示没有，total>0表示有
			dto = ctlBL.searchKnowledgeNotCheckActionForKGMDis(dto);
			req.setAttribute("versions", dto.getVersions());
			//设置显示信息
			IGKGM02051VO vo = new IGKGM02051VO();
			vo.setKnowledge(dto.getKnowledge());
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang 业务系统显示
			vo.setKnowledgeAppImpactList(dto.getKnowledgeAppImpactList());
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang 业务系统显示
			if(dto.getKnowledgeProcessList()!=null && dto.getKnowledgeProcessList().size()>0){
				vo.setKnowledgeProcessList(dto.getKnowledgeProcessList());				
			}
			
			//增加历史评分显示 start leexuzhi 2011/03/28
			int maxCnt = getMaxDataCount("IGKGM0207");
			 dto.setMaxSearchCount(maxCnt);
		
			 dto.setKnid(Integer.valueOf(knid));
			 //查询知识评分结果
			 dto = ctlBL.searchKnowledgeGradeAction(dto);
			 vo.setKnowledgeGradeList(dto.getKnowledgeGradeList());
			 
			//增加历史评分显示 end leexuzhi 2011/03/28
			super.<IGKGM02051VO> setVO(req.getSession(), vo);		
			log.debug("========知识详细信息查看处理终了========");
		}  else if("HISTORY".equals(mapping.getParameter())){
			log.debug("========知识历史记录查看处理开始========");
			String knid = req.getParameter("knid");
			
			dto.setKnid(Integer.valueOf(knid));
			
			dto = ctlBL.searchKnowledgeHistory(dto);
			
			IGKGM02051VO vo = new IGKGM02051VO();
			vo.setVoList(dto.getVoList());
			vo.setKnowledgeList(dto.getKnowledgeList());
			super.<IGKGM02051VO> setVO(req.getSession(), vo);
			log.debug("========知识历史记录查看处理结束========");
		}	else if("PROCESSANDSERVICE".equals(mapping.getParameter())){
			log.debug("=========流程关联知识查看处理开始========");
			String knid = req.getParameter("knid");
			
			dto.setKnid(Integer.valueOf(knid));
			
			dto = ctlBL.searchKnowledgeProcessByKnid(dto);
			
			if(dto.getKnowledgeProcessList() == null && dto.getKnowledgeProcessList().size()<=0){
				addMessage(req, new ActionMessage("IGKGM0205.I001"));
			}
			
			IGKGM02051VO vo = new IGKGM02051VO();
			
			vo.setKnowledgeProcessList(dto.getKnowledgeProcessList());
			super.<IGKGM02051VO> setVO(req.getSession(), vo);
			log.debug("========流程关联知识查看处理结束========");
		} else if ("PRINT".equals(mapping.getParameter())){
			//知识信息查看
			log.debug("========知识详细信息查看处理开始========");
			
			//查询流程详细
			//设定知识ID
			String knid = req.getParameter("knid");
			dto.setKnid(Integer.valueOf(knid));
			
			//设定知识版本号
			String knversion = req.getParameter("knversion");
			dto.setKnversion(Integer.valueOf(knversion));
			
			IGKGM02BL igkgm02BL = (IGKGM02BL) getBean("igkgm02BL");
			dto = igkgm02BL.searchKnowledgeDetailAction(dto);
			
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang 业务系统显示
			dto = ctlBL.getKnowledgeAppImpact(dto);
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang 业务系统显示
			
			//设置显示信息
			IGKGM02051VO vo = new IGKGM02051VO();
			vo.setKnowledge(dto.getKnowledge());
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang 业务系统显示
			vo.setKnowledgeAppImpactList(dto.getKnowledgeAppImpactList());
			//<<<<<<<<<<<<<<<<< add by wangxiaoqiang 业务系统显示
			//参考案例
//			if(dto.getKnowledgeProcessList()!=null && dto.getKnowledgeProcessList().size()>0){
//				vo.setKnowledgeProcessList(dto.getKnowledgeProcessList());				
//			}
			super.<IGKGM02051VO> setVO(req.getSession(), vo);		
			log.debug("========知识详细信息查看处理终了========");
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
