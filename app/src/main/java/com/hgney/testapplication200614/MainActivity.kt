package com.hgney.testapplication200614

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_FOR_NICK = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeNickBtn.setOnClickListener {
            val myIntent = Intent(this, EditNickNameActivity::class.java)
            startActivityForResult(myIntent, REQ_FOR_NICK)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_FOR_NICK) {
            if (resultCode == Activity.RESULT_OK) {
                val nickName = data?.getStringExtra("nick")

                nickNameText.text = nickName

                Toast.makeText(this, "닉네임 변경 완료.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}