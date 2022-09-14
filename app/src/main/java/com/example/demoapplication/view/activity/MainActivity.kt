package com.example.demoapplication.view.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoapplication.databinding.ActivityMainBinding
import com.example.demoapplication.model.Person
import com.example.demoapplication.view.adapter.TestAdapter
import java.util.regex.Matcher
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityMainBinding
    private val testAdapter = TestAdapter()
    private var listOfPerson: ArrayList<Person> = ArrayList()
    private var longString = "56hj fog dfg56hjk 1HG CM8 5564A265324 fights AA-000-AA vhdl"
    private val patternForVin : Pattern = Pattern.compile("\\d+[A-Z]{2} [A-Z]{2}\\d+ [0-9]{4}[A-Z]\\d+")
    private val patternForPlate: Pattern = Pattern.compile("[A-Z]{2}-[0-9]{3}-[A-Z]{2}")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.rvTest.layoutManager = LinearLayoutManager(this)
        mBinding.rvTest.adapter = testAdapter
        updateAdapter()



        setOnclickListener()

        findPattern().let { Log.e("TAG", "PATTERN: $it") }

    }

    private fun findPattern(): String?{
        var matcher: Matcher?

        matcher = patternForVin.matcher(longString)
        return if (matcher.find()) {
            matcher.group()
        }else{
            matcher = patternForPlate.matcher(longString)
            if (matcher.find()){
                matcher.group()
            }else{
                "NOT found"
            }
        }
    }

    //This is test branch 1

    private fun setOnclickListener() {
        mBinding.chip1.setOnClickListener {
            // Responds to chip click
        }

        mBinding.chip1.setOnCloseIconClickListener {
            // Responds to chip's close icon click if one is present
        }

        mBinding.chip1.setOnCheckedChangeListener { _, _ ->
            // Responds to chip checked/unchecked
        }

        mBinding.chipGroup.setOnCheckedChangeListener { _, _ ->
            // Responds to child chip checked/unchecked
        }

        mBinding.fab.setOnClickListener {
            val newList : ArrayList<Person> = ArrayList()
            newList.addAll(listOfPerson)
            newList[0] = Person(1, "Intern","XYZ")
            newList.add(Person(4, "React Native","Test"))
            testAdapter.submitList(newList)

        }
    }

    private fun updateAdapter() {

        listOfPerson.add(Person(1, "Android","Sajid"))
        listOfPerson.add(Person(2, "DotNet","Ali"))
        listOfPerson.add(Person(3, "PHP","Star"))

        listOfPerson.filter { it.id == 1 }

        testAdapter.submitList(listOfPerson)

    }

}