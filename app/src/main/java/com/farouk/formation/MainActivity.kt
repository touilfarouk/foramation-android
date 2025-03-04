package com.farouk.formation

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.farouk.formation.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    companion object {
        private val TAG = "MainActivity"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)







        // Define a Flow that emits users with a delay
         fun simpleFlow(): Flow<String> = flow {
            userList.forEach { user ->
                emit(user)
                delay(500) // Delay between emissions
            }
        }

        // Launch the coroutine and collect the Flow
        CoroutineScope(Dispatchers.Main).launch {

                simpleFlow().collect { user ->
                   // Log.d(TAG, "Flow: $user")
                }

            flowUserList.collect { user ->
               // Log.d(TAG, "Flow: $user")
            }

            userList.asFlow().collect { user ->
                Log.d(TAG, "Flow asFlow: $user")
            }

            }







    }
}