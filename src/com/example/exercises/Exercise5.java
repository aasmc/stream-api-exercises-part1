package com.example.exercises;

import java.util.Comparator;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.example.dao.CityDao;
import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;
import com.example.domain.City;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise5 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();
	private static final CityDao cityDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the highest populated capital city of each continent
		Function<ContinentCityPair, City> extractCity = ContinentCityPair::city;
		var highPopulatedCapitalCityOfEachContinent;

		highPopulatedCapitalCityOfEachContinent.forEach((continent,pair) -> System.out.printf("%s: %s\n",continent,pair.get().city()));	
	}

}