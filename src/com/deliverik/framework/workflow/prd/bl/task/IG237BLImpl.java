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
import com.deliverik.framework.workflow.prd.model.IG237Info;
import com.deliverik.framework.workflow.prd.model.condition.IG237SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG237SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG237DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG237PK;
import com.deliverik.framework.workflow.prd.model.entity.IG237TB;

/**
  * 概述: 流程策略通知人业务逻辑实现
  * 功能描述: 流程策略通知人业务逻辑实现
  * 创建记录: 2012/04/25
  * 修改记录: 
  */
public class IG237BLImpl extends BaseBLImpl implements
		IG237BL {

	/** 流程策略通知人DAO接口 */
	protected IG237DAO ig237DAO;
	
	/**
	 * 流程策略通知人DAO接口设定
	 *
	 * @param ig237DAO 流程策略通知人DAO接口
	 */
	public void setIg237DAO(IG237DAO ig237DAO) {
		this.ig237DAO = ig237DAO;
	}

	/**
	 * 流程策略通知人实例取得
	 *
	 * @return 流程策略通知人实例
	 */
	public IG237TB getIG237TBInstance() {
		return new IG237TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG237Info> searchIG237Info() {
		return ig237DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG237Info searchIG237InfoByPK(IG237PK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG237SearchCond cond) {
		return ig237DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG237Info> searchIG237Info(
			IG237SearchCond cond) {
		return ig237DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG237Info> searchIG237Info(
			IG237SearchCond cond, int start,
			int count) {
		return ig237DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG237Info registIG237Info(IG237Info instance)
		throws BLException {
		return ig237DAO.save(instance);
	}
	
	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public void registAllIG237Info(List<IG237Info> instance)
			throws BLException {
		ig237DAO.saveOrUpdateAll(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG237Info updateIG237Info(IG237Info instance)
		throws BLException {
		checkExistInstance(new IG237PK(instance.getPsdid(), instance.getPsdconfirm(), instance.getUserid(), instance.getPivalue()));
		return ig237DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG237InfoByPK(IG237PK pk)
		throws BLException {
		ig237DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG237Info(IG237Info instance)
		throws BLException {
		ig237DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG237Info checkExistInstance(IG237PK pk)
		throws BLException {
		IG237Info instance = ig237DAO.findByPK(pk);
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
		IG237SearchCondImpl cond = new IG237SearchCondImpl();
		cond.setPsdid_like(pdid);
		List<IG237Info> lst_IG237Info = this.searchIG237Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG237>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG237Info != null) {
			for(IG237Info info : lst_IG237Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<PSDCONFIRM>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdconfirm()) ? "" : IGStringUtils.filterXMLStr(info.getPsdconfirm()));
				sbf_xml.append("</PSDCONFIRM>");
				sbf_xml.append("<USERID>");
				sbf_xml.append(StringUtils.isEmpty(info.getUserid()) ? "" : "&userid_" + info.getUserid() + ";");
				sbf_xml.append("</USERID>");
				sbf_xml.append("<ROLEID>");
				sbf_xml.append(info.getRoleid() == null ? "" : "&roleid_" + info.getRoleid() + ";");
				sbf_xml.append("</ROLEID>");
				sbf_xml.append("<PIVALUE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPivalue()) ? "" : IGStringUtils.filterXMLStr(info.getPivalue()));
				sbf_xml.append("</PIVALUE>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG237>");
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
		List<IG237Info> lst_IG237 = new ArrayList<IG237Info>();
		IG237TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG237TBInstance();
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setPsdconfirm(e.getChildText("PSDCONFIRM"));
			entity.setUserid(e.getChildText("USERID"));
			entity.setRoleid(new Integer(e.getChildText("ROLEID")));
			entity.setPivalue(e.getChildText("PIVALUE"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG237.add(entity);
		}
		this.ig237DAO.saveOrUpdateAll(lst_IG237);
	}

}