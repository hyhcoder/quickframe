package com.hyhcoder.quickframe.protal.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hyhcoder.quickframe.common.core.reqres.response.ResponseData;
import com.hyhcoder.quickframe.mapper.VoteRecordMapper;
import com.hyhcoder.quickframe.model.VoteRecordDo;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Observable;


/**
 * @author hyhcoder
 * @date 2019/6/29 17:28
 */

@RestController
public class DemoController {
	
	@Autowired
	private VoteRecordMapper voteRecordMapper;
	
	@RequestMapping("/demotest")
	public ResponseEntity demotest() {
		
		Wrapper<VoteRecordDo> querryWrapper = new QueryWrapper<>();
		
		IPage<VoteRecordDo> voteRecordDoPage = voteRecordMapper.selectPage(new Page<>(1000, 20), null);
		
		System.out.println(voteRecordDoPage.getPages());
		System.out.println(voteRecordDoPage.getTotal());
		System.out.println(voteRecordDoPage.getCurrent());
		return ResponseEntity.ok(voteRecordDoPage.getRecords());
		
		//return ResponseEntity.badRequest().body(ResponseData.error("你错误了"));
	}
	
}
