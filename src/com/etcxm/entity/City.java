package com.etcxm.entity;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 城市对象
 */
public class City {
	private Long id;
	private String name;

	public City() {
	}

	public City(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * 根据省份id查询省份中的城市!
	 * @return
	 */
	public static List<City> getCityByProvinceId(Long pid) {
		
		List<City> citys = new ArrayList<City>();
		
		if (pid == 1) {
			citys = Arrays.asList(
					new City(11L,"成都"),
					new City(12L,"南充"),
					new City(13L,"绵阳"),
					new City(14L,"遂宁"),
					new City(15L,"达州"),
					new City(16L,"宜宾"),
					new City(17L,"泸州"),
					new City(18L,"乐山")
			);
		} else if (pid == 2) {
			citys = Arrays.asList(
					new City(21L,"广州"),
					new City(22L,"深圳"),
					new City(23L,"佛山"),
					new City(24L,"中山"),
					new City(25L,"珠海"),
					new City(26L,"汕头"),
					new City(27L,"潮州"),
					new City(28L,"东莞")
			);
		} else if (pid == 3) {
			citys = Arrays.asList(
					new City(31L,"西安"),
					new City(32L,"宝鸡"),
					new City(33L,"咸阳"),
					new City(34L,"延安"),
					new City(35L,"汉中"),
					new City(36L,"渭南"),
					new City(37L,"榆林"),
					new City(38L,"咸阳")
			);
		}
		else if (pid == 4) {
			citys = Arrays.asList(
					new City(41L,"东城区"),
					new City(42L,"西城区"),
					new City(43L,"崇文区"),
					new City(44L,"宣武区"),
					new City(45L,"朝阳区"),
					new City(46L,"丰台区"),
					new City(47L,"石景山区"),
					new City(48L,"海淀区门")
			);
		}
		else if (pid == 5) {
			citys = Arrays.asList(
					new City(51L,"黄浦区"),
					new City(52L,"虹口区"),
					new City(53L,"闵行区"),
					new City(54L,"崇明县"),
					new City(55L,"浦东新区"),
					new City(56L,"闸北区")
			);
		}
		else if (pid == 6) {
			citys = Arrays.asList(
					new City(61L,"武昌区"),
					new City(62L,"汉阳区"),
					new City(63L,"洪山区"),
					new City(64L,"硚口区"),
					new City(65L,"江汉区"),
					new City(66L,"江岸区")
			);
		}
		return citys;
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return "City [id=" + id + ", name=" + name + "]";
	}
}
