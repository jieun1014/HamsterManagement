package com.hamsterLayer.DAO;

import java.util.List;

import com.hamster.hamster.Hamster;

public interface HamsterDAO {

	public void insert(Hamster hamster);

	public List<Hamster> selectAll();

	public Hamster select(int no);

	public void update(Hamster hamster);

	public void delete(int no);

}
