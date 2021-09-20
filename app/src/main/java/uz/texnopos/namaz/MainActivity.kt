package uz.texnopos.namaz

import android.os.Bundle
import android.view.Menu
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //    private lateinit var dataBaseFragment: AllFragment
    //    private lateinit var settings: Settings
    //    private lateinit var settingsFragment: SettingsFragment
    //    private lateinit var aboutFragment: AboutFragment
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //   settings = Settings(this)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_shahada, R.id.nav_paklik, R.id.nav_namaz, R.id.nav_sureler,
                R.id.nav_dualar, R.id.nav_40Parz, R.id.nav_About), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

//        setSupportActionBar(toolbar)
//        val actionBar = supportActionBar
//        actionBar?.title = "Navigation Drawer"
//        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
//            this,
//            drawer_layout,
//            toolbar,
//            (R.string.navigation_drawer_open),
//            (R.string.navigation_drawer_close)
//        ) {
//        }
//
//        drawerToggle.isDrawerIndicatorEnabled = true
//        drawer_layout.addDrawerListener(drawerToggle)
//        drawerToggle.syncState()
//
//        nav_view.setNavigationItemSelectedListener(this)
//
//
//        dataBaseFragment = AllFragment(10)
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.nav_host_fragment, dataBaseFragment)
//            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

//    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
//        when (menuItem.itemId) {
//            R.id.nav_paklik -> {
//                val fragment = AllFragment(1)
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.nav_host_fragment, fragment)
//                    .commit()
//            }
//            R.id.nav_dualar -> {
//                val fragment = AllFragment(8)
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.nav_host_fragment, fragment)
//                    .commit()
//            }
//            R.id.nav_imamgaEriw -> {
//                val fragment = AllFragment(6)
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.nav_host_fragment, fragment)
//                    .commit()
//            }
//            R.id.nav_janaza_namazi -> {
//                val fragment = AllFragment(5)
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.nav_host_fragment, fragment)
//                    .commit()
//            }
//            R.id.nav_namaz -> {
//                val fragment = NamazFragment()
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.nav_host_fragment, fragment)
//                    .commit()
//            }
//            R.id.nav_namaz_zikirler -> {
//                val fragment = AllFragment(3)
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.nav_host_fragment, fragment)
//                    .commit()
//            }
//            R.id.nav_namaz_buziladi -> {
//                val fragment = AllFragment(4)
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.nav_host_fragment, fragment)
//                    .commit()
//            }
//            R.id.nav_xayit_juma_namazi -> {
//                 val fragment = AllFragment(7)
//                 supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.nav_host_fragment, fragment)
//                    .commit()
//            }
//            R.id.nav_sureler -> {
//                val fragment = AllFragment(11)
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.nav_host_fragment, fragment)
//                    .commit()
//            }
//            R.id.nav_40Parz -> {
//                val fragment = AllFragment(9)
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.nav_host_fragment, fragment)
//                    .commit()
//            }
//            R.id.nav_shahada -> {
//                val fragment = AllFragment(10)
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.nav_host_fragment, fragment)
//                    .commit()
//            }
//            R.id.nav_setting -> {
//                settingsFragment =
//                    SettingsFragment()
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.nav_host_fragment,settingsFragment)
//                    .commit()
//            }
//            R.id.nav_About -> {
//                aboutFragment = AboutFragment()
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.nav_host_fragment,aboutFragment)
//                    .commit()
//            }
//            R.id.nav_qosimsha ->{
//                val fragment = Namaz()
//                supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.nav_host_fragment,fragment)
//                    .commit()
//            }
//        }
//        drawer_layout.closeDrawer(GravityCompat.START)
//        return true
//    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

//    private fun updateTheme() {
//        if (settings.isAppDarkMode()) {
//            setTheme(R.style.DarkTheme)
//        } else {
//            setTheme(R.style.LightTheme)
//        }
//    }
//
//    fun updateThemeAndRecreateActivity() {
//        updateTheme()
//        recreate()
//    }


}