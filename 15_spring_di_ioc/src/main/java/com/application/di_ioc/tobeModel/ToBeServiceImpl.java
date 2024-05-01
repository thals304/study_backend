package com.application.di_ioc.tobeModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // 해당 클래스를 service로 지정하여 spring bean으로 등록한다.
public class ToBeServiceImpl implements ToBeService{

	// before
	// private ToBeDAO toBeDAO = new ToBeDAOImpl();
	
	// after
	@Autowired
	private ToBeDAO toBeDAO;
}
