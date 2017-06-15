/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.soc.asset.model.SOC0151VWInfo;
import com.deliverik.framework.soc.asset.model.condition.SOC0151SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0151VWSearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0151VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.dao.SOC0151VWDAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0151TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0151VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0151VWPK;
import com.deliverik.framework.utility.BLErrorType;

/**
  * 概述: SOC0151VW业务逻辑实现
  * 功能描述: SOC0151VW业务逻辑实现
  * 创建记录: 2016/06/23
  * 修改记录: 
  */
public class SOC0151VWBLImpl extends BaseBLImpl implements
		SOC0151VWBL {

	/** soc0151VWDAO接口 */
	protected SOC0151VWDAO soc0151VWDAO;
	
	

	/**
	 * @return the soc0151VWDAO
	 */
	public SOC0151VWDAO getSoc0151VWDAO() {
		return soc0151VWDAO;
	}

	/**
	 * @param soc0151vwdao the soc0151VWDAO to set
	 */
	public void setSoc0151VWDAO(SOC0151VWDAO soc0151vwdao) {
		soc0151VWDAO = soc0151vwdao;
	}

	/**
	 * SOC0151VW实例取得
	 *
	 * @return SOC0151VW实例
	 */
	public SOC0151VW getSOC0151VWInstance() {
		return new SOC0151VW();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0151VWInfo> searchSOC0151VW() {
		return soc0151VWDAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public SOC0151VWInfo searchSOC0151VWByPK(SOC0151VWPK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0151VWSearchCond cond) {
		return soc0151VWDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0151VWInfo> searchSOC0151VW(
			SOC0151VWSearchCond cond) {
		return soc0151VWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0151VWInfo> searchSOC0151VW(
			SOC0151VWSearchCond cond, int start,
			int count) {
		return soc0151VWDAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public SOC0151VWInfo registSOC0151VW(SOC0151VWInfo instance)
		throws BLException {
		return soc0151VWDAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public SOC0151VWInfo updateSOC0151VW(SOC0151VWInfo instance)
		throws BLException {
		checkExistInstance(new SOC0151VWPK(instance.getId(), instance.getCcdid()));
		return soc0151VWDAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteSOC0151VWByPK(SOC0151VWPK pk)
		throws BLException {
		soc0151VWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteSOC0151VW(SOC0151VWInfo instance)
		throws BLException {
		soc0151VWDAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public SOC0151VWInfo checkExistInstance(SOC0151VWPK pk)
		throws BLException {
		SOC0151VWInfo instance = soc0151VWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	/**
	 * 根据检索条件取得资产属性取值范围标识名称列表
	 * 
	 * @param cond 资产属性取值范围信息检索条件
	 * @return 资产属性取值范围标识名称检索结果列表
	 */
	public List<ConfigurationCodeDetailBean> searchConfigurationCodeDetailBean(SOC0151VWSearchCond cond){
		List<ConfigurationCodeDetailBean> ret = soc0151VWDAO.findConfigurationCodeDetailBean(cond);
		return ret;
	}
	
	/**
	 * 根据数据标识取得资产属性取值范围标签对象
	 * 
	 * @param ccdcategory 资产属性取值范围数据标识
	 * @return 资产属性取值范围标签对象检索结果列表
	 */
	public List<LabelValueBean> searchLabelValueBeanList(String ccdcategory , Integer id){
		SOC0151VWSearchCondImpl cond = new SOC0151VWSearchCondImpl();
		cond.setId(id);
		cond.setCcdcategory(ccdcategory);
		cond.setCcdstatus("1");
		List<SOC0151VWInfo> ret = this.searchConfigurationCodeDetail(cond, 0, 0);
		List<LabelValueBean> list = new ArrayList<LabelValueBean>();
		list.add(new LabelValueBean("", ""));
		for(SOC0151VWInfo ccd : ret){
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
	public SOC0151VWInfo registConfigurationCodeDetail(SOC0151VWInfo configurationCodeDetail) throws BLException{
		SOC0151VWInfo ret = soc0151VWDAO.save(configurationCodeDetail);
		return ret;
	}

	/**
	 * 删除资产属性取值范围数据信息处理
	 * 
	 * @param configurationCodeDetail 删除的资产属性取值范围数据信息数据
	 * @return
	 */
	public void deleteConfigurationCodeDetail(SOC0151VWInfo configurationCodeDetail) throws BLException {
		checkExistConfigurationCodeDetail(new SOC0151VWPK(configurationCodeDetail.getId(),configurationCodeDetail.getCcdid()));
		soc0151VWDAO.delete(configurationCodeDetail);
	}


	/**
	 * 根据检索条件取得资产属性取值范围数据信息结果条数
	 * 
	 * @param cond 资产属性取值范围数据信息检索条件
	 * @return 资产属性取值范围数据信息结果条数
	 */
	public int getConfigurationCodeDetailSearchCount(SOC0151VWSearchCond cond) {
		return soc0151VWDAO.getSearchCount(cond);
	}

	/**
	 * 根据检索条件取得资产属性取值范围数据信息列表
	 * 
	 * @param cond 资产属性取值范围数据信息检索条件
	 * @return 资产属性取值范围数据信息检索结果列表
	 */
	public List<SOC0151VWInfo> searchConfigurationCodeDetail(SOC0151VWSearchCond cond) {
		List<SOC0151VWInfo> ret = soc0151VWDAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * 根据资产属性取值范围数据信息主键取得资产属性取值范围数据信息
	 * 
	 * @param ccdid 资产属性取值范围数据信息主键
	 * @return 资产属性取值范围数据信息
	 * @throws BLException 
	 */
	public SOC0151VWInfo searchConfigurationCodeDetailByKey(Integer id , Integer ccdid) throws BLException {
		return checkExistConfigurationCodeDetail(new SOC0151VWPK(id, ccdid));
	}

	/**
	 * 变更资产属性取值范围数据信息处理
	 * 
	 * @param configurationCodeDetail 变更的资产属性取值范围数据信息数据
	 * @return 资产属性取值范围数据信息
	 */
	public SOC0151VWInfo updateConfigurationCodeDetail(SOC0151VWInfo configurationCodeDetail) throws BLException {
		checkExistConfigurationCodeDetail(new SOC0151VWPK(configurationCodeDetail.getId(),configurationCodeDetail.getCcdid()));
		SOC0151VWInfo ret = soc0151VWDAO.save(configurationCodeDetail);
		return ret;
	}

	
	/**
	 * 资产属性取值范围数据信息存在检查
	 * 
	 * @param ccdid 资产ID
	 * @return 资产属性取值范围数据信息
	 * @throws BLException 
	 */
	protected SOC0151VWInfo checkExistConfigurationCodeDetail(SOC0151VWPK pk) throws BLException{
		SOC0151VWInfo info = soc0151VWDAO.findByPK(pk);
		return info;
	}
	/**
	 * <p>
	 * 新的资产属性取值范围数据信息对象实例取得
	 * <p>
	 * 
	 * @return 新的资产属性取值范围数据信息对象实例取得
	 */

	public SOC0151VW getConfigurationCodeDetailTBInstance() {
		return new SOC0151VW();
	}

/**
 * 根据检索条件取得资产属性取值范围数据信息列表
 * 
 * @param cond 资产属性取值范围数据信息检索条件
 * @param start 检索记录起始条数
 * @param count 检索记录件数
 * @return 资产属性取值范围数据信息检索结果列表
 */
public List<SOC0151VWInfo> searchConfigurationCodeDetail(SOC0151VWSearchCond cond, int start, int count){
	List<SOC0151VWInfo> ret = soc0151VWDAO.findByCond(cond,start,count);
	return ret;
}
}