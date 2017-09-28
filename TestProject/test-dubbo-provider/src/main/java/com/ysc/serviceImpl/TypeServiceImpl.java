package com.ysc.serviceImpl;

import com.ysc.bug.JVMmemory;
import com.ysc.bug.KafkaException;
import com.ysc.dao.TypeMapper;
import com.ysc.model.Page;
import com.ysc.model.Type;
import com.ysc.service.TypeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeServiceInterface {
	@Autowired
	private TypeMapper mapper;
	public List<Type> selectTypeById(Type type) {
		// TODO Auto-generated method stub
		return mapper.selectTypeById(type);
	}

	public void addType(Type type) {
		// TODO Auto-generated method stub
		KafkaException kafkaException = new KafkaException();
		kafkaException.outOfCapacity();
		mapper.addType(type);
	}

	public int deleteType(Type type) {
		// TODO Auto-generated method stub
		return mapper.deleteType(type);
	}

	public void updateType(Type type) {
		// TODO Auto-generated method stub
		mapper.updateType(type);
	}

	public void deleteMulType(List<Integer> list) {
		// TODO Auto-generated method stub
		mapper.deleteMulType(list);
	}

	public List<Type> selectPageType(Page page) {
		// TODO Auto-generated method stub
		return mapper.selectPageType(page);
	}

}
