package com.ddc.common.demo.util;

import java.util.List;
import org.springframework.beans.BeanUtils;

/**
 * 对象转换工具类
 *
 */
public class BeanCommonUtils {

	/**
	 * @param source 源
	 * @param target 目标
	 */
	public static void copyProperties(Object source, Object target) {
		BeanUtils.copyProperties(source, target);
	}

	/**
	 * @param source     源
	 * @param target     目标
	 * @param targetBean 目标对象
	 */
	public static <F, T> void copyListProperties(List<F> source, List<T> target, Class<T> targetBean) {
		source.stream().forEach(c -> {
			T newInstance;
			try {
				newInstance = targetBean.newInstance();
				BeanUtils.copyProperties(c, newInstance);
				target.add(newInstance);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		});
	}

}