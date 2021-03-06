package com.oneplatform.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeesuite.common.util.AssertUtil;
import com.jeesuite.common.util.BeanUtils;
import com.jeesuite.mybatis.plugin.pagination.Page;
import com.jeesuite.mybatis.plugin.pagination.PageParams;
import com.jeesuite.mybatis.plugin.pagination.PageExecutor;
import com.jeesuite.mybatis.plugin.pagination.PageExecutor.PageDataLoader;
import com.oneplatform.user.dto.param.UserAssetsQueryParam;
import com.oneplatform.user.dao.entity.UserAssetsEntity;
import com.oneplatform.user.dao.mapper.UserAssetsEntityMapper;

/**
 * generated by www.jeesuite.com
 */
@Service
public class UserAssetsService {

	@Autowired
	private UserAssetsEntityMapper userAssetsMapper;

	public void addUserAssets(UserAssetsEntity entity) {
		userAssetsMapper.insertSelective(entity);
	}

	public void updateUserAssets(UserAssetsEntity entity) {
		UserAssetsEntity originEntity = userAssetsMapper.selectByPrimaryKey(entity.getId());
		AssertUtil.notNull(originEntity);
		BeanUtils.copy(entity, originEntity);
		userAssetsMapper.updateByPrimaryKey(originEntity);
	}
	
	public void deleteUserAssets(Integer id) {
		userAssetsMapper.deleteByPrimaryKey(id);
	}
	
	public UserAssetsEntity findUserAssetsById(Integer id){
		UserAssetsEntity entity = userAssetsMapper.selectByPrimaryKey(id);
		AssertUtil.notNull(entity);
		return entity;
	}
	
    public Page<UserAssetsEntity> pageQuery(PageParams pageParam,UserAssetsQueryParam param){
		Page<UserAssetsEntity> page = PageExecutor.pagination(pageParam, new PageDataLoader<UserAssetsEntity>() {
			@Override
			public List<UserAssetsEntity> load() {
				return userAssetsMapper.findListByQueryParam(param);
			}
		});
		return page;
	}

}
