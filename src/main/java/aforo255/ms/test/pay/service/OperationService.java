package aforo255.ms.test.pay.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aforo255.ms.test.pay.entity.Operation;
import aforo255.ms.test.pay.repository.OperationDao;

@Service
public class OperationService  {

	@Autowired
	private OperationDao transactionDao;
	
	
	
	@Transactional(readOnly = true)
	public Operation findById(Integer id) {
		return transactionDao.findById(id).orElse(null);
	}

	public Operation save(Operation transaction) {
		return transactionDao.save(transaction);
	}



}
