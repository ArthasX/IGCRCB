package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0606Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0606SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0107DAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0109DAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0129DAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0606DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * 资产属性业务逻辑实现
 * 
 */
public class SOC0107BLImpl extends BaseBLImpl implements SOC0107BL {

	/** ConfigItem DAO */
	protected SOC0107DAO soc0107DAO;
	
	/** ConfigItemVW DAO */
	protected SOC0129DAO soc0129DAO;
	
	/** Configuration DAO */
	protected SOC0109DAO soc0109DAO;
	
	
	protected SOC0118BL soc0118BL;
	
	/** soc0606 DAO */
	protected SOC0606DAO soc0606DAO;

	
	/**
	 * ConfigItemDAO设定
	 *
	 * @param soc0107DAO ConfigItemDAO
	 */
	public void setSoc0107DAO(SOC0107DAO soc0107DAO) {
		this.soc0107DAO = soc0107DAO;
	}

	/**
	 * ConfigItemVWDAO设定
	 *
	 * @param soc0129DAO ConfigItemVWDAO
	 */
	public void setSoc0129DAO(SOC0129DAO soc0129DAO) {
		this.soc0129DAO = soc0129DAO;
	}

	/**
	 * ConfigurationDAO设定
	 *
	 * @param soc0109DAO ConfigurationDAO
	 */
	public void setSoc0109DAO(SOC0109DAO soc0109DAO) {
		this.soc0109DAO = soc0109DAO;
	}

	/**
	 * SOC0606DAO设定
	 *
	 * @param SOC0606DAO SOC0606DAO
	 */
	public void setSoc0606DAO(SOC0606DAO soc0606dao) {
		soc0606DAO = soc0606dao;
	}
	
