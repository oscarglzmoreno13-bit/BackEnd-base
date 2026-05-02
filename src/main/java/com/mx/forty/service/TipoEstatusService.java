package com.mx.forty.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;

import com.mx.forty.JpaConfig;
import com.mx.forty.TipoEstatusRepository;
import com.mx.forty.entity.TipoEstatus;

@Component
public class TipoEstatusService extends JpaConfig  {

	PlatformTransactionManager transactionManager;

	public TipoEstatusService(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}
	
	public List<TipoEstatus> finAll() {
		TransactionStatus status = transactionManager.getTransaction(null);
		try {
			transactionManager.commit(status);
		
		}catch (Exception e) {
			transactionManager.rollback(status);
		}
		return null;
	}

}
