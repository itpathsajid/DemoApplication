package com.example.demoapplication.view.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoapplication.databinding.ActivityMainBinding
import com.example.demoapplication.model.Person
import com.example.demoapplication.util.REGEX_EMAIL
import com.example.demoapplication.view.adapter.TestAdapter
import java.util.regex.Matcher
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {
    private lateinit var mBinding : ActivityMainBinding
    private val testAdapter = TestAdapter()
    private var listOfPerson: ArrayList<Person> = ArrayList()
    private var longString = "56hj fofg dfg56hjk 1HG CM8 5564A265324 fghdghs AA-000-AA vhgd"
    private val patternForVin : Pattern = Pattern.compile("\\d+[A-Z]{2} [A-Z]{2}\\d+ [0-9]{4}[A-Z]\\d+")
    private val patternForPlate: Pattern = Pattern.compile("[A-Z]{2}-[0-9]{3}-[A-Z]{2}")
    private val emailPattern = Pattern.compile(REGEX_EMAIL)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mBinding.rvTest.layoutManager = LinearLayoutManager(this)
        mBinding.rvTest.adapter = testAdapter
        updateAdapter()

        mBinding.fab.setOnClickListener {
            val newList : ArrayList<Person> = ArrayList()
            newList.addAll(listOfPerson)
            newList[0] = Person(1, "Intern","XYZ")
            newList.add(Person(4, "React Native","Test"))
            testAdapter.submitList(newList)

        }

        setOnclickListener()

        findPattern().let { Log.e("TAG", "PATTERN: $it") }

    }

    private fun findPattern(): String?{
        var matcher : Matcher ? = null

        matcher = patternForVin.matcher(longString)
        if (matcher.find()) {
            return matcher.group()
        }else{
            matcher = patternForPlate.matcher(longString)
            if (matcher.find()){
                return matcher.group()
            }else{
                return "NOT found"
            }
        }
    }



    private fun setOnclickListener() {
        mBinding.chip1.setOnClickListener {
            // Responds to chip click
        }

        mBinding.chip1.setOnCloseIconClickListener {
            // Responds to chip's close icon click if one is present
        }

        mBinding.chip1.setOnCheckedChangeListener { chip, isChecked ->
            // Responds to chip checked/unchecked
        }

        mBinding.chipGroup.setOnCheckedChangeListener { group, checkedId ->
            // Responds to child chip checked/unchecked
        }
    }

    private fun updateAdapter() {

        listOfPerson.add(Person(1, "Android","Sajid"))
        listOfPerson.add(Person(2, "DotNet","Ali"))
        listOfPerson.add(Person(3, "PHP","Suthar"))

        testAdapter.submitList(listOfPerson)

    }

}