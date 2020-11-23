package com.cengiztoru.samplenavigationexample.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.cengiztoru.samplenavigationexample.R
import com.cengiztoru.samplenavigationexample.data.User
import kotlin.random.Random

class SplashFragment : Fragment() {

    lateinit var navController: NavController

    //initalize Navigation Controller
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        checkUserThanGoNextScreen()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun checkUserThanGoNextScreen() {
        when (isUserLogged()) {
            false -> {
                navController.navigate(R.id.action_splashFragment_to_loginFragment)
            }
            true -> {
                //PASS DATA WITHOUT SAFE ARGS, PASS DATA BY SIMPLE BUNDLE
                val bundle = Bundle()
                bundle.putParcelable("user", getUserData())
                navController.navigate(R.id.action_splashFragment_to_homeFragment, bundle)

            }
        }
    }

    //if result of mode random number to 2 is 0 funtion will return true else return false
    //TODO YOU CAN CUSTOMIZE HERE FOR YOU
    private fun isUserLogged() = Random.nextInt() % 2 == 0


    //TODO YOU CAN CUSTOMIZE HERE FOR YOU
    private fun getUserData(): User = User("fathnabilah@gmail.com", "nabilah", "fath")

}