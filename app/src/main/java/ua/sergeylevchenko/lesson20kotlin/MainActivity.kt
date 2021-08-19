package ua.sergeylevchenko.lesson20kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import ua.sergeylevchenko.lesson20kotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }


    override fun onUserLeaveHint() {
        val toast = Toast.makeText(applicationContext, "Нажата кнопка HOME", Toast.LENGTH_SHORT)
        toast.show()
        super.onUserLeaveHint()

    }

    override fun onBackPressed() {
        AlertDialog.Builder(this).apply {
            setTitle("Подтверждение")
            setMessage("Вы уверены, что хотите выйти из программы?")

            setPositiveButton("Выйти") { _, _ ->
                super.onBackPressed()
                Toast.makeText(
                    this@MainActivity, "Вы проиграли кота",
                    Toast.LENGTH_LONG
                ).show()
            }

            setNegativeButton("Нет") { _, _ ->
                Toast.makeText(
                    this@MainActivity, "Правильный выбор",
                    Toast.LENGTH_LONG
                ).show()
            }
            setCancelable(true)
        }.create().show()

    }

}


