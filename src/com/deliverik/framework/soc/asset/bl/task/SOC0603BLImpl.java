/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;

import com.deliverik.framework.asset.EntityItemKeyWords;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;

import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0603Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0603SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0118DAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0603DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.soc.asset.model.dao.SOC0109DAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0107DAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0117DAO;


/**
 * 机柜业务逻辑实现
 * 
 */
public class SOC0603BLImpl extends BaseBLImpl implements SOC0603BL {

	/** ComputerContainerVW DAO */
	protected SOC0603DAO soc0603DAO;
	
	/** EntityItem DAO */
	protected SOC0118DAO soc0118DAO;
	
	/** SOC0109 DAO */
	protected SOC0109DAO soc0109DAO;
	
	/** ConfigItemDAO */
	protected SOC0107DAO soc0107DAO;
	
	/** Entity DAO */
	protected SOC0117DAO soc0117DAO;

	public void setSOC0603DAO(SOC0603DAO soc0603DAO) {
		this.soc0603DAO = soc0603DAO;
	}
	

	public void setSoc0603DAO(SOC0603DAO soc0603dao) {
		soc0603DAO = soc0603dao;
	}


	public void setSoc0118DAO(SOC0118DAO soc0118dao) {
		soc0118DAO = soc0118dao;
	}


	public void setSoc0109DAO(SOC0109DAO soc0109dao) {
		soc0109DAO = soc0109dao;
	}


	public void setSoc0107DAO(SOC0107DAO soc0107dao) {
		soc0107DAO = soc0107dao;
	}


	public void setSoc0117DAO(SOC0117DAO soc0117dao) {
		soc0117DAO = soc0117dao;
	}


	/**
	 * 根据机房信息主键取得机房信息
	 * 
	 * @param eiid 机房ID
	 * @return 机房信息
	 */
	public SOC0603Info searchSOC0603InfoByKey(String eiid){

		SOC0603Info ret = soc0603DAO.findByPK(Integer.parseInt(eiid));
		return ret;
	}
	
	/**
	 * 根据检索条件取得机房信息结果条数
	 * 
	 * @param cond 机房信息检索条件
	 * @return 机房信息结果条数
	 */
	public int getSOC0603InfoSearchCount(SOC0603SearchCond cond){

		return soc0603DAO.getSearchCount(cond);
	}

	/**
	 * 根据检索条件取得机房信息列表
	 * 
	 * @param cond 机房信息检索条件
	 * @return 机房信息检索结果列表
	 */
	public List<SOC0603Info> searchSOC0603Info(SOC0603SearchCond cond){
		
		List<SOC0603Info> ret = soc0603DAO.findByCond(cond,0,0);
		return ret;
	}
	
	/**
	 * 根据检索条件取得机房信息列表
	 * 
	 * @param cond 机房信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 机房信息检索结果列表
	 */
	public List<SOC0603Info> searchSOC0603Info(SOC0603SearchCond cond, int start, int count){
		
		List<SOC0603Info> ret = soc0603DAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * 保存机柜信息处理
	 * 
	 * @param SOC0603Info 机柜信息
	 * @return 保存生成的机柜ID
	 * @throws BLException
	 */
	public Integer registSOC0603Info(SOC0603Info SOC0603Info) throws BLException{
		//机柜基本信息生成
		SOC0118TB entityItemTB = new SOC0118TB();
		
		//机柜模型ID取得
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER);
		
		//登记处理前的机柜信息确认
		List<SOC0117Info> entityList = soc0117DAO.findByCond(cond, 0, 0);
		
		if ( entityList == null || entityList.size() ==0 ) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","机柜模型基本");
		}
		
