package com.nrahmatd.springboot.SALT.controller

import com.nrahmatd.springboot.SALT.basemodel.ResponseModel
import com.nrahmatd.springboot.SALT.entities.Customer
import com.nrahmatd.springboot.SALT.service.CustomerService
import com.nrahmatd.springboot.SALT.utils.convertToDateSQL
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(path= ["/restapi"])
class MainController {
    @Autowired
    private val customerService: CustomerService? = null

    /**
     * Customer Web API
     */

    @PostMapping(path = ["/addcustomer"])
    @ResponseBody
    fun addNewCustomer(
        @RequestParam nama: String,
        @RequestParam alamat: String,
        @RequestParam kota: String,
        @RequestParam provinsi: String,
        @RequestParam tgl_registrasi: String,
        @RequestParam status: String
    ): ResponseModel? {

        val customer = Customer(
            nama = nama,
            alamat = alamat,
            kota = kota,
            provinsi = provinsi,
            tgl_registrasi = convertToDateSQL(tgl_registrasi),
            status = status
        )

        val responseModel: ResponseModel = try {
            customerService!!.saveCustomer(customer)
            ResponseModel("Successfully saving data", 1)
        } catch (e: DataAccessException) {
            ResponseModel("Error saving data $e", 0)
        }

        return responseModel
    }

    @PutMapping(path = ["/updatecustomer"])
    @ResponseBody
    fun updateCustomer(
        @RequestParam nama: String,
        @RequestParam alamat: String,
        @RequestParam kota: String,
        @RequestParam provinsi: String,
        @RequestParam tgl_registrasi: String,
        @RequestParam status: String
    ): ResponseModel? {



        val customer = Customer(
            nama = nama,
            alamat = alamat,
            kota = kota,
            provinsi = provinsi,
            tgl_registrasi = convertToDateSQL(tgl_registrasi),
            status = status
        )

        val responseModel: ResponseModel = try {
            customerService!!.updateCustomer(customer)
            ResponseModel("Successfully update data", 1)
        } catch (e: DataAccessException) {
            ResponseModel("Error update data $e", 0)
        }

        return responseModel
    }

    @DeleteMapping(path = ["/deletecustomer/{idcustomer}"])
    @ResponseBody
    fun deleteCustomer(
        @PathVariable idcustomer: Int
    ): ResponseModel? {
        val responseModel: ResponseModel = try {
            customerService!!.deleteCustomer(idcustomer)
            ResponseModel("Successfully delete data", 1)
        } catch (e: DataAccessException) {
            ResponseModel("Error delete data $e", 0)
        }

        return responseModel
    }

    @PostMapping(path = ["/getcustomer"])
    @ResponseBody
    fun getCustomer(
        @RequestParam idcustomer: Int
    ): Customer {
        return customerService!!.getCustomerById(idcustomer)
    }

    @GetMapping(path = ["/getallcustomer"])
    @ResponseBody
    fun getAllCustomer(): Iterable<Customer?>? {
        return customerService!!.getAllCustomer()
    }
}