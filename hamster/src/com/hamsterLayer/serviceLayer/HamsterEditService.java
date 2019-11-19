package com.hamsterLayer.serviceLayer;

import com.hamster.hamster.Hamster;
import com.hamsterLayer.DAO.HamsterDAOImpl;

public class HamsterEditService {
	
	public Hamster view(int no) {
		Hamster hamster = new HamsterDAOImpl().select(no);
		return hamster;
	}
	
	public void edit(Hamster hamster) {
		new HamsterDAOImpl().update(hamster);
	}

}
