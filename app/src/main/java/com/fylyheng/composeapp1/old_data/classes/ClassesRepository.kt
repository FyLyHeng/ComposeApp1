package com.fylyheng.composeapp1.old_data.classes

import com.fylyheng.composeapp1.old_data.instructuors.InstructorSummary
import java.time.LocalTime
import java.time.format.DateTimeFormatter

interface ClassesRepository {

    suspend fun getClasses() : Result<List<ClassSummary>>

    suspend fun getClassById(id:String) : Result<ClassDetail>
}


enum class ClassFilterType {
    Title,
    Location,
    Day,
    Time
}

data class ClassFilter (
    val type: ClassFilterType,
    val value: String
)

sealed class ListItem {
    abstract val title :String
    abstract val headerIndex : Int
}

data class ClassSummary(
    val id: String,
    val dayOfWeek:Int,
    val day:String,
    val time:String,

    ) : ListItem()
{
    override val headerIndex: Int
        get() = dayOfWeek

    override val title: String
        get() = TODO("Not yet implemented")

    fun getTimeOfDay() : String {

        val hour = LocalTime.parse(time, DateTimeFormatter.ofPattern("h:mm a")).hour
        return when{
            hour <12 -> "Morning"
            hour in 12..16 -> "Afternoon"
            else -> "Evening"
        }
    }
}



data class ClassDetail(
    val id: String,
    val name:String,
    val location:String,
    val dayOfWeek:Int,
    val day:String,
    val time:String,
    val duration:Int,
    val difficulty : String,
    val instructor : InstructorSummary
)