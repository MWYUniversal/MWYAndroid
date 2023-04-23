package com.owner.room_db

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.owner.room_db.dao.CarDao
import com.owner.room_db.dao.PersonDao
import com.owner.room_db.dao.UserDao
import com.owner.room_db.databinding.ActivityMainBinding
import com.owner.room_db.entity.Car
import com.owner.room_db.entity.Person
import com.owner.room_db.entity.User
import com.owner.room_db.utils.DbManager
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var userDao: UserDao = DbManager.db.userDao()
    private var carDao: CarDao = DbManager.db.carDao()
    private var personDao: PersonDao = DbManager.db.personDao()
    private lateinit var mBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(mBinding.root)


        insertAll()
        mBinding.insert.setOnClickListener(this)
        mBinding.delete.setOnClickListener(this)
        mBinding.update.setOnClickListener(this)
        mBinding.query.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.insert -> {
                insertSingle()
            }
            R.id.delete -> {
                delete()
            }
            R.id.update -> {
                carDao.insert(Car("11", "22"))
                personDao.insert(Person("11", 22,180.12))
            }
            R.id.query -> {
                query()
            }
            else -> {}
        }
    }


    /**
     * 查询
     */
    private fun query() {
        val queryAllUser = userDao.queryAllUser()
        mBinding.text.text = queryAllUser.size.toString()
    }

    /**
     * 插入单条数据
     */
    private fun insertSingle() {
        val age = Random.nextInt(20, 40)
        val user = User("小二", age, "贵阳市观山湖区", "")
        userDao.addUser(user)
    }

    /**
     * 默认插入批量数据
     */
    private fun insertAll() {
        runBlocking {
            if (userDao.queryAllUser().size == 0) {
                val mutableList: MutableList<User> = mutableListOf()
                for (a in 1..3) {
                    val user = User("张三$a", 20 + a, "贵阳市观山湖区$a", "")
                    mutableList.add(user)
                }
                userDao.addBatchUser(mutableList)
                Toast.makeText(this@MainActivity, "批量新增数据成功", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * 删除表里的所有数据
     */
    private fun delete() {
        userDao.deleteAllUser()
        Toast.makeText(this@MainActivity, "删除所有数据成功", Toast.LENGTH_SHORT).show()
    }
}