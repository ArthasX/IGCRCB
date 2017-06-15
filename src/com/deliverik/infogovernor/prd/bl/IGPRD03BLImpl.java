/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.bl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.FastDateFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.parameter.ProcessGroup;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.bl.task.IG480BL;
import com.deliverik.framework.workflow.prd.bl.task.IG481BL;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.IG481Info;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG480SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG481SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG480TB;
import com.deliverik.framework.workflow.prd.model.entity.IG481TB;
import com.deliverik.framework.workflow.prr.bl.task.IG483BL;
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.condition.IG483SearchCondImpl;
import com.deliverik.infogovernor.prd.dto.IGPRD03DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0301Form;
import com.deliverik.infogovernor.prd.form.IGPRD0302Form;
import com.deliverik.infogovernor.prd.form.IGPRD0303Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程组定义BL实现
 * </p>
 * 
 * @version 1.0
 */
public class IGPRD03BLImpl extends BaseBLImpl implements IGPRD03BL {
	
	/** 日志对象取得 */
	private static final Log log = LogFactory.getLog(IGPRD03BLImpl.class);

	/** 日期格式定义 */
	public final static FastDateFormat DATETIME_FORMAT = FastDateFormat.getInstance("yyyy/MM/dd/HH/mm");
	
	private IG480BL ig480BL;
	private IG481BL ig481BL;
	private IG483BL ig483BL;
	private IG380BL ig380BL;
	private FlowOptBL flowOptBL;
	
	private WorkFlowDefinitionBL workFlowDefinitionBL;
	
	private FileUploadBL fileUploadBL;
	
