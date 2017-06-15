/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.bl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.bl.task.IG007BL;
import com.deliverik.framework.workflow.prd.bl.task.IG222BL;
import com.deliverik.framework.workflow.prd.bl.task.IG273BL;
import com.deliverik.framework.workflow.prd.bl.task.IG298BL;
import com.deliverik.framework.workflow.prd.bl.task.IG413BL;
import com.deliverik.framework.workflow.prd.bl.task.IG560BL;
import com.deliverik.framework.workflow.prd.bl.task.IG699BL;
import com.deliverik.framework.workflow.prd.bl.task.IG725BL;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG156Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG233Info;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.IG298Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG413Info;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.IG699Info;
import com.deliverik.framework.workflow.prd.model.IG725Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG156SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG233SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG273SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG298SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG413SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG699SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG725SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prd.model.entity.IG156TB;
import com.deliverik.framework.workflow.prd.model.entity.IG222TB;
import com.deliverik.framework.workflow.prd.model.entity.IG233TB;
import com.deliverik.framework.workflow.prd.model.entity.IG273TB;
import com.deliverik.framework.workflow.prd.model.entity.IG298TB;
import com.deliverik.framework.workflow.prd.model.entity.IG333TB;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;
import com.deliverik.framework.workflow.prd.model.entity.IG413TB;
import com.deliverik.framework.workflow.prd.model.entity.IG560TB;
import com.deliverik.framework.workflow.prd.model.entity.IG699TB;
import com.deliverik.framework.workflow.prd.model.entity.IG725TB;
import com.deliverik.infogovernor.prd.dto.IGPRD10DTO;
import com.deliverik.infogovernor.prd.form.IGPRD1002Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程定义BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRD10BLImpl extends BaseBLImpl implements IGPRD10BL{

	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGPRD10BLImpl.class);
	
	/** 流程定义BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	/** 流程定义BL */
	protected IG222BL ig222BL;
	/** 流程定义BL */
	protected IG298BL ig298BL;
	/**流程参与者定义业务逻辑处理BL*/
	protected IG560BL ig560BL;
	
	/** 流程定义BL */
	protected IG273BL ig273BL;

	/**
	 * @param ig273bl the ig273BL to set
	 */
	public void setIg273BL(IG273BL ig273bl) {
		ig273BL = ig273bl;
	}


	public void setIg222BL(IG222BL ig222bl) {
		ig222BL = ig222bl;
	}


	public void setIg298BL(IG298BL ig298bl) {
		ig298BL = ig298bl;
	}

	public void setIg560BL(IG560BL ig560bl) {
		ig560BL = ig560bl;
	}


	/**
	 * 流程定义BL设定
	 * @param workFlowDefinitionBL 流程定义BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	
	
	/**
	 * 流程定义信息查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD10DTO searchLastProcessDefinitionAction(IGPRD10DTO dto) throws BLException {
		log.debug("=============流程定义信息查询操作开始===============");
		//实例化查询条件 zx
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		this.copyProperties(cond, dto.getForm());
		int totalCount = workFlowDefinitionBL.getProcessDefinitionSearchLastCount(cond);
		
		if (totalCount == 0) {
			log.debug("========流程定义信息查询数据不存在========");
			//流程定义信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========流程定义信息查询数据件数过多========");
			//流程定义信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		//当前页流程定义信息取得
		List<IG380Info> processDefinitionList = workFlowDefinitionBL.searchLastProcessDefinition(cond, pDto.getFromCount(), pDto.getPageDispCount());
		dto.setProcessDefinitionList(processDefinitionList);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		log.debug("=============流程定义信息查询操作结束===============");
		return dto;
	}
	
	/**
	 * 加载流程定义信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD10DTO initProcessDefinitionAction(IGPRD10DTO dto) throws BLException {
		log.debug("=============加载流程定义信息操作开始=============");
		//dto参数取得
		if(dto.getForm() != null && dto.getForm() instanceof IGPRD1002Form){
			IG007BL ig007BL = (IG007BL) WebApplicationSupport.getBean("ig007BL");
			IG699BL ig699BL = (IG699BL) WebApplicationSupport.getBean("ig699BL");
			IGPRD1002Form form = (IGPRD1002Form) dto.getForm();
			//取得流程定义ID
			String pdid = form.getPdid();
			//拼接xml
			Document doc = DocumentHelper.createDocument();
			//初始化流程定义信息
			IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(pdid);
			Element rootElement = DocumentHelper.createElement("WebFlow");
			Element rootBase = DocumentHelper.createElement("BaseProperties");
			rootBase.addAttribute("flowId", pd.getPdid());
			rootBase.addAttribute("flowText", pd.getPdname());
			rootElement.add(rootBase);
			//初始化分派节点
			IG233SearchCondImpl assignCond = new IG233SearchCondImpl();
			assignCond.setPdid(pdid);
			List<IG233Info> assignList = workFlowDefinitionBL.searchAssignedDefInfo(assignCond);
			Map<String, List<IG233Info>> assignMap = new HashMap<String, List<IG233Info>>();
			for(IG233Info info:assignList){
				if(assignMap.get(info.getPsdid()) == null){
					assignMap.put(info.getPsdid(), new ArrayList<IG233Info>());
				}
				assignMap.get(info.getPsdid()).add(info);
			}
			//初始化按钮
			IG725SearchCondImpl psbCond = new IG725SearchCondImpl();
			psbCond.setPdbdid_like(pdid);
			List<IG725Info> psbList = workFlowDefinitionBL.searchParticipantDefaultButtonDef(psbCond);
			Map<String, Map<String, IG725Info>> psbMap = new HashMap<String,  Map<String, IG725Info>>();
			for(IG725Info info:psbList){
				if(psbMap.get(info.getPsdid()) == null){
					psbMap.put(info.getPsdid(), new HashMap<String, IG725Info>());
				}
				psbMap.get(info.getPsdid()).put(info.getPbdid(), info);
			}
			//初始化节点定义信息
			IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
			psdCond.setPdid(pdid);
			//是应急流程所需节点则设置应急标识
			psdCond.setDrmSign("drm");
			List<IG333Info> psdList = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
			Element steps = DocumentHelper.createElement("Steps");
			for(IG333Info info:psdList){
				Element step = DocumentHelper.createElement("Step");
				Element stepBase = DocumentHelper.createElement("BaseProperties");
				stepBase.addAttribute("id", info.getPsdid());
				stepBase.addAttribute("text", info.getPsdname());
				stepBase.addAttribute("ppsdid", info.getPpsdid());
				if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(info.getPsdcode())){
					stepBase.addAttribute("stepType", "EndStep");
				}else if(IGPRDCONSTANTS.PROCESS_START_STATUS.equals(info.getPsdcode())){
					stepBase.addAttribute("stepType", "BeginStep");
				}else if(IGPRDCONSTANTS.PROCESS_END_SUBSTATUS.equals(info.getPsdcode())){
					stepBase.addAttribute("stepType", "EndStep");
				}else{
					stepBase.addAttribute("stepType", "NormalStep");
				}
				//如果是待发起节点则用时设置成0
				if("待发起".equals(info.getPsdname())){
					stepBase.addAttribute("bysequence","0");
				}else{
					stepBase.addAttribute("bysequence",info.getBysequence());
				}
				
				step.add(stepBase);
				Element baseInfo = DocumentHelper.createElement("BasicInfo");
				//条件跃迁表单
				IG699SearchCondImpl ig699Cond = new IG699SearchCondImpl();
				ig699Cond.setPsdid(info.getPsdid());
				List<IG699Info> ig699InfoList = ig699BL.searchIG699Info(ig699Cond);
				if(ig699InfoList!=null && ig699InfoList.size()>0){
					for(IG699Info ig699Info:ig699InfoList){
						IG007Info ig007Info = ig007BL.searchIG007InfoByKey(ig699Info.getPidid());
						if(ig007Info!=null&&ig007Info.getPidname().equals("跃迁条件")){
							baseInfo.addAttribute("ig007Entity", "true");
						}
					}
				}
				addInfo(baseInfo,info);
				step.add(baseInfo);
				List<IG233Info> list = assignMap.get(info.getPsdid());
				if(list != null){
					Element psbs = DocumentHelper.createElement("AssignList");
					for(IG233Info psb:list){
						Element button = DocumentHelper.createElement("AssignInfo");
						addInfo(button,psb);
						psbs.add(button);
					}
					
					step.add(psbs);
				}
				
				//参与人
				IG222SearchCondImpl ig222Cond = new IG222SearchCondImpl();
				ig222Cond.setPsdid(info.getPsdid());
				List<IG222Info> parList = workFlowDefinitionBL.searchParticipantDef(ig222Cond);
				if(parList != null){
					Element psbs = DocumentHelper.createElement("Participants");
					for(IG222Info psb:parList){
						Element roleInfo = DocumentHelper.createElement("role");
						addInfo(roleInfo,psb);
						psbs.add(roleInfo);
					}
					step.add(psbs);
				}
				
				
				steps.add(step);
			}
			
			rootElement.add(steps);
			IG273SearchCondImpl pstCond = new IG273SearchCondImpl();
			pstCond.setPtdid_like(pdid);
			List<IG273Info> pstList = workFlowDefinitionBL.searchProcessTransitionDef(pstCond);
			Element actions = DocumentHelper.createElement("Actions");
			Element buttons = DocumentHelper.createElement("Buttons");
			for(IG273Info info:pstList){
			 	Element action = DocumentHelper.createElement("Action");
				Element actionBase = DocumentHelper.createElement("BaseProperties");
				actionBase.addAttribute("id", IGPRDCONSTANTS.IMG_ACTION_ID_BEGIN_WITH + info.getPtdid());
				actionBase.addAttribute("actionType", "PolyLine");
				actionBase.addAttribute("from", info.getFpsdid());
				actionBase.addAttribute("to", info.getTpsdid());
				actionBase.addAttribute("ppsdid", info.getFingerPrint());
				
				action.add(actionBase);
				Element rules = DocumentHelper.createElement("Rules");
				rules.addAttribute("ptdname", info.getPtdname());
				rules.addAttribute("ptddesc", info.getPtddesc());
				rules.addAttribute("ptdtype", info.getPtdtype());
				rules.addAttribute("ptdcond", info.getPtdcond());
				Map<String, IG725Info> map = psbMap.get(info.getFpsdid());
				if(map != null){
					if(StringUtils.isNotEmpty(info.getPtdcond())){
						String[] split = info.getPtdcond().split("!");
						if(split.length > 1){
							String pbid = split[1].split("#")[0];
							IG725Info pb = map.get(pbid);
							if(pb != null&&!"切换主备".equals(pb.getPdbdname())){
								rules.addAttribute("pbname", pb.getPdbdname());
							}
						}
					}
					//获取切换主备按钮
					if(map.get("15")!=null){
						IG725Info pb = map.get("15");
						Element button = DocumentHelper.createElement("Button");
						button.addAttribute("psdid", pb.getPsdid());
						buttons.add(button);
					}
				}
				action.add(rules);
				actions.add(action);
			}
			rootElement.add(actions);
			rootElement.add(buttons);
			doc.setRootElement(rootElement);
			addOtherInfo(doc,pd);
			form.setXml(doc.asXML());
		}
		log.debug("=============加载流程定义信息操作结束=============");
		return dto;
	}

	@SuppressWarnings("unchecked")
	private void addOtherInfo(Document doc, IG380Info pd) {
		if(StringUtils.isNotEmpty(pd.getPdxml())){
			try {
				Document flowXml = DocumentHelper.parseText(pd.getPdxml());
				Element root = flowXml.getRootElement();
				Map<String, Element> stepMap = new HashMap<String, Element>();
				Map<String, Element> actionMap = new HashMap<String, Element>();
				for(Iterator<Element> steps = root.element("Steps").elementIterator();steps.hasNext();){
					Element element = steps.next();
					String psdid = element.element("BaseProperties").attributeValue("id");
					stepMap.put(psdid, element);
				}
				for(Iterator<Element> actions = root.element("Actions").elementIterator();actions.hasNext();){
					Element element = actions.next();
					String ptdid = element.element("BaseProperties").attributeValue("id");
					actionMap.put(ptdid, element);
				}
				for(Iterator<Element> steps = doc.getRootElement().element("Steps").elementIterator();steps.hasNext();){
					Element element = steps.next();
					String psdid = element.element("BaseProperties").attributeValue("id");
					Element e = stepMap.get(psdid);
					Element vml = DocumentHelper.createElement("VMLProperties");
					vml.addAttribute("width", "50");
					vml.addAttribute("height", "80");
					if(e != null){
						Element rvml = e.element("VMLProperties");
						vml.addAttribute("x", rvml.attributeValue("x"));
						vml.addAttribute("y", rvml.attributeValue("y"));
					}
					element.add(vml);
				}
				for(Iterator<Element> actions = doc.getRootElement().element("Actions").elementIterator();actions.hasNext();){
					Element element = actions.next();
					String ptdid = element.element("BaseProperties").attributeValue("id");
					Element e = actionMap.get(ptdid);
					if(e != null){
						List<Element> list = e.elements("point");
						if(list != null){
							for(Element p:list){
								Element point = DocumentHelper.createElement("point");
								point.addAttribute("id", p.attributeValue("id"));
								point.addAttribute("x", p.attributeValue("x"));
								point.addAttribute("y", p.attributeValue("y"));
								element.add(point);
							}
						}
					}
				}
			} catch (DocumentException e) {
				log.error("",e);
			}
		}
	}


	private void addInfo(Element other, Object info) {
		Class<? extends Object> clz = info.getClass();
		Field[] fields = clz.getDeclaredFields();
		
		for(Field f:fields){
			f.setAccessible(true);
			try{
				Object o = f.get(info);
				if(o instanceof String || o instanceof Integer || o instanceof Double){
					other.addAttribute(f.getName(), o.toString());
				}else{
					other.addAttribute(f.getName(), "");
				}
			}catch (Exception e) {
				log.error("",e);
			}
		}
		//父类中的属性 - fingerprint
		Field[] superFields = clz.getSuperclass().getDeclaredFields();
		for(Field f:superFields){
			f.setAccessible(true);
			try{
				Object o = f.get(info);
				if(o instanceof String || o instanceof Integer || o instanceof Double){
					other.addAttribute(f.getName(), o.toString());
				}else{
					other.addAttribute(f.getName(), "");
				}
			}catch (Exception e) {
				log.error("",e);
			}
		}
	}
	
	private void parseInfo(Element e,Object o) throws BLException{
		Class<? extends Object> clz = o.getClass();
		//baseAction 属性
		Field[] superFields = clz.getSuperclass().getDeclaredFields();
		//当前类中的属性
		Field[] fields = Arrays.copyOf(clz.getDeclaredFields(), clz.getDeclaredFields().length+superFields.length);
		//将父类中的属性添加到属性数组中 被拷贝数组  被拷贝数组开始索引 拷贝到的数组 被拷贝数组放的位置  被拷贝数组的长度
		System.arraycopy(superFields, 0, fields, fields.length-superFields.length, superFields.length);
		
		for(Field f:fields){
			f.setAccessible(true);
			String ev = e.attributeValue(f.getName());
			ev = nullToEmpty(ev);
			String type = f.getType().toString();
			Object value = null;
			try{
				if(type.endsWith("java.lang.String")){
					value = ev;
				}else if(type.endsWith("java.lang.Integer")){
					if(!"".equals(ev)){
						value = Integer.valueOf(ev);
					}
				}else if(type.endsWith("java.lang.Double")){
					value = Double.valueOf(ev);
				}
				f.set(o, value);
			}catch (Exception ex) {
				log.error("",ex);
			}
		}
		
	}

	/**
	 * 更改流程定义操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public IGPRD10DTO changeProcessDefinitionAction(IGPRD10DTO dto) throws BLException {
		log.debug("================更改流程定义操作开始=================");
		if(dto.getForm() != null && dto.getForm() instanceof IGPRD1002Form){
			IGPRD1002Form form = (IGPRD1002Form) dto.getForm();
			IG007BL ig007BL = (IG007BL) WebApplicationSupport.getBean("ig007BL");
			IG699BL ig699BL = (IG699BL) WebApplicationSupport.getBean("ig699BL");
			try {
				Document doc = DocumentHelper.parseText(form.getXmlValue());
				//取得更节点
				Element root = doc.getRootElement();
				String pdid = root.element("BaseProperties").attributeValue("flowId");
				// 删除权限
				IG699SearchCondImpl ig699Cond = new IG699SearchCondImpl();
				ig699Cond.setPdvid_like(pdid);
				List<IG699Info> ig699InfoList = ig699BL.searchIG699Info(ig699Cond);
				if (ig699InfoList != null && ig699InfoList.size() > 0) {
					for (IG699Info ig699Info : ig699InfoList) {
						ig699BL.deleteIG699Info(ig699Info);
					}
				}
				//删除007中配置的跃迁条件
				IG007SearchCondImpl ig007Cond = new IG007SearchCondImpl();
				ig007Cond.setPdid(pdid);
				ig007Cond.setPidname("跃迁条件");
				List<IG007Info> ig007InfoList = ig007BL.searchIG007Info(ig007Cond, 0, 0);
				if(ig007InfoList!=null && ig007InfoList.size()>0){
					for(IG007Info ig007Info:ig007InfoList){
						ig007BL.deleteIG007Info(ig007Info);
					}
					
				}
				IG380TB pdTB = (IG380TB) workFlowDefinitionBL.searchProcessDefinitionByKey(pdid);
				//查询所有节点
				IG333SearchCondImpl psdCond = new IG333SearchCondImpl();
				psdCond.setPdid(pdid);
				List<IG333Info> psds = workFlowDefinitionBL.searchProcessStatusDef(psdCond);
				Map<String, IG333Info> psdMap = new HashMap<String, IG333Info>();
				for(IG333Info info:psds){
					psdMap.put(info.getPsdid(), info);
				}
				//取得所有节点信息
				List<IG333TB> psdList = new ArrayList<IG333TB>(); 
				for(Iterator<Element> steps = root.element("Steps").elementIterator("Step");steps.hasNext();){
					Element step = steps.next();
					Element base = step.element("BasicInfo");
					if(base != null){
						IG333TB psd = new IG333TB();
						parseInfo(base, psd);
						psdList.add(psd);
					}
				}
				//数据库添加节点信息
				if(psdList.size() > 0){
					for(IG333TB tb : psdList){
						//PPSDID外键约束BUG解决 当PPSDID 为空字符串时需要转换为NULL
						if(StringUtils.isEmpty(tb.getPpsdid())){
							tb.setPpsdid(null);
						}
						workFlowDefinitionBL.registProcessStatus(tb);
						IG333Info info = psdMap.get(tb.getPsdid());
						if(info != null){
							psdMap.remove(info.getPsdid());
						}
					}
				}
				
				//添加节点相关联信息
				//分派信息
				List<IG233TB> assignList = new ArrayList<IG233TB>();
				//删除 当前流程定义下的所有状态表单 默认值
				IG560SearchCondImpl ig560Cond = new IG560SearchCondImpl();
				ig560Cond.setPsdid_l(pdid);
				ig560Cond.setUsedToAll("F");
				List<IG560Info> ig560List = ig560BL.searchIG560(ig560Cond);
				for(IG560Info info:ig560List){
					ig560BL.deleteIG560ByPK(info.getDvid());
				}
				
				//清空当前流程的所有节点的前后处理
				IG413BL ig413BL = (IG413BL) WebApplicationSupport.getBean("ig413BL");
				IG413SearchCondImpl cond = new IG413SearchCondImpl();
				cond.setPdid(pdid);
				List<IG413Info> ig413Lst = ig413BL.searchIG413Info(cond);
				for(IG413Info info:ig413Lst){
					ig413BL.deleteIG413Info(info.getPedid());
				}
				//遍历状态节点
				for(Iterator<Element> steps = root.element("Steps").elementIterator("Step");steps.hasNext();){
					Element step = steps.next();
					Element base = step.element("BasicInfo");
					//当前节点psdid
					String curPsdid = base.attributeValue("psdid");
					//分派信息list
					Element assignLst = step.element("AssignList");
					if(null!=assignLst){
						for(Iterator<Element> assignIter = step.element("AssignList").elementIterator("AssignInfo");assignIter.hasNext();){
							Element next = assignIter.next();
							IG233TB assign = new IG233TB();
							parseInfo(next, assign);
							assignList.add(assign);
						}
					}
					//状态表单信息
					Element stepForm = step.element("StepForm");
					if(null!=stepForm){
						int index = 0;
						for(Iterator<Element> stepFormIter = step.element("StepForm").elementIterator("FormInfo");stepFormIter.hasNext();){
							index++;
							Element next = stepFormIter.next();
							next.attributeValue("pidtype");
							IG560TB ig560tb = new IG560TB();
							parseInfo(next, ig560tb);
							ig560tb.setUsedtoall("F");
							//去掉附件
//							if("F".equals(next.attributeValue("pidtype"))){
//								//20150324195106851000000000000002_#_新建文本文档.txt
//								ig560tb.setDfvalue(ig560tb.getDfvalue().split("_#_")[0]);	
//							}
							if(!"F".equals(next.attributeValue("pidtype"))){
								//资产表单
								if("4".equals(next.attributeValue("pidtype")) &&ig560tb.getPsdid().lastIndexOf("002") != 7){
									if(StringUtils.isNotBlank(ig560tb.getDfvalue()) && ig560tb.getDfvalue().split("_EIID_").length > 1 && ig560tb.getDfvalue().split("_EIID_")[1].split("_SOC_").length > 1){
										ig560tb.setDfvalue(ig560tb.getDfvalue().split("_EIID_")[0]+"_SOC_"+ig560tb.getDfvalue().split("_EIID_")[1].split("_SOC_")[1]);
									}
									
								}
								//过滤掉关闭节点
								if(ig560tb.getPsdid().lastIndexOf("002") != 7){
									ig560BL.registIG560(ig560tb);
								}
							}
							
						}
					}
					//插入跃迁条件表单
					Element ig007Entity = step.element("ig007Entity");
					if(null!=ig007Entity){
						IG007TB ig007TB = new IG007TB();
						ig007TB.setPidid(ig007Entity.attributeValue("pidid"));
						ig007TB.setPdid(ig007Entity.attributeValue("pdid"));
						ig007TB.setPidname(ig007Entity.attributeValue("pidname"));
						ig007TB.setPidlabel(ig007Entity.attributeValue("pidlabel"));
						ig007TB.setPidtype(ig007Entity.attributeValue("pidtype"));
						ig007TB.setPidoption(ig007Entity.attributeValue("pidoption"));
						ig007TB.setPidrequired(ig007Entity.attributeValue("pidrequired"));
						ig007TB.setPidsortid(ig007Entity.attributeValue("pidsortid"));
						ig007TB.setPidmode("0");
						ig007TB.setRowwidth(ig007Entity.attributeValue("rowwidth"));
						ig007TB.setSelecedlast(ig007Entity.attributeValue("selectedlast"));
						ig007TB.setNumbertype(ig007Entity.attributeValue("numbertype"));
						ig007TB.setShowline(ig007Entity.attributeValue("showline"));
						ig007TB.setRemarks(ig007Entity.attributeValue("remarks"));
						ig007TB.setShowstyles(ig007Entity.attributeValue("showstyles"));
						ig007TB.setTitledisplay(ig007Entity.attributeValue("titledisplay"));
						ig007TB.setPidrows(Integer.parseInt(ig007Entity.attributeValue("pidrows")));
						ig007TB.setPidwidth(Integer.parseInt(ig007Entity.attributeValue("pidwidth")));
						ig007TB.setPiduse(ig007Entity.attributeValue("piduse"));
						ig007TB.setNeedidea(ig007Entity.attributeValue("needidea"));
						ig007TB.setPidratio(ig007Entity.attributeValue("pidratio"));
						ig007TB.setPidsize(Integer.parseInt(ig007Entity.attributeValue("pidsize")));
						ig007TB.setHasattach(ig007Entity.attributeValue("hasattach"));
						ig007TB.setShowrownum(ig007Entity.attributeValue("showrownum"));
						ig007BL.registIG007Info(ig007TB);
						String stepId = ig007Entity.attributeValue("stepId");
						
						IG699TB ig699TB = new IG699TB();
						ig699TB.setPidid(ig007TB.getPidid());
						ig699TB.setPdvid(stepId+ig007TB.getPidid().substring(ig007TB.getPidid().length()-3, ig007TB.getPidid().length()));
						ig699TB.setPidrequired("1");
						ig699TB.setPsdid(stepId);
						ig699TB.setPidaccess("3");
						ig699BL.registIG699Info(ig699TB);
					}
					
					//删除参与者信息
					IG222SearchCondImpl ig222cond = new IG222SearchCondImpl();
					ig222cond.setPsdid(curPsdid);
					List<IG222Info>	ig222List = ig222BL.searchIG222Info(ig222cond);
					for(IG222Info delInfo:ig222List){
						ig222BL.deleteIG222Info(delInfo);
					}
					IG298SearchCondImpl ig298cond = new IG298SearchCondImpl();
					ig298cond.setPsdid(curPsdid);
					List<IG298Info>	ig298List = ig298BL.searchIG298Info(ig298cond);
					for(IG298Info delInfo:ig298List){
						ig298BL.deleteIG298Info(delInfo);
					}
					//参与人list
					Element participantsLst = step.element("Participants");
					if(null!=participantsLst){
						for(Iterator<Element> roleIter = step.element("Participants").elementIterator("role");roleIter.hasNext();){
							Element next = roleIter.next();
							IG222TB participants = new IG222TB();
							parseInfo(next, participants);
							String psdid = next.attributeValue("psdid");
							Integer roleid = Integer.valueOf(next.attributeValue("roleid"));
							participants.setPpdid(workFlowDefinitionBL.getParticipantDefPK(psdid));
							ig222BL.registIG222Info(participants);
							workFlowDefinitionBL.registParticipantDef(participants);
							
							IG298Info psrdInfo = workFlowDefinitionBL.checkProcessStatusRoleDefInfo(psdid,roleid);
							if(psrdInfo == null) {
								IG298TB psrdTB = new IG298TB();
								psrdTB.setPsrdid(workFlowDefinitionBL.getProcessStatusRoleDefInfoPK(psdid));
								psrdTB.setPsdid(psdid);
								psrdTB.setRoleid(1);
								workFlowDefinitionBL.registProcessStatusRoleDefInfo(psrdTB);
							}
						}
					}
					
					// 设定 场景的前后处理事件
					IG413TB preTB = new IG413TB();
					preTB.setPedid(workFlowDefinitionBL.getWorkFlowEventHandlerPK(curPsdid));
					preTB.setPdid(pdid);
					preTB.setPsdid(curPsdid);
					preTB.setPedtype("1");//前处理
					preTB.setPedblid("igDRMEVENT0103BL");
					preTB.setPedorder(2);
					ig413BL.registIG413Info(preTB);
					//设定 场景定义各个节点的处理人
					if(!"001".equals(curPsdid.substring(curPsdid.length()-3,curPsdid.length()))){
						IG413TB preTB2 = new IG413TB();
						preTB2.setPedid(workFlowDefinitionBL.getWorkFlowEventHandlerPK(curPsdid));
						preTB2.setPdid(pdid);
						preTB2.setPsdid(curPsdid);
						preTB2.setPedtype("1");// 前处理
						preTB2.setPedblid("igDRMEVENT0301BL");
						preTB2.setPedorder(1);
						ig413BL.registIG413Info(preTB2);
					}
					IG413TB flagTB = new IG413TB();
					flagTB.setPedid(workFlowDefinitionBL.getWorkFlowEventHandlerPK(curPsdid));
					flagTB.setPdid(pdid);
					flagTB.setPsdid(curPsdid);
					flagTB.setPedtype("2");//后处理
					flagTB.setPedblid("igDRMEVENT0103BL");
					flagTB.setPedorder(1);
					ig413BL.registIG413Info(flagTB);
					
					//将流程图中不需要的元素删除
					step.remove(base);
					step.remove(step.element("AssignList"));
					step.remove(step.element("attInfo"));
					step.remove(step.element("Participants"));
					step.remove(step.element("StepForm"));
				}
				//psdFlag 0：普通节点 1：开始和关闭节点
				if(psdList.size() > 0){
					for(IG333TB tb : psdList){
						String psdFlag = "0";
						//psdFlag 0：普通节点 1：开始和关闭节点 ZC
						if("Z".equals(tb.getPsdcode())||"C".equals(tb.getPsdcode())||"B".equals(tb.getPsdcode())){
							psdFlag = "1";
						}
						//设定按钮权限
						insertProcessDefaultButtonDef(tb.getPsdid(),psdFlag);
					}
				}
				if(assignList.size() > 0){
					for(IG233TB tb : assignList){
						workFlowDefinitionBL.registAssignedDefInfo(tb);
					}
				}
				
				//删除连接线
				IG273SearchCondImpl ig273cond = new IG273SearchCondImpl();
				ig273cond.setPtdid_like(pdid);
				List<IG273Info>	ig273List = ig273BL.searchIG273Info(ig273cond);
				for(IG273Info delInfo:ig273List){
					ig273BL.deleteIG273Info(delInfo);
				}
				//重置连接线
				for(Iterator<Element> actions = root.element("Actions").elementIterator("Action");actions.hasNext();){
					Element action = actions.next();
					Element base = action.element("BaseProperties");
					Element rules = action.element("Rules");
					IG273TB rTB = new IG273TB();
					rTB.setPtdid(base.attributeValue("id").substring(1));
					rTB.setFpsdid(base.attributeValue("from"));
					rTB.setTpsdid(base.attributeValue("to"));
					rTB.setFingerPrint(base.attributeValue("ppsdid"));
					if(null!=rules){
						rTB.setPtdname(rules.attributeValue("ptdname"));
						rTB.setPtddesc(rules.attributeValue("ptddesc"));
						rTB.setPtdtype(rules.attributeValue("ptdtype"));
						rTB.setPtdcond(rules.attributeValue("ptdcond"));
					}
					workFlowDefinitionBL.registProcessTransitionDef(rTB);
					action.remove(rules);
				}
				for(Iterator<Entry<String, IG333Info>> iter = psdMap.entrySet().iterator();iter.hasNext();){
					Entry<String, IG333Info> entry = iter.next();
					workFlowDefinitionBL.deleteProcessStatusDefByPK(entry.getValue().getPsdid());
				}
				pdTB.setPdxml(doc.asXML());
				workFlowDefinitionBL.updateProcessDefinition(pdTB);
				//重置切换主备按钮权限
				IG725BL ig725BL = (IG725BL) WebApplicationSupport.getBean("ig725BL");
				IG725SearchCondImpl ig725CondImpl = new IG725SearchCondImpl();
				ig725CondImpl.setPdbdid_like(pdid);
				List<IG725Info> psbList = workFlowDefinitionBL.searchParticipantDefaultButtonDef(ig725CondImpl);
				if(psbList!=null && psbList.size()>0){
					for(IG725Info ig725Info:psbList){
						if("切换主备".equals(ig725Info.getPdbdname())){
							ig725BL.deleteIG725Info(ig725Info);
						}	
					}
				}
				for(Iterator<Element> buttons = root.element("Buttons").elementIterator("Button");buttons.hasNext();){
					Element button = buttons.next();
					IG725TB ig725TB = new IG725TB();
					ig725TB.setPdbdid(button.attributeValue("psdid")+"003");
					ig725TB.setPsdid(button.attributeValue("psdid"));
					ig725TB.setPbdid("15");
					ig725TB.setPdbdname("切换主备");
					ig725TB.setPdbddesc("切换主备");
					ig725TB.setPdbdauth("0");
					ig725TB.setCheckrequired("0");
					ig725TB.setCheckrecord("0");
					ig725TB.setActurl("switchMaster");
					ig725BL.registIG725Info(ig725TB);
				}

			} catch (Exception e) {
				log.debug("=======保存场景定义错误========");

				e.printStackTrace();

				throw new BLException("IGCO10000.E141", "保存场景出错");

			}
		}
		log.debug("================更改流程定义操作结束=================");
		return dto;
	}
	
	/**
	 * 取得节点按钮信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD10DTO searchProcessStepButtonAction(IGPRD10DTO dto) throws BLException {
		log.debug("==============节点按钮信息取得操作开始==============");
		if(dto.getForm() != null && dto.getForm() instanceof IGPRD1002Form){
			IGPRD1002Form form = (IGPRD1002Form) dto.getForm();
			//初始化按钮
			IG725SearchCondImpl psbCond = new IG725SearchCondImpl();
			psbCond.setPdbdid_like(form.getPsdid());
			List<IG725Info> psbList = workFlowDefinitionBL.searchParticipantDefaultButtonDef(psbCond);
			//拼接xml
			Document doc = DocumentHelper.createDocument();
			Element root = DocumentHelper.createElement("Buttons");
			for(IG725Info info:psbList){
				Element b = DocumentHelper.createElement("Button");
				addInfo(b, info);
				root.add(b);
			}
			doc.setRootElement(root);
			dto.setAjaxResult(doc.asXML());
		}
		log.debug("==============节点按钮信息取得操作结束==============");
		return dto;
	}

	/**
	 * 设定按钮权限-和按钮BL
	 * @param psdid
	 * @param psdFlag 0：普通节点 1：开始和关闭节点
	 * @throws BLException
	 */
	private void insertProcessDefaultButtonDef(String psdid,String psdFlag) throws BLException {
		
		// 设定按钮权限
		//↓↓↓↓↓清除该节点原来的按钮权限
		IG725TB pdbdTB = new IG725TB();
		IG725SearchCondImpl cond = new IG725SearchCondImpl();
		cond.setPsdid(psdid);
		List<IG725Info> infoList = workFlowDefinitionBL.searchParticipantDefaultButtonDef(cond);
		for(int i=0;i<infoList.size();i++){
			workFlowDefinitionBL.deleteParticipantDefaultButtonDefByKey(infoList.get(i).getPdbdid());
		}
		//↑↑↑↑↑清除该节点原来的按钮权限
		//↓↓↓↓↓清除该节点原来的中止按钮处理BL
		IG156SearchCondImpl ig156Cond = new IG156SearchCondImpl();
		ig156Cond.setPsdid(psdid);
		List<IG156Info> ig156List = workFlowDefinitionBL.searchProcessStatusButtonDef(ig156Cond);
		for(int i=0;i<ig156List.size();i++){
			workFlowDefinitionBL.deleteProcessStatusButtonDefByPK(ig156List.get(i).getPseid());
		}
		//↑↑↑↑↑清除该节点原来的中止按钮处理BL
		
		//提交按钮
		pdbdTB.setPdbdid(workFlowDefinitionBL.getParticipantDefaultButtonDefPK(psdid));
		pdbdTB.setPsdid(psdid);
		pdbdTB.setPbdid("10");
		pdbdTB.setPdbdname("提交");
		pdbdTB.setPdbddesc("提交");
		pdbdTB.setPdbdauth("0");
		pdbdTB.setCheckrequired("1");
		pdbdTB.setCheckrecord("0");
		workFlowDefinitionBL.registParticipantDefaultButtonDef(pdbdTB);
		
		//非发起和关闭节点添加中止按钮和按钮BL
		if("0"==psdFlag){
			//自定义中止按钮
			pdbdTB.setPdbdid(workFlowDefinitionBL.getParticipantDefaultButtonDefPK(psdid));
			pdbdTB.setPsdid(psdid);
			pdbdTB.setPbdid("14");
			pdbdTB.setPdbdname("中止");
			pdbdTB.setPdbddesc("中止");
			pdbdTB.setPdbdauth("0");
			pdbdTB.setCheckrequired("1");
			pdbdTB.setCheckrecord("0");
			workFlowDefinitionBL.registParticipantDefaultButtonDef(pdbdTB);
			
			// 设定中止按钮事件
			IG156TB spseTB = new IG156TB();
			spseTB.setPseid(workFlowDefinitionBL.getProcessStatusButtonDefPK(psdid));
			spseTB.setPdid(psdid.substring(0, 7));
			spseTB.setPsdid(psdid);
			spseTB.setPsebuttonid("14");
			spseTB.setPseactionid("igDRMBTN0103BL");
			spseTB.setPseorder(1); 
			spseTB.setPsbdname("中止");
			workFlowDefinitionBL.registProcessStatusButtonDef(spseTB);
			
			// 设定保存按钮事件
			IG156TB updateTB = new IG156TB();
			updateTB.setPseid(workFlowDefinitionBL.getProcessStatusButtonDefPK(psdid));
			updateTB.setPdid(psdid.substring(0, 7));
			updateTB.setPsdid(psdid);
			updateTB.setPsebuttonid("01");
			updateTB.setPseactionid("igDRMBTN0104BL");
			updateTB.setPseorder(1); 
			updateTB.setPsbdname("更新");
			workFlowDefinitionBL.registProcessStatusButtonDef(updateTB);
		}
	}
	
	/**
	 * null->""
	 * @param String 
	 * @return
	 * @throws BLException
	 */
	public String nullToEmpty(String str) throws BLException{
		if(null==str){
			str = "";
		}	
		return str;
	}
	
}
