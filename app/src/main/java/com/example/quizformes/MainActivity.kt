package com.example.quizformes


import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

data class Question(
    val texte: String,
    val image: Int,
    val choix: Array<String>,
    val bonneReponse: Int,
    val description: String
)

class MainActivity : AppCompatActivity() {

    private val questions = arrayOf(
        Question(
            "Quelle est cette forme ?",
            R.drawable.triangle,
            arrayOf("Carré", "Triangle", "Cercle"),
            1,
            "Triangle"
        ),
        Question(
            "Combien de côtés possède cette forme ?",
            R.drawable.carre,
            arrayOf("Trois", "Quatre", "Cinq"),
            1,
            "Carré"
        ),
        Question(
            "Quelle forme est ronde ?",
            R.drawable.cercle,
            arrayOf("Rectangle", "Triangle", "Cercle"),
            2,
            "Cercle"
        ),
        Question(
            "Quelle forme possède cinq pointes ?",
            R.drawable.etoile,
            arrayOf("Étoile", "Carré", "Cercle"),
            0,
            "Étoile"
        ),
        Question(
            "Quelle forme possède quatre angles droits et deux côtés longs ?",
            R.drawable.rectangle,
            arrayOf("Cercle", "Rectangle", "Triangle"),
            1,
            "Rectangle"
        )
    )

    private var indice = 0
    private var score = 0
    private var repondu = false

    private lateinit var txtScore: TextView
    private lateinit var txtNumero: TextView
    private lateinit var txtQuestion: TextView
    private lateinit var txtFeedback: TextView
    private lateinit var txtResultat: TextView
    private lateinit var imgQuestion: ImageView
    private lateinit var progressQuiz: ProgressBar
    private lateinit var boutons: List<Button>
    private lateinit var btnSuivant: Button
    private lateinit var btnRejouer: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtScore = findViewById(R.id.txt_score)
        txtNumero = findViewById(R.id.txt_numero)
        txtQuestion = findViewById(R.id.txt_question)
        txtFeedback = findViewById(R.id.txt_feedback)
        txtResultat = findViewById(R.id.txt_resultat)
        imgQuestion = findViewById(R.id.img_question)
        progressQuiz = findViewById(R.id.progress_quiz)

        boutons = listOf(
            findViewById(R.id.btn_choix1),
            findViewById(R.id.btn_choix2),
            findViewById(R.id.btn_choix3)
        )

        btnSuivant = findViewById(R.id.btn_suivant)
        btnRejouer = findViewById(R.id.btn_rejouer)

        boutons.forEachIndexed { index, bouton ->
            bouton.setOnClickListener {
                verifierReponse(index)
            }
        }

        btnSuivant.setOnClickListener {
            if (indice < questions.size - 1) {
                indice++
                afficherQuestion()
            } else {
                afficherResultat()
            }
        }

        btnRejouer.setOnClickListener {
            recommencerQuiz()
        }

        afficherQuestion()
    }

    private fun afficherQuestion() {
        val question = questions[indice]

        txtNumero.text = "Question ${indice + 1} sur ${questions.size}"
        txtQuestion.text = question.texte
        imgQuestion.setImageResource(question.image)
        imgQuestion.contentDescription = question.description
        txtScore.text = "Score : $score/5"
        progressQuiz.progress = indice

        question.choix.forEachIndexed { index, choix ->
            boutons[index].text = choix
            boutons[index].isEnabled = true
            boutons[index].visibility = View.VISIBLE
        }

        txtFeedback.text = ""
        txtResultat.visibility = View.GONE
        btnSuivant.isEnabled = false
        btnSuivant.text = if (indice == questions.size - 1) {
            "Voir le résultat"
        } else {
            "Question suivante"
        }

        repondu = false
    }

    private fun verifierReponse(choix: Int) {
        if (repondu) return

        repondu = true
        val question = questions[indice]

        if (choix == question.bonneReponse) {
            score++
            txtFeedback.text = "Bonne réponse !"
            txtFeedback.setTextColor(android.graphics.Color.rgb(30, 140, 70))
        } else {
            txtFeedback.text =
                "Mauvaise réponse ! Réponse : ${question.choix[question.bonneReponse]}"
            txtFeedback.setTextColor(android.graphics.Color.RED)
        }

        txtScore.text = "Score : $score/5"
        progressQuiz.progress = indice + 1

        boutons.forEach {
            it.isEnabled = false
        }

        btnSuivant.isEnabled = true
    }

    private fun afficherResultat() {
        boutons.forEach {
            it.visibility = View.GONE
        }

        txtQuestion.visibility = View.GONE
        imgQuestion.visibility = View.GONE
        txtNumero.visibility = View.GONE
        txtFeedback.visibility = View.GONE
        btnSuivant.visibility = View.GONE

        txtResultat.text = "Quiz terminé !\nTon score : $score/5"
        txtResultat.visibility = View.VISIBLE
        btnRejouer.visibility = View.VISIBLE
        progressQuiz.progress = questions.size
    }

    private fun recommencerQuiz() {
        indice = 0
        score = 0

        boutons.forEach {
            it.visibility = View.VISIBLE
        }

        txtQuestion.visibility = View.VISIBLE
        imgQuestion.visibility = View.VISIBLE
        txtNumero.visibility = View.VISIBLE
        txtFeedback.visibility = View.VISIBLE
        btnSuivant.visibility = View.VISIBLE
        btnRejouer.visibility = View.GONE

        progressQuiz.progress = 0
        afficherQuestion()
    }
}
