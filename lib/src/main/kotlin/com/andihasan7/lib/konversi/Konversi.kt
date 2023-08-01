/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.andihasan7.lib.konversi

import kotlin.math.abs
import kotlin.math.round
import com.andihasan7.lib.konversi.round

class Konversi {
    
    /* 
    	fungsi mengubah DMS ke Double, jika bernilai negatif,
    	wajib memasukkan tanda negatif (-) disetiap input DMS.
        parameter second bisa menerima integer / double
    */
   
   
    fun toDecimal(degree: Int, minute: Int, second: Number): Double {
    	val decimal = degree + (minute.toDouble() / 60) + (second.toDouble() / 3600)
    	return decimal
	}
    
    

    // HH : MM detik dibulatkan ke menit, menit ke jam jika menit == 60
    fun toTime(decimal: Double): String {
    	var time = decimal.toInt().toString()
    	var minute = ((decimal - time.toDouble()) * 60).toInt().toString()
    	var second = round(((decimal - time.toDouble()) * 60 - minute.toDouble()) * 60).toInt().toString()

    	// Tambahkan perhitungan untuk membulatkan detik ke menit & menit ke jam jika menit == 60
    	if (second.toDouble() <= 60 && second.toDouble() >= 30) {
        	minute = (minute.toInt() + 1 - 60).toString()
            time = (time.toInt() + 1).toString()
    	}
        
        // Tambahkan nol sebelum angka yang kurang dari 10
        time = time.padStart(2, '0')
        minute = minute.padStart(2, '0')

    	return "$time : $minute"
	}
    
    
    // HH : MM : SS angka dibelakang koma orde detik tidak dibulatkan ke detik integer
    fun toTimeFull(decimal: Double): String {
    	var time = decimal.toInt().toString()
    	var minute = ((decimal - time.toDouble()) * 60).toInt().toString()
    	var second = (((decimal - time.toDouble()) * 60 - minute.toDouble()) * 60).toInt().toString()
        
        time = time.padStart(2, '0')
        minute = minute.padStart(2, '0')
        second = second.padStart(2, '0')

    	return "$time : $minute : $second"
	}
    
    // HH : MM : SS angka dibulatkan ke detik
    fun toTimeFullRound(decimal: Double): String {
    	var time = decimal.toInt().toString()
    	var minute = ((decimal - time.toDouble()) * 60).toInt().toString()
    	var second = round(((decimal - time.toDouble()) * 60 - minute.toDouble()) * 60).toInt().toString()
        
        // Tambahkan perhitungan untuk membulatkan detik ke menit & menit ke jam jika detik & menit == 60
    	if (second.toDouble() == 60.0) {
        	second = (second.toInt() - 60).toString()
        	minute = (minute.toInt() + 1).toString()
    	}

    	if (minute.toInt() == 60) {
        	minute = (minute.toInt() - 60).toString()
        	time = (time.toInt() + 1).toString()
    	}
        
        time = time.padStart(2, '0')
        minute = minute.padStart(2, '0')
        second = second.padStart(2, '0')

    	return "$time : $minute : $second"
	}
    
    // HH : MM : SS,ss dibulatkan ke 2 angka di belakang koma 
    fun toTimeFullRound2(decimal: Double): String {
    	var time = decimal.toInt().toString()
    	var minute = ((decimal - time.toDouble()) * 60).toInt().toString()
    	var second = (((decimal - time.toDouble()) * 60 - minute.toDouble()) * 60).round(2).toString()
        
        time = time.padStart(2, '0')
        minute = minute.padStart(2, '0')
        second = second.padStart(2, '0')

    	return "$time : $minute : $second"
	}
    
    // DD° MM` SS``angka dibelakang koma orde detik tidak dibulatkan ke detik integer
    fun toDegreeFull(decimal: Double): String {
    	var degree = abs(decimal).toInt().toString()
    	var minute = ((abs(decimal) - degree.toDouble()) * 60).toInt().toString()
    	var second = ((((abs(decimal) - degree.toDouble()) * 60) - minute.toDouble()) * 60).toInt().toString()

        // Tambahkan nol sebelum angka yang kurang dari 10
        degree = degree.padStart(2, '0')
        minute = minute.padStart(2, '0')
        second = second.padStart(2, '0')
        
        if (decimal < 0) {
            degree = "-$degree"
        }

    	return "$degree\u00B0 $minute\u2032 $second\u2033"
	}
    
    
    // DD° MM` SS`` angka dibulatkan ke detik
    fun toDegreeFullRound(decimal: Double): String {
    	var degree = abs(decimal).toInt().toString()
    	var minute = ((abs(decimal) - degree.toDouble()) * 60).toInt().toString()
    	var second = round((((abs(decimal) - degree.toDouble()) * 60) - minute.toDouble()) * 60).toInt().toString()
        
        // Tambahkan perhitungan untuk membulatkan detik ke menit & menit ke jam jika detik & menit == 60
    	if (second.toDouble() == 60.0) {
        	second = (second.toInt() - 60).toString()
        	minute = (minute.toInt() + 1).toString()
    	}

    	if (minute.toInt() == 60) {
        	minute = (minute.toInt() - 60).toString()
        	degree = (degree.toInt() + 1).toString()
    	}

        // Tambahkan nol sebelum angka yang kurang dari 10
        degree = degree.padStart(2, '0')
        minute = minute.padStart(2, '0')
        second = second.padStart(2, '0')
        
        if (decimal < 0) {
            degree = "-$degree"
        }

    	return "$degree\u00B0 $minute\u2032 $second\u2033"
	}
	
    
    // DD° MM` SS,ss`` dibulatkan ke 2 angka di belakang koma
	fun toDegreeFullRound2(decimal: Double): String {
    	var degree = abs(decimal).toInt().toString()
    	var minute = ((abs(decimal) - degree.toDouble()) * 60).toInt().toString()
    	var second = ((((abs(decimal) - degree.toDouble()) * 60) - minute.toDouble()) * 60).round(2).toString()

        // Tambahkan nol sebelum angka yang kurang dari 10
        degree = degree.padStart(2, '0')
        minute = minute.padStart(2, '0')
        second = second.padStart(2, '0')
        
        if (decimal < 0) {
            degree = "-$degree"
        }

    	return "$degree\u00B0 $minute\u2032 $second\u2033"
	}
    
    /*
        catatan yang belum ada adalah toDegree,
        DD° MM` detik dibulatkan ke menit,
        mungkin tidak akan saya tambahkan mengingat
        jarang sekali dipakai untuk keperluan falak
        karena keperluan falak menuntut format lengkap 
    */
    
}
