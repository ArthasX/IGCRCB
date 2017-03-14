/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.bl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.infogovernor.crc.bl.task.ChangeProcessVWBL;
import com.deliverik.infogovernor.crc.dto.IGCRC14DTO;
import com.deliverik.infogovernor.crc.form.IGCRC1401Form;
import com.deliverik.infogovernor.crc.model.ChangeProcessVWInfo;
import com.deliverik.infogovernor.crc.model.condition.ChangeProcessVWSearchCondImpl;
import com.deliverik.infogovernor.crc.model.vo.IGCRC14011VO;
import com.deliverik.infogovernor.crc.model.vo.IGCRC14012VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 变更查询BL实现
 * </p>
 * 
 * shikailong@deliverik.com
 * @version 1.0
 */
public class IGCRC14BLImpl extends BaseBLImpl implements IGCRC14BL {

	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGCRC14BLImpl.class);

	/** 变更流程业务逻辑BL*/
	protected ChangeProcessVWBL changeProcessVWBL;
	
	/** 流程定义业务逻辑 */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;

	/** 流程处理业务逻辑 */
	protected WorkFlowOperationBL workFlowOperationBL;
	/**
	 * 变更流程业务逻辑BL设定
	 * @param changeProcessVWBL the 变更流程业务逻辑BL
	 */
	public void setChangeProcessVWBL(ChangeProcessVWBL changeProcessVWBL) {
		this.changeProcessVWBL = changeProcessVWBL;
	}

	/**
	 * 流程定义业务逻辑设定
	 * @param workFlowDefinitionBL the 流程定义业务逻辑
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * 流程处理业务逻辑设定
	 * @param workFlowOperationBL the 流程处理业务逻辑
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * 查询变更流程
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCRC14DTO searchEntityItemAction(IGCRC14DTO dto) throws BLException{
		log.debug("========查询变更流程处理开始========");
		if(dto.getForm()!=null && dto.getForm() instanceof IGCRC1401Form){
			//取得form
			IGCRC1401Form form = (IGCRC1401Form)dto.getForm();
			//获取cond
			ChangeProcessVWSearchCondImpl cond = new ChangeProcessVWSearchCondImpl();
			//工单号查询
			cond.setPrserialnum_like(form.getPrserialnum());
			//变更名称设定
			cond.setPrtitle_like(form.getPrtitle());
			//变更类型
			cond.setChangetype_like(form.getChangetype());
			//更新平台
			cond.setUpdateplatform_like(form.getUpdateplatform());
			//工单状态
			cond.setPrstatus(form.getPrstatus());
			//工单类别
			cond.setChangecategory(form.getChangecategory());
			//发起时间
			cond.setPropentime_begin(form.getPropentime());
			cond.setPropentime_end(form.getPrclosetime());
			//业务影响范围
			cond.setBusinessscope(form.getBusinessscope());
			//变更原因
			cond.setChangereason_like(form.getChangereason());
			//是否影响业务
			cond.setIsinfluence(form.getIsinfluence());
			//变更分类
			cond.setChangeclassify(form.getChangeclassify());
			//变更内容
			cond.setChangecontent_like(form.getChangecontent());
			//处理人
			cond.setPpusername_like(form.getPpusername_like());
			
			// 查询记录总数
			int totalCount = changeProcessVWBL.getSearchCount(cond);
			if (totalCount == 0) {
				log.debug("========查询数据不存在========");
				// 查询数据不存在
				dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
				return dto;
			}
			if (totalCount > dto.getMaxSearchCount()) {
				log.debug("========查询数据件数过多========");
				// 查询数据件数过多
				dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
				return dto;
			}
			// 获取分页bean
			PagingDTO pDto = dto.getPagingDto();
			// 调用DAO接口查询
			List<ChangeProcessVWInfo> list = changeProcessVWBL.searchChangeProcessVW(cond, pDto.getFromCount(), pDto.getPageDispCount());
			IGCRC14011VO vo = new IGCRC14011VO();
			vo = copyVo(list, vo);
			dto.setIgcrc14011VO(vo);
			pDto.setTotalCount(totalCount);
			dto.setChangeProcessVWInfos(list);
		}
		log.debug("========查询变更流程处理开始========");
		return dto;
		
	}
	
	/**
	 * 复制集合到vo中
	 * @param list
	 * @param vo
	 * @return
	 */
	protected IGCRC14011VO copyVo(List<ChangeProcessVWInfo> list,IGCRC14011VO vo){
		List<IGCRC14012VO> list2 = new ArrayList<IGCRC14012VO>();
		if(list != null && list.size()>0){
			for(int i =0;i<list.size();i++){
				ChangeProcessVWInfo info = list.get(i);
				IGCRC14012VO vo2 = new IGCRC14012VO();	
				copyProperties(vo2, info);
				if(StringUtils.isNotBlank(info.getChangetype())){
					if(info.getChangetype().split("_tree_")!=null && info.getChangetype().split("_tree_").length>1){
						String type = info.getChangetype().split("_tree_")[1];
						String[] types = type.split("-");
						vo2.setChangetype(types[types.length-1]);
					}
				}
				if(StringUtils.isNotBlank(info.getUpdateplatform())){
					String type = info.getUpdateplatform();
					String type2 = type.replaceAll("#", "、").replaceAll("cv_cev_","");
					if(type2.indexOf("、") == 0){
						type2 = type2.substring(1, type2.length());
					}
					vo2.setUpdateplatform(type2);
				}
				if(StringUtils.isNotBlank(info.getPrdesc())){
					String type = info.getPrdesc().replaceAll("&nbsp;", " ")
										.replaceAll("<br>", "\t")
										.replaceAll("&gt;", ">")
										.replaceAll("&lt;", "<");
					vo2.setPrdesc(type);
				}
				list2.add(vo2);
			}
		}
		vo.setIgcrc14012vos(list2);
		return vo;
	}
	
	/**
	 * 根据PDID获取启用的流程PDID
	 */
	public IGCRC14DTO searchPdid7BitAction(IGCRC14DTO dto) throws BLException {
		log.debug("========当前流程类型启用版本的PDID取得处理开始========");
        IG380SearchCondImpl condImpl = new IG380SearchCondImpl();
        condImpl.setPdid_like("01084");
        condImpl.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
        List<IG380Info> ig380infoList = workFlowDefinitionBL.searchProcessDefinition(condImpl);
        if (ig380infoList.size() == 0) {
            //throw new BLException("IGCO10000.E027", dto.getPdid());
        } else {
            dto.setPdid(ig380infoList.get(ig380infoList.size() - 1).getPdid());
          //查询该流程定义下的所有流程状态
            IG333SearchCondImpl ig333Cond = new IG333SearchCondImpl();
            ig333Cond.setPdid(dto.getPdid());
            List<IG333Info> ig333Infos = workFlowDefinitionBL.searchProcessStatusDef(ig333Cond);
            dto.setIg333InfoList(ig333Infos);
        }
        log.debug("========当前流程类型启用版本的PDID取得处理终了========");
		return dto;
	}
	
	/**
	 * 导出变更管理Excel
	 * @return
	 * @throws BLException
	 */
	public IGCRC14DTO getExcelDataList(IGCRC14DTO dto) throws BLException {
		log.debug("=================获取变更管理相应数据集开始=================");
	
		// 查询参与人信息条件(暂无)
		IG337SearchCondImpl processParticipantCond = new IG337SearchCondImpl();
		processParticipantCond.setPsdid("01084");
		// 查询参与人信息
		dto.setProcessParticipantList(workFlowOperationBL.searchProcessParticipants(processParticipantCond));
		log.debug("=================获取变更管理相应数据集结束=================");
		return dto;
	}
	
}
