package fr.vannsuplabs.morpion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val case11 : ImageButton get() = findViewById(R.id.case1_1)
    private val case12 : ImageButton get() = findViewById(R.id.case1_2)
    private val case13 : ImageButton get() = findViewById(R.id.case1_3)
    private val case21 : ImageButton get() = findViewById(R.id.case2_1)
    private val case22 : ImageButton get() = findViewById(R.id.case2_2)
    private val case23 : ImageButton get() = findViewById(R.id.case2_3)
    private val case31 : ImageButton get() = findViewById(R.id.case3_1)
    private val case32 : ImageButton get() = findViewById(R.id.case3_2)
    private val case33 : ImageButton get() = findViewById(R.id.case3_3)
    // Not use private val textviewmorpion : TextView get() = findViewById(R.id.text_view_morpion)
    private val textViewMorpion2 : TextView get() = findViewById(R.id.text_view_morpion2)
    private val buttonReplay : Button get() = findViewById(R.id.button_replay)

    private var grille : Array<Case> = Array(9, init = {Case()})

    private var turn : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        case11.setOnClickListener{ play(case11, grille[0]) }
        case12.setOnClickListener{ play(case12, grille[1]) }
        case13.setOnClickListener{ play(case13, grille[2]) }

        case21.setOnClickListener{ play(case21, grille[3]) }
        case22.setOnClickListener{ play(case22, grille[4]) }
        case23.setOnClickListener{ play(case23, grille[5]) }

        case31.setOnClickListener{ play(case31, grille[6]) }
        case32.setOnClickListener{ play(case32, grille[7]) }
        case33.setOnClickListener{ play(case33, grille[8]) }

        buttonReplay.setOnClickListener { replay() }
    }

    private fun play(view : ImageButton, case : Case){
        if (turn) {
            view.setImageResource(R.drawable.ic_baseline_add)
            case.isCheckByCross = true
            textViewMorpion2.text = resources.getString(R.string.au_o)
        }
        else {
            view.setImageResource(R.drawable.ic_baseline_blur_circular)
            case.isCheckByCross = false
            textViewMorpion2.text = resources.getString(R.string.au_x)
        }
        turn = !turn
        checkWinGrille()
    }

    private fun checkWinGrille(){
        if(checkWinRow() != null)
            showWin(checkWinRow())

        if(checkWinColumn() != null)
            showWin(checkWinColumn())

        if(checkWinDiagonal() != null)
            showWin(checkWinDiagonal())
    }

    private fun checkWinRow() : Boolean?{
        if(grille[0].isCheckByCross == grille[1].isCheckByCross && grille[1].isCheckByCross == grille[2].isCheckByCross){
            return grille[0].isCheckByCross
        }
        if(grille[3].isCheckByCross == grille[4].isCheckByCross && grille[4].isCheckByCross == grille[5].isCheckByCross){
            return grille[3].isCheckByCross
        }
        if(grille[6].isCheckByCross == grille[7].isCheckByCross && grille[7].isCheckByCross == grille[8].isCheckByCross){
            return grille[6].isCheckByCross
        }
        return null
    }

    private fun checkWinColumn() : Boolean?{
        if(grille[0].isCheckByCross == grille[3].isCheckByCross && grille[3].isCheckByCross == grille[6].isCheckByCross){
            return grille[0].isCheckByCross
        }
        if(grille[1].isCheckByCross == grille[4].isCheckByCross && grille[4].isCheckByCross == grille[7].isCheckByCross){
            return grille[1].isCheckByCross
        }
        if(grille[2].isCheckByCross == grille[5].isCheckByCross && grille[5].isCheckByCross == grille[8].isCheckByCross){
            return grille[2].isCheckByCross
        }
        return null
    }

    private fun checkWinDiagonal(): Boolean?{
        if(grille[0].isCheckByCross == grille[4].isCheckByCross && grille[4].isCheckByCross == grille[8].isCheckByCross){
            return grille[0].isCheckByCross
        }
        if(grille[2].isCheckByCross == grille[4].isCheckByCross && grille[4].isCheckByCross == grille[6].isCheckByCross){
            return grille[2].isCheckByCross
        }
        return null
    }

    private fun showWin(isCheckByCross : Boolean?) {
        if(isCheckByCross!!)
            textViewMorpion2.text = resources.getString(R.string.win_x)
        else
            textViewMorpion2.text = resources.getString(R.string.win_o)
    }

    private fun replay(){
        grille = Array(9, init = {Case()})

        case11.setImageResource(0)
        case12.setImageResource(0)
        case13.setImageResource(0)
        case21.setImageResource(0)
        case22.setImageResource(0)
        case23.setImageResource(0)
        case31.setImageResource(0)
        case32.setImageResource(0)
        case33.setImageResource(0)
        textViewMorpion2.text = resources.getString(R.string.au_x)
    }

}