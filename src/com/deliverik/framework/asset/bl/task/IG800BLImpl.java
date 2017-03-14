package com.deliverik.framework.asset.bl.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.IG225Info;
import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.condition.IG002SearchCond;
import com.deliverik.framework.asset.model.condition.IG002SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG225SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.asset.model.condition.IG800SearchCondImpl;
import com.deliverik.framework.asset.model.dao.IG002DAO;
import com.deliverik.framework.asset.model.dao.IG225DAO;
import com.deliverik.framework.asset.model.dao.IG800DAO;
import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.asset.model.entity.IG800TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * 资产属性业务逻辑实现
 * 
 */
public class IG800BLImpl extends BaseBLImpl implements IG800BL {

	/** ConfigItem DAO */
	protected IG800DAO ig800DAO;
	
	/** ig002 DAO */
	protected IG002DAO ig002DAO;
	
	/** Ig225 DAO */
	protected IG225DAO ig225DAO;
	
	
	protected IG013BL ig013BL;
	
	public void setIg013BL(IG013BL ig013BL) {
		this.ig013BL = ig013BL;
	}

	public void setIg225DAO(IG225DAO ig225DAO) {
		this.ig225DAO = ig225DAO;
	}

	public void setIg800DAO(IG800DAO ig800DAO) {
		this.ig800DAO = ig800DAO;
	}

	public void setIg002DAO(IG002DAO ig002DAO) {
		this.ig002DAO = ig002DAO;
	}
	
	/**
	 * <p>
	 * 新的资产属性信息对象实例取得
	 * <p>
	 * 
	 * @return 新的资产属性信息对象实例取得
	 */

	public IG800TB getIG800TBInstance() {
		return new IG800TB();
	}

	/**
	 * 根据资产属性信息主键取得资产属性信息
	 * 
	 * @param ciid 资产属性信息主键
	 * @return 资产属性信息
	 * @throws BLException 
	 */
	public IG800Info searchIG800InfoByKey(Integer ciid) throws BLException{
		return checkExistConfigItem(ciid);
	}

	/**
	 * 根据检索条件取得资产属性信息列表（平台保留，请使用searchConfigItemVW方法进行检索）
	 * 
	 * @param cond 资产属性信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产属性信息检索结果列表
	 */
	public List<IG800Info> searchIG800Info(IG800SearchCond cond, int start, int count){
		List<IG800Info> ret = ig800DAO.findByCond(cond,0,0);
		return ret;
	}
	
