package com.wyln.webset.mapper;

import java.util.List;

import com.wyln.webset.bean.Picture;

/**
 * 
 * @ClassName: PictureMapper
 * @Description: Picture的映射类
 * @author Tommy
 * @date 2017年3月1日
 */
public interface PictureMapper {
	Long addPicture(Picture picture);
	Long updatePicture(Picture picture);
	Long deleteByKey(Long id);
	Long deleteByKeys(List<Long> ids); 
	Long deleteByIid(Long id);
	Long deleteByIids(List<Long> ids); 
	Picture getPictureByKey(Long id);
	Picture getPicturesByKeys(List<Long> ids); 
	List<Picture> getPictureByIid(Long id);
	Picture getPictureDefault(Long id);
}
