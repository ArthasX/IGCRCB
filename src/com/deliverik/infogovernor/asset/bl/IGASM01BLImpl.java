package com.deliverik.infogovernor.asset.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.bl.task.IG611BL;
import com.deliverik.framework.asset.model.IG612Info;
import com.deliverik.framework.asset.model.condition.IG611SearchCondImpl;
import com.deliverik.framework.asset.model.entity.IG611TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.SOC0109BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0151BL;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0151SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0109TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0151TB;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.dto.IGASM01DTO;
import com.deliverik.infogovernor.asset.form.IGASM0101Form;
import com.deliverik.infogovernor.asset.form.IGASM0102Form;
import com.deliverik.infogovernor.asset.form.IGASM0104Form;
import com.deliverik.infogovernor.asset.form.IGASM0108Form;
import com.deliverik.infogovernor.asset.form.IGASM0111Form;
import com.deliverik.infogovernor.asset.form.IGASM0114Form;
import com.deliverik.infogovernor.sym.bl.IGSYM01BL;
import com.deliverik.infogovernor.sym.bl.IGSYM02BL;
import com.deliverik.infogovernor.sym.dto.IGSYM01DTO;
import com.deliverik.infogovernor.sym.dto.IGSYM02DTO;

/**
 * 资产配置模型管理业务逻辑实现
 * @Author  
 * @History 2009-8-17     新建
 * @History 2010-5-07     0000428: 增加机房属性管理
 * @Version V2.0
 */
public class IGASM01BLImpl extends BaseBLImpl implements IGASM01BL {

	static Log log = LogFactory.getLog(IGASM01BLImpl.class);

	/** 资产信息BL */
	protected SOC0117BL soc0117BL;
	
	/** 资产配置信息BL */
	protected SOC0109BL soc0109BL;

	/** 资产下拉数据信息BL */
//	protected IG545BL ig545BL;
	protected SOC0151BL soc0151BL;
	
	/** 资产模型属性缺省值BL */
	protected IG611BL ig611BL;
	
	/** 文件上传BL */
	protected FileUploadBL fileUploadBL;

