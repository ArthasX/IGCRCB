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
import com.deliverik.framework.workflow.prd.model.IG243Info;
import com.deliverik.framework.workflow.prd.model.condition.IG243SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG243SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG243DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG243TB;

/**
  * 概述: 流程标题定义表业务逻辑实现
  * 功能描述: 流程标题定义表业务逻辑实现
  * 创建记录: 2012/03/30
  * 修改记录: 
  */
public class IG243BLImpl extends BaseBLImpl implements
		IG243BL {

	/** 流程标题定义表DAO接口 */
	protected IG243DAO ig243DAO;
	
	/**
	 * 流程标题定义表DAO接口设定
	 *
	 * @param ig243DAO 流程标题定义表DAO接口
	 */
	public void setIg243DAO(IG243DAO ig243DAO) {
		this.ig243DAO = ig243DAO;
	}

	/**
	 * 流程标题定义表实例取得
	 *
	 * @return 流程标题定义表实例
	 */
	public IG243TB getIG243TBInstance() {
		return new IG243TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG243Info> searchIG243Info() {
		return ig243DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG243Info searchIG243InfoByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG243SearchCond cond) {
		return ig243DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG243Info> searchIG243Info(
			IG243SearchCond cond) {
		return ig243DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG243Info> searchIG243Info(
			IG243SearchCond cond, int start,
			int count) {
		return ig243DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG243Info registIG243Info(IG243Info instance)
		throws BLException {
		return ig243DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG243Info updateIG243Info(IG243Info instance)
		throws BLException {
		checkExistInstance(instance.getPtdid());
		return ig243DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG243InfoByPK(String pk)
		throws BLException {
		ig243DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG243Info(IG243Info instance)
		throws BLException {
		ig243DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG243Info checkExistInstance(String pk)
		throws BLException {
		IG243Info instance = ig243DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	
	/**
	 * PTDID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PTDID主键值
	 */
	public String getPtdidSequenceNextValue(String pdid) {
		return ig243DAO.getPtdidSequenceNextValue(pdid);
	}
	
	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG243SearchCondImpl cond = new IG243SearchCondImpl();
		cond.setPtdid_like(pdid);
		List<IG243Info> lst_IG243Info = this.searchIG243Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG243>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG243Info != null) {
			for(IG243Info info : lst_IG243Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PTDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPtdid()) ? "" : IGStringUtils.filterXMLStr(info.getPtdid()));
				sbf_xml.append("</PTDID>");
				sbf_xml.append("<PDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
				sbf_xml.append("</PDID>");
				sbf_xml.append("<PTITLENAME>");
				sbf_xml.append(StringUtils.isEmpty(info.getPtitlename()) ? "" : IGStringUtils.filterXMLStr(info.getPtitlename()));
				sbf_xml.append("</PTITLENAME>");
				sbf_xml.append("<PTITLEACCESS>");
				sbf_xml.append(StringUtils.isEmpty(info.getPtitleaccess()) ? "" : IGStringUtils.filterXMLStr(info.getPtitleaccess()));
				sbf_xml.append("</PTITLEACCESS>");
				sbf_xml.append("<PDESCNAME>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdescname()) ? "" : IGStringUtils.filterXMLStr(info.getPdescname()));
				sbf_xml.append("</PDESCNAME>");
				sbf_xml.append("<PDESCACCESS>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdescaccess()) ? "" : IGStringUtils.filterXMLStr(info.getPdescaccess()));
				sbf_xml.append("</PDESCACCESS>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG243>");
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
		List<IG243Info> lst_IG243 = new ArrayList<IG243Info>();
		IG243TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG243TBInstance();
			entity.setPtdid(e.getChildText("PTDID"));
			entity.setPdid(e.getChildText("PDID"));
			entity.setPtitlename(e.getChildText("PTITLENAME"));
			entity.setPtitleaccess(e.getChildText("PTITLEACCESS"));
			entity.setPdescname(e.getChildText("PDESCNAME"));
			entity.setPdescaccess(e.getChildText("PDESCACCESS"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG243.add(entity);
		}
		this.ig243DAO.saveOrUpdateAll(lst_IG243);
	}

}