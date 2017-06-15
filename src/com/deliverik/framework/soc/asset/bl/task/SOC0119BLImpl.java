package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.dao.SOC0119DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
import com.deliverik.framework.utility.IGStringUtils;


/**
 * �ʲ���ϵҵ���߼�ʵ��
 * 
 * @author 
 */
public class SOC0119BLImpl extends BaseBLImpl implements SOC0119BL {

	/** EntityItemRelation DAO */
	protected SOC0119DAO soc0119DAO;
	
	/**
	 * EntityItemRelationDAO�趨
	 *
	 * @param soc0119DAO EntityItemRelationDAO
	 */
	public void setSoc0119DAO(SOC0119DAO soc0119DAO) {
		this.soc0119DAO = soc0119DAO;
	}

	/**
	 * ����eiidɾ����ϵ����
	 * @param eiid
	 */
	public void delByEiid(Integer eiid)throws BLException{
		this.soc0119DAO.delByEiid(eiid);
	}
	/**
	 * ����eiidɾ����ϵ����
	 * @param eiid
	 */
	public void delByEiid(Integer eiid,String eirrelationcode)throws BLException{
		this.soc0119DAO.delByEiid( eiid, eirrelationcode);
	}
	/**
	 * <p>
	 * �µ��ʲ���ϵ��Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ��ʲ���ϵ��Ϣ����ʵ��ȡ��
	 */

	public SOC0119TB getEntityItemRelationTBInstance() {
		return new SOC0119TB();
	}

	/**
	 * ���ݼ�������ȡ���ʲ���ϵ��Ϣ�������
	 * 
	 * @param cond �ʲ���ϵ��Ϣ��������
	 * @return �ʲ���ϵ��Ϣ�������
	 */
	public int getEntityItemRelationSearchCount(SOC0119SearchCond cond){

		return soc0119DAO.getSearchCount(cond);
	}

	
	/**
	 * �����ʲ���ϵ��Ϣ����ȡ���ʲ���ϵ��Ϣ
	 * 
	 * @param eirid �ʲ���ϵ��Ϣ����
	 * @return �ʲ���ϵ��Ϣ
	 * @throws BLException 
	 */
	public SOC0119Info searchEntityItemRelationByKey(Integer eirid) throws BLException{

		return checkExistEntityItemRelation(eirid);
	}
	
	/**
	 * ���ݼ�������ȡ���ʲ���ϵ��Ϣ�б�
	 * 
	 * @param cond �ʲ���ϵ��Ϣ��������
	 * @return �ʲ���ϵ��Ϣ��������б�
	 */