	/**
	 * soc0118BL设定
	 *
	 * @param soc0118BL soc0118BL
	 */
	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}

	/**
	 * <p>
	 * 新的资产属性信息对象实例取得
	 * <p>
	 * 
	 * @return 新的资产属性信息对象实例取得
	 */

	public SOC0107TB getSOC0107Instance() {
		return new SOC0107TB();
	}

	/**
	 * 根据资产属性信息主键取得资产属性信息
	 * 
	 * @param ciid 资产属性信息主键
	 * @return 资产属性信息
	 * @throws BLException 
	 */
	public SOC0107Info searchSOC0107ByKey(Integer ciid) throws BLException{
		return checkExistSOC0107(ciid);
	}

	/**
	 * 根据检索条件取得资产属性信息列表（平台保留，请使用searchConfigItemVW方法进行检索）
	 * 
	 * @param cond 资产属性信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产属性信息检索结果列表
	 */
	public List<SOC0107Info> searchSOC0107(SOC0107SearchCond cond, int start, int count){
		List<SOC0107Info> ret = soc0107DAO.findByCond(cond,0,0);
		return ret;
	}
	
	/**
	 * 根据检索条件取得资产属性信息列表（平台保留，请使用searchConfigItemVW方法进行检索）
	 * 
	 * @param cond 资产属性信息检索条件
	 * @return 资产属性信息检索结果列表
	 */
	public List<SOC0107Info> searchSOC0107(SOC0107SearchCond cond) {
		List<SOC0107Info> ret = soc0107DAO.findByCond(cond,0,0);
		return ret;
	}
	
	/**
	 * 根据检索条件取得资产属性信息列表
	 * 
	 * @param eiid 资产ID
	 * @param civersion 资产属性大版本号 
	 * 			<br>civersion:null检索资产属性所有版本的属性信息。
	 * 			<br>civersion:-1检索资产属性最新版本的属性信息。
	 * 			<br>civersion:其他值检索资产属性对应版本的属性信息。
	 * @param cismallversion 资产属性小版本号
	 * @param cname 资产属性名称(模糊查询条件)
	 * @return 资产属性信息检索结果列表
	 */
	public List<SOC0107Info> searchSOC0107HistoryByEiid(Integer eiid, Integer civersion, Integer cismallversion, String cname) throws BLException {
		//取得资产id为eiid的资产的版本号
		SOC0118Info entityItem = soc0118BL.searchEntityItemByKey(eiid);
		if(entityItem==null){
			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS,
					"IGCO10000.E003","资产");
		}

		List<SOC0107Info> itemlist = new ArrayList<SOC0107Info>();		
		if(StringUtils.isNotEmpty(cname)){
			//取得属性名称中包含cname值的属性集合
			SOC0109SearchCondImpl cond = new SOC0109SearchCondImpl();
			cond.setCname(cname);
			List<SOC0109Info> list = soc0109DAO.findByCond(cond, 0, 0);
			for(SOC0109Info config:list){
				List<SOC0107Info> ret = new ArrayList<SOC0107Info>(); 
				SOC0107SearchCondImpl cond1 = new SOC0107SearchCondImpl();
				if(civersion==null){
					//检索所有版本的属性信息
					cond1.setEiid(eiid.toString());
					cond1.setCid(config.getCid());
					ret = soc0107DAO.findByCond(cond1,0,0);
				}else if(civersion==-1){
					//检索最新版本的属性信息
					cond1.setEiid(eiid.toString());
					cond1.setCid(config.getCid());
					cond1.setCiversion(String.valueOf(entityItem.getEiversion()));
					cond1.setCismallversion(entityItem.getEismallversion().toString());
					ret = soc0107DAO.findByCond(cond1,0,0);
				}else{
					//根据传入的版本号检索对应版本的属性信息
					cond1.setEiid(eiid.toString());
					cond1.setCid(config.getCid());
					cond1.setCiversion(String.valueOf(civersion));
					cond1.setCismallversion(cismallversion.toString());
					ret = soc0107DAO.findByCond(cond1,0,0);
				}
				
				itemlist.addAll(ret);
			}
		}else{
			List<SOC0107Info> ret = new ArrayList<SOC0107Info>(); 
			SOC0107SearchCondImpl cond1 = new SOC0107SearchCondImpl();
			if(civersion==null){
				//检索所有版本的属性信息
				cond1.setEiid(eiid.toString());
				ret = soc0107DAO.findByCond(cond1,0,0);
			}else if(civersion==-1){
				//检索最新版本的属性信息
				cond1.setEiid(eiid.toString());
				cond1.setCiversion(String.valueOf(entityItem.getEiversion()));
				ret = soc0107DAO.findByCond(cond1,0,0);
			}else{
				//根据传入的版本号检索对应版本的属性信息
				cond1.setEiid(eiid.toString());
				cond1.setCiversion(String.valueOf(civersion));
				ret = soc0107DAO.findByCond(cond1,0,0);
			}
			
			itemlist.addAll(ret);
		}
		

		return itemlist;
	}
	
	/**
	 * 根据检索条件取得资产属性信息列表
	 * 
	 * @param eiid 资产ID
	 * @param civersion 资产属性版本号 
	 * 			<br>civersion:null检索资产属性所有版本的属性信息。
	 * 			<br>civersion:-1检索资产属性最新版本的属性信息。
	 * 			<br>civersion:其他值检索资产属性对应版本的属性信息。
	 * @param cname 资产属性名称
	 * @return 资产属性信息检索结果列表
	 */
	public List<SOC0107Info> searchSOC0107HistoryByEiid(Integer eiid, Integer civersion, String cname) throws BLException {
		//取得资产id为eiid的资产的版本号
		SOC0118Info entityItem = soc0118BL.searchEntityItemByKey(eiid);
		if(entityItem==null){
			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS,
					"IGCO10000.E003","资产");
		}

		List<SOC0107Info> itemlist = new ArrayList<SOC0107Info>();		
		if(StringUtils.isNotEmpty(cname)){
			//取得属性名称中包含cname值的属性集合
			SOC0109SearchCondImpl cond = new SOC0109SearchCondImpl();
			cond.setCname(cname);
			List<SOC0109Info> list = soc0109DAO.findByCond(cond, 0, 0);
			for(SOC0109Info config:list){
				List<SOC0107Info> ret = new ArrayList<SOC0107Info>(); 
				SOC0107SearchCondImpl cond1 = new SOC0107SearchCondImpl();
				if(civersion==null){
					//检索所有版本的属性信息
					cond1.setEiid(String.valueOf(eiid));
					cond1.setCid(config.getCid());
					ret = soc0107DAO.findByCond(cond1,0,0);
				}else if(civersion==-1){
					//检索最新版本的属性信息
					cond1.setEiid(String.valueOf(eiid));
					cond1.setCid(config.getCid());
					cond1.setCiversion(String.valueOf(entityItem.getEiversion()));
					ret = soc0107DAO.findByCond(cond1,0,0);
				}else{
					//根据传入的版本号检索对应版本的属性信息
					cond1.setEiid(String.valueOf(eiid));
					cond1.setCid(config.getCid());
					cond1.setCiversion(String.valueOf(civersion));
					ret = soc0107DAO.findByCond(cond1,0,0);
				}
				
				itemlist.addAll(ret);
			}
		}else{
			List<SOC0107Info> ret = new ArrayList<SOC0107Info>(); 
			SOC0107SearchCondImpl cond1 = new SOC0107SearchCondImpl();
			if(civersion==null){
				//检索所有版本的属性信息
				cond1.setEiid(String.valueOf(eiid));
				ret = soc0107DAO.findByCond(cond1,0,0);
			}else if(civersion==-1){
				//检索最新版本的属性信息
				cond1.setEiid(String.valueOf(eiid));
				cond1.setCiversion(String.valueOf(entityItem.getEiversion()));
				ret = soc0107DAO.findByCond(cond1,0,0);
			}else{
				//根据传入的版本号检索对应版本的属性信息
				cond1.setEiid(String.valueOf(eiid));
				cond1.setCiversion(String.valueOf(civersion));
				ret = soc0107DAO.findByCond(cond1,0,0);
			}
			
			itemlist.addAll(ret);
		}
		

		return itemlist;
	}
	
	/**
	 * 保存资产属性信息处理，其他属性统一提升一个版本<br>
	 * ConfigItem实现类对象设置eiid,cid和civalue值即可
	 * 
	 * @param currentEiversion 当前资产版本号(更新前)
	 * @param configItem 资产属性信息
	 * @return 保存后的资产属性信息
	 */
	public void saveSOC0107(int currentEiversion, SOC0107Info soc0107Info) throws BLException {
		//校验
		if(soc0107Info == null) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","资产属性基本");
		} else if(soc0107Info.getEiid() == null || soc0107Info.getEiid() <= 0){
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","资产基本");
		} else if(soc0107Info.getCid() == null || soc0107Info.getCid() == ""){
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","资产模型属性基本");
		}
		//查询所属资产
		SOC0118Info entityItem = soc0118BL.searchEntityItemByKey(soc0107Info.getEiid());
		
		if(currentEiversion != entityItem.getEiversion()) {
			throw new BLException("IGCO00000.E004");
		}
		
		//查询资产属性
		SOC0129SearchCondImpl cond = new SOC0129SearchCondImpl();
		cond.setEiid(entityItem.getEiid().toString());
		List<SOC0129Info> ciList = searchConfigItemVW(cond);
		//最新版本
		int version = entityItem.getEiversion() + 1;
		//修改时间
		String ciupdtime = IGStringUtils.getCurrentDateTime();
		//新增资产属性信息
		for(SOC0129Info ci : ciList) {
			SOC0107TB configItemTB = new SOC0107TB();
			//资产ID
			configItemTB.setEiid(Integer.parseInt(ci.getEiid()));
			//模型属性ID
			configItemTB.setCid(ci.getCid());
			//模型ID
			configItemTB.setEid(ci.getEid());
			//模型层次码
			configItemTB.setEsyscoding(ci.getEsyscoding());
			//版本号
			configItemTB.setCiversion(version);
			//更新时间
			configItemTB.setCiupdtime(ciupdtime);
			//如属性ID相等则替换属性值
			if(ci.getCid().equals(soc0107Info.getCid().toString())) {
				configItemTB.setCivalue(soc0107Info.getCivalue());
			} else {
				configItemTB.setCivalue(ci.getCivalue());
			}
			soc0107DAO.save(configItemTB);
		}
		
		//修改资产基本信息
		SOC0118TB entityItemTB = (SOC0118TB)SerializationUtils.clone(entityItem);
		
		entityItemTB.setEiversion(version);
		
		entityItemTB.setEiupdtime(ciupdtime);
		
		soc0118BL.updateEntityItem(entityItemTB);
		
	}
	
	/**
	 * 保存同一资产多个属性信息处理，其他属性统一提升一个版本<br>
	 * ConfigItem实现类对象设置cid和civalue值即可
	 * 
	 * @param eiid 资产ID
	 * @param currentEiversion 当前资产版本号(更新前)
	 * @param configItemList 保存的资产属性信息数据集合
	 */
	public void saveSOC0107(Integer eiid, int currentEiversion, List<SOC0107Info> soc0107InfoList) throws BLException {
		if(eiid == null || eiid <= 0){
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","资产基本");
		} else if(soc0107InfoList == null || soc0107InfoList.size() == 0) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","资产属性基本");
		}
		//查询所属资产
		SOC0118Info entityItem = soc0118BL.searchEntityItemByKey(eiid);
		
		if(currentEiversion != entityItem.getEiversion()) {
			throw new BLException("IGCO00000.E004");
		}
		
		//最新版本
		int version = entityItem.getEiversion() + 1;
		//修改时间
		String ciupdtime = IGStringUtils.getCurrentDateTime();
		//查询资产属性
		SOC0129SearchCondImpl cond = new SOC0129SearchCondImpl();
		cond.setEiid(eiid.toString());
		//2014年8.29添加-为采购流程
		cond.setEsyscoding_q(entityItem.getEsyscoding());
		List<SOC0129Info> ciList = searchConfigItemVW(cond);
		//新增资产属性信息
		for(SOC0129Info ci : ciList) {
			SOC0107TB configItemTB = new SOC0107TB();
			//资产ID
			configItemTB.setEiid(Integer.parseInt(ci.getEiid()));
			//模型属性ID
			configItemTB.setCid(ci.getCid());
			//模型ID
			configItemTB.setEid(ci.getEid());
			//模型层次码
			configItemTB.setEsyscoding(ci.getEsyscoding());
			//版本号
			configItemTB.setCiversion(version);
			//更新时间
			configItemTB.setCiupdtime(ciupdtime);
			
			configItemTB.setCivalue(ci.getCivalue());
			//资产升版 - 小版本不能为NULL
			configItemTB.setCismallversion(ci.getCismallversion());
			for(SOC0107Info soc0107Info : soc0107InfoList) {
				//校验
				if(soc0107Info.getCid() == null || soc0107Info.getCid() == ""){
					throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
							"IGCO10000.E004","资产模型属性基本");
				}
				//如属性ID相等则替换属性值
				if(ci.getCid().equals(soc0107Info.getCid().toString())) {
					configItemTB.setCivalue(soc0107Info.getCivalue());
					continue;
				}
			}
			soc0107DAO.save(configItemTB);
		}
		
		//修改资产基本信息
		SOC0118TB entityItemTB = (SOC0118TB)SerializationUtils.clone(entityItem);
		
		entityItemTB.setEiversion(version);
		
		entityItemTB.setEiupdtime(ciupdtime);
		
		soc0118BL.updateEntityItem(entityItemTB);
		
	}
	
	
	/**
	 * 保存资产属性信息处理（平台保留）
	 * 
	 * @param configItem 保存的资产属性信息数据
	 * @return 资产属性信息
	 */
	public SOC0107Info registSOC0107(SOC0107Info configItem) throws BLException {
		SOC0107Info ret = soc0107DAO.save(configItem);
		return ret;
	}

	/**
	 * 根据检索条件取得资产属性信息结果条数（平台保留，请使用getConfigItemVWSearchCount方法进行检索）
	 * 
	 * @param cond 资产属性信息检索条件
	 * @return 资产属性信息结果条数
	 */
	public int getSOC0107SearchCount(SOC0107SearchCond cond) {
		return soc0107DAO.getSearchCount(cond);
	}

	

	/**
	 * 变更资产属性信息处理（平台保留）
	 * 
	 * @param configItem 变更的资产属性信息数据
	 * @return 资产属性信息
	 */
	public SOC0107Info updateSOC0107(SOC0107Info soc0107Info) throws BLException {
		checkExistSOC0107(soc0107Info.getCiid());
		SOC0107Info ret = soc0107DAO.save(soc0107Info);
		return ret;
	}
	
	/**
	 * 资产属性信息存在检查
	 * 
	 * @param ciid 资产属性ID
	 * @return 资产属性信息
	 * @throws BLException 
	 */
	protected SOC0107Info checkExistSOC0107(Integer ciid) throws BLException{//必须有
		SOC0107Info info = soc0107DAO.findByPK(ciid);
		if(info == null) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","资产属性基本");
		}
		return info;
	}
	
	/**
	 * 根据检索条件取得资产配置信息结果条数
	 * 
	 * @param cond 资产配置信息检索条件
	 * @return 资产配置信息结果条数
	 */
	public int getConfigItemVWSearchCount(SOC0129SearchCond cond){

		return soc0129DAO.getSearchCount(cond);
	}

	/**
	 * 根据检索条件取得资产配置信息列表
	 * 
	 * @param cond 资产配置信息检索条件
	 * @return 资产配置信息检索结果列表
	 */
	public List<SOC0129Info> searchConfigItemVW(SOC0129SearchCond cond){
		List<SOC0129Info> ret = soc0129DAO.findByCond(cond,0,0);
		return ret;
	}
	
	/**
	 * 根据检索条件取得资产配置信息列表
	 * 
	 * @param cond 资产配置信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产配置信息检索结果列表
	 */
	public List<SOC0129Info> searchConfigItemVW(SOC0129SearchCond cond, int start, int count){

		List<SOC0129Info> ret = soc0129DAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * 根据大版本获取资产最大小版本
	 * @param eiid 资产ID
	 * @param civersion 资产大版本号
	 * @return 最大小版本
	 */
	public Integer searchEiMaxSmallVersion(Integer eiid, Integer civersion) {
		return this.soc0107DAO.searchEiMaxSmallVersion(eiid, civersion);
	}

	public String getHostEiid(SOC0107SearchCondImpl cond) throws BLException {
		return this.soc0107DAO.getHostEiid(cond);
	}
	public List<SOC0107Info> getConfigItemByEid(SOC0107SearchCondImpl cond){
		return this.soc0107DAO.getConfigItemByEid(cond);
	}

	/**
	 * 根据检索条件取得资产配置信息结果条数
	 * 
	 * @param cond 资产配置信息检索条件
	 * @return 资产配置信息结果条数
	 */
	public int getSOC0606InfoSearchCount(SOC0606SearchCond cond){

		return soc0606DAO.getSearchCount(cond);
	}
	
	/**
	 * 根据检索条件取得资产配置信息列表
	 * 
	 * @param cond 资产配置信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产配置信息检索结果列表
	 */
	public List<SOC0606Info> searchSOC0606Info(SOC0606SearchCond cond, int start, int count){

		List<SOC0606Info> ret = soc0606DAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * 根据属性获取资产信息
	 * @param value 属性集合
	 * @return 资产信息集合
	 * @throws BLException
	 */
	public List<Integer> searchEiByCname(Map<String, String> value) throws BLException {
		return this.soc0107DAO.searchEiByCname(value);
	}
	
	/**
	 * 根据检索条件取得资产配置信息列表 常熟新资产专用
	 * 
	 * @param cond 资产配置信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产配置信息检索结果列表
	 */
	public List<SOC0129Info> searchConfigItemSoc0109VW(SOC0129SearchCond cond, int start, int count){

		List<SOC0129Info> ret = soc0129DAO.findByCondSoc0109(cond,start,count);
		return ret;
	}


	/**
	 * 根据资产id和config id 查询场景定义流程节点与节点参与人信息
	 * @param cid config id
	 * @param eiid 资产id
	 * @return
	 * @throws BLException
	 */
	public List<Map<String, Object>> searchProcessDefineUserByEiidInfo(String cid, Integer eiid) throws BLException {
		return soc0107DAO.searchProcessDefineUserByEiidInfo(cid,eiid);
	}
}
