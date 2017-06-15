package com.deliverik.framework.asset.bl.task;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;

import com.deliverik.framework.asset.EntityItemKeyWords;
import com.deliverik.framework.asset.model.IG778Info;
import com.deliverik.framework.asset.model.IG225Info;
import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.condition.IG778SearchCond;
import com.deliverik.framework.asset.model.condition.IG225SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG117SearchCondImpl;
import com.deliverik.framework.asset.model.dao.IG778DAO;
import com.deliverik.framework.asset.model.dao.IG800DAO;
import com.deliverik.framework.asset.model.dao.IG225DAO;
import com.deliverik.framework.asset.model.dao.IG117DAO;
import com.deliverik.framework.asset.model.dao.IG013DAO;
import com.deliverik.framework.asset.model.entity.IG800TB;
import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;



/**
 * 机柜业务逻辑实现
 * 
 */
public class IG778BLImpl extends BaseBLImpl implements IG778BL {

	/** ComputerContainerVW DAO */
	protected IG778DAO ig778DAO;
	
	/** EntityItem DAO */
	protected IG013DAO ig013BLDAO;
	
	/** Ig225 DAO */
	protected IG225DAO ig225DAO;
	
	/** ConfigItemDAO */
	protected IG800DAO ig800DAO;
	
	/** Entity DAO */
	protected IG117DAO ig117DAO;

	public void setIg778DAO(IG778DAO ig778DAO) {
		this.ig778DAO = ig778DAO;
	}
	
	public void setIg013DAO(IG013DAO ig013BLDAO) {
		this.ig013BLDAO = ig013BLDAO;
	}
	
	public void setIg225DAO(IG225DAO ig225DAO) {
		this.ig225DAO = ig225DAO;
	}
	
	public void setIg800DAO(IG800DAO ig800DAO) {
		this.ig800DAO = ig800DAO;
	}
	
	public void setIg117DAO(IG117DAO ig117DAO) {
		this.ig117DAO = ig117DAO;
	}

	/**
	 * 根据机房信息主键取得机房信息
	 * 
	 * @param eiid 机房ID
	 * @return 机房信息
	 */
	public IG778Info searchIG778InfoByKey(Integer eiid){

		IG778Info ret = ig778DAO.findByPK(eiid);
		return ret;
	}
	
	/**
	 * 根据检索条件取得机房信息结果条数
	 * 
	 * @param cond 机房信息检索条件
	 * @return 机房信息结果条数
	 */
	public int getIG778InfoSearchCount(IG778SearchCond cond){

		return ig778DAO.getSearchCount(cond);
	}

	/**
	 * 根据检索条件取得机房信息列表
	 * 
	 * @param cond 机房信息检索条件
	 * @return 机房信息检索结果列表
	 */
	public List<IG778Info> searchIG778Info(IG778SearchCond cond){
		
		List<IG778Info> ret = ig778DAO.findByCond(cond,0,0);
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
	public List<IG778Info> searchIG778Info(IG778SearchCond cond, int start, int count){
		
		List<IG778Info> ret = ig778DAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * 保存机柜信息处理
	 * 
	 * @param ig778Info 机柜信息
	 * @return 保存生成的机柜ID
	 * @throws BLException
	 */
	public Integer registIG778Info(IG778Info ig778Info) throws BLException{
		//机柜基本信息生成
		IG013TB entityItemTB = new IG013TB();
		
		//机柜模型ID取得
		IG117SearchCondImpl cond = new IG117SearchCondImpl();
		cond.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER);
		
		//登记处理前的机柜信息确认
		List<IG117Info> entityList = ig117DAO.findByCond(cond, 0, 0);
		
		if ( entityList == null || entityList.size() ==0 ) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","机柜模型基本");
		}
		
		IG117Info entity = entityList.get(0);
		entityItemTB.setEid(entity.getEid());
		entityItemTB.setEiname(ig778Info.getEiname());
		entityItemTB.setEilabel(ig778Info.getEilabel());
		entityItemTB.setEidesc(ig778Info.getEidesc());
		entityItemTB.setEiversion(1);
		entityItemTB.setEiinsdate(IGStringUtils.getCurrentDate());
		entityItemTB.setEiupdtime(IGStringUtils.getCurrentDateTime());
		entityItemTB.setEsyscoding("999007");
		IG013Info entityItem = ig013BLDAO.save(entityItemTB);
		//机柜位置（X）属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_VALUE,
				ig778Info.getX_value(),"机柜","机柜位置（X）",1);
		