	/**
	 * 根据检索条件取得资产属性信息列表（平台保留，请使用searchConfigItemVW方法进行检索）
	 * 
	 * @param cond 资产属性信息检索条件
	 * @return 资产属性信息检索结果列表
	 */
	public List<IG800Info> searchIG800Info(IG800SearchCond cond) {
		List<IG800Info> ret = ig800DAO.findByCond(cond,0,0);
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
	public List<IG800Info> searchIG800InfoHistoryByEiid(Integer eiid, Integer civersion, Integer cismallversion, String cname) throws BLException {
		//取得资产id为eiid的资产的版本号
		IG013Info entityItem = ig013BL.searchIG013InfoByKey(eiid);
		if(entityItem==null){
			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS,
					"IGCO10000.E003","资产");
		}

		List<IG800Info> itemlist = new ArrayList<IG800Info>();		
		if(StringUtils.isNotEmpty(cname)){
			//取得属性名称中包含cname值的属性集合
			IG225SearchCondImpl cond = new IG225SearchCondImpl();
			cond.setCname(cname);
			List<IG225Info> list = ig225DAO.findByCond(cond, 0, 0);
			for(IG225Info config:list){
				List<IG800Info> ret = new ArrayList<IG800Info>(); 
				IG800SearchCondImpl cond1 = new IG800SearchCondImpl();
				if(civersion==null){
					//检索所有版本的属性信息
					cond1.setEiid(eiid);
					cond1.setCid(config.getCid());
					ret = ig800DAO.findByCond(cond1,0,0);
				}else if(civersion==-1){
					//检索最新版本的属性信息
					cond1.setEiid(eiid);
					cond1.setCid(config.getCid());
					cond1.setCiversion(String.valueOf(entityItem.getEiversion()));
					cond1.setCismallversion(entityItem.getEismallversion().toString());
					ret = ig800DAO.findByCond(cond1,0,0);
				}else{
					//根据传入的版本号检索对应版本的属性信息
					cond1.setEiid(eiid);
					cond1.setCid(config.getCid());
					cond1.setCiversion(String.valueOf(civersion));
					cond1.setCismallversion(cismallversion.toString());
					ret = ig800DAO.findByCond(cond1,0,0);
				}
				
				itemlist.addAll(ret);
			}
		}else{
			List<IG800Info> ret = new ArrayList<IG800Info>(); 
			IG800SearchCondImpl cond1 = new IG800SearchCondImpl();
			if(civersion==null){
				//检索所有版本的属性信息
				cond1.setEiid(eiid);
				ret = ig800DAO.findByCond(cond1,0,0);
			}else if(civersion==-1){
				//检索最新版本的属性信息
				cond1.setEiid(eiid);
				cond1.setCiversion(String.valueOf(entityItem.getEiversion()));
				ret = ig800DAO.findByCond(cond1,0,0);
			}else{
				//根据传入的版本号检索对应版本的属性信息
				cond1.setEiid(eiid);
				cond1.setCiversion(String.valueOf(civersion));
				ret = ig800DAO.findByCond(cond1,0,0);
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
	 * @param ig800Info 资产属性信息
	 * @return 保存后的资产属性信息
	 */
	public void saveIG800Info(int currentEiversion, IG800Info ig800Info) throws BLException {
		//校验
		if(ig800Info == null) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","资产属性基本");
		} else if(ig800Info.getEiid() == null || ig800Info.getEiid() <= 0){
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","资产基本");
		} else if(ig800Info.getCid() == null || ig800Info.getCid() <= 0){
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","资产模型属性基本");
		}
		//查询所属资产
		IG013Info entityItem = ig013BL.searchIG013InfoByKey(ig800Info.getEiid());
		
		if(currentEiversion != entityItem.getEiversion()) {
			throw new BLException("IGCO00000.E004");
		}
		
		//查询资产属性
		IG002SearchCondImpl cond = new IG002SearchCondImpl();
		cond.setEiid(entityItem.getEiid());
		List<IG002Info> ciList = searchIG002Info(cond);
		//最新版本
		int version = entityItem.getEiversion() + 1;
		//修改时间
		String ciupdtime = IGStringUtils.getCurrentDateTime();
		//新增资产属性信息
		for(IG002Info ci : ciList) {
			IG800TB configItemTB = new IG800TB();
			//资产ID
			configItemTB.setEiid(Integer.parseInt(ci.getEiid()));
			//模型属性ID
			configItemTB.setCid(Integer.parseInt(ci.getCid()));
			//模型ID
			configItemTB.setEid(Integer.parseInt(ci.getEid()));
			//模型层次码
			configItemTB.setEsyscoding(ci.getEsyscoding());
			//版本号
			configItemTB.setCiversion(version);
			//更新时间
			configItemTB.setCiupdtime(ciupdtime);
			//如属性ID相等则替换属性值
			if(ci.getCid().equals(ig800Info.getCid().toString())) {
				configItemTB.setCivalue(ig800Info.getCivalue());
			} else {
				configItemTB.setCivalue(ci.getCivalue());
			}
			ig800DAO.save(configItemTB);
		}
		
		//修改资产基本信息
		IG013TB entityItemTB = (IG013TB)SerializationUtils.clone(entityItem);
		
		entityItemTB.setEiversion(version);
		
		entityItemTB.setEiupdtime(ciupdtime);
		
		ig013BL.updateIG013Info(entityItemTB);
		
	}
	
	/**
	 * 保存同一资产多个属性信息处理，其他属性统一提升一个版本<br>
	 * ConfigItem实现类对象设置cid和civalue值即可
	 * 
	 * @param eiid 资产ID
	 * @param currentEiversion 当前资产版本号(更新前)
	 * @param ig800InfoList 保存的资产属性信息数据集合
	 */
	public void saveIG800Info(Integer eiid, int currentEiversion, List<IG800Info> ig800InfoList) throws BLException {
		if(eiid == null || eiid <= 0){
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","资产基本");
		} else if(ig800InfoList == null || ig800InfoList.size() == 0) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","资产属性基本");
		}
		//查询所属资产
		IG013Info entityItem = ig013BL.searchIG013InfoByKey(eiid);
		
		if(currentEiversion != entityItem.getEiversion()) {
			throw new BLException("IGCO00000.E004");
		}
		
		//最新版本
		int version = entityItem.getEiversion() + 1;
		//修改时间
		String ciupdtime = IGStringUtils.getCurrentDateTime();
		//查询资产属性
		IG002SearchCondImpl cond = new IG002SearchCondImpl();
		cond.setEiid(eiid);
		List<IG002Info> ciList = searchIG002Info(cond);
		//新增资产属性信息
		for(IG002Info ci : ciList) {
			IG800TB configItemTB = new IG800TB();
			//资产ID
			configItemTB.setEiid(Integer.parseInt(ci.getEiid()));
			//模型属性ID
			configItemTB.setCid(Integer.parseInt(ci.getCid()));
			//模型ID
			configItemTB.setEid(Integer.parseInt(ci.getEid()));
			//模型层次码
			configItemTB.setEsyscoding(ci.getEsyscoding());
			//版本号
			configItemTB.setCiversion(version);
			//更新时间
			configItemTB.setCiupdtime(ciupdtime);
			
			configItemTB.setCivalue(ci.getCivalue());
			
			for(IG800Info configItem : ig800InfoList) {
				//校验
				if(configItem.getCid() == null || configItem.getCid() <= 0){
					throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
							"IGCO10000.E004","资产模型属性基本");
				}
				//如属性ID相等则替换属性值
				if(ci.getCid().equals(configItem.getCid().toString())) {
					configItemTB.setCivalue(configItem.getCivalue());
					continue;
				}
			}
			ig800DAO.save(configItemTB);
		}
		
		//修改资产基本信息
		IG013TB entityItemTB = (IG013TB)SerializationUtils.clone(entityItem);
		
		entityItemTB.setEiversion(version);
		
		entityItemTB.setEiupdtime(ciupdtime);
		
		ig013BL.updateIG013Info(entityItemTB);
		
	}
	
	
	/**
	 * 保存资产属性信息处理（平台保留）
	 * 
	 * @param ig800Info 保存的资产属性信息数据
	 * @return 资产属性信息
	 */
	public IG800Info registIG800Info(IG800Info ig800Info) throws BLException {
		IG800Info ret = ig800DAO.save(ig800Info);
		return ret;
	}

