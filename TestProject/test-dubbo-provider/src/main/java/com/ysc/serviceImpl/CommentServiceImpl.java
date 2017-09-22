package com.ysc.serviceImpl;

import com.ysc.dao.CommentMapper;
import com.ysc.model.Comment;
import com.ysc.model.Good;
import com.ysc.service.CommentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentServiceInterface {
	@Autowired
	CommentMapper mapper;
	public void insertCommet(Comment comment) {
		// TODO Auto-generated method stub
		mapper.insertCommet(comment);
	}
	public List<Comment> selectCommentByGood(Good good) {
		// TODO Auto-generated method stub
		return mapper.selectCommentByGood(good);
	}
	public List<Integer> canComment(Comment comment) {
		// TODO Auto-generated method stub
		return mapper.canComment(comment);
	}
	
}
