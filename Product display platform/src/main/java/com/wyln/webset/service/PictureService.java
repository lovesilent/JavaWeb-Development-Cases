package com.wyln.webset.service;

import java.util.List;

import com.wyln.webset.bean.Picture;

/**
 * 
 * @ClassName: PictureService
 * @Description: Picture事务接口
 * @author Tommy
 * @date 2017年3月1日
 */
public interface PictureService {
	Long addPicture(Picture picture);
	Long updatePicture(Picture picture);
	Long deleteByKey(Long id);
	Long deleteByKeys(List<Long> ids); 
	Picture getPictureByKey(Long id);
	Picture getPicturesByKeys(List<Long> ids);
	List<Picture> getPictureByIid(Long id);
	Picture getPictureDefault(Long id);
}
