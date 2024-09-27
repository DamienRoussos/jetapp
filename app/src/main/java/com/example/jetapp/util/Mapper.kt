package com.example.jetapp.util

interface Mapper<in I, out O> {
    fun map(input: I): O
}