		//机柜位置（Y）属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_VALUE,
				ig778Info.getY_value(),"机柜","机柜位置（Y）",1);
		
		//机柜高度（U）属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_U_TOTAL,
				ig778Info.getU_total(),"机柜","机柜高度（U）",1);
		
		//机柜横向宽属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_WIDTH,
				ig778Info.getX_width(),"机柜","机柜横向宽",1);

		//机柜纵向宽属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_WIDTH,
				ig778Info.getY_width(),"机柜","机柜纵向宽",1);
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
	protected void insertConfigItem(IG013Info entityItem,
			String clabel,String civalue,String sErrParam0,String sErrParam1,
			Integer civersion) throws BLException {
		//1.查询条件生成
		IG225SearchCondImpl configCond = new IG225SearchCondImpl();
		configCond.setClabel(clabel);
		
		//2.属性查询
		List<IG225Info> configList = ig225DAO.findByCond(configCond, 0, 0);
		
		if ( configList == null || configList.size()==0 ) {
			throw new BLException("IGCO10000.E013",sErrParam0,sErrParam1);
		}
		
		//2.属性内容生成
		IG800TB configItemTB = new IG800TB();
		
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
		ig800DAO.save(configItemTB);
		
	}

	/**
	 * 删除机柜信息处理
	 * 
	 * @param ig778Info 删除的机柜信息
	 * @return
	 * @throws BLException
	 */
	public void deleteIG778Info(IG778Info ig778Info) throws BLException{
		IG013Info ret = checkExistComputerContainer( ig778Info.getEiid());
		ig013BLDAO.delete(ret);
	}

	/**
	 * 根据机柜主键删除机柜信息处理
	 * 
	 * @param eiid 删除机柜信息的主键
	 * @return
	 * @throws BLException
	 */
	public void deleteIG778InfoByKey(Integer eiid) throws BLException{
		IG013Info ret = checkExistComputerContainer(eiid);
		ig013BLDAO.delete(ret);
	}

	/**
	 * 变更机柜信息处理
	 * 
	 * @param ig778Info 变更前的机柜信息
	 * @throws BLException
	 */
	public void updateIG778Info(IG778Info ig778Info) throws BLException{
		IG013Info entityItem = checkExistComputerContainer(ig778Info.getEiid());
		
		//机柜基本信息生成
		IG013TB entityItemTB = (IG013TB)SerializationUtils.clone(entityItem);
		int cur_version = entityItem.getEiversion() + 1;
		entityItemTB.setEiname(ig778Info.getEiname());
		entityItemTB.setEilabel(ig778Info.getEilabel());
		entityItemTB.setEidesc(ig778Info.getEidesc());
		entityItemTB.setEiversion(cur_version);
		entityItemTB.setEiupdtime(IGStringUtils.getCurrentDateTime());
		ig013BLDAO.save(entityItemTB);
		//机柜高属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_U_TOTAL,
				ig778Info.getU_total(),"机柜","机柜高",cur_version);
		
		//机柜位置（X）属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_VALUE,
				ig778Info.getX_value(),"机柜","机柜位置（X）",cur_version);
		
		//负责人属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_VALUE,
				ig778Info.getY_value(),"机柜","机柜位置（Y）",cur_version);
		
		//机柜横向宽属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_WIDTH,
				ig778Info.getX_width(),"机柜","机柜横向宽",cur_version);
		
		//机柜纵向宽属性生成
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_WIDTH,
				ig778Info.getY_width(),"机柜","机柜纵向宽",cur_version);
		
	}
	
	/**
	 * 机柜信息存在检查
	 * 
	 * @param eiid 机柜ID
	 * @return 机柜基本信息
	 * @throws BLException 
	 */
	protected  IG013Info checkExistComputerContainer(Integer eiid) throws BLException{
		IG013Info info = ig013BLDAO.findByPK(eiid);
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
	public List<IG778Info> searchUpsAndAirIG778Info(IG778SearchCond cond) {
		return ig778DAO.findByIG778Info(cond);
	}


	
}
