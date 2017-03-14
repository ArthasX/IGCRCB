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
import com.deliverik.framework.workflow.prd.model.IG258Info;
import com.deliverik.framework.workflow.prd.model.condition.IG258SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG258SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG258DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG258TB;

/**
  * 概述: 流程状态参与者调整业务逻辑实现
  * 功能描述: 流程状态参与者调整业务逻辑实现
  * 创建记录: 2012/05/09
  * 修改记录: 
  */
public class IG258BLImpl extends BaseBLImpl implements
		IG258BL {

	/** 流程状态参与者调整DAO接口 */
	protected IG258DAO ig258DAO;
	
	/**
	 * 流程状态参与者调整DAO接口设定
	 *
	 * @param ig258DAO 流程状态参与者调整DAO接口
	 */
	public void setIg258DAO(IG258DAO ig258DAO) {
		this.ig258DAO = ig258DAO;
	}

	/**
	 * 流程状态参与者调整实例取得
	 *
	 * @return 流程状态参与者调整实例
	 */
	public IG258TB getIG258TBInstance() {
		return new IG258TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG258Info> searchIG258Info() {
		return ig258DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG258Info searchIG258InfoByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG258SearchCond cond) {
		return ig258DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG258Info> searchIG258Info(
			IG258SearchCond cond) {
		return ig258DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG258Info> searchIG258Info(
			IG258SearchCond cond, int start,
			int count) {
		return ig258DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG258Info registIG258Info(IG258Info instance)
		throws BLException {
		return ig258DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG258Info updateIG258Info(IG258Info instance)
		throws BLException {
		checkExistInstance(instance.getPspcdid());
		return ig258DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG258InfoByPK(String pk)
		throws BLException {
		ig258DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG258Info(IG258Info instance)
		throws BLException {
		ig258DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG258Info checkExistInstance(String pk)
		throws BLException {
		IG258Info instance = ig258DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}

	/**
	 * PSDID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PSDID主键值
	 */
	public String getPspcdSequenceNextValue(String psdid) {
		return ig258DAO.getPspcdSequenceNextValue(psdid);
	}
	
	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG258SearchCondImpl cond = new IG258SearchCondImpl();
		cond.setPspcdid_like(pdid);
		List<IG258Info> lst_IG258Info = this.searchIG258Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG258>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG258Info != null) {
			for(IG258Info info : lst_IG258Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PSPCDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPspcdid()) ? "" : IGStringUtils.filterXMLStr(info.getPspcdid()));
				sbf_xml.append("</PSPCDID>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<PSPCDPSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPspcdpsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPspcdpsdid()));
				sbf_xml.append("</PSPCDPSDID>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG258>");
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
		List<IG258Info> lst_IG258 = new ArrayList<IG258Info>();
		IG258TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG258TBInstance();
			entity.setPspcdid(e.getChildText("PSPCDID"));
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setPspcdpsdid(e.getChildText("PSPCDPSDID"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG258.add(entity);
		}
		this.ig258DAO.saveOrUpdateAll(lst_IG258);
	}
}