package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0107VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0109VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107VWSearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0107VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0109VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0107VWDAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0109VWDAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0129DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0107VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0107VWPK;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VWPK;
import com.deliverik.framework.utility.BLErrorType;

/**
 * 资产属性业务逻辑实现
 * 
 */
public class SOC0107VWBLImpl extends BaseBLImpl implements SOC0107VWBL {

	/** ConfigItem DAO */
	protected SOC0107VWDAO soc0107VWDAO;
	
	/** Configuration DAO */
	protected SOC0109VWDAO soc0109VWDAO;
	
	protected SOC0118VWBL soc0118VWBL;

	protected SOC0129DAO soc0129DAO;
   

	/**
	 * @param soc0129dao the soc0129DAO to set
	 */
	public void setSoc0129DAO(SOC0129DAO soc0129dao) {
		soc0129DAO = soc0129dao;
	}

	/**
	 * @param soc0107vwdao the soc0107VWDAO to set
	 */
	public void setSoc0107VWDAO(SOC0107VWDAO soc0107vwdao) {
		soc0107VWDAO = soc0107vwdao;
	}

	/**
	 * @param soc0109vwdao the soc0109VWDAO to set
	 */
	public void setSoc0109VWDAO(SOC0109VWDAO soc0109vwdao) {
		soc0109VWDAO = soc0109vwdao;
	}

	/**
	 * @param soc0118vwbl the soc0118VWBL to set
	 */
	public void setSoc0118VWBL(SOC0118VWBL soc0118vwbl) {
		soc0118VWBL = soc0118vwbl;
	}

	/**
	 * <p>
	 * 新的资产属性信息对象实例取得
	 * <p>
	 * 
	 * @return 新的资产属性信息对象实例取得
	 */

	public SOC0107VW getSOC0107VWInstance() {
		return new SOC0107VW();
	}

	/**
	 * 根据资产属性信息主键取得资产属性信息
	 * 
	 * @param ciid 资产属性信息主键
	 * @return 资产属性信息
	 * @throws BLException 
	 */
	public SOC0107VWInfo searchSOC0107VWByKey(SOC0107VWPK pk) throws BLException{
		return checkExistSOC0107VW(pk);
	}

	/**
	 * 根据检索条件取得资产属性信息列表（平台保留，请使用searchConfigItemVW方法进行检索）
	 * 
	 * @param cond 资产属性信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产属性信息检索结果列表
	 */
	public List<SOC0107VWInfo> searchSOC0107VW(SOC0107VWSearchCond cond, int start, int count){
		List<SOC0107VWInfo> ret = soc0107VWDAO.findByCond(cond,0,0);
		return ret;
	}
	