	public List<SOC0119Info> searchEntityItemRelation(SOC0119SearchCond cond){

		List<SOC0119Info> ret = soc0119DAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * ���ݼ�������ȡ���ʲ���ϵ��Ϣ�б�
	 * 
	 * @param cond �ʲ���ϵ��Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ���ϵ��Ϣ��������б�
	 */
	public List<SOC0119Info> searchEntityItemRelation(SOC0119SearchCond cond, int start, int count){

		List<SOC0119Info> ret = soc0119DAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * �����ʲ���ϵ��Ϣ����
	 * 
	 * @param entityItemRelation ������ʲ���ϵ��Ϣ����
	 * @return �ʲ���ϵ��Ϣ
	 * @throws BLException 
	 */
	public SOC0119Info registEntityItemRelation(SOC0119Info entityItemRelation) throws BLException{
		//checkNotExistEntityItemRelation(entityItemRelation.getPareiid(),entityItemRelation.getCldeiid());
		SOC0119Info ret = soc0119DAO.save(entityItemRelation);
		return ret;
	}

	/**
	 * ����ʲ���ϵ��Ϣ����
	 * 
	 * @param entityItemRelation ������ʲ���ϵ��Ϣ����
	 * @return �ʲ���ϵ��Ϣ
	 * @throws BLException 
	 */
	public SOC0119Info updateEntityItemRelation(SOC0119Info entityItemRelation) throws BLException{
		checkExistEntityItemRelation(entityItemRelation.getEirid());
		SOC0119Info ret = soc0119DAO.save(entityItemRelation);
		return ret;
	}
	
	/**
	 * �ʲ���ϵ��Ϣ�汾��������
	 * 
	 * @param eiid ����ʲ�ID
	 * @param eiversion ��ϵ�����ʲ����´�汾
	 * @param eismallversion �رձ����ʲ�����С�汾
	 * @param neweiversion �ʲ����´�汾
	 * @param neweismallversion �ʲ�����С�汾
	 * @throws BLException 
	 */
	public void upgradeEntityItemRelation(Integer eiid, Integer eiversion, Integer eismallversion,
			Integer neweiversion, Integer neweismallversion) throws BLException {
		//��ǰʱ��
		String dataTime = IGStringUtils.getCurrentDateTime();
		//������ϵ�����ʲ����°汾��ϵ������
		SOC0119SearchCondImpl condPar = new SOC0119SearchCondImpl();
		condPar.setPareiid(eiid);//�ʲ�ID
		condPar.setParversion(eiversion);//�ʲ���汾
		condPar.setParsmallversion(eismallversion);//�ʲ�С�汾
		List<SOC0119Info> eirList = this.searchMaxEntityItemRelation(condPar);
		SOC0119TB eirTB = null;
		for(SOC0119Info eir : eirList) {
			eirTB = (SOC0119TB)SerializationUtils.clone(eir);
			eirTB.setEirid(null);
			eirTB.setParversion(neweiversion);
			eirTB.setParsmallversion(neweismallversion);
			eirTB.setEirupdtime(dataTime);
			this.soc0119DAO.save(eirTB);
		}
		//������ϵ�����ʲ����°汾��ϵ������
		SOC0119SearchCondImpl condCld = new SOC0119SearchCondImpl();
		condCld.setCldeiid(eiid);//�ʲ�ID
		condCld.setCldversion(eiversion);//�ʲ���汾
		condCld.setCldsmallversion(eismallversion);//�ʲ�С�汾
		eirList = this.searchMaxEntityItemRelation(condCld);
		for(SOC0119Info eir : eirList) {
			eirTB = (SOC0119TB)SerializationUtils.clone(eir);
			eirTB.setEirid(null);
			eirTB.setCldversion(neweiversion);
			eirTB.setCldsmallversion(neweismallversion);
			eirTB.setEirupdtime(dataTime);
			this.soc0119DAO.save(eirTB);
		}
		
	}

	/**
	 * ɾ���ʲ���ϵ��Ϣ����
	 * 
	 * @param entityItemRelation ɾ�����ʲ���ϵ��Ϣ����
	 * @return
	 * @throws BLException 
	 */
	public void deleteEntityItemRelation(SOC0119Info entityItemRelation) throws BLException{
		checkExistEntityItemRelation(entityItemRelation.getEirid());
		soc0119DAO.delete(entityItemRelation);
	}

	/**
	 * �ʲ���ϵ��Ϣ�����ڼ��
	 * 
	 * @param pareiid �ʲ�ID������
	 * @param cldeiid �ʲ�ID������
	 * @throws BLException 
	 */
	protected void checkNotExistEntityItemRelation(Integer pareiid, Integer cldeiid) throws BLException{
		SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
		
		cond.setPareiid(pareiid);
		cond.setCldeiid(cldeiid);
		
		List<SOC0119Info> infoList = soc0119DAO.findByCond(cond, 0, 0);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException("IGCO10000.E003","�ʲ���ϵ");
		}
	}
	
	/**
	 * �ʲ���ϵ��Ϣ���ڼ��
	 * 
	 * @param eirid �ʲ���ϵ��ϢID
	 * @return �ʲ���ϵ��Ϣ
	 * @throws BLException 
	 */
	protected SOC0119Info checkExistEntityItemRelation(Integer eirid) throws BLException{
		SOC0119Info info = soc0119DAO.findByPK(eirid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","�ʲ���ϵ");
		}
		
		return info;
	}
	/**
	 * �����ʲ���ϵ��Ϣ����ɾ���ʲ���ϵ��Ϣ����
	 * 
	 * @param eirid ɾ���ʲ���ϵ��Ϣ������
	 * @return
	 * @throws BLException
	 */

	public void deleteEntityItemRelationByKey(Integer eirid) throws BLException {
		SOC0119Info entityItemRelation = checkExistEntityItemRelation(eirid);
		soc0119DAO.delete(entityItemRelation);
		
	}
	
	/**
	 * �ʲ���ϵ���汾����
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0119Info> searchMaxEntityItemRelation(SOC0119SearchCond cond) {
		return this.soc0119DAO.searchMaxEntityItemRelation(cond);
	}

	public List<SOC0119Info> searchMaxEntityItemRelation(
			SOC0119SearchCond cond, int start, int count) {
		return this.soc0119DAO.searchMaxEntityItemRelation(cond, start, count);
	}
	
	/**
	 * ����eiid ��ѯ������ص�eiid
	 * @param eiid
	 * @return
	 */
	public List<Integer> searchRelationByEiid(SOC0119SearchCond cond) throws BLException{
		return this.soc0119DAO.searchRelationByEiid(cond);
	}
	
	/**
	 * ���������ϵ��ѯ
	 * @param cond
	 * @return
	 */
	public List<Integer> searchCldeiidByPareiid(final SOC0119SearchCond cond)throws BLException{
		return this.soc0119DAO.searchCldeiidByPareiid(cond);
	}

	/**
	 * ��ͬ-�����ϵ����
	 * @param eiid
	 * @param eiversion
	 * @param eismallversion
	 * @param version
	 * @param i
	 * @param cldeiids
	 */
	public void upgradeEntityItemRelationOne(Integer eiid, Integer eiversion,
			Integer eismallversion, int neweiversion, int neweismallversion, String[] cldeiids)
			throws BLException {
		//��ǰʱ��
		String dataTime = IGStringUtils.getCurrentDateTime();
		//������ϵ�����ʲ����°汾��ϵ������
		SOC0119SearchCondImpl condPar = new SOC0119SearchCondImpl();
		condPar.setPareiid(eiid);//�ʲ�ID
		condPar.setParversion(eiversion);//�ʲ���汾
		condPar.setParsmallversion(eismallversion);//�ʲ�С�汾
		condPar.setDeleteflag("0");
		List<SOC0119Info> eirList = this.searchEntityItemRelation(condPar);
		SOC0119TB eirTB = null;
		for(SOC0119Info eir : eirList) {
			eirTB = (SOC0119TB)SerializationUtils.clone(eir);
			eirTB.setEirid(null);
			eirTB.setParversion(neweiversion);
			eirTB.setParsmallversion(neweismallversion);
			eirTB.setEirupdtime(dataTime);
			eirTB.setDeleteflag("0");
			//��ģʽ
			if("C".equals(eir.getEirstatus())) {
				if(cldeiids!=null&&cldeiids.length>0){
					for(int i=0;i<cldeiids.length;i++){
						if(StringUtils.isNotEmpty(cldeiids[i])){
							String cldeiid=cldeiids[i].split("_")[0];
							String cldversion=cldeiids[i].split("_")[1];
							String cldsmallversion=cldeiids[i].split("_")[2];
							String ciid="_"+cldeiids[i].split("_")[3]+"_";
							//�ж��Ƿ����������ʲ�
							if(cldeiid.equals(eirTB.getCldeiid().toString())&&eirTB.getEirinfo().indexOf(ciid)!=-1){
								eirTB.setCldversion(Integer.parseInt(cldversion));
								eirTB.setCldsmallversion(Integer.parseInt(cldsmallversion));
								break;
							}
						}
					}
				}
			} else {
				eirTB.setCldversion(eirTB.getCldEntityItemVW().getEiversion());
				eirTB.setCldsmallversion(eirTB.getCldEntityItemVW().getEismallversion());
			}
			this.soc0119DAO.save(eirTB);
		}
		
	}
	
	/**
	 * ������ģʽ��ϵ
	 * @param eiid
	 * @param eiversion
	 * @param eismallversion
	 * @param version
	 * @param i
	 * @param cldeiids
	 */
	public void upgradeEntityItemRelationByJiFang(Integer eiid, Integer eiversion,
			Integer eismallversion, int neweiversion, int neweismallversion)
			throws BLException {
		//��ǰʱ��
		String dataTime = IGStringUtils.getCurrentDateTime();
		//������ϵ�����ʲ����°汾��ϵ������
		SOC0119SearchCondImpl condPar = new SOC0119SearchCondImpl();
		condPar.setPareiid(eiid);//�ʲ�ID
		condPar.setParversion(eiversion);//�ʲ���汾
		condPar.setParsmallversion(eismallversion);//�ʲ�С�汾
		condPar.setDeleteflag("0");
		List<SOC0119Info> eirList = this.searchEntityItemRelation(condPar);
		SOC0119TB eirTB = null;
		for(SOC0119Info eir : eirList) {
			//��ģʽ
			if(!"C".equals(eir.getEirstatus())) {
				eirTB = (SOC0119TB)SerializationUtils.clone(eir);
				eirTB.setEirid(null);
				eirTB.setParversion(neweiversion);
				eirTB.setParsmallversion(neweismallversion);
				eirTB.setEirupdtime(dataTime);
				eirTB.setDeleteflag("0");
				eirTB.setCldversion(eirTB.getCldEntityItemVW().getEiversion());
				eirTB.setCldsmallversion(eirTB.getCldEntityItemVW().getEismallversion());
				this.soc0119DAO.save(eirTB);
			}
		}
		
	}

	/**
     * ���ݼ�������ȡ���ʲ���ϵ��Ϣ�б�
     * 
     * @param cond �ʲ���ϵ��Ϣ��������
     * @return �ʲ���ϵ��Ϣ��������б�
     */
    public List<SOC0119Info> searchEntityItemRelationBySql(SOC0119SearchCond cond,int start, int count){

        List<SOC0119Info> ret = soc0119DAO.findByCondBySql(cond,start,count);
        return ret;
    }
    
    /**
   	 * ����eiid_in ��ѯ������ص�eiid
   	 * @param eiid
   	 * @return
   	 */
   	public List<Integer> searchRelationByEiid_in(final SOC0119SearchCond cond){
   		return soc0119DAO.searchRelationByEiid_in(cond);
   	}
}
