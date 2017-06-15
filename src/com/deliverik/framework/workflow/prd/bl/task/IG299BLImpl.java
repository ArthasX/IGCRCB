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
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.model.IG299Info;
import com.deliverik.framework.workflow.prd.model.condition.IG299SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG299SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG299DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG299TB;

/**
  * 概述: 状态可分派机构定义表业务逻辑实现
  * 功能描述: 状态可分派机构定义表业务逻辑实现
  * 创建记录: 2013/02/26
  * 修改记录: 
  */
public class IG299BLImpl extends BaseBLImpl implements
		IG299BL {

	/** 状态可分派机构定义表DAO接口 */
	protected IG299DAO ig299DAO;
	
	/**
	 * 状态可分派机构定义表DAO接口设定
	 *
	 * @param ig299DAO 状态可分派机构定义表DAO接口
	 */
	public void setIg299DAO(IG299DAO ig299DAO) {
		this.ig299DAO = ig299DAO;
	}

	/**
	 * 状态可分派机构定义表实例取得
	 *
	 * @return 状态可分派机构定义表实例
	 */
	public IG299TB getIG299TBInstance() {
		return new IG299TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG299Info> searchIG299() {
		return ig299DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG299Info searchIG299ByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG299SearchCond cond) {
		return ig299DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG299Info> searchIG299(
			IG299SearchCond cond) {
		return ig299DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG299Info> searchIG299(
			IG299SearchCond cond, int start,
			int count) {
		return ig299DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG299Info registIG299(IG299Info instance)
		throws BLException {
		return ig299DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG299Info updateIG299(IG299Info instance)
		throws BLException {
		checkExistInstance(instance.getPsodid());
		return ig299DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG299ByPK(String pk)
		throws BLException {
		ig299DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG299(IG299Info instance)
		throws BLException {
		ig299DAO.delete(instance);
	}

	/**
	 * PSODID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PSODID主键值
	 */
	public String getPsrdidSequenceNextValue(String psdid) {
		return ig299DAO.getPsrdidSequenceNextValue(psdid);
	}
	
	/**
	 * 指定状态可分派机构查询
	 *
	 * @param psdid 流程状态ID
	 * @return 可分派机构列表
	 * @throws BLException 
	 */
	public List<IG299Info> searchIG299Info(
			String psdid) throws BLException {
		if (StringUtils.isEmpty(psdid)) {
			throw new BLException("IGCO10000.E004", "流程状态基本");
		}
		IG299SearchCondImpl cond = new IG299SearchCondImpl();
		cond.setPsdid_eq(psdid);
		return ig299DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 可被分派的机构检索处理
	 * @param pdid 流程类型ID
	 * @param levellen 机构的当前级数
	 * @param psdid 流程状态节点ID
	 * @return 可被分派的机构列表
	 */
	public List<Organization> searchToBeAssignOrg(String pdid, int levellen, String psdid) {
		return ig299DAO.searchToBeAssignOrg(pdid, levellen, psdid);
	}
	
	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG299Info checkExistInstance(String pk)
		throws BLException {
		IG299Info instance = ig299DAO.findByPK(pk);
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
		IG299SearchCondImpl cond = new IG299SearchCondImpl();
		cond.setPsdid_like(pdid);
		List<IG299Info> ig299List = this.searchIG299(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG299>");
		sbf_xml.append("<DATALIST>");
		if(ig299List!=null){
			for(IG299Info info:ig299List){
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PSODID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsodid())?"":IGStringUtils.filterXMLStr(info.getPsodid()));
				sbf_xml.append("</PSODID>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid())?"":IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<ORGSYSCODING>");
				sbf_xml.append(StringUtils.isEmpty(info.getOrgsyscoding())?"":IGStringUtils.filterXMLStr(info.getOrgsyscoding()));
				sbf_xml.append("</ORGSYSCODING>");
				sbf_xml.append("<ORGNAME>");
				sbf_xml.append(StringUtils.isEmpty(info.getOrgname())?"":IGStringUtils.filterXMLStr(info.getOrgname()));
				sbf_xml.append("</ORGNAME>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint())?"":IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG299>");
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
		List<IG299Info> lst_IG299 = new ArrayList<IG299Info>();
		IG299TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG299TBInstance();
			entity.setPsodid(e.getChildText("PSODID"));
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setOrgsyscoding(e.getChildText("ORGSYSCODING"));
			entity.setOrgname(e.getChildText("ORGNAME"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG299.add(entity);
		}
		this.ig299DAO.saveOrUpdateAll(lst_IG299);
	}

}