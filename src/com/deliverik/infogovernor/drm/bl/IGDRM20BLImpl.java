package com.deliverik.infogovernor.drm.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.drm.bl.task.SOC0509BL;
import com.deliverik.infogovernor.drm.dto.IGDRM20DTO;
import com.deliverik.infogovernor.drm.form.IGDRM2001Form;
import com.deliverik.infogovernor.drm.form.IGDRM2003Form;
import com.deliverik.infogovernor.drm.form.IGDRM2004Form;
import com.deliverik.infogovernor.drm.form.IGDRM2005Form;
import com.deliverik.infogovernor.drm.model.SOC0509Info;
import com.deliverik.infogovernor.drm.model.condition.SOC0509SearchCondImpl;
import com.deliverik.infogovernor.drm.model.entity.SOC0509TB;

/**
 * 概述: 功能描述: 创建记录: 修改记录:
 */
public class IGDRM20BLImpl extends BaseBLImpl implements IGDRM20BL {

	static Log log = LogFactory.getLog(IGDRM20BLImpl.class);

	/** 流程定义BL */
	protected SOC0117BL soc0117BL;

	protected SOC0509BL soc0509BL;

	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}

	public void setSoc0509BL(SOC0509BL soc0509bl) {
		soc0509BL = soc0509bl;
	}

	public IGDRM20DTO insertEntityAction(IGDRM20DTO dto) throws BLException {
		log.debug("========资产信息登记处理开始========");
		IGDRM2001Form form = (IGDRM2001Form) dto.getForm();
		SOC0117TB soc0117tb = new SOC0117TB();
		this.copyProperties(soc0117tb, form);
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEsyscoding(form.getEparcoding());
		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(cond);
		if (entityList != null && entityList.size() > 0) {
			// 资产信息登记处理
			SOC0117Info soc0117Info = entityList.get(0);
			SOC0117Info entity = this.soc0117BL.registEntity(soc0117tb,
					soc0117Info.getEid());
			dto.setEntity(entity);
			//Copy上级目录属性，相当于继承，便于独立管理
			copyConfig(soc0117Info, entity);
		} else {
			// 资产信息登记处理
			SOC0117Info entity = this.soc0117BL.registEntity(soc0117tb, "");
			dto.setEntity(entity);
		}
		dto.addMessage(new ActionMessage("IGCO10000.I004", "模板基本信息"));
		log.debug("========资产信息登记处理终了========");
		return dto;
	}

	public IGDRM20DTO updateEntityAction(IGDRM20DTO dto) throws BLException {
		log.debug("========资产信息更新处理开始========");

		// 查询更新的数据源
		IGDRM2001Form form = (IGDRM2001Form) dto.getForm();
		String eid = form.getEid();
		SOC0117TB update = (SOC0117TB) SerializationUtils.clone(soc0117BL.searchEntityByKey(eid));
		
		// 赋值
		update.setEname(form.getEname());
		update.setEdesc(form.getEdesc());
		
		// 资产信息更新处理
		this.soc0117BL.updateEntity(update);

		dto.addMessage(new ActionMessage("IGCO10000.I005", "模型基本信息"));
		log.debug("========资产信息更新处理终了========");
		return dto;
	}

	public IGDRM20DTO getPlanSectionTree(IGDRM20DTO dto) throws BLException {
		// 获取类型实例
		SOC0117Info entity = dto.getEntity();

		// 查询章节信息
		SOC0509SearchCondImpl cond = new SOC0509SearchCondImpl();
		String esyscoding = entity.getEsyscoding();
		cond.setEsyscoding(esyscoding);
		List<SOC0509Info> searchSOC0509 = soc0509BL.searchSOC0509(cond);

		// 填充根节点
		if (searchSOC0509 == null || searchSOC0509.isEmpty()) {
			searchSOC0509 = new ArrayList<SOC0509Info>();
		}
		SOC0117SearchCondImpl entityCond = new SOC0117SearchCondImpl();
		entityCond.setEsyscoding(esyscoding);
		List<SOC0117Info> searchEntity = soc0117BL.searchEntity(entityCond);

		SOC0509TB root = new SOC0509TB();
		if(null != searchEntity && searchEntity.size() > 0){
			SOC0117Info tbRoot = searchEntity.get(0);
			root.setCid("CI" + tbRoot.getEsyscoding());
			root.setPcid("0");
			root.setCname(tbRoot.getEname());
			root.setEid(tbRoot.getEid());
			root.setEsyscoding(tbRoot.getEsyscoding());
			searchSOC0509.add(root);
		}

		// 设置章节树
		dto.setPlanSectionTree(searchSOC0509);
		return dto;
	}

	public IGDRM20DTO insertSoc0509Info(IGDRM20DTO dto) throws BLException {
		IGDRM2003Form form = (IGDRM2003Form) dto.getForm();
		String eid = form.getEid();
		String esyscoding = form.getEsyscoding();
		String[] pcids = form.getParent_cids();
		String[] names = form.getNode_names();
		String[] attaches = form.getNode_attaches();
		String[] node_cseq = form.getNode_cseq();
		int corder = getNextCorder();
		for(int i=0;i<pcids.length;i++){
			SOC0509TB tb = soc0509BL.getSOC0509TBInstance();
			tb.setCstatus("1");
			tb.setEid(eid);
			tb.setCid(getNextCid(tb.getEid()));
			tb.setEsyscoding(esyscoding);
			tb.setCname(names[i]);
			tb.setPcid(pcids[i]);
			tb.setCattach(attaches[i]);
			tb.setCorder(corder++ + "");
			tb.setCseq(Integer.valueOf(node_cseq[i]));
			soc0509BL.registSOC0509(tb);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I004", "章节信息"));
		return dto;
	}

	/**
	 * 获取模型属性主键
	 * 
	 * @param eid
	 * @return
	 */
	private String getNextCid(String eid) {

		// 拼写模型属性ID
		String cidhead = "CI" + eid.substring(2) + "1";
		// 模型属性id
		String cidstr = "";

		SOC0509SearchCondImpl cond = new SOC0509SearchCondImpl();
		cond.setEid(eid);
		List<SOC0509Info> clist = soc0509BL.searchSOC0509(cond);

		// 若存在，则取最大值+1
		if (clist != null && clist.size() > 0) {
			String lastCid = clist.get(0).getCid();
			String serinum = lastCid.substring(10);
			if (serinum.equals("999")) {
				return null;
			}
			String nextnum = String.valueOf(Integer.parseInt(serinum) + 1);
			cidstr = cidhead + StringUtils.leftPad(nextnum, 3, "0");
		}
		// 不存在序列号设为001
		else {
			cidstr = cidhead + "001";
		}

		return cidstr;
	}
	/**
	 * 获取表中下一个CORDER的值
	 */
	private Integer getNextCorder(){
		return soc0509BL.getNextCorder();
	}
	
	/**
	 * 按条件查询
	 */
	public IGDRM20DTO searchPlanAction(IGDRM20DTO dto) throws BLException {
		IGDRM2004Form form = (IGDRM2004Form) dto.getForm();
		
		SOC0117SearchCond cond = new SOC0117SearchCondImpl();
		this.copyProperties(cond, form);
		
		int totalCount = soc0117BL.getEntitySearchCount(cond);
		PagingDTO pDto = dto.getPagingDTO();

		dto.setSoc0117List(soc0117BL.searchEntity(cond,
				pDto.getFromCount(), pDto.getPageDispCount()));
		pDto.setTotalCount(totalCount);
		return dto;
	}

	/**
	 * 启用模板
	 */
	public IGDRM20DTO startAction(IGDRM20DTO dto) throws BLException {
		return changeStatus(dto, "1");
	}

	/**
	 * 禁用模板
	 */
	public IGDRM20DTO stopAction(IGDRM20DTO dto) throws BLException {
		return changeStatus(dto, "2");
	}

	/**
	 * 更改模板状态（启用或停用）
	 * 
	 * @param dto
	 * @param status
	 * @return
	 * @throws BLException
	 */
	private IGDRM20DTO changeStatus(IGDRM20DTO dto, String status)
			throws BLException {
		IGDRM2004Form form = (IGDRM2004Form) dto.getForm();
		SOC0117TB info = (SOC0117TB) SerializationUtils.clone(soc0117BL
				.searchEntityByKey(form.getEid()));
		info.setEstatus(status);
		soc0117BL.updateEntity(info);
		return dto;
	}

	/**
	 * 初始化Entity
	 */
	public IGDRM20DTO initEntityAction(IGDRM20DTO dto) throws BLException {
		IGDRM2005Form form = (IGDRM2005Form) dto.getForm();
		String eid = form.getEid();
		SOC0117Info info = soc0117BL.searchEntityByKey(eid);
		dto.setEntity(info);
		return dto;
	}

	/**
	 * 删除某个Entity下的SOC0509
	 */
	public IGDRM20DTO deletePlanOfEntity(IGDRM20DTO dto) throws BLException {
		IGDRM2005Form form = (IGDRM2005Form) dto.getForm();
		String cid = form.getCid();
		soc0509BL.deleteSOC0509ByPK(cid);
		
		// 递归删除其他子代节点
		deletePlanChild(cid);
		return dto;
	}
	
	/**
	 * 递归删除子代节点
	 * @param pcid
	 */
	private void deletePlanChild(String pcid) throws BLException {
		SOC0509SearchCondImpl cond = new SOC0509SearchCondImpl();
		cond.setPcid(pcid);
		List<SOC0509Info> children = soc0509BL.searchSOC0509(cond);
		for(int i=0;i<children.size();i++){
			SOC0509Info child = children.get(i);
			soc0509BL.deleteSOC0509(child);
			deletePlanChild(child.getCid());
		}
	}

	/**
	 * 重命名某个Entity下的SOC0509
	 */
	public IGDRM20DTO renamePlanOfEntity(IGDRM20DTO dto) throws BLException {
		IGDRM2005Form form = (IGDRM2005Form) dto.getForm();
		String cid = form.getCid();
		String cname = form.getCname();
		SOC0509TB info;
		info = (SOC0509TB) SerializationUtils.clone(soc0509BL
				.searchSOC0509ByPK(cid));
		info.setCname(cname);
		soc0509BL.updateSOC0509(info);
		return dto;
	}

	/**
	 * 显示制定eid的Esntity下的详细章节信息
	 */
	public IGDRM20DTO getPlanTreeDetail(IGDRM20DTO dto) throws BLException {
		IGDRM2005Form form = (IGDRM2005Form) dto.getForm();
		String eid = form.getEid();
		SOC0117Info info = soc0117BL.searchEntityByKey(eid);
		dto.setEntity(info);
		dto = getPlanSectionTree(dto);
		return dto;
	}

	public IGDRM20DTO initModelAction(IGDRM20DTO dto) throws BLException {
		IGDRM2003Form form = (IGDRM2003Form) dto.getForm();
		String pcid = form.getPcid();
		String eid = form.getEid();

		SOC0509SearchCondImpl cond = new SOC0509SearchCondImpl();
		
		if(null == eid){// 未点击根节点
			dto.setModelInfo(soc0509BL.searchSOC0509ByPK(pcid));
		}
		else{// 点击了根节点
			dto.setEntity(soc0117BL.searchEntityByKey(eid));
		}
		
		cond.setPcid(pcid);
		dto.setModelChildrenInfo(soc0509BL.searchSOC0509(cond));
		return dto;
	}

	public IGDRM20DTO initS0C0117EditInfo(IGDRM20DTO dto) throws BLException {
		// Form的获取
		IGDRM2001Form form = (IGDRM2001Form) dto.getForm();
		
		// 设置为更新模式
		form.setMode("1");
		
		// 获取主键
		String eid = form.getEid();
		
		// 设置信息
		SOC0117Info editInfo = soc0117BL.searchEntityByKey(eid);
		this.copyProperties(form, editInfo);
		
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEsyscoding(editInfo.getEparcoding());
		List<SOC0117Info> parInfo = soc0117BL.searchEntity(cond);
		if(null != parInfo && parInfo.size()>0){
			form.setEparname(parInfo.get(0).getEname());
		} else {
			form.setEparname("<未知>");
			log.debug("==============未找到esyscoding为" + editInfo.getEparcoding() + "的预案信息==============");
		}
		
		return dto;
	}

	public IGDRM20DTO copyAction(IGDRM20DTO dto) throws BLException {
		IGDRM2004Form form = (IGDRM2004Form)dto.getForm();
		String eid = form.getEid();
		//---模型copy
		//查询要拷贝的Entity信息
		SOC0117Info soc0117Info = soc0117BL.searchEntityByKey(eid);
		SOC0117TB newSOC0117tb = (SOC0117TB) SerializationUtils.clone(soc0117Info);
		newSOC0117tb.setEname(soc0117Info.getEname()+"_New");
		//查询上级资产类型信息
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEsyscoding(soc0117Info.getEparcoding());
		List<SOC0117Info> searchParEntity = soc0117BL.searchEntity(cond);
		//新增复制资产信息
		SOC0117Info registEntity = soc0117BL.registEntity(newSOC0117tb, searchParEntity.get(0).getEid());
		dto.setEntity(registEntity);
		
		//---配置项copy
		copyConfig(soc0117Info, registEntity);
		dto.addMessage(new ActionMessage("IGCO10000.I003","复制成功"));
		return dto;
	}

	private void copyConfig(SOC0117Info soc0117Info, SOC0117Info registEntity) throws BLException {
		SOC0509SearchCondImpl soc0509Cond = new SOC0509SearchCondImpl();
		soc0509Cond.setEsyscoding(soc0117Info.getEsyscoding());
		List<SOC0509Info> searchSOC0509List = soc0509BL.searchSOC0509(soc0509Cond);
		if(searchSOC0509List != null && !searchSOC0509List.isEmpty()){
			//将原有的属性封装为Map<PCID,List<属性>>
			Map<String, List<SOC0509Info>> pcidKeySoc0509Map = new HashMap<String, List<SOC0509Info>>();
			for (SOC0509Info soc0509Info : searchSOC0509List) {
				List<SOC0509Info> soc0509List = new ArrayList<SOC0509Info>();
				if(pcidKeySoc0509Map.containsKey(soc0509Info.getPcid())){
					soc0509List = pcidKeySoc0509Map.get(soc0509Info.getPcid());
				}
				soc0509List.add(soc0509Info);
				pcidKeySoc0509Map.put(soc0509Info.getPcid(), soc0509List);
			}
			Set<String> pcidSet = pcidKeySoc0509Map.keySet();
			for (String pcid : pcidSet) {
				//顶级下面的章节
				if(pcid.indexOf(soc0117Info.getEsyscoding()) != -1){
					List<SOC0509Info> list = pcidKeySoc0509Map.get(pcid);
					for (SOC0509Info soc0509Info : list) {
						SOC0509TB newSOC0509tb = (SOC0509TB) SerializationUtils.clone(soc0509Info);
						newSOC0509tb.setCid(getNextCid(registEntity.getEid()));
						newSOC0509tb.setEid(registEntity.getEid());
						newSOC0509tb.setEsyscoding(registEntity.getEsyscoding());
						newSOC0509tb.setPcid(pcid.replace(soc0117Info.getEsyscoding(), registEntity.getEsyscoding()));
						SOC0509Info newSOC0509Info = soc0509BL.registSOC0509(newSOC0509tb);
						//更新下级 递归
						updateSoc0509InfoByRecursion(pcidKeySoc0509Map,soc0509Info, newSOC0509Info);
					}
				}
			}
		}
	}
	
	//递归更新章节信息
	private void updateSoc0509InfoByRecursion(Map<String, List<SOC0509Info>> soc0509Map,SOC0509Info oldSoc0509Info,SOC0509Info parSoc0509Info) throws BLException{
		if(soc0509Map.containsKey(oldSoc0509Info.getCid())){
			List<SOC0509Info> nextSoc0509List = soc0509Map.get(oldSoc0509Info.getCid());
			for (SOC0509Info soc0509Info : nextSoc0509List) {
				SOC0509TB newSOC0509tb = (SOC0509TB) SerializationUtils.clone(soc0509Info);
				newSOC0509tb.setCid(getNextCid(parSoc0509Info.getEid()));
				newSOC0509tb.setPcid(parSoc0509Info.getCid());
				newSOC0509tb.setEid(parSoc0509Info.getEid());
				newSOC0509tb.setEsyscoding(parSoc0509Info.getEsyscoding());
				SOC0509Info registSOC0509 = soc0509BL.registSOC0509(newSOC0509tb);
				//递归 继续
				updateSoc0509InfoByRecursion(soc0509Map,soc0509Info, registSOC0509);
			}
		}
	}

	public IGDRM20DTO sortSoc0509Action(IGDRM20DTO dto) throws BLException {
		IGDRM2003Form form = (IGDRM2003Form) dto.getForm();
		String pcid = form.getPcid();
		String[] cids = form.getSort_cids();
		
		// 查询前台顺序的信息
		List<SOC0509TB> infos = new ArrayList<SOC0509TB>();
		for(String cid : cids){
			infos.add(getSOC0509ByPK(cid));
		}
		
		// 查询数据库信息
		SOC0509SearchCondImpl cond = new SOC0509SearchCondImpl();
		cond.setPcid(pcid);
		List<SOC0509Info> oldInfos = soc0509BL.searchSOC0509(cond);
		
		// corder值得替换
		for(int i=0;i<infos.size();i++){
			SOC0509TB tb = infos.get(i);
			tb.setCorder(oldInfos.get(i).getCorder());
		}
		
		// 先换值后更新， 避免corder值因覆盖而丢失
		for(SOC0509TB tb : infos){
			soc0509BL.updateSOC0509(tb);
		}
		return dto;
	}
	
	private SOC0509TB getSOC0509ByPK(String pk) throws BLException{
		return (SOC0509TB) SerializationUtils.clone(soc0509BL.searchSOC0509ByPK(pk));
	}
}
