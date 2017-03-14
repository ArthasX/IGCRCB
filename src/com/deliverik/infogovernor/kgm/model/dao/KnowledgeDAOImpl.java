/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
 package com.deliverik.infogovernor.kgm.model.dao;

 import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.Type;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.kgm.bl.IGKGMCONSTANTS;
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCond;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeTB;


/**
 * ����: ֪ʶ����ϢDAOʵ��
 * ����������֪ʶ����ϢDAOʵ��
 * ������¼��wangxiaoqiang 2010/12/07
 * �޸ļ�¼��
 */
@SuppressWarnings({"deprecation","rawtypes"})
public class KnowledgeDAOImpl extends BaseHibernateDAOImpl<Knowledge> implements KnowledgeDAO {
   /**
    * ���캯��
    */
   public KnowledgeDAOImpl(){
       super(KnowledgeTB.class);
   }
   /**
    * ȫ������
    * @return ���������
    */
   public List<Knowledge> findAll() {
       return null;
   }
   /**
    * ������������
    * @param id ����
    * @return �������
    */
   public Knowledge findByPK(Serializable id) {
       Knowledge result = super.findByPK(id);
       if(result == null) return null;
       return result;
   }
   
   /**
    * ���������������ȡ��
    * @param cond ��������
    * @return �����������
    */
   public int getSearchNotCheckCount(final KnowledgeSearchCond cond){
       DetachedCriteria c = getCriteriaNotCheck(cond);
       return getCount(c);
   }
   
   /**
    * ���������������ȡ��
    * @param cond ��������
    * @return �����������
    */
   public int getSearchCount(final KnowledgeSearchCond cond){
       DetachedCriteria c = getCriteria(cond);
       return getCount(c);
   }
   
