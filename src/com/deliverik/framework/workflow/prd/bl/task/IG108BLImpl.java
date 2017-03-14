/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.model.IG108Info;
import com.deliverik.framework.workflow.prd.model.condition.IG108SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG108SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG108DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG108TB;

/**
  * 概述: 自定义流程表单查询条件定义表业务逻辑实现
  * 功能描述: 自定义流程表单查询条件定义表业务逻辑实现
  * 创建记录: 2013/03/13
  * 修改记录: 
  */
public class IG108BLImpl extends BaseBLImpl implements IG108BL {

	/** 自定义流程表单查询条件定义表DAO接口 */
	protected IG108DAO ig108DAO;
	
	/**
	 * 自定义流程表单查询条件定义表DAO接口设定
	 *
	 * @param ig108DAO 自定义流程表单查询条件定义表DAO接口
	 */
	public void setIg108DAO(IG108DAO ig108DAO) {
		this.ig108DAO = ig108DAO;
	}

	/**
	 * 自定义流程表单查询条件定义表实例取得
	 *
	 * @return 自定义流程表单查询条件定义表实例
	 */
	public IG108TB getIG108TBInstance() {
		return new IG108TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG108Info> searchIG108() {
		return ig108DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG108Info searchIG108ByPK(Integer pk) throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG108SearchCond cond) {
		return ig108DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG108Info> searchIG108(IG108SearchCond cond) {
		return ig108DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 根据流程类型主键检索
	 * @param pdid
	 * @return
	 */
	public List<IG108Info> findBypdid(String pdid){
		if(StringUtils.isEmpty(pdid)){
			return null;
		}
		IG108SearchCondImpl cond = new IG108SearchCondImpl();
		cond.setPdid(pdid);
		return this.searchIG108(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG108Info> searchIG108(IG108SearchCond cond, int start,int count) {
		return ig108DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG108Info registIG108(IG108Info instance) throws BLException {
		return ig108DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG108Info updateIG108(IG108Info instance) throws BLException {
		checkExistInstance(instance.getPqid());
		return ig108DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG108ByPK(Integer pk) throws BLException {
		ig108DAO.delete(checkExistInstance(pk));
	}
	
	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG108(IG108Info instance) throws BLException {
		ig108DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG108Info checkExistInstance(Integer pk) throws BLException {
		IG108Info instance = ig108DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	
	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		List<IG108Info> lst_IG108Info = this.findBypdid(pdid);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG108>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG108Info != null) {
			for(IG108Info info : lst_IG108Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdid())?"":IGStringUtils.filterXMLStr(info.getPdid()));
				sbf_xml.append("</PDID>");
				sbf_xml.append("<PIDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidid())?"":IGStringUtils.filterXMLStr(info.getPidid()));
				sbf_xml.append("</PIDID>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG108>");
		return sbf_xml;
	}
	
	/**
	 * XML脚本导入处理
	 *
	 * @param element Element
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public void importXML(Element element) throws BLException {
		Element data = element.getChild("DATALIST");
		List<Element> dataList = data.getChildren();
		List<IG108Info> lst_IG108 = new ArrayList<IG108Info>();
		IG108TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG108TBInstance();
			entity.setPdid(e.getChildText("PDID"));
			entity.setPidid(e.getChildText("PIDID"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG108.add(entity);
		}
		this.ig108DAO.saveOrUpdateAll(lst_IG108);
	}

}