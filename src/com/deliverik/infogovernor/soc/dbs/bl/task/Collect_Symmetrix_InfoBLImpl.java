/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

 package com.deliverik.infogovernor.soc.dbs.bl.task;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.IniReader;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Info;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_InfoSearchCond;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_InfoSearchCondImpl;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_Symmetrix_InfoDAO;


/**
 * 
 * @Description:存储基本信息BL实现类
 * @Author
 * @History
 * @Version V1.0
 */
public class Collect_Symmetrix_InfoBLImpl extends BaseBLImpl implements Collect_Symmetrix_InfoBL{

	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.asset.asmResources"); 
	
	protected Collect_Symmetrix_InfoDAO collect_Symmetrix_InfoDAO;

	public void setCollect_Symmetrix_InfoDAO(
			Collect_Symmetrix_InfoDAO collect_Symmetrix_InfoDAO) {
		this.collect_Symmetrix_InfoDAO = collect_Symmetrix_InfoDAO;
	}

	/**
	 * 持久化处理
	 * 
	 * @param Collect_Symmetrix_Info实体类
	 * @return Collect_Symmetrix_Info实体类
	 */
	public Collect_Symmetrix_Info saveCollect_Symmetrix_Info(
			Collect_Symmetrix_Info collect_Symmetrix_Info) throws BLException {
		checkNotCollect_Symmetrix_Info(collect_Symmetrix_Info.getSymm_id());
		return collect_Symmetrix_InfoDAO.save(collect_Symmetrix_Info);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param id
	 *            主键
	 * @return 检索结果
	 */
	public Collect_Symmetrix_Info findCollect_Symmetrix_InfoByPK(Integer id)
			throws BLException {
		return collect_Symmetrix_InfoDAO.findByPK(id);
	}

	/**
	 * 全件检索
	 * 
	 * @return 检索结果集
	 */
	public List<Collect_Symmetrix_Info> findAllCollect_Symmetrix_Info()
			throws BLException {
		return collect_Symmetrix_InfoDAO.findAll();
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond
	 *            检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(Collect_Symmetrix_InfoSearchCond cond)
			throws BLException {
		return collect_Symmetrix_InfoDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond
	 *            检索条件
	 * @param start
	 *            检索记录起始行号
	 * @param count
	 *            检索记录件数
	 * @return 检索结果列表
	 */
	public List<Collect_Symmetrix_Info> findCollect_Symmetrix_InfoByCond(
			Collect_Symmetrix_InfoSearchCond cond, int start, int count)
			throws BLException {
		return collect_Symmetrix_InfoDAO.findByCond(cond, start, count);
	}

	/**
	 * 删除处理
	 * 
	 * @param Collect_Symmetrix_Info实体类
	 */
	public void deleteCollect_Symmetrix_Info(
			Collect_Symmetrix_Info collect_Symmetrix_Info) throws BLException {
		collect_Symmetrix_InfoDAO.delete(collect_Symmetrix_Info);
	}

	/**
	 * 修改处理
	 */
	public Collect_Symmetrix_Info updateCollect_Symmetrix_Info(
			Collect_Symmetrix_Info collect_Symmetrix_Info) throws BLException {
		checkExistInstance(collect_Symmetrix_Info.getId());
		return collect_Symmetrix_InfoDAO.save(collect_Symmetrix_Info);
	}

	/**
	 * 实例存在检查处理
	 * 
	 * @param pk主键
	 * @return 实例
	 */
	public Collect_Symmetrix_Info checkExistInstance(Serializable pk)
			throws BLException {
		Collect_Symmetrix_Info instance = collect_Symmetrix_InfoDAO
				.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "存储基本");
		}
		return instance;
	}

	/**
	 * 存储名称不存在检查
	 * 
	 * @param symm_id存储名称
	 * @return
	 * @throws BLException
	 */
	public void checkNotCollect_Symmetrix_Info(String symm_id)
			throws BLException {
		Collect_Symmetrix_InfoSearchCondImpl collect_Symmetrix_InfoSearchCond = new Collect_Symmetrix_InfoSearchCondImpl();
		collect_Symmetrix_InfoSearchCond.setSymm_id(symm_id);
		List<Collect_Symmetrix_Info> infoList = collect_Symmetrix_InfoDAO
				.findByCond(collect_Symmetrix_InfoSearchCond, 0, 0);
		if (infoList != null && infoList.size() > 0) {
			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS,"IGASM2602.E001", getValueFromResources("message.Collect_Symmetrix_InfoBLImpl.001"));
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

