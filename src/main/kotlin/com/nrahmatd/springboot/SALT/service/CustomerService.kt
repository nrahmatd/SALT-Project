package com.nrahmatd.springboot.SALT.service

import com.nrahmatd.springboot.SALT.entities.Customer
import com.nrahmatd.springboot.SALT.repositories.CustomerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional


@Service
@Transactional
class CustomerService {
    @Autowired
    private val customerRepository: CustomerRepository? = null
    fun getAllCustomer(): List<Customer> {
        return customerRepository!!.findAll()
    }

    fun saveCustomer(customer: Customer) {
        customerRepository!!.save(customer)
    }

    fun updateCustomer(customer: Customer) {
        val customerFromDB = getCustomerById(customer.id)
        customerFromDB.id = customer.id
        customerFromDB.nama = customer.nama
        customerFromDB.alamat = customer.alamat
        customerFromDB.kota = customer.kota
        customerFromDB.provinsi = customer.provinsi
        customerFromDB.tgl_registrasi = customer.tgl_registrasi
        customerFromDB.status = customer.status

        customerRepository!!.save(customerFromDB)
    }

    fun getCustomerById(id: Int): Customer {
        return customerRepository!!.findById(id).get()
    }

    fun deleteCustomer(id: Int) {
        customerRepository!!.deleteById(id)
    }
}