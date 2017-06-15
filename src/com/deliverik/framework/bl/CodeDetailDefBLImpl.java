package com.deliverik.framework.bl;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCond;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCondImpl;
import com.deliverik.framework.model.dao.CodeDetailDefTBDAO;
import com.deliverik.framework.model.entity.CodeDetailDefTBPK;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;

/**
 * ������Ϣ�����߼�ʵ��
 * 
 * @author 
 */
public class CodeDetailDefBLImpl extends BaseBLImpl implements CodeDetailDefBL {

	/** CodeDetailTB DAO */
	protected CodeDetailDefTBDAO codeDetailDefTBDAO;

	

	/**
	 * ������������
	 * 
	 * @param pk ����
	 * @return �������
	 */
	public CodeDetailDef searchCodeDetailDefByPK(CodeDetailDefTBPK pk) {
		return codeDetailDefTBDAO.findByPK(pk);
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getSearchCount(CodeDetailDefSearchCond cond){

		return codeDetailDefTBDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CodeDetailDef> searchCodeDetailDef(CodeDetailDefSearchCond cond,int orderbyFlag){

		List<CodeDetailDef> ret = codeDetailDefTBDAO.findByCond(cond,0,0,orderbyFlag);
		return ret;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CodeDetailDef> searchCodeDetailDef(CodeDetailDefSearchCond cond){

		List<CodeDetailDef> ret = codeDetailDefTBDAO.findByCond(cond);
		return ret;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CodeDetailDef> searchCodeDetailDefTree(CodeDetailDefSearchCond cond,int orderbyFlag){
		List<CodeDetailDef> ret = codeDetailDefTBDAO.findByCond(cond,orderbyFlag);
		return ret;
	}
	
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<CodeDetailDef> searchCodeDetailDef(CodeDetailDefSearchCond cond, 
			int start, int count ,int orderbyFlag){

		List<CodeDetailDef> ret = codeDetailDefTBDAO.findByCond(cond,start,count,orderbyFlag);
		return ret;
	}
	
	/**
	 * �������ڼ�������
	 * 
	 * @param ccid �������ID
	 * @param pccid ���������ID
	 * @param pcid ������ID
	 * @return ��������
	 */
	public String getLastUpdate(String ccid, String pccid, String pcid){
		return this.codeDetailDefTBDAO.getLastUpdate(ccid, pccid, pcid);
	}
	
	/**
	 * ��ѯ�¼��������
	 * @param syscoding ���������
	 * @return �¼��������
	 */
	
	public String getSyscoding(String syscoding){
		return this.codeDetailDefTBDAO.getSyscoding(syscoding);
	}
	
	/**
	 * ��ѯ�¼��������
	 * @param ccid ���ڵ��ʶ
	 * @return �¼��������
	 */
	
	public String getSyscodingLevel1(String ccid){
		return this.codeDetailDefTBDAO.getSyscodingLevel1(ccid);
	}
	
	/**
	 * ��ѯ�������cid
	 * @param ccid ���id
	 * @return �������cid
	 */
	
	public String getMaxcid(final String ccid){
		return this.codeDetailDefTBDAO.getMaxcid(ccid);
	}

	/**
	 * ��¼����
	 * 
	 * @param codeDetail ��¼����
	 * @return ������Ϣ
	 */
	public CodeDetailDef registCodeDetailDef(CodeDetailDef codeDetail) throws BLException{
		CodeDetailDefTBPK pk = new CodeDetailDefTBPK();
		pk.setCcid(codeDetail.getCcid());
		pk.setCid(codeDetail.getCid());

		checkNotExistCodeDetailDef(pk);
		
		CodeDetailDef ret = codeDetailDefTBDAO.save(codeDetail);
		return ret;
	}

	/**
	 * ɾ������
	 * 
	 * @param codeDetail ɾ������
	 * @return
	 */
	public void deleteCodeDetailDef(CodeDetailDef codeDetailDef) throws BLException{
		CodeDetailDefTBPK pk = new CodeDetailDefTBPK();
		pk.setCcid(codeDetailDef.getCcid());
		pk.setCid(codeDetailDef.getCid());

		checkExistCodeDetailDef(pk);
		
		codeDetailDefTBDAO.delete(codeDetailDef);
	}

	/**
	 * ɾ������
	 * 
	 * @param pk ɾ�����������Ϣ����
	 * @return
	 */
	public CodeDetailDef deleteCodeDetailDef(CodeDetailDefTBPK pk) throws BLException{
		CodeDetailDef info = checkExistCodeDetailDef(pk);
		codeDetailDefTBDAO.delete(info);
		
		return info;
	}

	/**
	 * ɾ������
	 * 
	 * @param ccid ɾ���������CD
	 * @return
	 */
	public List<CodeDetailDef> deleteCodeDetailDef(String ccid) throws BLException {
		CodeDetailDefSearchCondImpl cond = new CodeDetailDefSearchCondImpl();
		cond.setCcid(ccid);
		List<CodeDetailDef> infoList = codeDetailDefTBDAO.findByCond(cond, 0, 0, 0);
		
		codeDetailDefTBDAO.delete(infoList);
		
		return infoList;
	}

	/**
	 * �������
	 * 
	 * @param codeDetail �������
	 * @return ������Ϣ
	 */
	public CodeDetailDef updateCodeDetailDef(CodeDetailDef codeDetail) throws BLException{
		CodeDetailDefTBPK pk = new CodeDetailDefTBPK();
		pk.setCcid(codeDetail.getCcid());
		pk.setCid(codeDetail.getCid());

		checkExistCodeDetailDef(pk);
		
		CodeDetailDef ret = codeDetailDefTBDAO.save(codeDetail);
		return ret;
	}


	/**
	 * ������Ϣ�����ڼ��
	 * 
	 * @param pk ������Ϣ����
	 * @return
	 * @throws BLException 
	 */
	protected void checkNotExistCodeDetailDef(CodeDetailDefTBPK pk) throws BLException{

		CodeDetailDef info = this.codeDetailDefTBDAO.findByPK(pk);
		if( info != null ) {
			throw new BLException(BLErrorType.CODEDETAIL_ALREADY_EXISTS_ERROR,
					"IGCO10000.E003","����");
		}
	}
	
	/**
	 * ������Ϣ���ڼ��
	 * 
	 * @param pk ������Ϣ����
	 * @return ������Ϣ
	 * @throws BLException 
	 */
	protected CodeDetailDef checkExistCodeDetailDef(CodeDetailDefTBPK pk) throws BLException{
		CodeDetailDef info = this.codeDetailDefTBDAO.findByPK(pk);
		if( info == null) {
			throw new BLException(BLErrorType.CODEDETAIL_NOT_EXISTS_ERROR,
					"IGCO10000.E004","����");
		}
		
		return info;
	}
	
	/**
	 * ��ȡ������Ϣ
	 * @param ecategory �ʲ�����
	 * @param rccid ��ϵ�������ݷ����
	 * @return ��������б�
	 */
	public List<LabelValueBean> searchLabelValueBeanList(String ecategory,String rccid){
		CodeDetailDefSearchCondImpl cond = new CodeDetailDefSearchCondImpl();
		cond.setCcid(rccid);
		cond.setBusinesscode_like(ecategory);
		List<CodeDetailDef> ret = this.searchCodeDetailDef(cond, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		//�����豸�����Ĺ�ϵ
		if(CommonDefineUtils.ENTIY_CATEGORY_DEVICE.equals(ecategory)){
			for(int i=0; i<ret.size(); i++){
				if(CommonDefineUtils.CONTAINER_DEVICE_ASSIGN_RELATION_CODE.equals(ret.get(i).getBusinesscode())){
					ret.remove(i);
				}
			}
		}
		List<LabelValueBean> list = new ArrayList<LabelValueBean>();
		list.add(new LabelValueBean("", ""));
		for(CodeDetailDef cd : ret){
			if(!ecategory.equals(CommonDefineUtils.ENTIY_CATEGORY_MODULE)){
				if(cd.getBusinesscode().indexOf(CommonDefineUtils.ENTIY_CATEGORY_MODULE)>-1){
					continue;
				}
			}
			list.add(new LabelValueBean(cd.getCvalue(), cd.getCid()+"#"+cd.getBusinesscode()));
		}
		return list;
	}

	public void setCodeDetailDefTBDAO(CodeDetailDefTBDAO codeDetailDefTBDAO) {
		this.codeDetailDefTBDAO = codeDetailDefTBDAO;
	}
	
	/**
	 * ���ݲ�����ѯ�÷����µ�������ĩ��ҵ��ϵͳ����
	 * @param syscoding
	 * @return
	 */
	public List<CodeDetailDef> getFinalBusSys(String syscoding){
		return this.codeDetailDefTBDAO.getFinalBusSys(syscoding);
	}

}
