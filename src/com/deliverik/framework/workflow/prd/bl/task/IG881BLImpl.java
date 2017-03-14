/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.model.IG100Info;
import com.deliverik.framework.workflow.prd.model.IG881Info;
import com.deliverik.framework.workflow.prd.model.condition.IG100SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG881SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG881SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG881DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG881TB;

/**
 * <p>概述:流程参与者变量权限业务逻辑实现</p>
 * <p>功能描述：1.条件检索结果件数取得</p>
 * <p>          2.主键检索处理</p>
 * <p>          3.全部检索处理</p>
 * <p>          4.条件检索处理</p>
 * <p>          5.登录处理</p>
 * <p>          6.按主键删除处理</p>
 * <p>          7.删除处理</p>
 * <p>          8.变更处理</p>
 * <p>          9.流程参与者变量权限存在检查</p>
 * <p>创建记录：</p>
 */
public class IG881BLImpl extends BaseBLImpl implements IG881BL{
	
	/** ig881DAO DAO */
	protected IG881DAO ig881DAO;
	
	/**
	 * 功能：流程参与者变量权限定义DAO
	 * 
	 * @param ig881DAO 流程参与者变量权限定义DAO
	 */
	public void setIg881DAO(
			IG881DAO ig881DAO) {
		this.ig881DAO = ig881DAO;
	}

	/**
	 * 功能：获取流程变量定义实例
	 * @return IG881TB
	 */
	
	public IG881TB getIG881TBInstance(){
		return new IG881TB();
	}

	/**
	 * 功能：条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getIG881InfoSearchCount(IG881SearchCond cond){
		
		return ig881DAO.getSearchCount(cond);
	}

	/**
	 * 功能：主键检索处理
	 * 
	 * @param pipdid 流程参与者变量权限ID
	 * @return 流程参与者变量权限
	 */
	public IG881Info searchIG881InfoByKey(String pipdid) throws BLException{
		
		return checkExistProcessInfoParticipantDef(pipdid);
	}
	
	/**
	 * 功能：全部检索处理
	 *
	 * @return 全部流程参与者变量权限信息
	 */
	public List<IG881Info> searchIG881Info(IG881SearchCond cond){
		
		return ig881DAO.findByCond(cond,0,0);
	}

	/**
	 * 功能：条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG881Info> searchIG881Info(IG881SearchCond cond, int start, int count){
		
		return ig881DAO.findByCond(cond,start,count);
	}

	/**
	 * 功能：登录处理
	 * 
	 * @param Ig881 登录数据
	 * @return 流程参与者变量权限
	 */
	public IG881Info registIG881Info(IG881Info ig881Info) throws BLException{
		
		return ig881DAO.save(ig881Info);
	}

	/**
	 * 功能：删除处理
	 * 
	 * @param pipdid 删除对象流程参与者主键
	 */
	public void deleteIG881InfoByKey(String pipdid) throws BLException{
		
		IG881Info processInfoParticipantDef = checkExistProcessInfoParticipantDef(pipdid);
		
		ig881DAO.delete(processInfoParticipantDef);
	}

	/**
	 * 功能：删除处理
	 * 
	 * @param IG881 删除对象流程参与者
	 */
	public void deleteIG881Info(IG881Info ig881Info) throws BLException{
		IG881Info pid = checkExistProcessInfoParticipantDef(ig881Info.getPipdid());
		
		ig881DAO.delete(pid);
	}
	/**
	 * 功能：变更处理
	 * 
	 * @param IG881 变更数据
	 * @return 流程参与者变量权限
	 */
	public IG881Info updateIG881Info(IG881Info ig881Info) throws BLException{
		
		checkExistProcessInfoParticipantDef(ig881Info.getPipdid());
		return ig881DAO.save(ig881Info);
	}

	/**
	 * 功能：流程参与者变量权限存在检查
	 * 
	 * @param pipdid 流程参与者变量权限ID
	 * @return 流程参与者变量权限
	 * @throws BLException 
	 */
	protected IG881Info checkExistProcessInfoParticipantDef(String pipdid) throws BLException{
		IG881Info info = ig881DAO.findByPK(pipdid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","流程参与者变量权限基本");
		}
		return info;
	}
	
	/**
	 * 流程参与者变量权限视图查询
	 * 
	 * @param cond 查询条件
	 * @return 流程参与者变量权限
	 * @throws BLException 
	 */
	public List<IG100Info> searchIG100Info(IG100SearchCond cond)
		throws BLException{
		return ig881DAO.findByCond(cond);
	}
	
	/**
	 * PIPDID主键值取得
	 * 
	 * @param 流程状态参与者定义ID
	 * @return PIPDID主键值
	 */
	public String getPipdidSequenceNextValue(String ppdid) {
		return ig881DAO.getPipdidSequenceNextValue(ppdid);
	}
	
	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG881SearchCondImpl cond = new IG881SearchCondImpl();
		cond.setPipdid_like(pdid);
		List<IG881Info> lst_IG881Info = this.searchIG881Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG881>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG881Info != null) {
			for(IG881Info info : lst_IG881Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PIPDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPipdid()) ? "" : IGStringUtils.filterXMLStr(info.getPipdid()));
				sbf_xml.append("</PIPDID>");
				sbf_xml.append("<PIDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidid()) ? "" : IGStringUtils.filterXMLStr(info.getPidid()));
				sbf_xml.append("</PIDID>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<PPDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPpdid()) ? "" : IGStringUtils.filterXMLStr(info.getPpdid()));
				sbf_xml.append("</PPDID>");
				sbf_xml.append("<PIDACCESS>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidaccess()) ? "" : IGStringUtils.filterXMLStr(info.getPidaccess()));
				sbf_xml.append("</PIDACCESS>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("<PIDREQUIRED>");
				sbf_xml.append(StringUtils.isEmpty(info.getPidrequired()) ? "" : IGStringUtils.filterXMLStr(info.getPidrequired()));
				sbf_xml.append("</PIDREQUIRED>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG881>");
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
		List<IG881Info> lst_IG881 = new ArrayList<IG881Info>();
		IG881TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG881TBInstance();
			entity.setPipdid(e.getChildText("PIPDID"));
			entity.setPidid(e.getChildText("PIDID"));
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setPpdid(e.getChildText("PPDID"));
			entity.setPidaccess(e.getChildText("PIDACCESS"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			entity.setPidrequired(e.getChildText("PIDREQUIRED"));
			lst_IG881.add(entity);
		}
		this.ig881DAO.saveOrUpdateAll(lst_IG881);
	}
}
