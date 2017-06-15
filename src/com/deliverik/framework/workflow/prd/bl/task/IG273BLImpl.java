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
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.condition.IG273SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG273SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG273DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG273TB;

/**
 * <p>概述:流程状态跃迁规则业务逻辑实现</p>
 * <p>功能描述：1.条件检索结果件数取得</p>
 * <p>          2.主键检索处理</p>
 * <p>          3.条件检索处理</p>
 * <p>          4.全部检索处理</p>
 * <p>          5.新增处理</p>
 * <p>          6.删除处理(主键)</p>
 * <p>          7.删除处理</p>
 * <p>          8.变更处理</p>
 * <p>          9.流程状态跃迁规则信息存在检查</p>
 * <p>          10.获取规则定义信息实例</p>
 * <p>创建记录：</p>
 */
public class IG273BLImpl extends BaseBLImpl implements IG273BL {
	
	/** 流程状态跃迁规则DAO操作 */
	protected IG273DAO ig273DAO;

	/**
	 * 功能：设置流程状态跃迁规则DAO
	 * 
	 * @param ig273DAO 流程状态跃迁规则DAO
	 */
	public void setIg273DAO(
			IG273DAO ig273DAO) {
		this.ig273DAO = ig273DAO;
	}

	/**
	 * 功能：条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	
	public int getIG273InfoSearchCount(IG273SearchCond cond) {
		return ig273DAO.getSearchCount(cond);
	}

	/**
	 * 功能：主键检索处理
	 * 
	 * @param ptdid 流程状态跃迁规则ID
	 * @return 流程状态跃迁规则信息
	 * @throws BLException 
	 */
	
	public IG273Info searchIG273InfoByKey(String ptdid) throws BLException {
		return checkExistIG273Info(ptdid);
	}

	/**
	 * 功能：条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	
	public List<IG273Info> searchIG273Info(
			IG273SearchCond cond, int start, int count) {
		return ig273DAO.findByCond(cond, start, count);
	}
	
	/**
	 * 功能：条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	
	public List<IG273Info> searchIG273Info(IG273SearchCond cond) {
		return ig273DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 功能：全部检索处理
	 * 
	 * @return 检索结果列表
	 */
	
	public List<IG273Info> searchIG273InfoAll() {
		return ig273DAO.findAll();
	}
	
	

	/**
	 * 功能：新增处理
	 * 
	 * @param IG273Info 新增数据
	 * @return 资产信息
	 * @throws BLException 
	 */
	
	public IG273Info registIG273Info(
			IG273Info ig273Info) throws BLException {
		return ig273DAO.save(ig273Info);
	}

	/**
	 * 功能：删除处理
	 * 
	 * @param ptdid 删除流程状态跃迁规则主键
	 * @throws BLException 
	 */
	
	public void deleteIG273InfoByKey(String ptdid) throws BLException {
		IG273Info processTransitionDef = checkExistIG273Info(ptdid);
		ig273DAO.delete(processTransitionDef);
	}
	
	/**
	 * 功能：删除处理
	 * 
	 * @param ig273Info 删除流程状态跃迁规则信息
	 * @throws BLException 
	 */
	
	public void deleteIG273Info(IG273Info ig273Info) throws BLException {
		ig273DAO.delete(ig273Info);
	}

	/**
	 * 功能：变更处理
	 * 
	 * @param ig273Info 变更数据
	 * @return 流程状态跃迁规则
	 * @throws BLException 
	 */
	
	public IG273Info updateIG273Info(
			IG273Info ig273Info) throws BLException {
		return ig273DAO.save(ig273Info);
	}
	
	/**
	 * 功能：流程状态跃迁规则信息存在检查
	 * 
	 * @param ptdid 流程状态跃迁规则ID
	 * @return 流程状态跃迁规则
	 * @throws BLException 
	 */
	
	protected IG273Info checkExistIG273Info(String ptdid) throws BLException{
		IG273Info info = ig273DAO.findByPK(ptdid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","流程状态跃迁规则基本");
		}
		return info;
	}
	
	/**
	 * 功能：获取规则定义信息实例
	 * 
	 * @return 规则定义
	 */
	
	public IG273TB getIG273TBInstance() {
		return new IG273TB();
	}
	
	/**
	 * PTDID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PTDID主键值
	 */
	public String getPtdidSequenceNextValue(String psdid) {
		return ig273DAO.getPtdidSequenceNextValue(psdid);
	}
	
	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG273SearchCondImpl cond = new IG273SearchCondImpl();
		cond.setPtdid_like(pdid);
		List<IG273Info> lst_IG273Info = this.searchIG273Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG273>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG273Info != null) {
			for(IG273Info info : lst_IG273Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PTDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPtdid()) ? "" : IGStringUtils.filterXMLStr(info.getPtdid()));
				sbf_xml.append("</PTDID>");
				sbf_xml.append("<FPSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getFpsdid()) ? "" : IGStringUtils.filterXMLStr(info.getFpsdid()));
				sbf_xml.append("</FPSDID>");
				sbf_xml.append("<TPSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getTpsdid()) ? "" : IGStringUtils.filterXMLStr(info.getTpsdid()));
				sbf_xml.append("</TPSDID>");
				sbf_xml.append("<PTDNAME>");
				sbf_xml.append(StringUtils.isEmpty(info.getPtdname()) ? "" : IGStringUtils.filterXMLStr(info.getPtdname()));
				sbf_xml.append("</PTDNAME>");
				sbf_xml.append("<PTDDESC>");
				sbf_xml.append(StringUtils.isEmpty(info.getPtddesc()) ? "" : IGStringUtils.filterXMLStr(info.getPtddesc()));
				sbf_xml.append("</PTDDESC>");
				sbf_xml.append("<PTDTYPE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPtdtype()) ? "" : IGStringUtils.filterXMLStr(info.getPtdtype()));
				sbf_xml.append("</PTDTYPE>");
				sbf_xml.append("<PTDCOND>");
				sbf_xml.append(StringUtils.isEmpty(info.getPtdcond()) ? "" : IGStringUtils.filterXMLStr(info.getPtdcond()));
				sbf_xml.append("</PTDCOND>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG273>");
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
		List<IG273Info> lst_IG273 = new ArrayList<IG273Info>();
		IG273TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG273TBInstance();
			entity.setPtdid(e.getChildText("PTDID"));
			entity.setFpsdid(e.getChildText("FPSDID"));
			entity.setTpsdid(e.getChildText("TPSDID"));
			entity.setPtdname(e.getChildText("PTDNAME"));
			entity.setPtddesc(e.getChildText("PTDDESC"));
			entity.setPtdtype(e.getChildText("PTDTYPE"));
			entity.setPtdcond(e.getChildText("PTDCOND"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG273.add(entity);
		}
		this.ig273DAO.saveOrUpdateAll(lst_IG273);
	}

}