	/**
	 * 根据检索条件取得资产属性信息结果条数（平台保留，请使用getConfigItemVWSearchCount方法进行检索）
	 * 
	 * @param cond 资产属性信息检索条件
	 * @return 资产属性信息结果条数
	 */
	public int getIG800InfoSearchCount(IG800SearchCond cond) {
		return ig800DAO.getSearchCount(cond);
	}

	

	/**
	 * 变更资产属性信息处理（平台保留）
	 * 
	 * @param ig800Info 变更的资产属性信息数据
	 * @return 资产属性信息
	 */
	public IG800Info updateIG800Info(IG800Info ig800Info) throws BLException {
		checkExistConfigItem(ig800Info.getCiid());
		IG800Info ret = ig800DAO.save(ig800Info);
		return ret;
	}
	
	/**
	 * 资产属性信息存在检查
	 * 
	 * @param ciid 资产属性ID
	 * @return 资产属性信息
	 * @throws BLException 
	 */
	protected IG800Info checkExistConfigItem(Integer ciid) throws BLException{//必须有
		IG800Info info = ig800DAO.findByPK(ciid);
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
	public int getIG002InfoSearchCount(IG002SearchCond cond){

		return ig002DAO.getSearchCount(cond);
	}

	/**
	 * 根据检索条件取得资产配置信息列表
	 * 
	 * @param cond 资产配置信息检索条件
	 * @return 资产配置信息检索结果列表
	 */
	public List<IG002Info> searchIG002Info(IG002SearchCond cond){
		List<IG002Info> ret = ig002DAO.findByCond(cond,0,0);
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
	public List<IG002Info> searchIG002Info(IG002SearchCond cond, int start, int count){

		List<IG002Info> ret = ig002DAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * 登记初始化时根据检索条件取得资产配置信息列表
	 * 
	 * @param cond 资产配置信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产配置信息检索结果列表
	 */
	public List<IG002Info> initSearchIG002Info(IG002SearchCond cond, int start, int count){
		
		List<IG002Info> ret = ig002DAO.initFindByCond(cond);
		return ret;
	}
	
	/**
	 * 根据大版本获取资产最大小版本
	 * @param eiid 资产ID
	 * @param civersion 资产大版本号
	 * @return 最大小版本
	 */
	public Integer searchEiMaxSmallVersion(Integer eiid, Integer civersion) {
		return this.ig800DAO.searchEiMaxSmallVersion(eiid, civersion);
	}

	/**
	 * 根据属性获取资产信息
	 * @param value 属性集合
	 * @return 资产信息集合
	 * @throws BLException
	 */
	public List<Integer> searchEiByCname(Map<String, String> value) throws BLException {
		return this.ig800DAO.searchEiByCname(value);
	}
}
