package com.ysc.dao;

import com.ysc.model.Comment;
import com.ysc.model.Good;
import java.util.List;

public interface CommentMapper {
	public void insertCommet(Comment comment);//添加评论
	public List<Comment> selectCommentByGood(Good good);//查询某个商品的评论
	public List<Integer> canComment(Comment comment);//判断能否评论
}
