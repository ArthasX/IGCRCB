/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.List;

import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.model.IG111Info;
import com.deliverik.framework.workflow.prd.model.condition.IG111SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG111SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG111DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG111TB;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程查询条件定义实体BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IG111BLImpl extends BaseBLImpl implements IG111BL{

	/** 流程查询条件定义实体DAO */
	protected IG111DAO ig111DAO;

	/**
	 * 流程查询条件定义实体DAO设定
	 * @param ig111DAO 流程查询条件定义实体DAO
	 */
	public void setIg111DAO(IG111DAO ig111dao) {
		ig111DAO = ig111dao;
	}
	
	/**
	 * 条件检索
	 * @param cond 检索条件
	 * @return 检索结果
	 * @throws BLException
	 */
	public List<IG111Info> searchIG111(IG111SearchCond cond) throws BLException {
		return ig111DAO.findByCond(cond,0,0);
	}
	
	/**
	 * 删除处理
	 * @param instance 删除实例
	 */
	public void deleteIG111(IG111Info instance) throws BLException {
		ig111DAO.delete(instance);
	}
	
	/**
	 * 取得下一个ID
	 * @param pdid 流程定义ID
	 * @return 实体ID
	 * @throws BLException
	 */
	public String getNextId(String pdid) throws BLException{
		return ig111DAO.getNextId(pdid);
	}
	
	/**
	 * 新增处理
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG111Info registIG111(IG111Info instance) throws BLException {
		return ig111DAO.save(instance);
	}
	
	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG111SearchCondImpl cond = new IG111SearchCondImpl();
		cond.setPdid(pdid);
		List<IG111Info> list = this.searchIG111(cond);
		StringBuffer sbf_xml = new StringBuffer();
		sbf_xml.append("<IG111>");
		sbf_xml.append("<DATALIST>");
		for(IG111Info info:list){
			sbf_xml.append("<DATA>");
			sbf_xml.append("<QID>");
			sbf_xml.append(info.getQid());
			sbf_xml.append("</QID>");
			sbf_xml.append("<PDID>");
			sbf_xml.append(info.getPdid());
			sbf_xml.append("</PDID>");
			sbf_xml.append("<QMODE>");
			sbf_xml.append(info.getQmode());
			sbf_xml.append("</QMODE>");
			sbf_xml.append("<QTYPE>");
			sbf_xml.append(info.getQtype());
			sbf_xml.append("</QTYPE>");
			sbf_xml.append("<QFLAG>");
			sbf_xml.append(info.getQflag());
			sbf_xml.append("</QFLAG>");
			sbf_xml.append("<QNAME>");
			sbf_xml.append(info.getQname());
			sbf_xml.append("</QNAME>");
			sbf_xml.append("<FINGERPRINT>");
			sbf_xml.append(info.getFingerPrint());
			sbf_xml.append("</FINGERPRINT>");
			sbf_xml.append("</DATA>");
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG111>");
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
		IG111TB entity = null;
		for(Element e : dataList) {
			entity = new IG111TB();
			entity.setQid(e.getChildText("QID"));
			entity.setPdid(e.getChildText("PDID"));
			entity.setQmode(e.getChildText("QMODE"));
			entity.setQtype(e.getChildText("QTYPE"));
			entity.setQflag(e.getChildText("QFLAG"));
			entity.setQname(e.getChildText("QNAME"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			this.registIG111(entity);
		}
	}

	/**
	 * 根据流程定义id删除 自定义查询条件
	 * 
	 * @param pdid
	 */
	public void deleteByPdid(String pdid) throws BLException {
		ig111DAO.deleteByPdid(pdid);
	}
}
