package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.soc.asset.bl.task.SOC0151BL;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.condition.SOC0151SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0151SearchCondImpl;
import com.deliverik.framework.soc.asset.model.dao.SOC0151DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0151TB;
import com.deliverik.framework.utility.BLErrorType;

/**
 * 资产属性取值范围数据业务逻辑实现
 * 
 */
public class SOC0151BLImpl extends BaseBLImpl implements SOC0151BL {

	/** ConfigurationCodeDetail DAO */
	protected SOC0151DAO soc0151DAO;

	
	public void setSoc0151DAO(SOC0151DAO soc0151DAO) {
		this.soc0151DAO = soc0151DAO;
	}

	/**
	 * <p>
	 * 新的资产属性取值范围数据信息对象实例取得
	 * <p>
	 * 
	 * @return 新的资产属性取值范围数据信息对象实例取得
	 */

	public SOC0151TB getConfigurationCodeDetailTBInstance() {
		return new SOC0151TB();
	}

	/**
	 * 根据检索条件取得资产属性取值范围数据信息列表
	 * 
	 * @param cond 资产属性取值范围数据信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产属性取值范围数据信息检索结果列表
	 */
	public List<SOC0151Info> searchConfigurationCodeDetail(SOC0151SearchCond cond, int start, int count){
		List<SOC0151Info> ret = soc0151DAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * 根据检索条件取得资产属性取值范围标识名称列表
	 * 
	 * @param cond 资产属性取值范围信息检索条件
	 * @return 资产属性取值范围标识名称检索结果列表
	 */
	public List<ConfigurationCodeDetailBean> searchConfigurationCodeDetailBean(SOC0151SearchCond cond){
		List<ConfigurationCodeDetailBean> ret = soc0151DAO.findConfigurationCodeDetailBean(cond);
		return ret;
	}
	
	/**
	 * 根据数据标识取得资产属性取值范围标签对象
	 * 
	 * @param ccdcategory 资产属性取值范围数据标识
	 * @return 资产属性取值范围标签对象检索结果列表
	 */
	public List<LabelValueBean> searchLabelValueBeanList(String ccdcategory){
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		cond.setCcdcategory(ccdcategory);
		cond.setCcdstatus("1");
		List<SOC0151Info> ret = this.searchConfigurationCodeDetail(cond, 0, 0);
		List<LabelValueBean> list = new ArrayList<LabelValueBean>();
		list.add(new LabelValueBean("", ""));
		for(SOC0151Info ccd : ret){
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
	public SOC0151Info registConfigurationCodeDetail(SOC0151Info configurationCodeDetail) throws BLException{
		SOC0151Info ret = soc0151DAO.save(configurationCodeDetail);
		return ret;
	}

	/**
	 * 删除资产属性取值范围数据信息处理
	 * 
	 * @param configurationCodeDetail 删除的资产属性取值范围数据信息数据
	 * @return
	 */
	public void deleteConfigurationCodeDetail(SOC0151Info configurationCodeDetail) throws BLException {
		checkExistConfigurationCodeDetail(configurationCodeDetail.getCcdid());
		soc0151DAO.delete(configurationCodeDetail);
	}

	/**
	 * 根据资产属性取值范围数据信息主键删除资产属性取值范围数据信息处理
	 * 
	 * @param ccdid 删除资产属性取值范围数据信息的主键
	 * @return
	 */
	public void deleteConfigurationCodeDetailByKey(Integer ccdid) throws BLException {
		SOC0151Info configurationCodeDetail = checkExistConfigurationCodeDetail(ccdid);
		soc0151DAO.delete(configurationCodeDetail);
	}

	/**
	 * 根据检索条件取得资产属性取值范围数据信息结果条数
	 * 
	 * @param cond 资产属性取值范围数据信息检索条件
	 * @return 资产属性取值范围数据信息结果条数
	 */
	public int getConfigurationCodeDetailSearchCount(SOC0151SearchCond cond) {
		return soc0151DAO.getSearchCount(cond);
	}

	/**
	 * 根据检索条件取得资产属性取值范围数据信息列表
	 * 
	 * @param cond 资产属性取值范围数据信息检索条件
	 * @return 资产属性取值范围数据信息检索结果列表
	 */
	public List<SOC0151Info> searchConfigurationCodeDetail(SOC0151SearchCond cond) {
		List<SOC0151Info> ret = soc0151DAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * 根据资产属性取值范围数据信息主键取得资产属性取值范围数据信息
	 * 
	 * @param ccdid 资产属性取值范围数据信息主键
	 * @return 资产属性取值范围数据信息
	 * @throws BLException 
	 */
	public SOC0151Info searchConfigurationCodeDetailByKey(Integer ccdid) throws BLException {
		return checkExistConfigurationCodeDetail(ccdid);
	}

	/**
	 * 变更资产属性取值范围数据信息处理
	 * 
	 * @param configurationCodeDetail 变更的资产属性取值范围数据信息数据
	 * @return 资产属性取值范围数据信息
	 */
	public SOC0151Info updateConfigurationCodeDetail(SOC0151Info configurationCodeDetail) throws BLException {
		checkExistConfigurationCodeDetail(configurationCodeDetail.getCcdid());
		SOC0151Info ret = soc0151DAO.save(configurationCodeDetail);
		return ret;
	}

	/**
	 * 根据资产属性取值范围信息数据标识取得资产属性取值范围信息
	 * 
	 * @param ccdcategory 资产属性取值范围数据标识
	 * @return 资产属性取值范围信息
	 */
	public SOC0151Info searchConfigurationCodeDetailByKey(String ccdcategory) {
		SOC0151Info ret = soc0151DAO.findByPK(ccdcategory);
		return ret;
	}
	
	/**
	 * 资产属性取值范围数据信息存在检查
	 * 
	 * @param ccdid 资产ID
	 * @return 资产属性取值范围数据信息
	 * @throws BLException 
	 */
	protected SOC0151Info checkExistConfigurationCodeDetail(Integer ccdid) throws BLException{
		SOC0151Info info = soc0151DAO.findByPK(ccdid);
		if(info == null) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","资产属性取值范围数据基本");
		}
		return info;
	}
}
