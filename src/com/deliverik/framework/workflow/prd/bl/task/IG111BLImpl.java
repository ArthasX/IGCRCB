/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̲�ѯ��������ʵ��BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IG111BLImpl extends BaseBLImpl implements IG111BL{

	/** ���̲�ѯ��������ʵ��DAO */
	protected IG111DAO ig111DAO;

	/**
	 * ���̲�ѯ��������ʵ��DAO�趨
	 * @param ig111DAO ���̲�ѯ��������ʵ��DAO
	 */
	public void setIg111DAO(IG111DAO ig111dao) {
		ig111DAO = ig111dao;
	}
	
	/**
	 * ��������
	 * @param cond ��������
	 * @return �������
	 * @throws BLException
	 */
	public List<IG111Info> searchIG111(IG111SearchCond cond) throws BLException {
		return ig111DAO.findByCond(cond,0,0);
	}
	
	/**
	 * ɾ������
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG111(IG111Info instance) throws BLException {
		ig111DAO.delete(instance);
	}
	
	/**
	 * ȡ����һ��ID
	 * @param pdid ���̶���ID
	 * @return ʵ��ID
	 * @throws BLException
	 */
	public String getNextId(String pdid) throws BLException{
		return ig111DAO.getNextId(pdid);
	}
	
	/**
	 * ��������
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG111Info registIG111(IG111Info instance) throws BLException {
		return ig111DAO.save(instance);
	}
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
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
	 * XML�ű����봦��
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
	 * �������̶���idɾ�� �Զ����ѯ����
	 * 
	 * @param pdid
	 */
	public void deleteByPdid(String pdid) throws BLException {
		ig111DAO.deleteByPdid(pdid);
	}
}
