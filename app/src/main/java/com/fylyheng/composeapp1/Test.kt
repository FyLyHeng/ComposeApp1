package com.fylyheng.composeapp1

class Test {

    fun testElvis() {

        //v1
        val name: String? = null
        val displayName1 : String = name?: "Guest" // If 'name' is null, 'displayName' becomes "Guest"
        print(displayName1) //Guest


        //v2
        val nickName : String? = null
        val display2 = if (nickName != null) nickName else "Guest"
        print(display2) //Guest

        val displayName2 : String = name?: throw Exception("name can not be null")

        //v3
        val firstName : String? = null
        var display3 : String
        if (firstName != null) {
            display3 = firstName
        }
        else {
            display3 = "Guest"
            print("")
            throw Exception()
            testSafeCall()
        }

        print(display3) //Guest
    }


    fun testSafeCall() {

        // count s1 when s1 != null
        val s1 : String? = "my name is heng"
        val s2CountDigit = s1?.count() // call function

        if (s1!=null) {
            val s2CountDigit = s1.count()
        }

        print(s2CountDigit)


        var name: String = "heng"
        var nameCountDigit = name.last()
        println(nameCountDigit) // null

    }
}