package com.deliverik.infogovernor.drm.igflow.button;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.resultset.EntityItemInfo;
import com.deliverik.framework.igflow.resultset.ProcessInfoEntityInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG560BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG333TB;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;
import com.deliverik.framework.workflow.prd.model.entity.IG560TB;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;

/**
 * 组合场景修订 待发起节点（第一页）点击【下一步】按钮事件
 * 将被修订的场景流程升版
 * 
 */
public class IGDRMBTN0202BLImpl extends BaseBLImpl implements
		WorkFlowStatusButtonHandlerBL {
	
	static Log log = LogFactory.getLog(IGDRMBTN0202BLImpl.class);

	/** 更新功能API类 */
	private FlowSetBL flowSetBL;
    /** 查询类功能API类 */
    private FlowSearchBL flowSearchBL;
    /** 流程定义功能BL */
    private WorkFlowDefinitionBL workFlowDefinitionBL;
    protected IG500BL ig500BL;
    /**流程参与者定义业务逻辑处理BL*/
   	protected IG560BL ig560BL;
   	
   	protected IG333BL ig333BL;
	/**
	 * @param ig560bl the ig560BL to set
	 */
	public void setIg560BL(IG560BL ig560bl) {
		ig560BL = ig560bl;
	}
	public void setIg500BL(IG500BL ig500BL) {
		this.ig500BL = ig500BL;
	}

	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
        this.flowSearchBL = flowSearchBL;
    }

	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	
	/**
	 * @param ig333bl the ig333BL to set
	 */
	public void setIg333BL(IG333BL ig333bl) {
		ig333BL = ig333bl;
	}
	/**
	 * 场景修订待发起节点（第一页）点击【下一步】按钮事件
	 * @param WorkFlowStatusEventBeanInfo bean
	 * @throws BLException
	 */
	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========预案定义待发起保存按钮处理开始========");
		//String oldXml = null;
		IG380TB new380TB = null;
		//单一场景定义流程实例信息
		IG500Info ig500Info = ig500BL.searchIG500InfoByKey(bean.getLogInfo().getPrid());
		//场景名称
		//String prtitle = ig500Info.getPrtitle();
		String prtitle = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "场景名称");
		// 预案描述
		String pddesc = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "场景描述");
		//原场景应急处置步骤
		String opdid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "场景应急处置步骤");
		//原场景定义prid
		String oprid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "定义场景流程ID");
		//修订
		if(StringUtils.isNotEmpty(opdid)){
			//升级原流程定义ID
			workFlowDefinitionBL.upgradeProcessDefVersion(opdid);
			//流程版本号
			String version = StringUtils.leftPad(String.valueOf(Integer.parseInt(opdid.substring(5, 7)) + 1), 2, "0");
			//新版本流程pdid 0240101
			String pdid = opdid.substring(0, 5) + version;
			// 获取流程定义
			IG380Info cptInfo = workFlowDefinitionBL.searchProcessDefinitionByKey(pdid);
			// 更新流程定义基本信息-原流程开启
			IG380TB cptTB = (IG380TB) SerializationUtils.clone(cptInfo);
			cptTB.setPdstatus(IGPRDCONSTANTS.PD_STATUS_ENABLE);
			// 更新流程定义
			workFlowDefinitionBL.updateProcessDefinition(cptTB);
			// 获取新版本流程信息
			IG380Info ptInfo = workFlowDefinitionBL.searchProcessDefinitionByKey(pdid);
			// 更新流程定义基本信息
			new380TB = (IG380TB) SerializationUtils.clone(ptInfo);
			new380TB.setPdname(prtitle); // 预案名称
			new380TB.setPddesc(pddesc); // 预案描述
			if ("01".equals(bean.getPbdid())) {
				//oldXml = ptInfo.getPdxml();
				//new380TB.setPdxml(null);
			}
			// 更新流程定义基本信息-修订流程关闭
			new380TB.setPdcrtdate(IGStringUtils.getCurrentDate()); // 创建时间
			new380TB.setPdstatus(IGPRDCONSTANTS.PD_STATUS_DISABLE);
			
			// 更新流程定义
			workFlowDefinitionBL.updateProcessDefinition(new380TB);
			// 清空其他表数据
			//clearRelatedData(pdid);
			// 将流程定义ID设定到流程中
			PublicProcessInfoValue ppivInfo = new PublicProcessInfoValue(bean.getLogInfo());
			ppivInfo.setFormname("场景应急处置步骤");
			ppivInfo.setFormvalue(pdid);
			flowSetBL.setPublicProcessInfoValue(ppivInfo);
			//场景定义流程title更新
			IG500TB prTB = (IG500TB) SerializationUtils.clone(ig500Info);
			prTB.setPrtitle(prtitle);
			ig500BL.updateIG500Info(prTB);
			//原流程-应急资源资产List
			List<ProcessInfoEntityInfo> piList = flowSearchBL.searchProcessEntityItem(Integer.valueOf(oprid), "应急资源");
			//原应急资源资产ID
			//String oldEiidStr = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "原应急资源资产ID");
			//Eiversion(Eiid
			//String[] oldEiidArr = oldEiidStr.split("_");
			//拷贝原 资产表单-应急资源到ig731表中
			if(null!=piList){
				for(ProcessInfoEntityInfo piInfo : piList){
					//应急资源信息
					EntityItemInfo eiInfo = flowSearchBL.searchEntityItem(piInfo.getEiid());
					//场景定义流程和应急资源资产建立关系
					flowSetBL.setProcessEntityRelation(bean.getLogInfo().getPrid(), "应急资源", piInfo.getEiid(), eiInfo.getEiversion());
				}
			}
			//复制状态级表单默认值↓↓↓↓↓↓
			//查询所有状态级表单的默认值-ig560表 - 
			IG560SearchCondImpl ig560Cond = new IG560SearchCondImpl();
			ig560Cond.setPidid_l(opdid);
			List<IG560Info> ig560List = ig560BL.searchIG560(ig560Cond);
			List<IG560Info> ig560NewList = new ArrayList<IG560Info>();
			for(int i=0;i<ig560List.size();i++){
				IG560TB ig560tb = new IG560TB();
				ig560tb = (IG560TB)SerializationUtils.clone(ig560List.get(i));
				ig560tb.setDvid(null);
				ig560tb.setPidid(pdid+ig560List.get(i).getPidid().substring(7));
				ig560tb.setPsdid(pdid+ig560List.get(i).getPsdid().substring(7));
				ig560NewList.add(ig560tb);
			}
			ig560BL.saveOrUpdateAll(ig560NewList);
			
			//遍历节点信息 更新 fingerPrint（标记上一节点id用字段） - 流程号升版 
			IG333SearchCondImpl sCond = new IG333SearchCondImpl();
			sCond.setPdid(pdid);
			List<IG333Info> psLst = ig333BL.searchIG333Info(sCond);
			for(int i=0;i<psLst.size();i++){
				String fingerPrint = psLst.get(i).getFingerPrint();
				if(StringUtils.isEmpty(fingerPrint)){
					continue;
				}
				String[] fingerArr = fingerPrint.split("_");
				String upFinger = "";
				for(int j=0;j<fingerArr.length;j++){
					//02401 + 02 + 001  version->02
					String fin = fingerArr[j].substring(0, 5) + version + fingerArr[j].substring(7);
					upFinger += (""==upFinger)?fin:("_"+fin);
				}
				IG333TB ig333TB = (IG333TB)SerializationUtils.clone(psLst.get(i));
				ig333TB.setFingerPrint(upFinger);
				ig333BL.updateIG333Info(ig333TB);
			}
				
		}else{
			log.error("原场景应急处置步骤流程定义ID不存在！");
		}
	}
	
	

}