    /**
	 * 查询流程组定义
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	
	public IGPRD03DTO searchProcessGroupDefinition(IGPRD03DTO dto) throws BLException{
		log.debug("开始查询流程组定义列表");
		IG480SearchCondImpl cond = new IG480SearchCondImpl();
		BeanUtils.copyProperties(dto.getIgprd0301Form()	,cond);
		//默认查询WD
		if(cond.getPtid() == null) {
			cond.setPtid(8);
		}

		//流程定义信息查询件数取得 
		int totalCount = ig480BL.getSearchCount(cond);
		
		if (totalCount == 0) {
			log.debug("========流程定组义信息查询数据不存在========");
			//流程定义信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========流程组定义信息查询数据件数过多========");
			//流程定义信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		
		//当前页流程定义信息取得
		List<IG480Info> processDefinitionList = ig480BL.searchIG480(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setProcessGroupDefinitionList(processDefinitionList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("查询流程组定义列表结束");
		
		
		return dto;
	}
	
	/**
	 * 流程组升级
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD03DTO upgradeProcessGroupDefinition(IGPRD03DTO dto)throws BLException{
		
		
		
		return dto;
	}
	
	/**
	 * 保存流程组定义
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD03DTO regProcessGroupDefinition(IGPRD03DTO dto)throws BLException{
		log.debug("开始保存流程组定义基本信息");
		IGPRD0302Form igprd0302Form = dto.getIgprd0302Form();
		IG480TB ig480tb = new IG480TB();
		BeanUtils.copyProperties(igprd0302Form, ig480tb);
		//如果没有主键则执行新增操作否则执行更新
		if(StringUtils.isEmpty(ig480tb.getPgdid())){
			IG259Info pt = workFlowDefinitionBL.searchProcessTemplateByKey(igprd0302Form.getPtid());
			String pgdid = ig480BL.getPdidNextValue(pt.getFirstsite(),pt.getPdsequence());
			ig480tb.setPgdid(pgdid);
			ig480tb.setPgdstatus(IGPRDCONSTANTS.PGD_STATUS_DISABLE);//停用
			ig480tb.setPtid(pt.getPtid());
			IG480Info ig480Info = ig480BL.registIG480(ig480tb);
			dto.setProcessGroupDefinition(ig480Info);
		}else{
			IG480Info ig480Info = ig480BL.updateIG480(ig480tb);
			dto.setProcessGroupDefinition(ig480Info);
		}
		log.debug("保存流程组定义基本信息结束");
		
		return dto;
	}
	/**
	 * 流程组编辑页面初始化
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD03DTO initPGDforEdit(IGPRD03DTO dto)throws BLException{
		log.debug("开始流程组编辑页面初始化");
		String pdgid = dto.getIgprd0302Form().getPgdid();
		IG480Info processGroupDefinition = ig480BL.searchIG480ByPK(pdgid);
		dto.setProcessGroupDefinition(processGroupDefinition);
		log.debug("流程组编辑页面初始化结束");
		
		
		return dto;
		
	}

	/**
	 * 流程组关联流程定义页面初始化
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD03DTO initPGDRelition(IGPRD03DTO dto)throws BLException{
		
		log.debug("流程组成员管理页面初始化开始");
		//查询流程组定义基本信息
		IGPRD0303Form form = dto.getIgprd0303Form();
		IG480Info ig480Info = ig480BL.searchIG480ByPK(form.getPgdid());
		dto.setProcessGroupDefinition(ig480Info);
		//查询流程组成员信息
		IG481SearchCondImpl cond = new IG481SearchCondImpl();
		cond.setPgdid(form.getPgdid());
		List<IG481Info> pgrList =  ig481BL.searchIG481(cond);
		//查询组内成员和可选择流程定义
		IG380SearchCondImpl ig380Cond = new IG380SearchCondImpl();
		List<IG380Info> innerPGs = new ArrayList<IG380Info>();
		List<IG380Info> outerPGs = new ArrayList<IG380Info>();
		String[] pdids = new String[pgrList.size()]; 
		for (int i =0;i<pgrList.size();i++) {
			pdids[i] = pgrList.get(i).getPdid();
		}
		if(ig480Info.getPtid()!=null&&ig480Info.getPtid()>0){
			ig380Cond.setPtid(ig480Info.getPtid());
		}
		ig380Cond.setPdid_in(pdids);
		innerPGs = ig380BL.searchIG380Info(ig380Cond);
		ig380Cond.setPdid_in(null);
		ig380Cond.setPdid_not_in(pdids);
		ig380Cond.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);//发布流程
		outerPGs = ig380BL.searchIG380Info(ig380Cond);
		dto.setInnerPds(innerPGs);
		dto.setOuterPds(outerPGs);
		
		log.debug("流程组成员管理页面初始化结束");
		return dto;
	}

	/**
	 * 添加流程组内成员流程定义
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD03DTO addMember(IGPRD03DTO dto)throws BLException{
		log.debug("添加流程组内成员开始");

		IGPRD0303Form form = dto.getIgprd0303Form();
		String[] pdids = form.getPdids();
		for (String pdid : pdids) {
			IG481TB tb = new IG481TB();
			tb.setPgdid(form.getPgdid());
			tb.setPdid(pdid);
			tb.setCreateType("0");
			ig481BL.registIG481(tb);
		}
		
		log.debug("添加流程组内成员结束");
		return dto;
	}
	
	/**
	 * 删除流程组内成员流程定义
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD03DTO delMember(IGPRD03DTO dto)throws BLException{
		log.debug("删除流程组内成员开始");
		IGPRD0303Form form = dto.getIgprd0303Form();
		IG481SearchCondImpl cond = new IG481SearchCondImpl();
		cond.setPdids_in(form.getPdids());
		ig481BL.deleteByCond(cond);
		log.debug("删除流程组内成员结束");
		return dto;
	}
	
	/**
	 * 修改流程组状态
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD03DTO changeStatus(IGPRD03DTO dto) throws BLException{
		
		IGPRD0301Form form = dto.getIgprd0301Form();
		
		IG480TB tb = (IG480TB)ig480BL.searchIG480ByPK(form.getPgdid());
		//从测试状态转为发布状态或停用状态，删除测试数据
		if((IGPRDCONSTANTS.PGD_STATUS_TESTABLE.equals(tb.getPgdstatus())
				&& IGPRDCONSTANTS.PGD_STATUS_ENABLE.equals(form.getPgdstatus()))
			||(IGPRDCONSTANTS.PGD_STATUS_TESTABLE.equals(tb.getPgdstatus())
					&& IGPRDCONSTANTS.PGD_STATUS_DISABLE.equals(form.getPgdstatus()))
				) {
			IG483SearchCondImpl cond = new IG483SearchCondImpl();
			cond.setPgdid(tb.getPgdid());
			cond.setIstest("1");
			List<IG483Info> lst_IG483Info = this.ig483BL.searchIG483(cond);
			for(IG483Info info : lst_IG483Info) {
				this.ig483BL.deleteIG483(info);
			}
		}
		//从发布状态转为其它状态，判断是否有未关闭流程组
		else if(IGPRDCONSTANTS.PGD_STATUS_ENABLE.equals(tb.getPgdstatus())
				&& !IGPRDCONSTANTS.PGD_STATUS_ENABLE.equals(form.getPgdstatus())){
			IG483SearchCondImpl cond = new IG483SearchCondImpl();
			cond.setPgdid(tb.getPgdid());
			cond.setActive(true);
			List<IG483Info> lst_IG483Info = this.ig483BL.searchIG483(cond);
			if(!lst_IG483Info.isEmpty()) {
				throw new BLException("IGCO10000.E141","该流程组定义正在被使用不能停止");	
			}
			
		}
		
		tb.setPgdstatus(form.getPgdstatus());
		
		ig480BL.updateIG480(tb);
		dto.addMessage(new ActionMessage("IGCO10000.I000", "状态修改成功。"));
		
		return dto;
	}
	
	/**
	 * 流程组发起
	 * @param dto IGPRD03DTO
	 * @return IGPRD03DTO
	 * @throws BLException
	 */
	public IGPRD03DTO LaunchAction(IGPRD03DTO dto) throws BLException {
		
		IGPRD0301Form form = dto.getIgprd0301Form();
		
		IG480TB ig480 = (IG480TB)ig480BL.searchIG480ByPK(form.getPgdid());
		
		ProcessGroup processGroupInfo = new ProcessGroup();
		processGroupInfo.setDefid(form.getPgdid());
		processGroupInfo.setCrtuserid(dto.getUser().getUserid());
		processGroupInfo.setTitle(ig480.getPgdname() + "_" + DATETIME_FORMAT.format(new Date()));
		processGroupInfo.setDefstatus(ig480.getPgdstatus());
		this.flowOptBL.initProcessGroupAction(processGroupInfo);
		dto.addMessage(new ActionMessage("IGCO10000.I000", "流程组（" + processGroupInfo.getTitle() + "）发起成功。"));
		return dto;
	}
	
