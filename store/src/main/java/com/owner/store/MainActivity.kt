package com.owner.store

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import com.owner.store.base.BaseViewBindingActivity
import com.owner.store.data.PersonSerializer
import com.owner.store.data.UserPreferencesSerializer
import com.owner.store.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class MainActivity : BaseViewBindingActivity<ActivityMainBinding>(), View.OnClickListener {
    //创建 DataStore
    val Context.personDataStore: DataStore<PersonPreferences> by dataStore(
        fileName = "PersonPreferences.pb",
        serializer = PersonSerializer
    )
    val Context.userDataStore: DataStore<UserPreferences> by dataStore(
        fileName = "UserPreferences.pb",
        serializer = UserPreferencesSerializer
    )


    override fun initBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding.add.setOnClickListener(this)
        mBinding.update.setOnClickListener(this)
        mBinding.show.setOnClickListener(this)
        mBinding.clear.setOnClickListener(this)
        mBinding.protoAdd.setOnClickListener(this)
        mBinding.protoShow.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.add -> {
                runBlocking {
                    FlyDataStore.putData("name", "张三")
                }
            }
            R.id.update -> {
                FlyDataStore.putData("name", "李四")

            }
            R.id.show -> {
                mBinding.content.text = FlyDataStore.getData("name", "测试")
            }

            R.id.clear -> {
                FlyDataStore.clearData()
            }
            R.id.proto_add -> {
                runBlocking {
                    //更新
                    userDataStore.updateData {
                        it.toBuilder().setName("张三").setAge(16).setSex(1).setWeight(65.0f)
                            .setTall(175.0f)
                            .build()
                    }

                }
                /*    runBlocking {
                        personDataStore.updateData {
                            it.toBuilder().setName("测试proto").setAge(50).build()
                        }
                    }*/
            }
            R.id.proto_show -> {
                runBlocking {
                    val person = personDataStore.data.first()
                    //读取
                    val userUpdate = userDataStore.data.first()
//                       mBinding.content.text = "name: ${person.name} , age: ${person.age}"
                    mBinding.content.text =
                        "name: ${person.name} , age: ${person.age}" + "\n" + "name: ${userUpdate.name} , " +
                                "age: ${userUpdate.age}，" +
                                "weight：${userUpdate.weight}，" +
                                "tall：${userUpdate.tall}，" +
                                "sex：${userUpdate.sex}"
                }
            }
        }
    }
}