package com.jdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import com.jdbc.domainmodel.Person;


public interface Idao {

	
		void setDataSource(DataSource ds);

		void create(String firstName, String lastName);

		List<Person> select(String firstname, String lastname);

		List<Person> selectAll();

		void deleteAll();

		void delete(String firstName, String lastName);

	}