		SOC0117Info entity = entityList.get(0);
		entityItemTB.setEid(entity.getEid());
		entityItemTB.setEiname(SOC0603Info.getEiname());
		entityItemTB.setEilabel(SOC0603Info.getEilabel());
		entityItemTB.setEidesc(SOC0603Info.getEidesc());
		entityItemTB.setEiversion(1);
		entityItemTB.setEiinsdate(IGStringUtils.getCurrentDate());
		entityItemTB.setEiupdtime(IGStringUtils.getCurrentDateTime());
		entityItemTB.setEsyscoding("999007");
		SOC0118Info entityItem = soc0118DAO.save(entityItemTB);
		//机柜位置（X）属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_VALUE,
				SOC0603Info.getX_value(),"机柜","机柜位置（X）",1);
		
		//机柜位置（Y）属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_VALUE,
				SOC0603Info.getY_value(),"机柜","机柜位置（Y）",1);
		
		//机柜高度（U）属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_U_TOTAL,
				SOC0603Info.getU_total(),"机柜","机柜高度（U）",1);
		
		//机柜横向宽属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_WIDTH,
				SOC0603Info.getX_width(),"机柜","机柜横向宽",1);

		//机柜纵向宽属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_WIDTH,
				SOC0603Info.getY_width(),"机柜","机柜纵向宽",1);
		return entityItem.getEiid();
	}
	
	/**
	 * 属性信息添加处理
	 *
	 * @param entityItem EntityItem 资产
	 * @param clabel String 属性编号
	 * @param civalue String 属性值
	 * @param sErrParam0 String 错误信息参数0
	 * @param sErrParam1 String 错误信息参数1 
	 * @param civersion Integer 属性版本
	 * @return
	 */
	protected void insertConfigItem(SOC0118Info entityItem,
			String clabel,String civalue,String sErrParam0,String sErrParam1,
			Integer civersion) throws BLException {
		//1.查询条件生成
		SOC0109SearchCondImpl configCond = new SOC0109SearchCondImpl();
		configCond.setClabel(clabel);
		
		//2.属性查询
		List<SOC0109Info> configList = soc0109DAO.findByCond(configCond, 0, 0);
		
		if ( configList == null || configList.size()==0 ) {
			throw new BLException("IGCO10000.E013",sErrParam0,sErrParam1);
		}
		
		//2.属性内容生成
		SOC0107TB configItemTB = new SOC0107TB();
		
		//资产ID
		configItemTB.setEiid(entityItem.getEiid());
		//资产模型ID
		configItemTB.setEid(entityItem.getEid());
		//资产属性ID
		configItemTB.setCid(configList.get(0).getCid());
		//资产属性值
		configItemTB.setCivalue(civalue);
		
		//资产属性版本
		configItemTB.setCiversion(civersion);
		
		//资产属性更新时间
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		configItemTB.setCiupdtime(datetime);
		
		//3.属性信息登记
		soc0107DAO.save(configItemTB);
		
	}

	/**
	 * 删除机柜信息处理
	 * 
	 * @param SOC0603Info 删除的机柜信息
	 * @return
	 * @throws BLException
	 */
	public void deleteSOC0603Info(SOC0603Info SOC0603Info) throws BLException{
		SOC0118Info ret = checkExistComputerContainer(SOC0603Info.getEiid());
		soc0118DAO.delete(ret);
	}

	/**
	 * 根据机柜主键删除机柜信息处理
	 * 
	 * @param eiid 删除机柜信息的主键
	 * @return
	 * @throws BLException
	 */
	public void deleteSOC0603InfoByKey(Integer eiid) throws BLException{
		SOC0118Info ret = checkExistComputerContainer(eiid);
		soc0118DAO.delete(ret);
	}

	/**
	 * 变更机柜信息处理
	 * 
	 * @param SOC0603Info 变更前的机柜信息
	 * @throws BLException
	 */
	public void updateSOC0603Info(SOC0603Info SOC0603Info) throws BLException{
		SOC0118Info entityItem = checkExistComputerContainer(SOC0603Info.getEiid());
		
		//机柜基本信息生成
		SOC0118TB entityItemTB = (SOC0118TB)SerializationUtils.clone(entityItem);
		int cur_version = entityItem.getEiversion() + 1;
		entityItemTB.setEiname(SOC0603Info.getEiname());
		entityItemTB.setEilabel(SOC0603Info.getEilabel());
		entityItemTB.setEidesc(SOC0603Info.getEidesc());
		entityItemTB.setEiversion(cur_version);
		entityItemTB.setEiupdtime(IGStringUtils.getCurrentDateTime());
		soc0118DAO.save(entityItemTB);
		//机柜高属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_U_TOTAL,
				SOC0603Info.getU_total(),"机柜","机柜高",cur_version);
		
		//机柜位置（X）属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_VALUE,
				SOC0603Info.getX_value(),"机柜","机柜位置（X）",cur_version);
		
		//负责人属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_VALUE,
				SOC0603Info.getY_value(),"机柜","机柜位置（Y）",cur_version);
		
		//机柜横向宽属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_WIDTH,
				SOC0603Info.getX_width(),"机柜","机柜横向宽",cur_version);
		
		//机柜纵向宽属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_WIDTH,
				SOC0603Info.getY_width(),"机柜","机柜纵向宽",cur_version);
		
	}
	
	/**
	 * 机柜信息存在检查
	 * 
	 * @param eiid 机柜ID
	 * @return 机柜基本信息
	 * @throws BLException 
	 */
	protected  SOC0118Info checkExistComputerContainer(Integer eiid) throws BLException{
		SOC0118Info info = soc0118DAO.findByPK(eiid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","机柜");
		}
		
		return info;
	}

	/**
	 * 条件检索处理：检索空调和UPS
	 * 
	 * @param cond
	 * @return
	 */
	public List<SOC0603Info> searchUpsAndAirSOC0603Info(SOC0603SearchCond cond) {
		return soc0603DAO.findBySOC0603Info(cond);
	}
}
