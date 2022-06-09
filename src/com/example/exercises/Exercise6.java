package com.example.exercises;

import java.util.Comparator;
import java.util.function.Function;

import com.example.dao.CountryDao;
import com.example.dao.InMemoryWorldDao;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class Exercise6 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Sort the countries by number of their cities in descending order
		Function<CountryCityCountPair, Integer> countExtracter = CountryCityCountPair::count;
		var countriesWithCityCountInDescOrder;

		countriesWithCityCountInDescOrder.forEach(System.out::println);
	}

}
