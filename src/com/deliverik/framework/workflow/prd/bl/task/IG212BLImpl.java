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
import com.deliverik.framework.workflow.prd.model.IG212Info;
import com.deliverik.framework.workflow.prd.model.IG238Info;
import com.deliverik.framework.workflow.prd.model.condition.IG212SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG212SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG212DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG212PK;
import com.deliverik.framework.workflow.prd.model.entity.IG212TB;

/**
  * 概述: 流程通知策略业务逻辑实现
  * 功能描述: 流程通知策略业务逻辑实现
  * 创建记录: 2012/04/24
  * 修改记录: 
  */
public class IG212BLImpl extends BaseBLImpl implements
		IG212BL {

	/** 流程通知策略DAO接口 */
	protected IG212DAO ig212DAO;
	
	/**
	 * 流程通知策略DAO接口设定
	 *
	 * @param ig212DAO 流程通知策略DAO接口
	 */
	public void setIg212DAO(IG212DAO ig212DAO) {
		this.ig212DAO = ig212DAO;
	}

	/**
	 * 流程通知策略实例取得
	 *
	 * @return 流程通知策略实例
	 */
	public IG212TB getIG212TBInstance() {
		return new IG212TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG212Info> searchIG212Info() {
		return ig212DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG212Info searchIG212InfoByPK(IG212PK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG212SearchCond cond) {
		return ig212DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG212Info> searchIG212Info(
			IG212SearchCond cond) {
		return ig212DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG212Info> searchIG212Info(
			IG212SearchCond cond, int start,
			int count) {
		return ig212DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG212Info registIG212Info(IG212Info instance)
		throws BLException {
		return ig212DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG212Info updateIG212Info(IG212Info instance)
		throws BLException {
		checkExistInstance(new IG212PK(instance.getPsdid(), instance.getPsdconfirm()));
		return ig212DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG212InfoByPK(IG212PK pk)
		throws BLException {
		ig212DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG212Info(IG212Info instance)
		throws BLException {
		ig212DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG212Info checkExistInstance(IG212PK pk)
		throws BLException {
		IG212Info instance = ig212DAO.findByPK(pk);
		return instance;
	}
	
	/**
	 * 流程通知策略查询
	 * 
	 * @param pdid 流程定义ID
	 * @return 流程通知策略列表
	 */
	public List<IG238Info> searchIG238Info(String pdid) {
		return ig212DAO.searchIG238Info(pdid);
	}
	
	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG212SearchCondImpl cond = new IG212SearchCondImpl();
		cond.setPsdid_like(pdid);
		List<IG212Info> lst_IG212Info = this.searchIG212Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG212>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG212Info != null) {
			for(IG212Info info : lst_IG212Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<PSDCONFIRM>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdconfirm()) ? "" : IGStringUtils.filterXMLStr(info.getPsdconfirm()));
				sbf_xml.append("</PSDCONFIRM>");
				sbf_xml.append("<SMS>");
				sbf_xml.append(StringUtils.isEmpty(info.getSms()) ? "" : IGStringUtils.filterXMLStr(info.getSms()));
				sbf_xml.append("</SMS>");
				sbf_xml.append("<EMAIL>");
				sbf_xml.append(StringUtils.isEmpty(info.getEmail()) ? "" : IGStringUtils.filterXMLStr(info.getEmail()));
				sbf_xml.append("</EMAIL>");
				sbf_xml.append("<PDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
				sbf_xml.append("</PDID>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG212>");
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
		List<IG212Info> lst_IG212 = new ArrayList<IG212Info>();
		IG212TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG212TBInstance();
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setPsdconfirm(e.getChildText("PSDCONFIRM"));
			entity.setSms(e.getChildText("SMS"));
			entity.setEmail(e.getChildText("EMAIL"));

			entity.setPdid(e.getChildText("PDID"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG212.add(entity);
		}
		this.ig212DAO.saveOrUpdateAll(lst_IG212);
	}

}