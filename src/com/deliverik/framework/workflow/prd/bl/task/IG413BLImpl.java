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
import com.deliverik.framework.workflow.prd.model.IG413Info;
import com.deliverik.framework.workflow.prd.model.condition.IG413SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG413SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG413DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG413TB;

/**
 * <p>
 * 流程事件定义业务逻辑实现
 * </p>
 */

public class IG413BLImpl extends BaseBLImpl implements
		IG413BL {

	/** 流程事件定义DAO */
	protected IG413DAO ig413DAO;

	/**
	 * 流程事件定义DAO
	 * 
	 * @param ig413DAO流程事件定义DAO
	 */
	public void setIg413DAO(
			IG413DAO ig413DAO) {
		this.ig413DAO = ig413DAO;
	}

	/**
	 * 功能：获取流程变量定义实例
	 * @return IG413TB
	 */
	
	public IG413TB getIG413TBInstance(){
		return new IG413TB();
	}

	/**
	 * 条件检索结果件数取得
	 * 
	 * @param cond检索条件
	 * @return 条件检索结果件数
	 */
	public int getSearchCount(IG413SearchCond cond) {
		return ig413DAO.getSearchCount(cond);
	}

	/**
	 * 主键检索处理
	 * 
	 * @param pedid流程事件定义ID
	 * @return 流程事件定义信息
	 */
	public IG413Info searchIG413InfoByKey(String pedid)
			throws BLException {

		return checkExistProcessEventDef(pedid);
	}

	/**
	 * 全部检索处理
	 * 
	 * @return 全部流程事件定义信息
	 */
	public List<IG413Info> searchIG413InfoAll() {
		return ig413DAO.findAll();
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG413Info> searchIG413Info(
			IG413SearchCond cond, int start, int count) {
		return ig413DAO.findByCond(cond, start, count);
	}

	/**
	 * 条件检索处理
	 * 
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<IG413Info> searchIG413Info(IG413SearchCond cond) {
		return ig413DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 登录处理
	 * 
	 * @param processEventDef登录数据
	 * @return 流程事件定义信息
	 */
	public IG413Info registIG413Info(IG413Info ig413Info)
			throws BLException {
		return ig413DAO.save(ig413Info);
	}

	/**
	 * 删除处理
	 * 
	 * @param pedid流程事件定义ID
	 */
	public void deleteIG413Info(String pedid) throws BLException {

		IG413Info processEventDef = checkExistProcessEventDef(pedid);

		ig413DAO.delete(processEventDef);
	}

	/**
	 * 变更处理
	 * 
	 * @param processEventDef变更数据
	 * @return 流程事件定义信息
	 */
	public IG413Info updateIG413Info(IG413Info ig413Info)
			throws BLException {
		checkExistProcessEventDef(ig413Info.getPedid());
		return ig413DAO.save(ig413Info);
	}

	/**
	 * 流程事件定义信息存在检查
	 * 
	 * @param pedid流程事件定义ID
	 * @return 流程事件定义信息
	 * @throws BLException
	 */
	protected IG413Info checkExistProcessEventDef(String pedid)
			throws BLException {
		IG413Info info = ig413DAO.findByPK(pedid);
		if (info == null) {
			throw new BLException("IGCO10000.E004", "流程事件定义基本");
		}
		return info;
	}
	
	/**
	 * PEDID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PEDID主键值
	 */
	public String getPedidSequenceNextValue(String psdid) {
		return ig413DAO.getPedidSequenceNextValue(psdid);
	}
	
	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG413SearchCondImpl cond = new IG413SearchCondImpl();
		cond.setPedid_like(pdid);
		List<IG413Info> lst_IG413Info = this.searchIG413Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG413>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG413Info != null) {
			for(IG413Info info : lst_IG413Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PEDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPedid()) ? "" : IGStringUtils.filterXMLStr(info.getPedid()));
				sbf_xml.append("</PEDID>");
				sbf_xml.append("<PDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
				sbf_xml.append("</PDID>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<PEDACTIONID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPedactionid()) ? "" : IGStringUtils.filterXMLStr(info.getPedactionid()));
				sbf_xml.append("</PEDACTIONID>");
				sbf_xml.append("<PEDTYPE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPedtype()) ? "" : IGStringUtils.filterXMLStr(info.getPedtype()));
				sbf_xml.append("</PEDTYPE>");
				sbf_xml.append("<PEDBLID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPedblid()) ? "" : IGStringUtils.filterXMLStr(info.getPedblid()));
				sbf_xml.append("</PEDBLID>");
				sbf_xml.append("<PEDORDER>");
				sbf_xml.append(info.getPedorder() == null ? "" : info.getPedorder());
				sbf_xml.append("</PEDORDER>");
				sbf_xml.append("<PEDEC>");
				sbf_xml.append(StringUtils.isEmpty(info.getPedec()) ? "" : IGStringUtils.filterXMLStr(info.getPedec()));
				sbf_xml.append("</PEDEC>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG413>");
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
		List<IG413Info> lst_IG413 = new ArrayList<IG413Info>();
		IG413TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG413TBInstance();
			entity.setPedid(e.getChildText("PEDID"));
			entity.setPdid(e.getChildText("PDID"));
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setPedactionid(e.getChildText("PEDACTIONID"));
			entity.setPedtype(e.getChildText("PEDTYPE"));
			entity.setPedblid(e.getChildText("PEDBLID"));
			entity.setPedorder(StringUtils.isEmpty(e.getChildText("PEDORDER")) ? null : new Integer(e.getChildText("PEDORDER")));
			entity.setPedec(e.getChildText("PEDEC"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG413.add(entity);
		}
		this.ig413DAO.saveOrUpdateAll(lst_IG413);
	}
}
