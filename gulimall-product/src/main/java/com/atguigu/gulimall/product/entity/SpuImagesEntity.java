package com.atguigu.gulimall.product.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * spu图片
 *
 * @author xining yinerqian@gmail.com
 * @since 1.0.0 2024-06-19
 */
@Data
@TableName("pms_spu_images")
public class SpuImagesEntity {

    /**
     * id
     */
	private Long id;
    /**
     * spu_id
     */
	private Long spuId;
    /**
     * 图片名
     */
	private String imgName;
    /**
     * 图片地址
     */
	private String imgUrl;
    /**
     * 顺序
     */
	private Integer imgSort;
    /**
     * 是否默认图
     */
	private Integer defaultImg;
}