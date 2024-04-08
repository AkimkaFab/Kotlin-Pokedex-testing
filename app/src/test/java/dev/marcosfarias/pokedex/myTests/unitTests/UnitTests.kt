//package dev.marcosfarias.pokedex.myTests.unitTests
//
//import android.content.Context
//import android.util.Log
//import androidx.room.Room
//import androidx.test.core.app.ApplicationProvider
////import androidx.test.ext.junit.rules.ActivityScenarioRule
////import androidx.test.ext.junit.runners.AndroidJUnit4
//
//import androidx.test.runner.AndroidJUnit4
//import dev.marcosfarias.pokedex.R
//import dev.marcosfarias.pokedex.database.AppDatabase
//import dev.marcosfarias.pokedex.database.dao.PokemonDAO
//import dev.marcosfarias.pokedex.model.Pokemon
//import dev.marcosfarias.pokedex.repository.PokemonService
//import io.mockk.every
//import io.mockk.mockkStatic
////import org.junit.jupiter.api.Test
//import org.junit.*
//import org.junit.runner.RunWith
//import org.koin.android.ext.koin.androidApplication
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.create
//import org.koin.dsl.module
//import java.io.IOException
//import java.util.logging.Logger
//
//
//
//class UnitTests {
//    val myRf = Retrofit.Builder()
//        .baseUrl("https://gist.githubusercontent.com/mrcsxsiq/b94dbe9ab67147b642baa9109ce16e44/raw/97811a5df2df7304b5bc4fbb9ee018a0339b8a38/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//
//    val myRoom = module {
//
//        single<AppDatabase> {
//            Room.databaseBuilder(
//                androidApplication(),
//                AppDatabase::class.java,
//                androidApplication().baseContext.getString(R.string.app_name)
//            ).build()
//        }
//        single {
//            get<AppDatabase>().pokemonDAO()
//        }
//    }
//
//    @Test
//    fun getAllPokemonsFromBack() {
//        val allPoks = myRf.create<PokemonService>().get().execute().body()
//        println("Ответ: $allPoks")
//
//        if (allPoks.toString().contains("[Pokemon(id=#001, abilities=[Overgrow], attack=30, base_exp=64, category=Seed," +
//                " cycles=20 , defense=20, egg_groups=Grass, Monster , evolutions=[#001, #002, #003]")) {
//            assert(true)
//        } else {
//            assert(false)
//        }
//    }
//}
//
//
//
//@RunWith(AndroidJUnit4::class)
//class DatabaseMockTest {
//
//    private lateinit var pokemonTestDao: PokemonDAO
//    private lateinit var db: AppDatabase
//
//
//
//    @Before
//    fun createDb() {
//
////        mockkStatic(android.util.Log::class)
////        every { android.util.Log.v(any(), any()) } returns 0
////        every { android.util.Log.d(any(), any()) } returns 0
////        every { android.util.Log.i(any(), any()) } returns 0
////        every { android.util.Log.e(any(), any()) } returns 0
//
//        val context = ApplicationProvider.getApplicationContext<Context>()
//        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
//        pokemonTestDao = db.pokemonDAO()
//
//    }
//
//    @After
//    @Throws(IOException::class)
//    fun closeDb() {
//        db.close()
//    }
//
//    @Test
//    @Throws(Exception::class)
//    fun addAndGetPokemons() {
//
//        val pokemon1 = Pokemon(
//            "#001", listOf("Big", "Cool boy"), 228, "80",
//            "Mom's pie", "10", 13, "Pies", listOf("#001", "#002", "#003"),
//            "", "33%", 0, "6' 66\"", 666,
//            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png", "67%",
//            "Mockerus", "Reason of tryaska?", 777, 69
//        )
//        pokemonTestDao.add(pokemon = listOf(pokemon1))
//        val getAllPoksMock = pokemonTestDao.all().toString()
//        println("ТВОИ ПОКЕМОНЫ: $getAllPoksMock")
//
//    }
//}