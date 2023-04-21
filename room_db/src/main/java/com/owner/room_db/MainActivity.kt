package com.owner.room_db

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.owner.room_db.dao.UserDao
import com.owner.room_db.entity.User
import com.owner.room_db.utils.DbManager
import kotlinx.coroutines.runBlocking
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    var userDao: UserDao = DbManager.db.userDao()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()

        var db = DbManager.db
        var db1 = DbManager.db
        var db2 = DbManager.db
        var db3 = DbManager.db

        Log.e("onCreate: ", db.hashCode().toString())
        Log.e("onCreate: ", db1.hashCode().toString())
        Log.e("onCreate: ", db2.hashCode().toString())
        Log.e("onCreate: ", db3.hashCode().toString())

        insertAll()
        val queryAllUser = userDao.queryAllUser()
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
                Toast.makeText(this@MainActivity,"批量新增数据成功",Toast.LENGTH_SHORT).show()
            }
        }
    }
}