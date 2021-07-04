package uz.texnopos.namaz.ui.paklik

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_service.*
import uz.texnopos.namaz.R
import uz.texnopos.namaz.data.User

class PaklikService(): Fragment(R.layout.fragment_service) {

    private val myAdapter = PaklikAdapter()
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        rvService.adapter = myAdapter
        myAdapter.onItemClicked = { id ->
           val action = PaklikServiceDirections.actionNavPaklikToPaklikFragment(id)
                   navController.navigate(action)
        }
        setData()
    }

    private fun setData(){
        val params: MutableList<User> = mutableListOf()
        for (i in 1..3){
            when (i) {
                1 -> {
                    params.add(User("Таҳәрат"))
                }
                2 -> {
                    params.add(User("Таяммум"))
                }
                3 -> {
                    params.add(User("Ғусыл"))
                }
                else -> {
                    params.add(User("Null"))
                }
            }

        }
        myAdapter.models = params
    }


}