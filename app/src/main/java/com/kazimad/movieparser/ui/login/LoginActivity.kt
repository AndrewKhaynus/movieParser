package com.kazimad.movieparser.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kazimad.movieparser.InterfaceActivity
import com.kazimad.movieparser.R
import com.kazimad.movieparser.ui.main.MainActivity
import com.kazimad.movieparser.utils.ActivityUtils

class LoginActivity : AppCompatActivity(), InterfaceActivity {
    private lateinit var viewModel: LoginActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewModel = ViewModelProviders.of(this).get(LoginActivityViewModel::class.java)
        viewModel.loginCheckerLiveData.observe(this, Observer<Boolean> { t -> checkUserLogin(t) })

        viewModel.checkIsUserLoginIn()

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        for (fragment in supportFragmentManager.fragments) {
            fragment.onActivityResult(requestCode, resultCode, data)
        }
        onUserLoggedIn()
    }

    override fun onUserLoggedIn() {
        viewModel.checkIsUserLoginIn()
    }

    private fun checkUserLogin(userLoggedIn: Boolean?) {
        userLoggedIn?.let {
            if (userLoggedIn) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                val loginFragment = LoginFragment()
                ActivityUtils.addFragmentToActivity(this, loginFragment)
            }
        }
    }
}