   /**
    * ֪ʶ���к�ȡ��ȡ��
    * @return ֪ʶ���к�ȡ��
    */
   public String getKnserial(){
	   String sql =  "select max(knserial) from KnowledgeTB ";
		NamedParamMap p = getNamedParamMap();
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 ) return null;
		return (String) l.get(0);
   }
   
   
   /**
    * ������������
    * @param cond ��������
    * @param start ������¼��ʼ�к�
    * @param count ������¼����
    * @return ��������б�
    */
   public List<Knowledge> findByCond(final KnowledgeSearchCond cond, final int start, final int count){
	   DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("knapprovetime"));
		List<Knowledge> ret = findByCriteria(c, start, count);
	       return ret;
   }
   
   /**
    * ����֪ʶid������ǰ��Ч֪ʶ����
    * @param cond ��������
    * @return ��������б�
    */
   public Knowledge findByKnid(final KnowledgeSearchCond cond){
	   DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("knversion"));
		List<Knowledge> ret = findByCriteria(c, 0, 0);
		if(ret !=null && ret.size()>0){
			return ret.get(0);
		}else{
			return null;
		}
	       
   }
   
   /**
    * ������������֪ʶ����ʷ�汾��ѯ��
    * @param cond ��������
    * @param start ������¼��ʼ�к�
    * @param count ������¼����
    * @return ��������б�
    */
   public List<Knowledge> findByCond_History(final KnowledgeSearchCond cond, final int start, final int count){
	   DetachedCriteria c = getCriteriaNotCheck(cond);
		c.addOrder(Order.desc("knversion"));
		List<Knowledge> ret = findByCriteria(c, start, count);
	       return ret;
   }
   
   /**
    * ��ѯknowledge���Ƿ���û���������ļ�¼
    * 
    * @param cond ��������
    * @return �����ü���������
    */
  
   protected DetachedCriteria getCriteriaNotCheck(KnowledgeSearchCond cond){
       DetachedCriteria c = getDetachedCriteria();

		//id
		if( StringUtils.isNotEmpty(cond.getKnid().toString())){
			c.add(Expression.eq("knid", cond.getKnid()));
		}
		//״̬����������ɾ����1OR4
		c.add(Expression.or(Expression.eq("knstatus", IGKGMCONSTANTS.KNOWLEDGE_APPROVEED), Expression.eq("knstatus", IGKGMCONSTANTS.KNOWLEDGE_DELETE)));
       return c;
   }
   
   /**
    * ������������
    * 
    * @param cond ��������
    * @return �����ü���������
    */
   protected DetachedCriteria getCriteria(KnowledgeSearchCond cond){
       DetachedCriteria c = getDetachedCriteria();
       //֪ʶ���
		if( StringUtils.isNotEmpty(cond.getKnserial_like())){
//			c.add(Expression.like("Upper(knserial)", "%" + cond.getKnserial_like().toUpperCase() + "%"));
			c.add(Expression.sql(" Upper(knserial) like "+"'%" + cond.getKnserial_like().toUpperCase() + "%'"));
		}
        //�û�
        if(null != cond.getKnid()){
        	if( StringUtils.isNotEmpty(String.valueOf(cond.getKnid()))){
    			c.add(Expression.eq("knid", cond.getKnid()));
    		}
        }
        //֪ʶ������
        if(cond.getKnapproverole()!=null&&!cond.getKnapproverole().equals(0)){
        	c.add(Expression.eq("knapproverole", cond.getKnapproverole()));
        }
        if(cond.getKnapproveroles()!=null&&cond.getKnapproveroles().length>0){
        	String sql = "";
        	Integer[] kars = cond.getKnapproveroles();
        	int j=0;
        	for(int i=0;i<kars.length;i++){
        		if(kars[i]!=null){
        			
        			if(j==0){
            			sql=" (knapproverole="+kars[i];
            		}else{
            			sql+=" or knapproverole="+kars[i];
            		}
        			j++;
        		}
        	}
        	if(j>0){
    			sql+=")";
    		}
        	c.add(Expression.sql(sql));
        }
        //�鵵������
		if( StringUtils.isNotEmpty(cond.getKnapprovername())){
//			c.add(Expression.like("knapprovername", "%" + cond.getKnapprovername() + "%"));
			c.add(Expression.sql(" Upper(knapprovername) like "+"'%" + cond.getKnapprovername().toUpperCase() + "%'"));
		}
		//֪ʶ����������
		if( StringUtils.isNotEmpty(cond.getKnproffername())){
//			c.add(Expression.like("knproffername", "%" + cond.getKnproffername() + "%"));
			c.add(Expression.sql(" Upper(knproffername) like "+"'%" + cond.getKnproffername().toUpperCase() + "%'"));
		}
		//����
		if( StringUtils.isNotEmpty(cond.getKnclass())){
			c.add(Expression.eq("knclass", cond.getKnclass()));
		}
		//״̬
		if( StringUtils.isNotEmpty(cond.getKnstatus())){
			c.add(Expression.in("knstatus", cond.getKnstatus().split(",")));
		}
		//�û�
		if( StringUtils.isNotEmpty(cond.getKnproffer())){
			c.add(Expression.eq("knproffer", cond.getKnproffer()));
		}
		//�鵵ʱ���
		if(StringUtils.isNotEmpty(cond.getKnapprovetime_f())){
			c.add(Expression.ge("knapprovetime", cond.getKnapprovetime_f()+" 00:00"));
		}
		//�鵵ʱ�䵽
		if(StringUtils.isNotEmpty(cond.getKnapprovetime_t())){
			c.add(Expression.le("knapprovetime", cond.getKnapprovetime_t()+" 23:59"));
		}
		//����ʱ���
		if(StringUtils.isNotEmpty(cond.getKnproffertime_f())){
			c.add(Expression.ge("knproffertime", cond.getKnproffertime_f()+" 00:00"));
		}
		//����ʱ�䵽
		if(StringUtils.isNotEmpty(cond.getKnproffertime_t())){
			c.add(Expression.le("knproffertime", cond.getKnproffertime_t()+" 23:59"));
		}
		//��Դ
		if(StringUtils.isNotEmpty(cond.getKnorigin())){
			c.add(Expression.eq("knorigin", cond.getKnorigin()));
		}
		//��������
		if(StringUtils.isNotEmpty(cond.getKntelarea())){
			c.add(Expression.eq("kntelarea", cond.getKntelarea()));
		}
		//�ؼ���
		String[] keys = cond.getKnkeys();
		String keylikesql ="";
		
		if(keys != null && keys.length>0){
			Type [] types = new Type[keys.length];
			for (int i = 0; i < keys.length; i++) {
				
				types[i] = Hibernate.STRING;
				if(i==0){
					keylikesql = keylikesql + " Upper(knkey) like ? ";
				}else{
					keylikesql = keylikesql + "  or Upper(knkey) like ? ";
				}
				
				keys[i] = "%" + keys[i].toUpperCase() + "%";

			}

			c.add(Restrictions.sqlRestriction(" ( " + keylikesql + " ) ", keys, types));
		}
		
		//���� ��֪ʶ����
		String[] kntitles = cond.getKntitles();
		String titlelikesql ="";
		//String deslikesql ="";
		
		if(kntitles != null && kntitles.length>0){
			Type [] types = new Type[kntitles.length*4];
			String [] value = new String[kntitles.length*4];
			for (int i = 0; i < kntitles.length*4; i=i+4) {
				
				
				if(i==0){
					titlelikesql = titlelikesql + " Upper(kntitle) like ?  or Upper(knfaultcause) like ? or Upper(knsolveway) like ? or Upper(kndes) like ?";
					//deslikesql = deslikesql + " kndes like ? ";
				}else{
					titlelikesql = titlelikesql + "  or Upper(kntitle) like ?  or Upper(knfaultcause) like ? or Upper(knsolveway) like ? or Upper(kndes) like ? ";
					//deslikesql = deslikesql + "  or kndes like ? ";
				}
				types[i] = Hibernate.STRING;
				types[i+1] = Hibernate.STRING;
				types[i+2] = Hibernate.STRING;
				types[i+3] = Hibernate.STRING;
				value[i] = "%" + kntitles[i/4].toUpperCase() + "%";
				value[i+1] = "%" + kntitles[i/4].toUpperCase() + "%";
				value[i+2] = "%" + kntitles[i/4].toUpperCase() + "%";
				value[i+3] = "%" + kntitles[i/4].toUpperCase() + "%";

			}
			
			c.add(Restrictions.sqlRestriction(" ( " + titlelikesql + " ) ", value, types));
			
			//c.add(Restrictions.sqlRestriction(" ( " + deslikesql + " ) ", kntitles, types));
		}

		
		
       return c;
   }
   
 
	/**
	 * ���ܣ���ȡָ��ID����
	 * @param knid���ID
	 * @return ��ǰID����
	 */
	public Integer getMaxVersion(Integer knid){
		String sql =  "SELECT knversion FROM KnowledgeVW  where knid = :knid";
		NamedParamMap p = getNamedParamMap();
		p.setInteger("knid", knid);
		List list = findByNamedParamMap(sql, p);
		if( list.size() == 0 ) return 0;
		if(list.get(0) == null)return 0;
		return  (Integer) list.get(0);
	}
	
	/**
	 * ���ܣ���ȡָ��ID����
	 * @param knid���ID
	 * @return ��ǰID����
	 */
	public Integer getMaxgKnid(){
		String sql =  "SELECT MAX(knid) FROM KnowledgeVW  where knid > :knid";
		NamedParamMap p = getNamedParamMap();
		p.setInteger("knid", Integer.valueOf("0"));
		List list = findByNamedParamMap(sql, p);
		if( list.size() == 0 ) return 0;
		if(list.get(0) == null)return 0;
		return  (Integer) list.get(0);
	}
	
}

