package com.nrahmatd.springboot.SALT.utils

import java.text.SimpleDateFormat

fun convertToDateSQL(date: String): java.sql.Date {
    val formatterDate = SimpleDateFormat("yyyy-mm-dd")
    val dateParse = formatterDate.parse(date)
    return java.sql.Date(dateParse.time)
}