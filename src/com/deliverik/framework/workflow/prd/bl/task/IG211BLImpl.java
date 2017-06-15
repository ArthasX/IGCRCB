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
import com.deliverik.framework.workflow.prd.model.IG211Info;
import com.deliverik.framework.workflow.prd.model.condition.IG211SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG211SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG211DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG211TB;

/**
 * <p>概述:流程状态变量前处理业务逻辑实现</p>
 * <p>功能描述：1.条件检索结果件数取得</p>
 * <p>          2.主键检索处理</p>
 * <p>          3.条件检索处理</p>
 * <p>          4.全部检索处理</p>
 * <p>          5.新增处理</p>
 * <p>          6.删除处理</p>
 * <p>          7.变更处理</p>
 * <p>          8.流程状态变量前处理信息存在检查</p>
 * <p>          9.流程状态前处理变量信息实例</p>
 * <p>创建记录：</p>
 */
public class IG211BLImpl extends BaseBLImpl implements IG211BL {
	
	/** 流程状态变量前处理DAO操作 */
	protected IG211DAO ig211DAO;

	/**
	 * 流程状态变量前处理定义DAO
	 * 
	 * @param ig211DAO 流程状态变量前处理定义DAO
	 */
	public void setIg211DAO(
			IG211DAO ig211DAO) {
		this.ig211DAO = ig211DAO;
	}

	/**
	 * 功能：条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	
	public int getIG211InfoSearchCount(IG211SearchCond cond) {
		return ig211DAO.getSearchCount(cond);
	}
	
	

	/**
	 * 功能：主键检索处理
	 * 
	 * @param psidid 流程状态变量前处理ID
	 * @return 流程状态变量前处理信息
	 * @throws BLException 
	 */
	
	public IG211Info searchIG211InfoByKey(String psidid) throws BLException {
		return checkExistIG211Info(psidid);
	}

	/**
	 * 功能：条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	
	public List<IG211Info> searchIG211Info(
			IG211SearchCond cond, int start, int count) {
		return ig211DAO.findByCond(cond, start, count);
	}
	
	/**
	 * 功能：条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	
	public List<IG211Info> searchIG211Info(
			IG211SearchCond cond) {
		return ig211DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 功能：全部检索处理
	 * 
	 * @return 检索结果列表
	 */
	
	public List<IG211Info> searchProcessStatusInfoDefAll() {
		return ig211DAO.findAll();
	}

	/**
	 * 功能：新增处理
	 * 
	 * @param IG211Info 新增数据
	 * @return 资产信息
	 * @throws BLException 
	 */
	
	public IG211Info registIG211Info(
			IG211Info ig211Info) throws BLException {
		return ig211DAO.save(ig211Info);
	}

	/**
	 * 功能：删除处理
	 * 
	 * @param psidid 删除流程状态变量前处理主键
	 * @throws BLException 
	 */
	
	public void deleteIG211Info(String psidid) throws BLException {
		IG211Info processStatusInfoDef = checkExistIG211Info(psidid);
		ig211DAO.delete(processStatusInfoDef);
	}

	/**
	 * 功能：变更处理
	 * 
	 * @param Ig211 变更数据
	 * @return 流程状态变量前处理
	 * @throws BLException 
	 */
	
	public IG211Info updateIG211Info(
			IG211Info ig211Info) throws BLException {
		return ig211DAO.save(ig211Info);
	}
	
	/**
	 * 功能：流程状态变量前处理信息存在检查
	 * 
	 * @param psidid 流程状态变量前处理ID
	 * @return 流程状态变量前处理
	 * @throws BLException 
	 */
	
	protected IG211Info checkExistIG211Info(String psidid) throws BLException{
		IG211Info info = ig211DAO.findByPK(psidid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","流程状态变量前处理基本");
		}
		return info;
	}
	
	/**
	 * 功能：流程状态前处理变量信息实例
	 * 
	 * @return 流程状态前处理变量
	 */
	
	public IG211TB getIG211TBInstance() {
		return new IG211TB();
	}
	
	/**
	 * PSIDID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PSIDID主键值
	 */
	public String getPsididSequenceNextValue(String psdid) {
		return ig211DAO.getPsididSequenceNextValue(psdid);
	}
	
	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG211SearchCondImpl cond = new IG211SearchCondImpl();
		cond.setPsidid_like(pdid);
		List<IG211Info> lst_IG211Info = this.searchIG211Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG211>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG211Info != null) {
			for(IG211Info info : lst_IG211Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PSIDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsidid()) ? "" : IGStringUtils.filterXMLStr(info.getPsidid()));
				sbf_xml.append("</PSIDID>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<PIDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidid()) ? "" : IGStringUtils.filterXMLStr(info.getPidid()));
				sbf_xml.append("</PIDID>");
				sbf_xml.append("<PIDNAME>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidname()) ? "" : IGStringUtils.filterXMLStr(info.getPidname()));
				sbf_xml.append("</PIDNAME>");
				sbf_xml.append("<PIDLABEL>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidlabel()) ? "" : IGStringUtils.filterXMLStr(info.getPidlabel()));
				sbf_xml.append("</PIDLABEL>");
				sbf_xml.append("<PIDDESC>");
				sbf_xml.append(StringUtils.isEmpty(info.getPiddesc()) ? "" : IGStringUtils.filterXMLStr(info.getPiddesc()));
				sbf_xml.append("</PIDDESC>");
				sbf_xml.append("<PIDTYPE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidtype()) ? "" : IGStringUtils.filterXMLStr(info.getPidtype()));
				sbf_xml.append("</PIDTYPE>");
				sbf_xml.append("<PIDVALUE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidvalue()) ? "" : IGStringUtils.filterXMLStr(info.getPidvalue()));
				sbf_xml.append("</PIDVALUE>");
				sbf_xml.append("<PIDATTKEY>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidattkey()) ? "" : IGStringUtils.filterXMLStr(info.getPidattkey()));
				sbf_xml.append("</PIDATTKEY>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG211>");
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
		List<IG211Info> lst_IG211 = new ArrayList<IG211Info>();
		IG211TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG211TBInstance();
			entity.setPsidid(e.getChildText("PSIDID"));
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setPidid(e.getChildText("PIDID"));
			entity.setPidname(e.getChildText("PIDNAME"));
			entity.setPidlabel(e.getChildText("PIDLABEL"));
			entity.setPiddesc(e.getChildText("PIDDESC"));
			entity.setPidtype(e.getChildText("PIDTYPE"));
			entity.setPidvalue(e.getChildText("PIDVALUE"));
			entity.setPidattkey(e.getChildText("PIDATTKEY"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG211.add(entity);
		}
		this.ig211DAO.saveOrUpdateAll(lst_IG211);
	}

}
