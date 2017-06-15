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
import com.deliverik.framework.workflow.prd.bl.task.IG480BL;
import com.deliverik.framework.workflow.prd.bl.task.IG560BL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;
import com.deliverik.framework.workflow.prd.model.entity.IG480TB;
import com.deliverik.framework.workflow.prd.model.entity.IG560TB;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;

/**
 * 组合场景定义待发起节点（第一页）点击【下一步】按钮事件
 * 场景新增时：新生成一个组合场景流程定义
 * 场景复制时：复制一个组合场景流程定义（待修改）
 */
public class IGDRMBTN0201BLImpl extends BaseBLImpl implements
		WorkFlowStatusButtonHandlerBL {
	
	static Log log = LogFactory.getLog(IGDRMBTN0201BLImpl.class);

	/** 更新功能API类 */
	private FlowSetBL flowSetBL;
    /** 查询类功能API类 */
    private FlowSearchBL flowSearchBL;
    /** 流程定义功能BL */
    private WorkFlowDefinitionBL workFlowDefinitionBL;
    /** 流程实例功能BL */
    protected IG500BL ig500BL;
    /**流程参与者定义业务逻辑处理BL*/
   	protected IG560BL ig560BL;
   	/** 流程组定义功能BL */
   	protected IG480BL ig480BL;
   	
	/**
	 * @param ig480bl the 流程组定义功能BL to set
	 */
	public void setIg480BL(IG480BL ig480bl) {
		ig480BL = ig480bl;
	}
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
	 * 场景定义待发起节点（第一页）点击【下一步】按钮事件
	 * @param WorkFlowStatusEventBeanInfo bean
	 * @throws BLException
	 */
	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========预案定义待发起保存按钮处理开始========");
		//组合场景定义流程实例信息
		IG500Info ig500Info = ig500BL.searchIG500InfoByKey(bean.getLogInfo().getPrid());
		//场景名称
		String prtitle = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "场景名称");
		//预案描述
		String pddesc = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "场景描述");
		//场景应急处置步骤
		String stepPdid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "场景应急处置步骤");
		//原场景定义prid
		String oprid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "定义场景流程ID");
		//场景流程新增 >-场景应急处置步骤pdid为空
		if(StringUtils.isEmpty(stepPdid)){
			//如果stepPdid为空 则为发起流程的第一步
			
			// 查询流程模板信息
			IG259Info pt = workFlowDefinitionBL.searchProcessTemplateByKey(19);
			// 获取流程定义ID
			String pgdid = workFlowDefinitionBL.getProcessDefinitionPK(pt.getFirstsite(),pt.getPdsequence());
			//流程组定义id
			IG480TB ig480TB = new IG480TB();
			ig480TB.setPgdid(pgdid);
			ig480TB.setPgdname(prtitle);//组合场景名称
			ig480TB.setPgddesc(pddesc);//组合场景描述
			ig480TB.setPgdcrtime(IGStringUtils.getCurrentDate()); // 创建时间
			ig480TB.setPgdstatus(IGPRDCONSTANTS.PD_STATUS_DISABLE); // 流程定义状态，默认为停用
			ig480TB.setPtid(19);
			//xml组织格式
			//开始组织数据
			StringBuffer jsonTemp = new StringBuffer("<GroupFlow ");
			jsonTemp.append(" contentHeight= \""+400+"\">");
			jsonTemp.append(" <BaseProperties pgdid= \""+pgdid+"\"");
			jsonTemp.append(" pgdname=  \""+prtitle+"\"/>");
			jsonTemp.append("<WebFlows>");
			//组织结尾数据
			//组织结尾数据
			jsonTemp.append("</" + "WebFlows>");
			jsonTemp.append("<FlowActions>");
			jsonTemp.append("</FlowActions>");
			jsonTemp.append("</GroupFlow>");
			ig480TB.setPgdxml(jsonTemp.toString());
			ig480BL.registIG480(ig480TB);
			// 将流程定义ID设定到流程中
			PublicProcessInfoValue ppivInfo = new PublicProcessInfoValue(bean.getLogInfo());
			ppivInfo.setFormname("场景应急处置步骤");
			ppivInfo.setFormvalue(pgdid);
			flowSetBL.setPublicProcessInfoValue(ppivInfo);
		}else{//---------------------场景复制待修改----------------
			//场景复制>流程
			String newPdid = workFlowDefinitionBL.copyProcessDefVersion(stepPdid);
			// 将流程定义ID设定到流程中
			PublicProcessInfoValue ppivInfo = new PublicProcessInfoValue(bean.getLogInfo());
			ppivInfo.setFormname("场景应急处置步骤");
			ppivInfo.setFormvalue(newPdid);
			flowSetBL.setPublicProcessInfoValue(ppivInfo);
			// 更新流程定义状态为启用-场景流程
	    	IG380Info pdInfo = workFlowDefinitionBL.searchProcessDefinitionByKey(newPdid);
	    	IG380TB pdTB = (IG380TB) SerializationUtils.clone(pdInfo);
	    	pdTB.setPdstatus(IGPRDCONSTANTS.PD_STATUS_DISABLE);
	    	workFlowDefinitionBL.updateProcessDefinition(pdTB);
	    	//原应急资源资产ID
			String oldEiid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "原应急资源资产ID");
			//拷贝原 资产表单-应急资源到ig731表中
			if(!"".equals(oldEiid)){
				flowSetBL.setProcessEntityRelation(bean.getLogInfo().getPrid(), "应急资源", Integer.valueOf(oldEiid), null);
			}
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
			ig560Cond.setPidid_l(stepPdid);
			List<IG560Info> ig560List = ig560BL.searchIG560(ig560Cond);
			List<IG560Info> ig560NewList = new ArrayList<IG560Info>();
			for(int i=0;i<ig560List.size();i++){
				IG560TB ig560tb = new IG560TB();
				ig560tb = (IG560TB)SerializationUtils.clone(ig560List.get(i));
				ig560tb.setDvid(null);
				ig560tb.setPidid(newPdid+ig560List.get(i).getPidid().substring(7));
				ig560tb.setPsdid(newPdid+ig560List.get(i).getPsdid().substring(7));
				ig560NewList.add(ig560tb);
			}
			ig560BL.saveOrUpdateAll(ig560NewList);
		}
		//场景定义流程title更新-ig500
		IG500TB prTB = (IG500TB)SerializationUtils.clone(ig500Info);
		prTB.setPrtitle(prtitle);
		ig500BL.updateIG500Info(prTB);
		
		
	}
	
	
	/**
	 * 通过类路径来取工程路径
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getAbsolutePathByClass(){
		String webPath = this.getClass().getResource("/").getPath().replaceAll("^\\/", "");
		webPath = webPath.replaceAll("[\\\\\\/]WEB-INF[\\\\\\/]classes[\\\\\\/]?", "/");
		webPath = webPath.replaceAll("[\\\\\\/]+", "/");
		webPath = webPath.replaceAll("%20", " ");
		if (webPath.matches("^[a-zA-Z]:.*?$")) {

		} else {
			webPath = "/" + webPath;
		}
		webPath += "/";
		webPath = webPath.replaceAll("[\\\\\\/]+", "/");
		return webPath;
	}
}
