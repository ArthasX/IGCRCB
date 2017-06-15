package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.soc.asset.bl.task.ConfigurationCodeDetailBL;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetail;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.condition.ConfigurationCodeDetailSearchCond;
import com.deliverik.framework.soc.asset.model.condition.ConfigurationCodeDetailSearchCondImpl;
import com.deliverik.framework.soc.asset.model.dao.ConfigurationCodeDetailDAO;
import com.deliverik.framework.soc.asset.model.entity.ConfigurationCodeDetailTB;
import com.deliverik.framework.utility.BLErrorType;

/**
 * 资产属性取值范围数据业务逻辑实现
 * 
 */
public class ConfigurationCodeDetailBLImpl extends BaseBLImpl implements ConfigurationCodeDetailBL {

	/** ConfigurationCodeDetail DAO */
	protected ConfigurationCodeDetailDAO configurationCodeDetailDAO;

	public void setConfigurationCodeDetailDAO(ConfigurationCodeDetailDAO configurationCodeDetailDAO) {
		this.configurationCodeDetailDAO = configurationCodeDetailDAO;
	}
	
	/**
	 * <p>
	 * 新的资产属性取值范围数据信息对象实例取得
	 * <p>
	 * 
	 * @return 新的资产属性取值范围数据信息对象实例取得
	 */

	public ConfigurationCodeDetailTB getConfigurationCodeDetailTBInstance() {
		return new ConfigurationCodeDetailTB();
	}

	/**
	 * 根据检索条件取得资产属性取值范围数据信息列表
	 * 
	 * @param cond 资产属性取值范围数据信息检索条件
	 * @param start 检索记录起始条数
	 * @param count 检索记录件数
	 * @return 资产属性取值范围数据信息检索结果列表
	 */
	public List<ConfigurationCodeDetail> searchConfigurationCodeDetail(ConfigurationCodeDetailSearchCond cond, int start, int count){
		List<ConfigurationCodeDetail> ret = configurationCodeDetailDAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * 根据检索条件取得资产属性取值范围标识名称列表
	 * 
	 * @param cond 资产属性取值范围信息检索条件
	 * @return 资产属性取值范围标识名称检索结果列表
	 */
	public List<ConfigurationCodeDetailBean> searchConfigurationCodeDetailBean(ConfigurationCodeDetailSearchCond cond){
		List<ConfigurationCodeDetailBean> ret = configurationCodeDetailDAO.findConfigurationCodeDetailBean(cond);
		return ret;
	}
	
	/**
	 * 根据数据标识取得资产属性取值范围标签对象
	 * 
	 * @param ccdcategory 资产属性取值范围数据标识
	 * @return 资产属性取值范围标签对象检索结果列表
	 */
	public List<LabelValueBean> searchLabelValueBeanList(String ccdcategory){
		ConfigurationCodeDetailSearchCondImpl cond = new ConfigurationCodeDetailSearchCondImpl();
		cond.setCcdcategory(ccdcategory);
		cond.setCcdstatus("1");
		List<ConfigurationCodeDetail> ret = this.searchConfigurationCodeDetail(cond, 0, 0);
		List<LabelValueBean> list = new ArrayList<LabelValueBean>();
		list.add(new LabelValueBean("", ""));
		for(ConfigurationCodeDetail ccd : ret){
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
	public ConfigurationCodeDetail registConfigurationCodeDetail(ConfigurationCodeDetail configurationCodeDetail) throws BLException{
		ConfigurationCodeDetail ret = configurationCodeDetailDAO.save(configurationCodeDetail);
		return ret;
	}

	/**
	 * 删除资产属性取值范围数据信息处理
	 * 
	 * @param configurationCodeDetail 删除的资产属性取值范围数据信息数据
	 * @return
	 */
	public void deleteConfigurationCodeDetail(ConfigurationCodeDetail configurationCodeDetail) throws BLException {
		checkExistConfigurationCodeDetail(configurationCodeDetail.getCcdid());
		configurationCodeDetailDAO.delete(configurationCodeDetail);
	}

	/**
	 * 根据资产属性取值范围数据信息主键删除资产属性取值范围数据信息处理
	 * 
	 * @param ccdid 删除资产属性取值范围数据信息的主键
	 * @return
	 */
	public void deleteConfigurationCodeDetailByKey(Integer ccdid) throws BLException {
		ConfigurationCodeDetail configurationCodeDetail = checkExistConfigurationCodeDetail(ccdid);
		configurationCodeDetailDAO.delete(configurationCodeDetail);
	}

	/**
	 * 根据检索条件取得资产属性取值范围数据信息结果条数
	 * 
	 * @param cond 资产属性取值范围数据信息检索条件
	 * @return 资产属性取值范围数据信息结果条数
	 */
	public int getConfigurationCodeDetailSearchCount(ConfigurationCodeDetailSearchCond cond) {
		return configurationCodeDetailDAO.getSearchCount(cond);
	}

	/**
	 * 根据检索条件取得资产属性取值范围数据信息列表
	 * 
	 * @param cond 资产属性取值范围数据信息检索条件
	 * @return 资产属性取值范围数据信息检索结果列表
	 */
	public List<ConfigurationCodeDetail> searchConfigurationCodeDetail(ConfigurationCodeDetailSearchCond cond) {
		List<ConfigurationCodeDetail> ret = configurationCodeDetailDAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * 根据资产属性取值范围数据信息主键取得资产属性取值范围数据信息
	 * 
	 * @param ccdid 资产属性取值范围数据信息主键
	 * @return 资产属性取值范围数据信息
	 * @throws BLException 
	 */
	public ConfigurationCodeDetail searchConfigurationCodeDetailByKey(Integer ccdid) throws BLException {
		return checkExistConfigurationCodeDetail(ccdid);
	}

	/**
	 * 变更资产属性取值范围数据信息处理
	 * 
	 * @param configurationCodeDetail 变更的资产属性取值范围数据信息数据
	 * @return 资产属性取值范围数据信息
	 */
	public ConfigurationCodeDetail updateConfigurationCodeDetail(ConfigurationCodeDetail configurationCodeDetail) throws BLException {
		checkExistConfigurationCodeDetail(configurationCodeDetail.getCcdid());
		ConfigurationCodeDetail ret = configurationCodeDetailDAO.save(configurationCodeDetail);
		return ret;
	}

	/**
	 * 根据资产属性取值范围信息数据标识取得资产属性取值范围信息
	 * 
	 * @param ccdcategory 资产属性取值范围数据标识
	 * @return 资产属性取值范围信息
	 */
	public ConfigurationCodeDetail searchConfigurationCodeDetailByKey(String ccdcategory) {
		ConfigurationCodeDetail ret = configurationCodeDetailDAO.findByPK(ccdcategory);
		return ret;
	}
	
	/**
	 * 资产属性取值范围数据信息存在检查
	 * 
	 * @param ccdid 资产ID
	 * @return 资产属性取值范围数据信息
	 * @throws BLException 
	 */
	protected ConfigurationCodeDetail checkExistConfigurationCodeDetail(Integer ccdid) throws BLException{
		ConfigurationCodeDetail info = configurationCodeDetailDAO.findByPK(ccdid);
		if(info == null) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","资产属性取值范围数据基本");
		}
		return info;
	}
}
