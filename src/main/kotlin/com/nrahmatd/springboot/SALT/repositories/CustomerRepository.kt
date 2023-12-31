package com.nrahmatd.springboot.SALT.repositories

import com.nrahmatd.springboot.SALT.entities.Customer
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerRepository : JpaRepository<Customer, Int>