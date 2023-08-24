/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.andihasan7.lib.konversi

import kotlin.test.Test
import kotlin.test.assertTrue
import com.andihasan7.lib.konversi.Konversi
import com.andihasan7.lib.konversi.round

class LibraryTest {
    @Test fun someLibraryMethodReturnsTrue() {
        val classUnderTest = Konversi().toTimeFull(10.99999722)
        assertTrue(classUnderTest == "10 : 59 : 59", "metode library harus bernilai 'true'")
        
        val dr = 10
        val mnt = 59
        val dtk = 10.99
        val v = 17.97876587007
        
        val n = 10.98638611
        
        val degree = 7
        val minute = 26
        val second = 0
        val check = false
        
        println("toDecimalCheck = ${Konversi().toDecimalCheck(degree, minute, second, check)}")
        println("toDecimal = ${Konversi().toDecimal(dr, mnt, dtk)}")
        println("toTime = ${Konversi().toTime(n)}")
        println("toTimeFull = ${Konversi().toTimeFull(n)}")
        println("toTimeFullRound = ${Konversi().toTimeFullRound(n)}")
        println("toTimeFullRound2 = ${Konversi().toTimeFullRound2(n)}")
        println("toDegreeFull = ${Konversi().toDegreeFull(n)}")
        println("toDegreeFullRound = ${Konversi().toDegreeFullRound(n)}")
        println("toDegreeFullRound2 = ${Konversi().toDegreeFullRound2(n)}")
        println("round $v = ${v.round(3)}")
    }
}
