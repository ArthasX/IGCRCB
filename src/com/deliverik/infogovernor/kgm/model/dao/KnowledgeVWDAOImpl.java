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
import com.deliverik.infogovernor.kgm.model.Knowledge;
import com.deliverik.infogovernor.kgm.model.condition.KnowledgeSearchCond;
import com.deliverik.infogovernor.kgm.model.entity.KnowledgeVW;


/**
 * ����: ����֪ʶ��ϢDAOʵ��
 * ��������������֪ʶ��ϢDAOʵ��
 * ������¼��wangxiaoqiang 2010/12/07
 * �޸ļ�¼��
 */
public class KnowledgeVWDAOImpl extends BaseHibernateDAOImpl<Knowledge> implements KnowledgeVWDAO {
   /**
    * ���캯��
    */
   public KnowledgeVWDAOImpl(){
       super(KnowledgeVW.class);
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
   public Knowledge findByPK(Serializable pk) {
       Knowledge result = super.findByPK(pk);
       if(result == null) return null;
       return result;
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
    * ������������
    * 
    * @param cond ��������
    * @return �����ü���������
    */
   protected DetachedCriteria getCriteria(KnowledgeSearchCond cond){
       DetachedCriteria c = getDetachedCriteria();
        //�鵵������
		if( StringUtils.isNotEmpty(cond.getKnapprovername())){
			c.add(Expression.like("knapprovername", "%" + cond.getKnapprovername() + "%"));
		}
		//֪ʶ����������
		if( StringUtils.isNotEmpty(cond.getKnproffername())){
			c.add(Expression.like("knproffername", "%" + cond.getKnproffername() + "%"));
		}
		//����
		if( StringUtils.isNotEmpty(cond.getKnclass())){
			c.add(Expression.eq("knclass", cond.getKnclass()));
		}
		//��Դ
		if( StringUtils.isNotEmpty(cond.getKnorigin())){
			c.add(Expression.eq("knorigin", cond.getKnorigin()));
		}
		//��������
		if( StringUtils.isNotEmpty(cond.getKntelarea())){
			c.add(Expression.eq("kntelarea", cond.getKntelarea()));
		}
		//ҵ������
		if( StringUtils.isNotEmpty(cond.getKnarea())){
			c.add(Expression.eq("knarea", cond.getKnarea()));
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
		//�ؼ���
		String[] keys = cond.getKnkeys();
		String keylikesql ="";
		
		if(keys != null && keys.length>0){
			Type [] types = new Type[keys.length];
			for (int i = 0; i < keys.length; i++) {
				
				types[i] = Hibernate.STRING;
				if(i==0){
					keylikesql = keylikesql + " knkey like ? ";
				}else{
					keylikesql = keylikesql + "  or knkey like ? ";
				}
				
				keys[i] = "%" + keys[i] + "%";

			}

			c.add(Restrictions.sqlRestriction(" ( " + keylikesql + " ) ", keys, types));
		}
		
		//���� ��֪ʶ����
		String[] kntitles = cond.getKntitles();
		String titlelikesql ="";
		String deslikesql ="";
		
		if(kntitles != null && kntitles.length>0){
			Type [] types = new Type[kntitles.length*2];
			String [] value = new String[kntitles.length*2];
			for (int i = 0; i < kntitles.length*2; i=i+2) {
				if(i==0){
					titlelikesql = titlelikesql + " kntitle like ?  or kndes like ?";
				}else{
					titlelikesql = titlelikesql + "  or kntitle like ?  or kndes like ? ";
				}
				types[i] = Hibernate.STRING;
				types[i+1] = Hibernate.STRING;
				value[i] = "%" + kntitles[i/2] + "%";
				value[i+1] = "%" + kntitles[i/2] + "%";

			}		
			c.add(Restrictions.sqlRestriction(" ( " + titlelikesql + " ) ", value, types));
		}
       return c;
   }
   
}

