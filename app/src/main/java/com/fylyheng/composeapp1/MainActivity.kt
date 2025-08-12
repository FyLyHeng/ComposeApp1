package com.fylyheng.composeapp1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.fylyheng.composeapp1.movie_app.data.movie.MovieRepository
import com.fylyheng.composeapp1.movie_app.screens.MovieScreen
import com.fylyheng.composeapp1.movie_app.view_model.MovieViewModel
import com.fylyheng.composeapp1.movie_app.view_model.MovieViewModelFactory
import com.fylyheng.composeapp1.note_app.screen.DisplayDialog
import com.fylyheng.composeapp1.note_app.view_model.NoteViewModel
import com.fylyheng.composeapp1.ui.theme.ComposeApp1Theme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


      /* Note_APP
        //Init Room DB
        val database = AppDatabase.getInstance(applicationContext)


        //init note repo
        val noteRepo = NoteRepository(database.appDao)


        //init note viewModel Factory
        val noteViewModelFactory = NoteViewModelFactory(noteRepo)

        //init note viewModel
        val noteViewModel = ViewModelProvider(this, noteViewModelFactory)[NoteViewModel::class.java]*/

        //BlogPost_APP
        //val blogPostViewModel : BlogPostViewModel by viewModels()


        //Movie_APP
        val movieRepository = MovieRepository(applicationContext)
        val movieRepositoryFactory = MovieViewModelFactory(movieRepository)
        val movieViewModel = ViewModelProvider(this,movieRepositoryFactory)[MovieViewModel::class.java]

        setContent {
            ComposeApp1Theme {
                /*Note_APP
                Scaffold (floatingActionButton = { MyFAB(noteViewModel) }) { padding ->

                    // noteViewModel.allNotes(): invoke a function in ViewModel that returns a LiveData<List<Note>>.
                    // observeAsState(emptyList()): This converts the LiveData into a Compose State, so it can automatically recompose the UI when the data changes.

                    // observeAsState() is a bridge between LiveData and Compose.
                    // emptyList() is the default value shown before LiveData emits a value.


                    // 👇 this line listens to LiveData
                    val notes by noteViewModel.allNotes().observeAsState(emptyList())


                    // ✅ this Composable gets recomposed when `notes` changes
                    DisplayNoteListItem(notes, padding)

                }*/


                //Blog_Post_APP
                /*Scaffold { innerPadding->
                    BlogPostScreen(blogPostViewModel, innerPadding)
                }*/


                Scaffold { innerPadding->
                    MovieScreen(movieViewModel, innerPadding)
                }
            }
        }
    }
}

@Composable
fun MyFAB(viewModel: NoteViewModel) {

    var showDialog by remember { mutableStateOf(false) }

    DisplayDialog(viewModel, showDialog) {
        showDialog = false
    }

    FloatingActionButton(
        onClick = { showDialog = true },
        containerColor = Color.Blue,
        contentColor = Color.White
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "Add Note"
        )
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeApp1Theme {
        Greeting("Android")
    }
}