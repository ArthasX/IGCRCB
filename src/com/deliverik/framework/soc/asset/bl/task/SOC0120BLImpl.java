/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0120Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0120SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0120SearchCondImpl;
import com.deliverik.framework.soc.asset.model.dao.SOC0120DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0120PK;
import com.deliverik.framework.soc.asset.model.entity.SOC0120TB;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.IniReader;

/**
  * 概述: 导入数据版本管理表业务逻辑实现
  * 功能描述: 导入数据版本管理表业务逻辑实现
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public class SOC0120BLImpl extends BaseBLImpl implements
		SOC0120BL {
	
	static Log log = LogFactory.getLog(SOC0120BLImpl.class);

	
	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.asset.asmResources"); 

	/** 导入数据版本管理表DAO接口 */
	protected SOC0120DAO soc0120DAO;
	

	/**
	 * 导入数据版本管理表DAO接口设定
	 *
	 * @param soc0120DAO 导入数据版本管理表DAO接口
	 */
	public void setSoc0120DAO(SOC0120DAO soc0120DAO) {
		this.soc0120DAO = soc0120DAO;
	}

	/**
	 * 导入数据版本管理表实例取得
	 *
	 * @return 导入数据版本管理表实例
	 */
	public SOC0120TB getImportVersionTBInstance() {
		return new SOC0120TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<SOC0120Info> searchImportVersion() {
		return soc0120DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk主键
	 * @return 检索结果
	 */
	public SOC0120Info searchImportVersionByPK(Serializable pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0120SearchCond cond) {
		return soc0120DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0120Info> searchImportVersion(
			SOC0120SearchCond cond) {
		return soc0120DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0120Info> searchImportVersion(
			SOC0120SearchCond cond, int start,
			int count) {
		return soc0120DAO.findByCond(cond, start, count);
	}
	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0120Info> searchImportVersionAutoCollect(
			SOC0120SearchCond cond, int start,
			int count) {
		return soc0120DAO.findByCondAutoCollect(cond, start, count);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance新增实例
	 * @return 新增实例
	 */
	public SOC0120Info registImportVersion(SOC0120Info instance)
		throws BLException {
		checkNotImportVersion(instance.getImpeiname());
		return soc0120DAO.save(instance);
	}
	/**
	 * 修改处理
	 *
	 * @param instance修改实例
	 * @return 修改实例
	 */
	public SOC0120Info updateImportVersion(SOC0120Info instance)
		throws BLException {
		checkExistInstance(new SOC0120PK(instance.getImpversion(),instance.getImpeiname()));
		return soc0120DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk主键
	 */
	public void deleteImportVersionByPK(Serializable pk)
		throws BLException {
		soc0120DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance删除实例
	 */
	public void deleteImportVersion(SOC0120Info instance)
		throws BLException {
		soc0120DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk主键
	 * @return 实例
	 */
	public SOC0120Info checkExistInstance(Serializable pk)
		throws BLException {
		SOC0120Info instance = soc0120DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	
	/**
	 * 导入对象版本检索
	 */
	public List<SOC0120Info> searchImportVersionByPK(
			String impeiname,Integer impversion) throws BLException{
		return soc0120DAO.searchImportVersionByImpname(impeiname,impversion);
	}

	/**
	 * 导入对象不存在检查
	 * 
	 * @param impeiname实体名
	 * @return
	 * @throws BLException 
	 */
	public void checkNotImportVersion(String impeiname) throws BLException {
		SOC0120SearchCondImpl cond = new SOC0120SearchCondImpl();
		cond.setImpeiname(impeiname);
		List<SOC0120Info> infoList = soc0120DAO.findByImpeiname(cond);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS,
					"IGCO00000.E027",getValueFromResources("message.ImportVersionBLImpl.001"));
		}
	}
	
	/**
	 * <p>
	 * 根据配置文件的值，判断使用哪种语言的资源
	 * </p>
	 * 
	 * @param key 资源文件中的key
	 * @return 资源文件中的value
	 * @throws BLException
	 *
	 */
	private String getValueFromResources(String key){
		String value = "";
		String reourceLanguage = IniReader.getValue("LANGUAGE");
		if("EN".equals(reourceLanguage)){
			resources = MessageResources.getMessageResources("com.deliverik.infogovernor.asset.asmResources_en_US"); 
		} else{
			resources = MessageResources.getMessageResources("com.deliverik.infogovernor.asset.asmResources_zh_CN");
		}
		value = resources.getMessage(key);
		return value;
	}
}