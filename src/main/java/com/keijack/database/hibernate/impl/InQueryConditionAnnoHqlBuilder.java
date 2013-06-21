package com.keijack.database.hibernate.impl;

import java.util.Collection;
import java.util.List;

import com.keijack.database.hibernate.hqlconditions.QueryCondition;

/**
 * 
 * @author Keijack
 * 
 */
public class InQueryConditionAnnoHqlBuilder extends
	QueryConditionAnnoHqlBuilder {

    /**
     * {@inheritDoc}
     */
    @Override
    public void generateHql(QueryCondition conditionAnno, Object param,
	    StringBuilder where, List<Object> params) {
	where.append(" and (1 = 0");
	for (Object obj : (Collection<?>) param) {
	    StringBuilder filedWithSqlFunction = getHqlFieldWithSqlFunction(conditionAnno);
	    where.append(" or ").append(filedWithSqlFunction).append(" = ?");
	    params.add(obj);
	}
	where.append(")");

    }

}