	public IGPRD03DTO pgdUpgrade(IGPRD03DTO dto) throws BLException{
		
		return dto;
	}


	/**
	 * ig480BL   设定
	 * @param ig480BL ig480BL
	 */
	public void setIg480BL(IG480BL ig480bl) {
		ig480BL = ig480bl;
	}

	/**
	 * workFlowDefinitionBL   设定
	 * @param workFlowDefinitionBL workFlowDefinitionBL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * ig481BL   设定
	 * @param ig481BL ig481BL
	 */
	public void setIg481BL(IG481BL ig481bl) {
		ig481BL = ig481bl;
	}

	/**
	 * ig380BL   设定
	 * @param ig380BL ig380BL
	 */
	public void setIg380BL(IG380BL ig380bl) {
		ig380BL = ig380bl;
	}

	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}

	public void setIg483BL(IG483BL ig483bl) {
		ig483BL = ig483bl;
	}
	   
    public FileUploadBL getFileUploadBL() {
        return fileUploadBL;
    }

    public void setFileUploadBL(FileUploadBL fileUploadBL) {
        this.fileUploadBL = fileUploadBL;
    }

    /** 
     * @Title: flexUploadFile 
     * @Description:  flex或其他流形式上传附件逻辑 
     * @param dto  内的fileItem
     * void    
     * @throws Excetption 一切文件操作异常
     */
    public void flexUploadFile(IGPRD03DTO dto) throws Exception {
        FileItem item = dto.getFileItem();
        String attkey=fileUploadBL.uploadFile(item);
        dto.setAttKey(attkey);
    }
	
}

