package com.app.abc.util

fun <T> T.TAG():String = this!!::class.java.simpleName.toString()
fun Int.intToBoolean() : Boolean = this != 0