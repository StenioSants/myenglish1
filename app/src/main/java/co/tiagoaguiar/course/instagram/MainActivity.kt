package co.tiagoaguiar.course.instagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {


  private lateinit var btnLoguin : Button
  private lateinit var registerNewUser : TextView
  private lateinit var rememberPassword : TextView

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    btnLoguin = findViewById(R.id.btn_loguin_main)
    btnLoguin.setOnClickListener {
      val i = Intent(this, ItemMain::class.java )
      startActivity(i)
    }

    registerNewUser = findViewById(R.id.txt_resgister_main)
    registerNewUser.setOnClickListener {
      val i = Intent(this, registerNewUsers::class.java)
      startActivity(i)
    }

    rememberPassword = findViewById(R.id.txt_remember_main)
    rememberPassword.setOnClickListener {
      val i = Intent(this, RememberPassword::class.java)
      startActivity(i)
    }
  }
}