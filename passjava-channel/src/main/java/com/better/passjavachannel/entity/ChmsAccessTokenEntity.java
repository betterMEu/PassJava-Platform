package com.better.passjavachannel.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 渠道-认证表
 *
 * @author sangyu
 * @email yls912@qq.com
 * @date 2022-08-02 15:29:47
 */
@Data
@TableName("chms_access_token")
public class ChmsAccessTokenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Long id;
	/**
	 * access_token
	 */
	private String accessToken;
	/**
	 * 到期时间
	 */
	private Date expireTime;
	/**
	 * 渠道id
	 */
	private Long channelId;
	/**
	 * 删除标记（0-正常，1-删除）
	 */
	private Integer delFlag;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;

}
