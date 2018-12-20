package com.springmvcajax.app.modal;

import java.util.List;
/**
 * USER DETAILS BEAN
 * @author Naveen
 *
 */
public class UserModal
{
	private String label;
	private String userName;
	private String passWord;
	private String province;
	private List<String> provincesList;
	private String capitalRegion;
    private List<String>capitalRegionList;
    private String population;
    private String area;
	private List<String> majorCitiesList;


	public String getLabel()
	{
		return label;
	}

	public void setLabel(String label)
	{
		this.label = label;
	}

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassWord()
	{
		return passWord;
	}

	public void setPassWord(String passWord)
	{
		this.passWord = passWord;
	}

	public String getProvince()
	{
		return province;
	}

	public void setProvince(String province)
	{
		this.province = province;
	}

	public List<String> getProvincesList()
	{
		return provincesList;
	}

	public void setProvincesList(List<String> provincesList)
	{
		this.provincesList = provincesList;
	}

	public String getCapitalRegion()
	{
		return capitalRegion;
	}

	public void setCapitalRegion(String capitalRegion)
	{
		this.capitalRegion = capitalRegion;
	}

	public List<String> getCapitalRegionList()
	{
		return capitalRegionList;
	}

	public void setCapitalRegionList(List<String> capitalRegionList)
	{
		this.capitalRegionList = capitalRegionList;
	}

	public String getPopulation()
	{
		return population;
	}

	public void setPopulation(String population)
	{
		this.population = population;
	}

	public String getArea()
	{
		return area;
	}

	public void setArea(String area)
	{
		this.area = area;
	}

	public List<String> getMajorCitiesList()
	{
		return majorCitiesList;
	}

	public void setMajorCitiesList(List<String> majorCitiesList)
	{
		this.majorCitiesList = majorCitiesList;
	}
}
