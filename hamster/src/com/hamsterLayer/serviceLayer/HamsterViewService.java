package com.hamsterLayer.serviceLayer;

import com.hamster.hamster.Hamster;
import com.hamsterLayer.DAO.HamsterDAOImpl;

public class HamsterViewService {
	
	public Hamster view(int no) {
		Hamster hamster = new HamsterDAOImpl().select(no);
		return hamster;
	}

}
