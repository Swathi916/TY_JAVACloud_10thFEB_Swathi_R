package com.tyss.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tyss.springmvc.beans.EmployeeInfoBean;
import com.tyss.springmvc.beans.Login;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public EmployeeInfoBean getEmployee(Integer empId) {
		EntityManager manager = factory.createEntityManager();
		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, empId);
		manager.close();
		
		return employeeInfoBean;
		
	}

	@Override
	public void addEmp(EmployeeInfoBean employee) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction =manager.getTransaction();
		transaction.begin();
		manager.persist(employee);
		transaction.commit();
		manager.close();
	     
	}

	@Override
	public List<EmployeeInfoBean> getAllEmp() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<EmployeeInfoBean> typedQuery = manager.createQuery("from employee_info",EmployeeInfoBean.class);
		List<EmployeeInfoBean> emp = typedQuery.getResultList();
		manager.close();
		
		return emp;
	}

	@Override
	public void deleteEmp(Integer id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction =manager.getTransaction();
		transaction.begin();
		Query query = manager.createQuery("delete from employee_info", EmployeeInfoBean.class);
		query.executeUpdate();
		transaction.commit();
		manager.close();
		
		
	}

	@Override
	public void updateEmp(EmployeeInfoBean employee) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction =manager.getTransaction();
		transaction.begin();
		Query query = manager.createQuery("update  employee_info set name='"+ employee.getEmpName()+"', mailI");
		query.executeUpdate();
		transaction.commit();
		manager.close();
		
	}

//	@Override
//	public String authenticate(Login login) {
//		EntityManager entityManager = factory.createEntityManager();
//         Login login1 = entityManager.find(Login.class, 1);
//         String un = login1.getUsername();
//          String pd = login1.getPassword();
//
//          if ((un.equals(login.getUsername()))&&(pd.equals(login.getPassword()))) {
//        	  return "true";
//          } else {
//        	  return "false";
//          }
//	}
		
		
		
	}
	
	

