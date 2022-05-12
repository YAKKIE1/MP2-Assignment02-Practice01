package za.ac.cput.mp2.assignment02.navigation

//This class allows only classes inside of this sealed class to inherit from this file.
sealed class Screen(val route: String){
    object WelcomeScreen: Screen("Welcome Screen")
    object AboutScreen: Screen("About Screen")
    object ModuleScreen: Screen("Module Screen")
}
