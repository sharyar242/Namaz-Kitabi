package uz.texnopos.namaz.ui.namaz

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_namaz_service.*
import uz.texnopos.namaz.R
import uz.texnopos.namaz.data.User

class NamazService: Fragment(R.layout.fragment_namaz_service){


    private val myAdapter = NamazAdapter()
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        rvServiceNamaz.adapter = myAdapter
        myAdapter.onItemClickedNamaz= { id, type ->
            val action = NamazServiceDirections.actionNavNamazToNamazFragment(id,type)
            navController.navigate(action)
        }
        setData()
    }

    private fun setData(){
        val params: MutableList<User> = mutableListOf()
        for (i in 1..17){
            when (i) {
                1 -> {
                    params.add(User("Намаз"))
                }
                2 -> {
                    params.add(User("Азан, азан дуўасы, тәкбир"))
                }
                3 -> {
                    params.add(User("Таң намаз"))
                }
                4 -> {
                    params.add(User("Песин намаз"))
                }
                5 -> {
                    params.add(User("Намазлыгер"))
                }
                6 -> {
                    params.add(User("Шам намаз"))
                }
                7 -> {
                    params.add(User("Қуптан ҳәм ўитр намазы"))
                }
                8 -> {
                    params.add(User("ТАҲИЯТУЛ МАСЖИД"))
                }
                9 -> {
                    params.add(User("ТӘҲӘЖЖУД НАМАЗЫ"))
                }
                10 -> {
                    params.add(User("ҲАЙЫТ НАМАЗЫ"))
                }
                11 -> {
                    params.add(User("ЖУМА НАМАЗЫ"))
                }
                12 -> {
                    params.add(User("ЖАНАЗА НАМАЗЫ"))
                }
                13 -> {
                    params.add(User("МҮСӘПИР АДАМНЫҢ НАМАЗЫ"))
                }
                14 -> {
                    params.add(User("ИМАМҒА ЕРИЎ"))
                }
                15 -> {
                    params.add(User("ҚАЗА НАМАЗ"))
                }
                16 -> {
                    params.add(User("Намаздан кейинги зикирлер"))
                }
                17 -> {
                    params.add(User("Намаз бузылатуғын жағдайлар"))
                }
                else -> {
                    params.add(User("Null"))
                }
            }

        }
        myAdapter.models = params
    }
}