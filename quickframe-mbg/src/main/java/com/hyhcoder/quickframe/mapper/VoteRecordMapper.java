package com.hyhcoder.quickframe.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyhcoder.quickframe.model.VoteRecordDo;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hyhcoder
 * @since 2019-07-14
 */
@Mapper
public interface VoteRecordMapper extends BaseMapper<VoteRecordDo> {
	
	IPage<VoteRecordDo> selectPageVo(Page page);
}
