package com.deliverik.framework.bl;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCond;
import com.deliverik.framework.model.entity.CodeDetailDefTBPK;


/**
 * ������Ϣ�����߼��ӿ�
 * 
 */
public interface CodeDetailDefBL extends BaseBL{

	/**
	 * ������������
	 * 
	 * @param pk ����
	 * @return �������
	 */
	public CodeDetailDef searchCodeDetailDefByPK(CodeDetailDefTBPK pk);

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(CodeDetailDefSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CodeDetailDef> searchCodeDetailDef(CodeDetailDefSearchCond cond,int orderbyFlag);
	
	public List<CodeDetailDef> searchCodeDetailDef(CodeDetailDefSearchCond cond);

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CodeDetailDef> searchCodeDetailDef(CodeDetailDefSearchCond cond, 
			int start, int count, int orderbyFlag);

	/**
	 * �������ڼ�������
	 * 
	 * @param ccid �������ID
	 * @param pccid ���������ID
	 * @param pcid ������ID
	 * @return ��������
	 */
	public String getLastUpdate(String ccid, String pccid, String pcid);
	
	/**
	 * ��ѯ�¼��������
	 * @param syscoding ���������
	 * @return �¼��������
	 */
	
	public String getSyscoding(final String syscoding);
	
	/**
	 * ��ѯ�¼��������
	 * @param ccid ���ڵ��ʶ
	 * @return �¼��������
	 */
	
	public String getSyscodingLevel1(String ccid);
	
	/**
	 * ��ѯ�������cid
	 * @param ccid ���id
	 * @return �������cid
	 */
	
	public String getMaxcid(final String ccid);

	/**
	 * ��¼����
	 * 
	 * @param entity ��¼����
	 * @return ������Ϣ
	 */
	public CodeDetailDef registCodeDetailDef(CodeDetailDef codeDetail) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param entity ɾ������
	 * @return
	 */
	public void deleteCodeDetailDef(CodeDetailDef codeDetail) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param eid ɾ�����������Ϣ����
	 * @return
	 */
	public CodeDetailDef deleteCodeDetailDef(CodeDetailDefTBPK pk) throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param ccid ɾ���������CD
	 * @return
	 */
	public List<CodeDetailDef> deleteCodeDetailDef(String ccid) throws BLException;

	/**
	 * �������
	 * 
	 * @param entity �������
	 * @return ������Ϣ
	 */
	public CodeDetailDef updateCodeDetailDef(CodeDetailDef codeDetail) throws BLException;
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CodeDetailDef> searchCodeDetailDefTree(CodeDetailDefSearchCond cond,int orderbyFlag);
	
	/**
	 * ��ȡ������Ϣ
	 * @param ecategory �ʲ�����
	 * @param rccid ��ϵ�������ݷ����
	 * @return ��������б�
	 */
	public List<LabelValueBean> searchLabelValueBeanList(String ecategory,String rccid);
	
	/**
	 * ���ݲ�����ѯ�÷����µ�������ĩ��ҵ��ϵͳ����
	 * @param syscoding
	 * @return
	 */
	public List<CodeDetailDef> getFinalBusSys(String syscoding);

}
