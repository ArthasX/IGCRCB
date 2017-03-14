/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prd.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
import com.deliverik.framework.bl.AttachmentBL;
import com.deliverik.framework.model.Attachment;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.model.IG001Info;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG335Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG699Info;
import com.deliverik.framework.workflow.prd.model.condition.IG001SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG273SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG335SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG699SearchCondImpl;
import com.deliverik.infogovernor.prd.dto.IGPRD02DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0201Form;
import com.deliverik.infogovernor.prd.vo.IGPRD02022VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRD02BLImpl extends BaseBLImpl implements IGPRD02BL {
	
	/** 日志对象取得 */
	private static final Log log = LogFactory.getLog(IGPRD02BLImpl.class);
	
	/** 用户角色BL */
	protected UserRoleBL userroleBL;
	
	/** 流程定义BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/** 附加BL */
	protected AttachmentBL attachmentBL;

	/**
	 * 用户角色BL设定
	 * @param userroleBL 用户角色BL
	 */
	public void setUserroleBL(UserRoleBL userroleBL) {
		this.userroleBL = userroleBL;
	}
	
	/**
	 * 流程定义BL设定
	 * @param workFlowDefinitionBL 流程定义BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}

	/**
	 * 附加BL设定
	 * @param attachmentBL 附加BL
	 */
	public void setAttachmentBL(AttachmentBL attachmentBL) {
		this.attachmentBL = attachmentBL;
	}

	/**
	 * 用户查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD02DTO searchUserInfoList(IGPRD02DTO dto) throws BLException {
		log.debug("=============用户查询操作开始=============");
		//页面信息取得
		IGPRD0201Form form = dto.getIgprd0201Form();
		//查询配置角色
		List<IG001Info> allList = workFlowDefinitionBL.searchOARoleConfig(new IG001SearchCondImpl());
		List<Integer> roleids = null;
		if(allList!=null){
			for(IG001Info prd:allList){
				if(roleids==null){
					roleids = new ArrayList<Integer>();
				}
				roleids.add(prd.getProroleid());
			}
		}
		if(roleids==null){
			dto.getPagingDto().setTotalCount(0);
			log.debug("===========无指定配置角色=============");
			return dto;
		}
		//查询条件设定
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setOrgid_like(form.getOrgid());
		cond.setRoleid_in(roleids);
		
		// 查询记录总数
		int totalCount = userroleBL.getUserRoleVWSearchCount(cond);
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
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//调用DAO接口查询
		List<UserRoleInfo> userroleList = userroleBL.searchUserRoleVW(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setUserroleList(userroleList);
		log.debug("=============用户查询操作开始=============");
		return dto;
	}
	
	
	/**
	 * 初始化流程简略信息
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRD02DTO initProccessDefinitionInfoAction(IGPRD02DTO dto) throws BLException {
		log.debug("================初始化流程简略信息操作开始===============");
		//初始化流程图
		dto = initFlowChartAction(dto);
		//初始化流程信息
		dto = initWorkFlowDefinitionAction(dto);
		log.debug("================初始化流程简略信息操作结束===============");
		return dto;
	}

	private IGPRD02DTO initWorkFlowDefinitionAction(IGPRD02DTO dto) throws BLException{
		log.debug("=============初始化流程简略信息操作开始============");
		//dto参数取得
		String pdid = dto.getPdid();
		//查询节点信息
		IG333SearchCondImpl ig333_cond = new IG333SearchCondImpl();
		ig333_cond.setPdid(pdid);
		List<IG333Info> psdList = workFlowDefinitionBL.searchProcessStatusDef(ig333_cond);
		//简略信息集合，用IGPRD02022VO来存储每个状态的信心，再存入集合。
		List<IGPRD02022VO> rootList = new ArrayList<IGPRD02022VO>();
		//存储状态对应序号
		Map<String, Integer> serMap = new HashMap<String, Integer>();
		//遍历状态信息并放入集合,产生顺序序号并且保存
		for(int i=0;i<psdList.size();i++){
			IGPRD02022VO vo = new IGPRD02022VO();
			vo.setSerial(i);
			vo.setProcessStatusDefinition(psdList.get(i));
			serMap.put(psdList.get(i).getPsdid(), i);
			rootList.add(vo);
		}
		//查询参与人信息
		IG222SearchCondImpl ig222_cond = new IG222SearchCondImpl();
		ig222_cond.setPdid(pdid);
		List<IG222Info> ppdList = workFlowDefinitionBL.searchParticipantDef(ig222_cond);
		//处理参与人集合，便于根据节点ID寻找参与人
		Map<String, List<IG222Info>> ppdMap = new HashMap<String, List<IG222Info>>();
		for(IG222Info info:ppdList){
			if(ppdMap.get(info.getPsdid()) == null){
				ppdMap.put(info.getPsdid(), new ArrayList<IG222Info>());
			}
			ppdMap.get(info.getPsdid()).add(info);
		}
		//跃迁规则查询，确定前置任务
		IG273SearchCondImpl ig273_cond = new IG273SearchCondImpl();
		ig273_cond.setPtdid_like(pdid);
		List<IG273Info> ptdList = workFlowDefinitionBL.searchProcessTransitionDef(ig273_cond);
		//处理跃迁规则，便于从后节点找到前节点
		Map<String, List<String>> ptdMap = new LinkedHashMap<String, List<String>>();
		for(IG273Info info:ptdList){
			if(ptdMap.get(info.getTpsdid()) == null){
				ptdMap.put(info.getTpsdid(), new ArrayList<String>());
			}
			ptdMap.get(info.getTpsdid()).add(info.getFpsdid());
		}
		//查询附件表单信息
		IG007SearchCondImpl ig007_cond = new IG007SearchCondImpl();
		ig007_cond.setPdid(pdid);
		ig007_cond.setPidtype("F");
		ig007_cond.setTableColumn("N");
		List<IG007Info> pidList = workFlowDefinitionBL.searchProcessInfoDef(ig007_cond);
		//处理数据，便于根据表单定义ID查找表单
		Map<String, IG007Info> pidMap = new HashMap<String, IG007Info>();
		for(IG007Info info:pidList){
			pidMap.put(info.getPidid(), info);
		}
		//查询表单缺省权限
		IG699SearchCondImpl ig699_cond = new IG699SearchCondImpl();
		ig699_cond.setPdvid_like(pdid);
		List<IG699Info> pqdList = workFlowDefinitionBL.searchParticipantDefaultVariable(ig699_cond);
		//处理数据，便于根据状态查找权限
		Map<String, List<String>> pqdMap = new LinkedHashMap<String, List<String>>();
		for(IG699Info info:pqdList){
			if(pqdMap.get(info.getPsdid()) == null){
				pqdMap.put(info.getPsdid(), new ArrayList<String>());
			}
			if(StringUtils.isNotEmpty(info.getPidaccess())){
				if(Integer.valueOf(info.getPidaccess()) > 1){
					pqdMap.get(info.getPsdid()).add(info.getPidid());
				}
			}
		}
		//查询流程策略
		IG335SearchCondImpl ig335_cond = new IG335SearchCondImpl();
		ig335_cond.setPsdid_like(pdid);
		List<IG335Info> cldList = workFlowDefinitionBL.searchFormStrategy(ig335_cond);
		//处理数据，便于根据状态ID查找当前状态策略
		Map<String, List<IG335Info>> cldMap = new HashMap<String, List<IG335Info>>();
		for(IG335Info info : cldList){
			if(cldMap.get(info.getPsdid()) == null){
				cldMap.put(info.getPsdid(), new ArrayList<IG335Info>());
			}
			cldMap.get(info.getPsdid()).add(info);
		}
		for(IGPRD02022VO vo : rootList){
			//取得当前状态下的参与人
			List<IG222Info> list = ppdMap.get(vo.getProcessStatusDefinition().getPsdid());
			Map<Role, List<User>> map = new LinkedHashMap<Role, List<User>>();
			if(list != null){
				for(IG222Info info : list){
					if(map.get(info.getRole()) == null){
						map.put(info.getRole(), new ArrayList<User>());
					}
					if(StringUtils.isNotEmpty(info.getUserid())){
						map.get(info.getRole()).add(info.getUser());
					}
				}
			}
			vo.setParticipantMap(map);
			//设置前置任务
			List<String> ptds = ptdMap.get(vo.getProcessStatusDefinition().getPsdid());
			if(ptds != null){
				StringBuffer r = new StringBuffer();
				for(int i=0;i<ptds.size();i++){
					if(i > 0){
						r.append(",");
					}
					r.append(serMap.get(ptds.get(i)));
				}
				vo.setPrepositionTaskSerial(r.toString());
			}
			//设置附件表单
			List<String> pqds = pqdMap.get(vo.getProcessStatusDefinition().getPsdid());
			if(pqds != null){
				List<Attachment> attachmentList = new ArrayList<Attachment>(); 
				for(String pidid:pqds){
					IG007Info info = pidMap.get(pidid);
					if(info != null && StringUtils.isNotEmpty(info.getPiddefault())){
						List<Attachment> attList = attachmentBL.searchAttachmentsByAttkey(info.getPiddefault());
						if(attList != null){
							attachmentList.addAll(attList);
						}
					}
				}
				vo.setAttList(attachmentList);
			}
			//设置处理时间
			List<IG335Info> clds = cldMap.get(vo.getProcessStatusDefinition().getPsdid());
			if(clds != null){
				int size = clds.size();
				long f = 0;
				for(IG335Info info:clds){
					long d = ((long)info.getNotifyd()) * 24L * 60L;
					long h = ((long)info.getNotifyh()) * 60L;
					long m = info.getNotifym();
					f += d + h + m;
				}
				vo.setHandlingTime((f / size) + "");
			}
		}
		dto.setVoList(rootList);
		log.debug("=============初始化流程简略信息操作结束============");
		return dto;
	}

	/**
	 * 初始化流程图操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	private IGPRD02DTO initFlowChartAction(IGPRD02DTO dto) throws BLException{
		log.debug("============初始化流程图操作开始===========");
		//dto参数取得
		String pdid = dto.getPdid();
		//查询流程定义信息
		IG380Info pd = workFlowDefinitionBL.searchProcessDefinitionByKey(pdid);
		dto.setProcessDefinition(pd);
		try {
			Document document = DocumentHelper.parseText(pd.getPdxml());
			Element root = document.getRootElement();
			int height = 0;
			for(Iterator<Element> steps = root.element("Steps").elementIterator("Step");steps.hasNext();){
				Element next = steps.next();
				int y = Integer.valueOf(next.element("VMLProperties").attributeValue("y").replaceAll("px", ""));
				if(y > height){
					y = height;
				}
			}
			dto.setFlowChartXML(document.asXML().replaceAll("\"", "'"));
			dto.setFlowChartHeight(height + 120);
		} catch (DocumentException e) {
			log.error("",e);
		}
		log.debug("============初始化流程图操作结束===========");
		return dto;
	}
}

