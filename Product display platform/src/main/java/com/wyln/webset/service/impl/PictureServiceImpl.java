package com.wyln.webset.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyln.webset.bean.Picture;
import com.wyln.webset.mapper.PictureMapper;
import com.wyln.webset.service.PictureService;

/**
 * 
 * @ClassName: PictureServiceImpl
 * @Description: Picture事务实现
 * @author Tommy
 * @date 2017年3月1日
 */

@Service
public class PictureServiceImpl implements PictureService {

	@Autowired
	private PictureMapper pictureMapper;
	
	@Override
	public Long addPicture(Picture picture) {
		return pictureMapper.addPicture(picture);
	}

	@Override
	public Long updatePicture(Picture picture) {
		return pictureMapper.updatePicture(picture);
	}

	@Override
	public Long deleteByKey(Long id) {
		return pictureMapper.deleteByKey(id);
	}

	@Override
	public Long deleteByKeys(List<Long> ids) {
		return pictureMapper.deleteByIids(ids);
	}

	@Override
	public Picture getPictureByKey(Long id) {
		return pictureMapper.getPictureByKey(id);
	}

	@Override
	public Picture getPicturesByKeys(List<Long> ids) {
		return pictureMapper.getPicturesByKeys(ids);
	}

	@Override
	public Picture getPictureDefault(Long id) {
		return pictureMapper.getPictureDefault(id);
	}

	@Override
	public List<Picture> getPictureByIid(Long id) {
		return pictureMapper.getPictureByIid(id);
	}

}
