package com.example.todo_list.data.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.todo_list.data.ToDoDatabase
import com.example.todo_list.data.models.ToDoData
import com.example.todo_list.data.repository.ToDoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ToDoViewModel(application: Application): AndroidViewModel(application){

    private val toDoDao = ToDoDatabase.getDataBase(application).toDoDao()
    private val repository: ToDoRepository

    private val getAllData: LiveData<List<ToDoData>>

    init {
        repository = ToDoRepository(toDoDao)
        getAllData = repository.getAllData
    }

    fun insertData(toDoData: ToDoData){
        viewModelScope.launch(Dispatchers.IO){
            repository.insertData(toDoData)
        }
    }
}