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
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.model.IG298Info;
import com.deliverik.framework.workflow.prd.model.condition.IG298SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG298SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG298DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG298TB;

/**
  * 概述: 流程状态可分派角色定义信息业务逻辑实现
  * 功能描述: 流程状态可分派角色定义信息业务逻辑实现
  * 创建记录: 2012/04/11
  * 修改记录: 
  */
public class IG298BLImpl extends BaseBLImpl implements
		IG298BL {

	/** 流程状态可分派角色定义信息DAO接口 */
	protected IG298DAO ig298DAO;
	
	/**
	 * 流程状态可分派角色定义信息DAO接口设定
	 *
	 * @param ig298DAO 流程状态可分派角色定义信息DAO接口
	 */
	public void setIg298DAO(IG298DAO ig298DAO) {
		this.ig298DAO = ig298DAO;
	}

	/**
	 * 流程状态可分派角色定义信息实例取得
	 *
	 * @return 流程状态可分派角色定义信息实例
	 */
	public IG298TB getIG298TBInstance() {
		return new IG298TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG298Info> searchIG298Info() {
		return ig298DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG298Info searchIG298InfoByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG298SearchCond cond) {
		return ig298DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG298Info> searchIG298Info(
			IG298SearchCond cond) {
		return ig298DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG298Info> searchIG298Info(
			IG298SearchCond cond, int start,
			int count) {
		return ig298DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG298Info registIG298Info(IG298Info instance)
		throws BLException {
		return ig298DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG298Info updateIG298Info(IG298Info instance)
		throws BLException {
		checkExistInstance(instance.getPsrdid());
		return ig298DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG298InfoByPK(String pk)
		throws BLException {
		ig298DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG298Info(IG298Info instance)
		throws BLException {
		ig298DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG298Info checkExistInstance(String pk)
		throws BLException {
		IG298Info instance = ig298DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	
	/**
	 * PSRDID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PSRDID主键值
	 */
	public String getPsrdidSequenceNextValue(String psdid) {
		return ig298DAO.getPsrdidSequenceNextValue(psdid);
	}
	
	/**
	 * 指定状态可分派角色查询
	 *
	 * @param psdid 流程状态ID
	 * @return 可分派角色列表
	 * @throws BLException 
	 */
	public List<IG298Info> searchIG298Info(
			String psdid) throws BLException {
		if (StringUtils.isEmpty(psdid)) {
			throw new BLException("IGCO10000.E004", "流程状态基本");
		}
		IG298SearchCondImpl cond = new IG298SearchCondImpl();
		cond.setPsdid(psdid);
		return ig298DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 可被分派的角色检索处理
	 * @param pdid 流程定义ID
	 * @param psdid 流程状态ID
	 * @return 可被分派的角色列表
	 */
	public List<Role> searchToBeAssignRole(String pdid, String psdid) {
		return ig298DAO.searchToBeAssignRole(pdid, psdid);
	}
	
	/**
	 * 实例存在检查处理
	 *
	 * @param psdid 状态ID
	 * @param roleid 角色ID
	 * @return 实例
	 */
	public IG298Info checkIG298Info(String psdid, Integer roleid)
		throws BLException {
		IG298SearchCondImpl cond = new IG298SearchCondImpl();
		cond.setPsdid(psdid);
		cond.setRoleid(roleid);
		List<IG298Info> lst = ig298DAO.findByCond(cond, 0, 0);
		if (lst.isEmpty()) {
			return null;
		} else {
			return lst.get(0);
		}
	}
	
	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG298SearchCondImpl cond = new IG298SearchCondImpl();
		cond.setPsrdid_like(pdid);
		List<IG298Info> lst_IG298Info = this.searchIG298Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG298>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG298Info != null) {
			for(IG298Info info : lst_IG298Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PSRDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsrdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsrdid()));
				sbf_xml.append("</PSRDID>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<ROLEID>");
				sbf_xml.append(info.getRoleid() == null ? "" : "&roleid_" + info.getRoleid() + ";");
				sbf_xml.append("</ROLEID>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG298>");
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
		List<IG298Info> lst_IG298 = new ArrayList<IG298Info>();
		IG298TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG298TBInstance();
			entity.setPsrdid(e.getChildText("PSRDID"));
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setRoleid(StringUtils.isEmpty(e.getChildText("ROLEID")) ? null : new Integer(e.getChildText("ROLEID")));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG298.add(entity);
		}
		this.ig298DAO.saveOrUpdateAll(lst_IG298);
	}

}