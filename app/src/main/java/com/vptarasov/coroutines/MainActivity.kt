package com.vptarasov.coroutines

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.Dispatchers.IO

class MainActivity : AppCompatActivity() {

    private var viewModelJob = Job()
    private val viewModelScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private lateinit var btn: Button

    private var result = 1.0
    private var result2 = 1.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = button
        btn.setOnClickListener { doWork() }


    }

    private fun doWork() {

        val useCase = GetListOfPostsUseCase()

        viewModelScope.launch {
            withContext(IO) {
                val result = useCase.doWork(
                    GetListOfPostsUseCase.Params()
                )
                Log.d("coroutines example",  "get list of posts = ${result.posts}")
            }
        }
    }

    fun cancelJob() {
        viewModelJob.cancel()
    }
}