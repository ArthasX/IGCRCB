package com.deliverik.infogovernor.drm.igflow.button;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

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
import com.deliverik.framework.workflow.prd.model.IG480Info;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prd.model.entity.IG126TB;
import com.deliverik.framework.workflow.prd.model.entity.IG243TB;
import com.deliverik.framework.workflow.prd.model.entity.IG333TB;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;
import com.deliverik.framework.workflow.prd.model.entity.IG480TB;
import com.deliverik.framework.workflow.prd.model.entity.IG560TB;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;

/**
 * <p>
 * 场景定义待发起节点（第一页）点击【下一步】按钮事件
 * 场景新增时：新生成一个场景流程定义
 * 场景复制时：复制一个场景流程定义
 * 
 * </p>
 */
public class IGDRMBTN0101BLImpl extends BaseBLImpl implements
		WorkFlowStatusButtonHandlerBL {
	
	static Log log = LogFactory.getLog(IGDRMBTN0101BLImpl.class);

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
		log.info("========预案定义待发起保存按钮处理开始========");
		//单一场景定义流程实例信息
		IG500Info ig500Info = ig500BL.searchIG500InfoByKey(bean.getLogInfo().getPrid());
		//场景名称
		String prtitle = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "场景名称");
		//预案描述
		String pddesc = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "场景描述");
		//场景应急处置步骤
		String stepPdid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "场景应急处置步骤");
		//原场景定义prid
		String oprid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "定义场景流程ID");
		//场景类型
		String scenetype = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "场景类型");
		if(StringUtils.isNotEmpty(scenetype)&&"单一场景".equals(scenetype)){
			//场景流程新增 >-场景应急处置步骤pdid为空
			if(StringUtils.isEmpty(stepPdid)){
				//如果stepPdid为空 则为发起流程的第一步
				// 查询流程模板信息
				IG259Info pt = workFlowDefinitionBL.searchProcessTemplateByKey(22);
				// 获取流程定义ID
				String pdid = workFlowDefinitionBL.getProcessDefinitionPK(pt.getFirstsite(),pt.getPdsequence());
				// 设定流程定义基本信息
				IG380TB ptTB = new IG380TB(); 
				ptTB.setPdid(pdid); // 流程定义ID
				ptTB.setPtid(22); // 模板ID
				ptTB.setPdname(prtitle); // 预案名称
				ptTB.setPddesc(pddesc); // 预案描述
				ptTB.setPdcrtdate(IGStringUtils.getCurrentDate()); // 创建时间
				ptTB.setPdstatus(IGPRDCONSTANTS.PD_STATUS_DISABLE); // 流程定义状态，默认为停用
				ptTB.setPermission("0");
				String newXml = "<WebFlow><BaseProperties flowId=\"0133301\" flowText=\"asdf\"/><Steps><Step><BaseProperties id=\"0133301001\" text=\"待发起\" stepType=\"BeginStep\"/><BasicInfo psdid=\"0133301001\" pdid=\"0133301\" psdname=\"待发起\" psddesc=\"流程默认开始状态\" psdcode=\"Z\" psdtype=\"0\" psdmode=\"1\" psdflag=\"0\" psdconfirm=\"0\" bysequence=\"01\"/><VMLProperties width=\"50\" height=\"80\" x=\"732px\" y=\"444px\"/></Step><Step><BaseProperties id=\"0133301002\" text=\"关闭\" stepType=\"EndStep\"/><BasicInfo psdid=\"0133301002\" pdid=\"0133301\" psdname=\"关闭\" psddesc=\"流程默认结束状态\" psdcode=\"C\" psdtype=\"0\" psdmode=\"1\" psdflag=\"0\" psdconfirm=\"0\"/><VMLProperties width=\"50\" height=\"80\" x=\"732px\" y=\"444px\"/></Step></Steps><Actions/></WebFlow>";
				ptTB.setPdxml(newXml);
				ptTB.setMessagegenerator("igDRMMESSAGE0001BL");
				// 等级流程定义
				workFlowDefinitionBL.registProcessDefinition(ptTB);
				// 设定流程标题描述
				IG243TB ptdTB = new IG243TB();
				ptdTB.setPtdid(workFlowDefinitionBL.getProcessTitleDefPK(pdid)); // 主键
				ptdTB.setPdid(pdid); // 流程定义ID
				ptdTB.setPtitlename("事件标题"); // 标题表单显示名称
				ptdTB.setPtitleaccess("0"); // 标题表单是否可见
				ptdTB.setPdescname("事件描述"); // 描述表单显示名称
				ptdTB.setPdescaccess("0"); // 描述表单是否可见
				// 保存流程标题信息
				workFlowDefinitionBL.registProcessTitleDef(ptdTB);
				// 设定流程默认开始节点
				IG333TB psdStartTB = new IG333TB();
				psdStartTB.setPsdid(workFlowDefinitionBL.getProcessStatusDefPK(pdid));//主键
				psdStartTB.setPdid(pdid);//流程定义ID
				psdStartTB.setPsdcode(IGPRDCONSTANTS.PROCESS_START_STATUS);//开始状态
				psdStartTB.setPsdtype(IGPRDCONSTANTS.PROCESS_NODE_TYPE_NORMAL);//普通节点
				psdStartTB.setPsddesc(IGPRDCONSTANTS.PROCESS_START_STATUS_DESC);//说明
				psdStartTB.setPsdname(IGPRDCONSTANTS.PROCESS_START_STATUS_LABEL);//开始状态显示名称
				psdStartTB.setPsdmode(IGPRDCONSTANTS.MODE_NORMAL);//普通模式
				psdStartTB.setPsdflag(IGPRDCONSTANTS.NOT_NEED_ASSIGN); //开始状态是否可分派是"否"
				psdStartTB.setPsdconfirm(IGPRDCONSTANTS.SUBSTATUS_CONFIRM_NO);//无确认状态
				psdStartTB.setBysequence("01");
				//流程状态定义信息登记处理
				workFlowDefinitionBL.registProcessStatus(psdStartTB);
				
				// 设定流程默认关闭节点
				IG333TB psdEndTB = new IG333TB();
				psdEndTB.setPsdid(workFlowDefinitionBL.getProcessStatusDefPK(pdid));//主键
				psdEndTB.setPdid(pdid);//流程定义ID
				psdEndTB.setPsdcode(IGPRDCONSTANTS.PROCESS_END_STATUS);//结束状态
				psdEndTB.setPsdtype(IGPRDCONSTANTS.PROCESS_NODE_TYPE_NORMAL);//普通节点
				psdEndTB.setPsddesc(IGPRDCONSTANTS.PROCESS_END_STATUS_DESC);//说明
				psdEndTB.setPsdname(IGPRDCONSTANTS.PROCESS_END_STATUS_LABEL);//结束状态显示名称
				psdEndTB.setPsdmode(IGPRDCONSTANTS.MODE_NORMAL);
				psdEndTB.setPsdflag(IGPRDCONSTANTS.NOT_NEED_ASSIGN); //是否可分派是"否"
				psdEndTB.setPsdconfirm(IGPRDCONSTANTS.SUBSTATUS_CONFIRM_NO);//无确认状态
				// 流程状态定义信息登记处理
				workFlowDefinitionBL.registProcessStatus(psdEndTB);
				//设定默认的表单->"任务描述"、"任务结果"、"附件"
				
				try{
					creatFormList(pdid);
				}catch(Exception e){
					throw new BLException("IGCO10000.E141","生成表单信息出错!");
				}
				
				// 将流程定义ID设定到流程中
				PublicProcessInfoValue ppivInfo = new PublicProcessInfoValue(bean.getLogInfo());
				ppivInfo.setFormname("场景应急处置步骤");
				ppivInfo.setFormvalue(pdid);
				flowSetBL.setPublicProcessInfoValue(ppivInfo);
				// 设定自定义处理页
				IG126TB pjdTB = new IG126TB();
				pjdTB.setPjdid(workFlowDefinitionBL.getProcessJspDefPK(pdid));
				pjdTB.setPdid(pdid);
				pjdTB.setPjdtype("2");
				pjdTB.setPjdurl("/drm/IGDRM0110.jsp");
				workFlowDefinitionBL.registProcessJspDef(pjdTB);
			}else{
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
				
			}
		}else if(StringUtils.isNotEmpty(scenetype)&&"组合场景".equals(scenetype)){
			if(StringUtils.isEmpty(stepPdid)){
				// 查询流程模板信息
				IG259Info pt = workFlowDefinitionBL.searchProcessTemplateByKey(22);
				// 获取流程定义ID
				String pgdid = workFlowDefinitionBL.getProcessDefinitionPK(pt.getFirstsite(),pt.getPdsequence());
				//流程组定义id
				IG480TB ig480TB = new IG480TB();
				ig480TB.setPgdid(pgdid);
				ig480TB.setPgdname(prtitle);//组合场景名称
				ig480TB.setPgddesc(pddesc);//组合场景描述
				ig480TB.setPgdcrtime(IGStringUtils.getCurrentDate()); // 创建时间
				ig480TB.setPgdstatus(IGPRDCONSTANTS.PD_STATUS_DISABLE); // 流程定义状态，默认为停用
				ig480TB.setPtid(22);
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
			}else{
				//组合场景复制>流程
				String newPdid = workFlowDefinitionBL.copyGroupProcessDefVersion(stepPdid);
				// 将流程定义ID设定到流程中
				PublicProcessInfoValue ppivInfo = new PublicProcessInfoValue(bean.getLogInfo());
				ppivInfo.setFormname("场景应急处置步骤");
				ppivInfo.setFormvalue(newPdid);
				flowSetBL.setPublicProcessInfoValue(ppivInfo);
				// 更新流程定义状态为启用-场景流程
		    	IG480Info pdInfo = workFlowDefinitionBL.searchGroupProcessDefinitionByKey(newPdid);
		    	IG480TB pdTB = (IG480TB) SerializationUtils.clone(pdInfo);
		    	pdTB.setPgdstatus(IGPRDCONSTANTS.PD_STATUS_DISABLE);
		    	workFlowDefinitionBL.updateGroupProcessDefinition(pdTB);
		    	//原应急资源资产ID
				String oldEiid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "原应急资源资产ID");
				//拷贝原 资产表单-应急资源到ig731表中
				if(!"".equals(oldEiid)){
					flowSetBL.setProcessEntityRelation(bean.getLogInfo().getPrid(), "应急资源", Integer.valueOf(oldEiid), null);
				}
				//原流程-应急资源资产List
				List<ProcessInfoEntityInfo> piList = flowSearchBL.searchProcessEntityItem(Integer.valueOf(oprid), "应急资源");
				//拷贝原 资产表单-应急资源到ig731表中
				if(null!=piList){
					for(ProcessInfoEntityInfo piInfo : piList){
						//应急资源信息
						EntityItemInfo eiInfo = flowSearchBL.searchEntityItem(piInfo.getEiid());
						//场景定义流程和应急资源资产建立关系
						flowSetBL.setProcessEntityRelation(bean.getLogInfo().getPrid(), "应急资源", piInfo.getEiid(), eiInfo.getEiversion());
					}	
				}
			}
		}else{
			//场景类型没取到
		}
		//场景定义流程title更新-ig500
		IG500TB prTB = (IG500TB)SerializationUtils.clone(ig500Info);
		prTB.setPrtitle(prtitle);
		ig500BL.updateIG500Info(prTB);
		
	}
	
	
	/**
	 * 生成状态表单
	 * @param pdid
	 */
	@SuppressWarnings("unchecked")
	private void creatFormList(String pdid)throws Exception{
			log.info("==========获取状态表单信息开始=============");
			try{
				File xml = new File(getAbsolutePathByClass()+"WEB-INF/prrxml/formDef.xml");
				SAXBuilder builder = new SAXBuilder();  
		          
		        org.jdom.Document doc = builder.build(xml);  
		        Element element = doc.getRootElement();
		        List<Element> elArr =  element.getChildren();
		        
				for (int i = 0; i < elArr.size(); i++) {
					Element el = elArr.get(i);
					// 设定默认表单"附件"
					IG007TB attTB = new IG007TB();
					attTB.setPidid(workFlowDefinitionBL.getProcessInfoDefPK(pdid));
					attTB.setPdid(pdid);
					el.getAttributeValue("pidname");
					attTB.setPidname(el.getAttributeValue("pidname"));
					attTB.setPidlabel(el.getAttributeValue("pidname"));
					attTB.setPidtype(el.getAttributeValue("pidtype"));
					attTB.setPiddefault("");
					attTB.setPidrequired("0");
					attTB.setPidsortid(StringUtils.leftPad(String.valueOf(i), 2, "0"));
					attTB.setPidmode("2");
					attTB.setHasattach("N");
					attTB.setRowwidth("0");
					attTB.setPidwidth(0);
					attTB.setPidrows(0);
					attTB.setShowrownum("Y");
					attTB.setShowline("1");
					attTB.setRemarks("0");
					attTB.setShowstyles("0");
					attTB.setTitledisplay("L");
					attTB.setNeedidea("N");
					attTB.setPidratio("3_5");
					attTB.setPidsize(0);
					attTB.setSelecedlast("N");
					attTB.setNumbertype("0");
//					if(el.getAttributeValue("optarr")!=null)
					attTB.setPidoption(el.getAttributeValue("optarr"));
					attTB.setPiduse(el.getAttributeValue("isuse"));
					workFlowDefinitionBL.registProcessInfoDef(attTB);
					
				}
			}catch(Exception e){
				e.printStackTrace();
				throw e;
			}
			log.info("==========获取状态表单信息结束=============");
	}

	/**
	 * 通过类路径来取工程路径
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getAbsolutePathByClass(){
		String webPath = this.getClass().getResource("").getPath().replaceAll("^\\/", "");
		webPath = webPath.substring(0,webPath.indexOf("/com/"));
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
	
	public static void main(String[] args) {
		IGDRMBTN0101BLImpl a = new IGDRMBTN0101BLImpl();
		System.out.println(a.getAbsolutePathByClass());
	}
}