	/**
	 * 根据检索条件取得资产属性信息列表（平台保留，请使用searchConfigItemVW方法进行检索）
	 * 
	 * @param cond 资产属性信息检索条件
	 * @return 资产属性信息检索结果列表
	 */
	public List<SOC0107VWInfo> searchSOC0107VW(SOC0107VWSearchCond cond) {
		List<SOC0107VWInfo> ret = soc0107VWDAO.findByCond(cond,0,0);
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
	public List<SOC0107VWInfo> searchSOC0107VWHistoryByEiid(Integer eiid, Integer civersion, Integer cismallversion, String cname) throws BLException {
		//取得资产id为eiid的资产的版本号
//		SOC0118VWInfo entityItem = soc0118VWBL.searchEntityItemByKey(new SOC0118VWPK(1, eiid));
//		if(entityItem==null){
//			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS,
//					"IGCO10000.E003","资产");
//		}

		List<SOC0107VWInfo> itemlist = new ArrayList<SOC0107VWInfo>();		
//		if(StringUtils.isNotEmpty(cname)){
//			//取得属性名称中包含cname值的属性集合
//			SOC0109SearchCondImpl cond = new SOC0109SearchCondImpl();
//			cond.setCname(cname);
//			List<SOC0109Info> list = soc0109VWDAO.findByCond(cond, 0, 0);
//			for(SOC0109Info config:list){
//				List<SOC0107VWInfo> ret = new ArrayList<SOC0107VWInfo>(); 
//				SOC0107VWSearchCondImpl cond1 = new SOC0107VWSearchCondImpl();
//				if(civersion==null){
//					//检索所有版本的属性信息
//					cond1.setEiid(eiid.toString());
//					cond1.setCid(config.getCid());
//					ret = soc0107VWDAO.findByCond(cond1,0,0);
//				}else if(civersion==-1){
//					//检索最新版本的属性信息
//					cond1.setEiid(eiid.toString());
//					cond1.setCid(config.getCid());
//					cond1.setCiversion(String.valueOf(entityItem.getEiversion()));
//					cond1.setCismallversion(entityItem.getEismallversion().toString());
//					ret = soc0107VWDAO.findByCond(cond1,0,0);
//				}else{
//					//根据传入的版本号检索对应版本的属性信息
//					cond1.setEiid(eiid.toString());
//					cond1.setCid(config.getCid());
//					cond1.setCiversion(String.valueOf(civersion));
//					cond1.setCismallversion(cismallversion.toString());
//					ret = soc0107VWDAO.findByCond(cond1,0,0);
//				}
//				
//				itemlist.addAll(ret);
//			}
//		}else{
//			List<SOC0107VWInfo> ret = new ArrayList<SOC0107VWInfo>(); 
//			SOC0107VWSearchCondImpl cond1 = new SOC0107VWSearchCondImpl();
//			if(civersion==null){
//				//检索所有版本的属性信息
//				cond1.setEiid(eiid.toString());
//				ret = soc0107VWDAO.findByCond(cond1,0,0);
//			}else if(civersion==-1){
//				//检索最新版本的属性信息
//				cond1.setEiid(eiid.toString());
//				cond1.setCiversion(String.valueOf(entityItem.getEiversion()));
//				ret = soc0107VWDAO.findByCond(cond1,0,0);
//			}else{
//				//根据传入的版本号检索对应版本的属性信息
//				cond1.setEiid(eiid.toString());
//				cond1.setCiversion(String.valueOf(civersion));
//				ret = soc0107VWDAO.findByCond(cond1,0,0);
//			}
			
//			itemlist.addAll(ret);
//		}
		

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
//	public List<SOC0107VWInfo> searchSOC0107VWHistoryByEiid(Integer eiid, Integer civersion, String cname) throws BLException {
//		//取得资产id为eiid的资产的版本号
//		SOC0118VWInfo entityItem = soc0118VWBL.searchEntityItemByKey(eiid);
//		if(entityItem==null){
//			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS,
//					"IGCO10000.E003","资产");
//		}
//
//		List<SOC0107VWInfo> itemlist = new ArrayList<SOC0107VWInfo>();		
//		if(StringUtils.isNotEmpty(cname)){
//			//取得属性名称中包含cname值的属性集合
//			SOC0109SearchCondImpl cond = new SOC0109SearchCondImpl();
//			cond.setCname(cname);
//			List<SOC0109Info> list = soc0109VWDAO.findByCond(cond, 0, 0);
//			for(SOC0109Info config:list){
//				List<SOC0107VWInfo> ret = new ArrayList<SOC0107VWInfo>(); 
//				SOC0107VWSearchCondImpl cond1 = new SOC0107VWSearchCondImpl();
//				if(civersion==null){
//					//检索所有版本的属性信息
//					cond1.setEiid(String.valueOf(eiid));
//					cond1.setCid(config.getCid());
//					ret = soc0107VWDAO.findByCond(cond1,0,0);
//				}else if(civersion==-1){
//					//检索最新版本的属性信息
//					cond1.setEiid(String.valueOf(eiid));
//					cond1.setCid(config.getCid());
//					cond1.setCiversion(String.valueOf(entityItem.getEiversion()));
//					ret = soc0107VWDAO.findByCond(cond1,0,0);
//				}else{
//					//根据传入的版本号检索对应版本的属性信息
//					cond1.setEiid(String.valueOf(eiid));
//					cond1.setCid(config.getCid());
//					cond1.setCiversion(String.valueOf(civersion));
//					ret = soc0107VWDAO.findByCond(cond1,0,0);
//				}
//				
//				itemlist.addAll(ret);
//			}
//		}else{
//			List<SOC0107VWInfo> ret = new ArrayList<SOC0107VWInfo>(); 
//			SOC0107VWSearchCondImpl cond1 = new SOC0107VWSearchCondImpl();
//			if(civersion==null){
//				//检索所有版本的属性信息
//				cond1.setEiid(String.valueOf(eiid));
//				ret = soc0107VWDAO.findByCond(cond1,0,0);
//			}else if(civersion==-1){
//				//检索最新版本的属性信息
//				cond1.setEiid(String.valueOf(eiid));
//				cond1.setCiversion(String.valueOf(entityItem.getEiversion()));
//				ret = soc0107VWDAO.findByCond(cond1,0,0);
//			}else{
//				//根据传入的版本号检索对应版本的属性信息
//				cond1.setEiid(String.valueOf(eiid));
//				cond1.setCiversion(String.valueOf(civersion));
//				ret = soc0107VWDAO.findByCond(cond1,0,0);
//			}
//			
//			itemlist.addAll(ret);
//		}
//		
//
//		return itemlist;
//	}
	
	/**
	 * 保存资产属性信息处理，其他属性统一提升一个版本<br>
	 * ConfigItem实现类对象设置eiid,cid和civalue值即可
	 * 
	 * @param currentEiversion 当前资产版本号(更新前)
	 * @param configItem 资产属性信息
	 * @return 保存后的资产属性信息
	 */
//	public void saveSOC0107VW(int currentEiversion, SOC0107VWInfo SOC0107VWInfo) throws BLException {
//		//校验
//		if(SOC0107VWInfo == null) {
//			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
//					"IGCO10000.E004","资产属性基本");
//		} else if(SOC0107VWInfo.getEiid() == null || SOC0107VWInfo.getEiid() <= 0){
//			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
//					"IGCO10000.E004","资产基本");
//		} else if(SOC0107VWInfo.getCid() == null || SOC0107VWInfo.getCid() == ""){
//			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
//					"IGCO10000.E004","资产模型属性基本");
//		}
//		//查询所属资产
//		SOC0118VWInfo entityItem = soc0118VWBL.searchEntityItemByKey(SOC0107VWInfo.getEiid());
//		
//		if(currentEiversion != Integer.parseInt(entityItem.getEiversion())) {
//			throw new BLException("IGCO00000.E004");
//		}
//		
//		//查询资产属性
//		SOC0129SearchCondImpl cond = new SOC0129SearchCondImpl();
//		cond.setEiid(entityItem.getEiid().toString());
////		List<SOC0129Info> ciList = searchConfigItemVW(cond);
//		//最新版本
//		int version = Integer.parseInt(entityItem.getEiversion()) + 1;
//		//修改时间
//		String ciupdtime = IGStringUtils.getCurrentDateTime();
//		//新增资产属性信息
////		for(SOC0129Info ci : ciList) {
////			SOC0107VW configItemTB = new SOC0107VW();
////			//资产ID
////			configItemTB.setEiid(Integer.parseInt(ci.getEiid()));
////			//模型属性ID
////			configItemTB.setCid(ci.getCid());
////			//模型ID
////			configItemTB.setEid(ci.getEid());
////			//模型层次码
////			configItemTB.setEsyscoding(ci.getEsyscoding());
////			//版本号
////			configItemTB.setCiversion(version+"");
////			//更新时间
////			configItemTB.setCiupdtime(ciupdtime);
////			//如属性ID相等则替换属性值
////			if(ci.getCid().equals(SOC0107VWInfo.getCid().toString())) {
////				configItemTB.setCivalue(SOC0107VWInfo.getCivalue());
////			} else {
////				configItemTB.setCivalue(ci.getCivalue());
////			}
////			soc0107VWDAO.save(configItemTB);
////		}
//		
//		//修改资产基本信息
//		SOC0118VW entityItemTB = (SOC0118VW)SerializationUtils.clone(entityItem);
//		
//		entityItemTB.setEiversion(version+"");
//		
//		entityItemTB.setEiupdtime(ciupdtime);
//		
//		soc0118VWBL.updateEntityItem(entityItemTB);
//		
//	}
	
	/**
	 * 保存同一资产多个属性信息处理，其他属性统一提升一个版本<br>
	 * ConfigItem实现类对象设置cid和civalue值即可
	 * 
	 * @param eiid 资产ID
	 * @param currentEiversion 当前资产版本号(更新前)
	 * @param configItemList 保存的资产属性信息数据集合
	 */
//	public void saveSOC0107VW(Integer eiid, int currentEiversion, List<SOC0107VWInfo> SOC0107VWInfoList) throws BLException {
//		if(eiid == null || eiid <= 0){
//			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
//					"IGCO10000.E004","资产基本");
//		} else if(SOC0107VWInfoList == null || SOC0107VWInfoList.size() == 0) {
//			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
//					"IGCO10000.E004","资产属性基本");
//		}
//		//查询所属资产
//		SOC0118VWInfo entityItem = soc0118VWBL.searchEntityItemByKey(eiid);
//		
//		if(currentEiversion != Integer.parseInt(entityItem.getEiversion())) {
//			throw new BLException("IGCO00000.E004");
//		}
//		
//		//最新版本
//		int version = Integer.parseInt(entityItem.getEiversion()) + 1;
//		//修改时间
//		String ciupdtime = IGStringUtils.getCurrentDateTime();
//		//查询资产属性
//		SOC0129SearchCondImpl cond = new SOC0129SearchCondImpl();
//		cond.setEiid(eiid.toString());
//		//2014年8.29添加-为采购流程
//		cond.setEsyscoding_q(entityItem.getEsyscoding());
////		List<SOC0129Info> ciList = searchConfigItemVW(cond);
//		//新增资产属性信息
////		for(SOC0129Info ci : ciList) {
////			SOC0107VW configItemTB = new SOC0107VW();
////			//资产ID
////			configItemTB.setEiid(Integer.parseInt(ci.getEiid()));
////			//模型属性ID
////			configItemTB.setCid(ci.getCid());
////			//模型ID
////			configItemTB.setEid(ci.getEid());
////			//模型层次码
////			configItemTB.setEsyscoding(ci.getEsyscoding());
////			//版本号
////			configItemTB.setCiversion(version+"");
////			//更新时间
////			configItemTB.setCiupdtime(ciupdtime);
////			
////			configItemTB.setCivalue(ci.getCivalue());
////			
////			for(SOC0107VWInfo SOC0107VWInfo : SOC0107VWInfoList) {
////				//校验
////				if(SOC0107VWInfo.getCid() == null || SOC0107VWInfo.getCid() == ""){
////					throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
////							"IGCO10000.E004","资产模型属性基本");
////				}
////				//如属性ID相等则替换属性值
////				if(ci.getCid().equals(SOC0107VWInfo.getCid().toString())) {
////					configItemTB.setCivalue(SOC0107VWInfo.getCivalue());
////					continue;
////				}
////			}
////			soc0107VWDAO.save(configItemTB);
////		}
//		
//		//修改资产基本信息
//		SOC0118VW entityItemTB = (SOC0118VW)SerializationUtils.clone(entityItem);
//		
//		entityItemTB.setEiversion(version+"");
//		
//		entityItemTB.setEiupdtime(ciupdtime);
//		
//		soc0118VWBL.updateEntityItem(entityItemTB);
//		
//	}
	
	
	/**
	 * 保存资产属性信息处理（平台保留）
	 * 
	 * @param configItem 保存的资产属性信息数据
	 * @return 资产属性信息
	 */
	public SOC0107VWInfo registSOC0107VW(SOC0107VWInfo configItem) throws BLException {
		SOC0107VWInfo ret = soc0107VWDAO.save(configItem);
		return ret;
	}

	/**
	 * 根据检索条件取得资产属性信息结果条数（平台保留，请使用getConfigItemVWSearchCount方法进行检索）
	 * 
	 * @param cond 资产属性信息检索条件
	 * @return 资产属性信息结果条数
	 */
	public int getSOC0107VWSearchCount(SOC0107VWSearchCond cond) {
		return soc0107VWDAO.getSearchCount(cond);
	}

	

	/**
	 * 变更资产属性信息处理（平台保留）
	 * 
	 * @param configItem 变更的资产属性信息数据
	 * @return 资产属性信息
	 */
//	public SOC0107VWInfo updateSOC0107VW(SOC0107VWInfo SOC0107VWInfo) throws BLException {
//		checkExistSOC0107VW(SOC0107VWInfo.getCiid());
//		SOC0107VWInfo ret = soc0107VWDAO.save(SOC0107VWInfo);
//		return ret;
//	}
	
	/**
	 * 资产属性信息存在检查
	 * 
	 * @param ciid 资产属性ID
	 * @return 资产属性信息
	 * @throws BLException 
	 */
	protected SOC0107VWInfo checkExistSOC0107VW(SOC0107VWPK pk) throws BLException{//必须有
		SOC0107VWInfo info = soc0107VWDAO.findByPK(pk);
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
		return this.soc0107VWDAO.searchEiMaxSmallVersion(eiid, civersion);
	}

	public String getHostEiid(SOC0107VWSearchCondImpl cond) throws BLException {
		return this.soc0107VWDAO.getHostEiid(cond);
	}
	public List<SOC0107VWInfo> getConfigItemByEid(SOC0107VWSearchCondImpl cond){
		return this.soc0107VWDAO.getConfigItemByEid(cond);
	}

	/**
	 * 根据检索条件取得资产配置信息结果条数
	 * 
	 * @param cond 资产配置信息检索条件
	 * @return 资产配置信息结果条数
	 */
//	public int getSOC0606InfoSearchCount(SOC0606SearchCond cond){
//
//		return soc0606DAO.getSearchCount(cond);
//	}
	
	/**
	 * 根据检索条件取得资产配置信息列表
	 * 
	 * @param cond 资产配置信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产配置信息检索结果列表
	 */
//	public List<SOC0606Info> searchSOC0606Info(SOC0606SearchCond cond, int start, int count){
//
//		List<SOC0606Info> ret = soc0606DAO.findByCond(cond,start,count);
//		return ret;
//	}
	
	/**
	 * 根据属性获取资产信息
	 * @param value 属性集合
	 * @return 资产信息集合
	 * @throws BLException
	 */
	public List<Integer> searchEiByCname(Map<String, String> value) throws BLException {
		return this.soc0107VWDAO.searchEiByCname(value);
	}

	/**
	 * 根据检索条件取得资产属性信息列表
	 * 
	 * @param id 资产ID
	 * @param eiid 资产ID
	 * @param civersion 资产属性大版本号 
	 * 			<br>civersion:null检索资产属性所有版本的属性信息。
	 * 			<br>civersion:-1检索资产属性最新版本的属性信息。
	 * 			<br>civersion:其他值检索资产属性对应版本的属性信息。
	 * @param cismallversion 资产属性小版本号
	 * @param cname 资产属性名称(模糊查询条件)
	 * @return 资产属性信息检索结果列表
	 */
	public List<SOC0107VWInfo> searchSOC0107VWHistoryByEiid(Integer id ,Integer eiid, Integer civersion, Integer cismallversion, String cname) throws BLException {
		//取得资产id为eiid的资产的版本号
		SOC0118VWInfo entityItem = soc0118VWBL.searchEntityItemByKey(new SOC0118VWPK(id, eiid));
		if(entityItem==null){
			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS,
					"IGCO10000.E003","资产");
		}
		
		List<SOC0107VWInfo> itemlist = new ArrayList<SOC0107VWInfo>();		
		if(StringUtils.isNotEmpty(cname)){
			//取得属性名称中包含cname值的属性集合
			SOC0109VWSearchCondImpl cond = new SOC0109VWSearchCondImpl();
			cond.setId(id);
			cond.setCname(cname);
			List<SOC0109VWInfo> list = soc0109VWDAO.findByCond(cond, 0, 0);
			for(SOC0109VWInfo config:list){
				List<SOC0107VWInfo> ret = new ArrayList<SOC0107VWInfo>(); 
				SOC0107VWSearchCondImpl cond1 = new SOC0107VWSearchCondImpl();
				cond1.setId(id);
				if(civersion==null){
					//检索所有版本的属性信息
					cond1.setEiid(eiid.toString());
					cond1.setCid(config.getCid());
					ret = soc0107VWDAO.findByCond(cond1,0,0);
				}else if(civersion==-1){
					//检索最新版本的属性信息
					cond1.setEiid(eiid.toString());
					cond1.setCid(config.getCid());
					cond1.setCiversion(entityItem.getEiversion());
					cond1.setCismallversion(entityItem.getEismallversion().toString());
					ret = soc0107VWDAO.findByCond(cond1,0,0);
				}else{
					//根据传入的版本号检索对应版本的属性信息
					cond1.setEiid(eiid.toString());
					cond1.setCid(config.getCid());
					cond1.setCiversion(String.valueOf(civersion));
					cond1.setCismallversion(cismallversion.toString());
					ret = soc0107VWDAO.findByCond(cond1,0,0);
				}
				
				itemlist.addAll(ret);
			}
		}else{
			List<SOC0107VWInfo> ret = new ArrayList<SOC0107VWInfo>(); 
			SOC0107VWSearchCondImpl cond1 = new SOC0107VWSearchCondImpl();
			cond1.setId(id);
			if(civersion==null){
				//检索所有版本的属性信息
				cond1.setEiid(eiid.toString());
				ret = soc0107VWDAO.findByCond(cond1,0,0);
			}else if(civersion==-1){
				//检索最新版本的属性信息
				cond1.setEiid(eiid.toString());
				cond1.setCiversion(entityItem.getEiversion());
				ret = soc0107VWDAO.findByCond(cond1,0,0);
			}else{
				//根据传入的版本号检索对应版本的属性信息
				cond1.setEiid(eiid.toString());
				cond1.setCiversion(String.valueOf(civersion));
				ret = soc0107VWDAO.findByCond(cond1,0,0);
			}
			
			itemlist.addAll(ret);
		}
		
		
		return itemlist;
	}

//	public void saveSOC0107VW(int currentEiversion, SOC0107VWInfo SOC0107VWInfo)
//			throws BLException {
//		// TODO Auto-generated method stub
//		
//	}

//	public void saveSOC0107VW(Integer eiid, int currentEiversion,
//			List<SOC0107VWInfo> SOC0107VWInfoList) throws BLException {
//		// TODO Auto-generated method stub
//		
//	}

//	public SOC0107VWInfo updateSOC0107VW(SOC0107VWInfo SOC0107VWInfo)
//			throws BLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	/**
	 * 根据检索条件取得资产配置信息列表 常熟新资产专用
	 * 
	 * @param cond 资产配置信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产配置信息检索结果列表
	 */
//	public List<SOC0129Info> searchConfigItemSoc0109VW(SOC0129SearchCond cond, int start, int count){
//
//		List<SOC0129Info> ret = soc0129DAO.findByCondSoc0109(cond,start,count);
//		return ret;
//	}
}
