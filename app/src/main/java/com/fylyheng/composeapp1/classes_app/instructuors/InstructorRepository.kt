package com.fylyheng.composeapp1.classes_app.instructuors

import com.fylyheng.composeapp1.classes_app.classes.ClassSummary

interface InstructorRepository {

    suspend fun getInstructors() : Result<List<InstructorSummary>>

    suspend fun getInstructorById(id: String) : Result<InstructorDetail>
}


data class InstructorSummary (
    val id:String,
    val name: String,
    val picture : String
)

data class InstructorDetail (
    val id:String,
    val name: String,
    val bio:String,
    val picture : String,
    val classes : List<ClassSummary>
)