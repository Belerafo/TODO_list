package com.example.todo_list.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.PropertyKey


@Entity(tableName = "todo_table")
data class ToDoData (
        @PrimaryKey(autoGenerate = true)
        var id: Int,
        var title: String,
        var priority: Priority,
        var description: String
)