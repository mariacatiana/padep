package br.com.jpegsinng.padep.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import br.com.jpegsinng.padep.R
import br.com.jpegsinng.padep.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHostFragment.navController

        // Configurar a AppBarConfiguration
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.activitiesFragment
            )
        )

        // Configurar a Toolbar como ActionBar
        setSupportActionBar(binding.toolbarApp)

        // Configurar a ActionBar com o NavController
        setupActionBarWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->

            when (destination.id) {
                R.id.registerFragment -> {
                    supportActionBar?.show()
                    binding.bottomNavMain.visibility = View.VISIBLE
                }
                R.id.activitiesFragment -> {
                    supportActionBar?.show()
                    binding.bottomNavMain.visibility = View.VISIBLE
                }
                R.id.homeFragment -> {
                    supportActionBar?.show()
                    binding.bottomNavMain.visibility = View.VISIBLE
                }
                R.id.loginFragment -> {
                    supportActionBar?.hide()
                    binding.bottomNavMain.visibility = View.GONE
                }
                else -> {
                    supportActionBar?.show()
                    binding.bottomNavMain.visibility = View.VISIBLE
                }
            }
        }

        // Configure a BottomNavigationView com o NavController
        binding.bottomNavMain.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}