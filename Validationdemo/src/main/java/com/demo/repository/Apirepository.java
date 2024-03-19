package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.APIcredential;

@Repository
public interface Apirepository extends JpaRepository<APIcredential,Integer>
{

	//APIcredential findbycredentialid(Integer credentialid);
}
