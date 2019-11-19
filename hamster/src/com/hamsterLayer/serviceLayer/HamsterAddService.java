package com.hamsterLayer.serviceLayer;

import com.hamster.hamster.Hamster;
import com.hamsterLayer.DAO.HamsterDAOImpl;

public class HamsterAddService {
	
	public void add(Hamster hamster) {
		new HamsterDAOImpl().insert(hamster);
	}
}
