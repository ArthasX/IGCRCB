package com.deliverik.infogovernor.drm.bl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Action;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.IG222BL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.bl.task.IG480BL;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG483BL;
import com.deliverik.framework.workflow.prr.bl.task.IG484BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.IG483Info;
import com.deliverik.framework.workflow.prr.model.IG484Info;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG484SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;
import com.deliverik.infogovernor.drm.dto.IGDRM09DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0904Form;


/**
 * 预案管理业务逻辑实现
 *
 */
public class IGDRM09BLImpl extends BaseBLImpl implements IGDRM09BL {

	static Log log = LogFactory.getLog(IGDRM09BLImpl.class);
	//流程状态定义业务逻辑
	protected IG333BL ig333BL;
	//流程参与者定义业务逻辑
	protected IG222BL ig222BL;
	//流程参与者定义业务逻辑
	protected UserRoleBL userRoleBL;
    
    private IG380BL ig380BL;
    /**流程组实例BL*/
    private IG483BL ig483BL;
    
    /**组合场景实例成员BL*/
    private IG484BL ig484BL;
    
    /**组合场景定义BL*/
    private IG480BL ig480BL;
    
    
    
    private WorkFlowOperationBL workFlowOperationBL;
    
    
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	public void setIg480BL(IG480BL ig480bl) {
		ig480BL = ig480bl;
	}
	public void setIg484BL(IG484BL ig484bl) {
		ig484BL = ig484bl;
	}
	/**
	 * @param ig483bl the 流程组实例BL to set
	 */
	public void setIg483BL(IG483BL ig483bl) {
		ig483BL = ig483bl;
	}
	public void setIg333BL(IG333BL ig333bl) {
		ig333BL = ig333bl;
	}
	public void setIg222BL(IG222BL ig222bl) {
		ig222BL = ig222bl;
	}
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
	protected IG500BL ig500BL;
	

	
	/**
	 * ig500BL   设定
	 * @param ig500BL ig500BL
	 */
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}
	/**
	 * 根据菜单标识获取菜单名称
	 * 
	 * @param dto
	 * @return String
	 * @throws BLException
	 */
	public String getActionName(IGDRM09DTO dto) throws BLException {
		log.debug("========根据菜单标识获取菜单名称取得处理开始========");
        //获取登录人可见菜单集合
		UserPermission userPermission = dto.getUserPermission();
		
		String titlename = "事件";
		
		//获取菜单标识
		String actname = dto.getActname();
		//获取菜单上级标识
		String actname_m1 = "";
		String actname_m2 = "";
		//当获取的菜单标识是三级菜单时
		if(StringUtils.isNotEmpty(actname) && actname.length() > 10){//start if 1
			//获取一级菜单和二级菜单标识
			actname_m1 = actname.substring(0, 8);
			actname_m2 = actname.substring(0, 10);
			//获取菜单集合
			List<Map<Action, List<Map<Action, List<Map<Action, List<Action>>>>>>> actionList = userPermission.getActionList();
			tit: for(Map<Action, List<Map<Action, List<Map<Action, List<Action>>>>>> map: actionList) {//start for 1
				
				//获取一级菜单
				Set<Entry<Action, List<Map<Action, List<Map<Action, List<Action>>>>>>> set_m1 = map.entrySet();
				for(Iterator<Entry<Action, List<Map<Action, List<Map<Action, List<Action>>>>>>> iter_m1 = set_m1.iterator();
					iter_m1.hasNext();){//start for 2
					
					//找到对应的一级菜单
					Entry<Action, List<Map<Action, List<Map<Action, List<Action>>>>>> next_m1 = iter_m1.next();
					if(actname_m1.equals(next_m1.getKey().getActname())){//start if 2
						
						//记录二级菜单信息List
						List<Map<Action, List<Map<Action, List<Action>>>>> list_m2 = next_m1.getValue();
						for (Map<Action, List<Map<Action, List<Action>>>> map_m2 : list_m2) {//start for 3
							
							//获取二级菜单
							Set<Entry<Action, List<Map<Action, List<Action>>>>> set_m2 = map_m2.entrySet();
							for(Iterator<Entry<Action, List<Map<Action, List<Action>>>>> iter_m2 = set_m2.iterator();
								iter_m2.hasNext();){//start for 4
								
								//找到对应的二级菜单
								Entry<Action, List<Map<Action, List<Action>>>> next_m2 = iter_m2.next();
								if(actname_m2.equals(next_m2.getKey().getActname())){ //start if 3
									
									//记录三级菜单信息List
									List<Map<Action, List<Action>>> list_m3 = next_m2.getValue();
									for (Map<Action, List<Action>> map_m3 : list_m3) {//start for 5
										
										//获取三级菜单
										Set<Entry<Action, List<Action>>> set_m3 = map_m3.entrySet();
										for(Iterator<Entry<Action, List<Action>>> iter_m3= set_m3.iterator();
											iter_m3.hasNext();){//start for 6
											
											//找到对应的三级菜单
											Entry<Action, List<Action>> next_m3 = iter_m3.next();
											//找到对应的三级菜单
											if(actname.equals(next_m3.getKey().getActname())){
												titlename = next_m3.getKey().getActlabel();
												break tit;
											}
										}//end for 6
									}//end for 5
								}//end if 3
							}//end for 4
						}//end for 3
					}//end if 2
				}//end for 2
			}//end for 1
		}//end if 1
		
        log.debug("========根据菜单标识获取菜单名称取得处理终了========");
		return titlename;
	}

	/**
	 * <p>
	 * Description: 查询工作记录
	 * </p>
	 * 
	 * @param dto IGDRM0102DTO
	 * @return IGDRM0102DTO
	 * @throws BLException
	 */
	
	public IGDRM09DTO getProcessRecords(IGDRM09DTO dto) throws BLException {
		log.debug("========查询工作记录处理开始========");
		
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		
		BeanUtils.copyProperties(dto.getIgdrm0903Form(), cond);
		cond.setPrurgency(null);
		//查询该流程定义下的所有流程状态
        IG333SearchCondImpl ig333Cond = new IG333SearchCondImpl();
        ig333Cond.setPdid_like(dto.getIgdrm0903Form().getPrpdid());
        List<IG333Info> ig333Infos = workFlowDefinitionBL.searchProcessStatusDef(ig333Cond);
        dto.setiG333InfoList(ig333Infos);
		// 查询记录总数
		int totalCount = ig500BL.queryIG500EntityCount(cond);
		
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
		List<IG500Info> prList = ig500BL.queryIG500EntityListByProcessInfo(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		dto.setProcessList(prList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		this.setDetailURLToDTO(dto);
		
		log.debug("========查询工作记录处理终了========");
		return dto;
	}
	
	private void setDetailURLToDTO(IGDRM09DTO dto) throws BLException{
		Map<String,String> nameURLMap = new HashMap<String,String>();
		IG259SearchCondImpl cond = new IG259SearchCondImpl();
		cond.setPttype(dto.getPrtype());
		//cond.setPtstatus("a");
		List<IG259Info> processTemplateList = workFlowDefinitionBL.searchProcessTemplate(cond);
		for (IG259Info processTemplate : processTemplateList) {
			nameURLMap.put(processTemplate.getPttype(), processTemplate.getPtdetailpg());
		}
		dto.setNameURLMap(nameURLMap);
	}

	/**流程定义BL*/
	protected WorkFlowDefinitionBL workFlowDefinitionBL;

	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	
	/**
	 * @Description: 应急流程弹出查询页
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM07DTO    
	 * @throws
	 */
	public IGDRM09DTO searchProcess(IGDRM09DTO dto)throws BLException{
		IG500SearchCondImpl ig500cond = new IG500SearchCondImpl();
		ig500cond.setPrstatus(dto.getPrstatus());
		ig500cond.setPrtype(dto.getPrtype());
		ig500cond.setPrActive("Y");
		//值为空的，99999作为空的标识
		ig500cond.setPid(99999);
		List<IG500Info> ig500InfoList = ig500BL.searchIG500Info(ig500cond);
		List<IG483Info> ig483List =  ig483BL.searchIG483();
		for(IG483Info info : ig483List){
			if(StringUtils.isNotEmpty(info.getPgrclosetime()))continue;
			IG500TB ig500TB = new IG500TB();
			ig500TB.setFingerPrint("GROUP");
			ig500TB.setPrid(info.getPgrid());
			ig500TB.setPrserialnum(info.getPgrserialnum());
			ig500TB.setPrusername(info.getPgrusername());
			ig500TB.setPrtitle(info.getPgrtitle());
			ig500TB.setPropentime(info.getPgropentime());
			ig500InfoList.add(ig500TB);
		}
		//按开始时间排序
	      Collections.sort(ig500InfoList, new Comparator<IG500Info>(){
			public int compare(IG500Info o1, IG500Info o2) {
				String info1 = o1.getPropentime();
				String info2 = o2.getPropentime();
				if (info1.compareTo(info2) > 0) {
					return 1;
				} else {
					return -1;
				}
			}
	    	});
		dto.setProcessList(ig500InfoList);
		return dto;
	}
	
	/**
	 * 查询流程定义
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM09DTO getProcessDef(IGDRM09DTO dto) throws BLException{
		IGDRM0904Form from = dto.getIgdrm0904Form();
		
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		
		BeanUtils.copyProperties(from, cond);
		
		List<IG380Info> ig380List = ig380BL.searchIG380Info(cond);
		
		dto.setProcessDefinitionList(ig380List);
		
		return dto;
		
	}
	
	/**
	 * 初始化组合场相关流程
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public IGDRM09DTO getGroupSenceInfo(IGDRM09DTO dto)throws BLException{
		
		log.debug("===============查看组合场景流程实例信息开始================");
		StringBuilder  prid_in = new StringBuilder();
		List<IG036Info> noticeList = new ArrayList<IG036Info>();
		IG483Info ig483Info  = null;
		List<IG484Info> ig484List = null;
		Integer pgrid = dto.getPgrid();
		if(pgrid!=null&&pgrid>0){
		
		
			//获取流程组实例信息
			ig483Info = ig483BL.searchIG483ByPK(pgrid); 
			
			//获取流程组内成员实例信息
			IG484SearchCondImpl cond = new IG484SearchCondImpl();
			
			cond.setPgrid(pgrid);
	
			ig484List = ig484BL.searchIG484(cond);
			
			//查询关联的流程实例
			for (int i = 0; i < ig484List.size(); i++) {
				if(i>0){
					prid_in.append(",");
				}
				prid_in.append(ig484List.get(i).getPrid());
			}
		
		}else{
			prid_in.append(dto.getPrid());
			
		}
		IG500SearchCondImpl ig500cond = new IG500SearchCondImpl();
		
		ig500cond.setPrid_in(prid_in.toString());
		
		List<IG500Info> ig500List = ig500BL.searchIG500Info(ig500cond);
		
		//装载到map中
		Map<String, IG500Info> prMap = new HashMap<String, IG500Info>();
		for (IG500Info ig500Info : ig500List) {
			prMap.put(ig500Info.getPrpdid(), ig500Info);
		}
		
		
			try{
				List<Element> webFlows = null;
				Document document = null;
				if(pgrid!=null&&pgrid>0){
					//取出流程图XML
					document = DocumentHelper.parseText(ig480BL.searchIG480ByPK(ig483Info.getPgdid()).getPgdxml());
					//取出流程图的高
					dto.setXmlHeight(document.getRootElement().valueOf("@contentHeight"));
					
					//取出所有流程信息,根据流程图XML中单一场景流程遍历设置每个流程的高亮节点
					webFlows = document.selectNodes("//GroupFlow/WebFlows/WebFlow");
				}else{
					document = DocumentHelper.parseText(ig380BL.searchIG380InfoByKey(ig500List.get(0).getPrpdid()).getPdxml());
					//取出流程图的高
					dto.setXmlHeight(document.getRootElement().valueOf("@contentHeight"));
					webFlows = new ArrayList<Element>();
					webFlows.add(document.getRootElement());
				}
				for (Element webFlow : webFlows) {
					//根据单一流程的定义id获取对应的实例
					String pdid = webFlow.node(0).valueOf("@flowId");
					IG500Info process = prMap.get(pdid);
					//如果流程实例是空则说明组内流程还未发起,不用设置,继续循环
					if(process==null)
					continue;
					
					//高亮的节点
					StringBuffer isFocused = new StringBuffer();
					
					//如果流程关闭或者中止则关闭节点为高亮的节点
					if(IGPRDCONSTANTS.PROCESS_TERMINATE.equals(process.getPrstatus()) || IGPRDCONSTANTS.PROCESS_END_STATUS.equals(process.getPrstatus())){
						isFocused.append(process.getPrpdid()).append("002");
					}else{
						List<String> list = workFlowOperationBL.searchCurrentRecordStatus(process.getPrid());
						for(int i=0;i<list.size();i++){
							if(i > 0){
								isFocused.append(",");
							}
							if (!list.get(i).equals("null")) {
								String psdid = list.get(i).indexOf("_") >= 0 ? list.get(i).split("_")[0] : list.get(i);
								IG333Info info = workFlowDefinitionBL.searchProcessStatusDefByKey(psdid);
								isFocused.append(list.get(i));
								if(info != null && StringUtils.isNotEmpty(info.getPpsdid())){
									isFocused.append(",");
									isFocused.append(info.getPpsdid());
								}
							} 
						}
					}//if else 结束
					
					//记录高亮的节点高xml中
					((Element)webFlow.node(1)).setAttributeValue("isFocusedId", isFocused.toString());
					
					//加载日志信息
					noticeList.addAll(workFlowOperationBL.searchRecordLogForProcessDef(process.getPrid()));
					
				}
				
			    dto.setGroupProcessRecordXML(document.asXML().replaceAll("\"", "'"));
				
			}catch(Exception e){
				throw new BLException();
			}
		
		Collections.sort(noticeList);
		
		dto.setNoticeList(noticeList);
		
		dto.setGroupProcessRecord(ig483Info);
		
		dto.setGroupProcessRecordMembers(ig484List);
		
		dto.setProcessList(ig500List);
		
		log.debug("===============查看组合场景流程实例信息结束================");
		return dto;
	}
	
	
	/**
	 * ig380BL   设定
	 * @param ig380BL ig380BL
	 */
	public void setIg380BL(IG380BL ig380bl) {
		ig380BL = ig380bl;
	}

	
}
