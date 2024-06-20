package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 商品评价回复关系
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
@TableName("pms_comment_replay")
public class CommentReplayEntity {

    /**
     * id
     */
	private Long id;
    /**
     * 评论id
     */
	private Long commentId;
    /**
     * 回复id
     */
	private Long replyId;
}