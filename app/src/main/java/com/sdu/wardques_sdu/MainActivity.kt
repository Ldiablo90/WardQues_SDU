package com.sdu.wardques_sdu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.sdu.wardques_sdu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val list = ArrayList<Ques>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val fragment = supportFragmentManager.beginTransaction()
        fragment.replace(binding.mainFragment.id,QuesPage1Fragment())
        fragment.commit()

        binding.pageQues1.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(binding.mainFragment.id,QuesPage1Fragment())
                .commit()
        }

        binding.pageQues2.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(binding.mainFragment.id,QuesPage2Fragment())
                .commit()
        }
        binding.pageQues3.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(binding.mainFragment.id,QuesPage3Fragment())
                .commit()
        }


    }
}

