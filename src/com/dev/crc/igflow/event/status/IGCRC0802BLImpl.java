/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.crc.igflow.event.status;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.EntityItem;
import com.deliverik.framework.igflow.parameter.EntityItemConfigValue;
import com.deliverik.framework.igflow.parameter.EntityItemConfigValueInfo;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;

/***
 * 入库申请流程关闭节点前处理
 * @time 2014/06/26
 * @author taoye
 * @version 1.0
 * @mail taoye@deliverik.com
 */
public class IGCRC0802BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**日志对象取得*/
	static Log log = LogFactory.getLog(IGCRC0802BLImpl.class);
	
	/** 更新功能API类 */
	private FlowSetBL flowSetBL;

    /** 查询类功能API类 */
    private FlowSearchBL flowSearchBL;

	/** 配置项信息BL */
    private SOC0118BL soc0118BL;
    
    /** 附件业务BL */
    private AttachmentBL attachmentBL;
    
    /** 流程处理BL */
    private WorkFlowOperationBL workFlowOperationBL;
	
    /** 流程变量操作 */
	private IG599BL ig599BL;
    
	/**
	 * 注入更新功能API类
	 * 
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * 注入查询功能API类
	 * 
	 * @param flowSearchBL
	 */
    public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }

    /**
     * 配置项信息BL设置
     * @param soc0118bl 配置项信息BL
     */
	public void setSoc0118BL(SOC0118BL soc0118bl) {
		this.soc0118BL = soc0118bl;
	}

	/**
     * 附件业务BL设置
     * @param soc0118bl 配置项信息BL
     */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}
	
	/**
	 * 流程处理BL设定
	 * @param workFlowOperationBL 流程处理BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	
	/**
	 * 流程变量操作设定
	 * 
	 * @param ig599bl
	 *            ig599BL
	 */
	public void setIg599BL(IG599BL ig599bl) {
		ig599BL = ig599bl;
	}
	
	/**
     * 前处理
     */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("=====================入库申请流程关闭的前置处理开始=====================");	
		List<ProcessRecordInfo> list = flowSearchBL.searchProcessInfo(bean.getLogInfo().getPrid(), null);
		//创建资产相关对象
		EntityItem entityItem = new EntityItem();
		//设置资产名称
		entityItem.setEiname(flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "文档名称"));
		//设置资产说明
		entityItem.setEidesc(flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "文档描述"));
		
		//获取资产编号
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		cond.setEilabel(CommonDefineUtils.ENTIY_CATEGORY_DOCUMENT_KEY + IGStringUtils.getCurrentYear().substring(2));
		
		String eilabel = soc0118BL.searchNextEntityItemLable(cond);
		//设置资产编号
		entityItem.setEilabel(eilabel);
		
		//获取资产管理人信息
		List<ParticipantInfo> participantInfo =  flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "入库审批分类");
		
		//获取发起人信息
		List<ParticipantInfo> expInfo =  flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), IGPRDCONSTANTS.PROCESS_START_STATUS_LABEL);
		//设置资产所属机构层次码-对应提交部门(发起人所在部门)
		entityItem.setEiorgsyscoding(expInfo.get(0).getOrgid());
		//设置资产所属模型层次码
		entityItem.setEsyscoding("999013");
		//设置资产管理人ID
		entityItem.setEiuserid(participantInfo.get(0).getUserid());
		//设置资产管理人姓名
		entityItem.setEiusername(participantInfo.get(0).getUsername());
		
		//创建资产属性信息列表
		List<EntityItemConfigValueInfo> configItems = new ArrayList<EntityItemConfigValueInfo>();
		
		//资产属性列表
		String[] itemNames = new String[]{"文档类型","文档分类","文档密级","文档编号","文档保管期限","保密性要求","存储方式","是否可下载","存放位置"};
		for(int i=0;i<itemNames.length;i++){
			//添加资产属性信息
			EntityItemConfigValue configItem = new EntityItemConfigValue();
			configItem.setName(itemNames[i]);
			String value = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), itemNames[i]);
			configItem.setValue(value);
			configItems.add(configItem);
		}
		
		//获取流程附件
		IG036SearchCondImpl cond036 = new IG036SearchCondImpl();
		cond036.setPrid(bean.getLogInfo().getPrid());//流程ID
		cond036.setRlType(IGPRDCONSTANTS.RECORDLOG_TYPE_CL);//处理日志
		//根据用户角色查找角色日志
		List<IG036Info> lst_IG036Info = workFlowOperationBL.searchUserRoleRecondLog(cond036);
		
		//获取附件信息
		List<Attachment> lst_attachment = new ArrayList<Attachment>();
		for(IG036Info info : lst_IG036Info){
			if(info.getRlattkey() != null && !info.getRlattkey().isEmpty()){
				lst_attachment = attachmentBL.searchAttachmentsByAttkey(info.getRlattkey());
			}
		}
		
		//添加文档文件
		String docname = "";
		if(lst_attachment != null && lst_attachment.size() > 0){
			docname = lst_attachment.get(0).getAttname().split("_")[lst_attachment.get(0).getAttname().split("_").length-1].replace(".", "_1.");
		}
		EntityItemConfigValue configItem = new EntityItemConfigValue();
		configItem.setName("文档文件");
		configItem.setValue(docname);	
		configItem.setFile(null);
		configItems.add(configItem);
		
		//添加"归档部门"配置项设置
		configItem = new EntityItemConfigValue();
		configItem.setName("归档部门");
		configItem.setValue(participantInfo.get(0).getOrgname());
		configItems.add(configItem);
		
		entityItem.setConfigItems(configItems);

		//添加资产
		Integer eiid = flowSetBL.createEntityItem(entityItem);

		if(!"".equals(docname)){
			//文件复制
			StringBuffer rfilename = new StringBuffer();
			rfilename.append(getResourceProperty("UPLOAD_FILE_ROOT_PATH"));
			rfilename.append(lst_attachment.get(0).getAtturl());
			rfilename.append(File.separator);
			rfilename.append(lst_attachment.get(0).getAttname());
			
			StringBuffer cfilename = new StringBuffer();
			cfilename.append(getResourceProperty("UPLOAD_FILE_ROOT_PATH"));
			cfilename.append("asm"+File.separator);
			cfilename.append(eiid);
			//创建目标文件夹
			boolean isCreate = new File(cfilename.toString()).mkdir();
			if(!isCreate){
				log.error(cfilename.toString()+"创建失败");
			}
			
			cfilename.append(File.separator);
			cfilename.append(docname);
			
			try{
				FileUtils.copyFile(new File(rfilename.toString()), new File(cfilename.toString()));
			}catch (Exception e) {
				log.error("文件复制失败",e);
			}
		}
		
		
		//获取文档编号
		String documentNum = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(),"文档编号");
		IG599SearchCondImpl ig599Cond = new IG599SearchCondImpl();
		ig599Cond.setPivarname("文档编号");
		ig599Cond.setPivarvalue(documentNum);
		List<IG599Info> ig500List = ig599BL.searchIG599InfosByCond(ig599Cond);
		//判断文档编号是否存在
		if(null != ig500List && ig500List.size() > 0){
			for (IG599Info ig599Info : ig500List) {
				//排除当前流程编号之外如果存在则提示信息
				if(!bean.getLogInfo().getPrid().equals(ig599Info.getPrid())){
					throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCRC0803.E002");
				}
			}
		}
		
		//如果文档编号超出99 提示信息
		if(documentNum != null && documentNum.length() > 10){
			if(Integer.parseInt(documentNum.substring(10)) > 99){
				throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCRC0803.E001");
			}
		}
		
		log.debug("=====================入库申请流程关闭的前置处理开始=====================");
	}

	/**
	 * 后处理
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

}