	/**
	 * 文件上传BL设定
	 *
	 * @param fileUploadBL 文件上传BL
	 */
	
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}

	public void setSoc0109BL(SOC0109BL soc0109bl) {
		soc0109BL = soc0109bl;
	}

	public void setSoc0151BL(
			SOC0151BL soc0151BL) {
		this.soc0151BL = soc0151BL;
	}
	
	/**
	 * 资产模型属性缺省值BL设定
	 * 
	 * @param ig611BL 资产模型属性缺省值BL
	 */
	public void setIg611BL(IG611BL ig611BL) {
		this.ig611BL = ig611BL;
	}

	/**
	 * <p>
	 * 判断每级资产模型是否可以停用
	 * </p>
	 * @param 资产模型esyscoding
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private boolean isCouldStop(String syscode) {
		IGASM0101Form form = new IGASM0101Form();
		IGASM01DTO dto = new IGASM01DTO();
		boolean flag = true;
		
		form.setEparcoding_status(syscode);
		form.setEstatus("1");
		dto.setEntitySearchCond(form);
		List<SOC0117Info> ret = soc0117BL.searchEntity(dto.getEntitySearchCond(), 0, 0);//查该模型是否存在使用中的下级模型
		if(ret.size()>0){
			flag = false;
		}
		return flag;
	}
	
	/**
	 * <p>
	 * Description: 确定是否显示'停用'按钮
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public Map<String,String> getButtonNameList(List<SOC0117Info> entityList) throws BLException {
		Map<String,String> org = new HashMap<String,String>();
		for(SOC0117Info ret:entityList){
			String flag = "0";//0不显示 1显示
			
			if(isCouldStop(ret.getEsyscoding())){
				flag = "1";
			}
			
			org.put(ret.getEid(), flag);
		}
		
		return org;
	}
	
	/**
	 * <p>
	 * 判断每级机构是否可以启用
	 * </p>
	 * @param 资产模型esyscoding
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private boolean isCouldStart(String syscode) {
		IGASM0101Form form = new IGASM0101Form();
		IGASM01DTO dto = new IGASM01DTO();
		boolean flag = true;
		
		form.setEparcoding_status_start(syscode);
		dto.setEntitySearchCond(form);
		List<SOC0117Info> ret = soc0117BL.searchEntity(dto.getEntitySearchCond(), 0, 0);//查该资产模型是否存在停用的上级模型

		if(ret.size()>0&&ret.get(0).getEstatus().equals("2")){//如果当前结点的上级是停用状态则当前结点不可启用
			flag = false;
		}
		return flag;
	}
	
	/**
	 * <p>
	 * Description: 确定是否显示'启用'按钮
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public Map<String,String> getStartButtonNameList(List<SOC0117Info> entityList) throws BLException {
		Map<String,String> org = new HashMap<String,String>();
		for(SOC0117Info ret:entityList){
			String flag = "0";//0不显示 1显示
			String syscode = ret.getEsyscoding();
			String parcode = ret.getEparcoding();
			if(parcode.equals("999")){//代表为1级模型，则直接设置flag为1
				flag = "1";
			}else{
				if(isCouldStart(syscode.substring(0,syscode.length()-3))){
					flag = "1";
				}
				
			}

			org.put(ret.getEid(), flag);
		}
		
		return org;
	}
	
	/**
	 * <p>
	 * Description: 资产模型属性状态变化
	 * </p>
	 * 
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	public void changeConfigStatus(IGASM01DTO dto) throws BLException {
		log.debug("========资产模型属性状态变化处理开始========");

		SOC0109Info configuration = soc0109BL.searchConfigurationByKey(dto.getCid());
		String status = "";
		if(configuration == null){
			throw new BLException("IGCO10000.E004","资产模型属性状态变更");
		}
		//1为启用 2为停用
		if("1".equals(dto.getCstatus())){
			status="2";
		}else if("2".equals(dto.getCstatus())){
			status="1";
		}
		SOC0109TB cfr = new SOC0109TB();
		//画面显示设定
		cfr.setCattach(configuration.getCattach());
		cfr.setCcategory(configuration.getCcategory());
		cfr.setCdesc(configuration.getCdesc());
		cfr.setCid(configuration.getCid());
		cfr.setClabel(configuration.getClabel());
		cfr.setCname(configuration.getCname());
		cfr.setCoption(configuration.getCoption());
		cfr.setCseq(configuration.getCseq());
		cfr.setCstatus(status);
		cfr.setEsyscoding(configuration.getEsyscoding());
		cfr.setCunit(configuration.getCunit());
		cfr.setEid(configuration.getEid());
		cfr.setCrequired(configuration.getCrequired());

		soc0109BL.updateConfiguration(cfr);

		log.debug("========资产模型属性状态变化处理结束========");
		
	}
	
	/**
	 * <p>
	 * Description: 资产模型状态变化
	 * </p>
	 * 
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	public void changeEntityStatus(IGASM01DTO dto) throws BLException {
		log.debug("========资产模型状态变化处理开始========");
		IGASM0101Form form = dto.getIgasm0101Form();
		SOC0117Info entity = soc0117BL.searchEntityByKey(form.getEid());
		String status = "";
		if(entity == null){
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","资产模型状态变更");
		}
		//1为启用 2为停用
		if("1".equals(dto.getEstatus())){
			status="2";
		}else if("2".equals(dto.getEstatus())){
			status="1";
		}
		IGASM0102Form form0102 = new IGASM0102Form();
		//画面显示设定
		form0102.setEcategory(entity.getEcategory());
		form0102.setEid(entity.getEid());
		form0102.setEkey1(entity.getEkey1());
		form0102.setEkey2(entity.getEkey2());
		form0102.setEkey3(entity.getEkey3());
		form0102.setElabel(entity.getElabel());
		form0102.setEname(entity.getEname());
		form0102.setEstatus(status);//设置资产模型状态
		form0102.setEsyscoding(entity.getEsyscoding());
		form0102.setEparcoding(entity.getEparcoding());
		form0102.setEdesc(entity.getEdesc());
		if("999".equals(entity.getEparcoding())){
			form0102.setEparname("资产模型");
		}
		else{
			SOC0117SearchCondImpl ret = new SOC0117SearchCondImpl();
			ret.setEsyscoding(entity.getEparcoding());
			List<SOC0117Info> list = this.soc0117BL.searchEntity(ret, 0, 0);
			for (int i = 0; i < list.size(); i++) {
				form0102.setEparname(list.get(0).getEname());
			}
		}
		form0102.setEidStr(String.valueOf(form.getEid()));
		
		soc0117BL.updateEntity(form0102);

		log.debug("========资产模型状态变化处理结束========");
		
	}
	
	/**
	 * 查询不包括机房、机柜及服务记录的一级模型（生成EXCEL模板使用）
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO searchEntityActionForExportExcelModel(IGASM01DTO dto) throws BLException {

		log.debug("========一级模型查询处理开始========");
		
		//资产信息查询件数取得 
		
		int totalCount = this.soc0117BL.getEntitySearchCount(dto.getEntitySearchCond());
		
		if (totalCount == 0) {
			log.debug("========资产信息查询数据不存在========");
			//资产信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========资产信息查询数据件数过多========");
			//资产信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		//当前页资产信息取得
		PagingDTO pDto = dto.getPagingDto();
		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(dto.getEntitySearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
//		List<Entity> newList = new ArrayList<Entity>();
//		for(Entity e:entityList){
//			if(!CommonDefineUtils.ENTIY_CATEGORY_SERVICE_RECORD_SYSCODING.equals(e.getEsyscoding())){
//				newList.add(e);
//			}
//		}
//		if(newList==null){
//			throw new BLException("IGASM0101.E006");
//		}
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityList(entityList);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========一级模型查询处理终了========");
		return dto;
	}
	
	
	/**
	 * 取得该结点的资产模型全名
	 * @param syscoding
	 * @return
	 */
	private String getCompleteEntityName(String syscoding) {
		StringBuffer ename = new StringBuffer();
		try{
			ArrayList<String> codelist = new ArrayList<String>();
			if(syscoding.length()==6){
				codelist.add(syscoding);
			}else{
				String pcode = syscoding.substring(0, 6);
				codelist.add(pcode);
				String childs = syscoding.substring(6);
				int j = childs.length()/3;
				for(int i=1;i<=j;i++){
					codelist.add(pcode+childs.substring(0, 3*i));
				}
				
			}
			SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
			cond.setSelectList(codelist);
			List<SOC0117Info> ret = soc0117BL.searchEntity(cond, 0, 0);
			
			for(int i=0,j=ret.size();i<j;i++){
				String syscode = ret.get(i).getEsyscoding();
				if(syscoding.contains(syscode)){
					if(i>0){
						ename.append("-");
					}
					ename.append(ret.get(i).getEname());
				}
				
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return ename.toString();
	}
	
	
	/**
	 * 导出Excel模板
	 * @throws Exception
	 */
	public IGASM01DTO searchInfoForExportExcel(String esyscode) throws BLException{

		try
		{
			IGASM01DTO dto = new IGASM01DTO();
			//查询资产模型（除机房、机柜、服务记录）
//			List<String> selectList = new ArrayList<String>();
//			selectList.add("999001");
//			selectList.add("999002");
//			selectList.add("999003");
//			selectList.add("999005");
//			selectList.add("999006");
//			selectList.add("999010");
//			selectList.add("999011");
//			selectList.add("999012");
//			selectList.add("999013");
			SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
			//cond.setSelectList(selectList);
			cond.setEsyscoding(esyscode);
			List<SOC0117Info> list = soc0117BL.searchEntity(cond, 0, 0);
			dto.setTopEntityList(list);
			
			
			//查询资产模型（除机房、机柜、服务记录,并且为当前传入的资产模型编码对应的资产模型集合）
			List<String> delList = new ArrayList<String>();
			delList.add("999007");
			delList.add("999008");
			delList.add("999009");
			SOC0117SearchCondImpl cond1 = new SOC0117SearchCondImpl();
			cond1.setDelList(delList);
			cond1.setSyscoding_q(esyscode);
			List<SOC0117Info> elist = soc0117BL.searchEntity(cond1, 0, 0);
			List<SOC0117Info> entitylist = new ArrayList<SOC0117Info>();
			for(SOC0117Info entity:elist){
				SOC0117TB etb = (SOC0117TB)SerializationUtils.clone(entity);
				etb.setEname(getCompleteEntityName(etb.getEsyscoding()));
				entitylist.add(etb);
			}
			dto.setEntityList(entitylist);
			
			//查取值范围
			SOC0151SearchCondImpl ccdcond = new SOC0151SearchCondImpl();
			ccdcond.setCcdstatus("1");//查询状态为可用的数据
			List<SOC0151Info> ccdlist  = soc0151BL.searchConfigurationCodeDetail(ccdcond, 0, 0);
			dto.setCcdList(ccdlist);
			
			//查询机构
			IGSYM01BL sym01BL = (IGSYM01BL) WebApplicationSupport.getBean("igsym01BL");
			IGSYM01DTO sym01dto = sym01BL.searchOrganizationForIGASM0101();
			List<Organization> orglist = sym01dto.getOrganizationCondList();
			dto.setOrglist(orglist);
			
			//查询该资产的属性
			List<Map<String,List<SOC0109Info>>> maplist = new ArrayList<Map<String,List<SOC0109Info>>>();
			for(SOC0117Info entity:list){
				List<String> cattachList = new ArrayList<String>();
				Map<String,List<SOC0109Info>> map = new LinkedHashMap<String,List<SOC0109Info>>();
				//codedetail表中CCID为012的记录代表资产配置项类型，CID为资产配置项类型的值
				cattachList.add("0");//资产配置项类型为文本框
				cattachList.add("2");//资产配置项类型为下拉框
				cattachList.add("3");//资产配置项类型为日期
				
				//资产配置信息分层次查询
				List<SOC0117Info> parentlist = this.soc0117BL.getParentNodes(entity.getEid());
				for(SOC0117Info e : parentlist){
					SOC0109SearchCondImpl cond2 = new SOC0109SearchCondImpl();
					cond2.setCseq(1);//只查询页面显示的属性
					cond2.setEid(e.getEid().toString());
					cond2.setCattachList(cattachList);
					List<SOC0109Info> configurationList = this.soc0109BL.searchConfiguration(cond2, 0, 0);
					map.put(e.getEsyscoding(), configurationList);
				}
				maplist.add(map);
			}
			dto.setConfigurationMapList(maplist);

			
			//查询用户
			IGSYM02BL sym02BL = (IGSYM02BL) WebApplicationSupport.getBean("igsym02BL");
			IGSYM02DTO sym02dto = sym02BL.searchUserActionForIGASM0101();
			List<User> userlist = sym02dto.getUserList();
			dto.setUserlist(userlist);
			
			
			return dto;
		}catch (Exception e){
			e.printStackTrace();
			log.debug("=============生成一级资产模型模板出错！==============");
			log.debug(e.getMessage());
			throw new BLException("IGASM0101.E007");
		}
		
	}

	/**
	 * 资产信息查询处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO searchEntityAction(IGASM01DTO dto) throws BLException {

		log.debug("========资产信息查询处理开始========");
		
		//资产信息查询件数取得 
		int totalCount = this.soc0117BL.getEntitySearchCount(dto.getEntitySearchCond());
		
		if (totalCount == 0) {
			log.debug("========资产信息查询数据不存在========");
			//资产信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========资产信息查询数据件数过多========");
			//资产信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		//当前页资产信息取得
		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(dto.getEntitySearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		//int num = 0;
//		for(int i=0;i<entityList.size();i++){
//			Entity en = entityList.get(i);
//			if("007".equals(en.getElabel())){//去掉机房
//				//num++;
//				entityList.remove(i);
//				i--;
//			}else if("008".equals(en.getElabel())){//去掉机柜
//				//num++;
//				entityList.remove(i);
//				i--;
//			}
//		}
//		
//		if("999".equals(dto.getEntitySearchCond().getEsyscoding_q())){
//			totalCount = totalCount - 2;
//		}
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityList(entityList);
		
		dto.setStopbuttonMap(getButtonNameList(entityList));
		dto.setStartbuttonMap(getStartButtonNameList(entityList));
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========资产信息查询处理终了========");
		return dto;
	}
	
	/**
	 * 资产信息登记处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO insertEntityAction(IGASM01DTO dto) throws BLException {
		log.debug("========资产信息登记处理开始========");
		
		
		
//		EntitySearchCondImpl cond = new EntitySearchCondImpl();
//		
//		cond.setEparcoding(form.getEparcoding());
//		
//		List<Entity> list = this.ig117BL.getMaxCodingEntitys(cond);
//		String esyscoding = "";
//		
//		String entitynum = ResourceUtility.getString("ENTITY_NUM");//资产模型编码的级数
//		if(entitynum == null || "".equals(entitynum)){
//			entitynum = "6";
//		}
//		int entity_num = Integer.valueOf(entitynum);
//		int entity_sys_len = 18;//资产模型编码的默认长度
//		if(entity_num>1 && entity_num<10){
//			entity_sys_len = 3+3*(entity_num-1);
//		}
//		if(list.size()>0){//存在下级机构
//			Entity entity = list.get(0);
//			esyscoding = entity.getEsyscoding();
//			String temp = esyscoding.substring(esyscoding.length()-3);
//			if("999".equals(form.getEparcoding())){
//				String ecategory = entity.getEcategory();
//				ecategory = StringUtils.leftPad(Integer.parseInt(ecategory)+1+"", 3, "0");
//				if(ecategory.equals("999")){
//					throw new BLException(BLErrorType.ORGANIZATION_INSERT_ERROR,
//							"IGASM0101.E003","模型基本信息");
//				}
//				form.setEcategory(ecategory);
//			}
//			if(temp.substring(temp.length()-3).equals("999")){
//				throw new BLException(BLErrorType.ORGANIZATION_INSERT_ERROR,
//						"IGASM0101.E004","模型基本信息");
//			}
//			if("0".equals(temp.substring(0, 1))){//0**
//				String tmp = String.valueOf(Integer.valueOf(temp)+1);
//				if(tmp.length()==1){
//					temp = "00"+tmp;
//				}else if(tmp.length()==2){
//					temp = "0"+tmp;
//				}else{
//					temp = tmp;
//				}
//				esyscoding = esyscoding.substring(0,esyscoding.length()-3)+temp;
//			}else{//***
//				esyscoding = esyscoding.substring(0,esyscoding.length()-3)+String.valueOf(Integer.valueOf(temp)+1);
//			}
//			form.setEsyscoding(esyscoding);
//		}else{
//			
//			String syscode = form.getEparcoding();
//			
//			//判断是否已经达到规定的层次数
//			if(syscode!=null && syscode.length()>=entity_sys_len){
//				throw new BLException(BLErrorType.ORGANIZATION_INSERT_ERROR,
//						"IGASM0101.E005","模型基本信息");
//			}
//			
//			form.setEsyscoding(form.getEparcoding()+"001");
//		}
//		form.setEstatus("1");
		IGASM0102Form form = dto.getIgasm0102Form();
		dto.setEntity(form);
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEsyscoding(form.getEparcoding());
		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(cond);
		if(entityList!=null && entityList.size()>0){
			//资产信息登记处理
			SOC0117Info entity = this.soc0117BL.registEntity(dto.getEntity(),entityList.get(0).getEid());			
			dto.setEntity(entity);
		}else{
			//资产信息登记处理
			SOC0117Info entity = this.soc0117BL.registEntity(dto.getEntity(),"");		
			dto.setEntity(entity);
		}

		dto.addMessage(new ActionMessage( "IGCO10000.I004", "模型基本信息") );

		log.debug("========资产信息登记处理终了========");
		return dto;
	}

	/**
	 * 资产信息编辑画面初期显示处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO initIGASM0102Action(IGASM01DTO dto) throws BLException {

		log.debug("========资产信息编辑画面初期显示处理开始========");
		
		IGASM0102Form form = dto.getIgasm0102Form();
		
		String eidStr = form.getEidStr();
		
		String eid = form.getEidStr();
		
		//显示用资产信息取得
		SOC0117Info entity = this.soc0117BL.searchEntityByKey(eid);
		
		if ( entity == null ){
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","变更对象资产基本");
		}
		
		//画面显示设定
		form.setEcategory(entity.getEcategory());
		form.setEdesc(entity.getEdesc());
		form.setEid(entity.getEid());
		form.setEkey1(entity.getEkey1());
		form.setEkey2(entity.getEkey2());
		form.setEkey3(entity.getEkey3());
		form.setElabel(entity.getElabel());
		form.setEname(entity.getEname());
		form.setEstatus(entity.getEstatus());
		form.setEsyscoding(entity.getEsyscoding());
		form.setEparcoding(entity.getEparcoding());
		form.setEmodeltype(entity.getEmodeltype());
		if("999".equals(entity.getEparcoding()))
		{
			form.setEparname("资产模型");
		}
		else{
			SOC0117SearchCondImpl ret = new SOC0117SearchCondImpl();
			ret.setEsyscoding(entity.getEparcoding());
			List<SOC0117Info> list = this.soc0117BL.searchEntity(ret, 0, 0);
			for (int i = 0; i < list.size(); i++) {
				form.setEparname(list.get(0).getEname());
			}
		}
		form.setEidStr(eidStr);
		
		//编辑模式设定
		form.setMode("1");
		
		dto.setIgasm0102Form(form);
		
		dto.addMessage(new ActionMessage("IGCO10000.I001","模型基本信息"));
		
		log.debug("========资产信息编辑画面初期显示处理终了========");
		return dto;
	}

	/**
	 * 资产信息更新处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO updateEntityAction(IGASM01DTO dto) throws BLException {
		log.debug("========资产信息更新处理开始========");
		
		//资产信息更新处理
		this.soc0117BL.updateEntity(dto.getEntity());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "模型基本信息") );
		log.debug("========资产信息更新处理终了========");
		return dto;
	}
	
	/**
	 * 资产配置信息登记处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO insertConfigurationAction(IGASM01DTO dto) throws BLException {
		log.debug("========资产配置信息登记处理开始========");
		
	/*	//配置信息编号检测
		if (dto.getConfiguration().getClabel().compareTo(
				CommonDefineUtils.COMMON_CONFIG_LABEL_MIN) >=0 &&
				dto.getConfiguration().getClabel().compareTo(
						CommonDefineUtils.COMMON_CONFIG_LABEL_MAX) <=0 ) {
			throw new BLException(BLErrorType.CONFIGURATION_ALREADY_EXISTS,
			"IGCOM0102.E001");
			
		}*/

		//资产配置信息登记处理
		SOC0109Info configuration = this.soc0109BL.registConfiguration(dto.getConfiguration());
		
		dto.setConfiguration(configuration);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "模型配置信息") );

		log.debug("========资产配置信息登记处理终了========");
		return dto;
	}

	/**
	 * 资产详细信息画面初期显示处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO initIGASM0106Action(IGASM01DTO dto) throws BLException {

		log.debug("========资产详细信息画面初期显示处理开始========");
		//资产基本信息查询
		SOC0117Info entity = this.soc0117BL.searchEntityByKey(dto.getConfigurationSearchCond().getEid());
		
		if (entity == null) {
			//资产基本内容信息不存在
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E001");
		}
		
		dto.setEntity(entity);
		
		//资产配置信息查询件数取得 
		int totalCount = 0;
		List<SOC0117Info> list = this.soc0117BL.getParentNodes(entity.getEid());
		Map<String,List<SOC0109Info>> map = new LinkedHashMap<String,List<SOC0109Info>>();
		SOC0109SearchCondImpl cond = new SOC0109SearchCondImpl();
		cond.setCseq(1);
		//资产配置信息分层次查询
		for(SOC0117Info e : list){
			cond.setEid(e.getEid().toString());
			List<SOC0109Info> configurationList = this.soc0109BL.searchConfiguration(cond, 0, 0);
			map.put(e.getEname(), configurationList);
			totalCount+=configurationList.size();
		}
		if (totalCount == 0) {
			log.debug("========资产配置信息查询数据不存在========");
			//资产配置信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========资产配置信息查询数据件数过多========");
			//资产配置信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		dto.setConfigurationMap(map);

		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));
		
		log.debug("========资产详细信息画面初期显示处理终了========");
		return dto;
	}

	/**
	 * 资产配置信息更新处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO updateConfigurationAction(IGASM01DTO dto) throws BLException {
		log.debug("========资产配置信息更新处理开始========");
		
		//资产配置信息更新处理
		this.soc0109BL.updateConfiguration(dto.getConfiguration());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "模型配置信息") );
		log.debug("========资产配置信息更新处理终了========");
		return dto;
	}
	
	/**
	 * 资产配置信息编辑画面初期显示处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO initIGASM0104Action(IGASM01DTO dto) throws BLException {

		log.debug("========变更用资产配置信息编辑画面初期显示处理开始========");
		IGASM0104Form form = dto.getIgasm0104Form();
		
		String cid = form.getCidStr();
		
		//显示用资产配置信息查询
		SOC0109Info configuration = this.soc0109BL.searchConfigurationByKey(cid);
		
		if ( configuration == null ){
			throw new BLException("IGCO10000.E004","变更对象资产配置");
		}
		
		//显示用设定
		//KEY
		form.setEid(configuration.getEid());
		form.setCid(configuration.getCid());
		//编号
		form.setClabel(configuration.getClabel());
		//名称
		form.setCname(configuration.getCname());
		//单位
		form.setCunit(configuration.getCunit());
		//必填
		form.setCrequired(configuration.getCrequired());
		//状态
		form.setCstatus(configuration.getCstatus());
		//说明
		form.setCdesc(configuration.getCdesc());
		//类别
		form.setCcategory(configuration.getCcategory());
		//取值范围
		form.setCoption(configuration.getCoption());
		//取值范围
		if("2".equals(configuration.getCattach())){
			SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
			cond.setCcdcategory(configuration.getCoption());
			cond.setCcdstatus("1");
			List<SOC0151Info> list = soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
			if(!list.isEmpty()){
				form.setRangename(list.get(0).getCcdlabel());
			}
		}else if ("4".equals(configuration.getCattach())){//属性值关联模型
			SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
			cond.setEsyscoding(configuration.getCoption());
			List<SOC0117Info> list = soc0117BL.searchEntity(cond, 0, 0);
			if(list.size() == 1){
				form.setCename(list.get(0).getEname());
			}else{
				throw new BLException("IGASM0104.E001",dto.getEntitySearchCond().getEsyscoding());
			}
			form.setCesyscoding(configuration.getCoption());
			form.setCoption(null);
		}
		
		//顺序
		form.setCseq(configuration.getCseq());
		
		//附件标识
		form.setCattach(configuration.getCattach());
		
		form.setCstatus(configuration.getCstatus());
		
		//编辑模式设定
		form.setMode("1");
		
		dto.setIgasm0104Form(form);
		
		dto.addMessage(new ActionMessage("IGCO10000.I001","模型配置信息"));
		
		log.debug("========变更用资产配置信息编辑画面初期显示处理终了========");
		return dto;
	}

	/**
	 * 资产信息删除处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO deleteEntityAction(IGASM01DTO dto) throws BLException {
		log.debug("========资产信息删除处理开始========");
		
		for( int i=0;i<dto.getDeleteEntity().length;i++ ){
			String eid = dto.getDeleteEntity()[i];
			
			//资产信息查询处理
			SOC0117Info entity = this.soc0117BL.searchEntityByKey(eid);
			
			if (entity == null){
				throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
						"IGCO10000.E004","删除对象资产基本");
			}

			//资产信息删除处理
			this.soc0117BL.deleteEntity(entity);
		}
		
		log.debug("========资产信息删除处理终了========");
		return dto;
	}
	
	/**
	 * 资产配置信息删除处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO deleteConfigurationAction(IGASM01DTO dto) throws BLException {
		log.debug("========资产配置信息删除处理开始========");
		
		for( int i=0;i<dto.getDeleteConfiguration().length;i++ ){
			String cid = dto.getDeleteConfiguration()[i];
			
			//资产配置信息查询
			SOC0109Info configuration = 
				this.soc0109BL.searchConfigurationByKey(cid);
			
			if (configuration == null){
				throw new BLException("IGCO10000.E004","删除对象资产配置");
			}
			
			//资产配置信息删除
			this.soc0109BL.deleteConfiguration(configuration);
		}
		
		log.debug("========资产配置信息删除处理终了========");
		return dto;
	}
	
	/**
	 * 资产下拉数据标识查询
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO searchConfigurationCodeDetailBean(IGASM01DTO dto) throws BLException {
		log.debug("========资产下拉数据查询处理开始========");
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		cond.setCcdtype("A");
		cond.setCcdstatus("1");
		List<ConfigurationCodeDetailBean> list = this.soc0151BL.searchConfigurationCodeDetailBean(cond);
		dto.setConfigurationCodeDetailBeanList(list);
		log.debug("========资产下拉数据查询处理终了========");
		return dto;
	}
	
	/**
	 * 资产下拉数据标识查询
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO searchConfigurationCodeDetail(IGASM01DTO dto) throws BLException {
		log.debug("========资产下拉数据查询处理开始========");
		if(dto.getIgasm0109Form() != null){
			this.changeCfgCodeDetailLabel(dto);
		}
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		cond.setCcdtype("A");
		List<String> tempList = new ArrayList<String>();
		List<SOC0151Info> retList = new ArrayList<SOC0151Info>();
		List<SOC0151Info> list = this.soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
		for (SOC0151Info configurationCodeDetail : list) {
			String ccdcategory = configurationCodeDetail.getCcdcategory();
			if(!tempList.contains(ccdcategory)){
				tempList.add(ccdcategory);
				retList.add(configurationCodeDetail);
			}
		}
		dto.setConfigurationCodeDetailList(retList);
		log.debug("========资产下拉数据查询处理终了========");
		return dto;
	}
	
	protected void changeCfgCodeDetailLabel(IGASM01DTO dto) throws BLException{
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		cond.setCcdcategory(dto.getIgasm0109Form().getCcdcategory());
		List<SOC0151Info> list = this.soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
		for (SOC0151Info configurationCodeDetail : list) {
			SOC0151TB ccdTB = (SOC0151TB) configurationCodeDetail;
			ccdTB.setCcdlabel(dto.getIgasm0109Form().getCcdlabel());
			this.soc0151BL.registConfigurationCodeDetail(ccdTB);
		}
	}
	
	public IGASM01DTO searchCfgCodeDetailByCategory(IGASM01DTO dto) throws BLException {
		log.debug("========资产下拉数据查询处理开始========");
		if("changeValue".equals(dto.getFlag())){
			this.changeCfgCodeDetailValue(dto);
		} else if ("status".equals(dto.getFlag())){
			this.changeCfgCodeDetailStatus(dto);
		}
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		cond.setCcdtype("A");
		cond.setCcdcategory(dto.getIgasm0110Form().getCcdcategory());
		List<SOC0151Info> list = this.soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
		dto.setConfigurationCodeDetailList(list);
		log.debug("========资产下拉数据查询处理终了========");
		return dto;
	}
	
	protected void changeCfgCodeDetailValue(IGASM01DTO dto) throws BLException{
		Integer ccdid = Integer.valueOf(dto.getIgasm0110Form().getCcdid());
		SOC0151Info configurationCodeDetail = soc0151BL.searchConfigurationCodeDetailByKey(ccdid);
		SOC0151TB ccdTB = (SOC0151TB) configurationCodeDetail;
		ccdTB.setCcdvalue(dto.getIgasm0110Form().getCcdvalue());
		this.soc0151BL.registConfigurationCodeDetail(ccdTB);
	}
	
	protected void changeCfgCodeDetailStatus(IGASM01DTO dto) throws BLException{
		Integer ccdid = Integer.valueOf(dto.getIgasm0110Form().getCcdid());
		SOC0151Info configurationCodeDetail = soc0151BL.searchConfigurationCodeDetailByKey(ccdid);
		SOC0151TB ccdTB = (SOC0151TB) configurationCodeDetail;
		if("1".equals(ccdTB.getCcdstatus())){
			ccdTB.setCcdstatus("0");
		}else if ("0".equals(ccdTB.getCcdstatus())){
			ccdTB.setCcdstatus("1");
		}
		this.soc0151BL.registConfigurationCodeDetail(ccdTB);
	}
	
	/**
	 * 资产下拉数据登记处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO insertConfigurationCodeDetailAction(IGASM01DTO dto) throws BLException {
		log.debug("========资产信息登记处理开始========");
		
		IGASM0108Form igasm0108form = dto.getIgasm0108Form();
		String[] values = igasm0108form.getCcdvalues();
		igasm0108form.setCcdtype("A");
		igasm0108form.setCcdstatus("1");
		String ccdcategory = "";
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		List<SOC0151Info> list = this.soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
		if(list.size()>0){//存在下级机构
			SOC0151Info ConfigurationCodeDetail = list.get(list.size() - 1);
			ccdcategory = ConfigurationCodeDetail.getCcdcategory();
			
			if(ConfigurationCodeDetail.equals("999")){
				throw new BLException("IGSYM0101.E004","数据基本信息");
			}
			if("0".equals(ccdcategory.substring(0, 1))){//0**
				String tmp = String.valueOf(Integer.valueOf(ccdcategory)+1);
				if(tmp.length()==1){
					ccdcategory = "00"+tmp;
				}else if(tmp.length()==2){
					ccdcategory = "0"+tmp;
				}else{
					ccdcategory = tmp;
				}
				
			}
			igasm0108form.setCcdcategory(ccdcategory);
		}else{
			igasm0108form.setCcdcategory("001");
		}
		if (values!=null && values.length>0) {
			for (int i = 0; i < values.length; i++) {
				igasm0108form.setCcdvalue(values[i]);
				dto.setIgasm0108Form(igasm0108form);
				dto.setConfigurationcodedetail(igasm0108form);
				SOC0151Info configurationcodedetail = this.soc0151BL.registConfigurationCodeDetail(dto.getConfigurationcodedetail());
				dto.setConfigurationcodedetail(configurationcodedetail);
			}
		}else{
			dto.setIgasm0108Form(igasm0108form);
			dto.setConfigurationcodedetail(igasm0108form);
			SOC0151Info configurationcodedetail = this.soc0151BL.registConfigurationCodeDetail(dto.getConfigurationcodedetail());
			dto.setConfigurationcodedetail(configurationcodedetail);
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "数据基本信息") );

		log.debug("========资产信息登记处理终了========");
		return dto;
	}
	
	public IGASM01DTO getCfgCodeDetailByCategory(IGASM01DTO dto) throws BLException {
		log.debug("========资产下拉数据查询处理开始========");
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		cond.setCcdtype("A");
		cond.setCcdcategory(dto.getIgasm0111Form().getCcdcategory());
		List<SOC0151Info> list = this.soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
		dto.setConfigurationcodedetail(list.get(0));
		log.debug("========资产下拉数据查询处理终了========");
		return dto;
	}
	
	public IGASM01DTO insertCfgCodeDetailAction(IGASM01DTO dto) throws BLException {
		log.debug("========资产信息登记处理开始========");
		IGASM0111Form igasm0111form = dto.getIgasm0111Form();
		String[] values = igasm0111form.getCcdvalues();
		igasm0111form.setCcdtype("A");
		igasm0111form.setCcdstatus("1");
		for (int i = 0; i < values.length; i++) {
			igasm0111form.setCcdvalue(values[i]);
			dto.setConfigurationcodedetail(igasm0111form);
			this.soc0151BL.registConfigurationCodeDetail(dto.getConfigurationcodedetail());
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "数据基本信息") );

		log.debug("========资产信息登记处理终了========");
		return dto;
	}
	
	/**
	 * 资产属性默认值编辑画面初期化处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 * @throws BLException
	 */
	public IGASM01DTO initIGASM0114Action(IGASM01DTO dto) throws BLException {
		log.debug("========资产属性默认值编辑画面初期化处理开始========");
		IGASM0114Form form = dto.getIgASM0114Form();
		IG611SearchCondImpl cond = new IG611SearchCondImpl();
		cond.setEsyscoding(form.getEsyscoding());
		cond.setEid(form.getEid());
		//配置项配置信息全件查询
		List<IG612Info> lst_IG612Info = this.ig611BL.searchDefaultValue(cond);
		//查询模型信息
		SOC0117Info ig117info = soc0117BL.searchEntityByKey(form.getEid());
		if(ig117info != null){
			//为模型名称与模型说明赋值
			form.setEname(ig117info.getEname());
			form.setEdesc(ig117info.getEdesc());
		}
		int totalCount = lst_IG612Info.size();
		String[] Cvalue = new String[totalCount];
		String[] entityItemCvalue = new String[totalCount];
		Map<String,List<IG612Info>> map = new LinkedHashMap<String,List<IG612Info>>();
		int i = 0;
		int j = 0;
		List<String> strlist = new ArrayList<String>();
		for(IG612Info e : lst_IG612Info){
			if(!map.containsKey(e.getCcategory())){
				map.put(e.getCcategory(), new ArrayList<IG612Info>());
				strlist.add(e.getCcategory());
			}
			map.get(e.getCcategory()).add(e);
			if("2".equals(e.getCattach())){
				List<LabelValueBean> list = soc0151BL.searchLabelValueBeanList(e.getCoption());
				form.setSelectedListMap(j++, list);
			}
			if ("5".equals(e.getCattach())) {
				List<LabelValueBean> list =soc0151BL.searchLabelValueBeanList(e
						.getCoption());
				if (list.size() > 0) {
					list.remove(0);
				}
				form.setSelectedListMap(j++, list);
			}
		}
		for(String str : strlist){
			for(IG612Info e : map.get(str)){
				//显示是资产名称，实际存值是资产名称(资产ID)
				if("4".equals(e.getCattach()) && StringUtils.isNotEmpty(e.getCvalue())){
					Cvalue[i] = e.getCvalue().substring(0, e.getCvalue().lastIndexOf("("));
					entityItemCvalue[i] = e.getCvalue();
				} else {
					Cvalue[i] = e.getCvalue();
				}
				i++;
			}
		}
		form.setCvalue(Cvalue);
		form.setEntityItemCvalue(entityItemCvalue);
		dto.setMap_IG612Info(map);
		log.debug("========资产属性默认值编辑画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 资产属性默认值编辑处理
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 * @throws BLException 
	 */
	public IGASM01DTO editIGASM0114Action(IGASM01DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========资产属性默认值编辑处理开始========");
		IGASM0114Form form = dto.getIgASM0114Form();
		//查询模型信息
		SOC0117Info entity = this.soc0117BL.searchEntityByKey(form.getEid());
		SOC0117TB etb = (SOC0117TB)SerializationUtils.clone(entity);
		etb.setEdesc(form.getEdesc());
		etb.setEname(form.getEname());
		//更新模型信息
		this.soc0117BL.updateEntity(etb);
		for( int i=0 ; i < form.getCid().length; i++ ){
			IG611TB ig611 = new IG611TB();
			//类型ID
			ig611.setEid(Integer.parseInt(form.getEid()));
			//资产配置ID
			ig611.setCid(Integer.parseInt(form.getCid()[i]));
			//内容
			ig611.setCvalue(form.getCvalue()[i]);
			//显示是资产名称，实际存值是资产名称(资产ID)
			if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getEntityItemCvalue()[i])){
				ig611.setCvalue(form.getEntityItemCvalue()[i]);
			}
			//附件删除
			if("1".equals(form.getCiattach()[i]) && "1".equals(form.getDelfile()[i])){
				ig611.setCvalue("");
			}
			//上传文件检测
			if (form.getCiattach()[i].toUpperCase().equals("1")) {
				FormFile file = form.getAttachFile(i);
				if ( file != null && file.getFileSize() > 0) {
					//上传文件存在的情况
					//上传文件路径
					String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
					StringBuffer pathBuf = new StringBuffer();
					
					//根目录
					pathBuf.append(rootPath);
					//机能ID
					pathBuf.append("asm"+File.separator);
					//备件ID
					pathBuf.append("model");
					pathBuf.append(File.separator);
					
					StringBuffer fileName = new StringBuffer();
					
					//扩展名取得
					String fileType = "";
					String sFileName = file.getFileName();
					int point = sFileName.lastIndexOf(".");
					if (point != -1) {
						fileType = sFileName.substring(point);
						fileName.append(sFileName.substring(0, point));
					}
					
					//文件名
					fileName.append("_");
					fileName.append(form.getEid());
					fileName.append("&");
					fileName.append(form.getCid()[i]);
					//文件扩展名
					fileName.append(fileType);

					//文件上传处理
					this.fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
					
					//内容
					//上传文件名保存
					ig611.setCvalue(fileName.toString());
				}
			}
			this.ig611BL.registIG611Info(ig611);
		}
		dto.addMessage(new ActionMessage("IGCO10000.I005","备件模型及其配置信息"));
		log.debug("========资产属性默认值编辑处理终了========");
		return dto;
	}
}
