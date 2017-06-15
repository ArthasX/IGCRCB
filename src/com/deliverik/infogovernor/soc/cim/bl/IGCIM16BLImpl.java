package com.deliverik.infogovernor.soc.cim.bl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.MessageResources;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.soc.asset.EntityItemKeyWords;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0163BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0501BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0502BL;
import com.deliverik.framework.soc.asset.model.SOC0110Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0163Info;
import com.deliverik.framework.soc.asset.model.SOC0501Info;
import com.deliverik.framework.soc.asset.model.SOC0502Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0163SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0501SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0502SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0501TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0502TB;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM16DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1601Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1611Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1631Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1633Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1634Form;

public class IGCIM16BLImpl extends BaseBLImpl implements IGCIM16BL {
	
	static Log log = LogFactory.getLog(IGCIM16BLImpl.class);
	
	/**密码信息BL*/
	private SOC0501BL soc0501BL;
	/**密码关联关系BL*/
	private SOC0502BL soc0502BL;
	
	private SOC0118BL soc0118BL;
	
	private SOC0119BL soc0119BL;
	private SOC0163BL soc0163BL;
	
	
	public void setSoc0163BL(SOC0163BL soc0163bl) {
		soc0163BL = soc0163bl;
	}

	private OrganizationBL organizationBL;
	
	/** 资产关联关系下拉数据BL */
	protected CodeDetailBL codeDetailBL;
	
	
	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.soc.cim.asmResources"); 

	
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}


	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}

	public void setSoc0119BL(SOC0119BL soc0119bl) {
		soc0119BL = soc0119bl;
	}

	public void setSoc0501BL(SOC0501BL soc0501bl) {
		soc0501BL = soc0501bl;
	}

	public void setSoc0502BL(SOC0502BL soc0502bl) {
		soc0502BL = soc0502bl;
	}
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}


	/**
	 * 保存密码信息
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO insertSoc0501Info(IGCIM16DTO dto) throws BLException {
		IGCIM1601Form form = dto.getIgcim1601Form();
		SOC0501TB soc0501TB = new SOC0501TB();
		soc0501TB.setPwd(form.getPwd());
		soc0501TB.setPwdDescription(form.getPwdDescription());
		soc0501TB.setPwdType(form.getPwdType());
		soc0501TB.setRegDate(form.getRegDate());
		soc0501TB.setServerIP(form.getServerIP());
		soc0501TB.setUserName(form.getUserName());
		
		soc0501BL.registSoc0501(soc0501TB);
		
		dto.setSoc0501Info(soc0501TB);
		return dto;
	}

	/**
	 * 保存密码关联关系
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO insertSoc0502Info(IGCIM16DTO dto) throws BLException {
		IGCIM1611Form form = dto.getIgcim1611Form();
		SOC0502TB soc0502TB = new SOC0502TB();
		
		soc0502TB.setOperationInfo(form.getOperationInfo());
		soc0502TB.setPid(form.getPid());
		soc0502TB.setrDescription(form.getrDescription());
		soc0502TB.setRegDate(form.getRegDate());
		soc0502TB.setrName(form.getrName());
		soc0502TB.setServerIp(form.getServerIp());
		
		soc0502BL.registSoc0502(soc0502TB);
		
		dto.setSoc0502Info(soc0502TB);
		return dto;
	}

	/**
	 * 获取密码关联关系
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO getSoc0502Info(IGCIM16DTO dto) throws BLException {
		
		log.debug("========密码关联关系查询处理开始========");
		IGCIM1611Form form = dto.getIgcim1611Form();
		
		SOC0501Info soc0501Info = soc0501BL.searchSoc0501ByPK(form.getPid());
		
		SOC0502SearchCondImpl cond = new SOC0502SearchCondImpl();
		BeanUtils.copyProperties(form, cond);
		List<SOC0502Info> soc0502List = soc0502BL.searchSoc0502(cond, 0, 0);
		dto.setSoc0502List(soc0502List);
		dto.setSoc0501Info(soc0501Info);
		
		log.debug("========密码关联关系查询处理结束========");
		
		return dto;
	}

	/**
	 * 获取密码信息
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO getSoc0501Info(IGCIM16DTO dto) throws BLException {
		
		log.debug("========密码信息查询处理开始========");
		
		IGCIM1601Form form = dto.getIgcim1601Form();
		SOC0501SearchCondImpl cond = new SOC0501SearchCondImpl();
		BeanUtils.copyProperties(form, cond);
		int totalCount = soc0501BL.getSearchCount(cond);
		if (totalCount == 0) {
			log.debug("========密码查询数据不存在========");
			//应用信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========密码信息查询数据件数过多========");
			//应用信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
		//分页用信息取得
			PagingDTO pDto = dto.getPagingDto();
			
			//当前页应用信息取得
			List<SOC0501Info> soc0501List = soc0501BL.searchSoc0501(cond, pDto.getFromCount(), pDto.getPageDispCount());
			
			pDto.setTotalCount(totalCount);
			
			dto.setSoc0501List(soc0501List);
			
			dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));

			log.debug("========密码信息查询处理结束========");
		return dto;
	}

	/**
	 * 密码信息
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO deleteSoc0501Info(IGCIM16DTO dto) throws BLException {
//		SOC0502SearchCondImpl cond = new SOC0502SearchCondImpl();
//		
//		BeanUtils.copyProperties(dto.getIgcim1611Form(), cond);
		
		soc0502BL.deleteSoc0502(dto.getIgcim1611Form().getRids());
		
		return dto;
	}

	/**
	 * 删除密码关联关系
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO deleteSoc0502Info(IGCIM16DTO dto) throws BLException {
		return dto;
	}

	/**
	 * 查询设备
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO searchSoc0124List(IGCIM16DTO dto) throws BLException{
		
		IGCIM1631Form form = dto.getIgcim1631Form();
		
		
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		BeanUtils.copyProperties(form, cond);
		
		int totalCount = soc0118BL.getEntityItemVWSearchCount(cond);
		
		if (totalCount == 0) {
			log.debug("========设备查询数据不存在========");
			//设备信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========设备信息查询数据件数过多========");
			//设备信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
			//分页用信息取得
			PagingDTO pDto = dto.getPagingDto();
			
			//当前页应用信息取得
			List<SOC0124Info> soc0124List = soc0118BL.searchEntityItemVW(cond, pDto.getFromCount(), pDto.getPageDispCount());
			
			pDto.setTotalCount(totalCount);
			
			dto.setSoc0124List(soc0124List);
			
			dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));

			log.debug("========设备信息查询处理结束========");
		return dto;
	}
	
	/**
	 * 查询设备
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO searchSoc0163List(IGCIM16DTO dto) throws BLException{
		
		IGCIM1631Form form = dto.getIgcim1631Form();
		
		
		SOC0163SearchCondImpl cond = new SOC0163SearchCondImpl();
		
		BeanUtils.copyProperties(form, cond);
		
		int totalCount = soc0163BL.getSearchCount(cond);
		
		if (totalCount == 0) {
			log.debug("========设备查询数据不存在========");
			//设备信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========设备信息查询数据件数过多========");
			//设备信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		
			//分页用信息取得
			PagingDTO pDto = dto.getPagingDto();
			
			//当前页应用信息取得
			List<SOC0163Info> soc0163List = soc0163BL.searchEntityItemEntityVW(cond, pDto.getFromCount(), pDto.getPageDispCount());
			
			pDto.setTotalCount(totalCount);
			
			dto.setSoc0163List(soc0163List);
			
			dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));

			log.debug("========设备信息查询处理结束========");
		return dto;
	}
	
	/**
	 * 查询关联业务系统
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO searchBusiessList(IGCIM16DTO dto) throws BLException{
		
		IGCIM1631Form form = dto.getIgcim1631Form();
		
		Integer eiid = form.getEiid();
		
		SOC0118Info soc0118Info = soc0118BL.searchEntityItemByKey(eiid);
		
		dto.setSoc0118Info(soc0118Info);
		
		SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
		
		cond.setPareiid(eiid);
		
		cond.setEirrelation("CR990100010001");
		
		List<Integer> eiids = soc0119BL.searchCldeiidByPareiid(cond);
		
		SOC0118SearchCondImpl soc0118Cond = new SOC0118SearchCondImpl();
		
		soc0118Cond.setEiids(eiids);
		
		List<SOC0118Info> soc0118List = soc0118BL.searchEntityItem(soc0118Cond);
		
		dto.setSoc0118List(soc0118List);
		
		return dto;
	}
	
	/**
	 * 保存密码关联关系
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO insertBusiessRelation(IGCIM16DTO dto) throws BLException{
		
		log.debug("========设备依赖关系登记处理开始========");
		
		IGCIM1633Form form = dto.getIgcim1633Form();
		
		//设备ID（子）取得
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.010")
					+ form.getElabel() + resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.011") 
					+ form.getEilabel() + resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.012"));
		}
		
		
		//设备ID（父）和（子）检测
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//设备ID（父）= （子）
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
					"IGCO10000.E012",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.004"));
		}
		
		SOC0119SearchCondImpl soc0119Cond = new SOC0119SearchCondImpl();
		soc0119Cond.setPareiid(form.getPareiid());
		soc0119Cond.setParsmallversion(form.getParsmallversion());
		soc0119Cond.setParversion(form.getParversion());
		soc0119Cond.setCldeiid(entityItemVWList.get(0).getEiid());
		soc0119Cond.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		soc0119Cond.setCldversion(entityItemVWList.get(0).getEiversion());
		soc0119Cond.setDeleteflag("0");
		
		int totalCount = this.soc0119BL.getEntityItemRelationSearchCount(soc0119Cond);
		if(totalCount>0){
			//同一依赖关系已经存在
			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS,
					"IGCO10000.E003","业务系统");
		}
		
		//依赖关系登记
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		SOC0119TB relationTB = soc0119BL.getEntityItemRelationTBInstance();
		BeanUtils.copyProperties(form, relationTB);
		
		relationTB.setEirupdtime(datetime);
		
		relationTB.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		relationTB.setCldversion(entityItemVWList.get(0).getEiversion());
		relationTB.setDeleteflag("0");
		soc0119BL.registEntityItemRelation(relationTB);
		
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.013")) );
		
		log.debug("========设备依赖关系登记处理终了========");
		return dto;
	}
	
	/**
	 * 设备依赖关系画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM16DTO initIGCIM1632BelongAction(IGCIM16DTO dto) throws BLException {
		log.debug("========设备依赖关系管理画面初期化处理开始========");
		
		//设备信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(dto.getIgcim1632Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGASM03BLImpl.004"));
		}
		String eiorgsyscoding = entityItemVWInfo.getEiorgsyscoding();
		if(!StringUtils.isEmpty(eiorgsyscoding)){
			OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
			OrgCond.setOrgsyscoding(eiorgsyscoding);
			List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
			for (int i = 0; i < orgList.size(); i++) {
				dto.setEiorgname(orgList.get(0).getOrgname());
			}
		}
		dto.setSoc0124Info(entityItemVWInfo);
		
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		//所属关系正向检索
		SOC0119SearchCondImpl soc0119cond = new SOC0119SearchCondImpl();
		soc0119cond.setPareiid(entityItemVWInfo.getEiid());
		soc0119cond.setParsmallversion(entityItemVWInfo.getEismallversion());
		soc0119cond.setParversion(entityItemVWInfo.getEiversion());
		soc0119cond.setDeleteflag("0");
		soc0119cond.setEirrelation("");
		List<SOC0119Info> relationList = null;
		//设备依赖关系信息查询件数取得 
		int totalCount = this.soc0119BL.getEntityItemRelationSearchCount(soc0119cond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========设备关系信息查询数据件数过多========");
			//设备依赖关系信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		Map<String,List<SOC0110Info>> rlnmap = new LinkedHashMap<String,List<SOC0110Info>>();
		if ( totalCount>0 ) {
			//设备依赖关系信息全件检索
			relationList = this.soc0119BL.searchEntityItemRelation(soc0119cond);
		}
		
		dto.setSoc0119List(relationList);
		log.debug("========设备依赖关系管理画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 删除关系
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO delRelation (IGCIM16DTO dto) throws BLException{
		log.debug("========设备依赖关系删除处理开始========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			String eirid = dto.getDeleteEntityItemRelation()[i];
			
			SOC0119Info soc119Info = 
				this.soc0119BL.searchEntityItemRelationByKey(Integer.valueOf(eirid));
			
			if (soc119Info == null){
				throw new BLException("IGCO10000.E004",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.013"));
			}

			this.soc0119BL.deleteEntityItemRelation(soc119Info);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006",resources.getMessage(dto.getLocale(),"message.IGCIM01BLImpl.013")));

		log.debug("========设备依赖关系删除处理终了========");
		return dto;
	}
	
	/**
	 * 初始化添加密码关联关系页面数据
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCIM16DTO initIGCIM1632EditAction(IGCIM16DTO dto) throws BLException{
		IGCIM1633Form form = dto.getIgcim1633Form();
		
		SOC0124Info  soc0124Info = soc0118BL.searchEntityItemVWByKey(Integer.valueOf(form.getEiid()));
		dto.setSoc0124Info(soc0124Info);
		return dto;
	}
	/**
	 * 密码拓扑关系画面初期化处理
	 *
	 * @param dto IGASM03DTO
	 * @return IGASM03DTO
	 */
	public IGCIM16DTO initIGCIM1634TopoBelongAction(IGCIM16DTO dto) throws BLException{
		IGCIM1634Form form=dto.getIgcim1634Form();
		StringBuffer eirrelations=new StringBuffer();
		CodeDetailSearchCondImpl cdcond=new CodeDetailSearchCondImpl();
		cdcond.setCcid(form.getRelationType());
		List<CodeDetail> codeDetailList=this.codeDetailBL.searchCodeDetail(cdcond, 1);
		if(codeDetailList!=null&&codeDetailList.size()>0){
			int i=0;
			for(CodeDetail cinfo:codeDetailList){
				eirrelations.append("'").append(cinfo.getCid()).append("'");
				if(i!=codeDetailList.size()-1){
					eirrelations.append(",");
				}
			}
		}
		SOC0119SearchCondImpl cond=new SOC0119SearchCondImpl();
		cond.setPareiid(Integer.parseInt(form.getEiid()));
		cond.setParversion(Integer.parseInt(form.getEiversion()));
		cond.setParsmallversion(Integer.parseInt(form.getEismallversion()));
		if(StringUtils.isNotEmpty(eirrelations.toString())){
			cond.setEirrelations(eirrelations.toString());
		}
		
		List<SOC0119Info>  soc0119InfoList=this.soc0119BL.searchMaxEntityItemRelation(cond);
		String xmlData="";
		String smalltype="";
		List<String> eiidList=new ArrayList<String>();
		if(soc0119InfoList!=null&&soc0119InfoList.size()>0){
			xmlData="<?xml version='1.0' encoding='utf-8'?><root>";
			for(SOC0119Info info:soc0119InfoList){
				if(!eiidList.contains(info.getPareiid().toString())){
					smalltype=getSmalltype(info.getParEntityItemVW().getEsyscoding());
					xmlData=xmlData+"<NODE id='"+info.getPareiid()+"' eirootmark='"+info.getParEntityItemVW().getEirootmark()+
					"' eiversion='"+info.getParversion()+"' eismallversion='"+info.getParsmallversion()+"' name='"+
					info.getParEntityItemVW().getEiname()+"' alert='false' datatips='"+info.getParEntityItemVW().getEiname()+
					"'  smalltype='"+smalltype+"' x='' y='' />";
					eiidList.add(info.getPareiid().toString());
				}
				if(!eiidList.contains(info.getCldeiid().toString())){
					smalltype=getSmalltype(info.getCldEntityItemVW().getEsyscoding());
					xmlData=xmlData+"<NODE id='"+info.getCldeiid()+"' eirootmark='"+info.getCldEntityItemVW().getEirootmark()+
					"' eiversion='"+info.getCldversion()+"' eismallversion='"+info.getCldsmallversion()+"' name='"+
					info.getCldEntityItemVW().getEiname()+"' alert='false' datatips='"+info.getCldEntityItemVW().getEiname()+
					"'  smalltype='"+smalltype+"' x='' y='' />";
					xmlData=xmlData+"<LINE id='"+Math.random()+"' " +
					"fromNode='"+info.getPareiid()+"' " +
					"toNode='"+info.getCldeiid()+"' />";
					eiidList.add(info.getCldeiid().toString());
				}
			}
			
			xmlData=xmlData+"</root>";
		}
		dto.setTopoXML(xmlData);
		return dto;
	}
	
	/**
	 * 获取Smalltype
	 * @param esyscoding
	 * @return
	 */
	public String getSmalltype(String esyscoding){
		if(esyscoding.startsWith("999002001")){
			return "0";//db
		}
		if(esyscoding.startsWith("999002")){
			return "1";//mw
		}
		if(esyscoding.startsWith("999001")){
			return "2";//host
   		}
		if(esyscoding.startsWith("999003001")){
   			return "3";//buss
   		}
		return "0";
	}
}
