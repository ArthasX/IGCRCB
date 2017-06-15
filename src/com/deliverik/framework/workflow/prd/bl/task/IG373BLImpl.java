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
import com.deliverik.framework.workflow.prd.model.IG373Info;
import com.deliverik.framework.workflow.prd.model.condition.IG373SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG373SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG373DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG373TB;

/**
  * 概述: 流程表单初始化事件定义表业务逻辑实现
  * 功能描述: 流程表单初始化事件定义表业务逻辑实现
  * 创建记录: 2012/07/03
  * 修改记录: 
  */
public class IG373BLImpl extends BaseBLImpl implements
		IG373BL {

	/** 流程表单初始化事件定义表DAO接口 */
	protected IG373DAO ig373DAO;
	
	/**
	 * 流程表单初始化事件定义表DAO接口设定
	 *
	 * @param ig373DAO 流程表单初始化事件定义表DAO接口
	 */
	public void setIg373DAO(IG373DAO ig373DAO) {
		this.ig373DAO = ig373DAO;
	}

	/**
	 * 流程表单初始化事件定义表实例取得
	 *
	 * @return 流程表单初始化事件定义表实例
	 */
	public IG373TB getIG373TBInstance() {
		return new IG373TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG373Info> searchIG373Info() {
		return ig373DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG373Info searchIG373InfoByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG373SearchCond cond) {
		return ig373DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG373Info> searchIG373Info(
			IG373SearchCond cond) {
		return ig373DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG373Info> searchIG373Info(
			IG373SearchCond cond, int start,
			int count) {
		return ig373DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG373Info registIG373Info(IG373Info instance)
		throws BLException {
		return ig373DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG373Info updateIG373Info(IG373Info instance)
		throws BLException {
		checkExistInstance(instance.getPiidid());
		return ig373DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG373InfoByPK(String pk)
		throws BLException {
		ig373DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG373Info(IG373Info instance)
		throws BLException {
		ig373DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG373Info checkExistInstance(String pk)
		throws BLException {
		IG373Info instance = ig373DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	
	/**
	 * PIIDID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PIIDID主键值
	 */
	public String getPiididSequenceNextValue(String psdid) {
		return ig373DAO.getPiididSequenceNextValue(psdid);
	}
	
	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG373SearchCondImpl cond = new IG373SearchCondImpl();
		cond.setPdid(pdid);
		List<IG373Info> lst_IG373Info = this.searchIG373Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG373>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG373Info != null) {
			for(IG373Info info : lst_IG373Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PIIDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPiidid()) ? "" : IGStringUtils.filterXMLStr(info.getPiidid()));
				sbf_xml.append("</PIIDID>");
				sbf_xml.append("<PDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
				sbf_xml.append("</PDID>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<PIIDBLID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPiidblid()) ? "" : IGStringUtils.filterXMLStr(info.getPiidblid()));
				sbf_xml.append("</PIIDBLID>");
				sbf_xml.append("<PIIDDEC>");
				sbf_xml.append(StringUtils.isEmpty(info.getPiiddec()) ? "" : IGStringUtils.filterXMLStr(info.getPiiddec()));
				sbf_xml.append("</PIIDDEC>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG373>");
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
		List<IG373Info> lst_IG373 = new ArrayList<IG373Info>();
		IG373TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG373TBInstance();
			entity.setPiidid(e.getChildText("PIIDID"));
			entity.setPdid(e.getChildText("PDID"));
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setPiidblid(e.getChildText("PIIDBLID"));
			entity.setPiiddec(e.getChildText("PIIDDEC"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG373.add(entity);
		}
		this.ig373DAO.saveOrUpdateAll(lst_IG373);
	}

}