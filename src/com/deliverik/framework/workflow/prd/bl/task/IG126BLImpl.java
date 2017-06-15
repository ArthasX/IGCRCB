/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.model.IG126Info;
import com.deliverik.framework.workflow.prd.model.condition.IG126SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG126SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG126DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG126TB;

/**
 * <p>
 * 流程页面定义业务逻辑实现
 * </p>
 */

public class IG126BLImpl extends BaseBLImpl implements
		IG126BL {

	/** 流程页面定义DAO */
	protected IG126DAO ig126DAO;

	/**
	 * 流程页面定义DAO
	 * 
	 * @param processJspDefDAO流程页面定义DAO
	 */
	public void setIg126DAO(
			IG126DAO ig126DAO) {
		this.ig126DAO = ig126DAO;
	}
	
	/**
	 * 功能：获取流程页面定义实例
	 * @return IG126TB
	 */
	
	public IG126TB getIG126TBInstance(){
		return new IG126TB();
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(IG126SearchCond cond) {
		return ig126DAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param pjdid流程页面定义ID
	 * @return 流程页面定义信息
	 */
	public IG126Info searchIG126InfoByKey(String pjdid)
			throws BLException {

		return checkExistIG126Info(pjdid);
	}

	/**
	 * 全部检索处理
	 * 
	 * @return 全部流程页面定义信息
	 */
	public List<IG126Info> searchIG126InfoAll() {
		return ig126DAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG126Info> searchIG126Info(
			IG126SearchCond cond, int start, int count) {
		return ig126DAO.findByCond(cond, start, count);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<IG126Info> searchIG126Info(
			IG126SearchCond cond) {
		return ig126DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 登录处理
	 * 
	 * @param IG126登录数据
	 * @return 流程页面定义信息
	 */
	public IG126Info registIG126Info(IG126Info ig126Info)
			throws BLException {
		return ig126DAO.save(ig126Info);
	}

	/**
	 * 删除处理
	 * 
	 * @param pjdid流程页面定义ID
	 */
	public void deleteIG126Info(String pjdid) throws BLException {

		IG126Info processJspDef = checkExistIG126Info(pjdid);

		ig126DAO.delete(processJspDef);
	}

	/**
	 * 变更处理
	 * 
	 * @param IG126变更数据
	 * @return 流程页面定义信息
	 */
	public IG126Info updateIG126Info(IG126Info ig126Info)
			throws BLException {
		checkExistIG126Info(ig126Info.getPjdid());
		return ig126DAO.save(ig126Info);
	}

	/**
	 * 流程页面定义信息存在检查
	 * 
	 * @param pjdid流程页面定义ID
	 * @return 流程页面定义信息
	 * @throws BLException
	 */
	protected IG126Info checkExistIG126Info(String pjdid)
			throws BLException {
		IG126Info info = ig126DAO.findByPK(pjdid);
		if (info == null) {
			throw new BLException("IGCO10000.E004", "流程页面定义基本");
		}
		return info;
	}
	
	/**
	 * PJDID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PJDID主键值
	 */
	public String getPjdidSequenceNextValue(String pdid) {
		return ig126DAO.getPjdidSequenceNextValue(pdid);
	}
	
	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG126SearchCondImpl cond = new IG126SearchCondImpl();
		cond.setPjdid_like(pdid);
		List<IG126Info> lst_IG126Info = this.searchIG126Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG126>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG126Info != null) {
			for(IG126Info info : lst_IG126Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PJDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPjdid()) ? "" : IGStringUtils.filterXMLStr(info.getPjdid()));
				sbf_xml.append("</PJDID>");
				sbf_xml.append("<PDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
				sbf_xml.append("</PDID>");
				sbf_xml.append("<PJDTYPE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPjdtype()) ? "" : IGStringUtils.filterXMLStr(info.getPjdtype()));
				sbf_xml.append("</PJDTYPE>");
				sbf_xml.append("<PJDBLID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPjdblid()) ? "" : IGStringUtils.filterXMLStr(info.getPjdblid()));
				sbf_xml.append("</PJDBLID>");
				sbf_xml.append("<PJDURL>");
				sbf_xml.append(StringUtils.isEmpty(info.getPjdurl()) ? "" : IGStringUtils.filterXMLStr(info.getPjdurl()));
				sbf_xml.append("</PJDURL>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG126>");
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
		List<IG126Info> lst_IG126 = new ArrayList<IG126Info>();
		IG126TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG126TBInstance();
			entity.setPjdid(e.getChildText("PJDID"));
			entity.setPdid(e.getChildText("PDID"));
			entity.setPjdtype(e.getChildText("PJDTYPE"));
			entity.setPjdblid(e.getChildText("PJDBLID"));
			entity.setPjdurl(e.getChildText("PJDURL"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG126.add(entity);
		}
		this.ig126DAO.saveOrUpdateAll(lst_IG126);
	}
}
