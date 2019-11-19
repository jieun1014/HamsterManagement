package com.hamsterLayer.serviceLayer;

import com.hamsterLayer.DAO.HamsterDAOImpl;

public class HamsterDeleteService {
	
	public void remove(int no) {
		new HamsterDAOImpl().delete(no);
	}

}
