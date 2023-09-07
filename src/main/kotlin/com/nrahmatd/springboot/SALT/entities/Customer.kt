package com.nrahmatd.springboot.SALT.entities

import com.nrahmatd.springboot.SALT.basemodel.BaseResponseModel
import javax.persistence.*

@Entity
@Table(name = "konsumen")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    var id: Int = 0,

    @Column(name = "nama", nullable = false)
    var nama: String,

    @Column(name = "alamat", nullable = false)
    var alamat: String,

    @Column(name = "kota", nullable = false)
    var kota: String,

    @Column(name = "provinsi", nullable = false)
    var provinsi: String,

    @Column(name = "tgl_registrasi", nullable = false)
    var tgl_registrasi: java.sql.Date,

    @Column(name = "status", nullable = true)
    var status: String? = null,
): BaseResponseModel {
    override val message: String
        get() = "Get Data"
    override val success: Int
        get() = 1
}