package com.hamsterLayer.serviceLayer;

import java.util.List;

import com.hamster.hamster.Hamster;
import com.hamsterLayer.DAO.HamsterDAOImpl;

public class HamsterListService {

	public List<Hamster> list() {
		List<Hamster> list = new HamsterDAOImpl().selectAll();
		return list;
	}

}
