package com.lvym.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lvym.po.Comment;

import java.util.List;

/**
 * Created by limi on 2017/10/22.
 */
public interface CommentRepository extends JpaRepository<Comment,Long>{


    List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);

    @Query("select c from Comment c where id=:parentCommentId")
	Comment findOne(Long parentCommentId);
}
