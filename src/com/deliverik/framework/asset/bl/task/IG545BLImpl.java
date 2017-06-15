package com.deliverik.framework.asset.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG545Info;
import com.deliverik.framework.asset.model.IG545Bean;
import com.deliverik.framework.asset.model.condition.IG545SearchCond;
import com.deliverik.framework.asset.model.condition.IG545SearchCondImpl;
import com.deliverik.framework.asset.model.dao.IG545DAO;
import com.deliverik.framework.asset.model.entity.IG545TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.BLErrorType;

/**
 * 资产属性取值范围数据业务逻辑实现
 * 
 */
public class IG545BLImpl extends BaseBLImpl implements IG545BL {

	/** ig545 DAO */
	protected IG545DAO ig545DAO;

	public void setIg545DAO(IG545DAO ig545DAO) {
		this.ig545DAO = ig545DAO;
	}
	
	/**
	 * <p>
	 * 新的资产属性取值范围数据信息对象实例取得
	 * <p>
	 * 
	 * @return 新的资产属性取值范围数据信息对象实例取得
	 */

	public IG545TB getIG545TBInstance() {
		return new IG545TB();
	}

	/**
	 * 根据检索条件取得资产属性取值范围数据信息列表
	 * 
	 * @param cond 资产属性取值范围数据信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产属性取值范围数据信息检索结果列表
	 */
	public List<IG545Info> searchIG545Info(IG545SearchCond cond, int start, int count){
		List<IG545Info> ret = ig545DAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * 根据检索条件取得资产属性取值范围标识名称列表
	 * 
	 * @param cond 资产属性取值范围信息检索条件
	 * @return 资产属性取值范围标识名称检索结果列表
	 */
	public List<IG545Bean> searchIG545Bean(IG545SearchCond cond){
		List<IG545Bean> ret = ig545DAO.findIG545Bean(cond);
		return ret;
	}
	
	/**
	 * 根据数据标识取得资产属性取值范围标签对象
	 * 
	 * @param ccdcategory 资产属性取值范围数据标识
	 * @return 资产属性取值范围标签对象检索结果列表
	 */
	public List<LabelValueBean> searchLabelValueBeanList(String ccdcategory){
		IG545SearchCondImpl cond = new IG545SearchCondImpl();
		cond.setCcdcategory(ccdcategory);
		cond.setCcdstatus("1");
		List<IG545Info> ret = this.searchIG545Info(cond, 0, 0);
		List<LabelValueBean> list = new ArrayList<LabelValueBean>();
		list.add(new LabelValueBean("", ""));
		for(IG545Info ccd : ret){
			list.add(new LabelValueBean(ccd.getCcdvalue(), ccd.getCcdvalue()));
		}
		return list;
	}
	
	/**
	 * 保存资产属性取值范围数据信息处理
	 * 
	 * @param configurationCodeDetail 保存的资产属性取值范围数据信息数据
	 * @return 资产属性取值范围数据信息
	 */
	public IG545Info registIG545Info(IG545Info configurationCodeDetail) throws BLException{
		IG545Info ret = ig545DAO.save(configurationCodeDetail);
		return ret;
	}

	/**
	 * 删除资产属性取值范围数据信息处理
	 * 
	 * @param ig545Info 删除的资产属性取值范围数据信息数据
	 * @return
	 */
	public void deleteIG545Info(IG545Info ig545Info) throws BLException {
		checkExistConfigurationCodeDetail(ig545Info.getCcdid());
		ig545DAO.delete(ig545Info);
	}

	/**
	 * 根据资产属性取值范围数据信息主键删除资产属性取值范围数据信息处理
	 * 
	 * @param ccdid 删除资产属性取值范围数据信息的主键
	 * @return
	 */
	public void deleteIG545InfoByKey(Integer ccdid) throws BLException {
		IG545Info configurationCodeDetail = checkExistConfigurationCodeDetail(ccdid);
		ig545DAO.delete(configurationCodeDetail);
	}

	/**
	 * 根据检索条件取得资产属性取值范围数据信息结果条数
	 * 
	 * @param cond 资产属性取值范围数据信息检索条件
	 * @return 资产属性取值范围数据信息结果条数
	 */
	public int getIG545InfoSearchCount(IG545SearchCond cond) {
		return ig545DAO.getSearchCount(cond);
	}

	/**
	 * 根据检索条件取得资产属性取值范围数据信息列表
	 * 
	 * @param cond 资产属性取值范围数据信息检索条件
	 * @return 资产属性取值范围数据信息检索结果列表
	 */
	public List<IG545Info> searchIG545Info(IG545SearchCond cond) {
		List<IG545Info> ret = ig545DAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * 根据资产属性取值范围数据信息主键取得资产属性取值范围数据信息
	 * 
	 * @param ccdid 资产属性取值范围数据信息主键
	 * @return 资产属性取值范围数据信息
	 * @throws BLException 
	 */
	public IG545Info searchIG545InfoByKey(Integer ccdid) throws BLException {
		return checkExistConfigurationCodeDetail(ccdid);
	}

	/**
	 * 变更资产属性取值范围数据信息处理
	 * 
	 * @param ig545Info 变更的资产属性取值范围数据信息数据
	 * @return 资产属性取值范围数据信息
	 */
	public IG545Info updateIG545Info(IG545Info ig545Info) throws BLException {
		checkExistConfigurationCodeDetail(ig545Info.getCcdid());
		IG545Info ret = ig545DAO.save(ig545Info);
		return ret;
	}

	/**
	 * 根据资产属性取值范围信息数据标识取得资产属性取值范围信息
	 * 
	 * @param ccdcategory 资产属性取值范围数据标识
	 * @return 资产属性取值范围信息
	 */
	public IG545Info searchIG545InfoByKey(String ccdcategory) {
		IG545Info ret = ig545DAO.findByPK(ccdcategory);
		return ret;
	}
	
	/**
	 * 资产属性取值范围数据信息存在检查
	 * 
	 * @param ccdid 资产ID
	 * @return 资产属性取值范围数据信息
	 * @throws BLException 
	 */
	protected IG545Info checkExistConfigurationCodeDetail(Integer ccdid) throws BLException{
		IG545Info info = ig545DAO.findByPK(ccdid);
		if(info == null) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","资产属性取值范围数据基本");
		}
		return info;
	}
}
