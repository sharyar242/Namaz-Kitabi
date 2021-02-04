package uz.texnopos.namaz

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import uz.texnopos.namaz.ui.about.AboutFragment
import uz.texnopos.namaz.ui.allDataBase.AllFragment
import uz.texnopos.namaz.ui.namaz.NamazFragment
import uz.texnopos.namaz.ui.settings.SettingsFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var dataBaseFragment: AllFragment
    private lateinit var settings: Settings
    private lateinit var settingsFragment: SettingsFragment
    private lateinit var aboutFragment: AboutFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        settings = Settings(this)

        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title = "Navigation Drawer"

        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            (R.string.navigation_drawer_open),
            (R.string.navigation_drawer_close)
        ) {
        }

        drawerToggle.isDrawerIndicatorEnabled = true
        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)


        dataBaseFragment = AllFragment(10)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav_host_fragment, dataBaseFragment)
            .commit()
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.nav_paklik -> {
                val fragment = AllFragment(1)
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit()
            }
            R.id.nav_dualar -> {
                val fragment = AllFragment(8)
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit()
            }
            R.id.nav_imamgaEriw -> {
                val fragment = AllFragment(6)
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit()
            }
            R.id.nav_janaza_namazi -> {
                val fragment = AllFragment(5)
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit()
            }
            R.id.nav_namaz -> {
                val fragment = NamazFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit()
            }
            R.id.nav_namaz_zikirler -> {
                val fragment = AllFragment(3)
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit()
            }
            R.id.nav_namaz_buziladi -> {
                val fragment = AllFragment(4)
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit()
            }
            R.id.nav_xayit_juma_namazi -> {
                 val fragment = AllFragment(7)
                 supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit()
            }
            R.id.nav_sureler -> {
                val fragment = AllFragment(11)
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit()
            }
            R.id.nav_40Parz -> {
                val fragment = AllFragment(9)
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit()
            }
            R.id.nav_shahada -> {
                val fragment = AllFragment(10)
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment, fragment)
                    .commit()
            }
            R.id.nav_setting -> {
                settingsFragment =
                    SettingsFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment,settingsFragment)
                    .commit()
            }
            R.id.nav_About -> {
                aboutFragment = AboutFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.nav_host_fragment,aboutFragment)
                    .commit()
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    private fun updateTheme() {
        if (settings.isAppDarkMode()) {
            setTheme(R.style.DarkTheme)
        } else {
            setTheme(R.style.LightTheme)
        }
    }

    fun updateThemeAndRecreateActivity() {
        updateTheme()
        recreate()
    }


}