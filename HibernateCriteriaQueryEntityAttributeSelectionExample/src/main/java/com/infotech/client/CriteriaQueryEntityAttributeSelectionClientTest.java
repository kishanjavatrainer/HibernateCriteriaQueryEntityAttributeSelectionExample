package com.infotech.client;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.infotech.entities.Employee;
import com.infotech.util.HibernateUtil;

public class CriteriaQueryEntityAttributeSelectionClientTest {

	public static void main(String[] args) {

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			CriteriaBuilder builder = session.getCriteriaBuilder();
		   CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);
			Root<Employee> root = criteriaQuery.from(Employee.class);
			criteriaQuery.select(root.get("employeeName"));
			
			 Query<String> createQuery = session.createQuery(criteriaQuery);
			 List<String> empNameList = createQuery.getResultList();
			 empNameList.forEach(System.out::println);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	
	}

}
