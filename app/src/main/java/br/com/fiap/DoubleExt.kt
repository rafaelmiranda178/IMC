package br.com.fiap

fun Double.toFixed(digits:Int) = String.format("%.${digits}f", this)